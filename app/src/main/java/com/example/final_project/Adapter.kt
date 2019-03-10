package com.example.final_project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.final_project.players.PlayerData
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class Adapter(private val playerName: List<String>) : RecyclerView.Adapter<Adapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.name_player_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.playerName?.text = playerName[position]
    }

    override fun getItemCount() = playerName.size
    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        var playerName: TextView? = null

        init {
            playerName = itemView?.findViewById(R.id.name)
        }
    }


}
