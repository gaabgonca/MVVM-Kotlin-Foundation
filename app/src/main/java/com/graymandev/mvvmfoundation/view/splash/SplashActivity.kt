package com.graymandev.mvvmfoundation.view.splash

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.animation.Animation
import android.widget.TextView
import com.chetantuteja.easybinding.BindingActivity
import com.google.android.material.animation.AnimationUtils
import com.graymandev.mvvmfoundation.R
import com.graymandev.mvvmfoundation.databinding.ActivitySplashBinding
import com.graymandev.mvvmfoundation.view.intro.IntroActivity

class SplashActivity : BindingActivity<ActivitySplashBinding>() {

    //private var binding : ActivitySplashBinding? = null

    override fun setupViewBinding(inflater: LayoutInflater): ActivitySplashBinding{
        return ActivitySplashBinding.inflate(inflater)
    }

    override fun init(){
        val typeFace: Typeface = Typeface.createFromAsset(assets,"cookie regular.ttf")

        binding.tvAppName.typeface = typeFace

        // Here we will launch the Intro Screen after the splash screen using the handler.
        // As using handler the splash screen will disappear after what we give to the handler.
        // Adding the handler to after the a task after some delay.
        Handler(Looper.getMainLooper()).postDelayed(
            {
                // If the user is signed in once and not signed out again from the app. So next time while coming into the app
                // we will redirect him to MainScreen or else to the Intro Screen as it was before.

                // Get the current user id
                //val currentUserID = FirestoreClass().getCurrentUserID()

                /*
                if (currentUserID.isNotEmpty()) {
                    // Start the Main Activity
                    startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                } else {
                    // Start the Intro Activity
                    startActivity(Intent(this@SplashActivity, IntroActivity::class.java))
                }
                 */

                startActivity(Intent(this@SplashActivity, IntroActivity::class.java))

                // Call this when your activity is done and should be closed.
                finish()
            },
            3000) // Here we pass the delay time in milliSeconds after which the splash activity will disappear.
    }

}