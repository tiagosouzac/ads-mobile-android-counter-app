package com.example.contador

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txtContador = findViewById<EditText>(R.id.activity_main_contador)
        val btnAumentar = findViewById<Button>(R.id.activity_main_contador_btn_aumentar)
        val btnDiminuir = findViewById<Button>(R.id.activity_main_contador_btn_diminuir)
        val btnReiniciar = findViewById<Button>(R.id.activity_main_contador_btn_reiniciar)

        txtContador.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(editable: Editable?) {
                    if (editable.isNullOrEmpty()) {
                        txtContador.setText("0")
                        txtContador.setSelection(1)
                        return
                    }

                    var valor = editable.toString()

                    if (valor.length > 1 && valor.startsWith("0")) {
                        valor = valor.substring(1)
                        txtContador.setText(valor)
                        txtContador.setSelection(valor.length)
                        return
                    }

                    btnDiminuir.isEnabled = valor.toInt() > 0
            }

            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence?,
                start: Int,
                before: Int,
                count: Int
            ) {
            }
        })

        btnAumentar.setOnClickListener {
            val valor = (txtContador.text.toString().toIntOrNull() ?: 0) + 1
            txtContador.setText("$valor")

            if (valor > 0) {
                btnDiminuir.isEnabled = true
            }
        }

        btnDiminuir.setOnClickListener {
            var valor = txtContador.text.toString().toIntOrNull() ?: 0

            if (valor != 0) {
                valor -= 1
                txtContador.setText("$valor")

                if (valor == 0) {
                    it.isEnabled = false
                }
            }
        }

        btnReiniciar.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Reiniciar contador")
                .setMessage("Você realmente deseja resetar o valor para zero?")
                .setPositiveButton("Sim") { _, _ ->
                    txtContador.setText("0")
                }
                .setNegativeButton("Não", null)
                .show()
        }
    }
}