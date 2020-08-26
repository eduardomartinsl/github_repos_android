package com.martins.eduardo.github_user_list.models

data class Repo (
    val node_id: String,
    val name: String,
    val description: String,
    val language: String,
    var languageHashColor: String?,
    val url: String
)