package com.example.notes.navigation

const val NOTE_KEY = "noteKey"
const val NOTE_STATE_KEY = "noteStateKey"
const val NOTE_ID_KEY = "notIdKey"
sealed class Route (
    val route:String
){

 data object Home : Route("home")
 data object AddNote : Route("addNote/{$NOTE_KEY}/{$NOTE_STATE_KEY}/{$NOTE_ID_KEY}")

}