package com.david.pokedex_pruebas.interfaz

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.david.pokedex_pruebas.R
import com.david.pokedex_pruebas.modelo.PokemonOld
import com.david.pokedex_pruebas.modelo.enumToColor
import com.david.pokedex_pruebas.modelo.listaPoke

//https://developer.android.com/develop/ui/compose/mental-model?hl=es-419
class ComposeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var index=0
        setContent {
            VerPokemon(listaPoke)
        }
    }
}



@Composable
fun VerPokemon(pokemonLista:List<PokemonOld>){
    var selectedItemIndex by remember { mutableStateOf(0) }
    val index=selectedItemIndex
    val poke = pokemonLista[index]
    var color1: Color=colorResource(id = enumToColor(poke.tipo[0]))
    var color2: Color=colorResource(id = enumToColor(poke.tipo[0]))
    var numero = "${(index+1)}"
    if(numero.length == 1) numero = "00${(index + 1)}"
    else if(numero.length == 2) numero = "0${(index + 1)}"
    if (poke.tipo.size == 2) {
        color2 = colorResource(id = enumToColor(poke.tipo[1]))
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
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(4f)
                    .background(colorResource(R.color.white))
            ) {
                Text(modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 20.dp),
                    text = "#$numero",
                    fontSize = 20.sp)
                Text(modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 20.dp),
                    text = poke.name,
                    fontSize = 20.sp)

                LazyColumn (Modifier.padding(vertical = 16.dp).align(Alignment.CenterHorizontally)){
                    items(pokemonLista.size) { index ->
                        Text(modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(top = 15.dp)
                            .clickable {
                                selectedItemIndex = index
                            },

                        text = pokemonLista[index].name)
                    }
                }
            }
        }
        Image(
            painter = painterResource(id = poke.foto),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .align(Alignment.TopCenter)
                .offset(y = (-10).dp),
            contentScale = ContentScale.Fit
        )
    }
}


@Preview(widthDp = 300, heightDp = 500)
@Composable
fun DefaultPreview() {
    VerPokemon(listaPoke)
}
