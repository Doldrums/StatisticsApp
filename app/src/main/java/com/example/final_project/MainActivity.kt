package com.example.final_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.final_project.Fragments.AddPlayerFragment
import com.example.final_project.Fragments.ComparisonFragment
import com.example.final_project.Fragments.ListPlayersFragment
import com.example.final_project.Fragments.StatFragment


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainactivity_layout)
        val actionBar = supportActionBar
        actionBar!!.hide()

        setFragment(LIST_OF_PLAYERS)

    }

//    нужно обработать ситуацию с нажатым + просто так
    fun addPlayer(name: String, id: String, doWeAddPlayer: Boolean) {
        if (doWeAddPlayer) {
            val currentFrag = ListPlayersFragment()
            if (!name.equals("") and !id.equals("")) {
                val bundle = Bundle()
                bundle.putString(NAME, name)
                bundle.putString(ID, id)
                bundle.putBoolean(ADD_PLAYER, doWeAddPlayer)
                currentFrag.arguments = bundle
            }
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment, currentFrag, "dummy")
                .commit()
        } else
            setFragment(LIST_OF_PLAYERS)
    }

    fun showPlayerStatistics(playerId: String, seasonId: String) {
        val frag = StatFragment()
        if (!playerId.equals("") and !seasonId.equals("")) {
            val bundle = Bundle()
            bundle.putString(NAME, playerId)
            bundle.putString(ID, seasonId)
            frag.arguments = bundle
        }
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment, frag, "dummy")
            .commit()
    }

    fun setFragment(fragmentId: Int) {
        when (fragmentId) {
            LIST_OF_PLAYERS -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment, ListPlayersFragment(), "dummy")
                    .commit()
            }
            PLAYER_ADDER -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment, AddPlayerFragment(), "dummy")
                    .commit()
            }
            STATISTICS -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment, StatFragment(), "dummy")
                    .commit()
            }
            COMPARSION -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment, ComparisonFragment(), "dummy")
                    .commit()
            }

        }
    }

    companion object {
        val LIST_OF_PLAYERS = 1
        val PLAYER_ADDER = 2
        val STATISTICS = 3
        val COMPARSION = 4

        val NAME = "NAME"
        val ID = "ID"
        val ADD_PLAYER = "ADD_PLAYER"
    }
}


