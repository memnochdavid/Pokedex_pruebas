
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
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import coil.compose.AsyncImage
import com.david.pokedex_pruebas.modelo.adaptaNombre

//https://developer.android.com/develop/ui/compose/mental-model?hl=es-419


//firebase

private lateinit var refBBDD: DatabaseReference
private lateinit var usuario_key: String
    /*
    private lateinit var refStorage: StorageReference
    private lateinit var urlImagen: Uri
    private lateinit var identificador: String*/




class ComposeVistaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        refBBDD = FirebaseDatabase.getInstance().reference

        if (intent.hasExtra("sesion")) {
            usuario_key = intent.getStringExtra("sesion").toString()
        }else{
            usuario_key = ""
        }


        //se rescatan los datos del intent
        //val poke = intent.getParcelableExtra<PokemonFB>("pokemon")
        //val lista = intent.getParcelableArrayListExtra<PokemonFB>("lista" ) as List<PokemonFB>
        val indice = intent.getIntExtra("indice", 0)
        //val sesion = intent.getParcelableArrayListExtra<UserFb>("sesion" ) as List<UserFb>
        //enableEdgeToEdge()
        setContent{
            //VerPokemonScreen(poke?: PokemonFB())//para cuando se actualiza la FB
            VerListaPokemon(listaPokeFireBase, indice, usuario_key, this, refBBDD)
            //VerPokemon(lista[45])
        }
    }
}



@Composable
fun VerPokemon(pokemon: PokemonFB, usuario:UserFb) {
    val num=pokemon.num
    var numero = "${(num)}"
    if(numero.length == 1) numero = "00${(num)}"
    else if(numero.length == 2) numero = "0${(num)}"

    var mediaPlayer: MediaPlayer? = null

    val context = LocalContext.current


    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 0.dp)
    ) {
        val (number,desc, nombre, foto, tipo1, tipo2,datos,interacciones,add) = createRefs()
        //imagen remote
        AsyncImage(
            model = pokemon.imagenFB,
            contentDescription = null,
            //contentScale = ContentScale.Crop,
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
        )
/*
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

        )*/
        LazyColumn(
            modifier = Modifier
                .constrainAs(datos) {
                    top.linkTo(foto.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                    height = Dimension.fillToConstraints
                }
                .fillMaxHeight()
        ){
            item {
                ConstraintLayout{
                    Text(modifier = Modifier
                        .constrainAs(number) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            //bottom.linkTo(parent.bottom)
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
                                val updatedEquipo = usuario.equipo + pokemon
                                val updates = hashMapOf<String, Any>(
                                    "usuarios/${usuario.key}/equipo" to updatedEquipo
                                )
                                refBBDD.updateChildren(updates)
                                    .addOnSuccessListener {
                                        Toast.makeText(context, "${pokemon.name} se ha añadido a tu equipo", Toast.LENGTH_SHORT).show()
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
                            bottom.linkTo(interacciones.top)
                        }
                        .width(300.dp)
                        .padding(horizontal = 20.dp, vertical = 10.dp),
                        text = pokemon.desc,
                        fontSize = 18.sp)

                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(vertical = 10.dp)
                            //.wrapContentHeight()//-------------------
                            //.height(columnHeight.dp)
                            .constrainAs(interacciones) {
                                top.linkTo(desc.bottom)
                                bottom.linkTo(parent.bottom)
                            }
                    ){
                        Interacciones(pokemon,1)//opción 1 para un único pokemon
                    }
                }

            }

        }
    }
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VerListaPokemon(lista: List<PokemonFB>, indice:Int, usuario_key: String, context: Context, refBBDD: DatabaseReference) {

    val usuario=UsuarioFromKey(usuario_key, refBBDD)

    val listState = rememberLazyListState(
        initialFirstVisibleItemIndex = indice
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .zIndex(2f),
        horizontalArrangement = Arrangement.End
    ) {
        usuario.key?.let { UserButton(context, it) }
    }
    LazyRow(
        state = listState,
        modifier = Modifier
            .fillMaxSize(),
            //.fillMaxHeight(0.6f),
            //.wrapContentHeight(),
        flingBehavior = rememberSnapFlingBehavior(lazyListState = listState)
    ){
        items(lista) { pokemon ->

            var color1: Color=colorResource(id = enumToColorFB(pokemon.tipo[0]))
            var color2: Color=colorResource(id = enumToColorFB(pokemon.tipo[0]))
            if (pokemon.tipo.size == 2) {
                color2 = colorResource(id = enumToColorFB(pokemon.tipo[1]))
            }

            Box(modifier = Modifier
                //.fillParentMaxWidth()
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
                VerPokemon(pokemon, usuario)
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