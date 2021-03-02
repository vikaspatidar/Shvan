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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vikaspatidar.shvan.R
import com.vikaspatidar.shvan.model.Pet

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PetsGrid(pets: List<Pet>, onPetSelected: (id: Int) -> Unit) {
    Spacer(modifier = Modifier.height(16.dp))
    when {
        pets.isEmpty() -> EmptyPage(id = R.string.no_data_available)
        else -> {
            Column {
                Spacer(modifier = Modifier.height(8.dp))
                LazyVerticalGrid(
                    cells = GridCells.Adaptive(
                        minSize = 180.dp
                    )
                ) {
                    items(pets) { pet ->
                        PetItem(pet) {
                            onPetSelected(pet.id)
                        }
                    }
                }
            }
        }
    }
}