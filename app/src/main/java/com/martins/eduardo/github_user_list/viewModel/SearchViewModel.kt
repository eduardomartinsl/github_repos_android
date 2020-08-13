package com.martins.eduardo.github_user_list.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.martins.eduardo.github_user_list.extensions.component
import com.martins.eduardo.github_user_list.repository.Repository
import javax.inject.Inject

class SearchViewModel(application: Application) : AndroidViewModel(application){

    @Inject
    lateinit var repository: Repository

    private val _listaHistorico = MutableLiveData<List<String>>()
    val listaHistorico : LiveData<List<String>>
        get() = _listaHistorico

    init {
        getApplication<Application>().component.inject(this)
    }

    fun carregaListaHistorico(){
        //deve ir no banco de dados local e buscar os resultados já buscados
    }

}