package com.whatrushka.whowhantbeamillionare.views.navigation

import FinishScreen
import HomeScreen
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.whatrushka.whowhantbeamillionare.core.view_model.QuestionsViewModel
import com.whatrushka.whowhantbeamillionare.views.screens.progress.ProgressScreen
import com.whatrushka.whowhantbeamillionare.views.screens.question.QuestionScreen


@Composable
fun Navigation(viewModel: QuestionsViewModel, modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val scope = rememberCoroutineScope()

    DisposableEffect(Unit) {
        onDispose {
            viewModel.player.stop()
        }
    }

    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ) {
        composable(route = Screen.HomeScreen.route){
            HomeScreen(navController = navController,
                viewModel = viewModel,
                scope = scope,
                modifier = modifier
            )
        }

        composable(route = Screen.ProgressScreen.route){
            ProgressScreen(navController = navController,
                viewModel = viewModel,
                scope = scope,
                modifier = modifier
            )
        }

        composable(route = Screen.QuestionScreen.route){
            QuestionScreen(navController = navController,
                viewModel = viewModel,
                scope = scope,
                modifier = modifier
            )
        }

        composable(route = Screen.FinishScreen.route) {
            FinishScreen(navController = navController,
                viewModel = viewModel,
                scope = scope,
                modifier = modifier
            )
        }
    }
}
