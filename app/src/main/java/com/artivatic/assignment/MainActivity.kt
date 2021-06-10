package com.artivatic.assignment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.artivatic.assignment.adapter.MainAdapter
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

        // Setup viewModel
        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(DataApi(RetrofitInstance.service))
        )[MainViewModel::class.java]

        // Setup UI
        val adapter = MainAdapter(arrayListOf())
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(
                DividerItemDecoration(
                    context,
                    (layoutManager as LinearLayoutManager).orientation
                )
            )
            this.adapter = adapter
        }

        // Setup observer
        viewModel.getData().observe(this, {
            it.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        binding.recyclerView.visibility = View.VISIBLE
                        binding.progressBar.visibility = View.GONE
                        resource.data.let { data ->
                            adapter.apply {
                                val rows = data?.rows?.filter { row ->
                                    row.title != null
                                }
                                setRows(rows!!)
                                notifyDataSetChanged()
                            }
                        }
                    }
                    Status.ERROR -> {
                        binding.recyclerView.visibility = View.VISIBLE
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        binding.progressBar.visibility = View.VISIBLE
                        binding.recyclerView.visibility = View.GONE
                    }
                }
            }
        })
    }
}