package com.example.lab2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager

class Buscar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscar)

        ToolBar().show(this, "Librería", false)

        val manager = LinearLayoutManager(this)
        val spin = findViewById<Spinner>(R.id.spCategoria)

        val lista = resources.getStringArray(R.array.categorias)
        val adaptador = ArrayAdapter(this,android.R.layout.simple_spinner_item,lista)
        spin.adapter = adaptador
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.opcionInicio){
            startActivity(Intent(this, MainActivity::class.java))
        }
        if(item.itemId == R.id.opcionBuscar){
            startActivity(Intent(this, Buscar::class.java))
        }
        if(item.itemId == R.id.opcionConf){
            Toast.makeText(this,"Opción Configuración", Toast.LENGTH_SHORT).show()
        }
        if(item.itemId == R.id.opcionLogout){
            Toast.makeText(this,"Opción Logout", Toast.LENGTH_SHORT).show()
        }

        return super.onOptionsItemSelected(item)
    }

}
