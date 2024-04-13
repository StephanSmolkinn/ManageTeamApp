package com.project.manageteam.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "teams")
class Team(
    @ColumnInfo(name = "title")
    val teamTitle: String,
    @ColumnInfo(name = "sport")
    val teamSport: String
) : Parcelable {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}