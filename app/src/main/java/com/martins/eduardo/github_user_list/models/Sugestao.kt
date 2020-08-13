package com.martins.eduardo.github_user_list.models

import androidx.room.PrimaryKey

data class Sugestao (
    @PrimaryKey(autoGenerate = true)
    val idSugestao: Int,
    val sugestao: String
)