package com.whatrushka.whowhantbeamillionare.core.view_model.models.game_question.data

sealed class AnswerResult {
    data object Success : AnswerResult()
    data object Fail : AnswerResult()
}