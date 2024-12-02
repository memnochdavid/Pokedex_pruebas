package com.david.pokedex_pruebas.interfaz

import android.annotation.SuppressLint
import android.util.Log
import androidx.activity.result.launch
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.tv.material3.Text
import com.david.pokedex_pruebas.R
import com.david.pokedex_pruebas.modelo.ConversacionFB
import com.david.pokedex_pruebas.modelo.MensajeFB
import com.david.pokedex_pruebas.modelo.UserFb
import com.david.pokedex_pruebas.modelo.UsuarioFromKey
import com.david.pokedex_pruebas.modelo.cargaChats
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.launch
import kotlin.collections.addAll

@Composable
fun Chat(receptor_key: String, sesion_key: String, mostrar: String,onMostrarChange: (String) -> Unit){
    val context = LocalContext.current
    val refBBDD = FirebaseDatabase.getInstance().getReference()
    var emisor= UsuarioFromKey(sesion_key,refBBDD)
    var receptor= UsuarioFromKey(receptor_key,refBBDD)
    //var idChat=refBBDD.child("chats").push().key!!
    var conversacion by remember { mutableStateOf<ConversacionFB?>(ConversacionFB("",sesion_key, receptor_key, mutableListOf<MensajeFB>())) }
    val lifecycleScope = rememberCoroutineScope()
    var mensajes = remember { mutableStateListOf<MensajeFB>() }

    LaunchedEffect(key1 = refBBDD, key2 = sesion_key) {
        lifecycleScope.launch {
            conversacion = cargaChats(refBBDD, sesion_key, id_receptor)
        }
    }


// Initialize mensajes with your initial data
    LaunchedEffect(key1 = conversacion!!.mensajes) {
        mensajes.addAll(conversacion!!.mensajes)
    }


    var color= colorResource(R.color.white)
    val listState = rememberLazyListState()

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
            LazyColumn(
                state = listState,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
            ) {
                items(mensajes, key = { it }) { mensaje ->
                    Log.d("mensaje",mensaje.texto)
                    color = if (mensaje.idUser == emisor.key) {
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
                        horizontalArrangement = if (mensaje.idUser == emisor.key) {
                            Arrangement.End // el que escribe a la derecha
                        } else {
                            Arrangement.Start // el que escribe a la izquierda
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
            var mensajeAux= MensajeFB(sesion_key,"","dd/MM/yyyy HH:mm:ss", text)//no funcionará, arregla el idReceptor
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
                                mensajeAux.texto=text
                                mensajeAux.idUser=sesion_key
                                mensajeAux.idReceptor=receptor.key!!
                                mensajes+=mensajeAux
                                conversacion!!.mensajes.add(mensajeAux)
                                conversacion!!.idUser=sesion_key
                                conversacion!!.idReceptor=receptor.key!!
                                text = ""
                                refBBDD.child("chats").child(conversacion!!.idChat).setValue(conversacion)
                            }
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.Send,
                                contentDescription = "Send",
                                tint = colorResource(id = R.color.white)
                            )
                        }
                    }
                    //para actualizar el scroll
                    LaunchedEffect(mensajes) {
                        if (mensajes.isNotEmpty()) {
                            listState.scrollToItem(mensajes.lastIndex)
                        }
                    }
                },
                textStyle = TextStyle(color = colorResource(id = R.color.white)),
                cursorBrush= SolidColor(colorResource(id = R.color.white)),
            )


        }

    }
}
