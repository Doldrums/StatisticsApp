package com.example.final_project

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.final_project.Fragments.ListPlayersFragment
import com.example.final_project.Fragments.StatFragment


public class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainactivity_layout)
        val actionBar = supportActionBar
        actionBar!!.hide()

        addPlayer(LIST_PLAYERS_FRAGMENT, "", "",false)

    }

    fun addPlayer(fragmentId: Int, name: String, id: String, doWeAddPlayer: Boolean) {
        when (fragmentId) {
            1 -> {
                if (doWeAddPlayer) {
                    val currentFrag = ListPlayersFragment()
                    Log.d("bug", "lpf_start")
                    if (!name.equals("") and !id.equals("")) {
                        val bundle = Bundle()
                        bundle.putString("name", name)
                        bundle.putString("id", id)
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

    fun changeFragment(fragmentId: Int) {
        when (fragmentId) {
            1 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment, ListPlayersFragment(), "kek_tag")
                    .commit()
            }
            2 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment, AddPlayerFragment(), "kek_tag")
                    .commit()
            }
            3 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment, StatFragment(), "kek_tag")
                    .commit()
            }
            4 -> {
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


