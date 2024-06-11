package com.whatrushka.whowhantbeamillionare.core.view_model.models.game_question.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.whatrushka.whowhantbeamillionare.core.domain.questions.impl.models.Question

data class GameQuestion(
    val price: Int,
    var answered: Boolean = false,
    var answeredCorrectly: Boolean? = null,
    val checkpoint: Boolean = false,
    val questionObject: Question
) {
    private var _answers = mutableStateOf<List<String>?>(null)

    private fun initAnswers() {
        _answers.value = mutableListOf(questionObject.correctAnswer)
            .also {
                it.addAll(questionObject.incorrectAnswers)
            }.shuffled()
    }

    fun getAnswers(): MutableState<List<String>?> {
        _answers.value?.let { return _answers }
        initAnswers()
        return _answers
    }

    fun updateAnswers(updatedAnswers: List<String>) {
        _answers.value = updatedAnswers
    }
}

