package com.whatrushka.whowhantbeamillionare.core.domain.questions.api

import com.whatrushka.whowhantbeamillionare.core.domain.questions.api.models.AnswerType
import com.whatrushka.whowhantbeamillionare.core.domain.questions.impl.models.Question
import io.ktor.client.HttpClient

interface ApiService {
    val client: HttpClient

    suspend fun startSession()

    suspend fun finishSession()

    suspend fun fetchQuestions(amount: Int, type: AnswerType): List<Question>
}