package com.david.pokedex_pruebas.interfaz

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.activity.result.launch
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.david.pokedex_pruebas.R
import com.david.pokedex_pruebas.modelo.PokemonFB
import com.david.pokedex_pruebas.modelo.enumToDrawableFB
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.david.pokedex_pruebas.api.ApiService
import com.david.pokedex_pruebas.api.PokeApiResponse
import com.david.pokedex_pruebas.api.modelo.PokeInfoViewModel
import com.david.pokedex_pruebas.api.modelo.Pokemon
import com.david.pokedex_pruebas.api.modelo.RetrofitClient
import com.david.pokedex_pruebas.api.modelo.TypeToDrawableAPI
import com.david.pokedex_pruebas.api.modelo.firstMayus
import com.david.pokedex_pruebas.modelo.UnonwnFormas
import com.david.pokedex_pruebas.modelo.UsuarioFromKey
import com.david.pokedex_pruebas.modelo.debilidadesEquipo
import com.david.pokedex_pruebas.modelo.debsFB
import com.david.pokedex_pruebas.modelo.fortalezasEquipo
import com.david.pokedex_pruebas.modelo.fortsFB
import com.david.pokedex_pruebas.modelo.inmuneFB
//import com.david.pokedex_pruebas.modelo.listaPokeFB
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.text.toFloat


//private lateinit var refBBDD: DatabaseReference
var index by mutableStateOf(0)
@Composable
fun PokemonCard(pokemon: PokemonFB, usuario_key: String, opc: Int) {
//    var arrayPoke=ArrayList<PokemonFB>()
//    arrayPoke.addAll(listaPokeFireBase)
    //refBBDD = FirebaseDatabase.getInstance().reference
    var isPressed by remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }
    val scale = animateFloatAsState(
        targetValue = if (isPressed) 0.90f else 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy, // Moderate bouncing
            stiffness = Spring.StiffnessMedium // Moderate stiffness
        )
    )
    val context=LocalContext.current
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val(pokeball,pokemonImage,numero,pokemonName,tipo1,tipo2, delete)=createRefs()

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .scale(scale.value)
                .clickable(
                    interactionSource = interactionSource,
                    indication = null, // Remove default ripple effect

                    onClick = {

                    }
                )
                .indication(
                    interactionSource = interactionSource,
                    indication = null
                )
                .pointerInput(Unit) {//lo que hace al pulsar en el Card()
                    detectTapGestures(
                        onPress = {
                            isPressed = true
                            try {
                                awaitRelease()
                            } finally {
                                isPressed = false // Reset isPressed in finally block
                            }
                            //isPressed = false
                            //intent a ComposeVistaActivity
                            index = pokemon.num - 1
                            var indice=pokemon.num-1
                            Log.d("INDEX - PokemonCard", index.toString())
                            //seleccionado= listaPokeFireBase[index]
                            if(opc!=3){
                                val intent = Intent(context, ComposeVistaActivity::class.java)
                                //intent.putParcelableArrayListExtra("lista", arrayPoke)
                                intent.putExtra("sesion", usuario_key)
                                intent.putExtra("indice", indice)
                                context.startActivity(intent)
                                //oculta campo de búsqueda
                                desde_evos=false
                                campoBusqueda = false
                            }
                        }
                    )
                }
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

                //imagen local

                Image(
                    painter = painterResource(id = pokemon.foto),
                    contentDescription = "Pokeball",
                    modifier = Modifier
                        .size(100.dp)
                        .fillMaxSize()
                        .constrainAs(pokemonImage) {
                            start.linkTo(parent.start)
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                        }
                )

                //imagen remota
                /*BUENA
                val painter = rememberAsyncImagePainter(
                    model = pokemon.imagenFB,
                    contentScale = ContentScale.Crop,
                )

                Image(
                    painter = painter,
                    contentDescription = "Pokemon Image",
                    modifier = Modifier
                        .size(100.dp)
                        .fillMaxSize()
                        .constrainAs(pokemonImage) {
                            start.linkTo(parent.start)
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                        }
                )*/
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
        if(opc==2){
            //var aux=UsuarioFromKey( usuario_key, refBBDD)
            IconButton(
                onClick = {
                    scope.launch {
                        //val latestEquipo = equipo_lista.value
                        val updatedEquipo = equipo_lista.value.filter { it.name != pokemon.name }
                        // Emit the new list to the StateFlow
                        val updates = hashMapOf<String, Any>(
                            "usuarios/$usuario_key/equipo" to updatedEquipo
                        )
                        equipo_lista.emit(updatedEquipo)
                        refBBDD.updateChildren(updates)
                            .addOnSuccessListener {
                                Toast.makeText(context, "Has liberado a ${pokemon.name}", Toast.LENGTH_SHORT).show()
                            }
                            .addOnFailureListener {
                                // Handle error
                            }
                    }
                },
                modifier = Modifier
                    .constrainAs(delete) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)

                    }
                    .padding(top = 5.dp, end = 15.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.close),
                    contentDescription = "Descripción del icono" // Agrega una descripción de contenido
                )
            }
        }
        if(opc==3){
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .scale(scale.value)
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null, // Remove default ripple effect

                        onClick = {
                            index = pokemon.num - 1
                            desde_evos=true
                            //seleccionado= listaPokeFireBase[index]
                        }
                    )
                    .indication(
                        interactionSource = interactionSource,
                        indication = null
                    )
                    .pointerInput(Unit) {//lo que hace al pulsar en el Card()
                        detectTapGestures(
                            onPress = {
                                isPressed = true
                                try {
                                    awaitRelease()
                                } finally {
                                    isPressed = false // Reset isPressed in finally block
                                }
                            }
                        )
                    }
            ){}
        }

    }

}
var show_regis by mutableStateOf(false)
var show_desc by mutableStateOf(false)
var show_evos by mutableStateOf(false)
var show_interacciones by mutableStateOf(false)
var show_formas_unown by mutableStateOf(false)
var show_gigamax by mutableStateOf(false)
var show_megaevos by mutableStateOf(false)
var desde_evos by mutableStateOf(false)

@Composable
fun FormasUnown(formas: List<UnonwnFormas>){
    val alturaFormas by animateFloatAsState(
        targetValue = if (show_formas_unown) 110f else 0f,
        animationSpec = tween(durationMillis = 300) // duración
    )
    var listState = rememberLazyListState(
        initialFirstVisibleItemIndex = 1
    )
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Text(
                text ="Formas Unown",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(vertical = 10.dp)
                    .clickable {
                        show_formas_unown = !show_formas_unown
                        show_gigamax=false
                        show_evos=false
                        show_interacciones=false
                        show_regis = false
                        show_desc = false
                    },
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(alturaFormas.dp)
        ){
            LazyRow(
                modifier = Modifier
                    .fillMaxSize(),
                flingBehavior = rememberSnapFlingBehavior(lazyListState = listState)
            ){
                items(formas){forma ->
                    UnownCard(forma)
                }
            }
        }
    }
}
@Composable
fun UnownCard(unown: UnonwnFormas){
    var isPressed by remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }
    val scale = animateFloatAsState(
        targetValue = if (isPressed) 0.90f else 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy, // Moderate bouncing
            stiffness = Spring.StiffnessMedium // Moderate stiffness
        )
    )
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val(foto,forma)=createRefs()
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .scale(scale.value)
                .clickable(
                    interactionSource = interactionSource,
                    indication = null, // Remove default ripple effect

                    onClick = {
                        //
                    }
                )
                .indication(
                    interactionSource = interactionSource,
                    indication = null
                )
                .pointerInput(Unit) {//lo que hace al pulsar en el Card()
                    detectTapGestures(
                        onPress = {


                            isPressed = true
                            try {
                                awaitRelease()
                            } finally {
                                isPressed = false // Reset isPressed in finally block
                            }


                        }
                    )
                }
        ) {
            ConstraintLayout(
                modifier = Modifier
                    .wrapContentWidth()
                    .background(colorResource(R.color.objeto_lista))
                    .padding(end = 30.dp)
            ) {
                //imagen local
                Image(
                    painter = painterResource(id = unown.foto),
                    contentDescription = "Pokeball",
                    modifier = Modifier
                        .size(100.dp)
                        .fillMaxSize()
                        .constrainAs(foto) {
                            start.linkTo(parent.start)
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                        }
                )
                /*
                                    //imagen remota
                                    AsyncImage(
                                        model = unown.imagenFB,
                                        contentDescription = "Pokemon Image",
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .size(100.dp)
                                            .fillMaxSize()
                                            .constrainAs(avatar) {
                                                start.linkTo(parent.start)
                                                top.linkTo(parent.top)
                                                bottom.linkTo(parent.bottom)
                                            }
                                    )
                                    */
                Text(
                    text = unown.name,
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 15.dp)
                        .constrainAs(forma) {
                            start.linkTo(foto.end)
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                            end.linkTo(parent.end)
                        }
                )
            }
        }
    }
}

@Composable
fun GigamaxEvos(evo: PokemonFB){
    val alturaFormas by animateFloatAsState(
        targetValue = if (show_gigamax) 110f else 0f,
        animationSpec = tween(durationMillis = 300) // duración
    )
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Text(
                text ="Forma Gigamax",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(vertical = 10.dp)
                    .clickable {
                        show_gigamax=!show_gigamax
                        seleccionado=PokemonFB(0,"",0,"","", "")
                        show_megaevos=false
                        show_formas_unown =false
                        show_evos=false
                        show_interacciones=false
                        show_regis = false
                        show_desc = false
                    },
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(alturaFormas.dp)
        ){
            GigamaxCard(evo)
        }
    }
}
@Composable
fun GigamaxCard(gigamax: PokemonFB){
    var isPressed by remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }
    val scale = animateFloatAsState(
        targetValue = if (isPressed) 0.90f else 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy, // Moderate bouncing
            stiffness = Spring.StiffnessMedium // Moderate stiffness
        )
    )
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val(foto,forma)=createRefs()
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .scale(scale.value)
                .clickable(
                    interactionSource = interactionSource,
                    indication = null, // Remove default ripple effect

                    onClick = {

                    }
                )
                .indication(
                    interactionSource = interactionSource,
                    indication = null
                )
                .pointerInput(Unit) {//lo que hace al pulsar en el Card()
                    detectTapGestures(
                        onPress = {


                            isPressed = true
                            try {
                                awaitRelease()
                            } finally {
                                isPressed = false // Reset isPressed in finally block
                            }
                            seleccionado=gigamax

                        }
                    )
                }
        ) {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colorResource(R.color.objeto_lista))
                    .padding(end = 30.dp)
            ) {
                //imagen local
                Image(
                    painter = painterResource(id = gigamax.foto),
                    contentDescription = "Pokeball",
                    modifier = Modifier
                        .size(100.dp)
                        .fillMaxSize()
                        .constrainAs(foto) {
                            start.linkTo(parent.start)
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                        }
                )
                /*
                                    //imagen remota
                                    AsyncImage(
                                        model = unown.imagenFB,
                                        contentDescription = "Pokemon Image",
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .size(100.dp)
                                            .fillMaxSize()
                                            .constrainAs(avatar) {
                                                start.linkTo(parent.start)
                                                top.linkTo(parent.top)
                                                bottom.linkTo(parent.bottom)
                                            }
                                    )
                                    */
                Text(
                    text = gigamax.name,
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 15.dp)
                        .constrainAs(forma) {
                            start.linkTo(foto.end)
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                            end.linkTo(parent.end)
                        }
                )
            }
        }
    }
}

@Composable
fun MegaEvos(evos: List<PokemonFB>){
    val alturaFormas by animateFloatAsState(
        targetValue = if (show_megaevos) 110f else 0f,
        animationSpec = tween(durationMillis = 300) // duración
    )
    var listState = rememberLazyListState(
        initialFirstVisibleItemIndex = 1
    )
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Text(
                text ="Mega Evolución",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(vertical = 10.dp)
                    .clickable {
                        show_megaevos=!show_megaevos
                        seleccionado=PokemonFB(0,"",0,"","", "")

                        show_gigamax=false
                        show_formas_unown =false
                        show_evos=false
                        show_interacciones=false
                        show_regis = false
                        show_desc = false
                    },
            )
        }
        LazyRow(
            modifier = Modifier
                .fillMaxSize()
                .height(alturaFormas.dp),
            flingBehavior = rememberSnapFlingBehavior(lazyListState = listState),
            horizontalArrangement = Arrangement.Center,
        ){
            items(evos){evo ->
                MegaEvoCard(evo)
            }
        }
    }
}
@Composable
fun MegaEvoCard(megaEvo: PokemonFB){
    var isPressed by remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }
    val scale = animateFloatAsState(
        targetValue = if (isPressed) 0.90f else 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy, // Moderate bouncing
            stiffness = Spring.StiffnessMedium // Moderate stiffness
        )
    )
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val(foto,forma)=createRefs()
        Card(
            modifier = Modifier
                .wrapContentWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .scale(scale.value)
                .clickable(
                    interactionSource = interactionSource,
                    indication = null, // Remove default ripple effect

                    onClick = {

                    }
                )
                .indication(
                    interactionSource = interactionSource,
                    indication = null
                )
                .pointerInput(Unit) {//lo que hace al pulsar en el Card()
                    detectTapGestures(
                        onPress = {


                            isPressed = true
                            try {
                                awaitRelease()
                            } finally {
                                isPressed = false // Reset isPressed in finally block
                            }
                            seleccionado=megaEvo

                        }
                    )
                }
        ) {
            ConstraintLayout(
                modifier = Modifier
                    .wrapContentWidth()
                    .background(colorResource(R.color.objeto_lista))
                    .padding(end = 30.dp)
            ) {
                //imagen local
                Image(
                    painter = painterResource(id = megaEvo.foto),
                    contentDescription = "Pokeball",
                    modifier = Modifier
                        .size(100.dp)
                        .fillMaxSize()
                        .constrainAs(foto) {
                            start.linkTo(parent.start)
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                        }
                )
                /*
                                    //imagen remota
                                    AsyncImage(
                                        model = unown.imagenFB,
                                        contentDescription = "Pokemon Image",
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .size(100.dp)
                                            .fillMaxSize()
                                            .constrainAs(avatar) {
                                                start.linkTo(parent.start)
                                                top.linkTo(parent.top)
                                                bottom.linkTo(parent.bottom)
                                            }
                                    )
                                    */
                Text(
                    text = megaEvo.name,
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 15.dp)
                        .constrainAs(forma) {
                            start.linkTo(foto.end)
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                            end.linkTo(parent.end)
                        }
                )
            }
        }
    }
}






@Composable
fun LineaEvo(evos: List<PokemonFB>,opc:Int){

    val alturaEvos by animateFloatAsState(
        targetValue = if (show_evos) 250f else 0f,
        animationSpec = tween(durationMillis = 300) // duración
    )
    val listState = rememberLazyListState(
        initialFirstVisibleItemIndex = 1
    )
    val alturaRegis by animateFloatAsState(
        targetValue = if (show_regis) 150f else 0f,
        animationSpec = tween(durationMillis = 300) // duración
    )

    when(opc){
        1->{
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(colorResource(id = R.color.electrico))
            ){
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ){
                    Text(
                        text ="Línea Evolutiva",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(vertical = 10.dp)
                            .clickable {
                                show_evos = !show_evos
                                show_gigamax=false
                                show_megaevos=false
                                show_interacciones=false
                                show_regis = false
                                show_desc = false
                                show_formas_unown=false
                            },
                    )

                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(alturaEvos.dp)
                ){
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize(),
                        flingBehavior = rememberSnapFlingBehavior(lazyListState = listState)
                    ){
                        items(evos) { pokemon ->
                            PokemonCard(pokemon, "",3)
                        }
                    }
                }
            }
        }
        2->{
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(colorResource(id = R.color.rojo_muy_claro))
            ){
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ){
                    Text(
                        text ="Formas Regionales",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(vertical = 10.dp)
                            .clickable {
                                show_regis = !show_regis
                                show_interacciones=false
                                show_gigamax=false
                                show_evos = false
                                show_desc = false
                                show_megaevos=false
                                show_formas_unown=false
                            },
                    )

                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(alturaRegis.dp)
                ){
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize(),
                        flingBehavior = rememberSnapFlingBehavior(lazyListState = listState)
                    ){
                        items(evos) { pokemon ->
                            PokemonCard(pokemon, "",3)
                        }
                    }
                }
            }
        }
    }





}

fun evosPoke(pokemon: PokemonFB):List<PokemonFB>{
    var lista=mutableListOf<PokemonFB>()
    for(i in pokemon.evos){
        //lista.add(listaPokeFireBase[i]) listaPokeFB
        lista.add(listaPokeFireBase[i-1])
    }
    return lista
}

fun formasRegionales(pokemon: PokemonFB):List<PokemonFB>{
    var lista=mutableListOf<PokemonFB>()
    var i=1025
    while(i<=1079){
        if(listaPokeFireBase[i].name.contains(pokemon.name)){
            lista.add(listaPokeFireBase[i])
        }
        i++
    }
    return lista
}

@Composable
fun MuestraDesc(desc: String) {
    var textHeight by remember { mutableStateOf(0f) }
    val alturaDesc by animateFloatAsState(
        targetValue = if (show_desc) textHeight else 0f,
        animationSpec = tween(durationMillis = 300)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.transparente))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Descripción",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(vertical = 10.dp)
                    .clickable {
                        show_desc = !show_desc
                        show_interacciones=false
                        show_regis = false
                        show_evos = false
                        show_megaevos=false
                        show_gigamax=false
                        show_formas_unown=false
                        Log.d("ALTURA TEXTO", textHeight.toString())
                    },
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(alturaDesc.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier
                    .width(300.dp)
                    .padding(start = 20.dp, end = 20.dp, top = 10.dp, bottom = 15.dp),
                text = desc,
                fontSize = 18.sp,
                onTextLayout = { textLayoutResult ->
                    textHeight = 30.sp.value * textLayoutResult.lineCount

                }
            )
        }
    }
}



//PARA POKEAPI

@Composable
fun PokemonScreen(pokemonId: Int, viewModel: PokeInfoViewModel) {
    val pokemon by viewModel.pokemonInfo.observeAsState()
    Log.d("PokemonScreen", pokemon.toString())
    LaunchedEffect(pokemonId) {
        viewModel.getPokemonInfo(pokemonId)
    }
    when (pokemon) {
        null -> {
            // Show loading indicator
            CircularProgressIndicator()
        }
        else -> {
            Column {
                Text(text = "Name: ${pokemon!!.name}")
                // ... other UI elements to display Pokemon information
            }
        }
    }
}
@Composable
fun ListaPokeApi() {
    var viewModel= PokeInfoViewModel()
    val pokemonList by viewModel.pokemonList.observeAsState(emptyList()) // Observe pokemonList directly
    var pokemonIds = remember { mutableStateListOf<Int>() }

    LaunchedEffect(key1 = Unit) {
        val apiService = RetrofitClient.create(ApiService::class.java)
        val call = apiService.getPokemonList(20, 0)

        call.enqueue(object : Callback<PokeApiResponse> {
            override fun onResponse(call: Call<PokeApiResponse>, response: Response<PokeApiResponse>) {
                if (response.isSuccessful) {
                    val pokeApiResponse = response.body()
                    val results = pokeApiResponse?.results ?: emptyList()

                    // Collect unique pokemon IDs
                    val newPokemonIds = results.mapNotNull {
                        it.url.split("/").last { it.isNotEmpty() }.toIntOrNull()
                    }.filterNot { pokemonIds.contains(it) }

                    // Update pokemonIds and fetch Pokemon info for new IDs
                    pokemonIds.addAll(newPokemonIds)
                    viewModel.getPokemonList(newPokemonIds) // Fetch and update pokemonList in ViewModel
                } else {
                    // Handle API error
                    Log.e("PokemonList", "Error fetching Pokémon list: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<PokeApiResponse>, t: Throwable) {
                // Handle network error
                Log.e("PokemonList", "Error fetching Pokémon list: ${t.message}")
            }
        })
    }

    LazyColumn(
        modifier = Modifier
            .height(400.dp)
    ) {
        items(pokemonList) { pokemon ->
            Log.d("PokemonList", "Pokemon: $pokemon")
            PokemonCardApi(pokemon, viewModel)
            Log.d("POKEMON DE API", pokemon.toString())
        }
    }
}

@Composable
fun PokemonCardApi(pokemon: Pokemon, viewModel: PokeInfoViewModel) {
    //Log.d("POKEMON DE API - TIPOS", "Pokemon: ${pokemon.types}")
    var isPressed by remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }
    val scale = animateFloatAsState(
        targetValue = if (isPressed) 0.90f else 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessMedium
        )
    )
    viewModel.getPokemonDescription(pokemon.order)
    val spanishDescription by viewModel.spanishDescription

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val(pokeball,pokemonImage,numero,pokemonName,tipo1,tipo2, descRow)=createRefs()

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .scale(scale.value)
                .clickable(
                    interactionSource = interactionSource,
                    indication = null, // Remove default ripple effect

                    onClick = {

                    }
                )
                .indication(
                    interactionSource = interactionSource,
                    indication = null
                )
                .pointerInput(Unit) {//lo que hace al pulsar en el Card()
                    detectTapGestures(
                        onPress = {
                            isPressed = true
                            try {
                                awaitRelease()
                            } finally {
                                isPressed = false // Reset isPressed in finally block
                            }
                            Log.d("POKEMON CLICK - NOMBRE", "Pokemon: $pokemon")
                            Log.d("POKEMON CLICK - DESCRIP", "Pokemon: $spanishDescription")
                        }
                    )
                }
        ) {

            var num = "${(pokemon.id)}"
            if (num.length == 1) num = "00${(pokemon.id)}"
            else if (num.length == 2) num = "0${(pokemon.id)}"

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
                /*
                val context = LocalContext.current
                val id = context.resources.getIdentifier(pokemon.name.lowercase(), "drawable", context.packageName)
                val painter = if (id != 0) {
                    painterResource(id = id)
                } else {
                    // Handle case where drawable not found (e.g., use a default image)
                    painterResource(id = R.drawable.error)
                }

                Image(
                    painter = painter,
                    contentDescription = "Pokeball",
                    modifier = Modifier
                        .size(100.dp)
                        .fillMaxSize()
                        .padding(5.dp)
                        .constrainAs(pokemonImage) {
                            start.linkTo(parent.start)
                            top.linkTo(parent.top)
                        }
                )*/

                //imagen remota de api
                val painter = rememberAsyncImagePainter(
                    model = pokemon.sprites.frontDefault,
                    contentScale = ContentScale.FillBounds,
                )

                Image(
                    painter = painter,
                    contentDescription = "Pokemon Image",
                    modifier = Modifier
                        .size(100.dp)
                        .fillMaxSize()
                        .constrainAs(pokemonImage) {
                            start.linkTo(parent.start)
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                        },

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
                    text = pokemon.name.firstMayus(),
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
                Text(
                    text = spanishDescription,
                    modifier = Modifier
                        .constrainAs(descRow) {
                            top.linkTo(pokemonName.bottom)
                            start.linkTo(numero.start)
                            end.linkTo(parent.end)
                            bottom.linkTo(parent.bottom)

                        }
                )



                if (pokemon.types.size == 1) {
                    Image(
                        painter = painterResource(id = TypeToDrawableAPI(pokemon.types[0])),
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
                        painter = painterResource(id = TypeToDrawableAPI(pokemon.types[0])),
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
                        painter = painterResource(id = TypeToDrawableAPI(pokemon.types[1])),
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











