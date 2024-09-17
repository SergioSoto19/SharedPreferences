package com.example.appcount

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {

    private lateinit var valueTextView: TextView
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        valueTextView = findViewById(R.id.valueTextView)
        sharedPreferences = getSharedPreferences("app_count", MODE_PRIVATE)

        val currentValue = sharedPreferences.getInt("value", 0)

        val newValue = currentValue + 1

        with(sharedPreferences.edit()) {
            putInt("value", newValue)
            apply()
        }

        valueTextView.text = newValue.toString()
    }
}