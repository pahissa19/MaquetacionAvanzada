package com.course.ejercicio6maquetacion.Box.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.course.ejercicio6maquetacion.Box.ViewModel.BoxViewModel
import com.course.ejercicio6maquetacion.R
import com.course.ejercicio6maquetacion.databinding.FragmentBoxBinding
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

class BoxFragment : Fragment() {

    private lateinit var binding: FragmentBoxBinding
    private lateinit var viewModel: BoxViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBoxBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(BoxViewModel::class.java)

        viewModel.elements.observe(viewLifecycleOwner) { elements ->
            binding.boxContainer.removeAllViews()

            for (element in elements) {
                val elementView = inflater.inflate(R.layout.item_element, binding.boxContainer, false)

                val iconImageView = elementView.findViewById<ImageView>(R.id.iconImageView)
                val textTextView = elementView.findViewById<TextView>(R.id.textTextView)
                val amountTextView = elementView.findViewById<TextView>(R.id.amountTextView)

                iconImageView.setImageResource(element.icon)
                textTextView.text = element.text
                amountTextView.text = formatCurrency(element.amount)

                binding.boxContainer.addView(elementView)
            }
        }

        return binding.root
    }

    private fun formatCurrency(amount: Double): String {
        val decimalFormat = DecimalFormat("#,##0.00", DecimalFormatSymbols(Locale.getDefault()))

        decimalFormat.currency = Currency.getInstance("EUR")

        return "${decimalFormat.format(amount)} ${decimalFormat.currency?.symbol}"
    }
}



