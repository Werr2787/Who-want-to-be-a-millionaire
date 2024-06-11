package com.whatrushka.whowhantbeamillionare.core.view_model.models.game_question.utils

import com.whatrushka.whowhantbeamillionare.core.domain.questions.impl.models.Question
import com.whatrushka.whowhantbeamillionare.core.view_model.models.game_question.data.GameQuestion
import com.whatrushka.whowhantbeamillionare.core.view_model.models.game_question.utils.HtmlParse.htmlToBase

fun Question.toGameQuestion(price: Int, checkpoint: Boolean = false) = GameQuestion(
    price = price,
    checkpoint = checkpoint,
    questionObject = this.also {
        it.question = it.question.htmlToBase()
        it.correctAnswer = it.correctAnswer.htmlToBase()
        it.incorrectAnswers = it.incorrectAnswers.map { ans -> ans.htmlToBase() }
    }
)