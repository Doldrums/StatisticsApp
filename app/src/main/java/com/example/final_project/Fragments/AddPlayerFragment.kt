package com.example.final_project.Fragments


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.final_project.MainActivity
import com.example.final_project.MainActivity.Companion.LIST_PLAYERS_FRAGMENT
import com.example.final_project.R
import kotlinx.android.synthetic.main.beginfragment_layout.*


class AddPlayerFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.beginfragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("FRAG", "Fragment BeginFragment started")
        val playerName = input_login.text.toString()
        btn_find.setOnClickListener {
            val mainActivity = this@AddPlayerFragment.activity as MainActivity
            mainActivity.changeFragment(LIST_PLAYERS_FRAGMENT, playerName, "null")
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            AddPlayerFragment().apply {
            }
    }
}
