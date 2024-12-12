package com.david.pokedex_pruebas.interfaz

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
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
import androidx.compose.runtime.MutableState
import coil.compose.rememberAsyncImagePainter
import com.david.pokedex_pruebas.modelo.UsuarioFromKey
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


private lateinit var refBBDD: DatabaseReference
@Composable
fun PokemonCard(pokemon: PokemonFB, usuario_key:String, opc:Int, equipo:MutableState<List<PokemonFB>>) {
//    var arrayPoke=ArrayList<PokemonFB>()
//    arrayPoke.addAll(listaPokeFireBase)
    refBBDD = FirebaseDatabase.getInstance().reference
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
                            val index = pokemon.num - 1
                            val intent = Intent(context, ComposeVistaActivity::class.java)
                            //intent.putParcelableArrayListExtra("lista", arrayPoke)
                            intent.putExtra("sesion", usuario_key)
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

                //imagen local
                /*
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
                )*/

                //imagen remota
                /*
                AsyncImage(
                    model = pokemon.imagenFB,
                    contentScale = ContentScale.Crop,
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
        if(opc==2){
            var aux=UsuarioFromKey( usuario_key, refBBDD)
            IconButton(
                onClick = {
                    val updatedEquipo = aux.equipo.filter { it.name != pokemon.name }
                    val updates = hashMapOf<String, Any>(
                        "usuarios/$usuario_key/equipo" to updatedEquipo
                    )
                    refBBDD.updateChildren(updates)
                        .addOnSuccessListener {
                            Toast.makeText(context, "Has liberado a ${pokemon.name}", Toast.LENGTH_SHORT).show()
                        }
                        .addOnFailureListener {
                            // Handle error
                        }
                    equipo.value=updatedEquipo
                },
                modifier = Modifier
                    .constrainAs(delete) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)

                    }
                    .padding(top = 5.dp, end = 15.dp)
            ) {
                Icon(
                    painter = painterResource(id = com.android.car.ui.R.drawable.car_ui_icon_close),
                    contentDescription = "Descripción del icono" // Agrega una descripción de contenido
                )
            }
        }

    }

}


/*
@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    PokemonCard(listaPokeFB[7], "",2)
}
*/