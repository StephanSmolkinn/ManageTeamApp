package com.project.manageteam.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.manageteam.model.Team

class HomeViewModel : ViewModel() {

    private val _team = MutableLiveData<Team>()
    val team
        get() = _team

}