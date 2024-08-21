package com.codexcue.takenotes.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("notes")
data class Note(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    val id: Int = 0,
    @ColumnInfo
    val info: String
)
