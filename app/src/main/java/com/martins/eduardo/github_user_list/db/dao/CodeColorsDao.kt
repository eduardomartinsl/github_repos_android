package com.martins.eduardo.github_user_list.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.martins.eduardo.github_user_list.models.Color

@Dao
interface CodeColorsDao {

    @Insert(onConflict = REPLACE)
    suspend fun insertColors(colors: List<Color>)

    @Query("SELECT color from Color where colorName = :colorName")
    suspend fun selectColorHash(colorName: String) : String

}

