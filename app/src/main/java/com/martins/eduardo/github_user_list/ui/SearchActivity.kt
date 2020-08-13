@file:Suppress("RedundantIf")

package com.martins.eduardo.github_user_list.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import com.martins.eduardo.github_user_list.R
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_search)

        editTextBuscaUsuario.paintFlags = 0
        editTextBuscaUsuario.requestFocus()

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
}