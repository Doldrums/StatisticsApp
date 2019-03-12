package com.example.final_project

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.final_project.API.getSeasonStats
import com.example.final_project.Fragments.ListPlayersFragment
import com.example.final_project.players.SimplePlayer

class PlayersAdapter(private var players: List<SimplePlayer>, spinToString: (Spinner) -> String) :
    RecyclerView.Adapter<PlayersAdapter.ViewHolder>() {

    public fun setData(items: List<SimplePlayer>) {
        this.players = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.name_player_item_layout, parent, false)
        return ViewHolder(view){spinner: Spinner -> spinner.selectedItem.toString() }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.playerName?.text = players[position].name

    }

    override fun getItemCount() = players.size

    class ViewHolder(itemView: View?,spinToString: (Spinner) -> String) : RecyclerView.ViewHolder(itemView!!) {
        val playerName = itemView?.findViewById(R.id.name) as TextView

        init {
            itemView!!.setOnClickListener {
                Log.i("mmm_tag", ListPlayersFragment.season)
                getSeasonStats(playerName.text.toString(),ListPlayersFragment.season)
                //TODO("вот тут хочу spinner.selectedItem.toString"))
                //TODO(или строку)

            }
        }
    }


}

//                { data ->
//                    val mainActivity = this.activity as MainActivity
//                    mainActivity.changeFragment(MainActivity.LIST_PLAYERS_FRAGMENT,data.getName(),data.getId())
//                }

