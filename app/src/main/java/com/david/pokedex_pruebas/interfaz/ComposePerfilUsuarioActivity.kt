package com.david.pokedex_pruebas.interfaz

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.app.ActivityCompat.recreate
import androidx.lifecycle.get
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.david.pokedex_pruebas.R
import com.david.pokedex_pruebas.interfaz.ui.theme.Pokedex_pruebasTheme
import com.david.pokedex_pruebas.modelo.UserFb
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
//import com.google.firebase.database.core.persistence.CachePolicy
import io.appwrite.models.InputFile
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import coil.request.CachePolicy
import coil.request.ErrorResult
import coil.request.SuccessResult
import com.david.pokedex_pruebas.modelo.PokemonFB
import com.david.pokedex_pruebas.modelo.PokemonTipoFB
import com.david.pokedex_pruebas.modelo.UsuarioFromKey
import com.david.pokedex_pruebas.modelo.listaPokeFB
import okhttp3.Dispatcher
import java.io.File

//private lateinit var sesionUser: ArrayList<UserFb>
private lateinit var refBBDD: DatabaseReference
lateinit var scopeUpdate: CoroutineScope
private lateinit var usuario_key: String


class ComposePerfilUsuarioActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        if (intent.hasExtra("sesion")) {
            usuario_key = intent.getStringExtra("sesion").toString()
        }else{
            usuario_key = ""
        }
        refBBDD = FirebaseDatabase.getInstance().reference
        super.onCreate(savedInstanceState)

        setContent {
            scopeUpdate = rememberCoroutineScope()
            PerfilUser(usuario_key, scopeUpdate, refBBDD)
        }
    }
}

@SuppressLint("ResourceAsColor")
@Composable
fun PerfilUser(usuario_key: String, scopeUpdate: CoroutineScope, refBBDD: DatabaseReference) {
    //var edicion by remember { mutableStateOf(false) }

    val usuario= UsuarioFromKey(usuario_key, refBBDD)
    Log.d("usuario", usuario.toString())

    var mostrar by remember { mutableStateOf((""))}
    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }
    var nick by remember { mutableStateOf((""))}
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var avatarLink by remember { mutableStateOf("") }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri: Uri? ->
            selectedImageUri = uri
        }
    )
    nick=usuario.nick
    email=usuario.email
    password=usuario.pass
    //avatarLink=usuario.avatar!!


    val context = LocalContext.current

    var muestra_perfil by remember { mutableStateOf(true) }

    var modifier_si_mensajes=if(muestra_perfil){
        Modifier
            .fillMaxSize()
            .background(colorResource(R.color.lista_con_foco))
            .padding(15.dp)
    } else{
        Modifier
            .fillMaxSize()
            .background(colorResource(R.color.lista_con_foco))
    }

    ConstraintLayout(//parent
        modifier = modifier_si_mensajes
    ) {
        val (avatar, opciones, inyecta, col1) = createRefs()
        if(muestra_perfil){//se oculta cuando se van a mostrar los chats
            Row(//row Avatar
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colorResource(R.color.lista_con_foco))//para ver el contorno
                    .constrainAs(avatar) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(opciones.top)
                    }
                    .fillMaxSize(0.2f)
            ){

                Column(//Column Foto
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(0.3f)
                        .background(colorResource(R.color.lista_con_foco)),
                    verticalArrangement = Arrangement.Center
                ){
                    UserButton( context, usuario_key)
                }
                Spacer(modifier = Modifier.weight(0.05f))//horizontal

                Column(//Column Datos
                    modifier = Modifier
                        .fillMaxHeight()
                        .background(
                            colorResource(R.color.transparente),
                            RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp)
                        )
                        .weight(0.65f)
                        .padding(vertical = 5.dp),
                    //.clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)),
                    horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
                ){
                    Column(
                        modifier = Modifier
                            .weight(0.5f)
                            .wrapContentHeight()
                    ){
                        Row(modifier = Modifier
                            .fillMaxHeight(0.5f)
                            .padding(end = 5.dp),//??????????
                            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ){
                            Text(modifier = Modifier
                                .padding(start = 10.dp)
                                .weight(0.3f)
                                .wrapContentWidth(),
                                text = nick,
                                color = Color.White,
                                fontWeight = FontWeight.Bold)
                            Text(modifier = Modifier
                                .padding(start = 10.dp)
                                .weight(0.7f)
                                .wrapContentWidth(),
                                text = email,
                                color = Color.White,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold)
                        }
                        Row(modifier = Modifier
                            //.fillMaxHeight(0.5f)
                            .fillMaxWidth()
                            .weight(0.3f)
                            .padding(10.dp)
                        )
                        {
                            Button(modifier = Modifier
                                .wrapContentHeight()
                                .weight(0.3f)
                                .padding(horizontal = 5.dp),
                                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                    containerColor = colorResource(R.color.rojo_muy_claro),
                                    contentColor = colorResource(R.color.white)
                                ),
                                shape = RoundedCornerShape(10.dp),
                                onClick = {
                                    mostrar = "Editar"
                                }
                            ) {
                                Text("Editar")
                            }
                            Button(modifier = Modifier
                                .wrapContentHeight()
                                .weight(0.3f)
                                .padding(horizontal = 5.dp),
                                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                    containerColor = colorResource(R.color.rojo_muy_claro),
                                    contentColor = colorResource(R.color.white)
                                ),
                                shape = RoundedCornerShape(10.dp),
                                onClick = {
                                    (context as? Activity)?.finish()
                                })
                            {
                                Text("Salir")
                            }
                        }

                    }


                }
            }

        }

        val modifier = Modifier
            .then(
                if (muestra_perfil) {
                    Modifier
                        .fillMaxWidth()
                        .background(
                            colorResource(R.color.transparente),
                            //RoundedCornerShape(topStart = 8.dp)
                        )
                        .constrainAs(opciones) {
                            if (muestra_perfil) top.linkTo(avatar.bottom)
                            else top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            bottom.linkTo(parent.bottom)
                        }
                        .fillMaxSize(0.8f)
                        .padding(vertical = 15.dp, horizontal = 5.dp)//
                } else {
                    Modifier
                        .fillMaxSize()
                        .background(
                            colorResource(R.color.transparente),
                            //RoundedCornerShape(topStart = 8.dp)
                        )
                        .constrainAs(opciones) {
                            if (muestra_perfil) top.linkTo(avatar.bottom)
                            else top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            bottom.linkTo(parent.bottom)
                        }
                        .fillMaxSize(0.8f)
                        .padding(vertical = 15.dp, horizontal = 5.dp)//
                }
            )

        Row(//Row de opciones
            modifier = modifier

        ){
            when(mostrar){//lo que muestra dependiendo de la opción
                "Editar" -> {
                    ConstraintLayout(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(colorResource(R.color.transparente))
                    ) {

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp)
                                .constrainAs(inyecta) {
                                    start.linkTo(parent.start)
                                    end.linkTo(parent.end)
                                    top.linkTo(col1.bottom)
                                    bottom.linkTo(parent.bottom)
                                }
                                .fillMaxHeight(1f),
                            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally

                        ) {
                            OutlinedTextField(
                                modifier = Modifier
                                    .background(colorResource(id = R.color.transparente))
                                    .fillMaxWidth(),
                                value = nick,
                                onValueChange = { nick = it },
                                label = { Text(
                                    color= colorResource(R.color.white),
                                    text="nick")},
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedBorderColor = colorResource(R.color.white),
                                    unfocusedBorderColor = colorResource(R.color.white),
                                    cursorColor = colorResource(R.color.white),
                                    focusedContainerColor= colorResource(R.color.rojo_muy_claro),
                                    focusedTextColor= colorResource(R.color.white),
                                    unfocusedTextColor= colorResource(R.color.white),
                                )
                            )
                            Spacer(modifier = Modifier.height(20.dp))
                            OutlinedTextField(
                                modifier = Modifier
                                    .background(colorResource(id = R.color.transparente))
                                    .fillMaxWidth(),
                                value = email,
                                onValueChange = { email = it },
                                label = { Text(
                                    color= colorResource(R.color.white),
                                    text="email")},
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedBorderColor = colorResource(R.color.white),
                                    unfocusedBorderColor = colorResource(R.color.white),
                                    cursorColor = colorResource(R.color.white),
                                    focusedContainerColor= colorResource(R.color.rojo_muy_claro),
                                    focusedTextColor= colorResource(R.color.white),
                                    unfocusedTextColor= colorResource(R.color.white),
                                )
                            )
                            Spacer(modifier = Modifier.height(20.dp))
                            OutlinedTextField(
                                value = password,
                                modifier = Modifier
                                    .background(colorResource(id = R.color.transparente))
                                    .fillMaxWidth(),
                                onValueChange = { password = it },
                                label = { Text(
                                    color= colorResource(R.color.white),
                                    text="contraseña")},
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedBorderColor = colorResource(R.color.white),
                                    unfocusedBorderColor = colorResource(R.color.white),
                                    cursorColor = colorResource(R.color.white),
                                    focusedContainerColor= colorResource(R.color.rojo_muy_claro),
                                    focusedTextColor= colorResource(R.color.white),
                                    unfocusedTextColor= colorResource(R.color.white),
                                ),
                                visualTransformation = PasswordVisualTransformation()
                            )
                            Spacer(modifier = Modifier.height(20.dp))


                            Button(
                                modifier = Modifier
                                    .padding(vertical = 8.dp),
                                onClick = { launcher.launch("image/*") },
                                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                    containerColor = colorResource(R.color.rojo_muy_claro),
                                    contentColor = colorResource(R.color.white)
                                ),
                                shape = RoundedCornerShape(10.dp),
                            ) {
                                Text("Cambia avatar")
                            }
                            Spacer(modifier = Modifier.height(8.dp))

                            if (selectedImageUri != null) {
                                AsyncImage(
                                    model = selectedImageUri,
                                    contentDescription = "Selected image",
                                    modifier = Modifier.size(100.dp)
                                )
                            }

                            Button(modifier = Modifier
                                .padding(vertical = 8.dp),
                                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                    containerColor = colorResource(R.color.rojo_muy_claro),
                                    contentColor = colorResource(R.color.white)
                                ),
                                shape = RoundedCornerShape(10.dp),
                                onClick = {
                                        val identificadorAppWrite = usuario.key.toString().substring(1, 20) ?: "" // coge el identificador
                                        avatarLink="https://cloud.appwrite.io/v1/storage/buckets/$appwrite_bucket/files/$identificadorAppWrite/preview?project=$appwrite_project"
                                        val inputStream = context.contentResolver.openInputStream(selectedImageUri!!)
                                        val usuarioCambios = UserFb(//objeto aux con los cambios
                                            nick,
                                            email,
                                            password,
                                            avatarLink,
                                            usuario.key.toString(),
                                            usuario.equipo
                                        )
                                        //referencia a Firebase
                                        //appwrite para el avater
                                        refBBDD.child("usuarios").child(usuario.key.toString()).setValue(usuarioCambios)
                                        if (inputStream != null) {
                                            scopeUpdate.launch {
                                                try{
                                                    val file = inputStream.use { input ->
                                                        val tempFile = kotlin.io.path.createTempFile().toFile()
                                                        tempFile.outputStream().use { output ->
                                                            input.copyTo(output)
                                                        }
                                                        InputFile.fromFile(tempFile) // Use fromFile method
                                                    }
                                                    withContext(Dispatchers.IO) {
                                                        //borra la foto vieja
                                                        storage.deleteFile(
                                                            bucketId = appwrite_bucket,
                                                            fileId = identificadorAppWrite
                                                        )
                                                        delay(500)
                                                        //crea la nueva foto con el mismo nombre
                                                        storage.createFile(
                                                            bucketId = appwrite_bucket,
                                                            fileId = identificadorAppWrite,
                                                            file = file
                                                        )
                                                        delay(500)
                                                    }
                                                }catch (e: Exception){
                                                    Log.e("UploadError", "Failed to upload image: ${e.message}")
                                                }
                                                finally {
                                                    Toast.makeText(context, "Usuario $nick actualizado con éxito", Toast.LENGTH_SHORT).show()
                                                    (context as? Activity)?.recreate()
                                                }
                                            }
                                        }

                                })
                            {
                                Text("Confirma")
                            }
                            Button(modifier = Modifier
                                .padding(vertical = 8.dp),
                                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                    containerColor = colorResource(R.color.rojo_muy_claro),
                                    contentColor = colorResource(R.color.white)
                                ),
                                shape = RoundedCornerShape(10.dp),
                                onClick = {
                                    mostrar=""
                                })
                            {
                                Text("Cancelar")
                            }
                        }
                    }

                }
                "Equipo"->{
                    ConstraintLayout(
                        modifier = Modifier
                            .wrapContentHeight()
                            .fillMaxWidth()
                    ){
                        val(equipo,boton1,boton2,titulo)=createRefs()
                        Text(modifier = Modifier
                                .constrainAs(titulo){
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                                top.linkTo(parent.top)
                                bottom.linkTo(equipo.top)
                            },
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            text = "EQUIPO")
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(0.9f)
                                .constrainAs(equipo) {
                                    start.linkTo(parent.start)
                                    end.linkTo(parent.end)
                                    top.linkTo(titulo.bottom)
                                    bottom.linkTo(boton1.top)
                                }
                        ){
                            items(usuario.equipo) { pokemon ->
                                usuario.key?.let { PokemonCard(pokemon, it, 2) }
                            }
                        }

                        Button(modifier = Modifier
                            .padding(vertical = 8.dp)
                            .constrainAs(boton1) {
                                start.linkTo(parent.start)
                                end.linkTo(boton2.start)
                                bottom.linkTo(parent.bottom)
                                top.linkTo(parent.bottom)
                            },
                            colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                containerColor = colorResource(R.color.rojo_muy_claro),
                                contentColor = colorResource(R.color.white)
                            ),
                            shape = RoundedCornerShape(10.dp),
                            onClick = {
                                mostrar="Interacciones"
                            })
                        {
                            Text("Interacciones")
                        }
                        Button(modifier = Modifier
                            .padding(vertical = 8.dp)
                            .constrainAs(boton2) {
                                start.linkTo(boton1.end)
                                end.linkTo(parent.end)
                                bottom.linkTo(parent.bottom)
                                top.linkTo(parent.bottom)
                            },
                            colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                containerColor = colorResource(R.color.rojo_muy_claro),
                                contentColor = colorResource(R.color.white)
                            ),
                            shape = RoundedCornerShape(10.dp),
                            onClick = {
                                mostrar=""
                            })
                        {
                            Text("Cancelar")
                        }

                    }
                }
                "Interacciones"->{
                    var tipos_equipo= mutableListOf<PokemonTipoFB>()
                    for (i in usuario.equipo){
                        tipos_equipo.add(i.tipo[0])
                        if(i.tipo.size>2){
                            tipos_equipo.add(i.tipo[1])
                        }
                    }
                    val auxPoke= PokemonFB(0,"_",0,"","",tipos_equipo)
                    ConstraintLayout(
                        modifier = Modifier
                            .wrapContentHeight()
                    ){
                        var (boton1)=createRefs()
                        Interacciones(auxPoke,usuario.equipo,2)// opción 2 para un equipo
                        Button(modifier = Modifier
                            .padding(vertical = 8.dp)
                            .constrainAs(boton1) {
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                                bottom.linkTo(parent.bottom)
                                top.linkTo(parent.bottom)
                            },
                            colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                containerColor = colorResource(R.color.rojo_muy_claro),
                                contentColor = colorResource(R.color.white)
                            ),
                            shape = RoundedCornerShape(10.dp),
                            onClick = {
                                mostrar="Equipo"
                            })
                        {
                            Text("Cancelar")
                        }
                    }

                }
                "Mensajes"->{
                    ConstraintLayout(
                        modifier = Modifier
                            .fillMaxSize()
                    ){

                        //contenido

                        //dummy para pruebas
                        val otro_key="-OChJafMy4GQUEw-rbog"

                        val otro=UsuarioFromKey(otro_key,refBBDD)
                        //fin de dummy

                        Chat(usuario, otro, usuario_key, mostrar, onMostrarChange = { newMostrar ->
                            mostrar = newMostrar
                            muestra_perfil=true
                        })
                    }
                }
                "Usuarios"->{
                    ConstraintLayout(
                        modifier = Modifier
                            .wrapContentHeight()
                            .fillMaxWidth()
                    ){
                        val(usuarios,boton1,boton2,titulo)=createRefs()
                        Text(modifier = Modifier
                            .constrainAs(titulo){
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                                top.linkTo(parent.top)
                                bottom.linkTo(usuarios.top)
                            },
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            text = "EQUIPO")
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(0.9f)
                                .constrainAs(usuarios) {
                                    start.linkTo(parent.start)
                                    end.linkTo(parent.end)
                                    top.linkTo(titulo.bottom)
                                    bottom.linkTo(boton1.top)
                                }
                        ){
                            items(usuario.equipo) { usuario ->
                                //todos los usuarios de la BD
                            }
                        }

                        Button(modifier = Modifier
                            .padding(vertical = 8.dp)
                            .constrainAs(boton1) {
                                start.linkTo(parent.start)
                                end.linkTo(boton2.start)
                                bottom.linkTo(parent.bottom)
                                top.linkTo(parent.bottom)
                            },
                            colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                containerColor = colorResource(R.color.rojo_muy_claro),
                                contentColor = colorResource(R.color.white)
                            ),
                            shape = RoundedCornerShape(10.dp),
                            onClick = {
                                mostrar="Interacciones"
                            })
                        {
                            Text("Interacciones")
                        }
                        Button(modifier = Modifier
                            .padding(vertical = 8.dp)
                            .constrainAs(boton2) {
                                start.linkTo(boton1.end)
                                end.linkTo(parent.end)
                                bottom.linkTo(parent.bottom)
                                top.linkTo(parent.bottom)
                            },
                            colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                containerColor = colorResource(R.color.rojo_muy_claro),
                                contentColor = colorResource(R.color.white)
                            ),
                            shape = RoundedCornerShape(10.dp),
                            onClick = {
                                mostrar=""
                            })
                        {
                            Text("Cancelar")
                        }

                    }
                }
                ""->{//aquí cada botón para abrir cada una de las opciones e inyectar el contenido en el when de arriba
                    ConstraintLayout() {
                        val (fb,equipo, mensajes, usuarios)=createRefs()
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .constrainAs(equipo) {
                                    start.linkTo(parent.start)
                                    top.linkTo(parent.top)
                                },
                            horizontalArrangement = Arrangement.Start
                        ){
                            Button(modifier = Modifier
                                .padding(vertical = 8.dp),
                                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                    containerColor = colorResource(R.color.rojo_muy_claro),
                                    contentColor = colorResource(R.color.white)
                                ),
                                shape = RoundedCornerShape(10.dp),
                                onClick = {
                                    mostrar="Equipo"
                                })
                            {
                                Text("Equipo")
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .constrainAs(mensajes) {
                                    start.linkTo(parent.start)
                                    top.linkTo(equipo.bottom)
                                },
                            horizontalArrangement = Arrangement.Start
                        ){
                            Button(modifier = Modifier
                                .padding(vertical = 8.dp),
                                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                    containerColor = colorResource(R.color.rojo_muy_claro),
                                    contentColor = colorResource(R.color.white)
                                ),
                                shape = RoundedCornerShape(10.dp),
                                onClick = {
                                    mostrar="Mensajes"
                                    muestra_perfil=false
                                })
                            {
                                Text("Mensajes")
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .constrainAs(usuarios) {
                                    start.linkTo(parent.start)
                                    top.linkTo(mensajes.bottom)
                                },
                            horizontalArrangement = Arrangement.Start
                        ){
                            Button(modifier = Modifier
                                .padding(vertical = 8.dp),
                                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                    containerColor = colorResource(R.color.rojo_muy_claro),
                                    contentColor = colorResource(R.color.white)
                                ),
                                shape = RoundedCornerShape(10.dp),
                                onClick = {
                                    mostrar="Usuarios"
                                })
                            {
                                Text("Usuarios")
                            }
                        }
                        /*
                        //////////////////////////////////////////////////////////////////////////////////////
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .constrainAs(fb) {
                                    start.linkTo(parent.start)
                                    top.linkTo(usuarios.bottom)
                                    //bottom.linkTo(parent.bottom)
                                },
                            horizontalArrangement = Arrangement.Start
                        ){
                            Button(modifier = Modifier
                                .padding(vertical = 8.dp),
                                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                    containerColor = colorResource(R.color.rojo_muy_claro),
                                    contentColor = colorResource(R.color.white)
                                ),
                                shape = RoundedCornerShape(10.dp),
                                onClick = {
                                    ///////////////////////////////////////////////////////////////////////////// NO BORRAR - sirve para actualizar FIREBASE y APPWRITE cuando se pulsa un elemento cualquiera de la lista
                                    //sube a Firebase y AppWrite
                                    //refStorage = FirebaseStorage.getInstance().reference
                                    for (i in listaPokeFB) {
                                        try {
                                            val resources = context.resources
                                            resources
                                                .openRawResource(i.foto)
                                                .use { inputStream ->
                                                    val identificador = refBBDD
                                                        .child("pokemones")
                                                        .push().key!!
                                                    refBBDD
                                                        .child("pokemones")
                                                        .child(identificador)
                                                        .setValue(i)

                                                    val tempFile = File.createTempFile(
                                                        identificador.drop(1),
                                                        ".png",
                                                        context.cacheDir
                                                    )
                                                    inputStream.use { input ->
                                                        tempFile
                                                            .outputStream()
                                                            .use { output ->
                                                                input.copyTo(output)
                                                            }
                                                    }
                                                    scope.launch {
                                                        withContext(
                                                            Dispatchers.IO
                                                        ) {

                                                            storage.createFile(
                                                                bucketId = appwrite_bucket,
                                                                fileId = identificador.drop(1),//elimina "_"
                                                                file = InputFile.fromPath(
                                                                    tempFile.absolutePath
                                                                )
                                                            )
                                                            tempFile.delete() // Delete after upload
                                                        }
                                                    }
                                                }
                                        } catch (e: Exception) {
                                            // Handle exceptions appropriately

                                        }
                                    }



                                })
                            {
                                Text("FB")
                            }
                        }
                        //////////////////////////////////////////////////////////////////////////////////////
                        */
                    }
                }
            }

        }





    }

}


/*

@Preview(showBackground = true)
@Composable
fun Vista() {
    scopeUpdate = rememberCoroutineScope()
    refBBDD = FirebaseDatabase.getInstance().reference
    PerfilUser("-OCQRBQkse69AQZPnrUH", scopeUpdate,refBBDD)
}*/