package com.example.final_project.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.final_project.Adapter
import com.example.final_project.MainActivity
import com.example.final_project.MainActivity.Companion.ADD_PLAYER_FRAGMENT
import com.example.final_project.R
import kotlinx.android.synthetic.main.listplayerfragment_layout.*


class ListPlayersFragment : Fragment() {
    var players = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        my_recycler_view.adapter = Adapter(players)


//        my_recycler_view.addOnItemTouchListener(
//            RecyclerItemClickListener(this@ListPlayersFragment.activity!!, my_recycler_view, object : RecyclerItemClickListener.OnItemClickListener {
//                override fun onItemClick(view: View, position: Int) {
//                    val mainActivity = this@ListPlayersFragment.activity as MainActivity
//                    // в playerName передаем имя  через позицию в RV
//                    mainActivity.changeFragment(STAT_FRAGMENT,players[position], "null")
//
//                }
//
//                override fun onLongItemClick(view: View?, position: Int) {
//                    item_background.setCardBackgroundColor(Color.BLUE)
//                    Toast.makeText(
//                        this@ListPlayersFragment.activity,
//                        "Длинное нажатие",
//                        Toast.LENGTH_LONG
//                    ).show()
//                }
//            })
//        )

        fab_addPlayer.setOnClickListener {
            val mainActivity = this@ListPlayersFragment.activity as MainActivity
            mainActivity.changeFragment(ADD_PLAYER_FRAGMENT)
        }


    }

}

