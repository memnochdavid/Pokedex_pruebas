package com.david.pokedex_pruebas.old
import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
//import androidx.compose.ui.graphics.Shader
//import androidx.compose.ui.graphics.TileMode
//import android.graphics.Shader
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.david.pokedex_pruebas.R

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
