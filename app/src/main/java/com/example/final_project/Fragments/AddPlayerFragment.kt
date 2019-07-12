package com.example.final_project.Fragments


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.final_project.API.getPlayer
import com.example.final_project.MainActivity
import com.example.final_project.R
import kotlinx.android.synthetic.main.add_player_frag_layout.*


class AddPlayerFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_player_frag_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("FRAG", "Fragment BeginFragment started")
        btn_find.setOnClickListener {
            getPlayer(input_login.text.toString()) { data ->
                val mainActivity = this.activity as MainActivity
                mainActivity.addPlayer(data.getName(), data.getId(),true)
            }
        }
    }
}


