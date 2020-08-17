package com.martins.eduardo.github_user_list.viewModel

import android.app.Application
import android.util.Log
import android.widget.ImageView
import androidx.lifecycle.*
import com.martins.eduardo.github_user_list.extensions.component
import com.martins.eduardo.github_user_list.models.Repo
import com.martins.eduardo.github_user_list.models.User
import com.martins.eduardo.github_user_list.repository.Repository
import com.squareup.picasso.Picasso
import kotlinx.coroutines.launch
import java.io.Console
import java.lang.Exception
import javax.inject.Inject

class UserListViewModel (application: Application) : AndroidViewModel(application){

    @Inject lateinit var repository: Repository

    init {
        getApplication<Application>().component.inject(this)
    }

    private val _listaRepositorios = MutableLiveData<List<Repo>>()
    val listaRepositorio : LiveData<List<Repo>>
    get() = _listaRepositorios

    private val _usuario = MutableLiveData<User>()
    val usuario: LiveData<User>
        get() = _usuario

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    fun buscaInformacoesDeUsuario(username: String) {
        viewModelScope.launch {
            _isLoading.postValue(true)
            try {
                val usuarioEncontrado = repository.buscaUsuario(username)
                _usuario.postValue(usuarioEncontrado)

                val repositoriosEncontrados = repository.buscaTodosRepositoriosNoGit(username)
                _listaRepositorios.postValue(repositoriosEncontrados)

            }catch (e: Exception){
                Log.e("Erro de comunicação", e.message!!)
            }
            _isLoading.postValue(false)
        }
    }


    fun carregaImagemUsuario(){

        val imageView = ImageView(getApplication())
        var a = Picasso.get().load("")!!
    }
}