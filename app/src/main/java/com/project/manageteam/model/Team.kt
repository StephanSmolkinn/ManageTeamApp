package com.project.manageteam.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "teams")
class Team(
    @ColumnInfo(name = "title") val teamTitle: String,
    @ColumnInfo(name = "sport") val teamSport: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}