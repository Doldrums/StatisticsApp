package com.example.final_project.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.final_project.MainActivity
import com.example.final_project.R
import com.example.final_project.RecyclerItemClickListener
import kotlinx.android.synthetic.main.listplayerfragment_layout.*


class ListPlayersFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.listplayerfragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("FRAG","Fragment ListFragment started")

        val player_id = mutableListOf<String>()
        player_id.add("Id1234567890")
        player_id.add("Id1234567890")
        player_id.add("Id1234567890")
        player_id.add("Id1234567890")
        player_id.add("Id1234567890")


        my_recycler_view.layoutManager = LinearLayoutManager(activity!!.applicationContext)
        my_recycler_view.adapter = Adapter(playerId)

        my_recycler_view.addOnItemTouchListener(
            RecyclerItemClickListener(this@ListPlayersFragment.activity!!, my_recycler_view, object : RecyclerItemClickListener.OnItemClickListener {
                override fun onItemClick(view: View, position: Int) {
                    //Переходим во фрагмент с подробной статистикой об игроке
//                    Toast.makeText(
//                        this@ListPlayersFragment.activity,
//                        "Короткое нажатие",
//                        Toast.LENGTH_LONG
//                    ).show()
                    val ma = this@ListPlayersFragment.activity as MainActivity
                    ma.changeFragment(2)

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

        btn_exit.setOnClickListener {
            val ma = this@ListPlayersFragment.activity as MainActivity
            ma.changeFragment(3)
        }



    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ListPlayersFragment().apply {
            }
    }

    class Adapter(private val player_id: List<String>) : RecyclerView.Adapter<Adapter.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

            val view = LayoutInflater.from(parent.context).inflate(R.layout.id_player_item_layout, parent, false)
            return ViewHolder(view)


        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.player_id?.text = player_id[position]
        }

        override fun getItemCount() = player_id.size
        class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
            var player_id: TextView? = null

            init {
                player_id = itemView?.findViewById(R.id.name)
            }
        }


    }
}
