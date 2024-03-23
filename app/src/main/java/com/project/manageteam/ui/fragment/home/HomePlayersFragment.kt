package com.project.manageteam.ui.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.room.InvalidationTracker
import com.project.manageteam.databinding.FragmentHomeBinding
import com.project.manageteam.databinding.FragmentHomePlayersBinding
import com.project.manageteam.model.Team
import com.project.manageteam.viewmodel.HomeViewModel
import com.project.manageteam.viewmodel.TeamViewModel
import com.project.manageteam.viewmodel.TeamViewModelFactory

class HomePlayersFragment : Fragment() {

    private lateinit var binding: FragmentHomePlayersBinding
    private lateinit var playerViewModel: TeamViewModel
    private val homeViewModel: HomeViewModel by activityViewModels()
    private var teamId = -1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomePlayersBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.idTeamName.text = homeViewModel.team.value?.teamTitle
        binding.idTeamSport.text = homeViewModel.team.value?.teamSport
    }

}