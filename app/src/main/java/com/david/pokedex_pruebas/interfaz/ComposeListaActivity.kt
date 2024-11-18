package com.david.pokedex_pruebas.interfaz


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.david.pokedex_pruebas.R
import com.david.pokedex_pruebas.modelo.PokemonFB
import com.david.pokedex_pruebas.modelo.PokemonTipoFB
import com.david.pokedex_pruebas.modelo.UserFb
import com.david.pokedex_pruebas.modelo.enumToDrawableFB
import com.david.pokedex_pruebas.modelo.enumToDrawableFB_busqueda
import com.david.pokedex_pruebas.modelo.listaPokeFB
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import io.appwrite.Client
import io.appwrite.services.Storage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import okhttp3.internal.wait


//para firebase
private lateinit var refBBDD: DatabaseReference
private lateinit var identificador: String
var campoBusqueda by mutableStateOf(false)
//para appwrite
val client = Client()
    .setEndpoint("https://cloud.appwrite.io/v1")
    .setProject("6738854a0011e2bc643f")
val storage = Storage(client)//habilitar para subir archivos

lateinit var scope: CoroutineScope

//appwrite bucket
//https://cloud.appwrite.io/console/project-6738854a0011e2bc643f/storage

//firebase realtime database
//https://console.firebase.google.com/u/0/project/com-david-pokedexpruebas/database/com-david-pokedexpruebas-default-rtdb/data/~2F?hl=es-419

class ComposeListaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sesion = intent.getParcelableArrayListExtra<UserFb>("sesion" ) as List<UserFb>

        refBBDD = FirebaseDatabase.getInstance().reference

        var listaPokeFireBase by mutableStateOf<List<PokemonFB>>(emptyList())
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
                    pokemon.imagenFB = "https://cloud.appwrite.io/v1/storage/buckets/6738855e0002d76f1141/files/$identificadorAppWrite/preview?project=6738854a0011e2bc643f"
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
            VerListaPoke(listaPokeFireBase, isLoading,sesion[0])//FireBase,AppWrite -- false
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

@Composable
fun VerListaPoke(pokemonList: List<PokemonFB>, isLoading: Boolean,sesion:UserFb) {
    var selectedItemIndex by remember { mutableStateOf(0) }

    var busquedaTipos by remember { mutableStateOf(false) }
    var textobusqueda by remember { mutableStateOf("") }
    var tipoBuscado by remember { mutableStateOf("") }
    var listaFiltrada by remember { mutableStateOf(pokemonList) }
    //efectos
    val alturaCampoBusqueda by animateFloatAsState(
        targetValue = if (campoBusqueda) 300f else 0f,
        animationSpec = tween(durationMillis = 300) // duración
    )
    val context = LocalContext.current

    //
    //intents
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

        LaunchedEffect(key1 = textobusqueda) {//filtramos la lista con la búsqueda de textobusqueda
            delay(200)
            listaFiltrada = if (textobusqueda.isEmpty()) {
                pokemonList //reestablece la lsta cuando no hay búsqueda
            } else {
                pokemonList.filter { pokemon ->
                    pokemon.name.contains(textobusqueda, ignoreCase = true)
                }
            }
        }
        LaunchedEffect(key1=tipoBuscado) {//filtramos la lista con la búsqueda de tipoBuscado
            delay(200)
            listaFiltrada = if (tipoBuscado.isEmpty()) {
                pokemonList //reestablece la lsta cuando no hay búsqueda
            } else {
                pokemonList.filter { pokemon ->
                    pokemon.tipo.any { it.tag.contains(tipoBuscado, ignoreCase = true)}
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                //.padding(vertical = 15.dp)
                .background(colorResource(R.color.lista_con_foco))
        ) {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 0.dp)
                    .systemBarsPadding()
                    .imePadding()
            ) {
                val (pokeball, pokemonImage, numero, pokemonName, tipo1, tipo2, lazyC, boton, layoutBusqueda, busquedaTipo, descBusqueda, switchBusqueda, botonUserActivity) = createRefs()

                /////////////////////////////////////////////////
                //abre activity para crear un usuario - borrar cuando menu
                IconButton(
                    onClick = {//para abrir el activity perfil de usuario TODO()
                        /*

                        val intent =
                            Intent(context, ComposeCreaUser::class.java)
                        context.startActivity(intent)*/
                    },
                    modifier = Modifier
                        .size(90.dp)
                        .padding(20.dp)
                        //.wrapContentHeight()
                        .constrainAs(botonUserActivity) {
                            end.linkTo(parent.end)
                            top.linkTo(parent.top)
                        }
                        .zIndex(2f)

                ) {
                    AsyncImage(
                        model = sesion.avatar,
                        contentDescription = "Pokemon Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(CircleShape)
                            .background(colorResource(R.color.fuego))
                    )
                }

                LazyColumn(
                    modifier = Modifier
                        //.fillMaxWidth()
                        .fillMaxSize()/////////
                        .constrainAs(lazyC) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            if (campoBusqueda) bottom.linkTo(layoutBusqueda.top)
                            else bottom.linkTo(parent.bottom)
                        }
                ) {
                    items(listaFiltrada) { pokemon ->
                        var isPressed by remember { mutableStateOf(false) }
                        val interactionSource = remember { MutableInteractionSource() }
                        val scale = animateFloatAsState(
                            targetValue = if (isPressed) 0.90f else 1f,
                            animationSpec = spring(
                                dampingRatio = Spring.DampingRatioMediumBouncy, // Moderate bouncing
                                stiffness = Spring.StiffnessMedium // Moderate stiffness
                            )
                        )
                        //val context = LocalContext.current
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 8.dp)
                                .scale(scale.value)
                                .clickable(
                                    interactionSource = interactionSource,
                                    indication = null, // Remove default ripple effect

                                    onClick = {/*
                                        val index = pokemonList.indexOf(pokemon)
                                        selectedItemIndex = index
                                        val intent =
                                            Intent(context, ComposeVistaActivity::class.java)
                                        intent.putParcelableArrayListExtra("lista", arrayPoke)
                                        intent.putExtra("indice", index)
                                        context.startActivity(intent)*/
                                        /*
                                        ///////////////////////////////////////////////////////////////////////////// NO BORRAR - sirve para actualizar FIREBASE y APPWRITE cuando se pulsa un elemento cualquiera de la lista
                                        //sube a Firebase y AppWrite
                                        //refStorage = FirebaseStorage.getInstance().reference
                                        for (i in pokemonList) {
                                            try {
                                                val resources = context.resources
                                                resources
                                                    .openRawResource(i.foto)
                                                    .use { inputStream ->
                                                        val identificador = refBBDD
                                                            .child("pokemones")
                                                            .push().key!!
                                                        refBBDD
                                                            .child("pokemones")
                                                            .child(identificador)
                                                            .setValue(i)

                                                        val tempFile = File.createTempFile(
                                                            identificador.drop(1),
                                                            ".png",
                                                            context.cacheDir
                                                        )
                                                        inputStream.use { input ->
                                                            tempFile
                                                                .outputStream()
                                                                .use { output ->
                                                                    input.copyTo(output)
                                                                }
                                                        }
                                                        scope.launch {
                                                            withContext(
                                                                Dispatchers.IO
                                                            ) {
                                                                storage.createFile(
                                                                    bucketId = "6738855e0002d76f1141",
                                                                    fileId = identificador.drop(1),//elimina "_"
                                                                    file = InputFile.fromPath(
                                                                        tempFile.absolutePath
                                                                    )
                                                                )
                                                                tempFile.delete() // Delete after upload
                                                            }
                                                        }
                                                    }
                                            } catch (e: Exception) {
                                                // Handle exceptions appropriately

                                            }
                                        }
                                        /////////////////////////////////////////////////////////////////////////
                                        */

                                    }
                                )
                                .indication(
                                    interactionSource = interactionSource,
                                    indication = null
                                )
                                .pointerInput(Unit) {//lo que hace al pulsar en el Card()
                                    detectTapGestures(
                                        onPress = {
                                            //efectos
                                            isPressed = true
                                            awaitRelease()
                                            isPressed = false
                                            //intent a ComposeVistaActivity
                                            val index = pokemonList.indexOf(pokemon)
                                            selectedItemIndex = index
                                            val intent =
                                                Intent(context, ComposeVistaActivity::class.java)
                                            intent.putParcelableArrayListExtra("lista", arrayPoke)
                                            intent.putExtra("indice", index)
                                            context.startActivity(intent)
                                            //oculta campo de búsqueda
                                            campoBusqueda = false
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
                                /*
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
                                )*/
                                AsyncImage(
                                    model = pokemon.imagenFB,
                                    contentDescription = "Pokemon Image",
                                    contentScale = ContentScale.Crop,
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
                        tipoBuscado=""
                        textobusqueda=""
                    },
                    modifier = Modifier
                        .size(120.dp)
                        .padding(20.dp)
                        //.wrapContentHeight()
                        .constrainAs(boton) {
                            start.linkTo(parent.start)
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

                //////////////////////////////////////
                //campoBusqueda=true//borrar - sólo preview
                /////////////////////////////////////

                if (campoBusqueda || alturaCampoBusqueda > 0f) {
                    ConstraintLayout(
                        modifier = Modifier
                            .constrainAs(layoutBusqueda) {
                                top.linkTo(lazyC.bottom)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                                bottom.linkTo(parent.bottom)
                            }
                            //.fillMaxSize()//
                            .wrapContentHeight()
                            //.padding(vertical = 30.dp)
                            //.background(color = colorResource(id = R.color.lista_sin_foco))
                            //.height(300.dp)
                            .height(alturaCampoBusqueda.dp)
                    ) {
                        var tipoBus=""
                        if(!busquedaTipos)tipoBus="NOMBRE"
                        else tipoBus="TIPO"
                        Text(
                            text = "$tipoBus",
                            fontSize = 18.sp,
                            color = colorResource(R.color.white),
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .constrainAs(descBusqueda) {
                                    top.linkTo(parent.top)
                                    start.linkTo(parent.start)
                                    end.linkTo(switchBusqueda.start)
                                    bottom.linkTo(busquedaTipo.top)
                                }
                                .padding(horizontal = 10.dp)
                                //.wrapContentWidth()
                        )
                        Switch(
                            modifier = Modifier
                                .constrainAs(switchBusqueda){
                                    top.linkTo(parent.top)
                                    //start.linkTo(descBusqueda.end)
                                    bottom.linkTo(busquedaTipo.top)
                                    end.linkTo(parent.end)
                                },
                            checked = busquedaTipos,
                            onCheckedChange = {
                                busquedaTipos = it
                            }
                        )
                        if(!busquedaTipos)OutlinedTextField(
                            value = textobusqueda,
                            onValueChange = { textobusqueda = it },
                            label = { Text("Buscar") },
                            modifier = Modifier
                                .padding(all = 25.dp)
                                .width(300.dp)
                                .background(color = colorResource(id = R.color.white))
                                .constrainAs(busquedaTipo) {
                                    top.linkTo(switchBusqueda.bottom)
                                    start.linkTo(parent.start)
                                    end.linkTo(parent.end)
                                    //bottom.linkTo(parent.bottom)
                                }
                                .clip(RoundedCornerShape(10.dp)),
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Filled.Search,
                                    contentDescription = "Buscar"
                                )
                            },
                            placeholder = { Text("nombre del Pokémon") },
                            shape = RoundedCornerShape(16.dp)
                        )
                        else{
                            LazyRow (
                                modifier = Modifier
                                    .padding(all = 25.dp)
                                    //.wrapContentHeight()
                                    .width(300.dp)
                                    .constrainAs(busquedaTipo) {
                                        top.linkTo(switchBusqueda.bottom)
                                        start.linkTo(parent.start)
                                        end.linkTo(parent.end)
                                        //bottom.linkTo(parent.bottom)
                                    },
                            ){
                                items(PokemonTipoFB.entries.dropLast(1)) { tipo ->
                                    Image(
                                        painter = painterResource(id = enumToDrawableFB_busqueda(tipo)),
                                        contentDescription = "Tipo",
                                        contentScale = ContentScale.Fit,
                                        modifier = Modifier
                                            .padding(horizontal = 5.dp)
                                            .width(50.dp)
                                            .height(50.dp)
                                            .clickable(
                                                onClick = {
                                                    tipoBuscado = tipo.tag
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






































@Preview(showBackground = true)
@Composable
fun PokemonCardPreview() {
    var userAux=UserFb("","","","https://cloud.appwrite.io/v1/storage/buckets/6738855e0002d76f1141/files/OC-7tUbUj0_3AIjTMOy/preview?project=6738854a0011e2bc643f")
    VerListaPoke(listaPokeFB, false, userAux)
}





/*
private lateinit var refBBDD: DatabaseReference
private lateinit var refStorage: StorageReference
private lateinit var identificador: String


class ComposeListaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        refBBDD = FirebaseDatabase.getInstance().reference
        refStorage = FirebaseStorage.getInstance().reference

        //var listaPokeFireBase by mutableStateOf<List<PokemonFB>>(emptyList())
        var pokemonList = mutableListOf<PokemonFB>()
        var isLoading by mutableStateOf(true)
        refBBDD.child("pokemones").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                pokemonList = mutableListOf<PokemonFB>()
                for (pokemonSnapshot in snapshot.children) {
                    val pokemon = pokemonSnapshot.getValue(PokemonFB::class.java)
                    pokemon?.let {
                        val identificador = pokemonSnapshot.key // Get the identificador
                        val imagePath = "pokemones/$identificador" // Construct image path
                        refStorage.child(imagePath).getBytes(Long.MAX_VALUE).addOnSuccessListener { bytes ->
                            val bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
                            pokemon.imagenFB = bitmap // Associate image with Pokemon
                            pokemonList.add(pokemon)

                            //listaPokeFireBase=pokemonList


                        }
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle error
            }
        })

        //enableEdgeToEdge()
        setContent {
            //VerListaPoke(listaPokeFB, false)//Local
            VerListaPoke(pokemonList, isLoading)//FireBase -- false
        }
    }
}

*/
