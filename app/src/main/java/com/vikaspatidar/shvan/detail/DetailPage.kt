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
package com.vikaspatidar.shvan.detail

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.annotation.StringRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.vikaspatidar.shvan.R
import com.vikaspatidar.shvan.model.Gender
import com.vikaspatidar.shvan.model.Pet

@Composable
fun DetailPage(
    pet: Pet,
    onBackPressed: () -> Unit
) {
    val scrollState = rememberScrollState()
    val bottomPadding = 78.dp
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.primary,
                elevation = 1.dp
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        modifier = Modifier
                            .padding(16.dp)
                            .clickable {
                                onBackPressed()
                            },
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = stringResource(id = R.string.content_desc_back),
                        tint = MaterialTheme.colors.onPrimary
                    )
                    Text(
                        text = pet.name,
                        modifier = Modifier.padding(8.dp),
                        style = MaterialTheme.typography.h6,
                    )
                }
            }
        },
        content = {
            Box(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier
                        .verticalScroll(scrollState)
                        .padding(bottom = bottomPadding)
                        .fillMaxSize()
                ) {
                    Image(
                        painter = painterResource(pet.photo),
                        contentDescription = pet.name,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(0.dp)
                            .height(260.dp)
                            .fillMaxWidth()
                            .clip(shape = RoundedCornerShape(0.dp, 0.dp, 16.dp, 16.dp)),
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        val gender = stringResource(
                            genderStringId(
                                pet.gender
                            )
                        )
                        AttributeBox(gender, R.string.title_gender)
                        Spacer(modifier = Modifier.width(36.dp))
                        AttributeBox(pet.age, R.string.title_age)
                        Spacer(modifier = Modifier.width(36.dp))
                        AttributeBox(pet.breed, R.string.title_breed)
                    }
                    Text(
                        text = pet.description,
                        modifier = Modifier.padding(8.dp),
                        style = MaterialTheme.typography.body2,
                    )
                }
            }
        },
        floatingActionButton = {
            val context = LocalContext.current
            ExtendedFloatingActionButton(
                text = {
                    Text(stringResource(R.string.button_adopt_me))
                },
                onClick = {
                    context.openUrl(pet.url)
                },
                icon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_outline_paw_24),
                        contentDescription = stringResource(R.string.content_desc_adopt),
                    )
                }
            )
        },
        floatingActionButtonPosition = FabPosition.End,
        isFloatingActionButtonDocked = true,
        bottomBar = {
            BottomBar(pet)
        },
    )
}

@Composable
fun AttributeBox(
    attribute: String,
    @StringRes resId: Int
) {
    Surface(
        color = MaterialTheme.colors.primary.copy(alpha = 0.1F),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .defaultMinSize(minWidth = 76.dp)
            .border(
                1.dp,
                MaterialTheme.colors.primary.copy(alpha = 0.7F),
                RoundedCornerShape(8.dp)
            ),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(4.dp)
        ) {
            Text(
                text = stringResource(id = resId),
                modifier = Modifier.padding(4.dp),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.body1,
            )

            Text(
                text = attribute,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(4.dp),
                style = MaterialTheme.typography.body2,
            )
        }
    }
}

@StringRes
private fun genderStringId(gender: Gender): Int {
    return when (gender) {
        Gender.MALE -> R.string.gender_male
        else -> R.string.gender_female
    }
}

private fun Context.openUrl(url: String) {
    try {
        startActivity(
            Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(url)
            }
        )
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

