package com.artivatic.assignment.viewmodel

import androidx.lifecycle.ViewModel
import com.artivatic.assignment.model.Data
import com.artivatic.assignment.repo.DataRepository
import com.artivatic.assignment.repo.ManualParsingImpl

class MainViewModel : ViewModel() {
    private val dataRepository = DataRepository(ManualParsingImpl())

    fun fetchData(): Data {
        return dataRepository.getData()
    }
}