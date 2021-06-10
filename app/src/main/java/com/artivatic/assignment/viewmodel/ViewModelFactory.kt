package com.artivatic.assignment.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.artivatic.assignment.api.DataApi
import com.artivatic.assignment.repo.DataRepository

class ViewModelFactory(private val dataApi: DataApi) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(DataRepository(dataApi)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}