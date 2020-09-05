package com.martins.eduardo.github_user_list.viewModel

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.martins.eduardo.github_user_list.extensions.component
import com.martins.eduardo.github_user_list.repository.Repository
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

class SplashScreenViewModel(application: Application) : AndroidViewModel(application) {

    @Inject
    lateinit var sharedPreferences: SharedPreferences
    @Inject
    lateinit var repository: Repository

    private val chavePrimeiroAcesso = "PRIMEIRO_ACESSO"

    init {
        getApplication<Application>().component.inject(this)
    }

    fun generateColorTable(context: Context, fileName: String) {
        val primeiroAcesso = sharedPreferences.getBoolean(chavePrimeiroAcesso, true)
        if (primeiroAcesso) {
            var jsonString = ""
            try {
                jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
            } catch (ioException: IOException) {
                ioException.printStackTrace()
            }
            viewModelScope.launch {
                repository.criaTabelaDeCores(jsonString)
            }
        }
        sharedPreferences.edit().putBoolean(
            chavePrimeiroAcesso,
            false
        ).apply()
    }


}