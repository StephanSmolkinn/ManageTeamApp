package com.project.manageteam.ui.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.project.manageteam.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private var teamId = -1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val teamType = requireActivity().intent.getStringExtra("teamType")
        val teamName = requireActivity().intent.getStringExtra("teamName")
        val teamSport = requireActivity().intent.getStringExtra("teamSport")
        teamId = requireActivity().intent.getIntExtra("teamId", -1)

        binding.idTeamName.text = teamName
        binding.idTeamSport.text = teamSport
    }

}