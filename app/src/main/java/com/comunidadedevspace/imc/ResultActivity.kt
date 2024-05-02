package com.comunidadedevspace.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)

        tvResult.text = result.toString()

        var classificacao: String = if (result <= 18.5f) {
            "MAGREZA"
        } else if (result > 18.5f && result <= 24.9f) {
            "NORMAL"
        } else if (result > 25f && result <= 29.9f) {
            "SOBREPESO"
        } else if (result > 30f && result <= 39.9f) {
            "OBESIDADE"
        } else {
            "OBESIDADE GRAVE"
        }

        val color = when (classificacao) {
            "MAGREZA" -> R.color.magreza
            "NORMAL" -> R.color.normal
            "SOBREPESO" -> R.color.sobrepeso
            "OBESIDADE" -> R.color.obesidade
            else -> R.color.obesidade_grave
        }

        tvClassificacao.setTextColor(getColor(color))
        tvClassificacao.text = classificacao

    }
}