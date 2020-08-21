package com.martins.eduardo.github_user_list.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.martins.eduardo.github_user_list.db.dao.CodeColorsDao
import com.martins.eduardo.github_user_list.db.dao.SugestoesDao
import com.martins.eduardo.github_user_list.models.Color
import com.martins.eduardo.github_user_list.models.Sugestao

@Database(entities = [Sugestao::class, Color::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun sugestoesDao(): SugestoesDao
    abstract fun codeColorsDao(): CodeColorsDao

}