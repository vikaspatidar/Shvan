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
package com.vikaspatidar.shvan.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.vikaspatidar.shvan.R

@ExperimentalFoundationApi
@Composable
fun HomePage(
    viewModel: PetViewModel,
    onPetSelected: (id: Int) -> Unit
) {
    Scaffold(
        topBar = {
            Toolbar()
        },
        content = {
            viewModel.liveData.observeAsState(
                emptyList()
            ).value?.let { pets ->
                PetsGrid(
                    pets,
                    onPetSelected
                )
            }
        }
    )
}

@Composable
fun Toolbar() {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.primary,
        elevation = 1.dp
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_pet_24),
                contentDescription = null,
                modifier = Modifier.padding(16.dp),
            )
            Text(
                text = stringResource(id = R.string.app_name),
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.h6,
            )
        }
    }
}



