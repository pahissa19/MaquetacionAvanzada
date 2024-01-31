package com.course.ejercicio6maquetacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.course.ejercicio6maquetacion.Pager.Adapter.UserAdapter
import com.course.ejercicio6maquetacion.Pager.ViewModel.UserViewModel
import com.course.ejercicio6maquetacion.Paragraph.ParagraphViewModel
import com.course.ejercicio6maquetacion.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var paragraphViewModel: ParagraphViewModel
    private lateinit var pagerViewModel: UserViewModel



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
        pagerViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        val userAdapter = UserAdapter(pagerViewModel.userList)
        binding.viewPager.adapter = userAdapter

    }
}