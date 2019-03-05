package com.example.final_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.final_project.Fragments.BeginFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainactivity_layout)
        val actionBar = supportActionBar
        actionBar!!.hide()

        supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment, BeginFragment.newInstance(), "rageComicList")
                .commit()


    }
}
