
package com.david.pokedex_pruebas.interfaz


import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.checkScrollableContainerConstraints
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.type
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.test.filter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import com.david.pokedex_pruebas.R
import com.david.pokedex_pruebas.api.ApiService
import com.david.pokedex_pruebas.api.PokeApiResponse
import com.david.pokedex_pruebas.api.modelo.PokeInfoViewModel
import com.david.pokedex_pruebas.api.modelo.Pokemon
import com.david.pokedex_pruebas.api.modelo.RetrofitClient
import com.david.pokedex_pruebas.api.modelo.Type
import com.david.pokedex_pruebas.api.modelo.TypeToDrawableAPI
import com.david.pokedex_pruebas.api.modelo.TypeToDrawableAPI_grandes
import com.david.pokedex_pruebas.modelo.PokemonFB
import com.david.pokedex_pruebas.modelo.PokemonTipoFB
import com.david.pokedex_pruebas.modelo.enumToDrawableFB_busqueda
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import io.appwrite.Client
import io.appwrite.services.Storage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


//para firebase
//private lateinit var refBBDD: DatabaseReference
//private lateinit var usuario_key: String
var campoBusqueda by mutableStateOf(false)
//para appwrite
val appwrite_project = "6738854a0011e2bc643f"
val appwrite_bucket = "67724c8b003318e75004"

val client = Client()
    .setEndpoint("https://cloud.appwrite.io/v1")
    .setProject(appwrite_project)
val storage = Storage(client)//habilitar para subir archivos

lateinit var scope: CoroutineScope
var listaPokeFireBase by mutableStateOf<List<PokemonFB>>(emptyList())
var isLoadingAPI by mutableStateOf(true)
var muestraGen by mutableStateOf<List<Int>>(emptyList())
//appwrite bucket
//https://cloud.appwrite.io/console/project-6738854a0011e2bc643f/storage

//firebase realtime database
//https://console.firebase.google.com/u/0/project/com-david-pokedexpruebas/database/com-david-pokedexpruebas-default-rtdb/data/~2F?hl=es-419

class ComposeListaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //refBBDD = FirebaseDatabase.getInstance().reference
/*
        if (intent.hasExtra("sesion")) {
            usuario_key = intent.getStringExtra("sesion").toString()
        }else{
            usuario_key = ""
        }*/


        //var listaPokeFireBase by mutableStateOf<List<PokemonFB>>(emptyList())
        /* RESTABLECER PARA FIREBASE!!!!!!!!!!!!!!
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
        */


        //enableEdgeToEdge()
            //VerListaPoke(listaPokeFB, false)//Local
        setContent {
            scope = rememberCoroutineScope()
            VerListaPokeAPI(listaByGen(1))


        }
    //evita el cierre al pulsar Back cuando se sólo se quiere cerrar la búsqueda

    }
    override fun onBackPressed() {
        if (campoBusqueda) {
            campoBusqueda = false // Change campoBusqueda to false
        } else {
            super.onBackPressed() // Default back press behavior (close the app)
        }
    }
}

/*ORIGINAL - FUNCIONA - NO BORRAR
@SuppressLint("UnrememberedMutableState")
@Composable
fun VerListaPoke(pokemonList: List<PokemonFB>, isLoading: Boolean) {
    //var selectedItemIndex by remember { mutableStateOf(0) }
    //var sesion = UsuarioFromKey(usuario_key, refBBDD)

    var busquedaTipos by remember { mutableStateOf(false) }
    var textobusqueda by remember { mutableStateOf("") }
    var tipoBuscado1 by remember { mutableStateOf("") }
    var tipoBuscado2 by remember { mutableStateOf("") }
    var listaFiltrada by remember { mutableStateOf(pokemonList) }
    val generations = listOf("1", "2", "3", "4", "5","6","7","8","9")
    val selectedGenerations = remember { mutableStateMapOf<String, Boolean>() }
    val selectedGenerationsList = remember { mutableStateListOf<String>() }
    val selectedGenerationsKey by derivedStateOf { selectedGenerations.filter { it.value }.keys }
    LaunchedEffect(Unit) {
        generations.forEach { generation ->
            selectedGenerations[generation] = false
        }
    }
    val listState1 = rememberLazyListState(
        initialFirstVisibleItemIndex = 0
    )
    val listState2 = rememberLazyListState(
        initialFirstVisibleItemIndex = 0
    )

    //efectos
    val alturaCampoBusqueda by animateFloatAsState(
        targetValue = if (campoBusqueda) 300f else 0f,
        animationSpec = tween(durationMillis = 300) // duración
    )
    val context = LocalContext.current


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

        LaunchedEffect(selectedGenerationsKey, textobusqueda, tipoBuscado1, tipoBuscado2) {
            selectedGenerationsList.clear()
            selectedGenerationsKey.forEach { generation ->
                selectedGenerationsList.add(generation)
            }

            delay(200) // You might not need this delay

            listaFiltrada = pokemonList.filter { pokemon ->
                (textobusqueda.isEmpty() || pokemon.name.contains(textobusqueda, ignoreCase = true)) &&
                        (tipoBuscado1.isEmpty() || pokemon.tipo.any { it.tag.contains(tipoBuscado1, ignoreCase = true) }) &&
                        (tipoBuscado2.isEmpty() || pokemon.tipo.any { it.tag.contains(tipoBuscado2, ignoreCase = true) }) && // New condition for tipoBuscado2
                        (selectedGenerationsList.isEmpty() || selectedGenerationsList.contains(pokemon.gen))
            }
        }


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(R.color.lista_con_foco))
        ) {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 0.dp)
                    .systemBarsPadding()
                    .imePadding()
            ) {
                val (generaciones,lazyC, boton, layoutBusqueda, busquedaTipo, descBusqueda, switchBusqueda, botonUserActivity) = createRefs()

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .zIndex(2f)
                        .constrainAs(botonUserActivity) {
                            top.linkTo(parent.top)
                            end.linkTo(parent.end)
                        },
                    horizontalArrangement = Arrangement.End
                ){
                    UserButton(context,1)//opc 1 para que abra la actividad del perfil
                }

                LazyColumn(
                    modifier = Modifier
                        //.fillMaxWidth()
                        .fillMaxSize()/////////
                        .constrainAs(lazyC) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            if (campoBusqueda) bottom.linkTo(parent.bottom)
                            else bottom.linkTo(parent.bottom)
                        }
                ) {
                    items(listaFiltrada) { pokemon ->
//                        var isPressed by remember { mutableStateOf(false) }
//                        val interactionSource = remember { MutableInteractionSource() }
//                        val scale = animateFloatAsState(
//                            targetValue = if (isPressed) 0.90f else 1f,
//                            animationSpec = spring(
//                                dampingRatio = Spring.DampingRatioMediumBouncy, // Moderate bouncing
//                                stiffness = Spring.StiffnessMedium // Moderate stiffness
//                            )
//                        )
                        PokemonCard(pokemon, usuario_key,1)
                        Log.d("Pokemon", "Pokemon: $pokemon")

                    }
                }
                Button(
                    onClick = {
                        campoBusqueda = !campoBusqueda
                        tipoBuscado1=""
                        tipoBuscado2=""
                        textobusqueda=""
                    },
                    modifier = Modifier
                        .size(120.dp)
                        .padding(20.dp)
                        .constrainAs(boton) {
                            end.linkTo(parent.end)
                            if (campoBusqueda) bottom.linkTo(layoutBusqueda.top)
                            else bottom.linkTo(parent.bottom)
                        },

                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 10.dp
                    ),
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


                //BUSQUEDA

                if (campoBusqueda || alturaCampoBusqueda > 0f) {
                    Row (
                        modifier = Modifier
                            .constrainAs(layoutBusqueda) {
                                //top.linkTo(parent.top)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                                bottom.linkTo(parent.bottom)
                                linkTo(layoutBusqueda.bottom, parent.bottom, bias = 1f)
                            }
                            .background(colorResource(R.color.fuego))
                            .height(alturaCampoBusqueda.dp)
                            .padding(horizontal = 10.dp)
                            .clickable(
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() }
                            ) {},
                    ){
                        Column(
                            modifier = Modifier
                                .wrapContentHeight()
                                .weight(0.2f)//weight horizontal
                                .padding(vertical = 20.dp)

                        ) {
                            //tipo 1
                            LazyColumn(state=listState1,flingBehavior = rememberSnapFlingBehavior(lazyListState = listState1)){
                                items(PokemonTipoFB.entries.dropLast(1)) { tipo ->
                                    Image(
                                        painter = painterResource(id = enumToDrawableFB_busqueda(tipo)),
                                        contentDescription = "Tipo",
                                        contentScale = ContentScale.Fit,
                                        modifier = Modifier
                                            .padding(all = 5.dp)
                                            .width(60.dp)
                                            .wrapContentHeight()
                                            .clickable(
                                                onClick = {
                                                    tipoBuscado1 = tipo.tag
                                                }
                                            )
                                    )
                                }
                            }
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxHeight()
                                .weight(0.75f)//weight horizontal
                                .padding(horizontal = 30.dp),
                            verticalArrangement = Arrangement.Center
                        ) {

                            //por nombre
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(0.25f),//weight vertical
                            ){
                                OutlinedTextField(
                                    value = textobusqueda,
                                    onValueChange = { textobusqueda = it },
                                    label = { Text(
                                        color= colorResource(R.color.white),
                                        text="Buscar") },
                                    modifier = Modifier
                                        .padding(top = 15.dp)
                                        .fillMaxWidth()
                                        .background(colorResource(id = R.color.transparente))
                                        .clip(RoundedCornerShape(10.dp)),
                                    leadingIcon = {
                                        Icon(
                                            imageVector = Icons.Filled.Search,
                                            tint = colorResource(id = R.color.white),
                                            contentDescription = "Buscar"
                                        )
                                    },
                                    placeholder = { Text("nombre del Pokémon",style = TextStyle(color = colorResource(id = R.color.white)))},
                                    shape = RoundedCornerShape(16.dp),
                                    colors = OutlinedTextFieldDefaults.colors(
                                        focusedBorderColor = colorResource(R.color.white),
                                        unfocusedBorderColor = colorResource(R.color.white),
                                        cursorColor = colorResource(R.color.white),
                                        focusedContainerColor= colorResource(R.color.rojo_muy_claro),
                                        unfocusedContainerColor=colorResource(R.color.rojo_claro),
                                        focusedTextColor= colorResource(R.color.white),
                                        unfocusedTextColor= colorResource(R.color.white),
                                    )
                                )
                            }
                            //Por generación
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(0.4f),//weight vertical
                                verticalAlignment = Alignment.CenterVertically
                            ){
                                LazyVerticalGrid(
                                    columns = GridCells.Fixed(3), // Adjust the number of columns as needed
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .wrapContentHeight(),
                                    verticalArrangement = Arrangement.Top,
                                    horizontalArrangement = Arrangement.spacedBy(0.dp), // Add horizontal spacing

                                ) {
                                    items(generations) { generation ->
                                        Row(verticalAlignment = Alignment.CenterVertically) {
                                            Checkbox(
                                                checked = selectedGenerations[generation] ?: false,
                                                onCheckedChange = { isChecked ->
                                                    selectedGenerations[generation] = isChecked
                                                },
                                                colors = CheckboxDefaults.colors(
                                                    checkedColor = colorResource(R.color.planta),
                                                    uncheckedColor = Color.White,
                                                    checkmarkColor = Color.White
                                                )
                                            )
                                            Text(
                                                text = generation,
                                                fontSize = 20.sp,
                                                color = colorResource(R.color.white),
                                                fontWeight = FontWeight.Bold,
                                                modifier = Modifier.padding(end = 0.dp)
                                            )
                                        }
                                    }
                                }
                            }
                            LazyRow(modifier = Modifier.weight(0.22f), state=listState2,flingBehavior = rememberSnapFlingBehavior(lazyListState = listState2)){
                                items(PokemonTipoFB.entries.dropLast(1)) { tipo ->
                                    Image(
                                        painter = painterResource(id = enumToDrawableFB_busqueda(tipo)),
                                        contentDescription = "Tipo",
                                        contentScale = ContentScale.Fit,
                                        modifier = Modifier
                                            .padding(start = 5.dp, end = 5.dp)
                                            .width(55.dp)
                                            .wrapContentHeight()
                                            .clickable(
                                                onClick = {
                                                    tipoBuscado2 = tipo.tag
                                                }
                                            )
                                    )
                                }
                            }
                        }


                    }


















//                    ConstraintLayout(
//                        modifier = Modifier
//                            .constrainAs(layoutBusqueda) {
//                                //top.linkTo(parent.top)
//                                start.linkTo(parent.start)
//                                end.linkTo(parent.end)
//                                bottom.linkTo(parent.bottom)
//                                linkTo(layoutBusqueda.bottom, parent.bottom, bias = 1f)
//                            }
//                            .background(colorResource(R.color.fuego))
//                            .height(alturaCampoBusqueda.dp)
//                            .padding(horizontal = 20.dp)
//                    ) {
//                        var tipoBus=""
//                        if(!busquedaTipos)tipoBus="NOMBRE"
//                        else tipoBus="TIPO"
//                        Text(
//                            text = "$tipoBus",
//                            fontSize = 18.sp,
//                            color = colorResource(R.color.white),
//                            fontWeight = FontWeight.Bold,
//                            modifier = Modifier
//                                .constrainAs(descBusqueda) {
//                                    top.linkTo(parent.top)
//                                    start.linkTo(parent.start)
//                                    end.linkTo(switchBusqueda.start)
//                                    bottom.linkTo(busquedaTipo.top)
//                                }
//                                .padding(horizontal = 10.dp)
//                        )
//                        Switch(
//                            modifier = Modifier
//                                .constrainAs(switchBusqueda){
//                                    top.linkTo(parent.top)
//                                    //start.linkTo(descBusqueda.end)
//                                    bottom.linkTo(busquedaTipo.top)
//                                    end.linkTo(parent.end)
//                                },
//                            checked = busquedaTipos,
//                            onCheckedChange = {
//                                busquedaTipos = it
//                            }
//                        )
//                        if(!busquedaTipos)OutlinedTextField(
//                            value = textobusqueda,
//                            onValueChange = { textobusqueda = it },
//                            label = { Text(
//                                color= colorResource(R.color.white),
//                                text="Buscar") },
//                            modifier = Modifier
//                                .padding(vertical = 20.dp)
//                                .fillMaxWidth()
//                                .background(colorResource(id = R.color.transparente))
//                                .constrainAs(busquedaTipo) {
//                                    top.linkTo(switchBusqueda.bottom)
//                                    //start.linkTo(parent.start)
//                                    //end.linkTo(parent.end)
//                                    bottom.linkTo(generaciones.top)
//                                }
//                                .clip(RoundedCornerShape(10.dp)),
//                            leadingIcon = {
//                                Icon(
//                                    imageVector = Icons.Filled.Search,
//                                    contentDescription = "Buscar"
//                                )
//                            },
//                            placeholder = { Text("nombre del Pokémon") },
//                            shape = RoundedCornerShape(16.dp),
//                            colors = OutlinedTextFieldDefaults.colors(
//                                focusedBorderColor = colorResource(R.color.white),
//                                unfocusedBorderColor = colorResource(R.color.acero),
//                                cursorColor = colorResource(R.color.white),
//                                focusedContainerColor= colorResource(R.color.rojo_muy_claro),
//                                focusedTextColor= colorResource(R.color.white),
//                                unfocusedTextColor= colorResource(R.color.acero),
//                            )
//
//                        )
//                        else{
//                            LazyRow (
//                                modifier = Modifier
//                                    .padding(vertical = 20.dp)
//                                    //.wrapContentHeight()
//                                    .fillMaxWidth()
//                                    .constrainAs(busquedaTipo) {
//                                        top.linkTo(switchBusqueda.bottom)
//                                        //start.linkTo(parent.start)
//                                        //end.linkTo(parent.end)
//                                        bottom.linkTo(generaciones.top)
//                                    },
//                            ){
//                                items(PokemonTipoFB.entries.dropLast(1)) { tipo ->
//                                    Image(
//                                        painter = painterResource(id = enumToDrawableFB_busqueda(tipo)),
//                                        contentDescription = "Tipo",
//                                        contentScale = ContentScale.Fit,
//                                        modifier = Modifier
//                                            .padding(horizontal = 5.dp)
//                                            .width(60.dp)
//                                            .wrapContentHeight()
//                                            .clickable(
//                                                onClick = {
//                                                    tipoBuscado = tipo.tag
//                                                }
//                                            )
//                                    )
//                                }
//                            }
//                        }
//
//                        Row(modifier = Modifier
//                            .constrainAs(generaciones) {
//                                top.linkTo(busquedaTipo.bottom)
//                                bottom.linkTo(parent.bottom)
//                            }
//                            .fillMaxWidth()
//                        ){
//                            Row(
//                                modifier = Modifier
//                                    .wrapContentHeight()
//                                    .weight(0.5f),
//                                horizontalArrangement =  Arrangement.Center,
//                            ){
//                                Text(text = "GEN",
//                                    fontSize = 15.sp,
//                                    color = colorResource(R.color.white),
//                                    fontWeight = FontWeight.Bold,
//                                    modifier = Modifier
//                                        .wrapContentSize()
//                                )
//                            }
//                            Row(modifier = Modifier
//                                .wrapContentHeight()
//                                .weight(0.5f),
//                                horizontalArrangement = Arrangement.Center,
//                                verticalAlignment = Alignment.CenterVertically
//                            ){
//                                generations.forEach { generation ->
//                                    Text(
//                                        text = generation,
//                                        fontSize = 15.sp,
//                                        color = colorResource(R.color.white),
//                                        fontWeight = FontWeight.Bold,
//                                        modifier = Modifier
//                                    )
//                                    Checkbox(
//                                        checked = selectedGenerations[generation] ?: false,
//                                        onCheckedChange = { isChecked ->
//                                            selectedGenerations[generation] = isChecked
//                                        }
//                                    )
//
//                                }
//                            }
//                        }
//
//                    }
                }
            }
        }
    }
}
*/






@SuppressLint("UnrememberedMutableState")
@Composable
fun VerListaPokeAPI(listaApi: List<Pokemon>) {
    var busquedaTipos by remember { mutableStateOf(false) }
    var textobusqueda by remember { mutableStateOf("") }
    var tipoBuscado1 by remember { mutableStateOf("") }
    var tipoBuscado2 by remember { mutableStateOf("") }
    var listaFiltrada by remember { mutableStateOf(listaApi) }
    val listaTipos = listaTipos()
    Log.d("ListaTipos", listaTipos.toString())
    val listState1 = rememberLazyListState(
        initialFirstVisibleItemIndex = 0
    )
    val listState2 = rememberLazyListState(
        initialFirstVisibleItemIndex = 0
    )

    //efectos
    val alturaCampoBusqueda by animateFloatAsState(
        targetValue = if (campoBusqueda) 300f else 0f,
        animationSpec = tween(durationMillis = 300) // duración
    )
    val context = LocalContext.current



    val viewModel: PokeInfoViewModel = viewModel()
    if (isLoadingAPI) { //se asegura de haber cargado los datos de la nube antes de empezar a mostrar nada
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(R.color.lista_con_foco))
                .padding(top = 0.dp) // Apply padding to the Box
                .systemBarsPadding()
                .imePadding(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                color = colorResource(R.color.white),
                strokeWidth = 10.dp,
                modifier = Modifier.size(100.dp)
            )
        }
    } else {

        LaunchedEffect(textobusqueda, tipoBuscado1, tipoBuscado2) {
            // Removed selectedGenerationsKey from LaunchedEffect and the filtering logic

            delay(200) // You might not need this delay

            listaFiltrada = listaApi.filter { pokemon ->
                (textobusqueda.isEmpty() || pokemon.name.contains(textobusqueda, ignoreCase = true)) &&
                        (tipoBuscado1.isEmpty() || pokemon.types.any { it.type.name.contains(tipoBuscado1, ignoreCase = true) }) &&
                        (tipoBuscado2.isEmpty() || pokemon.types.any { it.type.name.contains(tipoBuscado2, ignoreCase = true) })
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(R.color.lista_con_foco))
                .padding(top = 0.dp) // Apply padding to the Box
                .systemBarsPadding()
                .imePadding()
        ) {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                val (generaciones,lazyC, boton, layoutBusqueda, busquedaTipo, descBusqueda, switchBusqueda, botonUserActivity) = createRefs()

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .zIndex(2f)
                        .constrainAs(botonUserActivity) {
                            top.linkTo(parent.top)
                            end.linkTo(parent.end)
                        },
                    horizontalArrangement = Arrangement.End
                ){
                    UserButton(context,1)//opc 1 para que abra la actividad del perfil
                }

                LazyColumn(
                    modifier = Modifier
                        //.fillMaxWidth()
                        .fillMaxSize()
                        .constrainAs(lazyC) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            if (campoBusqueda) bottom.linkTo(parent.bottom)
                            else bottom.linkTo(parent.bottom)
                        }
                ) {
                    items(listaFiltrada) { pokemon ->
                        Log.d("PokemonList", "Pokemon: $pokemon")
                        PokemonCardApi(pokemon, viewModel)
                        Log.d("POKEMON DE API", pokemon.toString())
                    }
                }
                Button(
                    onClick = {
                        campoBusqueda = !campoBusqueda
                        tipoBuscado1=""
                        tipoBuscado2=""
                        textobusqueda=""
                    },
                    modifier = Modifier
                        .size(120.dp)
                        .padding(20.dp)
                        .constrainAs(boton) {
                            end.linkTo(parent.end)
                            if (campoBusqueda) bottom.linkTo(layoutBusqueda.top)
                            else bottom.linkTo(parent.bottom)
                        },

                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 10.dp
                    ),
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


                //BUSQUEDA

                if (campoBusqueda || alturaCampoBusqueda > 0f) {
                    Row (
                        modifier = Modifier
                            .constrainAs(layoutBusqueda) {
                                //top.linkTo(parent.top)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                                bottom.linkTo(parent.bottom)
                                linkTo(layoutBusqueda.bottom, parent.bottom, bias = 1f)
                            }
                            .background(colorResource(R.color.fuego))
                            .height(alturaCampoBusqueda.dp)
                            .padding(horizontal = 10.dp)
                            .clickable(
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() }
                            ) {},
                    ){
                        Column(
                            modifier = Modifier
                                .wrapContentHeight()
                                .weight(0.2f)//weight horizontal
                                .padding(vertical = 20.dp)

                        ) {
                            //tipo 1
                            LazyColumn(state=listState1,flingBehavior = rememberSnapFlingBehavior(lazyListState = listState1)){
                                items(listaTipos.dropLast(1)) { tipo ->
                                    Image(
                                        painter = painterResource(id = TypeToDrawableAPI_grandes(tipo)),
                                        contentDescription = "Tipo",
                                        contentScale = ContentScale.Fit,
                                        modifier = Modifier
                                            .padding(all = 5.dp)
                                            .width(60.dp)
                                            .wrapContentHeight()
                                            .clickable(
                                                onClick = {
                                                    tipoBuscado1 = tipo.type.name
                                                }
                                            )
                                    )
                                }
                            }
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxHeight()
                                .weight(0.75f)//weight horizontal
                                .padding(horizontal = 30.dp),
                            verticalArrangement = Arrangement.Center
                        ) {

                            //por nombre
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(0.25f),//weight vertical
                            ){
                                OutlinedTextField(
                                    value = textobusqueda,
                                    onValueChange = { textobusqueda = it },
                                    label = { Text(
                                        color= colorResource(R.color.white),
                                        text="Buscar") },
                                    modifier = Modifier
                                        .padding(top = 15.dp)
                                        .fillMaxWidth()
                                        .background(colorResource(id = R.color.transparente))
                                        .clip(RoundedCornerShape(10.dp)),
                                    leadingIcon = {
                                        Icon(
                                            imageVector = Icons.Filled.Search,
                                            tint = colorResource(id = R.color.white),
                                            contentDescription = "Buscar"
                                        )
                                    },
                                    placeholder = { Text("nombre del Pokémon",style = TextStyle(color = colorResource(id = R.color.white)))},
                                    shape = RoundedCornerShape(16.dp),
                                    colors = OutlinedTextFieldDefaults.colors(
                                        focusedBorderColor = colorResource(R.color.white),
                                        unfocusedBorderColor = colorResource(R.color.white),
                                        cursorColor = colorResource(R.color.white),
                                        focusedContainerColor= colorResource(R.color.rojo_muy_claro),
                                        unfocusedContainerColor=colorResource(R.color.rojo_claro),
                                        focusedTextColor= colorResource(R.color.white),
                                        unfocusedTextColor= colorResource(R.color.white),
                                    )
                                )
                            }
                            //tipo 2
                            LazyRow(modifier = Modifier.weight(0.22f), state=listState2,flingBehavior = rememberSnapFlingBehavior(lazyListState = listState2)){
                                items(listaTipos.dropLast(1)) { tipo ->
                                    Image(
                                        painter = painterResource(id = TypeToDrawableAPI_grandes(tipo)),
                                        contentDescription = "Tipo",
                                        contentScale = ContentScale.Fit,
                                        modifier = Modifier
                                            .padding(all = 5.dp)
                                            .width(60.dp)
                                            .wrapContentHeight()
                                            .clickable(
                                                onClick = {
                                                    tipoBuscado2 = tipo.type.name
                                                }
                                            )
                                    )
                                }
                            }
                        }

                    }
                }
            }
        }
    }
}




@Composable
fun listaByGen(gen: Int): List<Pokemon> {
    val viewModel: PokeInfoViewModel = viewModel()
    val pokemonListByGen by viewModel.pokemonListByGen.observeAsState(emptyList())

    LaunchedEffect(key1 = gen) {
        isLoadingAPI = true // Set to true before API call
        viewModel.getListByGeneration(gen) // Trigger API call
        // Wait for pokemonListByGen to be populated
        snapshotFlow { pokemonListByGen }
            .filter { it.isNotEmpty() } // Filter until list is not empty
            .collect {
                isLoadingAPI = false // Set to false when data is loaded
            }
    }
    return pokemonListByGen
}
@Composable
fun listaTipos(): List<Type> {
    val viewModel: PokeInfoViewModel = viewModel()
    val pokemonTypeList by viewModel.pokemonTypeList.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        viewModel.getTypeList() // Trigger API call to fetch the type list
    }

    return pokemonTypeList.map { typeInfo ->
        Type(slot = 0, type = typeInfo) // Assuming 'slot' is always 0
    }
}




















