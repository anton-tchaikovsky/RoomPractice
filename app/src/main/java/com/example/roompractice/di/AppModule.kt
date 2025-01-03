package com.example.roompractice.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.roompractice.com.example.roompractice.domain.interactor.Interactor
import com.example.roompractice.com.example.roompractice.domain.interactor.InteractorImpl
import com.example.roompractice.data.data_source.LocalDataSource
import com.example.roompractice.data.data_source.LocalDataSourceImpl
import com.example.roompractice.data.repository_impl.RepositoryImpl
import com.example.roompractice.data.room.FlowersDatabase
import com.example.roompractice.domain.Repository
import com.example.roompractice.presentation.FlowersViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
interface AppModule {
    @Binds
    @Singleton
    fun bindLocalDataSource(localDataSource: LocalDataSourceImpl): LocalDataSource

    @Binds
    @Singleton
    fun bindRepository(repository: RepositoryImpl): Repository

    @Binds
    fun bindInteractor(interactorImpl: InteractorImpl): Interactor

    @Binds
    fun bindViewModelFactory(factory: FlowersViewModelFactory): ViewModelProvider.Factory

    companion object{
        @Provides
        @Singleton
        fun provideDatabase(context: Context): FlowersDatabase = Room.databaseBuilder(
            context,
            FlowersDatabase::class.java,
            "flowersDatabase"
        )
            .createFromAsset("flowersDatabase.db")
            .build()
    }

}