package com.project.manageteam.ui.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.project.manageteam.databinding.FragmentHomeTeamBinding
import com.project.manageteam.model.Team
import com.project.manageteam.ui.adapter.FragmentPageAdapter
import com.project.manageteam.utils.constants.Constants
import com.project.manageteam.utils.setupOnBackPressed
import com.project.manageteam.viewmodel.HomeViewModel

class HomeTeamFragment : Fragment() {

    private lateinit var binding: FragmentHomeTeamBinding
    private lateinit var adapter: FragmentPageAdapter
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setupOnBackPressed(activity as AppCompatActivity)
        binding = FragmentHomeTeamBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val team = arguments?.getParcelable<Team>(Constants.TEAM)

        viewModel = ViewModelProvider(owner = requireActivity())[HomeViewModel::class.java]

        viewModel.team.value = team

        adapter = FragmentPageAdapter(requireActivity().supportFragmentManager, requireActivity().lifecycle)

        binding.idTabLayoutHomeTeam.addTab(binding.idTabLayoutHomeTeam.newTab().setText(" Home "))
        binding.idTabLayoutHomeTeam.addTab(binding.idTabLayoutHomeTeam.newTab().setText(" Sport "))

        binding.idViewPager.adapter = adapter

        binding.idTabLayoutHomeTeam.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    binding.idViewPager.currentItem = tab.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

        binding.idViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.idTabLayoutHomeTeam.selectTab(binding.idTabLayoutHomeTeam.getTabAt(position))
            }
        })
    }

}