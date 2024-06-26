package com.whatrushka.whowhantbeamillionare.core.view_model.models.hints.data

import android.content.Context
import com.whatrushka.whowhantbeamillionare.core.view_model.models.game_question.data.GameQuestion
import com.whatrushka.whowhantbeamillionare.core.view_model.models.hints.Hint
import com.whatrushka.whowhantbeamillionare.R

class FiftyFifty(context: Context) : Hint(
    context = context,
    name = R.string.fifty_fifty_name,
    description = R.string.fifty_fifty_description,
    icon = R.drawable.fifty_fifty
) {
    override fun extendResult(result: String): String = ""

    override fun call(question: GameQuestion) {
        if (isUsed().value) return
        super.call(question)

        val willBeRemoved = question
            .questionObject
            .incorrectAnswers
            .shuffled()
            .take(2)

        mutableListOf<String>().also { list ->
            question.getAnswers().value?.forEach {
                list.add(
                    if (it in willBeRemoved) ""
                    else it
                )
            }
        }.also { question.updateAnswers(it) }
    }

}