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

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vikaspatidar.shvan.model.Pet
import com.vikaspatidar.shvan.repo.Repository

class PetViewModel : ViewModel() {

    private val repository: Repository = Repository()

    private val _liveData = MutableLiveData<List<Pet>>()

    val liveData = _liveData as LiveData<List<Pet>>

    init {
        _liveData.value = repository.loadPets()
    }

    fun pet(id: Int): Pet? {
        return _liveData.value?.find { it.id == id }
    }
}
