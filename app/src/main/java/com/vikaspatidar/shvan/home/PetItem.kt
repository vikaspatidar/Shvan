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

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.vikaspatidar.shvan.R
import com.vikaspatidar.shvan.model.Gender
import com.vikaspatidar.shvan.model.Pet
import com.vikaspatidar.shvan.ui.theme.Cyan200
import com.vikaspatidar.shvan.ui.theme.Pink200

@Composable
fun PetItem(pet: Pet, onPetSelected: (id: Int) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Card(
            modifier = Modifier.clickable {
                onPetSelected(pet.id)
            },
            shape = RoundedCornerShape(8.dp),
            elevation = 2.dp,
        ) {
            Column {
                Image(
                    painter = painterResource(pet.photo),
                    contentDescription = pet.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(0.dp)
                        .height(180.dp)
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(8.dp, 8.dp, 0.dp, 0.dp)),
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = pet.name,
                        modifier = Modifier.padding(8.dp),
                        style = MaterialTheme.typography.body1,
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 8.dp, end = 8.dp),
                        contentAlignment = Alignment.CenterEnd,
                    ) {
                        val contentDescId: Int
                        val iconId: Int
                        val iconTint: Color
                        when (pet.gender) {
                            Gender.MALE -> {
                                iconTint = Cyan200
                                iconId = R.drawable.ic_baseline_male_24
                                contentDescId = R.string.content_desc_male
                            }
                            else -> {
                                iconTint = Pink200
                                iconId = R.drawable.ic_baseline_female_24
                                contentDescId = R.string.content_desc_female
                            }
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                painter = painterResource(id = iconId),
                                contentDescription = stringResource(contentDescId),
                                modifier = Modifier.padding(8.dp),
                                tint = iconTint
                            )
                        }
                    }
                }
            }
        }
    }
}