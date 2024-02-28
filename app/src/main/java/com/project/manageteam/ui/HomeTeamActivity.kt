package com.project.manageteam.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.project.manageteam.databinding.ActivityHomeTeamBinding
import com.project.manageteam.ui.fragment.home.FragmentPageAdapter

class HomeTeamActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeTeamBinding
    private lateinit var adapter: FragmentPageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeTeamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                finish()
            }
        })

        adapter = FragmentPageAdapter(supportFragmentManager, lifecycle)

        binding.idTabLayoutHomeTeam.addTab(binding.idTabLayoutHomeTeam.newTab().setText("Home"))
        binding.idTabLayoutHomeTeam.addTab(binding.idTabLayoutHomeTeam.newTab().setText("Players"))

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