@file:Suppress("RedundantIf")

package com.martins.eduardo.github_user_list.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.martins.eduardo.github_user_list.R
import com.martins.eduardo.github_user_list.extensions.component
import com.martins.eduardo.github_user_list.viewModel.SearchViewModel
import com.martins.eduardo.github_user_list.viewModel.UserListViewModel
import kotlinx.android.synthetic.main.activity_search.*
import javax.inject.Inject

class SearchActivity : AppCompatActivity() {

    private val viewModel by viewModels<SearchViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_search)

        application.component.inject(this)

        editTextBuscaUsuario.paintFlags = 0
        editTextBuscaUsuario.requestFocus()

        carregaSugestoes()

        editTextBuscaUsuario.setOnEditorActionListener{v, actionId, event ->
            if(actionId == EditorInfo.IME_ACTION_SEARCH){
                //iniciar activity com o usuario a ser pesqusiado
                val intent = Intent(this, UserListActivity::class.java)
                startActivity(intent)
                true
            }else{
                false
            }
        }
    }

    fun carregaSugestoes(){

        viewModel.carregaListaHistorico()
        viewModel.listaHistorico.observe(this, Observer {
            //carrega as informações da lista
        })

    }
}