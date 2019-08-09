package com.example.final_project.Fragments

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.final_project.MainActivity
import com.example.final_project.MainActivity.Companion.ADD_PLAYER
import com.example.final_project.MainActivity.Companion.ID
import com.example.final_project.MainActivity.Companion.NAME
import com.example.final_project.MainActivity.Companion.PLAYER_ADDER
import com.example.final_project.PlayersAdapter
import com.example.final_project.R
import com.example.final_project.RecyclerItemClickListener
import com.example.final_project.database.PlayersDB
import com.example.final_project.database.players.SimplePlayer
import kotlinx.android.synthetic.main.listplayerfragment_layout.*
import kotlinx.android.synthetic.main.name_player_item_layout.*
import kotlinx.android.synthetic.main.name_player_item_layout.view.*
import kotlinx.coroutines.*


class ListPlayersFragment() : Fragment() {
    var players = mutableListOf<SimplePlayer>()

    private var name = ""
    private var id = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.listplayerfragment_layout, container, false)
    }

    @ObsoleteCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //create database
        val db = Room.databaseBuilder(
            context!!,
            PlayersDB::class.java, "playersDB"
        ).build()

        db.createDatabase(context!!)

        my_recycler_view.layoutManager = LinearLayoutManager(activity!!.applicationContext)
        val adapter = PlayersAdapter(players)
        my_recycler_view.adapter = adapter

        //добавили ли мы игрока?
        val bundle = this.arguments
        if (bundle != null) {
            name = bundle.getString(NAME)!!
            id = bundle.getString(ID)!!
            if (bundle.getBoolean(ADD_PLAYER)) {
                newSingleThreadContext("dBThread").use { GlobalScope ->
                    runBlocking(GlobalScope) {
                        cachePlayer(SimplePlayer(name, id), db)
                        log("cashed SUCSESS: ${SimplePlayer(name, id)}")
                        players.clear()
                        players = db.simplePlayerDAO().getPlayersFromDB() as MutableList<SimplePlayer>
                        adapter.setData(players)
                    }
                }
            }
        } else {
            newSingleThreadContext("dBThread").use { GlobalScope ->
                runBlocking(GlobalScope) {
                    players = db.simplePlayerDAO().getPlayersFromDB() as MutableList<SimplePlayer>
                    adapter.setData(players)
                }
            }
        }

        adapter.setData(players)

        //если в базе нет - и не добавляли => нужно добавить
        if (players.isEmpty()) {
            layout_error_list.visibility = VISIBLE
        } else {
            layout_error_list.visibility = INVISIBLE
        }

        my_recycler_view.addOnItemTouchListener(
            RecyclerItemClickListener(
                this@ListPlayersFragment.activity!!,
                my_recycler_view,
                object : RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        val mainActivity = this@ListPlayersFragment.activity as MainActivity
                        mainActivity.showPlayerStatistics(view.name.text.toString(), id)
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
            mainActivity.setFragment(PLAYER_ADDER)
        }


    }
}


fun cachePlayer(player: SimplePlayer, db: PlayersDB) {
    GlobalScope.launch {
        db.simplePlayerDAO().addPlayerToDB(player)
        Log.d("DB", "Add ${player.toString()} to DB")
    }
}

fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")

