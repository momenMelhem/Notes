package com.example.notes.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.room.NoteEntity
import com.example.notes.room.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repo: Repository
) : ViewModel() {
    var note by mutableStateOf("")
    var allNotes by mutableStateOf(listOf<NoteEntity>())
    var noteState by mutableStateOf("")
    var noteObj by mutableStateOf(NoteEntity(note=note))

    fun onAddNoteClick(noteEntity: NoteEntity){

        viewModelScope.launch {
             repo.addNote(noteEntity)
            Log.d("allNotes",allNotes.toString())
            Log.d("repo.getNotes()",repo.getNotes().toString())
        }
        updateNotes()
    }
    fun updateNotes(){
        allNotes = repo.getNotes()
    }
    fun deleteNote(noteEntity: NoteEntity){
        viewModelScope.launch {
            repo.deleteNote(noteEntity)
            updateNotes()
        }
    }
    fun updateNote(id:Int, note:String){
        viewModelScope.launch {
            repo.updateNote(id,note)
        }

        Log.d("allNotes",allNotes.toString())
        Log.d("repo.getNotes()",repo.getNotes().toString())
    }
    fun getId(note:String):Int{
        return repo.getId(note)
    }
}