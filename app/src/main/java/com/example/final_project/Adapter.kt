package com.example.final_project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.final_project.players.JustInterfaceToAdapter
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


class CustomAdapter : ListDelegationAdapter<List<JustInterfaceToAdapter>>() {

    init {
        delegatesManager.addDelegate(PlayersDelegate())
    }

    fun setData(items: List<JustInterfaceToAdapter>) {
        this.items = items
        notifyDataSetChanged()
    }
}

private class PlayersDelegate :
    AbsListItemAdapterDelegate<PlayerData, JustInterfaceToAdapter, PlayersDelegate.ViewHolder>() {

    override fun isForViewType(
        item: JustInterfaceToAdapter,
        items: List<JustInterfaceToAdapter>,
        position: Int
    ): Boolean {
        return item is PlayerData
    }

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.name_player_item_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(item: PlayerData, viewHolder: ViewHolder, payloads: List<Any>) {
        viewHolder.name.text = item.player.last().attributes.name
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.name)
    }
}