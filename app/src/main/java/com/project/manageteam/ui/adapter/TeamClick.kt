package com.project.manageteam.ui.adapter

import com.project.manageteam.model.Team

interface TeamClick {

    fun teamAddClick(team: Team)

    fun teamDeleteClick(team: Team)

}