package com.example.final_project.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.final_project.API.getSeasonStats
import com.example.final_project.API.getSeasons
import com.example.final_project.MainActivity
import com.example.final_project.MainActivity.Companion.LIST_PLAYERS_FRAGMENT
import com.example.final_project.R
import kotlinx.android.synthetic.main.statfragment_layout.*


class StatFragment : Fragment() {
    var seasons = mutableListOf<String>()
    var playerId: String = ""
    var nameOfPlayer: String = ""
    var params = mutableListOf<String>()
    var paramsNames = mutableListOf<String>()

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

        val bundle = this.arguments
        if (bundle != null) {
            nameOfPlayer = bundle.getString("name")!!
            playerId = bundle.getString("id")!!
            Log.d("pn", nameOfPlayer)
            Log.d("pid", playerId)

            txt_playerName.text = nameOfPlayer
        }

        btn_exitStat.setOnClickListener {
            val mainActivity = this@StatFragment.activity as MainActivity
            mainActivity.changeFragment(LIST_PLAYERS_FRAGMENT)
        }

        getSeasons("pc-ru") { data ->
            for (item in data.seasons) {
                seasons.add(item.id)

            }
            spinner.adapter = ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, seasons)
            Log.d("ls", seasons.last())
        }

        //Вот тут на клик по кнопке получаем статистику по сезону, который выбран в спиннере
        //лучше выбирать 2 последних сезона, там есть данные
        button.setOnClickListener {
            Log.d("ssi", spinner.selectedItem.toString())
            getSeasonStats(playerId, spinner.selectedItem.toString()) { data ->
                Log.d("stat", data.data.seasonAttributes.gameModeStats.duo.assists.toString())
                //вот тут таким образом я заполняю textView
                //все параметры можно посмотреть в классе SeasonStatistic (их ООООчень много)
                assists.text = data.data.seasonAttributes.gameModeStats.duo.assists.toString()
            }
        }


    }
}



