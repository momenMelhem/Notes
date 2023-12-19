package com.example.notes.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NoteEntity(
    @PrimaryKey (autoGenerate = true)
    val id:Int =0,
    var note:String
)
