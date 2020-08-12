package com.martins.eduardo.github_user_list.ui

import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.martins.eduardo.github_user_list.R
import com.martins.eduardo.github_user_list.adapter.ListaRepositoriosAdapter
import com.martins.eduardo.github_user_list.extensions.component
import com.martins.eduardo.github_user_list.services.GitHubService
import com.martins.eduardo.github_user_list.viewModel.UserListViewModel
import kotlinx.android.synthetic.main.activity_user_list.*
import java.util.Observer
import javax.inject.Inject

private const val MENSAGEM_FALHA_CARREGAR_NOTICIAS = "Não foi possível carregar os repositórios"

class UserListActivity : AppCompatActivity() {

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    @Inject
    lateinit var gitHubService: GitHubService

    private val viewModel by viewModels<UserListViewModel>()

        private val adapter by lazy {
        applicationContext?.let {
            ListaRepositoriosAdapter(it)
        } ?: throw IllegalArgumentException("Contexto inválido")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)

        application.component.inject(this)

        val divisor = DividerItemDecoration(applicationContext, LinearLayoutManager.VERTICAL)
        ListaRepositoriosRecyclerView.addItemDecoration(divisor)
        ListaRepositoriosRecyclerView.adapter = adapter

        viewModel.buscaTodosRepositorios("eduardomartinsl")

        viewModel.listaRepositorio.observe(this, androidx.lifecycle.Observer {
            val a = 1
        })
    }

//    private val adapter by lazy {
//        applicationContext?.let {
//            ListaRepositoriosAdapter(it)
//        } ?: throw IllegalArgumentException("Contexto inválido")
//    }
//
//    private val viewModel by lazy {
//        val repository = Repository()
//        val factory = UserListViewModelFactory(repository)
//        val provider = ViewModelProvider(this, factory)
//        provider.get(UserListViewModel::class.java)
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_user_list)
//
//        val divisor = DividerItemDecoration(applicationContext, LinearLayoutManager.VERTICAL)
//        ListaRepositoriosRecyclerView.addItemDecoration(divisor)
//        ListaRepositoriosRecyclerView.adapter = adapter
//
//        viewModel.buscaTodosRepositorios("eduardomartinsl")
//
//        viewModel.listaRepositorio.observe(this, Observer {resource ->
//            resource.data?.let {
//                resource.data?.let { adapter.updateAdapter(it)}
//                resource.error?.let {
//                    mostraErro(MENSAGEM_FALHA_CARREGAR_NOTICIAS)
//                }
//            }
//        })
//    }
//
//    fun mostraErro(mensagem: String) {
//        Toast.makeText(
//            this,
//            mensagem,
//            Toast.LENGTH_LONG
//        ).show()
//    }

}
