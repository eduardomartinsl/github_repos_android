package com.martins.eduardo.github_user_list.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Sugestao (
    @PrimaryKey(autoGenerate = true)
    val idSugestao: Int = 0,
    val sugestao: String
)