package com.artivatic.assignment.viewmodel

import androidx.lifecycle.ViewModel
import com.artivatic.assignment.repo.DataRepository

class MainViewModel : ViewModel() {
    private val dataRepository = DataRepository()

    fun fetchData() {

    }
}