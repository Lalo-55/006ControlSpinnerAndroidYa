package com.luismorales17106494.a006_controlspinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.luismorales17106494.a006_controlspinner.databinding.ActivityMainBinding

/*
    6 - Control Spinner
El objetivo de este concepto es seguir practicando lo visto hasta ahora e incorporar el
control visual Spinner.
El control Spinner muestra una lista de String y nos permite seleccionar uno de ellos. Cuando
se lo selecciona se abre y muestra todos sus elementos para permitir seleccionar uno de ellos.


  Problema:
Realizar la carga de dos números en controles de tipo EditText ("Number").
Mostrar un mensaje que solicite la carga de los valores iniciando la
propiedad "hint" de cada control. Disponer un control de tipo Spinner que permita
seleccionar si queremos sumar, restar, multiplicar o dividir dichos valores. Finalmente
mediante un control de tipo Button efectuamos la operación respectiva. Mostramos el resultado
en un TextView.
 */
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val lista = arrayOf("Sumar", "Restar", "Multiplicar", "Dividir")


        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, lista)
        binding.spOperar.adapter = adaptador




        binding.btOperar.setOnClickListener() {

            if (binding.etNumero1.text.isNotBlank() && binding.etNumero2.text.isNotBlank()) {

                when (binding.spOperar.selectedItem.toString()) {
                    "Sumar" -> {
                        val sumar = binding.etNumero1.text.toString()
                            .toDouble() + binding.etNumero2.text.toString().toDouble()
                        binding.tvResultado.text = sumar.toString()
                    }
                    "Restar" -> {
                        val resta = binding.etNumero1.text.toString()
                            .toDouble() - binding.etNumero2.text.toString().toDouble()
                        binding.tvResultado.text = resta.toString()
                    }
                    "Multiplicar" -> {
                        val multi = binding.etNumero1.text.toString()
                            .toDouble() * binding.etNumero2.text.toString().toDouble()
                        binding.tvResultado.text = multi.toString()
                    }
                    "Dividir" -> {
                        val dividir = binding.etNumero1.text.toString()
                            .toDouble() / binding.etNumero2.text.toString().toDouble()
                        binding.tvResultado.text = dividir.toString()
                    }
                }
            } else {
                Toast.makeText(this, "Rellene todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

    }
}