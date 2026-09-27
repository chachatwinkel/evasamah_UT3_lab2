package com.example.evasamah_ut3_lab2

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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

        val nombre = findViewById<EditText>(R.id.texNombre)
        val raza = findViewById<Spinner>(R.id.opciones)
        val registrar = findViewById<ImageButton>(R.id.imagen)
        val faccion = findViewById<RadioGroup>(R.id.cajaBoton)
        val sigilo = findViewById<CheckBox>(R.id.caja1)
        val espada = findViewById<CheckBox>(R.id.caja2)


        nombre.requestFocus()

        val adaptador = ArrayAdapter.createFromResource(
            this,
            R.array.razas,
            android.R.layout.simple_spinner_item
        )
        adaptador.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )
        raza.adapter = adaptador


        registrar.setOnClickListener {

            val nombreGuerrero = nombre.text.toString()

            val razaElegida = raza.selectedItem.toString()

            val idSeleccionado = faccion.checkedRadioButtonId

            val botonSeleccionado = findViewById<RadioButton>(idSeleccionado)

            val faccionElegida =  botonSeleccionado.text.toString()


            var habilidades = ""

            if (sigilo.isChecked) { habilidades += "Sigilo "
            }

            if (espada.isChecked) { habilidades += "Combate con Espada"
            }


            val resumen = """
                Nombre: $nombreGuerrero
                Raza: $razaElegida
                Facción: $faccionElegida
                Habilidades: $habilidades
            """.trimIndent()


            Toast.makeText(
                this,
                resumen,
                Toast.LENGTH_LONG
            ).show()


            Log.d("Personaje", resumen)
        }

    }
}