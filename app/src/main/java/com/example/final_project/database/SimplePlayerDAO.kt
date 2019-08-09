package com.example.final_project.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.final_project.database.players.SimplePlayer

@Dao
interface SimplePlayerDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addPlayerToDB(player: SimplePlayer)

    @Query("SELECT * FROM simple_players")
    fun getPlayersFromDB():List<SimplePlayer>

//    @Query("DELETE FROM players WHERE name_field = :name")
//    fun deleteByName(name: String)

}


//
//    @Query("SELECT id,name_field,data_field FROM players")
//    fun selectAll(): List<Player>
//
//    @Query("SELECT id,name_field,data_field FROM players WHERE name_field = :name")
//    fun findByName(name: String): Player
