package com.example.jetpack_compose_mvvm_retrofit

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class UserApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}