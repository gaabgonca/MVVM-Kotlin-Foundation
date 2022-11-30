package com.graymandev.mvvmfoundation.view.intro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.graymandev.mvvmfoundation.databinding.ActivityIntroBinding
import com.graymandev.mvvmfoundation.databinding.ActivitySplashBinding

class IntroActivity : AppCompatActivity() {

    private var binding : ActivityIntroBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding?.root)

    }
}