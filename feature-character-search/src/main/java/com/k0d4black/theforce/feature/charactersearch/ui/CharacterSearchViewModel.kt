/**
 *
 * Copyright 2020 David Odari
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *          http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 **/
package com.k0d4black.theforce.feature.charactersearch.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.k0d4black.theforce.feature.charactersearch.model.SearchViewState
import com.k0d4black.theforce.local.features.recentsearch.data.RecentSearchRepository

internal class CharacterSearchViewModel(
    recentSearchRepository: RecentSearchRepository
) : ViewModel() {

    private val _searchViewState = MutableLiveData<SearchViewState>()
    val searchViewState: LiveData<SearchViewState>
        get() = _searchViewState

    init {
        recentSearchRepository.getRecentSearch()
    }

    fun onSearchQueryFormClicked() {
        // TODO Navigate to Search Results
    }
}
