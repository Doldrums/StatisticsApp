package com.example.final_project

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.final_project.database.players.SimplePlayer


class PlayersAdapter(private var players: List<SimplePlayer>) :
    RecyclerView.Adapter<PlayersAdapter.ViewHolder>() {

    fun setData(items: List<SimplePlayer>) {
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
        val playerName:TextView? = itemView?.findViewById(R.id.name)
    }
}

class SeasonsAdapter(context: Context, seasonsIds: MutableList<String>) : ArrayAdapter<String>(context, 0, seasonsIds) {

    fun setData(items: MutableList<String>) {
        notifyDataSetChanged()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    private fun initView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(
                R.layout.spinner_seasons_item, parent, false
            )
        }

        val seasonIdTV = convertView?.findViewById<TextView>(R.id.season_id)

        val currentItem = getItem(position).toString()

        if (currentItem != null) {
            seasonIdTV?.text = currentItem
        }

        return convertView!!
    }
}


