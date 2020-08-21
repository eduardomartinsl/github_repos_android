package com.martins.eduardo.github_user_list.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Color (
    @PrimaryKey(autoGenerate = true)
    val idColor: Int = 0,
    val colorName : String?,
    val color : String?
)