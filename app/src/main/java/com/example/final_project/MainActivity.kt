package com.example.final_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.final_project.Fragments.BeginFragment

import com.example.final_project.Fragments.StatFragment


class MainActivity : AppCompatActivity() {

    public fun ChangeFragment(i : Int){
        when (i) {
            1 -> supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment, BeginFragment.newInstance(), "kek_tag")
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainactivity_layout)
        val actionBar = supportActionBar
        actionBar!!.hide()

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment, BeginFragment.newInstance(), "kek_tag")
                .commit()
        }


    }

}
