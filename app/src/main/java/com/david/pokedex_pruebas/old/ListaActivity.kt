package com.david.pokedex_pruebas.old

import android.os.Bundle
//import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.HorizontalScrollView
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.SearchView
import androidx.appcompat.widget.SwitchCompat
//import androidx.glance.visibility
import com.david.pokedex_pruebas.R
import com.david.pokedex_pruebas.interfaz.ComposeListaActivity
//import com.david.pokedex_pruebas.modelo.busca

class ListaActivity : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)
        val recyclerView: RecyclerView = findViewById(R.id.pokelistRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this@ListaActivity)
        recyclerView.adapter = PokemonAdapter(listaPoke)



        val busqueda = findViewById<SearchView>(R.id.busqueda)
        busqueda.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                var listaAux = listaPoke
                //filtramos la listaAux con la busqueda
                var listaAux2 = listaAux.filter { pokemon ->
                    pokemon.name.contains(query, ignoreCase = true)
                }
                recyclerView.adapter = PokemonAdapter(listaAux2)
                recyclerView.adapter?.notifyDataSetChanged()
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                val query = newText ?: "" // Handle null case
                val listaAux = listaPoke.filter { pokemon ->
                    pokemon.name.contains(query, ignoreCase = true)
                }
                recyclerView.adapter = PokemonAdapter(listaAux)
                recyclerView.adapter?.notifyDataSetChanged()
                return true
            }
        })

        //ABRE LA ACTIVITY DE COMPOSE --eliminar
        val compose = findViewById<ImageButton>(R.id.compose)
        compose.setOnClickListener {
            val intent = Intent(this, ComposeListaActivity::class.java)
            startActivity(intent)
        }

        //para la búsqueda
        var oscurecer = findViewById<LinearLayout>(R.id.oscurece)
        val openBusqueda = findViewById<ImageButton>(R.id.open_menu)
        val bottomLayout = findViewById<LinearLayout>(R.id.bottom)
        openBusqueda.setOnClickListener {
            bottomLayout.visibility = View.VISIBLE
            openBusqueda.visibility = View.GONE
            oscurecer.visibility = View.VISIBLE
            busqueda.visibility=View.VISIBLE
        }

        //para la búsqueda por tipos
        val tipoBusqueda: SwitchCompat = findViewById(R.id.tipo_busqueda)
        val listaTipos: HorizontalScrollView = findViewById(R.id.lista_tipos)
        tipoBusqueda.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                listaTipos.visibility = View.VISIBLE
                openBusqueda.visibility = View.GONE
                busqueda.visibility = View.GONE
                oscurecer.visibility = View.VISIBLE
            } else {
                listaTipos.visibility = View.GONE
                busqueda.visibility = View.VISIBLE
            }
        }

        var tipoElegido=""
        val tiposParaBuscar = listOf(
            findViewById<ImageButton>(R.id.planta).apply { tag = "planta" },
            findViewById<ImageButton>(R.id.agua).apply { tag = "agua" },
            findViewById<ImageButton>(R.id.fuego).apply { tag = "fuego" },
            findViewById<ImageButton>(R.id.lucha).apply { tag = "lucha" },
            findViewById<ImageButton>(R.id.veneno).apply { tag = "veneno" },
            findViewById<ImageButton>(R.id.acero).apply { tag = "acero" },
            findViewById<ImageButton>(R.id.bicho).apply { tag = "bicho" },
            findViewById<ImageButton>(R.id.dragon).apply { tag = "dragon" },
            findViewById<ImageButton>(R.id.electrico).apply { tag = "electrico" },
            findViewById<ImageButton>(R.id.hada).apply { tag = "hada" },
            findViewById<ImageButton>(R.id.hielo).apply { tag = "hielo" },
            findViewById<ImageButton>(R.id.psiquico).apply { tag = "psiquico" },
            findViewById<ImageButton>(R.id.roca).apply { tag = "roca" },
            findViewById<ImageButton>(R.id.tierra).apply { tag = "tierra" },
            findViewById<ImageButton>(R.id.sinistro).apply { tag = "sinistro" },
            findViewById<ImageButton>(R.id.normal).apply { tag = "normal" },
            findViewById<ImageButton>(R.id.volador).apply { tag = "volador" },
            findViewById<ImageButton>(R.id.fantasma).apply { tag = "fantasma" }
        )

        for (i in tiposParaBuscar) {
            i.setOnClickListener {
                tipoElegido=i.tag as String
                //filtramos la listaPoke con la busqueda
                var listaAux = listaPoke.filter { pokemon ->
                    pokemon.tipo.any { it.name.contains(tipoElegido, ignoreCase = true)}
                }
                recyclerView.adapter = PokemonAdapter(listaAux)
                recyclerView.adapter?.notifyDataSetChanged()
            }
        }

        //para cerrar la búsqueda
        val cierraBusqueda = findViewById<ImageButton>(R.id.close_menu)
        cierraBusqueda.setOnClickListener {
            bottomLayout.visibility = View.GONE
            openBusqueda.visibility = View.VISIBLE
            oscurecer.visibility = View.GONE
            listaTipos.visibility = View.GONE
            tipoBusqueda.isChecked = false
        }
        oscurecer.setOnClickListener {
            bottomLayout.visibility = View.GONE
            openBusqueda.visibility = View.VISIBLE
            oscurecer.visibility = View.GONE
            listaTipos.visibility = View.GONE
            tipoBusqueda.isChecked = false
        }





    }
        override fun onResume() {//establece por defecto al cargar
            super.onResume()
            val recyclerView: RecyclerView = findViewById(R.id.pokelistRecyclerView)
            var num = intent.getIntExtra("pos", 0)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = PokemonAdapter(listaPoke)
            //guarda la posición en la lista entre activities, pero sólo durante la ejecución
            val sharedPrefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
            val posicion = sharedPrefs.getInt("pos", 0)
            recyclerView.scrollToPosition(posicion)
            val editor = sharedPrefs.edit()
            editor.putInt("pos", 0)
            editor.apply()
        }

}

/*plantilla de logs
        Log.d("Nombre", currentPokemon.name)
        Log.d("Inmune a 1", drawableToEnum(inmune[0]).toString())
        Log.d("Inmune a 2", drawableToEnum(inmune[1]).toString())*/