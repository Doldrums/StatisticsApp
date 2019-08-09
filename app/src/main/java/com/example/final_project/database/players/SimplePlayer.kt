package com.example.final_project.database.players

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "simple_players")
data class SimplePlayer(
    @ColumnInfo(name = "name_field")val name: String,
    @PrimaryKey
    @ColumnInfo(name = "id_field")val id: String
)

fun dataToPlayer(playerData: PlayerData): SimplePlayer {
    return SimplePlayer(playerData.player.last().attributes.name, playerData.player.last().id)
}