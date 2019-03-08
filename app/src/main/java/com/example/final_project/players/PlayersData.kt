package com.example.final_project.players

import com.google.gson.annotations.SerializedName

data class PlayersData(
    @SerializedName("data")
    val players: List<Player>
)

data class Player(
    val id: String,
    @SerializedName("attributes")
    val attributes: PlayerAttributes
)

data class PlayerAttributes(
    val name: String
)