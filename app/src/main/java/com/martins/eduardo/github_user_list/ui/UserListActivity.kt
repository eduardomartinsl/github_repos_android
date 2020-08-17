package com.martins.eduardo.github_user_list.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.martins.eduardo.github_user_list.R
import com.martins.eduardo.github_user_list.adapter.ListaRepositoriosAdapter
import com.martins.eduardo.github_user_list.extensions.component
import com.martins.eduardo.github_user_list.viewModel.UserListViewModel
import kotlinx.android.synthetic.main.activity_user_list.*

class UserListActivity : AppCompatActivity() {

    private val viewModel by viewModels<UserListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)

        val usuarioPesquisa = intent.getStringExtra("usuario_pesquisa") ?: ""

        application.component.inject(this)

        viewModel.buscaInformacoesDeUsuario(usuarioPesquisa)

        viewModel.usuario.observe(this, Observer { user->
            //atualizar informações da página do usuário
            nomeTextView.text = user.name
            usuarioContaTextView.text = user.login
            usuarioBioTextView.text = user.bio

        })

        viewModel.listaRepositorio.observe(this, androidx.lifecycle.Observer {

            val divisor = DividerItemDecoration(applicationContext, LinearLayoutManager.VERTICAL)
            val listaRepositoriosAdapter = ListaRepositoriosAdapter(it.toMutableList())

            val linearLayoutManager = LinearLayoutManager(this)
            linearLayoutManager.orientation = LinearLayoutManager.VERTICAL

            ListaRepositoriosRecyclerView.addItemDecoration(divisor)
            ListaRepositoriosRecyclerView.layoutManager = linearLayoutManager
            ListaRepositoriosRecyclerView.adapter = listaRepositoriosAdapter

        })
    }
}
