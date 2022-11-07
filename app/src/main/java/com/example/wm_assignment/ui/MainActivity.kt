package com.example.wm_assignment.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import com.example.wm_assignment.R

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getCountries().observe(this) { countries ->
            AlertDialog.Builder(this).setMessage("Countries \n$countries").create().show()
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.loadCountries()
    }
}