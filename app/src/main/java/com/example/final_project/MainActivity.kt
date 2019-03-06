package com.example.final_project

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.final_project.API.APIFunctions
import com.example.final_project.API.getPlayers
import com.example.final_project.Fragments.BeginFragment
import com.example.final_project.Fragments.ListPlayersFragment
import com.example.final_project.Fragments.StatFragment


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainactivity_layout)
        val actionBar = supportActionBar
        actionBar!!.hide()

        val names = listOf<String>("MRX962","CHEEL40000")
        getPlayers(names)
        val functions = APIFunctions(this)

            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment, BeginFragment.newInstance(), "kek_tag")
                .commit()



    }
    fun changeFragment(i : Int){
        when (i) {
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

}
