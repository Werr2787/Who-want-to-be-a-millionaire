package com.whatrushka.whowhantbeamillionare.core.view_model.models.sound.api

interface SoundService {
    fun start()

    fun beforeResultTimeout()

    fun questionTimer()

    fun correctAnswer()

    fun incorrectAnswer()

    fun winMillion()

    fun stop()
}