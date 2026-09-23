
package com.example.app_grupo4

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.app_grupo4.databinding.ActivityPregunta4Binding
import java.util.Locale

class Pregunta4Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPregunta4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(view: View?) {

        if (view?.id == binding.btnCalcular.id) {

            val datosTexto = binding.etDatos.text.toString().trim()

            if (datosTexto.isEmpty()) {
                binding.tvResultado.text =
                    "Ingrese la cantidad de GB."
                return
            }

            val datos = datosTexto.toDoubleOrNull()

            if (datos == null) {
                binding.tvResultado.text =
                    "Ingrese un número válido."
                return
            }

            if (datos < 0) {
                binding.tvResultado.text =
                    "La cantidad no puede ser negativa."
                return
            }

            if (datos <= 30) {

                binding.tvResultado.text =
                    "Consumo dentro de su plan contratado."

            } else {

                val exceso = datos - 30
                val cobro = 25.00 + (exceso * 6.00)

                binding.tvResultado.text = String.format(
                    Locale.US,
                    "Datos consumidos: %.2f GB\n" +
                            "Exceso de GB: %.2f GB\n" +
                            "Cobro adicional generado: S/ %.2f",
                    datos,
                    exceso,
                    cobro
                )
            }
        }
    }
}