package com.martins.eduardo.github_user_list.viewModel

import android.app.Application
import android.widget.Adapter
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.martins.eduardo.github_user_list.adapter.ListaSugestoesAdapter
import com.martins.eduardo.github_user_list.extensions.component
import com.martins.eduardo.github_user_list.models.Sugestao
import com.martins.eduardo.github_user_list.repository.Repository
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchViewModel(application: Application) : AndroidViewModel(application){

    @Inject
    lateinit var repository: Repository

    init {
        getApplication<Application>().component.inject(this)
    }

    private val _listaHistorico = MutableLiveData<List<Sugestao>>()
    val listaHistorico : LiveData<List<Sugestao>>
        get() = _listaHistorico

    fun carregaListaHistorico(){
        viewModelScope.launch {
            val listaSugestoes = repository.carregaListaSugestoes()
            _listaHistorico.postValue(listaSugestoes)
        }
    }

    fun salvaSugestao(sugestaoText: String){

        val sugestao = Sugestao(sugestao = sugestaoText)

        viewModelScope.launch {
            repository.salvaSugestao(sugestao)
        }
    }

    fun removeSugestao(sugestao: Sugestao){
        //todo remover sugestão (DAO)
    }

    fun buscaPorSugestao(sugestao: Sugestao){
        //todo buscar por sugestão
    }
}