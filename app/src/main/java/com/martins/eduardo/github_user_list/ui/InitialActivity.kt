package com.martins.eduardo.github_user_list.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.martins.eduardo.github_user_list.R
import com.martins.eduardo.github_user_list.viewModel.InitialViewModel
import kotlinx.android.synthetic.main.activity_initial.*
import javax.inject.Inject

class InitialActivity : AppCompatActivity() {
    //TODO criar splashscreen
    //por enquanto esta activity vai ser a responsável por criar o banco de dados de cores de linguagens de programação

    private val viewModel by viewModels<InitialViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_initial)

        button_buscar_usuario.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }
    }
}