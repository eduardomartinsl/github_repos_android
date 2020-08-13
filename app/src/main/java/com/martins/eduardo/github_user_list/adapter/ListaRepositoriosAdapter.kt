package com.martins.eduardo.github_user_list.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import com.martins.eduardo.github_user_list.R
import com.martins.eduardo.github_user_list.models.Repo
import kotlinx.android.synthetic.main.item_repository.view.*

class ListaRepositoriosAdapter(private val listaRepositorios: MutableList<Repo> = mutableListOf()) :
    RecyclerView.Adapter<ListaRepositoriosAdapter.ViewHolder>(){

    //criando a viewHolder
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val vh = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_repository, parent, false)

        return ViewHolder(vh)
    }

    override fun getItemCount(): Int = listaRepositorios.count()

    //bind da informação da lista com a view do item
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        val repositorio = listaRepositorios[position]

        viewHolder.titulo.text = repositorio.name
        viewHolder.descricao.text = repositorio.description
        viewHolder.linguagem.text = repositorio.language

    }

    //view referente a cada item da lista
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titulo = itemView.TituloRepositoryTextView
        val descricao = itemView.DescricaoRepositoryTextView
        val linguagem = itemView.LanguageTextView
    }
}