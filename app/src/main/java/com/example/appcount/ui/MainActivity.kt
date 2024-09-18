package com.example.appcount.ui

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.appcount.R
import com.example.appcount.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var valueTextView: TextView
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        valueTextView = findViewById(R.id.valueTextView)

        viewModel.incrementValue()
        val newValue = viewModel.getValue()
        valueTextView.text = newValue.toString()
    }
}