package com.example.final_project.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.final_project.*
import com.example.final_project.API.getSeasonStats
import com.example.final_project.API.getSeasons
import com.example.final_project.MainActivity.Companion.ID
import com.example.final_project.MainActivity.Companion.LIST_OF_PLAYERS
import com.example.final_project.MainActivity.Companion.NAME
import com.google.android.material.bottomnavigation.BottomNavigationView
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
            mainActivity.setFragment(LIST_OF_PLAYERS)
        }

        getSeasons("pc-ru") { data ->
            for (item in data.seasons) {
                seasons.add(item.id)

            }
            val spinAdapter = SeasonsAdapter(context!!, seasons)
            spinAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
            spinner.adapter = spinAdapter
            Log.d("ls", seasons.last())
        }

        val adapter = StatisticsAdapter()
        stat_data_rv.layoutManager = LinearLayoutManager(activity!!.applicationContext)
        stat_data_rv.adapter = adapter

        val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_solo -> {
                    Log.d("show_solo", spinner.selectedItem.toString())
                    getSeasonStats(playerId, spinner.selectedItem.toString()) { data ->
                        Log.d("stat_solo", data.data.seasonAttributes.gameModeStats.solo.assists.toString())

                        val statisticsData = listOf<StatList>(
                            StatDescr(getString(R.string.stat_txt_rank)),
                            StatData(
                                getString(R.string.rankPoints),
                                data.data.seasonAttributes.gameModeStats.solo.rankPoints.toString()
                            ),
                            StatData(
                                getString(R.string.bestRankPoint),
                                data.data.seasonAttributes.gameModeStats.solo.bestRankPoint.toString()
                            ),
                            StatData(
                                getString(R.string.roundsPlayed),
                                data.data.seasonAttributes.gameModeStats.solo.roundsPlayed.toString()
                            ),
                            StatData(
                                getString(R.string.assists),
                                data.data.seasonAttributes.gameModeStats.solo.assists.toString()
                            ),
                            StatData(
                                getString(R.string.top10s),
                                data.data.seasonAttributes.gameModeStats.solo.top10s.toString()
                            ),
                            StatData(
                                getString(R.string.mostSurvivalTime),
                                data.data.seasonAttributes.gameModeStats.solo.mostSurvivalTime.toString()
                            ),
                            StatData(
                                getString(R.string.swimDistance),
                                data.data.seasonAttributes.gameModeStats.solo.swimDistance.toString()
                            ),

                            StatDescr(getString(R.string.stat_txt_kills)),
                            StatData(
                                getString(R.string.kills),
                                data.data.seasonAttributes.gameModeStats.solo.kills.toString()
                            ),
                            StatData(
                                getString(R.string.longestKill),
                                data.data.seasonAttributes.gameModeStats.solo.longestKill.toString()
                            ),
                            StatData(
                                getString(R.string.roundMostKills),
                                data.data.seasonAttributes.gameModeStats.solo.roundMostKills.toString()
                            ),
                            StatData(
                                getString(R.string.headshotKills),
                                data.data.seasonAttributes.gameModeStats.solo.headshotKills.toString()
                            ),
                            StatData(
                                getString(R.string.dailyKills),
                                data.data.seasonAttributes.gameModeStats.solo.dailyKills.toString()
                            ),
                            StatData(
                                getString(R.string.weeklyKills),
                                data.data.seasonAttributes.gameModeStats.solo.weeklyKills.toString()
                            ),
                            StatData(
                                getString(R.string.weeklyKills),
                                data.data.seasonAttributes.gameModeStats.solo.weeklyKills.toString()
                            ),
                            StatData(
                                getString(R.string.maxKillStreaks),
                                data.data.seasonAttributes.gameModeStats.solo.maxKillStreaks.toString()
                            ),
                            StatData(
                                getString(R.string.roadKills),
                                data.data.seasonAttributes.gameModeStats.solo.roadKills.toString()
                            ),
                            StatData(
                                getString(R.string.teamKills),
                                data.data.seasonAttributes.gameModeStats.solo.teamKills.toString()
                            ),

                            StatDescr(getString(R.string.stat_txt_other)),
                            StatData(
                                getString(R.string.dBNOs),
                                data.data.seasonAttributes.gameModeStats.solo.dBNOs.toString()
                            ),
                            StatData(
                                getString(R.string.dailyWins),
                                data.data.seasonAttributes.gameModeStats.solo.dailyWins.toString()
                            ),
                            StatData(
                                getString(R.string.boosts),
                                data.data.seasonAttributes.gameModeStats.solo.boosts.toString()
                            ),
                            StatData(
                                getString(R.string.damageDealt),
                                data.data.seasonAttributes.gameModeStats.solo.damageDealt.toString()
                            ),
                            StatData(
                                getString(R.string.days),
                                data.data.seasonAttributes.gameModeStats.solo.days.toString()
                            ),
                            StatData(
                                getString(R.string.heals),
                                data.data.seasonAttributes.gameModeStats.solo.heals.toString()
                            ),
                            StatData(
                                getString(R.string.losses),
                                data.data.seasonAttributes.gameModeStats.solo.losses.toString()
                            ),
                            StatData(
                                getString(R.string.revives),
                                data.data.seasonAttributes.gameModeStats.solo.revives.toString()
                            ),
                            StatData(
                                getString(R.string.rideDistance),
                                data.data.seasonAttributes.gameModeStats.solo.rideDistance.toString()
                            ),
                            StatData(
                                getString(R.string.suicides),
                                data.data.seasonAttributes.gameModeStats.solo.suicides.toString()
                            ),
                            StatData(
                                getString(R.string.vehicleDestroys),
                                data.data.seasonAttributes.gameModeStats.solo.vehicleDestroys.toString()
                            ),
                            StatData(
                                getString(R.string.weaponsAcquired),
                                data.data.seasonAttributes.gameModeStats.solo.weaponsAcquired.toString()
                            )
                        )
                        adapter.setData(statisticsData)
                    }
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_duo -> {
                    Log.d("show_duo", spinner.selectedItem.toString())
                    getSeasonStats(playerId, spinner.selectedItem.toString()) { data ->
                        Log.d("stat_duo", data.data.seasonAttributes.gameModeStats.duo.assists.toString())

                        val statisticsData = listOf<StatList>(
                            StatDescr(getString(R.string.stat_txt_rank)),
                            StatData(
                                getString(R.string.rankPoints),
                                data.data.seasonAttributes.gameModeStats.duo.rankPoints.toString()
                            ),
                            StatData(
                                getString(R.string.bestRankPoint),
                                data.data.seasonAttributes.gameModeStats.duo.bestRankPoint.toString()
                            ),
                            StatData(
                                getString(R.string.roundsPlayed),
                                data.data.seasonAttributes.gameModeStats.duo.roundsPlayed.toString()
                            ),
                            StatData(
                                getString(R.string.assists),
                                data.data.seasonAttributes.gameModeStats.duo.assists.toString()
                            ),
                            StatData(
                                getString(R.string.top10s),
                                data.data.seasonAttributes.gameModeStats.duo.top10s.toString()
                            ),
                            StatData(
                                getString(R.string.mostSurvivalTime),
                                data.data.seasonAttributes.gameModeStats.duo.mostSurvivalTime.toString()
                            ),
                            StatData(
                                getString(R.string.swimDistance),
                                data.data.seasonAttributes.gameModeStats.duo.swimDistance.toString()
                            ),

                            StatDescr(getString(R.string.stat_txt_kills)),
                            StatData(
                                getString(R.string.kills),
                                data.data.seasonAttributes.gameModeStats.duo.kills.toString()
                            ),
                            StatData(
                                getString(R.string.longestKill),
                                data.data.seasonAttributes.gameModeStats.duo.longestKill.toString()
                            ),
                            StatData(
                                getString(R.string.roundMostKills),
                                data.data.seasonAttributes.gameModeStats.duo.roundMostKills.toString()
                            ),
                            StatData(
                                getString(R.string.headshotKills),
                                data.data.seasonAttributes.gameModeStats.duo.headshotKills.toString()
                            ),
                            StatData(
                                getString(R.string.dailyKills),
                                data.data.seasonAttributes.gameModeStats.duo.dailyKills.toString()
                            ),
                            StatData(
                                getString(R.string.weeklyKills),
                                data.data.seasonAttributes.gameModeStats.duo.weeklyKills.toString()
                            ),
                            StatData(
                                getString(R.string.weeklyKills),
                                data.data.seasonAttributes.gameModeStats.duo.weeklyKills.toString()
                            ),
                            StatData(
                                getString(R.string.maxKillStreaks),
                                data.data.seasonAttributes.gameModeStats.duo.maxKillStreaks.toString()
                            ),
                            StatData(
                                getString(R.string.roadKills),
                                data.data.seasonAttributes.gameModeStats.duo.roadKills.toString()
                            ),
                            StatData(
                                getString(R.string.teamKills),
                                data.data.seasonAttributes.gameModeStats.duo.teamKills.toString()
                            ),

                            StatDescr(getString(R.string.stat_txt_other)),
                            StatData(
                                getString(R.string.dBNOs),
                                data.data.seasonAttributes.gameModeStats.duo.dBNOs.toString()
                            ),
                            StatData(
                                getString(R.string.dailyWins),
                                data.data.seasonAttributes.gameModeStats.duo.dailyWins.toString()
                            ),
                            StatData(
                                getString(R.string.boosts),
                                data.data.seasonAttributes.gameModeStats.duo.boosts.toString()
                            ),
                            StatData(
                                getString(R.string.damageDealt),
                                data.data.seasonAttributes.gameModeStats.duo.damageDealt.toString()
                            ),
                            StatData(
                                getString(R.string.days),
                                data.data.seasonAttributes.gameModeStats.duo.days.toString()
                            ),
                            StatData(
                                getString(R.string.heals),
                                data.data.seasonAttributes.gameModeStats.duo.heals.toString()
                            ),
                            StatData(
                                getString(R.string.losses),
                                data.data.seasonAttributes.gameModeStats.duo.losses.toString()
                            ),
                            StatData(
                                getString(R.string.revives),
                                data.data.seasonAttributes.gameModeStats.duo.revives.toString()
                            ),
                            StatData(
                                getString(R.string.rideDistance),
                                data.data.seasonAttributes.gameModeStats.duo.rideDistance.toString()
                            ),
                            StatData(
                                getString(R.string.suicides),
                                data.data.seasonAttributes.gameModeStats.duo.suicides.toString()
                            ),
                            StatData(
                                getString(R.string.vehicleDestroys),
                                data.data.seasonAttributes.gameModeStats.duo.vehicleDestroys.toString()
                            ),
                            StatData(
                                getString(R.string.weaponsAcquired),
                                data.data.seasonAttributes.gameModeStats.duo.weaponsAcquired.toString()
                            )
                        )
                        adapter.setData(statisticsData)
                    }
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_squad -> {
                    Log.d("show_squad", spinner.selectedItem.toString())
                    getSeasonStats(playerId, spinner.selectedItem.toString()) { data ->
                        Log.d("stat_squad", data.data.seasonAttributes.gameModeStats.squad.assists.toString())

                        val statisticsData = listOf<StatList>(
                            StatDescr(getString(R.string.stat_txt_rank)),
                            StatData(
                                getString(R.string.rankPoints),
                                data.data.seasonAttributes.gameModeStats.squad.rankPoints.toString()
                            ),
                            StatData(
                                getString(R.string.bestRankPoint),
                                data.data.seasonAttributes.gameModeStats.squad.bestRankPoint.toString()
                            ),
                            StatData(
                                getString(R.string.roundsPlayed),
                                data.data.seasonAttributes.gameModeStats.squad.roundsPlayed.toString()
                            ),
                            StatData(
                                getString(R.string.assists),
                                data.data.seasonAttributes.gameModeStats.squad.assists.toString()
                            ),
                            StatData(
                                getString(R.string.top10s),
                                data.data.seasonAttributes.gameModeStats.squad.top10s.toString()
                            ),
                            StatData(
                                getString(R.string.mostSurvivalTime),
                                data.data.seasonAttributes.gameModeStats.squad.mostSurvivalTime.toString()
                            ),
                            StatData(
                                getString(R.string.swimDistance),
                                data.data.seasonAttributes.gameModeStats.squad.swimDistance.toString()
                            ),

                            StatDescr(getString(R.string.stat_txt_kills)),
                            StatData(
                                getString(R.string.kills),
                                data.data.seasonAttributes.gameModeStats.squad.kills.toString()
                            ),
                            StatData(
                                getString(R.string.longestKill),
                                data.data.seasonAttributes.gameModeStats.squad.longestKill.toString()
                            ),
                            StatData(
                                getString(R.string.roundMostKills),
                                data.data.seasonAttributes.gameModeStats.squad.roundMostKills.toString()
                            ),
                            StatData(
                                getString(R.string.headshotKills),
                                data.data.seasonAttributes.gameModeStats.squad.headshotKills.toString()
                            ),
                            StatData(
                                getString(R.string.dailyKills),
                                data.data.seasonAttributes.gameModeStats.squad.dailyKills.toString()
                            ),
                            StatData(
                                getString(R.string.weeklyKills),
                                data.data.seasonAttributes.gameModeStats.squad.weeklyKills.toString()
                            ),
                            StatData(
                                getString(R.string.weeklyKills),
                                data.data.seasonAttributes.gameModeStats.squad.weeklyKills.toString()
                            ),
                            StatData(
                                getString(R.string.maxKillStreaks),
                                data.data.seasonAttributes.gameModeStats.squad.maxKillStreaks.toString()
                            ),
                            StatData(
                                getString(R.string.roadKills),
                                data.data.seasonAttributes.gameModeStats.squad.roadKills.toString()
                            ),
                            StatData(
                                getString(R.string.teamKills),
                                data.data.seasonAttributes.gameModeStats.squad.teamKills.toString()
                            ),

                            StatDescr(getString(R.string.stat_txt_other)),
                            StatData(
                                getString(R.string.dBNOs),
                                data.data.seasonAttributes.gameModeStats.squad.dBNOs.toString()
                            ),
                            StatData(
                                getString(R.string.dailyWins),
                                data.data.seasonAttributes.gameModeStats.squad.dailyWins.toString()
                            ),
                            StatData(
                                getString(R.string.boosts),
                                data.data.seasonAttributes.gameModeStats.squad.boosts.toString()
                            ),
                            StatData(
                                getString(R.string.damageDealt),
                                data.data.seasonAttributes.gameModeStats.squad.damageDealt.toString()
                            ),
                            StatData(
                                getString(R.string.days),
                                data.data.seasonAttributes.gameModeStats.squad.days.toString()
                            ),
                            StatData(
                                getString(R.string.heals),
                                data.data.seasonAttributes.gameModeStats.squad.heals.toString()
                            ),
                            StatData(
                                getString(R.string.losses),
                                data.data.seasonAttributes.gameModeStats.squad.losses.toString()
                            ),
                            StatData(
                                getString(R.string.revives),
                                data.data.seasonAttributes.gameModeStats.squad.revives.toString()
                            ),
                            StatData(
                                getString(R.string.rideDistance),
                                data.data.seasonAttributes.gameModeStats.squad.rideDistance.toString()
                            ),
                            StatData(
                                getString(R.string.suicides),
                                data.data.seasonAttributes.gameModeStats.squad.suicides.toString()
                            ),
                            StatData(
                                getString(R.string.vehicleDestroys),
                                data.data.seasonAttributes.gameModeStats.squad.vehicleDestroys.toString()
                            ),
                            StatData(
                                getString(R.string.weaponsAcquired),
                                data.data.seasonAttributes.gameModeStats.squad.weaponsAcquired.toString()
                            )
                        )
                        adapter.setData(statisticsData)
                    }
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }


}






