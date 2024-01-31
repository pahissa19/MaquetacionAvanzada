package com.course.ejercicio6maquetacion.Pager

import androidx.lifecycle.ViewModel

import com.course.ejercicio6maquetacion.R

class UserViewModel : ViewModel() {
    val userList = listOf(
        User(R.drawable.ic_launcher_foreground, 25, "Male", "Reading, Traveling", "I love exploring new places."),
        User(R.drawable.ic_launcher_foreground, 30, "Female", "Music, Painting", "Passionate about art and creativity."),
        User(R.drawable.ic_launcher_foreground, 22, "Non-Binary", "Gaming, Coding", "Tech enthusiast and gamer."),
        User(R.drawable.ic_launcher_foreground, 28, "Male", "Hiking, Photography", "Nature lover and photographer.")
    )
}


