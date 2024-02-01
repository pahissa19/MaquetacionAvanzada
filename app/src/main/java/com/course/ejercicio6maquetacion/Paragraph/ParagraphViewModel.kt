package com.course.ejercicio6maquetacion.Paragraph

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class ParagraphViewModel : ViewModel() {

    private val _randomTextOne = MutableLiveData<String>()
    val randomTextOne: LiveData<String> get() = _randomTextOne

    private val _randomTextTwo = MutableLiveData<String>()
    val randomTextTwo: LiveData<String> get() = _randomTextTwo

    init {
        generateTexts()
    }

    private fun generateTexts() {
        _randomTextOne.value = generateRandomText()
        _randomTextTwo.value = generateRandomText()
    }


    fun generateRandomText(): String {
        val textLength = Random.nextInt(50, 401)
        val allowedChars = ('a'..'z') + ('A'..'Z') + ' '
        return (1..textLength)
            .map { allowedChars.random() }
            .joinToString("")
    }


}

