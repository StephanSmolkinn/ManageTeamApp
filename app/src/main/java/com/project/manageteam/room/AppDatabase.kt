package com.project.manageteam.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.project.manageteam.model.Player
import com.project.manageteam.model.Team

@Database(entities = [Team::class, Player::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getTeamsDao(): TeamsDao

    abstract fun getPlayersDao(): PlayersDao

    companion object {

        @Volatile
        private var _instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return _instance ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    name = "team_database"
                ).build()
                _instance = instance
                instance
            }
        }

    }

}