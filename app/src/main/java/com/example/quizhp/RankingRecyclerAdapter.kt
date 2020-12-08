package com.example.quizhp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_ranking_recycler.view.*

class RankingRecyclerAdapter(
        private val rankings: List<Ranking>
) : RecyclerView.Adapter<RankingRecyclerAdapter.RankingViewHolder>() {

    class RankingViewHolder(view: View)
        : RecyclerView.ViewHolder(view) {
        val textViewNome = view.textViewListNome
        val textViewPontos = view.textViewListPontos
    }

    override fun onCreateViewHolder(
            parent: ViewGroup, viewType: Int
    ): RankingViewHolder {
        val view = LayoutInflater
                .from(parent.context)
                .inflate(
                        R.layout.list_ranking_recycler,
                        parent,
                        false)
        val rankingViewHolder = RankingViewHolder(view)
        return rankingViewHolder
    }

    override fun onBindViewHolder(holder: RankingViewHolder, position: Int) {
        val ranking = rankings.get(position)
        holder.textViewNome.text = ranking.nome
        holder.textViewPontos.text = ranking.pontos.toString()
    }

    override fun getItemCount(): Int = rankings.size

}