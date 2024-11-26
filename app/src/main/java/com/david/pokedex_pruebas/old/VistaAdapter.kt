package com.david.pokedex_pruebas.old


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
//import androidx.glance.visibility
import androidx.recyclerview.widget.RecyclerView
import com.david.pokedex_pruebas.R


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

        //numero de pokemon
        if(numero.length == 1) numero = "00${(position + 1)}"
        else if(numero.length == 2) numero = "0${(position + 1)}"
        holder.pokemonNumber.text = "#${numero}"

        //tipos
        var fila_tipos = holder.itemView.findViewById<LinearLayout>(R.id.fila_tipos)
        fila_tipos.removeAllViews()
        var t1 = ImageView(holder.itemView.context)
        var t2 = ImageView(holder.itemView.context)
        t1.setImageResource(enumToDrawable(currentPokemon.tipo.get(0)))
        fila_tipos.addView(t1)
        if (n_tipos==2) {
            t2.setImageResource(enumToDrawable(currentPokemon.tipo.get(1)))
            fila_tipos.addView(t2)
        }

        //------------------------------------------------------------------
        //FORTALEZAS
        //añadimos al  Linear layout @columna2 los elementos dinamicamente Primero un texto y luego tantas imagenes como fortalezas tenga el pokemon
        var col_fortalezas = holder.itemView.findViewById<LinearLayout>(R.id.col_fort_tipo)
        //col_fortalezas.removeView(holder.itemView.findViewById<LinearLayout>(R.id.fuerte1))
        col_fortalezas.removeAllViews()



        //añadimos las imagenes de las debilidades
        for (fortaleza in forts(currentPokemon) ){
            var i = ImageView(holder.itemView.context)
            i.setImageResource(fortaleza)
            //añadimos el margin
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )

            val topMarginInDp = 5 // 5 dp
            val density = holder.itemView.context.resources.displayMetrics.density
            val topMarginInPixels = (topMarginInDp * density + 0.5f).toInt()

            params.setMargins(0, topMarginInPixels, 0, 0)
            i.layoutParams = params
            //añadimos la imagen
            col_fortalezas.addView(i)
        }

        //DEBILIDADES
        //añadimos al  Linear layout @columna1 los elementos dinamicamente Primero un texto y luego tantas imagenes como debilidades tenga el pokemon
        var col_debilidades = holder.itemView.findViewById<LinearLayout>(R.id.col_deb_tipo)
        //col_debilidades.removeView(holder.itemView.findViewById<LinearLayout>(R.id.debil1))
        col_debilidades.removeAllViews()

        //se añaden las imágenes
        for (debilidad in debs(currentPokemon) ){
            var i = ImageView(holder.itemView.context)
            i.setImageResource(debilidad)
            //añadimos el margin
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )

            val topMarginInDp = 5 // 5 dp
            val density = holder.itemView.context.resources.displayMetrics.density
            val topMarginInPixels = (topMarginInDp * density + 0.5f).toInt()

            params.setMargins(0, topMarginInPixels, 0, 0)
            i.layoutParams = params
            //añadimos la imagen
            col_debilidades.addView(i)
        }

        //INMUNIDAD
        //añadimos al  Linear layout @columna1 los elementos dinamicamente Primero un texto y luego tantas imagenes como debilidades tenga el pokemon
        var inmune_col2 = holder.itemView.findViewById<LinearLayout>(R.id.inmuneCol2)
        var fila_inmune = holder.itemView.findViewById<LinearLayout>(R.id.inmune_fila)
        inmune_col2.removeView(holder.itemView.findViewById<LinearLayout>(R.id.inmune1))
        inmune_col2.removeAllViews()

        if(inmune(currentPokemon).size==0){
            fila_inmune.visibility=View.GONE
        }else {
            fila_inmune.visibility=View.VISIBLE
            //se añaden las imágenes
            for (inmunidad in inmune(currentPokemon)) {
                var i = ImageView(holder.itemView.context)
                i.setImageResource(inmunidad)
                //añadimos el margin
                val params = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                val topMarginInDp = 5 // 5 dp
                val density = holder.itemView.context.resources.displayMetrics.density
                val topMarginInPixels = (topMarginInDp * density + 0.5f).toInt()
                params.setMargins(0, topMarginInPixels, 0, 0)
                i.layoutParams = params

                //añadimos la imagen
                inmune_col2.addView(i)
            }
        }
        //-------------------------------------------------------------
        //fondo del header para cada tipo de pokemon
        cambiaFondo(currentPokemon,holder)
    }

    override fun getItemCount():Int{
        return pokemonList.size
    }

}
