package com.david.pokedex_pruebas.interfaz

import android.util.Log
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.david.pokedex_pruebas.R
import com.david.pokedex_pruebas.modelo.PokemonFB
import com.david.pokedex_pruebas.modelo.debilidadesEquipo
import com.david.pokedex_pruebas.modelo.debsFB
import com.david.pokedex_pruebas.modelo.fortalezasEquipo
import com.david.pokedex_pruebas.modelo.fortsFB
import com.david.pokedex_pruebas.modelo.inmuneFB

@Composable
fun Interacciones(pokemon: PokemonFB, equipo:List<PokemonFB>, opc:Int){
    var altura by remember { mutableStateOf(0f) }
    var altura_forts=fortsFB(pokemon).size
    var altura_debs=debsFB(pokemon).size
    if(altura_debs>altura_forts)
        altura= altura_debs.toFloat()
    else altura= altura_forts.toFloat()

    altura=(altura+6)*16//se calcula la altura de la columna más grande, y se le aplica a todas


    val alturaInter by animateFloatAsState(
        targetValue = if (show_interacciones) altura else 0f,
        animationSpec = tween(durationMillis = 300) // duración
    )
    val debilidadesEquipo= debilidadesEquipo(equipo)
    val fortalezasEquipo= fortalezasEquipo(equipo)


    when(opc){
        1->{
            //altura=(altura+5)*16//se calcula la altura de la columna más grande, y se le aplica a todas

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(colorResource(id = R.color.acero))
            ){
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ){
                    Text(
                        text ="Interacciones",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier
                            .wrapContentWidth()
                            .padding(vertical = 10.dp)
                            .clickable {
                                show_interacciones = !show_interacciones
                                show_desc = false
                                show_regis = false
                                show_evos = false
                                show_gigamax=false
                                show_megaevos=false
                                show_formas_unown=false
                                Log.d("EQUIPO", equipo.toString())
                            },
                    )
                }

                Row(
                    modifier = Modifier
                        .height(alturaInter.dp)
                    //.padding(vertical = 10.dp)
                ){
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(vertical = 10.dp)
                            .background(colorResource(id = R.color.planta))
                            .height(alturaInter.dp),
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
                            //.fillMaxHeight()
                            .background(colorResource(id = R.color.fuego))
                            .height(alturaInter.dp),

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
                                .height(altura.dp)
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
        2->{//fortalezas y debilidades acumuladas del equipo

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 10.dp),
                verticalAlignment = Alignment.Top
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(vertical = 10.dp)
                        .background(colorResource(id = R.color.transparente))
                        .wrapContentHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = "Fortalezas",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(vertical = 5.dp),
                        color = colorResource(id = R.color.white)
                    )
                }
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(vertical = 10.dp)
                        .background(colorResource(id = R.color.transparente))
                        .wrapContentHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ){
                    Text(
                        text = "Debilidades",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(vertical = 5.dp),
                        color = colorResource(id = R.color.white)
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 10.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .verticalScroll(state = rememberScrollState())
                        .padding(vertical = 10.dp)
                        .background(colorResource(id = R.color.transparente))
                        //.height(altura.dp),
                        .wrapContentHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {
                    //fortalezas equipo
                    for (fortaleza in fortalezasEquipo(equipo)){
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
                        .verticalScroll(state = rememberScrollState())
                        .padding(vertical = 10.dp)
                        .background(colorResource(id = R.color.transparente))
                        //.height(altura.dp),
                        .wrapContentHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {
                    for (debilidades in debilidadesEquipo(equipo)){
                        Image(
                            painter = painterResource(id = debilidades),
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