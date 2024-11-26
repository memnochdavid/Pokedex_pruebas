package com.david.pokedex_pruebas.interfaz

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.tv.material3.Text
import com.david.pokedex_pruebas.R
import com.david.pokedex_pruebas.modelo.MensajeFB
import com.david.pokedex_pruebas.modelo.UserFb
import com.david.pokedex_pruebas.modelo.UsuarioFromKey
import com.google.firebase.database.FirebaseDatabase

@Composable
fun Chat(emisor: UserFb, receptor: UserFb, sesion_key:String){
    val context = LocalContext.current
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.rojo_claro))
    ) {
        val (fila_avatar,chat, escribe) = createRefs()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.2f)
                .constrainAs(fila_avatar){
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    //bottom
                },
        ){
            Column(
                modifier = Modifier
                    .weight(0.3f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                emisor.key?.let { UserButton(context, it) }
            }
            Column(
                modifier = Modifier
                    .weight(0.7f),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ){
                Text(
                    text = emisor.email,
                    color = colorResource(R.color.white),
                    modifier = Modifier
                        .fillMaxHeight()
                        .wrapContentWidth()
                        .padding(vertical = 20.dp)
                )
            }
        }
        Row(//lazyrow cuando apañe FB
            modifier = Modifier
                .fillMaxHeight(0.8f)
                .fillMaxWidth()
                .constrainAs(chat) {
                    top.linkTo(fila_avatar.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(escribe.top)
                }
                .background(colorResource(R.color.rojo_muy_claro)),
            verticalAlignment = Alignment.Top
        ){
            //chat
            //mensaje dummy
            var refBBDD= FirebaseDatabase.getInstance().getReference()
            var emisor= UsuarioFromKey("-OCYd1tvcSLb5ypwD6oT", refBBDD)
            var receptor= UsuarioFromKey("-OCcuV7oh20OTxz5SzQV", refBBDD)
            var mensaje1= MensajeFB(emisor,receptor,"dd/MM/yyyy HH:mm:ss", "ola k ase")
            var mensaje2= MensajeFB(receptor,emisor,"dd/MM/yyyy HH:mm:ss", "ta respondiendo o k ase")
            var mensaje3= MensajeFB(emisor,receptor,"dd/MM/yyyy HH:mm:ss", "otro mensaje")
            var mensaje4= MensajeFB(receptor,emisor,"dd/MM/yyyy HH:mm:ss", "esto es relleno")
            var mensaje5= MensajeFB(emisor,receptor,"dd/MM/yyyy HH:mm:ss", "te odio")
            var mensaje6= MensajeFB(receptor,emisor,"dd/MM/yyyy HH:mm:ss", "eres un mamón")
            var conversacion= listOf(mensaje1,mensaje2,mensaje3,mensaje4,mensaje5,mensaje6)
            //fin mensaje dummy

            var color= colorResource(R.color.white)


            LazyColumn {
                items(conversacion) { mensaje ->
                    color = if (mensaje.emisor.key == emisor.key) {
                        colorResource(id=R.color.mensajeout)
                    } else {
                        colorResource(id=R.color.mensajein)
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth() // Fill the width for better alignment
                            .background(colorResource(R.color.transparente))
                            .padding(vertical = 15.dp, horizontal = 15.dp),
                        horizontalArrangement = if (mensaje.emisor.key == emisor.key) {
                            Arrangement.End // Align messages from emisor to the right
                        } else {
                            Arrangement.Start // Align messages from receptor to the left
                        },
                    ) {
                        Mensaje(mensaje, color)
                    }
                }
            }

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .constrainAs(escribe) {
                    top.linkTo(chat.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
                .background(colorResource(R.color.transparente))
        ){
            //text input
        }

    }
}
