package com.david.pokedex_pruebas.interfaz

import android.net.Uri
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListState
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.test.bottom
import androidx.compose.ui.test.top
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.tv.material3.Button
import com.david.pokedex_pruebas.R
import com.david.pokedex_pruebas.modelo.PokemonFB
import com.david.pokedex_pruebas.modelo.enumToColor
import com.david.pokedex_pruebas.modelo.enumToDrawableFB
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

//https://developer.android.com/develop/ui/compose/mental-model?hl=es-419


//firebase
/*
    private lateinit var refBBDD: DatabaseReference
    private lateinit var refStorage: StorageReference
    private lateinit var urlImagen: Uri
    private lateinit var identificador: String
*/



class ComposeVistaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //se rescatan los datos del intent
        //val poke = intent.getParcelableExtra<PokemonFB>("pokemon")
        val lista = intent.getParcelableArrayListExtra<PokemonFB>("lista" ) as List<PokemonFB>
        val indice = intent.getIntExtra("indice", 0)



        setContent {
            //VerPokemonScreen(poke?: PokemonFB())//para cuando se actualiza la FB
            VerListaPokemon(lista, indice)
            //VerPokemon(lista[45])
        }
    }
}


@Composable
fun VerPokemon(pokemon: PokemonFB) {

    val num=pokemon.num
    var numero = "${(num)}"
    if(numero.length == 1) numero = "00${(num)}"
    else if(numero.length == 2) numero = "0${(num)}"

    var color1: Color=colorResource(id = enumToColor(pokemon.tipo[0]))
    var color2: Color=colorResource(id = enumToColor(pokemon.tipo[0]))
    if (pokemon.tipo.size == 2) {
        color2 = colorResource(id = enumToColor(pokemon.tipo[1]))
    }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.transparente))
    ) {
        val (header1, header2, number,desc, nombre, foto, tipo1, tipo2) = createRefs()

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color1)
                .fillMaxHeight(0.2f)
                .constrainAs(header1) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color2)
                .fillMaxHeight(0.2f)
                .constrainAs(header2) {
                    top.linkTo(header1.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        Image(
            painter = painterResource(id = pokemon.foto),
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight(0.4f)
                .constrainAs(foto) {
                    top.linkTo(header1.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    //bottom.linkTo(header2.bottom)
                },
            contentScale = ContentScale.FillHeight
        )

        Text(modifier = Modifier
            .constrainAs(number) {
                top.linkTo(foto.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(nombre.top)
            }
            .padding(top = 40.dp),
            fontWeight = FontWeight.Bold,
            text = "#$numero",
            fontSize = 20.sp)

        if (pokemon.tipo.size == 1) {
            Image(
                painter = painterResource(id = enumToDrawableFB(pokemon.tipo[0])),
                contentDescription = "Tipo 1",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(140.dp)
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
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(100.dp)
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
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(100.dp)
                    .constrainAs(tipo2) {
                        start.linkTo(tipo1.end)
                        end.linkTo(parent.end)
                        top.linkTo(nombre.bottom)
                        bottom.linkTo(desc.top)
                    }
            )
        }

        Text(modifier = Modifier
            .constrainAs(nombre) {
                top.linkTo(number.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(desc.top)
            }
            .padding(top = 40.dp),
            fontWeight = FontWeight.Bold,
            text = pokemon.name,
            fontSize = 20.sp)

        Text(modifier = Modifier
            .constrainAs(desc) {
                top.linkTo(nombre.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            }
            .width(300.dp)
            .padding(all = 20.dp),
            text = pokemon.desc,
            fontSize = 20.sp)
    }

}

@Composable
fun VerListaPokemon(lista: List<PokemonFB>, indice:Int) {
    val listState = rememberLazyListState(
        initialFirstVisibleItemIndex = indice
    )
    LazyRow(
        state = listState,
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.transparente))
    ){
        items(lista) { pokemon ->
            VerPokemon(pokemon)
        }
    }
}














































/*
@Composable
fun VerPokemonScreen(pokemon:PokemonFB) {
    VerPokemon(pokemon) // Display the Pokemon list
}*/


/*
@Composable
fun VerPokemon2(pokemon:PokemonFB){
    //var selectedItemIndex by remember { mutableStateOf(0) }
    val num=pokemon.num
    var color1: Color=colorResource(id = enumToColor(pokemon.tipo[0]))
    var color2: Color=colorResource(id = enumToColor(pokemon.tipo[0]))
    var numero = "${(num)}"
    if(numero.length == 1) numero = "00${(num)}"
    else if(numero.length == 2) numero = "0${(num)}"
    if (pokemon.tipo.size == 2) {
        color2 = colorResource(id = enumToColor(pokemon.tipo[1]))
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(color1)
            ) {
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(color2)
            ) {
            }
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(4f)
                    .background(colorResource(R.color.white))
            ) {
                val (number, nombre, desc) = createRefs()

                Text(modifier = Modifier
                    .constrainAs(number){
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(nombre.top)
                    }
                    .padding(top = 40.dp),
                    fontWeight = FontWeight.Bold,
                    text = "#$numero",
                    fontSize = 20.sp)

                Text(modifier = Modifier
                    .constrainAs(nombre) {
                        top.linkTo(number.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(desc.top)
                    }
                    .padding(top = 40.dp),
                    fontWeight = FontWeight.Bold,
                    text = pokemon.name,
                    fontSize = 20.sp)

                Text(modifier = Modifier
                    .constrainAs(desc) {
                        top.linkTo(nombre.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    }
                    .width(300.dp)
                    .padding(all = 20.dp),
                    text = pokemon.desc,
                    fontSize = 20.sp)
            }
        }
        Image(
            painter = painterResource(id = pokemon.foto),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .align(Alignment.TopCenter)
                .offset(y = (-10).dp),
            contentScale = ContentScale.FillHeight
        )

    }
}
*/





/*
@Preview(widthDp = 300, heightDp = 500)
@Composable
fun DefaultPreview() {
    VerPokemon(poke)
}
*/
