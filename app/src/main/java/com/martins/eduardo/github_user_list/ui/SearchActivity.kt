@file:Suppress("RedundantIf")

package com.martins.eduardo.github_user_list.ui

import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.martins.eduardo.github_user_list.R
import com.martins.eduardo.github_user_list.adapter.ListaSugestoesAdapter
import com.martins.eduardo.github_user_list.adapter.listeners.SugestaoClickListeners
import com.martins.eduardo.github_user_list.extensions.component
import com.martins.eduardo.github_user_list.models.Sugestao
import com.martins.eduardo.github_user_list.viewModel.SearchViewModel
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity(), SugestaoClickListeners {

    private val viewModel by viewModels<SearchViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_search)

        application.component.inject(this)

        editTextBuscaUsuario.paintFlags = 0
        editTextBuscaUsuario.requestFocus()

        editTextBuscaUsuario.setOnEditorActionListener{textView, actionId, event ->
            if(actionId == EditorInfo.IME_ACTION_SEARCH){

                //iniciar activity com o usuario a ser pesquisado

                val usuario = textView.text.toString()

                viewModel.salvaSugestao(usuario)

                val intent = Intent(this, UserListActivity::class.java)
                intent.putExtra("usuario_pesquisa", usuario)

                startActivity(intent)
                true
            }else{
                false
            }
        }
    }

    override fun onResume() {
        super.onResume()

        viewModel.carregaListaHistorico()

        viewModel.listaHistorico.observe(this, Observer {listaSugestoes ->
            val divisor = DividerItemDecoration(applicationContext, LinearLayoutManager.VERTICAL)
            val linearLayoutManager = LinearLayoutManager(this)
            linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
            sugestoesRecyclerView.addItemDecoration(divisor)
            sugestoesRecyclerView.layoutManager = linearLayoutManager

            val adapter = ListaSugestoesAdapter(listaSugestoes.toMutableList(), this)
            sugestoesRecyclerView.adapter = adapter

        })

    }

    override fun onSugestaoClickListener(sugestao: Sugestao) {
        viewModel.buscaPorSugestao(sugestao)
        Toast.makeText(this, "Sugestão clicada: ${sugestao.sugestao}", Toast.LENGTH_SHORT).show()
    }

    override fun OnExcluirSugestaoListener(sugestao: Sugestao) {
        viewModel.removeSugestao(sugestao)
        Toast.makeText(this, "Sugestão excluída", Toast.LENGTH_SHORT).show()
    }

}