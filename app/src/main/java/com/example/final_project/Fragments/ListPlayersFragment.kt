package com.example.final_project.Fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.final_project.MainActivity
import com.example.final_project.MainActivity.Companion.ADD_PLAYER
import com.example.final_project.MainActivity.Companion.ADD_PLAYER_FRAGMENT
import com.example.final_project.MainActivity.Companion.ID
import com.example.final_project.MainActivity.Companion.NAME
import com.example.final_project.PlayersAdapter
import com.example.final_project.R
import com.example.final_project.RecyclerItemClickListener
import com.example.final_project.players.SimplePlayer
import kotlinx.android.synthetic.main.listplayerfragment_layout.*
import kotlinx.android.synthetic.main.name_player_item_layout.*
import kotlinx.android.synthetic.main.name_player_item_layout.view.*


public class ListPlayersFragment() : Fragment() {
    var players = mutableListOf<SimplePlayer>()


    private var name = ""
    private var id = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.listplayerfragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = this.arguments
        if (bundle != null) {
            name = bundle.getString(NAME)!!
            id = bundle.getString(ID)!!
            if (bundle.getBoolean(ADD_PLAYER)) {
                players.add(SimplePlayer(name, id))
            }
        }

        if (players.size == 0) {
            layout_error_list.visibility = View.VISIBLE
        } else {
            layout_error_list.visibility = View.INVISIBLE
        }

        my_recycler_view.layoutManager = LinearLayoutManager(activity!!.applicationContext)
        my_recycler_view.adapter = PlayersAdapter(players)

        my_recycler_view.addOnItemTouchListener(
            RecyclerItemClickListener(
                this@ListPlayersFragment.activity!!,
                my_recycler_view,
                object : RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        val mainActivity = this@ListPlayersFragment.activity as MainActivity
                        mainActivity.setStatisticsFragment(MainActivity.STAT_FRAGMENT, view.name.text.toString(),id)
                    }

                    override fun onLongItemClick(view: View?, position: Int) {
                        item_background.setCardBackgroundColor(Color.BLUE)
                        Toast.makeText(
                            this@ListPlayersFragment.activity,
                            "Длинное нажатие",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                })
        )

        fab_addPlayer.setOnClickListener {
            val mainActivity = this@ListPlayersFragment.activity as MainActivity
            mainActivity.changeFragment(ADD_PLAYER_FRAGMENT)
        }


    }
}

