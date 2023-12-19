package com.example.notes.home

import android.util.Log
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.notes.home.components.NoteTextField
import com.example.notes.navigation.Route
import com.example.notes.room.NoteEntity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNoteScreen(
    viewModel: HomeViewModel,
    navController: NavHostController,
    note:String,
    state:String,
    id:Int
){
    //var textFieldValue by remember { mutableStateOf(note) }

    viewModel.note=note



    Scaffold (
        modifier =Modifier
            .padding(bottom = 4.dp),
        topBar = {
        CenterAlignedTopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = {
                     //   viewModel.noteObj.note=viewModel.note
                        when(state){

                            "newNote"->{
                                if (viewModel.note.isNotBlank()) {
                                    viewModel.onAddNoteClick((NoteEntity(note=viewModel.note)))
                                }
                                viewModel.updateNotes()
                            }
                            "updateNote"->{
                                viewModel.updateNote(id,viewModel.note )
                                Log.d("id",id.toString())
                                viewModel.updateNotes()
                            }
                        }
                        navController.navigate(Route.Home.route)
                    }
                    ){
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                    }
                }
            )
        }
    ) {
        NoteTextField(
            modifier = Modifier.padding(it),
            value = viewModel.note,
            onValueChange = { value->
                viewModel.note=value
            }
        )
    }

}