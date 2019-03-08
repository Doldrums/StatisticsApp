package com.example.final_project.players

import com.google.gson.annotations.SerializedName

data class SeasonStatistic(
    @SerializedName("attributes")
    val statisticAttributes: List<Statistics>
):JustInterfaceToAdapter

data class Statistics(
    val statisticAttributes: List<StatAttributes>
)

data class StatAttributes(
    val gameModeStats: List<Gamemode>
)

data class Gamemode(
    val type: String,    //возможные значения: duo, duo-fpp, solo, solo-fpp, squad, squad-fpp,
    val dannie: List<Dannie>                    //TODO("переназвать")
)

data class Dannie(
    val assists: Int,
    val bestRankPoint: Double,
    val boosts: Int,
    val dBNOs: Int,
    val dailyKills: Int,
    val dailyWins: Int,
    val damageDealt: Double,
    val days: Int,
    val headshotKills: Int,
    val heals: Int,
    val killPoints: Int,
    val kills: Int,
    val longestKill: Double,
    val longestTimeSurvived: Double,
    val losses: Int,
    val maxKillStreaks: Int,
    val mostSurvivalTime: Double,
    val rankPoints: Double,
    val rankPointsTitle: String,
    val revives: Int,
    val rideDistance: Double,
    val roadKills: Int,
    val roundMostKills: Int,
    val roundsPlayed: Int,
    val suicides: Int,
    val swimDistance: Double,
    val teamKills: Int,
    val timeSurvived: Double,
    val top10s: Int,
    val vehicleDestroys: Int,
    val walkDistance: Double,
    val weaponsAcquired: Int,
    val weeklyKills: Int,
    val winPoints: Int,
    val wins: Int
)

