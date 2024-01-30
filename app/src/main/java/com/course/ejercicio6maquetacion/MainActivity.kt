package com.course.ejercicio6maquetacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.course.ejercicio6maquetacion.Paragraph.ParagraphViewModel
import com.course.ejercicio6maquetacion.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var paragraphViewModel: ParagraphViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        paragraphViewModel = ViewModelProvider(this).get(ParagraphViewModel::class.java)

        paragraphViewModel.randomTextOne.observe(this) { randomText ->
            binding.tvOne.text = randomText
        }
        paragraphViewModel.randomTextTwo.observe(this) { randomText ->
            binding.tvTwo.text = randomText
        }

    }
}