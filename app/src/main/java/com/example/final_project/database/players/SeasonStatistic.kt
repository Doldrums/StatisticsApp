package com.example.final_project.database.players

import com.google.gson.annotations.SerializedName

data class SeasonStatsData(
    @SerializedName("data")
    val data:SeasonStatistic
)

data class SeasonStatistic(
    val type: String,
    @SerializedName("attributes")
    val seasonAttributes: StatAttributes
)


data class StatAttributes(
    val gameModeStats: Gamemode
)

data class Gamemode(
    @SerializedName("duo")
    val duo: Dannie ,
    @SerializedName("duo-fpp")
    val duo_fpp: Dannie,
    @SerializedName("solo")
    val solo: Dannie,
    @SerializedName("solo-fpp")
    val solo_fpp: Dannie,
    @SerializedName("squad")
    val squad: Dannie,
    @SerializedName("squad-fpp")
    val squad_fpp: Dannie

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


