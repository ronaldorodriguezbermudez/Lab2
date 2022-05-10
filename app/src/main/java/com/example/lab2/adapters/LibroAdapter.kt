package com.example.lab2.adapters

import LogicaNegocio.Libro
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab2.R

/*
para trabajar con nuestros datos, en este caso un adaptador que herede de la clase RecyclerView.Adapter. La peculiaridad en esta ocasión
es que este tipo de adaptador utilizará internamente el patrón view holder que dotará de una mayor eficiencia al control, y de ahí la necesidad
del segundo componente de la lista anterior, RecyclerView.ViewHolder

Fuente: https://www.sgoliver.net/blog/controles-de-seleccion-v-recyclerview/#:~:text=ViewHolder%20.,elemento%20individual%20de%20la%20lista.
 */

class LibroAdapter(private val listaLibro:List<Libro>, private val onClickListener: (Libro) -> Unit) : RecyclerView.Adapter<LibroViewHolder>() {

    //Devuelve el item_Libro.xml por cada libro en la lista, hacia el ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibroViewHolder {
        //Instantiates a layout XML file into its corresponding android.view.View objects
        val layoutInflater = LayoutInflater.from(parent.context)
        return LibroViewHolder(layoutInflater.inflate(R.layout.item_libro, parent, false))
    }

    // por cada libro en la lista llama al render del viewHolder
    override fun onBindViewHolder(holder: LibroViewHolder, position: Int) {
        val item = listaLibro[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int {
        return listaLibro.size
    }

}