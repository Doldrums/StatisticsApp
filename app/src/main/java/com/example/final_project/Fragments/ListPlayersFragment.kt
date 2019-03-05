package com.example.final_project.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.final_project.R
import kotlinx.android.synthetic.main.listplayerfragment_layout.*


class ListPlayersFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.listplayerfragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var player_id = mutableListOf<String>()
        player_id.add("Id1234567890")
        player_id.add("Id1234567890")
        player_id.add("Id1234567890")
        player_id.add("Id1234567890")
        player_id.add("Id1234567890")

        my_recycler_view.layoutManager = LinearLayoutManager(activity!!.applicationContext)
        my_recycler_view.adapter = Adapter(player_id)


    }

    companion object {
        @JvmStatic
        fun newInstance() =
            BeginFragment().apply {
            }
    }

    class Adapter(internal val player_id: List<String>) : RecyclerView.Adapter<Adapter.ViewHolder>() {
        lateinit var itemView: View
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            itemView = LayoutInflater.from(parent.context).inflate(R.layout.id_player_item_layout, parent, false)
            return ViewHolder(itemView)

        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.player_id?.text = player_id[position]
        }

        override fun getItemCount() = player_id.size
        class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
            var player_id: TextView? = null

            init {
                player_id = itemView?.findViewById(R.id.name)
            }
        }


    }
}
