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


class ListPlayersFragment : Fragment() {
    var players = mutableListOf<SimplePlayer>()

    private var name = ""
    private var id = ""

    lateinit var db: PlayersDB
    lateinit var adapter: PlayersAdapter

    private val mainJob = SupervisorJob()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.listplayerfragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainJob.start()

        //create database
        createDatabase()
        initAdapter()

        //добавили ли мы игрока?
        val bundle = this.arguments
        if (bundle != null) {
            name = bundle.getString(NAME)!!
            id = bundle.getString(ID)!!

            if (bundle.getBoolean(ADD_PLAYER)) {
                cachePlayers()
            }
        } else {
            getPlayersFromDatabase()
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

    override fun onDestroyView() {
        mainJob.cancel()
        super.onDestroyView()
    }

    private fun initAdapter() {
        my_recycler_view.layoutManager = LinearLayoutManager(activity!!.applicationContext)
        adapter = PlayersAdapter(players)
        my_recycler_view.adapter = adapter
    }

    private fun createDatabase() {
        db = Room.databaseBuilder(context!!, PlayersDB::class.java, "playersDB").build()
        db.createDatabase(context!!)
    }

    private fun getPlayersFromDatabase() = CoroutineScope(Dispatchers.Main + mainJob).launch {
        val playersFromDb = withContext(Dispatchers.IO) { db.simplePlayerDAO().getPlayersFromDB() }

        players.addAll(playersFromDb)
        adapter.setData(players)
    }

    private fun cachePlayers() = CoroutineScope(Dispatchers.Main + mainJob).launch {
        withContext(Dispatchers.IO) { cachePlayer(SimplePlayer(name, id)) }

        log("cached SUCCESS: ${SimplePlayer(name, id)}")

        players.clear()

        val playersFromDb =
            withContext(Dispatchers.IO) { db.simplePlayerDAO().getPlayersFromDB() }

        players.addAll(playersFromDb)
        adapter.setData(players)
    }

    private fun cachePlayer(player: SimplePlayer) {
        db.simplePlayerDAO().addPlayerToDB(player)
        Log.d("DB", "Add $player to DB")
    }
}

fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")

