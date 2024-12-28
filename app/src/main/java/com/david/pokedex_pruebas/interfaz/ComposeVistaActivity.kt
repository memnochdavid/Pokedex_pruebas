
package com.david.pokedex_pruebas.interfaz

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.david.pokedex_pruebas.R
import com.david.pokedex_pruebas.modelo.PokemonFB
import com.david.pokedex_pruebas.modelo.debsFB
import com.david.pokedex_pruebas.modelo.enumToColorFB
import com.david.pokedex_pruebas.modelo.enumToDrawableFB
import com.david.pokedex_pruebas.modelo.fortsFB
import com.david.pokedex_pruebas.modelo.inmuneFB
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.zIndex
import com.david.pokedex_pruebas.modelo.UserFb
import com.david.pokedex_pruebas.modelo.UsuarioFromKey
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import android.media.MediaPlayer
import android.util.Log
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.david.pokedex_pruebas.modelo.adaptaNombre
//import com.david.pokedex_pruebas.modelo.listaPokeFB
import java.util.concurrent.CountDownLatch

//https://developer.android.com/develop/ui/compose/mental-model?hl=es-419


//firebase

//private lateinit var refBBDD: DatabaseReference
//private lateinit var usuario_key: String

class ComposeVistaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //refBBDD = FirebaseDatabase.getInstance().reference
/*
        if (intent.hasExtra("sesion")) {
            usuario_key = intent.getStringExtra("sesion").toString()
        }else{
            usuario_key = ""
        }*/
        //val indice = intent.getIntExtra("indice", 0)
        //descargamos la lista de pokemon

        setContent{
            VerListaPokemon(this)
            //VerPokemon(lista[45])
        }
    }
}

//var seleccionado by mutableStateOf(PokemonFB(0,"",0,"","", ""))

@Composable
fun VerPokemon(pokemon: PokemonFB, usuario_key: String) {

    val num=pokemon.num
    var numero = "${(num)}"
    if(numero.length == 1) numero = "00${(num)}"
    else if(numero.length == 2) numero = "0${(num)}"
/*
    LaunchedEffect (seleccionado){
        pokemon=seleccionado
    }
    LaunchedEffect (index){
        pokemon=listaPokeFireBase[index]
    }*/

    var mediaPlayer: MediaPlayer? = null

    val context = LocalContext.current

    val usuario=UsuarioFromKey(usuario_key, refBBDD)

    var updatedEquipo by remember { mutableStateOf(usuario.equipo) }


    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 0.dp)
    ) {
        val (number,desc, nombre, foto, tipo1, tipo2,datos,interacciones,add,evos) = createRefs()
        //imagen remote
/*
        val painter = rememberAsyncImagePainter(
            model = pokemon.imagenFB,
            contentScale = ContentScale.Crop,
        )
        Image(
            painter = painter,
            contentDescription = "avatar de usuario",
            modifier = Modifier
                .size(350.dp)
                .fillMaxSize()
                .constrainAs(foto) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(datos.top)
                }
                .clickable {//reproduce su grito
                    val resourceId = context.resources.getIdentifier(
                        adaptaNombre(pokemon.name),
                        //pokemon.name.trim().lowercase(),
                        "raw",
                        context.packageName
                    )
                    // Initialize MediaPlayer if it's null
                    if (mediaPlayer == null) {
                        mediaPlayer = MediaPlayer.create(context, resourceId)
                    }
                    // Start or resume playback
                    if (mediaPlayer?.isPlaying == true) {
                        mediaPlayer?.pause()
                    } else {
                        mediaPlayer?.start()
                    }
                },
        )*/
        //imagen local

        Image(
            painter = painterResource(id = pokemon.foto),
            contentDescription = "Pokeball",
            modifier = Modifier
                .size(350.dp)
                .fillMaxSize()
                .constrainAs(foto) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(datos.top)
                }
                .clickable {//reproduce su grito
                    val resourceId = context.resources.getIdentifier(
                        pokemon.name.lowercase(),
                        "raw",
                        context.packageName
                    )
                    // Initialize MediaPlayer if it's null
                    if (mediaPlayer == null) {
                        mediaPlayer = MediaPlayer.create(context, resourceId)
                    }
                    // Start or resume playback
                    if (mediaPlayer?.isPlaying == true) {
                        mediaPlayer?.pause()
                    } else {
                        mediaPlayer?.start()
                    }
                },

        )

        LazyColumn(
            modifier = Modifier
                .constrainAs(datos) {
                    top.linkTo(foto.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                    height = Dimension.fillToConstraints
                }
                .fillMaxHeight(),
            reverseLayout = true/////////////////
        ){
            item {
                ConstraintLayout{
                    Text(modifier = Modifier
                        .constrainAs(number) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            bottom.linkTo(nombre.top)////////????????????
                        }
                        .padding(bottom = 10.dp)
                        .fillMaxHeight(),//////////
                        fontWeight = FontWeight.Bold,
                        text = "#$numero",
                        fontSize = 30.sp)

                    Text(modifier = Modifier
                        .constrainAs(nombre) {
                            top.linkTo(number.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            bottom.linkTo(tipo1.top)
                        }
                        .padding(vertical = 10.dp),
                        fontWeight = FontWeight.Bold,
                        text = pokemon.name,
                        fontSize = 30.sp)

                    IconButton(
                        onClick = {
                            if (usuario.equipo.size < 6) {
                                updatedEquipo = (usuario.equipo + pokemon).toMutableList()
                                val updates = hashMapOf<String, Any>(
                                    "usuarios/${usuario.key}/equipo" to updatedEquipo
                                )

                                refBBDD.updateChildren(updates)
                                    .addOnSuccessListener {
                                        Toast.makeText(context, "${pokemon.name} se ha añadido a tu equipo", Toast.LENGTH_SHORT).show()
                                        Log.v("AÑADEEEEEEEEE", pokemon.name)
                                        // No need to finish the activity here
                                    }
                                    .addOnFailureListener { exception ->
                                        // Handle failure, but do not finish the activity
                                        // You might want to display an error message to the user
                                    }
                            } else {
                                Toast.makeText(context, "Ya hay 6 Pokemon en tu equipo", Toast.LENGTH_SHORT).show()
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.8f)
                            .constrainAs(add) {
                                top.linkTo(number.bottom)
                                start.linkTo(nombre.end)
                                end.linkTo(parent.end)
                                bottom.linkTo(tipo1.top)
                            }
                    ) {
                        Icon(
                            painter = painterResource(id = com.android.car.ui.R.drawable.car_ui_icon_add),
                            contentDescription = "Descripción del icono" // Agrega una descripción de contenido
                        )
                    }

                    if (pokemon.tipo.size == 1) {
                        Image(
                            painter = painterResource(id = enumToDrawableFB(pokemon.tipo[0])),
                            contentDescription = "Tipo 1",
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier
                                .width(80.dp)
                                .padding(vertical = 10.dp)
                                .constrainAs(tipo1) {
                                    start.linkTo(parent.start)
                                    end.linkTo(parent.end)
                                    top.linkTo(nombre.bottom)
                                    bottom.linkTo(desc.top)
                                }
                        )
                    } else {
                        Image(
                            painter = painterResource(id = enumToDrawableFB(pokemon.tipo[0])),
                            contentDescription = "Tipo 1",
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier
                                .width(80.dp)
                                .padding(vertical = 10.dp)
                                .constrainAs(tipo1) {
                                    start.linkTo(parent.start)
                                    end.linkTo(tipo2.start)
                                    top.linkTo(nombre.bottom)
                                    bottom.linkTo(desc.top)
                                },
                        )
                        Image(
                            painter = painterResource(id = enumToDrawableFB(pokemon.tipo[1])),
                            contentDescription = "Tipo 2",
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier
                                .width(80.dp)
                                .padding(vertical = 10.dp)
                                .constrainAs(tipo2) {
                                    start.linkTo(tipo1.end)
                                    end.linkTo(parent.end)
                                    top.linkTo(nombre.bottom)
                                    bottom.linkTo(desc.top)
                                }
                        )
                    }

                    Text(modifier = Modifier
                        .constrainAs(desc) {
                            top.linkTo(tipo1.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            //bottom.linkTo(interacciones.top)
                        }
                        .width(300.dp)
                        .padding(start = 20.dp, end = 20.dp, top = 10.dp, bottom = 15.dp),
                        text = pokemon.desc,
                        fontSize = 18.sp)

                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            //.padding(vertical = 10.dp)??????
                            //.wrapContentHeight()//-------------------
                            //.height(columnHeight.dp)
                            .constrainAs(interacciones) {
                                top.linkTo(desc.bottom)
                                bottom.linkTo(evos.top)
                            }
                    ){
                        val listaDummy= mutableListOf<PokemonFB>()//lista vacía para poder reutilizar la función. Una lista de equipo válida es necesaria si la opc==2
                        Interacciones(pokemon, listaDummy,1)//opción 1 para un único pokemon
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth()
                            //.padding(vertical = 10.dp)????????
                            .background(colorResource(id = R.color.electrico))
                            .constrainAs(evos) {
                                top.linkTo(interacciones.bottom)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                                bottom.linkTo(parent.bottom)
                            }
                    ){
                        //val test = listaPokeFB[pokemon.num-1]
                        Log.v(  "POKE", pokemon.toString())
                        Log.v(  "EVOS", evosPoke(pokemon).toString())
                        val evosPoke=evosPoke(pokemon)
                        //LineaEvo(evosPoke)
                        LineaEvo(evosPoke)
                    }
                }

            }

        }
    }
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VerListaPokemon(context: Context) {


    val listState = rememberLazyListState(
        initialFirstVisibleItemIndex = index,
    )
    LaunchedEffect(index) {
        listState.scrollToItem(index)
        if(desde_evos){
            show_evos=true
        }
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .zIndex(2f),
        horizontalArrangement = Arrangement.End
    ) {
        UserButton(context)
    }
    LazyRow(
        state = listState,
        modifier = Modifier
            .fillMaxSize(),
        flingBehavior = rememberSnapFlingBehavior(lazyListState = listState)
    ){
        items(listaPokeFireBase) { pokemon ->

            var color1: Color=colorResource(id = enumToColorFB(pokemon.tipo[0]))
            var color2: Color=colorResource(id = enumToColorFB(pokemon.tipo[0]))
            if (pokemon.tipo.size == 2) {
                color2 = colorResource(id = enumToColorFB(pokemon.tipo[1]))
            }

            Box(modifier = Modifier
                .fillParentMaxSize()
                .background(colorResource(id = R.color.white))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color2)
                        .fillMaxHeight(0.4f)//0.4f!!
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color1)
                        .fillMaxHeight(0.2f)
                )
                VerPokemon(pokemon, usuario_key)
            }
        }
    }
}
/*
@Preview(showBackground = true,widthDp = 350, heightDp = 600)
@Composable
fun DefaultPreview() {
    var pokemon = PokemonFB(249,"",R.drawable.lugia, "Lugia","Dicen que es el guardián de los mares. Hay rumores de que fue visto en una noche de tormenta.",listOf(PokemonTipoFB.PSIQUICO,PokemonTipoFB.VOLADOR))
    var listaAux = mutableListOf<PokemonFB>()
    var userAux = UserFb("nick","email","asfsdhgdfjhd","link")

    listaAux.add(pokemon)
    VerListaPokemon(listaAux, 0, userAux, LocalContext.current)
    //VerPokemon(listaAux[0])
}
*/