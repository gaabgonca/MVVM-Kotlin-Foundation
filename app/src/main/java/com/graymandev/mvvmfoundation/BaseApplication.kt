package com.graymandev.mvvmfoundation

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//This class is instantiated before anything else
//We use it to add dependency injection using Hilt

@HiltAndroidApp
class BaseApplication : Application() {
}