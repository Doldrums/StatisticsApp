package com.example.final_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.final_project.Fragments.ListPlayersFragment
import com.example.final_project.Fragments.StatFragment


public class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainactivity_layout)
        val actionBar = supportActionBar
        actionBar!!.hide()

            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment, ListPlayersFragment.newInstance("", ""), "kek_tag")
                .commit()


    }
    fun changeFragment(fragmentId : Int, name : String, id : String) {
        when (fragmentId) {
            STAT_FRAGMENT -> supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment, StatFragment.newInstance(name, id), "frag2_tag")
                .commit()
            LIST_PLAYERS_FRAGMENT -> supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment, ListPlayersFragment.newInstance(name, id), "frag3_tag")
                .commit()
        }
    }

    companion object {
        val LIST_PLAYERS_FRAGMENT = 1
        val STAT_FRAGMENT = 2
        val BEGIN_FRAGMENT = 3
        val COMPARSION_FRAGMENT = 4

    }

}


