package com.martins.eduardo.github_user_list.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.martins.eduardo.github_user_list.R
import com.martins.eduardo.github_user_list.repository.Repository
import com.martins.eduardo.github_user_list.viewModel.UserListViewModel
import com.martins.eduardo.github_user_list.viewModel.factory.UserListViewModelFactory


class UserListActivity : AppCompatActivity() {
    //TODO formatar tela para exibição de informações (Repositórios)
    //TODO RecyclerView (Criar adapter)

    private val viewModel by lazy {
        val repository = Repository()
        val factory = UserListViewModelFactory(repository)
        val provider = ViewModelProvider(this, factory)
        provider.get(UserListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)

        viewModel.buscaTodosRepositorios("eduardomartinsl").observe(this, Observer {resource ->
            resource.data?.let {
                //atualizar lista de repositórios na activity

            }

            resource.error?.let {
                //exibe mensagem de erro (Geralmente um toast)
            }
        })
    }
}
