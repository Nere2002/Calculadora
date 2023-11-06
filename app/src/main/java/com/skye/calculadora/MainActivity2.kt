package com.skye.calculadora

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.skye.calculadora.databinding.ActivityMain2Binding


class MainActivity2 : AppCompatActivity() {

    lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        // Obtén los valores pasados como extras como enteros
        val numero1 = intent.getIntExtra("numero1", 0)
        val numero2 = intent.getIntExtra("numero2", 0)
        binding.textView2.text = numero1.toString()
        binding.textView3.text = numero2.toString()

        binding.resultado.setOnClickListener {
            val resultado: Int = numero1 + numero2

            // Crea un intent para devolver el resultado a la actividad principal
            val resultIntent = Intent()
            resultIntent.putExtra("resultado", resultado)

            // Establece el resultado y finaliza la actividad actual
            setResult(RESULT_OK, resultIntent)
            finish()
        }


    }

}