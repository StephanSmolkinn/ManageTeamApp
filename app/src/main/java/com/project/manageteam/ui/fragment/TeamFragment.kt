package com.project.manageteam.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.manageteam.databinding.FragmentTeamBinding
import com.project.manageteam.model.Team
import com.project.manageteam.ui.AddOrEditTeamActivity
import com.project.manageteam.ui.adapter.TeamAdapter
import com.project.manageteam.ui.adapter.TeamClick
import com.project.manageteam.utils.transaction
import com.project.manageteam.viewmodel.TeamViewModel

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
            factory = ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application)
        )[TeamViewModel::class.java]

        viewModel.allTeams.observe(viewLifecycleOwner, Observer {
            it?.let {
                teamRVAdapter.updateList(it)
            }
        })

        binding.FABAddTeam.setOnClickListener {
            val intent = Intent(requireContext(), AddOrEditTeamActivity::class.java)
            startActivity(intent)
        }

    }

    override fun teamAddClick(team: Team) {
        val intent = Intent(requireContext(), AddOrEditTeamActivity::class.java)
        intent.putExtra("teamType", "Edit")
        intent.putExtra("teamName", team.teamTitle)
        intent.putExtra("teamSport", team.teamSport)
        intent.putExtra("teamId", team.id)
        startActivity(intent)
        requireActivity().finish()
    }

    override fun teamDeleteClick(team: Team) {
        viewModel.deleteTeam(team)
        Toast.makeText(requireContext(), "${team.teamTitle} Deleted", Toast.LENGTH_LONG).show()
    }

}