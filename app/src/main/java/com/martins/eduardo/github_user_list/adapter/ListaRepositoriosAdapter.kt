package com.martins.eduardo.github_user_list.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.martins.eduardo.github_user_list.R
import com.martins.eduardo.github_user_list.models.Repo
import kotlinx.android.synthetic.main.item_repository.view.*

class ListaRepositoriosAdapter(
    private val context: Context,
    private val listaRepositorios: MutableList<Repo> = mutableListOf()
) : RecyclerView.Adapter<ListaRepositoriosAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(context).inflate(
            R.layout.item_repository,
            parent,
            false
        )
        return ViewHolder(view)
    }

    fun updateAdapter(repositorios: List<Repo>) {
        notifyItemRangeRemoved(0, this.listaRepositorios.size)
        this.listaRepositorios.clear()
        this.listaRepositorios.addAll(repositorios)
        notifyItemRangeInserted(0, this.listaRepositorios.size)
    }

    override fun getItemCount(): Int = listaRepositorios.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val repositorio = listaRepositorios[position]
        holder.bind(repositorio)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private lateinit var repositorio: Repo

        fun bind(repositorio: Repo){
            this.repositorio = repositorio
            itemView.TituloRepositoryTextView.text = repositorio.full_name
            itemView.DescricaoRepositoryTextView.text = repositorio.description
            itemView.LanguageTextView.text = repositorio.language
        }
    }
}