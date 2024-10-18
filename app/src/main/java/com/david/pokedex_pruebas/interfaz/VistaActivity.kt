package com.david.pokedex_pruebas.interfaz
import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
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

        /*
        //parallax
        recyclerView.bringToFront()
        val backgroundDrawable = BitmapDrawable(resources, BitmapFactory.decodeResource(resources, R.drawable.bosque)).apply {
            tileModeX = Shader.TileMode.REPEAT
        }
        recyclerView.addItemDecoration(ParallaxBackgroundItemDecoration(backgroundDrawable))
        //fin parallax
        */

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
    }



}

/*
//probando mierdas
//paralaxparallax
class ParallaxBackgroundItemDecoration(private val background: Drawable) : RecyclerView.ItemDecoration() {

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {

        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight

        for (i in 0 until parent.childCount) {
            val view = parent.getChildAt(i)
            val layoutParams = view.layoutParams as RecyclerView.LayoutParams
            val position = layoutParams.viewAdapterPosition

            // Calcula el desplazamiento parallax
            val parallaxOffset = (view.left - parent.paddingLeft) * 0.5f

            // Dibuja el fondo con el desplazamiento
            background.setBounds(left - parallaxOffset.toInt(), view.top, right - parallaxOffset.toInt(), view.bottom)
            background.draw(c)
        }

        super.onDraw(c, parent, state)
    }
}

*/


/*CÓDIGO ANTIGUO
val recyclerView: RecyclerView = findViewById(R.id.pokeVistaRecyclerView)
val layoutManager=LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
recyclerView.layoutManager = layoutManager

val adapter = PokeVistaAdapter(listaPoke)
recyclerView.adapter = adapter

/*
@SuppressLint("ClickableViewAccessibility")
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContentView(R.layout.vista_activity)
    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
        val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
        v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
        insets
    }
    //val botonPrev=findViewById<ImageView>(R.id.botonPrev)
    //val botonNext=findViewById<ImageView>(R.id.botonNext)
    var texto = findViewById<TextView>(R.id.nombre)
    val busqueda = findViewById<SearchView>(R.id.busqueda)
    var num=0
    val total= listaPoke.size


    //gestos
    gestureDetector = GestureDetectorCompat(this, object : GestureDetector.SimpleOnGestureListener() {
        var sentido = 0
        override fun onFling(
            e1: MotionEvent?,
            e2: MotionEvent,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            if (velocityX > 0) {//derecha
                sentido = -1
                if (num > 0 && num != 152) {
                    num--
                } else if (num == 0 && num != 152) {
                    num = total - 2
                }
            } else {//izquierda
                sentido = 1
                if (num == (total - 2) && num != 152) {
                    num = 0
                } else if (num < (total- 2) && num != 152) {
                    num++
                } else if (num == 152) {
                    // Mantener num en 152
                }
            }
            muestraPokenum(num, sentido)
            return true
        }
    })


    //Cambia el texto del nombre del pokemon mientras escribes
    busqueda.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String): Boolean {
            if(busca(query) !=-1)num= busca(query) else num=total-1
            query.dropLast(1)
            texto.text = ""
            texto.text = query.replaceFirstChar{ if (it.isLowerCase()) it.titlecase() else it.toString() }
            muestraPokenum(num,0)
            return true
        }
        override fun onQueryTextChange(busqueda: String?): Boolean {
            texto.text = busqueda
            return true
        }
    })

    ////ROTA las POSICIÓN en la lista - GESTOS
    botonPrev.setOnTouchListener { v, event ->
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                v.animate().scaleX(0.9f).scaleY(0.9f).setDuration(100).start()
            }
            MotionEvent.ACTION_UP -> {
                v.animate().scaleX(1f).scaleY(1f).setDuration(100).start()
            }
        };false
    }
    botonNext.setOnTouchListener { v, event ->
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                v.animate().scaleX(0.9f).scaleY(0.9f).setDuration(100).start()
            }
            MotionEvent.ACTION_UP -> {
                v.animate().scaleX(1f).scaleY(1f).setDuration(100).start()
            }
        };false
    }

    //ROTA las POSICIÓN en la lista - BOTONES
    botonPrev.setOnClickListener{
        if(num>0 && num!=152){
            num--
            muestraPokenum(num,-1)
        }
        if(num==0 && num!=152){
            num=total-2
            muestraPokenum(num,-1)
        }
    }
    botonNext.setOnClickListener{
        if(num==(total-2) && num!=152){
            num=0
            muestraPokenum(num,1)
        }
        if(num<(total-2) && num!=152){
            num++
            muestraPokenum(num,1)
        }
        if(num==152){
            muestraPokenum(152,0)
        }
    }



}

override fun onResume() {//establece por defecto al cargar
    super.onResume()
    val pokemonName = intent.getStringExtra("pokemon_name")
    var num = intent.getIntExtra("num", 0)
    for(i in listaPoke){
        if(i.name==pokemonName){
            num= listaPoke.indexOf(i)
        }
    }
    muestraPokenum(num,0)
}

//genera los valores para el elemento de la listaPoke y aplica efectos - Usa num -index en la lista y sentido -izq o der -0 para búsquedas
fun muestraPokenum(num: Int, sentido:Int) {
    val sprite = findViewById<ImageView>(R.id.foto)
    val texto = findViewById<TextView>(R.id.nombre)
    val descripcion = findViewById<TextView>(R.id.desc)

    when (sentido) {
        1 -> { // Slide left
            val animation = sprite.animate().translationX(-sprite.width.toFloat()).setDuration(200)
            animation.withEndAction {
                texto.text = listaPoke[num].name
                descripcion.text = listaPoke[num].desc
                sprite.setImageResource(listaPoke[num].foto)

                sprite.translationX = sprite.width.toFloat()
                texto.translationX = sprite.width.toFloat()
                descripcion.translationX = sprite.width.toFloat()

                sprite.animate().translationX(0f).setDuration(200).start()
                texto.animate().translationX(0f).setDuration(200).start()
                descripcion.animate().translationX(0f).setDuration(200).start()
            }.start()

            // Apply the same animation to texto and descripcion
            texto.animate().translationX(-texto.width.toFloat()).setDuration(200).withEndAction {
                texto.translationX = texto.width.toFloat()
                texto.animate().translationX(0f).setDuration(200).start()
            }.start()
            descripcion.animate().translationX(-descripcion.width.toFloat()).setDuration(200).withEndAction {
                descripcion.translationX = descripcion.width.toFloat()
                descripcion.animate().translationX(0f).setDuration(200).start()
            }.start()
        }
        -1 -> { // Slide right
            val animation = sprite.animate().translationX(sprite.width.toFloat()).setDuration(200)
            animation.withEndAction {
                texto.text = listaPoke[num].name
                descripcion.text = listaPoke[num].desc
                sprite.setImageResource(listaPoke[num].foto)

                sprite.translationX = -sprite.width.toFloat()
                texto.translationX = -texto.width.toFloat()
                descripcion.translationX = -descripcion.width.toFloat()

                sprite.animate().translationX(0f).setDuration(200).start()
                texto.animate().translationX(0f).setDuration(200).start()
                descripcion.animate().translationX(0f).setDuration(200).start()
            }.start()

            // Apply the same animation to texto and descripcion
            texto.animate().translationX(texto.width.toFloat()).setDuration(200).withEndAction {
                texto.translationX = -texto.width.toFloat()
                texto.animate().translationX(0f).setDuration(200).start()
            }.start()
            descripcion.animate().translationX(descripcion.width.toFloat()).setDuration(200).withEndAction {
                descripcion.translationX = -descripcion.width.toFloat()
                descripcion.animate().translationX(0f).setDuration(200).start()
            }.start()
        }
        0 -> {//fade para búsquedas
            sprite.animate().alpha(0f).setDuration(200).withEndAction {
                // Update the views with new data
                texto.text = listaPoke[num].name
                descripcion.text = listaPoke[num].desc
                sprite.setImageResource(listaPoke[num].foto)

                // Fade in the updated views
                sprite.animate().alpha(1f).setDuration(200).start()
                texto.animate().alpha(1f).setDuration(200).start()
                descripcion.animate().alpha(1f).setDuration(200).start()
            }.start()
        }
    }
}

//


private lateinit var gestureDetector: GestureDetectorCompat
override fun onTouchEvent(event: MotionEvent): Boolean {
    return gestureDetector.onTouchEvent(event) || super.onTouchEvent(event)
}
*/