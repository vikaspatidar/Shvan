/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.vikaspatidar.shvan

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.vikaspatidar.shvan.detail.DetailPage
import com.vikaspatidar.shvan.home.HomePage
import com.vikaspatidar.shvan.home.PetViewModel
import com.vikaspatidar.shvan.ui.theme.ShvanTheme

private const val HOME_PAGE = "home_page"
private const val DETAIL_PAGE = "detail_page"

private const val ARG_PET_ID = "pet_id"

class MainActivity : AppCompatActivity() {

    private val viewModel: PetViewModel by viewModels()

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShvanTheme {
                ShvanNavHost()
            }
        }
    }

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun ShvanNavHost() {
        val navController = rememberNavController()
        NavHost(navController, startDestination = HOME_PAGE) {
            composable(HOME_PAGE) {
                HomePage(viewModel) { id ->
                    navController.navigate("$DETAIL_PAGE/$id")
                }
            }
            composable("$DETAIL_PAGE/{$ARG_PET_ID}") {
                val petId = it.arguments?.getString(ARG_PET_ID)!!.toInt()
                viewModel.pet(petId)?.let { pet ->
                    DetailPage(pet) {
                        navController.popBackStack()
                    }
                }
            }
        }
    }
}