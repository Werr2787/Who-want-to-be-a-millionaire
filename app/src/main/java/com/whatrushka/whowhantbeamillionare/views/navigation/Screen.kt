package com.whatrushka.whowhantbeamillionare.views.navigation

sealed class Screen (
    val route: String
){
    data object HomeScreen : Screen ("home_Screen")
    data object ProgressScreen : Screen ("progress_Screen")
    data object QuestionScreen : Screen ("question_screen")
    data object FinishScreen : Screen ("finish_screen")
}