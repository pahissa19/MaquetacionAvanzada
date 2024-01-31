package com.course.ejercicio6maquetacion.Pager.ViewModel

import androidx.lifecycle.ViewModel
import com.course.ejercicio6maquetacion.Pager.Model.User

import com.course.ejercicio6maquetacion.R

class UserViewModel : ViewModel() {
    val userList = listOf(
        User(
            R.drawable.user1,
            25,
            "Male",
            "Reading, Traveling",
            "I love exploring new places and discovering hidden gems. My favorite genres are science fiction and fantasy. In my free time, I enjoy hiking and trying new cuisines."
        ),
        User(
            R.drawable.user2,
            30,
            "Female",
            "Music, Painting",
            "Passionate about art and creativity. I play the piano and enjoy experimenting with different painting styles. My favorite genres of music are jazz and classical."
        ),
        User(
            R.drawable.user3,
            22,
            "Female",
            "Gaming, Coding",
            "Tech enthusiast and gamer. I spend my weekends coding personal projects and diving into the latest video game releases. Always up for a good LAN party!"
        ),
        User(
            R.drawable.user4,
            28,
            "Male",
            "Hiking, Photography",
            "Nature lover and photographer. I find peace in the great outdoors and love capturing the beauty of landscapes. My camera is my constant companion on hikes and adventures."
        )
    )

}


