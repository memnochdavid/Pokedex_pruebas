package com.david.pokedex_pruebas.interfaz
import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
//import androidx.compose.ui.graphics.Shader
//import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.test.bottom
import androidx.compose.ui.test.left
import androidx.compose.ui.test.top
import androidx.compose.ui.test.width
//import android.graphics.Shader
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.david.pokedex_pruebas.R
import com.david.pokedex_pruebas.modelo.PokeVistaAdapter
import com.david.pokedex_pruebas.modelo.PokemonAdapter
import com.david.pokedex_pruebas.modelo.listaPoke

class VistaActivity : AppCompatActivity() {

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vista_activity)

        //RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.pokeVistaRecyclerView)
        val layoutManager=LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = PokeVistaAdapter(listaPoke)
        //efecto snap
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)


        //Para que muestre a partir del pokémon seleccionado
        val pokemonName = intent.getStringExtra("pokemon_name")
        var num = intent.getIntExtra("num", 0)
        for(i in listaPoke){
            if(i.name==pokemonName){
                num= listaPoke.indexOf(i)
            }
        }
        val initialPosition = num
        layoutManager.scrollToPosition(initialPosition)
/*
        //imageViews de tipo dinámicos
        val columna1 = findViewById<LinearLayout>(R.id.columna1)
        val drawablesTipos = listOf(
            R.drawable.agua,
            R.drawable.planta,
            R.drawable.agua,
            R.drawable.fuego,
            R.drawable.lucha,
            R.drawable.veneno,
            R.drawable.acero,
            R.drawable.bicho,
            R.drawable.dragon,
            R.drawable.electrico,
            R.drawable.hada,
            R.drawable.hielo,
            R.drawable.psiquico,
            R.drawable.roca,
            R.drawable.tierra,
            R.drawable.siniestro,
            R.drawable.normal,
            R.drawable.volador,
            R.drawable.fantasma,
        )
*/

    }

















}
