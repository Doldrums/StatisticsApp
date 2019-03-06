package com.example.final_project.players

import com.google.gson.annotations.SerializedName

class Data {
    @SerializedName("data")
    lateinit var players: List<Player>
}