package com.whatrushka.whowhantbeamillionare.views.screens.progress

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.whatrushka.whowhantbeamillionare.core.view_model.QuestionsViewModel
import com.whatrushka.whowhantbeamillionare.views.navigation.Screen
import com.whatrushka.whowhantbeamillionare.views.screens.progress.ui.ProgressList
import com.whatrushka.whowhantbeamillionare.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

@Composable
fun ProgressScreen(
    navController: NavController,
    viewModel: QuestionsViewModel,
    scope: CoroutineScope,
    modifier: Modifier = Modifier
) {
    val questions = viewModel.getQuestions()
    val currentQuestion = viewModel.getCurrentQuestion()

    LaunchedEffect(key1 = questions.value) {
        questions.value?.let {
            delay(5000)
            runBlocking {
                if ((currentQuestion?.first ?: 0) == 15 ||
                    viewModel.lastAnsweredQuestion()?.second?.answeredCorrectly == false
                ) {
                    navController.navigate(Screen.FinishScreen.route)
                } else {
                    navController.navigate(Screen.QuestionScreen.route)
                }
            }
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_without_text),
            contentDescription = null,
            modifier = Modifier
                .height(240.dp)
                .fillMaxWidth()
                .zIndex(2f)
        )

        questions.value?.let {
            ProgressList(questions = it.toList())
        }
    }
}