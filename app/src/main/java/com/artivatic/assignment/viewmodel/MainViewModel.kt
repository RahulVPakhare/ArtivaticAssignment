package com.artivatic.assignment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artivatic.assignment.model.Data
import com.artivatic.assignment.repo.DataRepository
import com.artivatic.assignment.repo.ManualParsingImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {
    private val dataRepository = DataRepository(ManualParsingImpl())
    val responseLiveData = MutableLiveData<Data>()

    fun fetchData() {
        viewModelScope.launch {
            val data = withContext(Dispatchers.IO) {
                dataRepository.getData()
            }
            responseLiveData.value = data
        }
    }
}