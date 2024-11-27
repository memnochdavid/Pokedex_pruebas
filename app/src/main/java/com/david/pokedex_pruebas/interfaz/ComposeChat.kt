package com.david.pokedex_pruebas.interfaz

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
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
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.tv.material3.Text
import com.david.pokedex_pruebas.R
import com.david.pokedex_pruebas.modelo.MensajeFB
import com.david.pokedex_pruebas.modelo.UserFb
import com.david.pokedex_pruebas.modelo.UsuarioFromKey
import com.google.firebase.database.FirebaseDatabase

@Composable
fun Chat(emisor: UserFb, receptor: UserFb, sesion_key: String, mostrar: String, onMostrarChange: (String) -> Unit){
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
                .fillMaxHeight(0.08f)
                //.wrapContentHeight()
                .constrainAs(fila_avatar) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    //bottom
                },
        ){
            Column(
                modifier = Modifier
                    .weight(0.2f)
                    .padding(horizontal = 10.dp),
                verticalArrangement = Arrangement.Center
            ){
                receptor.key?.let { UserButton(context, it) }
            }
            Column(
                modifier = Modifier
                    .weight(0.6f),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ){
                Text(
                    text = receptor.nick,
                    color = colorResource(R.color.white),
                    modifier = Modifier
                        .fillMaxHeight()
                        .wrapContentWidth()
                        .padding(vertical = 20.dp)
                )
            }
            Column(
                modifier = Modifier
                    .weight(0.2f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
                ){
                Button(
                    modifier = Modifier
                        .background(colorResource(R.color.transparente))
                        //.fillMaxHeight(),
                        .wrapContentHeight(),
                    onClick = {
                        onMostrarChange("")
                    },
                    colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.transparente),
                        contentColor = colorResource(R.color.white)),
                    )
                {
                    Icon(
                        painter = painterResource(id = R.drawable.atras),
                        contentDescription = "Cancelar"
                    )
                }
            }
        }
        Row(//lazyrow cuando apañe FB
            modifier = Modifier
                .fillMaxHeight(0.82f)
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
            //conversación dummy
            var refBBDD= FirebaseDatabase.getInstance().getReference()
            var emisor= UsuarioFromKey("-OCYd1tvcSLb5ypwD6oT", refBBDD)
            var receptor= UsuarioFromKey("-OCcuV7oh20OTxz5SzQV", refBBDD)
            var mensaje1= MensajeFB(emisor,receptor,"dd/MM/yyyy HH:mm:ss", "ola k ase")
            var mensaje2= MensajeFB(receptor,emisor,"dd/MM/yyyy HH:mm:ss", "ta respondiendo o k ase")
            var mensaje3= MensajeFB(emisor,receptor,"dd/MM/yyyy HH:mm:ss", "otro mensaje")
            var mensaje4= MensajeFB(receptor,emisor,"dd/MM/yyyy HH:mm:ss", "esto es relleno")
            var mensaje5= MensajeFB(emisor,receptor,"dd/MM/yyyy HH:mm:ss", "te odio")
            var mensaje6= MensajeFB(receptor,emisor,"dd/MM/yyyy HH:mm:ss", "eres un mamón")
            var mensaje7= MensajeFB(emisor,receptor,"dd/MM/yyyy HH:mm:ss", "pues anda que tú")
            var mensaje8= MensajeFB(receptor,emisor,"dd/MM/yyyy HH:mm:ss", "deja de acosarme")
            var mensaje9= MensajeFB(emisor,receptor,"dd/MM/yyyy HH:mm:ss", "probando el scroll")
            var mensaje10= MensajeFB(receptor,emisor,"dd/MM/yyyy HH:mm:ss", "más relleno")
            var mensaje11= MensajeFB(emisor,receptor,"dd/MM/yyyy HH:mm:ss", "esto es un coñazo")
            var mensaje12= MensajeFB(receptor,emisor,"dd/MM/yyyy HH:mm:ss", "no sé qué poner")
            var mensaje13= MensajeFB(emisor,receptor,"dd/MM/yyyy HH:mm:ss", "trabajando en el chat")
            var mensaje14= MensajeFB(receptor,emisor,"dd/MM/yyyy HH:mm:ss", "intercambio de mensajes")
            var mensaje15= MensajeFB(emisor,receptor,"dd/MM/yyyy HH:mm:ss", "tiki taka, salinas")
            var mensaje16= MensajeFB(receptor,emisor,"dd/MM/yyyy HH:mm:ss", "y apareció muerto en su casa lol")
            var mensaje17= MensajeFB(emisor,receptor,"dd/MM/yyyy HH:mm:ss", "te repondo")
            var mensaje18= MensajeFB(receptor,emisor,"dd/MM/yyyy HH:mm:ss", "no has dicho nada")
            var conversacion= listOf(mensaje1,mensaje2,mensaje3,mensaje4,mensaje5,mensaje6,mensaje7,mensaje8,mensaje9,mensaje10,mensaje11,mensaje12,mensaje13,mensaje14,mensaje15,mensaje16,mensaje17,mensaje18)
            //fin mensaje dummy

            var color= colorResource(R.color.white)
            val listState = rememberLazyListState()
            LazyColumn(
                state = listState
            ) {
                items(conversacion) { mensaje ->
                    color = if (mensaje.emisor.key == emisor.key) {
                        colorResource(id=R.color.mensajeout)
                    } else {
                        colorResource(id=R.color.mensajein)
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth() // Fill the width for better alignment
                            .wrapContentHeight()
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
            LaunchedEffect(conversacion) {
                listState.scrollToItem(conversacion.lastIndex)
            }

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .constrainAs(escribe) {
                    top.linkTo(chat.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
                .background(colorResource(R.color.transparente))
        ){
            var scrollMensajeInput=rememberScrollState()
            var text by remember { mutableStateOf("escribe tu mensaje") }
            var isFocused by remember { mutableStateOf(false) }
            BasicTextField(
                value = text,
                modifier = Modifier
                    .background(colorResource(id = R.color.transparente))
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .scrollable(
                        state = scrollMensajeInput,
                        enabled = true,
                        orientation = androidx.compose.foundation.gestures.Orientation.Vertical
                    )
                    .padding(horizontal = 20.dp)
                    .onFocusChanged { focusState ->
                        isFocused = focusState.isFocused
                        if (isFocused && text == "escribe tu mensaje") {
                            text = ""
                        }
                    },
                onValueChange = { newText ->
                    text = newText
                },
                decorationBox = { innerTextField ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        innerTextField()
                        IconButton(
                            onClick = {
                                // Handle send button click
                            }
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.Send,
                                contentDescription = "Send",
                                tint = colorResource(id = R.color.white)
                            )
                        }
                    }
                },
                textStyle = TextStyle(color = colorResource(id = R.color.white)),
                cursorBrush= SolidColor(colorResource(id = R.color.white)),
            )


        }

    }
}
