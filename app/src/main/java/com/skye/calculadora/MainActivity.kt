package com.skye.calculadora

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.skye.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button2.setOnClickListener {
            val REQUEST_CODE = 1
            val intent = Intent(this@MainActivity, MainActivity2::class.java)

            // Obtén los valores de las vistas EditText como cadenas de texto
            val numero1Str = binding.editTextNumber.text.toString()
            val numero2Str = binding.editTextNumber2.text.toString()

            // Convierte las cadenas de texto a enteros
            val numero1 = numero1Str.toInt()
            val numero2 = numero2Str.toInt()

            // Pasa los números como extras
            intent.putExtra("numero1", numero1)
            intent.putExtra("numero2", numero2)
            startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                val resultado = data?.getIntExtra("resultado", 0)
                binding.textView.text = resultado.toString()
            }
            if (resultCode == RESULT_CANCELED) {
                binding.textView.text = "Nada seleccionado"
            }
        }
    }
}
