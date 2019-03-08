package com.example.final_project.players

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("data")
    val players: List<Player>
)