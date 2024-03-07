package com.project.manageteam.model

import android.media.MediaExtractor.CasInfo
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.PrimaryKey

@Entity(tableName = "players")
class Player(
    @ColumnInfo(name = "name") val playerName: String,
    @ColumnInfo(name = "position") val playerPosition: String,
    @ColumnInfo(name = "shape") val playerShape: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    var teamId: Int = 0
}