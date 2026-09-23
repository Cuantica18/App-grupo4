
package com.example.app_grupo4

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.app_grupo4.databinding.ActivityPregunta7Binding
import java.util.Locale

class Pregunta7Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta7Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPregunta7Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btncalcular.setOnClickListener(this)
    }

    override fun onClick(p0: View) {
        when(p0.id){
            R.id.btncalcular -> calcularSancion()
        }
    }

    private fun calcularSancion() {

        val textoTemperatura = binding.ettemperatura.text.toString().trim()

        if (textoTemperatura.isEmpty()) {
            binding.ettemperatura.error = "Ingrese una temperatura"
            binding.txtResultado.text = ""
            return
        }

        val temperatura = textoTemperatura.toDoubleOrNull()

        if (temperatura == null) {
            binding.ettemperatura.error = "Ingrese una temperatura válida"
            binding.txtResultado.text = ""
            return
        }

        if (temperatura <= 35) {

            binding.txtResultado.text =
                "Parámetro térmico en norma ambiental."

        } else {

            val exceso = temperatura - 35
            val sancion = 3200 + (450 * exceso)

            val temperaturaFormato = String.format(Locale.US, "%.2f", temperatura)
            val excesoFormato = String.format(Locale.US, "%.2f", exceso)
            val sancionFormato = String.format(Locale.US, "%,.2f", sancion)

            binding.txtResultado.text =
                "Temperatura registrada: $temperaturaFormato °C\n" +
                        "Exceso: $excesoFormato °C\n" +
                        "Sanción total: S/ $sancionFormato"
        }
    }

}