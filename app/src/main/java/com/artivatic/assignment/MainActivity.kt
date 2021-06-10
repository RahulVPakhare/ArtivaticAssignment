package com.artivatic.assignment

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.artivatic.assignment.api.DataApi
import com.artivatic.assignment.api.RetrofitInstance
import com.artivatic.assignment.databinding.ActivityMainBinding
import com.artivatic.assignment.util.Status
import com.artivatic.assignment.viewmodel.MainViewModel
import com.artivatic.assignment.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {

    // View Binding
    private lateinit var binding: ActivityMainBinding

    // View Model
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(DataApi(RetrofitInstance.service))
        )[MainViewModel::class.java]

        viewModel.getData().observe(this, {
            it.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        resource.data.let { response ->
                            binding.tvHello.text = response?.title ?: "Some Title"
                        }
                    }
                    Status.ERROR -> {
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {

                    }
                }
            }
        })
    }
}