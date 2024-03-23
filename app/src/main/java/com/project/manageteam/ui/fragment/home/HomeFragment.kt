package com.project.manageteam.ui.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.project.manageteam.databinding.FragmentHomeBinding
import com.project.manageteam.viewmodel.HomeViewModel
import com.project.manageteam.viewmodel.PlayerViewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var playerViewModel: PlayerViewModel
    private lateinit var playerRV: RecyclerView
    private val homeViewModel: HomeViewModel by activityViewModels()

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

        binding.idTeamName.text = homeViewModel.team.value?.teamTitle
    }

}