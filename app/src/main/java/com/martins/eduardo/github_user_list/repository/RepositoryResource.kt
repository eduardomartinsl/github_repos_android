package com.martins.eduardo.github_user_list.repository

class RepositoryResource<T> (
    val data: T?,
    val error: String? = null
)