package com.example.final_project.Fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.final_project.MainActivity
import com.example.final_project.MainActivity.Companion.STAT_FRAGMENT
import com.example.final_project.PlayersAdapter
import com.example.final_project.R
import com.example.final_project.RecyclerItemClickListener
import kotlinx.android.synthetic.main.listplayerfragment_layout.*
import kotlinx.android.synthetic.main.name_player_item_layout.*


private const val ARG_PLAYER_NAME = "paramPlayerName"




class ListPlayersFragment : Fragment() {
    private var sPlayerName: String? = null

    private val players = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            sPlayerName = it.getString(ARG_PLAYER_NAME)
        }
        if (sPlayerName!=""){
            players.add(sPlayerName!!)
        }

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.listplayerfragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        my_recycler_view.layoutManager = LinearLayoutManager(activity!!.applicationContext)
        my_recycler_view.adapter = PlayersAdapter(players)


        my_recycler_view.addOnItemTouchListener(
            RecyclerItemClickListener(this@ListPlayersFragment.activity!!, my_recycler_view, object : RecyclerItemClickListener.OnItemClickListener {
                override fun onItemClick(view: View, position: Int) {
                    val mainActivity = this@ListPlayersFragment.activity as MainActivity
                    // в sPlayerName передаем имя  через позицию в RV
                    mainActivity.changeFragment(STAT_FRAGMENT,players[position], "null")

                }

                override fun onLongItemClick(view: View?, position: Int) {
                    item_background.setCardBackgroundColor(Color.BLUE)
                    Toast.makeText(
                        this@ListPlayersFragment.activity,
                        "Длинное нажатие",
                        Toast.LENGTH_LONG
                    ).show()
                }
            })
        )

        fab_addPlayer.setOnClickListener {
            val mainActivity = this@ListPlayersFragment.activity as MainActivity
            mainActivity.changeFragment(MainActivity.BEGIN_FRAGMENT, "null", "null")
        }



    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String) =
            ListPlayersFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PLAYER_NAME, param1)
                }
            }
    }


}
