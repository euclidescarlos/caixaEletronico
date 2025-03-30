package com.example.caixaeletronico

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {


    private var saldo = 1020.0  // Saldo inicial

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referências para os elementos da UI
        val saldoTextView: TextView = findViewById(R.id.saldoTextView)
        val valorEditText: EditText = findViewById(R.id.valorEditText)
        val sacarButton: Button = findViewById(R.id.sacarButton)
        val depositarButton: Button = findViewById(R.id.depositarButton)

        // Atualiza o saldo inicial na tela
        atualizarSaldo(saldoTextView)

        // Lógica do botão de saque
        sacarButton.setOnClickListener {
            val valor = valorEditText.text.toString().toDoubleOrNull()
            if (valor != null && valor > 0 && valor <= saldo) {
                saldo -= valor
                atualizarSaldo(saldoTextView)
            } else {
                saldoTextView.text = "Saldo insuficiente"
            }
        }

        // Lógica do botão de depósito
        depositarButton.setOnClickListener {
            val valor = valorEditText.text.toString().toDoubleOrNull()
            if (valor != null && valor > 0 && valor <= 1000) {
                saldo += valor
                atualizarSaldo(saldoTextView)
            } else {
                saldoTextView.text = "Valor inválido para depósito \n      valor máx = R$ 1000."
            }
        }
    }


    // Função para atualizar o saldo na tela
    private fun atualizarSaldo(textView: TextView) {
        textView.text = "Saldo: R$ %.2f".format(saldo)

    val btnSair = findViewById<Button>(R.id.btnSair)
    btnSair.setOnClickListener {
        finish() // Fecha a MainActivity e volta para o Menu
     }
    }
}
