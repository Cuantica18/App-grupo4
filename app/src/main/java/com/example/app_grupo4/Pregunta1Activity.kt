package com.example.app_grupo4

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app_grupo4.databinding.ActivityPregunta1Binding

class Pregunta1Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityPregunta1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btncalcular.setOnClickListener(this)
    }

    override fun onClick(p0: View) {
        when (p0.id) {
            R.id.btncalcular -> calcularConsumo()
        }
    }

    fun calcularConsumo() {
        val consumo = binding.etconsumo.text.toString().toDouble()

        if (consumo <= 20) {
            binding.tvresultado.text =
                "Consumo dentro de la asignación regular."
        } else {
            val exceso = consumo - 20
            val recargo = 45 + (exceso * 8.50)
            val recargoFormateado = String.format("%.2f", recargo)

            binding.tvresultado.text =
                "Volumen consumido: $consumo m³\n" +
                        "Exceso: $exceso m³\n" +
                        "Monto total del recargo: S/ $recargoFormateado"
        }
    }
}