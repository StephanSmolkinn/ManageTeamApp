package com.project.manageteam.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.manageteam.model.Player
import com.project.manageteam.model.Team
import com.project.manageteam.repository.PlayerRepository
import com.project.manageteam.repository.TeamRepository
import com.project.manageteam.room.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlayerViewModel(application: Application) : ViewModel() {

    private var repository: PlayerRepository
    var allPlayers: LiveData<List<Player>>

    init {
        val dao = AppDatabase.getDatabase(application).getPlayersDao()
        repository = PlayerRepository(dao)
        allPlayers = repository.allPlayers
    }

    fun addPlayer(player: Player) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(player)
    }

    fun updatePlayer(player: Player) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(player)
    }

    fun deletePlayer(player: Player) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(player)
    }

}