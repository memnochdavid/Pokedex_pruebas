package com.david.pokedex_pruebas

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
//import androidx.compose.ui.semantics.text
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent
import android.view.MotionEvent
import kotlin.io.path.name

class PokemonAdapter(private val pokemonList: List<Pokemon>) :
    RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pokemonImage: ImageView = itemView.findViewById(R.id.pokemonImage)
        val pokemonName: TextView = itemView.findViewById(R.id.pokemonName)
        val pokemonDesc: TextView = itemView.findViewById(R.id.pokemonDesc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.objeto_lista, parent, false)

        return PokemonViewHolder(itemView)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val currentPokemon = pokemonList[position]
        holder.pokemonImage.setImageResource(currentPokemon.foto)
        holder.pokemonName.text = currentPokemon.name
        holder.pokemonDesc.text = currentPokemon.desc

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, VistaActivity::class.java)
            intent.putExtra("pokemon_name", currentPokemon.name)
            intent.putExtra("pokemon_image", currentPokemon.foto)
            intent.putExtra("pokemon_desc", currentPokemon.desc)
            holder.itemView.context.startActivity(intent)
        }
        holder.itemView.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    v.animate().scaleX(0.9f).scaleY(0.9f).setDuration(100).start()
                }
                MotionEvent.ACTION_UP -> {
                    v.animate().scaleX(1f).scaleY(1f).setDuration(100).start()
                }
            };false
         }
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }
}