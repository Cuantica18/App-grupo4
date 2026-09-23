package com.example.app_grupo4

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app_grupo4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnpregunta1.setOnClickListener(this)
        binding.btnpregunta2.setOnClickListener(this)
        binding.btnpregunta3.setOnClickListener(this)
        binding.btnpregunta4.setOnClickListener(this)
        binding.btnpregunta5.setOnClickListener(this)
        binding.btnpregunta6.setOnClickListener(this)
        binding.btnpregunta7.setOnClickListener(this)

    }

    override fun onClick(p0: View) {
        when (p0.id) {
            R.id.btnpregunta1 -> irPregunta1()
            R.id.btnpregunta2 -> irPregunta2()
            R.id.btnpregunta3 -> irPregunta3()
            R.id.btnpregunta4 -> irPregunta4()
            R.id.btnpregunta5 -> irPregunta5()
            R.id.btnpregunta6 -> irPregunta6()
            R.id.btnpregunta7 -> irPregunta7()
        }
    }

    fun irPregunta1() {
        startActivity(Intent(this, Pregunta1Activity::class.java))
    }

    fun irPregunta2() {
        startActivity(Intent(this, Pregunta2Activity::class.java))
    }

    fun irPregunta3() {
        startActivity(Intent(this, Pregunta3Activity::class.java))
    }

    fun irPregunta4() {
        startActivity(Intent(this, Pregunta4Activity::class.java))
    }

    fun irPregunta5() {
        startActivity(Intent(this, Pregunta5Activity::class.java))
    }

    fun irPregunta6() {
        startActivity(Intent(this, Pregunta6Activity::class.java))
    }


    fun irPregunta7() {
        startActivity(Intent(this, Pregunta7Activity::class.java))
    }

}