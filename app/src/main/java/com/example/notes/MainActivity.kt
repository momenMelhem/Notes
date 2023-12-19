package com.example.notes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import com.example.notes.home.NotesList
import com.example.notes.navigation.NavGraph
import com.example.notes.navigation.Route
import com.example.notes.room.NoteDao

import com.example.notes.ui.theme.NotesTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NotesTheme {
                NavGraph(startDestination = Route.Home.route)
            }
        }
    }
}
