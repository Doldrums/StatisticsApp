package com.example.final_project.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.final_project.MainActivity
import com.example.final_project.MainActivity.Companion.ADD_PLAYER_FRAGMENT
import com.example.final_project.R
import kotlinx.android.synthetic.main.statfragment_layout.*

class StatFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.statfragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("FRAG", "Fragment StatFragment started")
        btn_exitStat.setOnClickListener {
            val mainActivity = this@StatFragment.activity as MainActivity
            mainActivity.changeFragment(ADD_PLAYER_FRAGMENT)
        }
    }
}
