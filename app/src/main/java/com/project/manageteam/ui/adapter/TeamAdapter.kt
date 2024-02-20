package com.project.manageteam.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.project.manageteam.R
import com.project.manageteam.model.Team

class TeamAdapter(
    val context: Context,
    private val teamClick: TeamClick,
) : RecyclerView.Adapter<TeamAdapter.ViewHolder>() {
    
    val allTeams = ArrayList<Team>()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val idTeamName = itemView.findViewById<TextView>(R.id.idTeamName)
        val idSport = itemView.findViewById<TextView>(R.id.idSport)
        val idButtonDelete = itemView.findViewById<ShapeableImageView>(R.id.idButtonDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.team_recylerview_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = allTeams.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.idTeamName.text = allTeams[position].teamTitle
        holder.idSport.text = allTeams[position].teamSport

        holder.idButtonDelete.setOnClickListener {
            teamClick.teamDeleteClick(allTeams[position])
        }

        holder.itemView.setOnClickListener {
            teamClick.teamAddClick(allTeams[position])
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: List<Team>) {
        allTeams.clear()
        allTeams.addAll(newList)
        notifyDataSetChanged()
    }

}