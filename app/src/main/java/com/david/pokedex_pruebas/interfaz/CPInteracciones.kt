package com.david.pokedex_pruebas.interfaz

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.david.pokedex_pruebas.R
import com.david.pokedex_pruebas.modelo.PokemonFB
import com.david.pokedex_pruebas.modelo.debsFB
import com.david.pokedex_pruebas.modelo.fortsFB
import com.david.pokedex_pruebas.modelo.inmuneFB

@Composable
fun Interacciones(pokemon: PokemonFB, opc:Int){
    when(opc){
        1->{
            var altura=0
            var altura_forts=fortsFB(pokemon).size
            var altura_debs=debsFB(pokemon).size

            if(altura_debs>altura_forts)
                altura=altura_debs
            else altura=altura_forts

            altura=(altura+5)*16



            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 10.dp)
            ){

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(vertical = 10.dp)
                        .background(colorResource(id = R.color.planta))
                        .height(altura.dp),
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
                        .height(altura.dp),

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
                            //.fillMaxHeight()
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
        2->{

        }
    }

}