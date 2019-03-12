package com.example.final_project.players

import com.google.gson.annotations.SerializedName

data class SeasonsData(
    @SerializedName("data")
    val seasons: List<Season>
)

data class Season(
    val id:String,
    @SerializedName("attributes")
    val attributes: SeasonAttributes

) {
    override fun toString(): String {
        return id
    }
}


data class SeasonAttributes(
    val isCurrentSeason: String,
    val isOffseason: String
)


