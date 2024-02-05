package com.course.ejercicio6maquetacion.Paragraph

import androidx.lifecycle.ViewModel
import kotlin.random.Random

class ParagraphViewModel : ViewModel() {

    fun generateRandomText(): String {
        val textLength = Random.nextInt(50, 401)
        val allowedChars = ('a'..'z') + ('A'..'Z') + ' '
        return (1..textLength)
            .map { allowedChars.random() }
            .joinToString("")
    }

}

