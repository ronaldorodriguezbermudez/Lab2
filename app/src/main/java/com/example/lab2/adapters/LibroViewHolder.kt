package com.example.lab2.adapters

import LogicaNegocio.Libro
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lab2.R

/*
 un view holder se encargará de contener y gestionar las vistas o controles asociados a cada elemento individual de la lista. El control RecyclerView
 se encargará de crear tantos view holder como sea necesario para mostrar los elementos de la lista que se ven en pantalla y los gestionará eficientemente
 de forma que no tenga que crear nuevos objetos para mostrar más elementos de la lista al hacer scroll, sino que tratará de «reciclar» aquellos que ya no
 sirven por estar asociados a otros elementos de la lista que ya han salido de la pantalla.

 Fuente: https://www.sgoliver.net/blog/controles-de-seleccion-v-recyclerview/#:~:text=ViewHolder%20.,elemento%20individual%20de%20la%20lista.
 */

class LibroViewHolder(view: View):RecyclerView.ViewHolder(view) {

    val nombre = view.findViewById<TextView>(R.id.tvLibroNombre)
    val editorial = view.findViewById<TextView>(R.id.tvLibroEditorial)
    val fecha = view.findViewById<TextView>(R.id.tvLibroAnnio)
    val idioma = view.findViewById<TextView>(R.id.tvLibroIdioma)
    val precio = view.findViewById<TextView>(R.id.tvLibroPrecio)
    val foto = view.findViewById<ImageView>(R.id.ivLibro)

    //se llama por cada libro en el listado
    fun render(libro: Libro, onClickListener: (Libro) -> Unit){
        nombre.text = libro.nombre
        editorial.text = "Editorial " + libro.editorial
        fecha.text = "Publicado en " + libro.fecha.toString()
        idioma.text = libro.idioma
        precio.text = "₡" + libro.precio.toString()
        //Se usar la libreria glide para cargar imagenes por medio de url
        //Tambien se debe dar permiso de usar internet en el manifest
        Glide.with(foto.context).load(libro.foto).into(foto)

        itemView.setOnClickListener{ onClickListener(libro)}
    }
}