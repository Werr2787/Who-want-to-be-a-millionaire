package com.whatrushka.whowhantbeamillionare.core.domain.questions.impl.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TokenRequest(
    @SerialName("response_code")
    val responseCode: Int,
    @SerialName("response_message")
    val responseMessage: String,
    val token: String
)
