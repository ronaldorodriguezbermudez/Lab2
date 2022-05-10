package com.example.lab2

import LogicaNegocio.Libro
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.bumptech.glide.Glide
import com.google.android.material.bottomappbar.BottomAppBar
import kotlinx.android.synthetic.main.activity_info_libro.*
import java.io.InputStream
import java.net.URL


class InfoLibro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_libro)

        ToolBar().show(this, "Librería", false)

        val libro: Libro = intent.extras?.getSerializable("libro") as Libro


        val tvNombre = findViewById<TextView>(R.id.tvNombre)
        val ivLibro = findViewById<ImageView>(R.id.ivLibro)
        val tvEditorial = findViewById<TextView>(R.id.tvEditorial)
        val tvPrecio = findViewById<TextView>(R.id.tvPrecio)
        val tvIdioma = findViewById<TextView>(R.id.tvIdioma)
        val tvSinopsis = findViewById<TextView>(R.id.tvSinopsis)

        tvNombre.text = libro.nombre
        Glide.with(ivLibro.context).load(libro.foto).into(ivLibro)
        tvEditorial.text = "Editorial " + libro.editorial
        tvPrecio.text = "₡" + libro.precio.toString()
        tvIdioma.text = "Idioma: " + libro.idioma
        tvSinopsis.text = libro.sinopsis + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sollicitudin justo sed leo faucibus suscipit. Etiam iaculis felis finibus massa tincidunt molestie. Donec ultricies tincidunt lectus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. In non quam eros. Maecenas tempus, quam vel blandit varius, nulla velit tempus ex, quis varius turpis nulla vitae urna. Sed imperdiet enim ante, in dignissim mauris condimentum eu. In posuere turpis enim, eu porttitor quam fringilla sodales. Cras metus turpis, mattis nec tellus sed, auctor accumsan eros. Donec scelerisque quam rhoncus efficitur sollicitudin. Vivamus feugiat lobortis tellus in tristique. Duis quis nunc leo. Duis faucibus sagittis tempor.\n" +
                "\n" +
                "Vestibulum ac nisi ut ante mattis ultricies mollis nec nisi. Aenean leo ante, maximus at leo sed, tincidunt dapibus libero. Fusce ex lacus, convallis eu vulputate vitae, rutrum id justo. Fusce ante nibh, eleifend ac gravida vitae, tincidunt ac augue. Nulla facilisi. Cras convallis euismod quam, eu commodo erat blandit nec. Maecenas egestas malesuada turpis a mattis. Fusce suscipit tincidunt augue. Vestibulum ut vehicula diam. Praesent tincidunt, tellus eu faucibus pharetra, orci quam tempor tellus, a viverra metus elit at lectus. Vestibulum posuere lorem sed fringilla iaculis."

        val comprar = findViewById<Button>(R.id.btncomprar)
        comprar.setOnClickListener{
            val intent = Intent(this, Compra::class.java)
            intent.putExtra("libro", libro)
            startActivity(intent)
        }
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
            Toast.makeText(this,"Opción Buscar", Toast.LENGTH_SHORT).show()
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
