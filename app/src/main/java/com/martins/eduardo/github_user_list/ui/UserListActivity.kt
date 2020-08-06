package com.martins.eduardo.github_user_list.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.martins.eduardo.github_user_list.R
import com.martins.eduardo.github_user_list.services.GitHubService
import retrofit.GsonConverterFactory
import retrofit.Retrofit


class UserListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)

//        var listaCompleta = service.listRepos("eduardomartinsl")
//
//        listaCompleta.enqueue(object: Callback<List<Repo>>{
//            override fun onFailure(t: Throwable?) {
//            }
//
//            override fun onResponse(response: Response<List<Repo>>?) {
//                var listatop = response?.body()
//            }
//
//        })
    }
}
