package com.example.appcount.viewmodel

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : ViewModel() {

    private val key = "value"

    fun getValue(): Int {
        return sharedPreferences.getInt(key, 0)
    }

    fun incrementValue() {
        val currentValue = getValue()
        val newValue = currentValue + 1
        with(sharedPreferences.edit()) {
            putInt(key, newValue)
            apply()
        }
    }
}