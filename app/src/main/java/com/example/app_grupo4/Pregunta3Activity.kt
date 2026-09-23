package com.example.app_grupo4

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app_grupo4.databinding.ActivityPregunta3Binding

class Pregunta3Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta3Binding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityPregunta3Binding.inflate(layoutInflater)
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
            R.id.btncalcular -> calcularCobro()
        }
    }

    fun calcularMontoEstacionamiento(minutos: Int): Double {
        return if (minutos <= 60) {
            0.0
        } else {
            val minutosExceso = minutos - 60
            10.0 + (minutosExceso * 0.50)
        }
    }

    fun calcularCobro() {
        val textoMinutos = binding.etminutos.text.toString().trim()

        if (textoMinutos.isEmpty()) {
            Toast.makeText(this, "Debe ingresar los minutos", Toast.LENGTH_SHORT).show()
            return
        }

        val minutos = textoMinutos.toIntOrNull()
        if (minutos == null || minutos < 0) {
            Toast.makeText(this, "Ingrese un número de minutos válido", Toast.LENGTH_SHORT).show()
            return
        }

        if (minutos <= 60) {
            binding.tvresultado.text = "Estacionamiento cubierto por periodo de cortesía."
        } else {
            val minutosExceso = minutos - 60
            val montoTotal = calcularMontoEstacionamiento(minutos)
            val montoFormateado = String.format("%.2f", montoTotal)
            binding.tvresultado.text = "Tiempo total registrado: $minutos min\nMinutos de exceso: $minutosExceso min\nMonto total a pagar: S/ $montoFormateado"
        }
    }
}