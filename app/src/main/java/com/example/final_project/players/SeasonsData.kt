package com.example.final_project.players

import com.google.gson.annotations.SerializedName

data class SeasonsData(
    @SerializedName("data")
    val season: List<Season>
)

data class Season(
    @SerializedName("attributes")
    val attributes: SeasonAttributes
)


data class SeasonAttributes(
    val isCurrentSeason: Boolean,
    val isOffseason: Boolean
)

