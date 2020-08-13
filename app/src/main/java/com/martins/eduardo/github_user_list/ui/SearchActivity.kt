@file:Suppress("RedundantIf")

package com.martins.eduardo.github_user_list.ui

import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.martins.eduardo.github_user_list.R
import com.martins.eduardo.github_user_list.adapter.ListaSugestoesAdapter
import com.martins.eduardo.github_user_list.extensions.component
import com.martins.eduardo.github_user_list.viewModel.SearchViewModel
import kotlinx.android.synthetic.main.activity_search.*

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
                viewModel.salvaSugestao(v.text.toString())
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

        viewModel.listaHistorico.observe(this, Observer {listaSugestoes ->
            //carrega as informações da lista em um adapter

            val divisor = DividerItemDecoration(applicationContext, LinearLayoutManager.VERTICAL)
            val linearLayoutManager = LinearLayoutManager(this)
            linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
            sugestoesRecyclerView.addItemDecoration(divisor)
            sugestoesRecyclerView.layoutManager = linearLayoutManager

            val adapter = ListaSugestoesAdapter(listaSugestoes.toMutableList())
            sugestoesRecyclerView.adapter = adapter

        })

    }
}