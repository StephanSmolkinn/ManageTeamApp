package com.project.manageteam.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.project.manageteam.R
import com.project.manageteam.databinding.TeamRecylerviewItemBinding
import com.project.manageteam.model.Team

class TeamAdapter(
    val context: Context,
    private val teamClick: TeamClick,
) : RecyclerView.Adapter<TeamAdapter.ViewHolder>() {
    
    private val allTeams = ArrayList<Team>()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var binding: TeamRecylerviewItemBinding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.team_recylerview_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = allTeams.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.idTeamName.text = allTeams[position].teamTitle
        holder.binding.idSport.text = allTeams[position].teamSport

        holder.binding.idButtonDelete.setOnClickListener {
            teamClick.teamDeleteClick(allTeams[position])
        }

        holder.itemView.setOnClickListener {
            teamClick.teamAddClick(allTeams[position])
        }
    }

}