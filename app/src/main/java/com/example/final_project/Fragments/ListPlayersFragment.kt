package com.example.final_project.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.final_project.Adapter
import com.example.final_project.MainActivity
import com.example.final_project.R
import com.example.final_project.RecyclerItemClickListener
import kotlinx.android.synthetic.main.listplayerfragment_layout.*


private const val ARG_PARAM1 = "param1"




class ListPlayersFragment : Fragment() {
    private var param1: String? = null

    val players = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
        if (param1!=null) players.add(param1!!)
        players.add("null")
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.listplayerfragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("FRAG","Fragment ListFragment started")

        my_recycler_view.layoutManager = LinearLayoutManager(activity!!.applicationContext)
        my_recycler_view.adapter = Adapter(players)

        my_recycler_view.addOnItemTouchListener(
            RecyclerItemClickListener(this@ListPlayersFragment.activity!!, my_recycler_view, object : RecyclerItemClickListener.OnItemClickListener {
                override fun onItemClick(view: View, position: Int) {
                    val ma = this@ListPlayersFragment.activity as MainActivity
                    // в playerName передаем имя  через позицию в RV
                    ma.changeFragment(2,players[position], "null")
                }

                override fun onLongItemClick(view: View?, position: Int) {
                    Toast.makeText(
                        this@ListPlayersFragment.activity,
                        "Длинное нажатие",
                        Toast.LENGTH_LONG
                    ).show()
                    // do whatever
                }
            })
        )

        fab_addPlayer.setOnClickListener {
            val ma = this@ListPlayersFragment.activity as MainActivity
            ma.changeFragment(1, "null", "null")
        }



    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String) =
            ListPlayersFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }


}
