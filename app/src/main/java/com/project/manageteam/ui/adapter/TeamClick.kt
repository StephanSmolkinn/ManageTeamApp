package com.project.manageteam.ui.adapter

import com.project.manageteam.model.Team

interface TeamClick {

    fun teamClick(team: Team)

    fun teamDeleteClick(team: Team)

}