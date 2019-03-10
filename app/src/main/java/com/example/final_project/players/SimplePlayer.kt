package com.example.final_project.players

data class SimplePlayer(
    val name: String,
    val id: String
)

fun dataToPlayer(playerData: PlayerData): SimplePlayer {
    return SimplePlayer(playerData.player.last().attributes.name, playerData.player.last().id)
}