package com.project.manageteam.repository

import androidx.lifecycle.LiveData
import com.project.manageteam.model.Team
import com.project.manageteam.room.TeamsDao

class TeamRepository(private val teamsDao: TeamsDao) {

    val allTeams: LiveData<List<Team>> = teamsDao.getAllTeams()

    suspend fun insert(team: Team) = teamsDao.insert(team)

    suspend fun update(team: Team) = teamsDao.update(team)

    suspend fun delete(team: Team) = teamsDao.delete(team)

}