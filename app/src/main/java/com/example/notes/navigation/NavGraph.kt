package com.example.notes.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.notes.home.AddNoteScreen
import com.example.notes.home.HomeViewModel
import com.example.notes.home.NotesList

@Composable
fun NavGraph(startDestination:String){

    val navController = rememberNavController()
    val homeViewModel:HomeViewModel = hiltViewModel()
    NavHost(navController, startDestination){
        composable(Route.Home.route){
            NotesList(navController, homeViewModel)
        }
        composable(
           route =  Route.AddNote.route,
            arguments = listOf(
                navArgument(NOTE_KEY){ type= NavType.StringType },
                navArgument(NOTE_STATE_KEY){type= NavType.StringType},
                navArgument(NOTE_ID_KEY){type= NavType.IntType}
            )
        ){
            AddNoteScreen(
             viewModel = homeViewModel,
             navController = navController,
             note = it.arguments?.getString(NOTE_KEY) ?:"",
             state = it.arguments?.getString(NOTE_STATE_KEY)?:"",
             id = it.arguments?.getInt(NOTE_ID_KEY)?:0
            )
        }
    }
}