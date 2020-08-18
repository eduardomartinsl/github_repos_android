package com.martins.eduardo.github_user_list.adapter.listeners

import com.martins.eduardo.github_user_list.models.Sugestao

interface OnSugestaoClickListeners {
    fun onSugestaoClickListener(sugestao: Sugestao)
    fun OnExcluirSugestaoListener(sugestao: Sugestao)
}