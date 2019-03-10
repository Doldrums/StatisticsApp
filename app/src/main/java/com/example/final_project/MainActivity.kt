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

            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment, ListPlayersFragment.newInstance("nameStart"), "kek_tag")
                .commit()


    }
    fun changeFragment(fragmentId : Int, name : String, id : String){
        when (fragmentId) {
            1 -> supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment, AddPlayerFragment.newInstance(), "kek_tag")
                .commit()
            2 -> supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment, StatFragment.newInstance(name, id), "kek_tag")
                .commit()
            3 -> supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment, ListPlayersFragment.newInstance(name), "kek_tag")
                .commit()
            4 -> supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment, ComparisonFragment.newInstance(), "kek_tag")
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


