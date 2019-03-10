package com.example.final_project.Fragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.final_project.API.APIFunctions
import com.example.final_project.MainActivity
import com.example.final_project.MainActivity.Companion.LIST_PLAYERS_FRAGMENT
import com.example.final_project.R
import com.google.android.material.snackbar.Snackbar
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
            if (playerName==""){
                Snackbar.make(it,"Введите что-нибудь",Snackbar.LENGTH_LONG).show()
            }else{
                //тут надо наверное провернуть какие-то действия с апихой дабы проверить адекватно ли имя игрока
                val mainActivity = this@AddPlayerFragment.activity as MainActivity
                mainActivity.changeFragment(LIST_PLAYERS_FRAGMENT, playerName, "null")
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            AddPlayerFragment().apply {
            }
    }
}
