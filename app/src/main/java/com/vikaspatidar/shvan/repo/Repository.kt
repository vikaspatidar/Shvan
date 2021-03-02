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
package com.vikaspatidar.shvan.repo

import com.vikaspatidar.shvan.R
import com.vikaspatidar.shvan.model.Gender
import com.vikaspatidar.shvan.model.Pet

class Repository {
    private val pets = listOf(
        Pet(
            id = 0,
            name = "Bowie",
            gender = Gender.MALE,
            age = "4 years",
            breed = "Affenpinscher",
            photo = R.drawable.bowie,
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
            adopted = false,
            url = "https://www.petfinder.com/dog/bowie-50597009/gu/mangilao/guam-animals-in-need-gu01/"
        ),
        Pet(
            id = 1,
            name = "Mina",
            gender = Gender.FEMALE,
            age = "3 years",
            breed = "Pit Bull Terrier",
            photo = R.drawable.mina,
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
            adopted = false
        ),
        Pet(
            id = 2,
            name = "Brownie",
            gender = Gender.MALE,
            age = "2 year",
            breed = "Affenpinscher",
            photo = R.drawable.brownie,
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
            adopted = false,
            url = "https://www.petfinder.com/dog/brownie-50290982/gu/mangilao/guam-animals-in-need-gu01/"
        ),
        Pet(
            id = 3,
            name = "Buster",
            gender = Gender.MALE,
            age = "5 years",
            breed = "Pit Bull Terrier",
            photo = R.drawable.buster,
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
            adopted = false,
            url = "https://www.petfinder.com/dog/buster-45818179/gu/mangilao/guam-animals-in-need-gu01/"
        ),
        Pet(
            id = 4,
            name = "Dessa",
            gender = Gender.FEMALE,
            age = "1 year",
            breed = "Affenpinscher",
            photo = R.drawable.dessa,
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
            adopted = false,
            url = "https://www.petfinder.com/dog/dessa-50677203/gu/mangilao/guam-animals-in-need-gu01/"
        ),
        Pet(
            id = 5,
            name = "Chomper",
            gender = Gender.MALE,
            age = "6 years",
            breed = "Affenpinscher",
            photo = R.drawable.chomper,
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
            adopted = false,
            url = "https://www.petfinder.com/dog/chomper-50586553/gu/mangilao/guam-animals-in-need-gu01/"
        )
    )

    fun loadPets(): List<Pet> {
        return pets
    }
}