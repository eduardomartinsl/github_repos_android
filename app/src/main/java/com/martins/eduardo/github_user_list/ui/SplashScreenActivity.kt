package com.martins.eduardo.github_user_list.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.martins.eduardo.github_user_list.R
import com.martins.eduardo.github_user_list.extensions.component
import com.martins.eduardo.github_user_list.viewModel.SplashScreenViewModel

class SplashScreenActivity : AppCompatActivity() {

    private val viewModel by viewModels<SplashScreenViewModel>()
    private val gitColorsFileName = "GitColors.json"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.splash_screen)

        application.component.inject(this)

        viewModel.generateColorTable(this, gitColorsFileName)
        val runnable = Runnable {
            val intent = Intent(this, InitialActivity::class.java)
            startActivity(intent)
        }

        val handler = Handler()
        handler.postDelayed(runnable, 2000)
    }

    override fun onPause() {
        super.onPause()
        cleanCallBack()
    }


    override fun onStop() {
        super.onStop()
        cleanCallBack()
    }

    private fun cleanCallBack() {
        val handler = Handler()
        handler.removeCallbacksAndMessages(null)
    }
}