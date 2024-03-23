package com.project.manageteam.ui.fragment.create_select_team

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.project.manageteam.R
import com.project.manageteam.databinding.FragmentAddTeamBinding
import com.project.manageteam.model.Team
import com.project.manageteam.utils.transaction
import com.project.manageteam.viewmodel.TeamViewModel
import com.project.manageteam.viewmodel.TeamViewModelFactory

class AddTeamFragment : Fragment() {

    private lateinit var binding: FragmentAddTeamBinding
    private lateinit var viewModel: TeamViewModel
    private var teamId = -1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddTeamBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(
            owner = requireActivity(),
            factory = TeamViewModelFactory(requireActivity().application)
        )[TeamViewModel::class.java]

        val teamType = requireActivity().intent.getStringExtra("teamType")

        binding.idButtonAddTeam.text = "Add Team"

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
            transaction(R.id.containerTeams, TeamFragment(), activity as AppCompatActivity, null)
        }
    }

}