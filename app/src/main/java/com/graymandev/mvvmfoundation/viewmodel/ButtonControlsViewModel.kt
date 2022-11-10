package com.graymandev.mvvmfoundation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ButtonControlsViewModel @Inject constructor() : ViewModel() {
    fun printText(s: String) {
        Log.i("VIEWMODEL", "IT WORKS")
        println(s)
    }
}