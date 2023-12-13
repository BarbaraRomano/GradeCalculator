package com.example.calculadoradenotas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculadoradenotas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener {

            val nota1 = binding.nota1.text.toString()
            val nota2 = binding.nota2.text.toString()
            val nota3 = binding.nota3.text.toString()
            val nota4 = binding.nota4.text.toString()
            val numFaltas = binding.numFaltas.text.toString()

            if (nota1.isEmpty() || nota2.isEmpty() || nota3.isEmpty() ||
                nota4.isEmpty() || numFaltas.isEmpty()
            ) {
                binding.media.setText("Todos os campos devem ser preenchidos")
            } else {
                calcularNotas(
                    nota1.toInt(),
                    nota2.toInt(),
                    nota3.toInt(),
                    nota4.toInt(),
                    numFaltas.toInt()
                )
            }
        }
    }

    fun calcularNotas(nota1: Int, nota2: Int, nota3: Int, nota4: Int, numFaltas: Int) {

        val faltas = numFaltas

        val media = (nota1 + nota2 + nota3 + nota4) / 4

        if (media < 6 || faltas > 12) {
            binding.media.setText("Reprovado")
        } else if (media >= 6 && faltas <= 12) {
            binding.media.setText("Aprovado")
        }
    }
}
