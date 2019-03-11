package com.example.final_project.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.final_project.MainActivity
import com.example.final_project.R
import kotlinx.android.synthetic.main.statfragment_layout.*


private const val ARG_PLAYER_NAME = "paramPlayerName"
private const val ARG_PLAYER_ID = "paramPlayerID"

class StatFragment : Fragment() {

    private var sPlayerName: String? = null
    private var sPlayerID: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            sPlayerName = it.getString(ARG_PLAYER_NAME)
            sPlayerID = it.getString(ARG_PLAYER_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.statfragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("FRAG","Fragment StatFragment started")
        btn_exitStat.setOnClickListener {
            val mainActivity = this@StatFragment.activity as MainActivity
            mainActivity.changeFragment(MainActivity.LIST_PLAYERS_FRAGMENT, "null", "null")
        }
        txt_playerName.text = sPlayerName

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            StatFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PLAYER_NAME, param1)
                    putString(ARG_PLAYER_ID, param2)
                }
            }
    }
}
