package com.example.lab2

import LogicaNegocio.Libro
import LogicaNegocio.ListaLibros
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
import androidx.recyclerview.widget.RecyclerView
import com.example.lab2.adapters.LibroAdapter

class Listado : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado)

        ToolBar().show(this, "Librería", false)

        this.initRecyclerView()
    }

    private fun initRecyclerView(){
        val manager = LinearLayoutManager(this)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerLista)
        recyclerView.layoutManager = manager
        //el adapter recibe un listado de libros
        recyclerView.adapter = LibroAdapter(ListaLibros.lista) {libro ->
            onItemSelected(
                libro
            )
        }
    }

    fun onItemSelected(libro:Libro){
        val intent = Intent(this, InfoLibro::class.java)
        intent.putExtra("libro", libro)
        startActivity(intent)
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