package com.david.pokedex_pruebas.interfaz

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.david.pokedex_pruebas.R
import com.david.pokedex_pruebas.modelo.PokemonTipoFB
import com.david.pokedex_pruebas.modelo.enumToDrawableFB_busqueda

@Composable
fun Menu(alturaCampoBusqueda:Float,busquedaTipos:MutableState<Boolean>,tipoBuscado:MutableState<String>,textobusqueda:MutableState<String>){
    ConstraintLayout(
        modifier = Modifier
            .background(colorResource(R.color.fuego))
            .height(alturaCampoBusqueda.dp)
    ) {
        val (descBusqueda,busquedaTipo,switchBusqueda)=createRefs()
        var tipoBus=""
        if(!busquedaTipos.value)tipoBus="NOMBRE"
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
            checked = busquedaTipos.value,
            onCheckedChange = {
                busquedaTipos.value = it
            }
        )
        if(!busquedaTipos.value)OutlinedTextField(
            value = textobusqueda.value,
            onValueChange = { textobusqueda.value = it },
            label = { Text("Buscar") },
            modifier = Modifier
                .padding(all = 25.dp)
                .width(300.dp)
                .background(color = colorResource(id = R.color.white))
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
                                    tipoBuscado.value = tipo.tag
                                }
                            )
                    )
                }
            }
        }

    }
}