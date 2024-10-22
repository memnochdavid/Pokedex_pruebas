package com.david.pokedex_pruebas.modelo

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
//import androidx.compose.ui.semantics.text
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent
import android.util.Log
import android.view.MotionEvent
import android.widget.HorizontalScrollView
import androidx.appcompat.widget.SwitchCompat
import androidx.compose.ui.semantics.text
//import androidx.glance.visibility
import com.david.pokedex_pruebas.R
import com.david.pokedex_pruebas.interfaz.VistaActivity
//
import kotlinx.coroutines.*

//import androidx.compose.animation.with
//import kotlin.io.path.name


class PokemonAdapter(private val pokemonList: List<PokemonOld>) :
    RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pokemonImage: ImageView = itemView.findViewById(R.id.pokemonImage)
        val pokemonNumber: TextView = itemView.findViewById(R.id.numero)
        val pokemonName: TextView = itemView.findViewById(R.id.pokemonName)
        val pokemonTipo1: ImageView = itemView.findViewById(R.id.tipo1)
        val pokemonTipo2: ImageView = itemView.findViewById(R.id.tipo2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.objeto_lista, parent, false)
        return PokemonViewHolder(itemView)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val currentPokemon = pokemonList[position]
        holder.pokemonName.text = ""
        holder.pokemonTipo1.setImageResource(0) // Or a placeholder image
        holder.pokemonTipo2.setImageResource(0)

        var n_tipos=currentPokemon.tipo.size
        holder.pokemonImage.setImageResource(currentPokemon.foto)
        holder.pokemonName.text = currentPokemon.name
        var numero = "${(position+1)}"

        if(numero.length == 1) numero = "00${(position + 1)}"
        else if(numero.length == 2) numero = "0${(position + 1)}"
        holder.pokemonNumber.text = "#${numero}"

        holder.pokemonTipo1.setImageResource(enumToDrawable(currentPokemon.tipo.get(0)))
        //Log.d("Nombre", currentPokemon.name)
        //Log.d("Tipo1", drawableToEnum(currentPokemon.tipo[0]).toString())

        if (n_tipos ==2) {
            holder.pokemonTipo2.visibility = View.VISIBLE////
            holder.pokemonTipo2.setImageResource(enumToDrawable(currentPokemon.tipo.get(1)))
            //Log.d("Tipo2", drawableToEnum(currentPokemon.tipo[1]).toString())
        }else holder.pokemonTipo2.visibility = View.GONE





        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, VistaActivity::class.java)
            intent.putExtra("pokemon_name", currentPokemon.name)
            intent.putExtra("pokemon_image", currentPokemon.foto)
            intent.putExtra("tipo1", currentPokemon.tipo.get(0))
            if (n_tipos==2) {
                intent.putExtra("tipo2", currentPokemon.tipo.get(1))
            }
            intent.putExtra("num", position)
            holder.itemView.context.startActivity(intent)
        }

        holder.itemView.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    v.animate().scaleX(0.9f).scaleY(0.9f).setDuration(100).start()
                }
                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                    v.animate().scaleX(1f).scaleY(1f).setDuration(100).start()
                }
            };false
        }
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }
}