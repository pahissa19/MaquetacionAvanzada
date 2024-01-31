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
        pagerViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        paragraphViewModel.randomTextOne.observe(this) { randomText ->
            binding.tvOne.text = randomText
        }
        paragraphViewModel.randomTextTwo.observe(this) { randomText ->
            binding.tvTwo.text = randomText
        }

        genLastParagraph()
        newText()
        createViewPager()
    }

    private fun newText(){
        binding.btnRandom.setOnClickListener {
            val par1 = paragraphViewModel.generateRandomText()
            val par2 = paragraphViewModel.generateRandomText()

            binding.tvOne.text = par1
            binding.tvTwo.text = par2
        }

        binding.btnRandomTwo.setOnClickListener{
           genLastParagraph()
        }

    }

    private fun genLastParagraph(){
        val par50 = paragraphViewModel.generateRandomText()
        val par120 = paragraphViewModel.generateRandomText()
        val par70 = paragraphViewModel.generateRandomText()

        binding.paragraph1.text = par50
        binding.paragraph2.text = par120
        binding.paragraph3.text = par70
    }

    private fun createViewPager(){
        val userAdapter = UserAdapter(pagerViewModel.userList)
        binding.viewPager.adapter = userAdapter
    }
}