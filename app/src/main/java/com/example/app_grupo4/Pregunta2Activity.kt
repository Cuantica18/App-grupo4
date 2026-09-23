package com.example.app_grupo4

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.app_grupo4.databinding.ActivityPregunta2Binding
import java.util.Locale

class Pregunta2Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPregunta2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.btnCalcular.id -> calcularRecargo()
        }
    }

    private fun calcularRecargo() {
        val textoConsumo = binding.etConsumo.text.toString().trim()

        if (textoConsumo.isEmpty()) {
            binding.etConsumo.error = "Ingrese el consumo en kWh"
            binding.tvResultado.text = ""
            return
        }

        val consumo = textoConsumo.toDoubleOrNull()
        if (consumo == null) {
            binding.etConsumo.error = "Ingrese un número válido"
            binding.tvResultado.text = ""
            return
        }

        if (consumo < 0) {
            binding.etConsumo.error = "El consumo no puede ser negativo"
            binding.tvResultado.text = ""
            return
        }

        if (consumo <= 150) {
            binding.tvResultado.text = "Consumo eficiente sin sobrecosto."
        } else {
            val exceso = consumo - 150.0

            val recargo = 60.00 + (1.80 * exceso)

            binding.tvResultado.text = String.format(
                Locale.US,
                "Consumo ingresado: %.2f kWh\nExceso: %.2f kWh\nMonto total a pagar por recargo: S/ %.2f",
                consumo,
                exceso,
                recargo
            )
        }
    }
}
