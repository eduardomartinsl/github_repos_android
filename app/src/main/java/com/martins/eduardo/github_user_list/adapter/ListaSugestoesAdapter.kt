package com.martins.eduardo.github_user_list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.martins.eduardo.github_user_list.R
import com.martins.eduardo.github_user_list.models.Sugestao
import kotlinx.android.synthetic.main.item_sugestao_historico.view.*

class ListaSugestoesAdapter(private val listaSugestoes: MutableList<Sugestao> = mutableListOf()) : RecyclerView.Adapter<ListaSugestoesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val vh = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_sugestao_historico, parent, false)

        return ViewHolder(vh)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val sugestao = listaSugestoes[position]

//        viewHolder.sugestaoTextView.text = sugestao.sugestao

        //todo implementar action de remoção de sugestao
    }

    override fun getItemCount(): Int = listaSugestoes.count()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
//        val sugestaoTextView = itemView.SugestaoTextView
        val removeSugestao = itemView.removeSugestao
    }

}
