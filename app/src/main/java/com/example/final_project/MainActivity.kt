package com.example.final_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.final_project.Fragments.BeginFragment
import com.example.final_project.Fragments.ListPlayersFragment
import com.example.final_project.Fragments.StatFragment


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainactivity_layout)
        val actionBar = supportActionBar
        actionBar!!.hide()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment, ListPlayersFragment.newInstance(), "kek_tag")
            .commit()


    }

    fun changeFragment(fragmentId: Int) {
        when (fragmentId) {
            1 -> supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment, ListPlayersFragment.newInstance(), "kek_tag")
                .commit()
            2 -> supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment, StatFragment.newInstance(), "kek_tag")
                .commit()
            3 -> supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment, BeginFragment.newInstance(), "kek_tag")
                .commit()
        }
    }

    companion object {
        val LIST_PLAYERS_FRAGMENT = 1
        val STAT_FRAGMENT = 2
        val BEGIN_FRAGMENT = 3
    }

}


