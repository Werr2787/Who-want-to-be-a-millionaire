package com.whatrushka.whowhantbeamillionare.core.view_model.models.hints.data

import android.content.Context
import com.whatrushka.whowhantbeamillionare.core.view_model.models.game_question.data.GameQuestion
import com.whatrushka.whowhantbeamillionare.core.view_model.models.hints.Hint
import com.whatrushka.whowhantbeamillionare.core.view_model.models.hints.utils.ProbabilityHelper
import com.whatrushka.whowhantbeamillionareteam1.R

class CallToFriend(context: Context) : Hint(
    context = context,
    name = R.string.call_to_friend_name,
    description = R.string.call_to_friend_description,
    icon = R.drawable.call_to_friend
) {
    override fun extendResult(result: String): String {
        return "Друг подсказывает - $result"
    }

    override fun call(question: GameQuestion) {
        if (isUsed().value) return
        super.call(question)

        ProbabilityHelper.returnWithProbability(
            desired = question.questionObject.correctAnswer,
            notDesired = question.questionObject.incorrectAnswers,
            probability = 0.7f
        ).say()
    }

}