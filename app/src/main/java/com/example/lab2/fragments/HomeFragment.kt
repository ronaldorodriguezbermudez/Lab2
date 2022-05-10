package com.example.lab2.fragments

import LogicaNegocio.Libro
import LogicaNegocio.ListaLibros
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab2.InfoLibro
import com.example.lab2.Listado
import com.example.lab2.R
import com.example.lab2.adapters.LibroAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    private var mContext: Context? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        initRecyclerView(root)
        return root

    }

    private fun initRecyclerView(root: View){
        val manager = LinearLayoutManager(root.context)
        val recyclerView = root.findViewById<RecyclerView>(R.id.recyclerLista)

        recyclerView.layoutManager = manager
        //el adapter recibe un listado de libros
        recyclerView.adapter = LibroAdapter(ListaLibros.lista) {libro ->
            onItemSelected(
                libro
            )
        }

    }

    fun onItemSelected(libro: Libro){

        val intent = Intent(mContext, InfoLibro::class.java)
        intent.putExtra("libro", libro)
        startActivity(intent)
    }
}