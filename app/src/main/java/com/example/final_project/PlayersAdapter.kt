package com.example.final_project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.example.final_project.players.SimplePlayer

class PlayersAdapter(private var players:List<SimplePlayer>) : RecyclerView.Adapter<PlayersAdapter.ViewHolder>() {

    public fun setData(items:List<SimplePlayer>){
        this.players = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.name_player_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.playerName?.text = players[position].name
    }

    override fun getItemCount() = players.size
    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val playerName = itemView?.findViewById(R.id.name) as TextView

    }


}
