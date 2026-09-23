
package com.example.app_grupo4

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.app_grupo4.databinding.ActivityPregunta5Binding
import java.util.Locale

class Pregunta5Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta5Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPregunta5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(view: View?) {

        if (view?.id == binding.btnCalcular.id) {

            val bolsasTexto = binding.etBolsas.text.toString().trim()

            if (bolsasTexto.isEmpty()) {
                binding.tvResultado.text =
                    "Ingrese la cantidad de bolsas."
                return
            }

            val bolsas = bolsasTexto.toIntOrNull()

            if (bolsas == null) {
                binding.tvResultado.text =
                    "Ingrese un número válido."
                return
            }

            if (bolsas < 0) {
                binding.tvResultado.text =
                    "La cantidad no puede ser negativa."
                return
            }

            if (bolsas <= 5) {

                binding.tvResultado.text =
                    "Carga permitida sin costo adicional."

            } else {

                val exceso = bolsas - 5
                val total = 80.00 + (exceso * 15.00)

                binding.tvResultado.text = String.format(
                    Locale.US,
                    "Cantidad ingresada: %d bolsas\n" +
                            "Exceso: %d bolsas\n" +
                            "Total a abonar: S/ %.2f",
                    bolsas,
                    exceso,
                    total
                )
            }
        }
    }
}