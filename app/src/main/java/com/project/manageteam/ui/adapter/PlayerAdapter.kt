package com.project.manageteam.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.project.manageteam.R
import com.project.manageteam.model.Player

class PlayerAdapter(val context: Context) : RecyclerView.Adapter<PlayerAdapter.ViewHolder>() {

    var allPlayers = ArrayList<Player>()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val idPlayerName = itemView.findViewById<TextView>(R.id.idPlayerName)
        val idPlayerPosition = itemView.findViewById<TextView>(R.id.idPosition)
        val idButtonDelete = itemView.findViewById<ShapeableImageView>(R.id.idButtonDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.player_recyclerview_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = allPlayers.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        
    }

}