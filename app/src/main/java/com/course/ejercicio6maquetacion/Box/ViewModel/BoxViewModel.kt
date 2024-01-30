package com.course.ejercicio6maquetacion.Box.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.course.ejercicio6maquetacion.Box.Model.Element
import com.course.ejercicio6maquetacion.R
import kotlin.random.Random

class BoxViewModel : ViewModel() {

    private val _elements = MutableLiveData<List<Element>>()
    val elements: LiveData<List<Element>> get() = _elements

    init {
        generateRandomElements()
    }

    private fun generateRandomElements() {
        val dummyElements = mutableListOf<Element>()

        repeat(Random.nextInt(3, 11)) {
            val randomText = generateRandomText()
            val randomAmount = String.format("%.4f", Random.nextDouble(0.0, 10000.0)).toDouble()
            val randomIcon = R.drawable.money

            dummyElements.add(Element(randomIcon, randomText, randomAmount ))
        }

        _elements.value = dummyElements
    }

    private fun generateRandomText(): String {
        val textLength = Random.nextInt(10, 121)
        val allowedChars = ('a'..'z') + ('A'..'Z') + ' '
        return (1..textLength)
            .map { allowedChars.random() }
            .joinToString("")
    }

}
