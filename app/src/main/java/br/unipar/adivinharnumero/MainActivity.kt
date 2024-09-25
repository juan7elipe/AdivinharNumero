package br.unipar.adivinharnumero

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var randomNumero: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        randomNumero = Random.nextInt(1, 101)

        val inputNumero = findViewById<EditText>(R.id.edNumero)
        val botaoResultado = findViewById<Button>(R.id.btnResultado)
        val resultado = findViewById<TextView>(R.id.txtResultado)


        botaoResultado.setOnClickListener {
            val chute = inputNumero.text.toString().toIntOrNull()
            if (chute != null) {

                when {
                    chute < randomNumero -> resultado.text = "Seu palpite é muito baixo."
                    chute > randomNumero -> resultado.text = "Seu palpite é muito alto."
                    else -> {
                        resultado.text = "Parabéns! Você acertou."
                        // Gera um novo número aleatório após a vitória
                        randomNumero = Random.nextInt(1, 101)
                    }
                }
            } else {
                resultado.text = "Por favor, insira um número válido."
            }
        }
    }

    private fun setContentView(activityMain: Any) {

    }
}
