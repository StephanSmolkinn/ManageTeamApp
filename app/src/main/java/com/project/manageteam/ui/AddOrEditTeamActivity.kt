package com.project.manageteam.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.project.manageteam.databinding.ActivityAddOrEditTeamBinding


class AddOrEditTeamActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddOrEditTeamBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddOrEditTeamBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}