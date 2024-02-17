package com.project.manageteam.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.manageteam.model.Team
import com.project.manageteam.repository.TeamRepository
import com.project.manageteam.room.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TeamViewModel : ViewModel() {

    private val context = MutableLiveData<Context>()
    lateinit var repository: TeamRepository
    lateinit var allTeams: LiveData<List<Team>>

    init {
        context.observeForever {
            val dao = AppDatabase.getDatabase(it).getTeamsDao()
            repository = TeamRepository(dao)
            allTeams = repository.allTeams
        }
    }

    fun addTeam(team: Team) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(team)
    }

    fun updateTeam(team: Team) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(team)
    }

    fun deleteTeam(team: Team) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(team)
    }

}