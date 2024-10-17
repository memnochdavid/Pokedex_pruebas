package com.david.pokedex_pruebas.modelo


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.david.pokedex_pruebas.R



class PokeVistaAdapter(private val pokemonList: List<PokemonOld>) :
    RecyclerView.Adapter<PokeVistaAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val foto: ImageView = view.findViewById(R.id.foto)
        val nombre: TextView = view.findViewById(R.id.nombre)
        val desc: TextView = view.findViewById(R.id.desc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.objeto_vista, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val currentPokemon = pokemonList[position]
        viewHolder.foto.setImageResource(currentPokemon.foto)
        viewHolder.nombre.text = currentPokemon.name
        viewHolder.desc.text = currentPokemon.desc
    }

    override fun getItemCount():Int{
        return pokemonList.size
    }
}