package com.course.ejercicio6maquetacion.Box

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.course.ejercicio6maquetacion.R
import com.course.ejercicio6maquetacion.databinding.FragmentBoxBinding
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.text.NumberFormat
import java.util.*

class BoxFragment : Fragment() {

    private lateinit var binding: FragmentBoxBinding
    private lateinit var viewModel: BoxViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_box, container, false)
        viewModel = ViewModelProvider(this).get(BoxViewModel::class.java)

        // Observa los cambios en la lista de elementos y actualiza la interfaz de usuario
        viewModel.elements.observe(viewLifecycleOwner) { elements ->
            binding.boxContainer.removeAllViews()

            // Iterar a través de los elementos y agregar vistas al contenedor
            for (element in elements) {
                val elementView = inflater.inflate(R.layout.item_element, binding.boxContainer, false)

                // Obtener referencias a las vistas del elemento
                val iconImageView = elementView.findViewById<ImageView>(R.id.iconImageView)
                val textTextView = elementView.findViewById<TextView>(R.id.textTextView)
                val amountTextView = elementView.findViewById<TextView>(R.id.amountTextView)

                // Asignar valores a las vistas del elemento
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



