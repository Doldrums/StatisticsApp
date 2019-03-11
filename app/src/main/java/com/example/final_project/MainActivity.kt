package com.example.final_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.final_project.Fragments.AddPlayerFragment
import com.example.final_project.Fragments.ComparisonFragment
import com.example.final_project.Fragments.ListPlayersFragment
import com.example.final_project.Fragments.StatFragment
import kotlinx.android.synthetic.main.mainactivity_layout.*


public class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainactivity_layout)
        val actionBar = supportActionBar
        actionBar!!.hide()

        changeFragment(LIST_PLAYERS_FRAGMENT, "", "")

    }

    fun changeFragment(fragmentId: Int, name: String, id: String) {


        when (fragmentId) {
            1 -> {
                val currentFrag = ListPlayersFragment()
                if (!name.equals("") and !id.equals("")) {
                    val bundle = Bundle()
                    bundle.putString("name",name)
                    bundle.putString("id",id)
                    currentFrag.arguments = bundle
                }
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment, currentFrag, "kek_tag")
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


