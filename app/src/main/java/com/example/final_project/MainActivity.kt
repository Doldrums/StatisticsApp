package com.example.final_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.final_project.Fragments.AddPlayerFragment
import com.example.final_project.Fragments.ComparisonFragment
import com.example.final_project.Fragments.ListPlayersFragment
import com.example.final_project.Fragments.StatFragment


public class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainactivity_layout)
        val actionBar = supportActionBar
        actionBar!!.hide()

        changeFragment(LIST_PLAYERS_FRAGMENT)

    }

    fun addPlayer(fragmentId: Int, name: String, id: String, doWeAddPlayer: Boolean) {
        when (fragmentId) {
            LIST_PLAYERS_FRAGMENT -> {
                if (doWeAddPlayer) {
                    val currentFrag = ListPlayersFragment()
                    if (!name.equals("") and !id.equals("")) {
                        val bundle = Bundle()
                        bundle.putString("name", name)
                        bundle.putString("id", id)
                        bundle.putBoolean("add_player", doWeAddPlayer)
                        currentFrag.arguments = bundle
                    }
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment, currentFrag, "kek_tag")
                        .commit()
                } else
                    changeFragment(fragmentId)
            }
        }
    }

    fun setStatisticsFragment(fragmentId: Int, playerId: String, seasonId: String) {
        when (fragmentId) {
            STAT_FRAGMENT -> {
                val currentFrag = StatFragment()
                if (!playerId.equals("") and !seasonId.equals("")) {
                    val bundle = Bundle()
                    bundle.putString("name", playerId)
                    bundle.putString("id", seasonId)
                    currentFrag.arguments = bundle
                }
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment, currentFrag, "kek_tag")
                    .commit()
            }
        }
    }


    fun changeFragment(fragmentId: Int) {
        when (fragmentId) {
            LIST_PLAYERS_FRAGMENT -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment, ListPlayersFragment(), "kek_tag")
                    .commit()
            }
            ADD_PLAYER_FRAGMENT -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment, AddPlayerFragment(), "kek_tag")
                    .commit()
            }
            STAT_FRAGMENT -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment, StatFragment(), "kek_tag")
                    .commit()
            }
            COMPARSION_FRAGMENT -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment, ComparisonFragment(), "kek_tag")
                    .commit()
            }

        }
    }

    companion object {
        val LIST_PLAYERS_FRAGMENT = 1
        val ADD_PLAYER_FRAGMENT = 2
        val STAT_FRAGMENT = 3
        val COMPARSION_FRAGMENT = 4
    }
}


