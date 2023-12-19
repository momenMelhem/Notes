package com.example.notes.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert

import androidx.room.Query
import androidx.room.Upsert

@Dao
interface NoteDao {

    @Insert
    suspend fun insertNote (note:NoteEntity)

    @Query("Update NoteEntity set note =:note where id=:id")
    suspend fun updateNote (id:Int,note: String)

    @Delete
    suspend fun deleteNote (noteEntity: NoteEntity)

    @Query ("Select * from NoteEntity")
     fun getAllNotes (): List<NoteEntity>

     @Query ("Select id From NoteEntity where note =:note")
     fun getId(note: String):Int
}