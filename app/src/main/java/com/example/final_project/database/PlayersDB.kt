package com.example.final_project.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.final_project.database.players.SimplePlayer


@Database(
    entities = [SimplePlayer::class],
    version = 1
)
abstract class PlayersDB : RoomDatabase() {
    abstract fun simplePlayerDAO(): SimplePlayerDAO

    fun createDatabase(context: Context) {
        Room.databaseBuilder(context.applicationContext, PlayersDB::class.java, "players.db")
            .allowMainThreadQueries().build()
    }
}
