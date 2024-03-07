package com.project.manageteam.repository

import androidx.lifecycle.LiveData
import com.project.manageteam.model.Player
import com.project.manageteam.room.PlayersDao

class PlayerRepository(private val playersDao: PlayersDao) {

    val allPlayers: LiveData<List<Player>> = playersDao.getAllPlayers()

    suspend fun insert(player: Player) = playersDao.insert(player)

    suspend fun update(player: Player) = playersDao.update(player)

    suspend fun delete(player: Player) = playersDao.delete(player)

}