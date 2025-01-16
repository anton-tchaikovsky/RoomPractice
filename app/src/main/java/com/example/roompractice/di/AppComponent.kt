package com.example.roompractice.di

import android.content.Context
import com.example.roompractice.presentation.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(activity: MainActivity)
}