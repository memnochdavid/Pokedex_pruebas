
package com.david.pokedex_pruebas.interfaz

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.core.copy
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.david.pokedex_pruebas.R
import com.david.pokedex_pruebas.modelo.PokemonFB
import com.david.pokedex_pruebas.modelo.PokemonTipoFB
import com.david.pokedex_pruebas.modelo.debsFB
import com.david.pokedex_pruebas.modelo.enumToColorFB
import com.david.pokedex_pruebas.modelo.enumToDrawableFB
import com.david.pokedex_pruebas.modelo.fortsFB
import com.david.pokedex_pruebas.modelo.inmuneFB
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration

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
        //enableEdgeToEdge()
        setContent{
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

    val scrollState = rememberScrollState()

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 0.dp)
    ) {
        val (number,desc, nombre, foto, tipo1, tipo2,datos,interacciones) = createRefs()
        Image(
            painter = painterResource(id = pokemon.foto),
            contentDescription = null,
            modifier = Modifier
                //.fillMaxHeight(0.5f)
                //.fillMaxWidth()
                .size(350.dp)
                .constrainAs(foto) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    //bottom.linkTo(number.top)
                },
            contentScale = ContentScale.Fit
        )
        Box(
            modifier = Modifier
                .verticalScroll(scrollState)
                //.wrapContentSize()
                //.heightIn(min = 0.dp, max = 750.dp)
                .constrainAs(datos) {
                    top.linkTo(foto.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                    height = Dimension.fillToConstraints
                }
            //.padding(top = 20.dp)
        ){
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxWidth()
                //.fillMaxHeight(0.2f)
            ){
                Text(modifier = Modifier
                    .constrainAs(number) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        //bottom.linkTo(nombre.top)
                    }
                    .padding(bottom = 10.dp),
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
                    //.padding(top = 40.dp),
                    fontWeight = FontWeight.Bold,
                    text = pokemon.name,
                    fontSize = 30.sp)

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
                        //.height(IntrinsicSize.Max)
                        .constrainAs(interacciones) {
                            top.linkTo(desc.bottom)
                            bottom.linkTo(parent.bottom)
                        }
                ){
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(vertical = 10.dp)
                            .fillMaxHeight()
                            .background(colorResource(id = R.color.planta)),

                        horizontalAlignment = Alignment.CenterHorizontally

                    ){
                        Text(text = "Eficaz contra", fontWeight = FontWeight.Bold, fontSize = 18.sp, modifier = Modifier.padding(vertical = 5.dp))
                        for (fortaleza in fortsFB(pokemon)){
                            Image(
                                painter = painterResource(id = fortaleza),
                                contentDescription = "Debilidad",
                                contentScale = ContentScale.FillWidth,
                                modifier = Modifier
                                    .width(80.dp)
                                    .padding(vertical = 2.5.dp)
                            )
                        }
                    }
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(vertical = 10.dp)
                            .fillMaxHeight()
                            .background(colorResource(id = R.color.fuego)),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Text(text = "Débil ante", fontWeight = FontWeight.Bold, fontSize = 18.sp, modifier = Modifier.padding(vertical = 5.dp))
                        for (debilidad in debsFB(pokemon)){
                            Image(
                                painter = painterResource(id = debilidad),
                                contentDescription = "Debilidad",
                                contentScale = ContentScale.FillWidth,
                                modifier = Modifier
                                    .width(80.dp)
                                    .padding(vertical = 2.5.dp)
                            )
                        }
                    }
                    var inmus=inmuneFB(pokemon)
                    if(inmus.size>0){
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .padding(vertical = 10.dp)
                                .fillMaxHeight()
                                .background(colorResource(id = R.color.objeto_lista)),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Text(text = "Inmune a", fontWeight = FontWeight.Bold, fontSize = 18.sp, modifier = Modifier.padding(vertical = 5.dp))
                            for (inmu in inmuneFB(pokemon)){
                                Image(
                                    painter = painterResource(id = inmu),
                                    contentDescription = "Debilidad",
                                    contentScale = ContentScale.FillWidth,
                                    modifier = Modifier
                                        .width(80.dp)
                                        .padding(vertical = 2.5.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VerListaPokemon(lista: List<PokemonFB>, indice:Int) {

    val listState = rememberLazyListState(
        initialFirstVisibleItemIndex = indice
    )


    LazyRow(
        state = listState,
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight(0.6f)
            .wrapContentHeight(),
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
                VerPokemon(pokemon)
            }
        }
    }
}

@Preview(showBackground = true,widthDp = 350, heightDp = 600)
@Composable
fun DefaultPreview() {
    var pokemon = PokemonFB(249,"",R.drawable.lugia, "Lugia","Dicen que es el guardián de los mares. Hay rumores de que fue visto en una noche de tormenta.",listOf(PokemonTipoFB.PSIQUICO,PokemonTipoFB.VOLADOR))
    var listaAux = mutableListOf<PokemonFB>()
    listaAux.add(pokemon)
    VerListaPokemon(listaAux, 0)
    //VerPokemon(listaAux[0])
}
