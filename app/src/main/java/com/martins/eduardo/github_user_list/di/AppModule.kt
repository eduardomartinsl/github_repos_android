package com.martins.eduardo.github_user_list.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
open class AppModule(private val application: Application) {
    @Provides
    @Singleton
    open fun providesApp() = application

    @Provides
    @Singleton
    open fun providesContext() = application.applicationContext

    @Provides
    @Singleton
    open fun provideSharedPreferences() = application.getSharedPreferences("SHARED_PREFERENCES", Context.MODE_PRIVATE)
}