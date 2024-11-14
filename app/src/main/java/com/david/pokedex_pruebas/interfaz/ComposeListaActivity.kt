package com.david.pokedex_pruebas.interfaz

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.david.pokedex_pruebas.R
import com.david.pokedex_pruebas.modelo.PokemonFB
import com.david.pokedex_pruebas.modelo.enumToDrawableFB
import com.david.pokedex_pruebas.modelo.listaPokeFB
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.delay

private lateinit var refBBDD: DatabaseReference

/*
private lateinit var refStorage: StorageReference
private lateinit var identificador: String*/

class ComposeListaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        refBBDD = FirebaseDatabase.getInstance().reference

        var listaPokeFireBase by mutableStateOf<List<PokemonFB>>(emptyList())
        var isLoading by mutableStateOf(true)
        refBBDD.child("pokemones").get().addOnSuccessListener { dataSnapshot ->
            val pokemonList = mutableListOf<PokemonFB>()
            for (childSnapshot in dataSnapshot.children) {
                val pokemon = childSnapshot.getValue(PokemonFB::class.java)
                pokemon?.let { pokemonList.add(it) }
            }
            listaPokeFireBase = pokemonList
            isLoading = false // Está cargando
        }.addOnFailureListener { exception ->
            Toast.makeText(
                this,
                "Error al cargar los datos de la base de datos",
                Toast.LENGTH_SHORT
            ).show()
            isLoading = false
        }

        //enableEdgeToEdge()
        setContent {
            //VerListaPoke(listaPokeFB, isLoading)//Local
            VerListaPoke(listaPokeFireBase, isLoading)//FireBase -- false
        }
    }
}

@Composable
fun VerListaPoke(pokemonList: List<PokemonFB>, isLoading: Boolean) {
    var selectedItemIndex by remember { mutableStateOf(0) }
    var campoBusqueda by remember { mutableStateOf(false) }
    var textobusqueda by remember { mutableStateOf("") }
    val focusRequester = remember { FocusRequester() }
    var listaFiltrada by remember { mutableStateOf(pokemonList) }
    var arrayPoke=ArrayList<PokemonFB>()
    arrayPoke.addAll(pokemonList)


    if (isLoading) { //se asegura de haber cargado los datos de la nube antes de empezar a mostrar nada
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(R.color.lista_con_foco)),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                color = colorResource(R.color.white),
                strokeWidth = 10.dp,
                modifier = Modifier.size(100.dp)
            )
        }
    } else {//cuando ha cargado, comienza a mostrar cosas

        LaunchedEffect(textobusqueda) {//filtramos la lista con la búsqueda de textobusqueda
            delay(200)
            listaFiltrada = if (textobusqueda.isEmpty()) {
                pokemonList // Show all items when search is empty
            } else {
                pokemonList.filter { pokemon ->
                    pokemon.name.contains(textobusqueda, ignoreCase = true)
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                //.padding(vertical = 15.dp)
                .background(colorResource(R.color.lista_con_foco))
        ) {
            ConstraintLayout {
                val (pokeball, pokemonImage, numero, pokemonName, tipo1, tipo2, menu, lazy, boton, layoutBusqueda) = createRefs()
                //val scrollState = rememberScrollState()
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 60.dp)
                        .constrainAs(lazy) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            bottom.linkTo(boton.top)
                        }
                ) {//recyclerview
                    items(listaFiltrada) { pokemon ->
                    //val pokemon = pokemonList[index]
                        val context = LocalContext.current
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 8.dp)

                                .clickable(
                                    onClick = {


                                        val index = pokemonList.indexOf(pokemon)
                                        selectedItemIndex = index
                                        val intent =
                                            Intent(context, ComposeVistaActivity::class.java)
                                        intent.putParcelableArrayListExtra("lista", arrayPoke)
                                        intent.putExtra("indice", index)
                                        context.startActivity(intent)

                                        /*
                                        ///////////////////////////////////////////////////////////////////////////// NO BORRAR - sirve para actualizar FIREBASE cuando se pulsa un elemento cualquiera de la lista
                                                                            //sube a Firebase
                                                                            //refStorage = FirebaseStorage.getInstance().reference
                                                                            for(i in pokemonList){
                                                                                identificador = refBBDD.child("pokemones").push().key!!
                                                                                refBBDD.child("pokemones").child(identificador).setValue(i)/*
                                                                                refStorage.child("pokemones").child(identificador).putFile(
                                                                                    Uri.parse("android.resource://com.david.pokedex_pruebas/drawable/${i.foto}"))*/
                                                                            }
                                        /////////////////////////////////////////////////////////////////////////
                                        */

                                    }


                                )
                        ) {

                            var num = "${(pokemon.num)}"
                            if (num.length == 1) num = "00${(pokemon.num)}"
                            else if (num.length == 2) num = "0${(pokemon.num)}"

                            ConstraintLayout(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(colorResource(R.color.objeto_lista))
                                    .padding(end = 30.dp)
                            ) {

                                Image(
                                    painter = painterResource(id = R.drawable.pokeball_icon),
                                    contentDescription = "Pokeball",
                                    modifier = Modifier
                                        .size(60.dp)
                                        .padding(5.dp)
                                        .constrainAs(pokeball) {
                                            start.linkTo(parent.start)
                                            top.linkTo(parent.top)
                                        }
                                )
                                Image(
                                    painter = painterResource(id = pokemon.foto),
                                    contentDescription = "Pokemon Image",
                                    modifier = Modifier
                                        .size(100.dp)
                                        .fillMaxSize()
                                        .constrainAs(pokemonImage) {
                                            start.linkTo(parent.start)
                                            top.linkTo(parent.top)
                                            bottom.linkTo(parent.bottom)
                                        }
                                )
                                Text(
                                    text = "#$num",
                                    color = Color.Black,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier
                                        .padding(start = 15.dp)
                                        .constrainAs(numero) {
                                            start.linkTo(pokemonImage.end)
                                            top.linkTo(parent.top)
                                            bottom.linkTo(tipo1.top)
                                            end.linkTo(pokemonName.start)
                                        }
                                )
                                Text(
                                    text = pokemon.name,
                                    color = Color.Black,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier
                                        .padding(start = 20.dp)
                                        .constrainAs(pokemonName) {
                                            start.linkTo(numero.end)
                                            top.linkTo(parent.top)
                                            bottom.linkTo(tipo1.top)
                                            end.linkTo(parent.end)
                                        }
                                )
                                if (pokemon.tipo.size == 1) {
                                    Image(
                                        painter = painterResource(id = enumToDrawableFB(pokemon.tipo[0])),
                                        contentDescription = "Tipo 1",
                                        contentScale = ContentScale.Fit,
                                        modifier = Modifier
                                            .width(60.dp)
                                            .height(25.dp)
                                            .constrainAs(tipo1) {
                                                start.linkTo(numero.start)
                                                bottom.linkTo(parent.bottom)
                                                top.linkTo(pokemonName.bottom)
                                                end.linkTo(pokemonName.end)
                                            }
                                    )
                                } else {
                                    Image(
                                        painter = painterResource(id = enumToDrawableFB(pokemon.tipo[0])),
                                        contentDescription = "Tipo 1",
                                        contentScale = ContentScale.Fit,
                                        modifier = Modifier
                                            .width(60.dp)
                                            .height(25.dp)
                                            .constrainAs(tipo1) {
                                                start.linkTo(numero.start)
                                                bottom.linkTo(parent.bottom)
                                                top.linkTo(pokemonName.bottom)
                                                end.linkTo(tipo2.start)
                                            }
                                    )
                                    Image(
                                        painter = painterResource(id = enumToDrawableFB(pokemon.tipo[1])),
                                        contentDescription = "Tipo 2",
                                        contentScale = ContentScale.Fit,
                                        modifier = Modifier
                                            .width(60.dp)
                                            .height(25.dp)
                                            .constrainAs(tipo2) {
                                                start.linkTo(tipo1.end)
                                                bottom.linkTo(parent.bottom)
                                                top.linkTo(pokemonName.bottom)
                                                end.linkTo(pokemonName.end)
                                            }
                                    )
                                }
                            }
                        }

                    }
                }
                Button(
                    onClick = {
                        campoBusqueda = !campoBusqueda
                    },
                    modifier = Modifier
                        .size(120.dp)
                        .padding(20.dp)
                        .wrapContentHeight()
                        .constrainAs(boton) {
                            start.linkTo(parent.start)
                            bottom.linkTo(parent.bottom)
                        },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.fuego), // Cambia el color de fondo a rojo
                        contentColor = Color.White // Cambia el color del contenido a blanco
                    )
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.lupa),
                        contentDescription = "Menu",
                        contentScale = ContentScale.FillWidth
                    )
                    Text(text = "Menu")
                }
                if (campoBusqueda) {
                    ConstraintLayout(
                        modifier = Modifier
                            .constrainAs(layoutBusqueda) {
                                top.linkTo(boton.top)
                                start.linkTo(boton.end)
                                end.linkTo(parent.end)
                                bottom.linkTo(parent.bottom)
                            }
                            .padding(top = 10.dp)
                    ) {
                        // Content of the new ConstraintLayout
                        OutlinedTextField(
                            value = textobusqueda,
                            onValueChange = { textobusqueda = it },
                            label = { Text("Buscar") },
                            modifier = Modifier
                                .padding(horizontal = 15.dp)
                                .background(color=colorResource(id = R.color.white))
                                .onFocusChanged { focusState ->
                                    if (!focusState.isFocused) {
                                        textobusqueda = ""
                                    }
                                }
                                .focusRequester(focusRequester), // Add this line
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Filled.Search,
                                    contentDescription = "Buscar"
                                )
                            },
                            shape = RoundedCornerShape(16.dp)

                        )

                    }
                }
            }


        }


    }
}






































@Preview(showBackground = true)
@Composable
fun PokemonCardPreview() {
    VerListaPoke(listaPokeFB, false)
}




