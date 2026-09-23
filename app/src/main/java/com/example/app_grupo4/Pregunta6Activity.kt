package com.example.app_grupo4

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.app_grupo4.databinding.ActivityPregunta6Binding
import java.util.Locale

class Pregunta6Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta6Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPregunta6Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(view: View?) {

        if (view?.id == binding.btnCalcular.id) {

            val horasTexto = binding.etHoras.text.toString().trim()

            if (horasTexto.isEmpty()) {
                binding.tvResultado.text =
                    "Ingrese la cantidad de horas."
                return
            }

            val horas = horasTexto.toIntOrNull()

            if (horas == null) {
                binding.tvResultado.text =
                    "Ingrese un número válido."
                return
            }

            if (horas < 0) {
                binding.tvResultado.text =
                    "La cantidad no puede ser negativa."
                return
            }

            if (horas <= 8) {

                binding.tvResultado.text =
                    "Horas cubiertas por la membresía mensual."

            } else {

                val exceso = horas - 8
                val total = 50.00 + (exceso * 35.00)

                binding.tvResultado.text = String.format(
                    Locale.US,
                    "Horas totales: %d horas\n" +
                            "Horas excedentes: %d horas\n" +
                            "Monto extra a facturar: S/ %.2f",
                    horas,
                    exceso,
                    total
                )
            }
        }
    }
}