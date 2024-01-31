package com.course.ejercicio6maquetacion.Pager

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.course.ejercicio6maquetacion.R

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val userImageView: ImageView = itemView.findViewById(R.id.userImageView)
    val ageTextView: TextView = itemView.findViewById(R.id.ageTextView)
    val sexTextView: TextView = itemView.findViewById(R.id.sexTextView)
    val hobbiesTextView: TextView = itemView.findViewById(R.id.hobbiesTextView)
    val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)

    fun bind(user: User) {
        userImageView.setImageResource(user.imageResId)
        ageTextView.text = "Age: ${user.age}"
        sexTextView.text = "Sex: ${user.sex}"
        hobbiesTextView.text = "Hobbies: ${user.hobbies}"
        descriptionTextView.text = "Description: ${user.description}"
    }
}
