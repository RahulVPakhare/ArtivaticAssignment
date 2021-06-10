package com.artivatic.assignment.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.artivatic.assignment.repo.DataRepository
import com.artivatic.assignment.util.Resource
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val dataRepository: DataRepository) : ViewModel() {

    fun getData() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = dataRepository.getData()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}