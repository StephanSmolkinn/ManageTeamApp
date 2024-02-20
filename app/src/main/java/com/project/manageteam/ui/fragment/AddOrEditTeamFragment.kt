package com.project.manageteam.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.project.manageteam.databinding.FragmentAddOrEditTeamBinding
import com.project.manageteam.model.Team
import com.project.manageteam.ui.MainActivity
import com.project.manageteam.viewmodel.TeamViewModel

class AddOrEditTeamFragment : Fragment() {

    lateinit var binding: FragmentAddOrEditTeamBinding
    lateinit var viewModel: TeamViewModel
    private var teamId = -1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddOrEditTeamBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(
            owner = requireActivity(),
            factory = ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application)
        )[TeamViewModel::class.java]

        val teamType = requireActivity().intent.getStringExtra("teamType")
        if (teamType.equals("Edit")) {
            val teamName = requireActivity().intent.getStringExtra("teamName")
            val teamSport = requireActivity().intent.getStringExtra("teamSport")
            teamId = requireActivity().intent.getIntExtra("teamId", -1)

            binding.idButtonAddTeam.text = "Update Team"
            binding.idEditTeamName.setText(teamName)
            binding.idEditTeamSport.setText(teamSport)
        } else {
            binding.idButtonAddTeam.text = "Add Team"
        }

        binding.idButtonAddTeam.setOnClickListener {
            val teamName = binding.idEditTeamName.text.toString()
            val teamSport = binding.idEditTeamSport.text.toString()

            if (teamType.equals("Edit")) {
                if (teamName.isNotEmpty() && teamSport.isNotEmpty()) {
                    val updateTeam = Team(teamName, teamSport)
                    updateTeam.id = teamId
                    viewModel.updateTeam(updateTeam)
                    Toast.makeText(requireContext(), "Team updated", Toast.LENGTH_LONG).show()
                }
            } else {
                if (teamName.isNotEmpty() && teamSport.isNotEmpty()) {
                    val addTeam = Team(teamName, teamSport)
                    viewModel.addTeam(addTeam)
                    Toast.makeText(requireContext(), "Team created", Toast.LENGTH_LONG).show()
                }
            }
            startActivity(Intent(requireContext(), MainActivity::class.java))
        }
    }

}