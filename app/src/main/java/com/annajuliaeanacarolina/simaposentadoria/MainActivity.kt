package com.annajuliaeanacarolina.simaposentadoria

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.annajuliaeanacarolina.simaposentadoria.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val generos = listOf("Feminino", "Masculino")

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            generos
        )

        adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )

        binding.spnGenero.adapter = adapter

        binding.btnCalcular.setOnClickListener {

            val idade = binding.edtIdade.text.toString().toInt()

            val genero = binding.spnGenero.selectedItem.toString()

            var idadeMinima = 0

            if (genero == "Masculino") {
                idadeMinima = 65
            } else {
                idadeMinima = 62
            }

            val resultado = idadeMinima - idade

            if (resultado < 0) {

                binding.txtResultado.text =
                    getString(R.string.ja_aposentado)

            } else {

                binding.txtResultado.text =
                    getString(R.string.tempo_restante, resultado)
            }
        }
    }
}