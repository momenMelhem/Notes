package com.example.notes.home

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.notes.home.components.NoteCard
import com.example.notes.navigation.NOTE_KEY
import com.example.notes.navigation.Route

@Composable
fun NotesList(
    navController: NavHostController,
    viewModel: HomeViewModel
){
    val emptyString = " "
    if (viewModel.allNotes.isEmpty()){
        viewModel.updateNotes()
    }
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
            containerColor = Color.White,
                modifier = Modifier
                   .padding(end=32.dp, bottom = 32.dp),
            onClick = {
                viewModel.noteState = "newNote"
                navController.navigate("addNote/ /${viewModel.noteState}/${0}")
            }
        ) {
            Icon(imageVector = Icons.Default.Create, contentDescription = "add note" )
        }
        },
    ){ it ->
        LazyColumn(
            modifier = Modifier
                .padding(it)
        ){
            items(viewModel.allNotes.size) {
                NoteCard(
                    note =  viewModel.allNotes[it].note,
                    onCardClick = {
                        viewModel.noteState = "updateNote"
                        navController.navigate(
                            "addNote/${viewModel.allNotes[it].note}/${viewModel.noteState}/${viewModel.allNotes[it].id}")
                                  },
                    onIconClick = {
                        try {
                            viewModel.deleteNote(viewModel.allNotes[it])
                        }
                        catch (e:IndexOutOfBoundsException){
                            e.printStackTrace()
                        }
                        viewModel.updateNotes()
                        Log.d("viewModel.updateNotes()",viewModel.updateNotes().toString())
                    }
                )


            }
        }
    }
}