package com.martins.eduardo.github_user_list.di

import android.content.Context
import androidx.room.Room
import com.martins.eduardo.github_user_list.db.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule {

    @Provides
    @Singleton
    fun providesDB(context: Context) = Room.databaseBuilder(context, AppDatabase::class.java, "Database") .build()

    @Provides
    fun providesSugestoesDao(db: AppDatabase) = db.sugestoesDao()

}