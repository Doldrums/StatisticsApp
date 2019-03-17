package com.example.final_project.Fragments

import android.graphics.Color
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
import com.example.final_project.MainActivity.Companion.ID
import com.example.final_project.MainActivity.Companion.LIST_PLAYERS_FRAGMENT
import com.example.final_project.MainActivity.Companion.NAME
import com.example.final_project.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.jjoe64.graphview.ValueDependentColor
import com.jjoe64.graphview.series.BarGraphSeries
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import kotlinx.android.synthetic.main.statfragment_layout.*


class StatFragment : Fragment() {
    var seasons = mutableListOf<String>()
    var playerId: String = ""
    var nameOfPlayer: String = ""

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
            nameOfPlayer = bundle.getString(NAME)!!
            playerId = bundle.getString(ID)!!
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
            spinner.adapter = ArrayAdapter<String>(context!!, android.R.layout.simple_spinner_item, seasons)
            Log.d("ls", seasons.last())
        }

        val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_solo -> {
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_duo -> {
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_squad -> {
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
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
                bestRankPoint.text = data.data.seasonAttributes.gameModeStats.duo.bestRankPoint.toString()
                rankPoints.text = data.data.seasonAttributes.gameModeStats.duo.rankPoints.toString()
                roundsPlayed.text = data.data.seasonAttributes.gameModeStats.duo.roundsPlayed.toString()
                kills.text = data.data.seasonAttributes.gameModeStats.duo.kills.toString()
                longestKill.text = data.data.seasonAttributes.gameModeStats.duo.longestKill.toString()
                dailyKills.text = data.data.seasonAttributes.gameModeStats.duo.dailyKills.toString()
                headshotKills.text = data.data.seasonAttributes.gameModeStats.duo.headshotKills.toString()
                maxKillStreaks.text = data.data.seasonAttributes.gameModeStats.duo.maxKillStreaks.toString()
                roadKills.text = data.data.seasonAttributes.gameModeStats.duo.roadKills.toString()
                roundMostKills.text = data.data.seasonAttributes.gameModeStats.duo.roundMostKills.toString()
                teamKills.text = data.data.seasonAttributes.gameModeStats.duo.teamKills.toString()
                weeklyKills.text = data.data.seasonAttributes.gameModeStats.duo.weeklyKills.toString()
                top10s.text = data.data.seasonAttributes.gameModeStats.duo.top10s.toString()
                mostSurvivalTime.text = data.data.seasonAttributes.gameModeStats.duo.mostSurvivalTime.toString()
                swimDistance.text = data.data.seasonAttributes.gameModeStats.duo.swimDistance.toString()
                dBNOs.text = data.data.seasonAttributes.gameModeStats.duo.dBNOs.toString()
                dailyWins.text = data.data.seasonAttributes.gameModeStats.duo.dailyWins.toString()
                boosts.text = data.data.seasonAttributes.gameModeStats.duo.boosts.toString()
                damageDealt.text = data.data.seasonAttributes.gameModeStats.duo.damageDealt.toString()
                days.text = data.data.seasonAttributes.gameModeStats.duo.days.toString()
                heals.text = data.data.seasonAttributes.gameModeStats.duo.heals.toString()
                losses.text = data.data.seasonAttributes.gameModeStats.duo.losses.toString()
                revives.text = data.data.seasonAttributes.gameModeStats.duo.revives.toString()
                rideDistance.text = data.data.seasonAttributes.gameModeStats.duo.rideDistance.toString()
                suicides.text = data.data.seasonAttributes.gameModeStats.duo.suicides.toString()
                vehicleDestroys.text = data.data.seasonAttributes.gameModeStats.duo.vehicleDestroys.toString()
                weaponsAcquired.text = data.data.seasonAttributes.gameModeStats.duo.weaponsAcquired.toString()

                val series = LineGraphSeries<DataPoint>(
                    arrayOf<DataPoint>(
                        DataPoint(0.0, data.data.seasonAttributes.gameModeStats.duo.dailyKills.toDouble()),
                        DataPoint(1.0, data.data.seasonAttributes.gameModeStats.duo.weeklyKills.toDouble()),
                        DataPoint(2.0, data.data.seasonAttributes.gameModeStats.duo.teamKills.toDouble()),
                        DataPoint(3.0, data.data.seasonAttributes.gameModeStats.duo.kills.toDouble()),
                        DataPoint(4.0, data.data.seasonAttributes.gameModeStats.duo.longestKill)
                    )
                )
                series.isDrawDataPoints = true
                series.dataPointsRadius = 10F
                graph.viewport.isScalable = true
                graph.addSeries(series)

                val series1 = BarGraphSeries(
                    arrayOf(
                        DataPoint(0.0, data.data.seasonAttributes.gameModeStats.duo.rankPoints),
                        DataPoint(1.0, data.data.seasonAttributes.gameModeStats.duo.bestRankPoint),
                        DataPoint(2.0, data.data.seasonAttributes.gameModeStats.duo.roundsPlayed.toDouble()),
                        DataPoint(3.0, data.data.seasonAttributes.gameModeStats.duo.assists.toDouble()),
                        DataPoint(4.0, data.data.seasonAttributes.gameModeStats.duo.top10s.toDouble())
                    )
                )
                graph1.addSeries(series1)
                // styling
                series1.valueDependentColor = ValueDependentColor<DataPoint> { points ->
                    Color.rgb(
                        points.x.toInt() * 255 / 4,
                        Math.abs(points.y * 255 / 6).toInt(),
                        100
                    )
                }
                series1.spacing = 50
                series1.isDrawValuesOnTop = true
                series1.valuesOnTopColor = Color.WHITE
                graph1.viewport.isScalable = true

            }
        }


    }
}



