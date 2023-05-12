package com.zogik.feature.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zogik.core.domain.entity.SearchEntity
import com.zogik.core.utils.Resource
import com.zogik.feature.domain.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val useCase: UseCase) : ViewModel() {

    private val _search: MutableLiveData<Resource<List<SearchEntity>>> = MutableLiveData()
    val search: LiveData<Resource<List<SearchEntity>>> = _search

    fun search(key: Map<String, List<String>>) {
        viewModelScope.launch {
            useCase.search(key).collectLatest {
                _search.value = it
                Log.d("searchVM", it.data.toString())
            }
        }
    }
}
