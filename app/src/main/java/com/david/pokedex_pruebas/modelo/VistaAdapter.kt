package com.david.pokedex_pruebas.modelo


import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.graphics.green
//import androidx.glance.visibility
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
        //tipos - ImageView de los tipos
        val pokemonTipo1: ImageView = itemView.findViewById(R.id.tipo1)
        val pokemonTipo2: ImageView = itemView.findViewById(R.id.tipo2)
        //debilidades - Array que maneja los imageView de las debilidades
        val debilidades = listOf(
            itemView.findViewById(R.id.debil1) as ImageView,
            itemView.findViewById(R.id.debil2) as ImageView,
            itemView.findViewById(R.id.debil3) as ImageView,
            itemView.findViewById(R.id.debil4) as ImageView,
            itemView.findViewById(R.id.debil5) as ImageView,
            itemView.findViewById(R.id.debil6) as ImageView,
            itemView.findViewById(R.id.debil7) as ImageView,
            itemView.findViewById(R.id.debil8) as ImageView
        )
        //fortalezas - Array que maneja los imageView de las fortalezas
        val fortalezas = listOf(
            itemView.findViewById(R.id.fuerte1) as ImageView,
            itemView.findViewById(R.id.fuerte2) as ImageView,
            itemView.findViewById(R.id.fuerte3) as ImageView,
            itemView.findViewById(R.id.fuerte4) as ImageView,
            itemView.findViewById(R.id.fuerte5) as ImageView,
            itemView.findViewById(R.id.fuerte6) as ImageView,
            itemView.findViewById(R.id.fuerte7) as ImageView,
            itemView.findViewById(R.id.fuerte8) as ImageView
        )
        //inmunidades - Array que maneja los imageView de las inmuidades
        val filaInmu = itemView.findViewById(R.id.inmune_fila) as LinearLayout//oculta/muestra la fila de inmuidades
        val inmunidades = listOf(
            itemView.findViewById(R.id.inmune1) as ImageView,
            itemView.findViewById(R.id.inmune2) as ImageView
        )


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

        holder.pokemonTipo1.setImageResource(enumToDrawable(currentPokemon.tipo.get(0)))
        if (n_tipos==2) {
            holder.pokemonTipo2.visibility = View.VISIBLE
            holder.pokemonTipo2.setImageResource(enumToDrawable(currentPokemon.tipo.get(1)))
        }else holder.pokemonTipo2.visibility = View.GONE



        //añadimos al  Linear layout @columna1 los elementos dinamicamente Primero un texto y luego tantas imagenes como tipos tenga el pokemon
        var columna1 = holder.itemView.findViewById<LinearLayout>(R.id.columna1)
        columna1.removeAllViews()

        //creamos un textView
        var t = TextView(holder.itemView.context)
        t.text = "Debil contra"
        t.textSize = 15f
        t.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.black))
        columna1.addView(t)

        //añadimos las imagenes de las debilidades

        for (tipo in debs(currentPokemon) ){
            var i = ImageView(holder.itemView.context)
            /*enum class PokemonTipo {
    PLANTA, AGUA, FUEGO, LUCHA, VENENO, ACERO, BICHO, DRAGON, ELECTRICO,HADA, HIELO, PSIQUICO, ROCA, TIERRA, SINIESTRO, NORMAL, VOLADOR, FANTASMA, NULL
}*/
            i.setImageResource(enumToDrawable(currentPokemon.tipo.get(0)))
            columna1.addView(i)
        }

        cambiaFondo(currentPokemon,holder)//fondo del header para cada tipo de pokemon








        var listaDebilidades=debs(currentPokemon)
        //debilidades
        when(listaDebilidades.size){
            0 -> {
                holder.debilidades[0].visibility=View.GONE
                holder.debilidades[1].visibility=View.GONE
                holder.debilidades[2].visibility=View.GONE
                holder.debilidades[3].visibility=View.GONE
                holder.debilidades[4].visibility=View.GONE
                holder.debilidades[5].visibility=View.GONE
                holder.debilidades[6].visibility=View.GONE
                holder.debilidades[7].visibility=View.GONE
            }
            1 -> {
                holder.debilidades[0].visibility=View.VISIBLE
                holder.debilidades[0].setImageResource(debs(currentPokemon).get(0))
                holder.debilidades[1].visibility=View.GONE
                holder.debilidades[2].visibility=View.GONE
                holder.debilidades[3].visibility=View.GONE
                holder.debilidades[4].visibility=View.GONE
                holder.debilidades[5].visibility=View.GONE
                holder.debilidades[6].visibility=View.GONE
                holder.debilidades[7].visibility=View.GONE
            }
            2 -> {
                holder.debilidades[0].visibility=View.VISIBLE
                holder.debilidades[0].setImageResource(debs(currentPokemon).get(0))
                holder.debilidades[1].visibility=View.VISIBLE
                holder.debilidades[1].setImageResource(debs(currentPokemon).get(1))
                holder.debilidades[2].visibility=View.GONE
                holder.debilidades[3].visibility=View.GONE
                holder.debilidades[4].visibility=View.GONE
                holder.debilidades[5].visibility=View.GONE
                holder.debilidades[6].visibility=View.GONE
                holder.debilidades[7].visibility=View.GONE

            }
            3 -> {
                holder.debilidades[0].visibility=View.VISIBLE
                holder.debilidades[0].setImageResource(debs(currentPokemon).get(0))
                holder.debilidades[1].visibility=View.VISIBLE
                holder.debilidades[1].setImageResource(debs(currentPokemon).get(1))
                holder.debilidades[2].visibility=View.VISIBLE
                holder.debilidades[2].setImageResource(debs(currentPokemon).get(2))
                holder.debilidades[3].visibility=View.GONE
                holder.debilidades[4].visibility=View.GONE
                holder.debilidades[5].visibility=View.GONE
                holder.debilidades[6].visibility=View.GONE
                holder.debilidades[7].visibility=View.GONE
            }
            4 -> {
                holder.debilidades[0].visibility=View.VISIBLE
                holder.debilidades[0].setImageResource(debs(currentPokemon).get(0))
                holder.debilidades[1].visibility=View.VISIBLE
                holder.debilidades[1].setImageResource(debs(currentPokemon).get(1))
                holder.debilidades[2].visibility=View.VISIBLE
                holder.debilidades[2].setImageResource(debs(currentPokemon).get(2))
                holder.debilidades[3].visibility=View.VISIBLE
                holder.debilidades[3].setImageResource(debs(currentPokemon).get(3))
                holder.debilidades[4].visibility=View.GONE
                holder.debilidades[5].visibility=View.GONE
                holder.debilidades[6].visibility=View.GONE
                holder.debilidades[7].visibility=View.GONE
            }
            5 -> {
                holder.debilidades[0].visibility=View.VISIBLE
                holder.debilidades[0].setImageResource(debs(currentPokemon).get(0))
                holder.debilidades[1].visibility=View.VISIBLE
                holder.debilidades[1].setImageResource(debs(currentPokemon).get(1))
                holder.debilidades[2].visibility=View.VISIBLE
                holder.debilidades[2].setImageResource(debs(currentPokemon).get(2))
                holder.debilidades[3].visibility=View.VISIBLE
                holder.debilidades[3].setImageResource(debs(currentPokemon).get(3))
                holder.debilidades[4].visibility=View.VISIBLE
                holder.debilidades[4].setImageResource(debs(currentPokemon).get(4))
                holder.debilidades[5].visibility=View.GONE
                holder.debilidades[6].visibility=View.GONE
                holder.debilidades[7].visibility=View.GONE
            }
            6 -> {
                holder.debilidades[0].visibility=View.VISIBLE
                holder.debilidades[0].setImageResource(debs(currentPokemon).get(0))
                holder.debilidades[1].visibility=View.VISIBLE
                holder.debilidades[1].setImageResource(debs(currentPokemon).get(1))
                holder.debilidades[2].visibility=View.VISIBLE
                holder.debilidades[2].setImageResource(debs(currentPokemon).get(2))
                holder.debilidades[3].visibility=View.VISIBLE
                holder.debilidades[3].setImageResource(debs(currentPokemon).get(3))
                holder.debilidades[4].visibility=View.VISIBLE
                holder.debilidades[4].setImageResource(debs(currentPokemon).get(4))
                holder.debilidades[5].visibility=View.VISIBLE
                holder.debilidades[5].setImageResource(debs(currentPokemon).get(5))
                holder.debilidades[6].visibility=View.GONE
                holder.debilidades[7].visibility=View.GONE
            }
            7 -> {
                holder.debilidades[0].visibility=View.VISIBLE
                holder.debilidades[0].setImageResource(debs(currentPokemon).get(0))
                holder.debilidades[1].visibility=View.VISIBLE
                holder.debilidades[1].setImageResource(debs(currentPokemon).get(1))
                holder.debilidades[2].visibility=View.VISIBLE
                holder.debilidades[2].setImageResource(debs(currentPokemon).get(2))
                holder.debilidades[3].visibility=View.VISIBLE
                holder.debilidades[3].setImageResource(debs(currentPokemon).get(3))
                holder.debilidades[4].visibility=View.VISIBLE
                holder.debilidades[4].setImageResource(debs(currentPokemon).get(4))
                holder.debilidades[5].visibility=View.VISIBLE
                holder.debilidades[5].setImageResource(debs(currentPokemon).get(5))
                holder.debilidades[6].visibility=View.VISIBLE
                holder.debilidades[6].setImageResource(debs(currentPokemon).get(6))
                holder.debilidades[7].visibility=View.GONE
            }
            8->{
                holder.debilidades[0].visibility=View.VISIBLE
                holder.debilidades[0].setImageResource(debs(currentPokemon).get(0))
                holder.debilidades[1].visibility=View.VISIBLE
                holder.debilidades[1].setImageResource(debs(currentPokemon).get(1))
                holder.debilidades[2].visibility=View.VISIBLE
                holder.debilidades[2].setImageResource(debs(currentPokemon).get(2))
                holder.debilidades[3].visibility=View.VISIBLE
                holder.debilidades[3].setImageResource(debs(currentPokemon).get(3))
                holder.debilidades[4].visibility=View.VISIBLE
                holder.debilidades[4].setImageResource(debs(currentPokemon).get(4))
                holder.debilidades[5].visibility=View.VISIBLE
                holder.debilidades[5].setImageResource(debs(currentPokemon).get(5))
                holder.debilidades[6].visibility=View.VISIBLE
                holder.debilidades[6].setImageResource(debs(currentPokemon).get(6))
                holder.debilidades[7].visibility=View.VISIBLE
                holder.debilidades[7].setImageResource(debs(currentPokemon).get(7))
            }

        }
        //fortalezas
        var listaFortalezas=forts(currentPokemon)
        when(listaFortalezas.size){
            0 -> {
                holder.fortalezas[0].visibility=View.GONE
                holder.fortalezas[1].visibility=View.GONE
                holder.fortalezas[2].visibility=View.GONE
                holder.fortalezas[3].visibility=View.GONE
                holder.fortalezas[4].visibility=View.GONE
                holder.fortalezas[5].visibility=View.GONE
                holder.fortalezas[6].visibility=View.GONE
                holder.fortalezas[7].visibility=View.GONE
            }
            1 -> {
                holder.fortalezas[0].visibility=View.VISIBLE
                holder.fortalezas[0].setImageResource(forts(currentPokemon).get(0))
                holder.fortalezas[1].visibility=View.GONE
                holder.fortalezas[2].visibility=View.GONE
                holder.fortalezas[3].visibility=View.GONE
                holder.fortalezas[4].visibility=View.GONE
                holder.fortalezas[5].visibility=View.GONE
                holder.fortalezas[6].visibility=View.GONE
                holder.fortalezas[7].visibility=View.GONE
            }
            2 -> {
                holder.fortalezas[0].visibility=View.VISIBLE
                holder.fortalezas[0].setImageResource(forts(currentPokemon).get(0))
                holder.fortalezas[1].visibility=View.VISIBLE
                holder.fortalezas[1].setImageResource(forts(currentPokemon).get(1))
                holder.fortalezas[2].visibility=View.GONE
                holder.fortalezas[3].visibility=View.GONE
                holder.fortalezas[4].visibility=View.GONE
                holder.fortalezas[5].visibility=View.GONE
                holder.fortalezas[6].visibility=View.GONE
                holder.fortalezas[7].visibility=View.GONE
            }
            3 -> {
                holder.fortalezas[0].visibility=View.VISIBLE
                holder.fortalezas[0].setImageResource(forts(currentPokemon).get(0))
                holder.fortalezas[1].visibility=View.VISIBLE
                holder.fortalezas[1].setImageResource(forts(currentPokemon).get(1))
                holder.fortalezas[2].visibility=View.VISIBLE
                holder.fortalezas[2].setImageResource(forts(currentPokemon).get(2))
                holder.fortalezas[3].visibility=View.GONE
                holder.fortalezas[4].visibility=View.GONE
                holder.fortalezas[5].visibility=View.GONE
                holder.fortalezas[6].visibility=View.GONE
                holder.fortalezas[7].visibility=View.GONE
            }
            4 -> {
                holder.fortalezas[0].visibility=View.VISIBLE
                holder.fortalezas[0].setImageResource(forts(currentPokemon).get(0))
                holder.fortalezas[1].visibility=View.VISIBLE
                holder.fortalezas[1].setImageResource(forts(currentPokemon).get(1))
                holder.fortalezas[2].visibility=View.VISIBLE
                holder.fortalezas[2].setImageResource(forts(currentPokemon).get(2))
                holder.fortalezas[3].visibility=View.VISIBLE
                holder.fortalezas[3].setImageResource(forts(currentPokemon).get(3))
                holder.fortalezas[4].visibility=View.GONE
                holder.fortalezas[5].visibility=View.GONE
                holder.fortalezas[6].visibility=View.GONE
                holder.fortalezas[7].visibility=View.GONE
            }
            5 -> {
                holder.fortalezas[0].visibility=View.VISIBLE
                holder.fortalezas[0].setImageResource(forts(currentPokemon).get(0))
                holder.fortalezas[1].visibility=View.VISIBLE
                holder.fortalezas[1].setImageResource(forts(currentPokemon).get(1))
                holder.fortalezas[2].visibility=View.VISIBLE
                holder.fortalezas[2].setImageResource(forts(currentPokemon).get(2))
                holder.fortalezas[3].visibility=View.VISIBLE
                holder.fortalezas[3].setImageResource(forts(currentPokemon).get(3))
                holder.fortalezas[4].visibility=View.VISIBLE
                holder.fortalezas[4].setImageResource(forts(currentPokemon).get(4))
                holder.fortalezas[5].visibility=View.GONE
                holder.fortalezas[6].visibility=View.GONE
                holder.fortalezas[7].visibility=View.GONE
            }
            6 -> {
                holder.fortalezas[0].visibility=View.VISIBLE
                holder.fortalezas[0].setImageResource(forts(currentPokemon).get(0))
                holder.fortalezas[1].visibility=View.VISIBLE
                holder.fortalezas[1].setImageResource(forts(currentPokemon).get(1))
                holder.fortalezas[2].visibility=View.VISIBLE
                holder.fortalezas[2].setImageResource(forts(currentPokemon).get(2))
                holder.fortalezas[3].visibility=View.VISIBLE
                holder.fortalezas[3].setImageResource(forts(currentPokemon).get(3))
                holder.fortalezas[4].visibility=View.VISIBLE
                holder.fortalezas[4].setImageResource(forts(currentPokemon).get(4))
                holder.fortalezas[5].visibility=View.VISIBLE
                holder.fortalezas[5].setImageResource(forts(currentPokemon).get(5))
                holder.fortalezas[6].visibility=View.GONE
                holder.fortalezas[7].visibility=View.GONE
            }
            7 -> {
                holder.fortalezas[0].visibility=View.VISIBLE
                holder.fortalezas[0].setImageResource(forts(currentPokemon).get(0))
                holder.fortalezas[1].visibility=View.VISIBLE
                holder.fortalezas[1].setImageResource(forts(currentPokemon).get(1))
                holder.fortalezas[2].visibility=View.VISIBLE
                holder.fortalezas[2].setImageResource(forts(currentPokemon).get(2))
                holder.fortalezas[3].visibility=View.VISIBLE
                holder.fortalezas[3].setImageResource(forts(currentPokemon).get(3))
                holder.fortalezas[4].visibility=View.VISIBLE
                holder.fortalezas[4].setImageResource(forts(currentPokemon).get(4))
                holder.fortalezas[5].visibility=View.VISIBLE
                holder.fortalezas[5].setImageResource(forts(currentPokemon).get(5))
                holder.fortalezas[6].visibility=View.VISIBLE
                holder.fortalezas[6].setImageResource(forts(currentPokemon).get(6))
                holder.fortalezas[7].visibility=View.GONE
            }
            8->{
                holder.fortalezas[0].visibility=View.VISIBLE
                holder.fortalezas[0].setImageResource(forts(currentPokemon).get(0))
                holder.fortalezas[1].visibility=View.VISIBLE
                holder.fortalezas[1].setImageResource(forts(currentPokemon).get(1))
                holder.fortalezas[2].visibility=View.VISIBLE
                holder.fortalezas[2].setImageResource(forts(currentPokemon).get(2))
                holder.fortalezas[3].visibility=View.VISIBLE
                holder.fortalezas[3].setImageResource(forts(currentPokemon).get(3))
                holder.fortalezas[4].visibility=View.VISIBLE
                holder.fortalezas[4].setImageResource(forts(currentPokemon).get(4))
                holder.fortalezas[5].visibility=View.VISIBLE
                holder.fortalezas[5].setImageResource(forts(currentPokemon).get(5))
                holder.fortalezas[6].visibility=View.VISIBLE
                holder.fortalezas[6].setImageResource(forts(currentPokemon).get(6))
                holder.fortalezas[7].visibility=View.VISIBLE
                holder.fortalezas[7].setImageResource(forts(currentPokemon).get(7))
            }
        }
        //inmunidades
        var inmune=inmune(currentPokemon)
        when(inmune.size) {
            0 -> {
                holder.filaInmu.visibility = View.GONE
            }

            1 -> {
                holder.filaInmu.visibility = View.VISIBLE
                holder.inmunidades[1].visibility = View.GONE
                holder.inmunidades[0].setImageResource(inmune(currentPokemon).get(0))
            }

            2 -> {
                holder.filaInmu.visibility = View.VISIBLE
                holder.inmunidades[1].visibility = View.VISIBLE
                holder.inmunidades[0].setImageResource(inmune(currentPokemon).get(0))
                holder.inmunidades[1].setImageResource(inmune(currentPokemon).get(1))
            }
        }

        /*plantilla de logs
        Log.d("Nombre", currentPokemon.name)
        Log.d("Inmune a 1", drawableToEnum(inmune[0]).toString())
        Log.d("Inmune a 2", drawableToEnum(inmune[1]).toString())*/
    }

    override fun getItemCount():Int{
        return pokemonList.size
    }

}
