package com.example.lab2

import LogicaNegocio.Libro
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Compra : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compra)

        val libro: Libro = intent.extras?.getSerializable("libro") as Libro

        val tvNombre = findViewById<TextView>(R.id.nombre)
        tvNombre.text = libro.nombre

        val fab: FloatingActionButton = findViewById(R.id.flotante)
        fab.setOnClickListener {
            Toast.makeText(this, "FAB Clicked", Toast.LENGTH_SHORT).show()
        }

        val bottomAppBar: BottomAppBar = findViewById(R.id.bottom_app_bar)
        bottomAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.opcionInicio -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    true
                }
                R.id.opcionBuscar -> {
                    startActivity(Intent(this, Buscar::class.java))
                    true
                }
                R.id.opcionConf -> {
                    Toast.makeText(this, "Opción Caonfiguración", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.opcionLogout -> {
                    Toast.makeText(this, "Opción Logout", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }
}