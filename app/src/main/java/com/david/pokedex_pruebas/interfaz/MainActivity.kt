package com.david.pokedex_pruebas.interfaz

import android.os.Bundle
//import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.annotation.SuppressLint
import android.widget.SearchView
import com.david.pokedex_pruebas.modelo.PokemonAdapter
import com.david.pokedex_pruebas.R
//import com.david.pokedex_pruebas.modelo.busca
import com.david.pokedex_pruebas.modelo.listaPoke

class MainActivity : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView = findViewById(R.id.pokelistRecyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PokemonAdapter(listaPoke)

        val busqueda = findViewById<SearchView>(R.id.busqueda)
        busqueda.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                var listaAux = listaPoke
                //filtramos la listaAux con la busqueda
                var listaAux2 = listaAux.filter { pokemon ->
                    pokemon.name.contains(query, ignoreCase = true)
                }
                recyclerView.adapter = PokemonAdapter(listaAux2)
                recyclerView.adapter?.notifyDataSetChanged()
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                val query = newText ?: "" // Handle null case
                val filteredList = listaPoke.filter { pokemon ->
                    pokemon.name.contains(query, ignoreCase = true)
                }
                recyclerView.adapter = PokemonAdapter(filteredList)
                recyclerView.adapter?.notifyDataSetChanged()
                return true
            }
        })
    }
        override fun onResume() {//establece por defecto al cargar
            super.onResume()
            val recyclerView: RecyclerView = findViewById(R.id.pokelistRecyclerView)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = PokemonAdapter(listaPoke)
        }
}

