
package com.david.pokedex_pruebas.interfaz


import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import com.david.pokedex_pruebas.R
import com.david.pokedex_pruebas.modelo.PokemonFB
import com.david.pokedex_pruebas.modelo.PokemonTipoFB
import com.david.pokedex_pruebas.modelo.UserFb
import com.david.pokedex_pruebas.modelo.UsuarioFromKey
import com.david.pokedex_pruebas.modelo.enumToDrawableFB_busqueda
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import io.appwrite.Client
import io.appwrite.services.Storage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay


//para firebase
private lateinit var refBBDD: DatabaseReference
private lateinit var usuario_key: String
var campoBusqueda by mutableStateOf(false)
//para appwrite
val appwrite_project = "6738854a0011e2bc643f"
val appwrite_bucket = "6746fbd1000a68a610a6"

val client = Client()
    .setEndpoint("https://cloud.appwrite.io/v1")
    .setProject(appwrite_project)
val storage = Storage(client)//habilitar para subir archivos

lateinit var scope: CoroutineScope
var listaPokeFireBase by mutableStateOf<List<PokemonFB>>(emptyList())

//appwrite bucket
//https://cloud.appwrite.io/console/project-6738854a0011e2bc643f/storage

//firebase realtime database
//https://console.firebase.google.com/u/0/project/com-david-pokedexpruebas/database/com-david-pokedexpruebas-default-rtdb/data/~2F?hl=es-419

class ComposeListaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        refBBDD = FirebaseDatabase.getInstance().reference

        if (intent.hasExtra("sesion")) {
            usuario_key = intent.getStringExtra("sesion").toString()
        }else{
            usuario_key = ""
        }


        //var listaPokeFireBase by mutableStateOf<List<PokemonFB>>(emptyList())
        var isLoading by mutableStateOf(true)
        refBBDD.child("pokemones").get().addOnSuccessListener { dataSnapshot ->
            val pokemonList = mutableListOf<PokemonFB>()
            for (childSnapshot in dataSnapshot.children) {
                val pokemon = childSnapshot.getValue(PokemonFB::class.java)
                pokemon?.let { pokemonList.add(it) }

                //appwrite
                val identificadorAppWrite = childSnapshot.key?.substring(1, 20) ?: "" // coge el identificador
                //pokemon.imagenFB = "https://cloud.appwrite.io/v1/storage/buckets/[BUCKET_ID]/files/[FILE_ID]/preview?project=[PROJECT_ID]"//--plantilla
                if (pokemon != null) {
                    //guarda la URL de la imagen en el objeto PokemonFB como string en pokemon.imagenFB
                    pokemon.imagenFB = "https://cloud.appwrite.io/v1/storage/buckets/$appwrite_bucket/files/$identificadorAppWrite/preview?project=$appwrite_project"
                }

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
            //VerListaPoke(listaPokeFB, false)//Local
            VerListaPoke(listaPokeFireBase, isLoading,UsuarioFromKey(usuario_key, refBBDD))//FireBase,AppWrite -- false
            scope = rememberCoroutineScope()
        }

    }
    //evita el cierre al pulsar Back cuando se sólo se quiere cerrar la búsqueda
    override fun onBackPressed() {
        if (campoBusqueda) {
            campoBusqueda = false // Change campoBusqueda to false
        } else {
            super.onBackPressed() // Default back press behavior (close the app)
        }
    }

}


@SuppressLint("UnrememberedMutableState")
@Composable
fun VerListaPoke(pokemonList: List<PokemonFB>, isLoading: Boolean,sesion:UserFb) {
    var selectedItemIndex by remember { mutableStateOf(0) }

    var busquedaTipos by remember { mutableStateOf(false) }
    var textobusqueda by remember { mutableStateOf("") }
    var tipoBuscado by remember { mutableStateOf("") }
    var listaFiltrada by remember { mutableStateOf(pokemonList) }
    val generations = listOf("1", "2", "3", "4", "5","6","7")
    val selectedGenerations = remember { mutableStateMapOf<String, Boolean>() }
    val selectedGenerationsList = remember { mutableStateListOf<String>() }
    val selectedGenerationsKey by derivedStateOf { selectedGenerations.filter { it.value }.keys }
    LaunchedEffect(Unit) {
        generations.forEach { generation ->
            selectedGenerations[generation] = false
        }
    }
    val listState = rememberLazyListState(
        initialFirstVisibleItemIndex = 0
    )

    //efectos
    val alturaCampoBusqueda by animateFloatAsState(
        targetValue = if (campoBusqueda) 250f else 0f,
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

        LaunchedEffect(key1 = selectedGenerationsKey, key2 = textobusqueda, key3 = tipoBuscado) {
            selectedGenerationsList.clear()
            selectedGenerationsKey.forEach { generation ->
                selectedGenerationsList.add(generation)
            }

            delay(200) // You might not need this delay

            listaFiltrada = pokemonList.filter { pokemon ->
                (textobusqueda.isEmpty() || pokemon.name.contains(textobusqueda, ignoreCase = true)) &&
                        (tipoBuscado.isEmpty() || pokemon.tipo.any { it.tag.contains(tipoBuscado, ignoreCase = true) }) &&
                        // Generation filter
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
                    sesion.key?.let { UserButton(context, it) }
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

                    }
                }
                Button(
                    onClick = {
                        campoBusqueda = !campoBusqueda
                        tipoBuscado=""
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
                            //tipos
                            LazyColumn(state=listState,flingBehavior = rememberSnapFlingBehavior(lazyListState = listState)){
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
                                                    tipoBuscado = tipo.tag
                                                }
                                            )
                                    )
                                }
                            }
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxHeight()
                                .weight(0.8f)//weight horizontal
                                .padding(horizontal = 30.dp),
                            verticalArrangement = Arrangement.Center
                        ) {

                            //por nombre
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(0.5f),//weight vertical
                            ){
                                OutlinedTextField(
                                    value = textobusqueda,
                                    onValueChange = { textobusqueda = it },
                                    label = { Text(
                                        color= colorResource(R.color.white),
                                        text="Buscar") },
                                    modifier = Modifier
                                        .padding(vertical = 20.dp)
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
                                    .weight(0.5f),//weight vertical
                            ){
                                LazyRow(
                                    modifier = Modifier.fillMaxWidth(),flingBehavior = rememberSnapFlingBehavior(lazyListState = listState)
                                    //horizontalArrangement = Arrangement.spacedBy(8.dp) // Add spacing between items
                                ) {
                                    items(generations) { generation ->
                                        Row(verticalAlignment = Alignment.CenterVertically) { // Align Text and Checkbox vertically
                                            Checkbox(
                                                checked = selectedGenerations[generation] ?: false,
                                                onCheckedChange = { isChecked ->
                                                    selectedGenerations[generation] = isChecked
                                                },
                                                colors = CheckboxDefaults.colors(
                                                    checkedColor = colorResource(R.color.planta),  // Color when checked
                                                    uncheckedColor = Color.White, // Color when unchecked
                                                    checkmarkColor = Color.White, // Color of the checkmark

                                                ),
                                            )
                                            Text(
                                                text = generation,
                                                fontSize = 25.sp,
                                                color = colorResource(R.color.white),
                                                fontWeight = FontWeight.Bold,
                                                modifier = Modifier.padding(end = 4.dp)
                                            )
                                        }
                                    }
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




































/*

@Preview(showBackground = true)
@Composable
fun PokemonCardPreview() {
    var userAux=UserFb("","","","https://cloud.appwrite.io/v1/storage/buckets/$appwrite_bucket/files/OC-7tUbUj0_3AIjTMOy/preview?project=$appwrite_project")
    VerListaPoke(listaPokeFB, false, userAux)
}



//una preview para tener desplegado el search bar
@Preview(showBackground = true)
@Composable
fun PokemonCardPreview2() {

}
*/
