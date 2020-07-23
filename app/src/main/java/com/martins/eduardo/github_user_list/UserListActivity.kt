package com.martins.eduardo.github_user_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.martins.eduardo.github_user_list.models.Repo
import com.martins.eduardo.github_user_list.services.GitHubService
import retrofit.Callback
import retrofit.GsonConverterFactory
import retrofit.Response
import retrofit.Retrofit


class UserListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(GitHubService::class.java)

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
