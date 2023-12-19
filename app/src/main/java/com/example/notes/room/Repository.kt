package com.example.notes.room

class Repository(private val noteDao: NoteDao) {
    suspend fun addNote(noteEntity: NoteEntity){
      noteDao.insertNote(noteEntity)
    }
    suspend fun deleteNote(noteEntity: NoteEntity){
        noteDao.deleteNote(noteEntity)
    }
    suspend fun updateNote(id:Int,note:String){
        noteDao.updateNote(id,note)
    }
     fun getNotes():List<NoteEntity>{
        return noteDao.getAllNotes()
    }
    fun getId(noteString: String):Int{
        return noteDao.getId(noteString)
    }
}