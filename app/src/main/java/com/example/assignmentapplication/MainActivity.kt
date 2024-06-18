package com.example.assignmentapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.assignmentapplication.adapter.CustomerAdapter
import com.example.assignmentapplication.databinding.ActivityMainBinding
import com.example.assignmentapplication.viewmodel.CustomerViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val viewModel = ViewModelProvider(this).get(CustomerViewModel::class.java)

        viewModel.getCustomerList(1,10,787)

        viewModel.customerList.observe(this, Observer {
            when(it){
                is Resource.Success ->{
                    val customerAdapter=CustomerAdapter(it.data)
                    binding.recyclerView.adapter=customerAdapter
                    binding.progressBar.visibility= View.GONE
                    binding.recyclerView.visibility=View.VISIBLE
                }

                is Resource.Error -> {


                }
                is Resource.Failure -> {


                }
               is Resource.Loading -> {

                }
            }
        })

    }
}