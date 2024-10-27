package com.david.pokedex_pruebas.interfaz
import android.annotation.SuppressLint
import android.content.Context
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
        class NextItemSnapHelper : LinearSnapHelper() {
            override fun findTargetSnapPosition(layoutManager: RecyclerView.LayoutManager, velocityX: Int, velocityY: Int): Int {
                val currentView = findSnapView(layoutManager) ?: return RecyclerView.NO_POSITION

                val currentPosition = layoutManager.getPosition(currentView)

                // Determine the direction of the fling
                val direction = if (layoutManager.canScrollHorizontally()) {
                    if (velocityX > 0) 1 else -1
                } else {
                    if (velocityY > 0) 0 else -1
                }

                // Calculate the target position based on the direction
                val targetPosition = currentPosition + direction

                // Check if the target position is within bounds
                return if (targetPosition in 0 until layoutManager.itemCount) {
                    targetPosition
                } else {
                    RecyclerView.NO_POSITION
                }
            }
        }
        //
        val snapHelper = NextItemSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)

        //Para que muestre a partir del pokémon seleccionado
        val pokemonName = intent.getStringExtra("pokemon_name")
        var num = intent.getIntExtra("num", 0)
        for(i in listaPoke){
            if(i.name==pokemonName){
                num= listaPoke.indexOf(i)
                //se comparte el pokemon seleccionado con el adaptador
                val sharedPrefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
                val editor = sharedPrefs.edit()
                editor.putInt("pos", num)
                editor.apply()
            }
        }
        layoutManager.scrollToPosition(num)


    //

    }

















}
