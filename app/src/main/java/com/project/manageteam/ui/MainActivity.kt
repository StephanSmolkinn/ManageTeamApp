package com.project.manageteam.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.project.manageteam.R
import com.project.manageteam.databinding.ActivityMainBinding
import com.project.manageteam.ui.fragment.TeamFragment
import com.project.manageteam.utils.replaceFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}