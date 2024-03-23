package com.project.manageteam.ui.fragment.create_select_team

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.manageteam.R
import com.project.manageteam.databinding.FragmentTeamBinding
import com.project.manageteam.model.Team
import com.project.manageteam.ui.adapter.TeamAdapter
import com.project.manageteam.ui.adapter.TeamClick
import com.project.manageteam.ui.fragment.home.HomeTeamFragment
import com.project.manageteam.utils.transaction
import com.project.manageteam.viewmodel.TeamViewModel
import com.project.manageteam.viewmodel.TeamViewModelFactory

class TeamFragment : Fragment(), TeamClick {

    private lateinit var binding: FragmentTeamBinding
    private lateinit var viewModel: TeamViewModel
    private lateinit var teamRV: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTeamBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        teamRV = binding.recycleViewTeam
        teamRV.layoutManager = LinearLayoutManager(requireContext())
        val teamRVAdapter = TeamAdapter(requireContext(), this)
        teamRV.adapter = teamRVAdapter

        viewModel = ViewModelProvider(
            owner = requireActivity(),
            factory = TeamViewModelFactory(requireActivity().application)
        )[TeamViewModel::class.java]

        viewModel.allTeams.observe(viewLifecycleOwner, Observer {
            it?.let {
                teamRVAdapter.updateList(it)
            }
        })

        binding.FABAddTeam.setOnClickListener {
            transaction(R.id.containerTeams, AddTeamFragment(), activity as AppCompatActivity, null)
        }
    }

    override fun teamAddClick(team: Team) {
        val argumentsForTeam = Bundle()
        argumentsForTeam.putString("teamType", "Edit")
        argumentsForTeam.putString("teamName", team.teamTitle)
        argumentsForTeam.putString("teamSport", team.teamSport)
        argumentsForTeam.putInt("teamId", team.id)
        transaction(R.id.containerTeams, HomeTeamFragment(), activity as AppCompatActivity, argumentsForTeam)
    }

    override fun teamDeleteClick(team: Team) {
        viewModel.deleteTeam(team)
        Toast.makeText(requireContext(), "${team.teamTitle} Deleted", Toast.LENGTH_LONG).show()
    }

}