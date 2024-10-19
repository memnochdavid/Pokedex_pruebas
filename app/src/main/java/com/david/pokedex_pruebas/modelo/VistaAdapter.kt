package com.david.pokedex_pruebas.modelo


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.graphics.green
import androidx.recyclerview.widget.RecyclerView
import com.david.pokedex_pruebas.R
import com.david.pokedex_pruebas.interfaz.VistaActivity
import com.david.pokedex_pruebas.modelo.PokemonOld


class PokeVistaAdapter(private val pokemonList: List<PokemonOld>) :
    RecyclerView.Adapter<PokeVistaAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val pokemonImage: ImageView = view.findViewById(R.id.foto)
        var pokemonNumber: TextView = view.findViewById(R.id.num)
        val pokemonName: TextView = view.findViewById(R.id.nombre)
        val desc: TextView = view.findViewById(R.id.desc)
        val pokemonTipo1: ImageView = itemView.findViewById(R.id.tipo1)
        val pokemonTipo2: ImageView = itemView.findViewById(R.id.tipo2)
        //debilidades
        val debilidades = listOf(
            itemView.findViewById(R.id.debil1) as ImageView,
            itemView.findViewById(R.id.debil2) as ImageView,
            itemView.findViewById(R.id.debil3) as ImageView,
            itemView.findViewById(R.id.debil4) as ImageView,
            itemView.findViewById(R.id.debil5) as ImageView,
            itemView.findViewById(R.id.debil6) as ImageView,
            itemView.findViewById(R.id.debil7) as ImageView
        )
        //fortalezas
        val fortalezas = listOf(
            itemView.findViewById(R.id.fuerte1) as ImageView,
            itemView.findViewById(R.id.fuerte2) as ImageView,
            itemView.findViewById(R.id.fuerte3) as ImageView,
            itemView.findViewById(R.id.fuerte4) as ImageView,
            itemView.findViewById(R.id.fuerte5) as ImageView
        )

        //puede que para borrar
        val columna1 = view.findViewById<LinearLayout>(R.id.columna1)
        val columna2 = view.findViewById<LinearLayout>(R.id.columna2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.objeto_vista, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentPokemon = pokemonList[position]
        var n_tipos=currentPokemon.tipo.size
        var numero = "${(position+1)}"

        holder.pokemonImage.setImageResource(currentPokemon.foto)
        holder.pokemonName.text = currentPokemon.name
        holder.desc.text = currentPokemon.desc

        if(numero.length == 1) numero = "00${(position + 1)}"
        else if(numero.length == 2) numero = "0${(position + 1)}"
        holder.pokemonNumber.text = "#${numero}"


        holder.pokemonTipo1.setImageResource(currentPokemon.tipo.get(0))
        if (n_tipos==2) {
            holder.pokemonTipo2.setImageResource(currentPokemon.tipo.get(1))
        }else holder.pokemonTipo2.visibility = View.GONE



        cambiaFondo(currentPokemon,holder)//fondo del header para cada tipo de pokemon

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

        //debs
        var listaDebilidades=debs(currentPokemon)

        when(listaDebilidades.size){
            0 -> {
                holder.debilidades[0].visibility=View.GONE
                holder.debilidades[1].visibility=View.GONE
                holder.debilidades[2].visibility=View.GONE
                holder.debilidades[3].visibility=View.GONE
                holder.debilidades[4].visibility=View.GONE
                holder.debilidades[5].visibility=View.GONE
                holder.debilidades[6].visibility=View.GONE
            }
            1 -> {
                holder.debilidades[0].setImageResource(debs(currentPokemon).get(0))
                holder.debilidades[1].visibility=View.GONE
                holder.debilidades[2].visibility=View.GONE
                holder.debilidades[3].visibility=View.GONE
                holder.debilidades[4].visibility=View.GONE
                holder.debilidades[5].visibility=View.GONE
                holder.debilidades[6].visibility=View.GONE
            }
            2 -> {
                holder.debilidades[0].setImageResource(debs(currentPokemon).get(0))
                holder.debilidades[1].setImageResource(debs(currentPokemon).get(1))
                holder.debilidades[2].visibility=View.GONE
                holder.debilidades[3].visibility=View.GONE
                holder.debilidades[4].visibility=View.GONE
                holder.debilidades[5].visibility=View.GONE
                holder.debilidades[6].visibility=View.GONE
            }
            3 -> {
                holder.debilidades[0].setImageResource(debs(currentPokemon).get(0))
                holder.debilidades[1].setImageResource(debs(currentPokemon).get(1))
                holder.debilidades[2].setImageResource(debs(currentPokemon).get(2))
                holder.debilidades[3].visibility=View.GONE
                holder.debilidades[4].visibility=View.GONE
                holder.debilidades[5].visibility=View.GONE
                holder.debilidades[6].visibility=View.GONE
            }
            4 -> {
                holder.debilidades[0].setImageResource(debs(currentPokemon).get(0))
                holder.debilidades[1].setImageResource(debs(currentPokemon).get(1))
                holder.debilidades[2].setImageResource(debs(currentPokemon).get(2))
                holder.debilidades[3].setImageResource(debs(currentPokemon).get(3))
                holder.debilidades[4].visibility=View.GONE
                holder.debilidades[5].visibility=View.GONE
                holder.debilidades[6].visibility=View.GONE
            }
            5 -> {
                holder.debilidades[0].setImageResource(debs(currentPokemon).get(0))
                holder.debilidades[1].setImageResource(debs(currentPokemon).get(1))
                holder.debilidades[2].setImageResource(debs(currentPokemon).get(2))
                holder.debilidades[3].setImageResource(debs(currentPokemon).get(3))
                holder.debilidades[4].setImageResource(debs(currentPokemon).get(4))
                holder.debilidades[5].visibility=View.GONE
                holder.debilidades[6].visibility=View.GONE
            }
            6 -> {
                holder.debilidades[0].setImageResource(debs(currentPokemon).get(0))
                holder.debilidades[1].setImageResource(debs(currentPokemon).get(1))
                holder.debilidades[2].setImageResource(debs(currentPokemon).get(2))
                holder.debilidades[3].setImageResource(debs(currentPokemon).get(3))
                holder.debilidades[4].setImageResource(debs(currentPokemon).get(4))
                holder.debilidades[5].setImageResource(debs(currentPokemon).get(5))
                holder.debilidades[6].visibility=View.GONE
            }
            7 -> {
                holder.debilidades[0].setImageResource(debs(currentPokemon).get(0))
                holder.debilidades[1].setImageResource(debs(currentPokemon).get(1))
                holder.debilidades[2].setImageResource(debs(currentPokemon).get(2))
                holder.debilidades[3].setImageResource(debs(currentPokemon).get(3))
                holder.debilidades[4].setImageResource(debs(currentPokemon).get(4))
                holder.debilidades[5].setImageResource(debs(currentPokemon).get(5))
                holder.debilidades[6].setImageResource(debs(currentPokemon).get(6))
            }

        }
        //forts
        var listaFortalezas=forts(currentPokemon)

        when(listaFortalezas.size){
            0 -> {
                holder.fortalezas[0].visibility=View.GONE
                holder.fortalezas[1].visibility=View.GONE
                holder.fortalezas[2].visibility=View.GONE
                holder.fortalezas[3].visibility=View.GONE
                holder.fortalezas[4].visibility=View.GONE
            }
            1 -> {
                holder.fortalezas[0].setImageResource(forts(currentPokemon).get(0))
                holder.fortalezas[1].visibility=View.GONE
                holder.fortalezas[2].visibility=View.GONE
                holder.fortalezas[3].visibility=View.GONE
                holder.fortalezas[4].visibility=View.GONE
            }
            2 -> {
                holder.fortalezas[0].setImageResource(forts(currentPokemon).get(0))
                holder.fortalezas[1].setImageResource(forts(currentPokemon).get(1))
                holder.fortalezas[2].visibility=View.GONE
                holder.fortalezas[3].visibility=View.GONE
                holder.fortalezas[4].visibility=View.GONE
            }
            3 -> {
                holder.fortalezas[0].setImageResource(forts(currentPokemon).get(0))
                holder.fortalezas[1].setImageResource(forts(currentPokemon).get(1))
                holder.fortalezas[2].setImageResource(forts(currentPokemon).get(2))
                holder.fortalezas[3].visibility=View.GONE
                holder.fortalezas[4].visibility=View.GONE
            }
            4 -> {
                holder.fortalezas[0].setImageResource(forts(currentPokemon).get(0))
                holder.fortalezas[1].setImageResource(forts(currentPokemon).get(1))
                holder.fortalezas[2].setImageResource(forts(currentPokemon).get(2))
                holder.fortalezas[3].setImageResource(forts(currentPokemon).get(3))
                holder.fortalezas[4].visibility=View.GONE
            }
            5 -> {
                holder.fortalezas[0].setImageResource(forts(currentPokemon).get(0))
                holder.fortalezas[1].setImageResource(forts(currentPokemon).get(1))
                holder.fortalezas[2].setImageResource(forts(currentPokemon).get(2))
                holder.fortalezas[3].setImageResource(forts(currentPokemon).get(3))
                holder.fortalezas[4].setImageResource(forts(currentPokemon).get(4))
            }
        }
        //


    }

    override fun getItemCount():Int{
        return pokemonList.size
    }




}
