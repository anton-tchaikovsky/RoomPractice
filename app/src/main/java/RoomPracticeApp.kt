package com.example.roompractice

import android.app.Application
import com.example.roompractice.di.AppComponent
import com.example.roompractice.di.DaggerAppComponent

class RoomPracticeApp: Application() {

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create(this)
    }

    companion object{
        lateinit var appComponent: AppComponent
    }
}