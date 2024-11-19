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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
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
import okhttp3.Dispatcher

private lateinit var sesionUser: ArrayList<UserFb>
private lateinit var refBBDD: DatabaseReference
lateinit var scopeUpdate: CoroutineScope

class ComposePerfilUsuarioActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val sesion = intent.getParcelableArrayListExtra<UserFb>("sesion" ) as List<UserFb>
        if (intent.hasExtra("sesion")) {
            sesionUser = intent.getParcelableArrayListExtra("sesion")!!
        }else{
            sesionUser = arrayListOf()
        }
        refBBDD = FirebaseDatabase.getInstance().reference
        super.onCreate(savedInstanceState)
        setContent {
            scopeUpdate = rememberCoroutineScope()
            PerfilUser(sesion[0], scopeUpdate)
        }
    }
}

@SuppressLint("ResourceAsColor")
@Composable
fun PerfilUser(usuario: UserFb, scopeUpdate: CoroutineScope) {

    var edicion by remember { mutableStateOf(false) }
    var mostrar by remember { mutableStateOf((""))}
    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }
    var nick by remember { mutableStateOf(if (sesionUser.isNullOrEmpty() && !edicion) "" else sesionUser[0].nick) }
    var email by remember { mutableStateOf(if (sesionUser.isNullOrEmpty() && !edicion) "" else sesionUser[0].email) }
    var password by remember { mutableStateOf(if (sesionUser.isNullOrEmpty() && !edicion) "" else sesionUser[0].pass) }
    var avatarLink by remember { mutableStateOf(if (sesionUser.isNullOrEmpty() && !edicion) "" else sesionUser[0].avatar) }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri: Uri? ->
            selectedImageUri = uri
        }
    )
    val context = LocalContext.current


    ConstraintLayout(//parent
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.lista_con_foco))
            .padding(15.dp)
    ) {
        val (avatar, opciones, inyecta, col1) = createRefs()
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
                /*
                AsyncImage(
                    model = usuario.avatar,
                    contentDescription = "avatar de usuario",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.8f)
                        .clip(CircleShape)
                        .background(colorResource(R.color.fuego))
                        .clip(CircleShape)
                )
            }*/

                //toda esta mierda es para que la imagen no se almacene en cache y se muestre bien cuando se modifica el avatar
                Surface(modifier = Modifier
                    .fillMaxSize()
                    .background(colorResource(R.color.lista_con_foco))
                ) {
                    //val context = LocalContext.current
                    //val placeholder = R.drawable.tr
                    val imageUrl = usuario.avatar
                    // Build an ImageRequest with Coil
                    val listener = object : ImageRequest.Listener {
                        override fun onError(request: ImageRequest, result: ErrorResult) {
                            super.onError(request, result)
                        }

                        override fun onSuccess(request: ImageRequest, result: SuccessResult) {
                            super.onSuccess(request, result)
                        }
                    }
                    val imageRequest = ImageRequest.Builder(context)
                        .data(imageUrl)
                        .listener(listener)
                        .dispatcher(Dispatchers.IO)
                        .memoryCacheKey(imageUrl)
                        .diskCacheKey(imageUrl)/*
                        .placeholder(ColorDrawable(R.color.fuego))
                        .error(placeholder)
                        .fallback(placeholder)*/
                        .diskCachePolicy(CachePolicy.DISABLED)
                        .memoryCachePolicy(CachePolicy.DISABLED)
                        .build()

                    // se carga el request en el AsyncImage
                    AsyncImage(
                        model = imageRequest,
                        contentDescription = "avatar de usuario",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.8f)
                            .clip(CircleShape)
                    )
                }
                //fin mierda para que se muestre bien el avatar actualizado
            }

            Spacer(modifier = Modifier.weight(0.05f))
            Column(//Column Datos
                modifier = Modifier
                    .fillMaxHeight()
                    .background(
                        colorResource(R.color.white),
                        RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp)
                    )
                    .weight(0.65f)
                    .padding(vertical = 5.dp)
                    .clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)),
                horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
            ){
                Column(
                    modifier = Modifier
                        .weight(0.5f)
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
                            text = usuario.nick,
                            color = Color.Black,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold)
                        Text(modifier = Modifier
                            .padding(start = 10.dp)
                            .weight(0.7f)
                            .wrapContentWidth(),
                            text = usuario.email,
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold)
                    }
                    Button(modifier = Modifier
                        //.fillMaxHeight(0.5f)
                        .wrapContentWidth()
                        .weight(0.3f)
                        .padding(10.dp),
                        colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                            containerColor = colorResource(R.color.hielo),
                            contentColor = colorResource(R.color.white)
                        ),
                        shape = RoundedCornerShape(10.dp),
                        onClick = {
                            mostrar = "Editar"
                        }
                    ) {
                        Text("Editar")
                    }
                }


            }
        }
        Row(//Row de opciones
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    colorResource(R.color.white),
                    RoundedCornerShape(topStart = 8.dp)
                )
                .constrainAs(opciones) {
                    top.linkTo(avatar.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
                .fillMaxSize(0.8f)
                .padding(15.dp)
        ){
            when(mostrar){//lo que muestra dependiendo de la opción
                "Editar" -> {
                    ConstraintLayout(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(colorResource(R.color.white))
                            .fillMaxSize()
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
                                    .background(Color.White)
                                    .fillMaxWidth(),
                                value = nick,
                                onValueChange = { nick = it },
                                label = { Text("Nombre de usuario") }
                            )
                            Spacer(modifier = Modifier.height(20.dp))
                            OutlinedTextField(
                                modifier = Modifier
                                    .background(Color.White)
                                    .fillMaxWidth(),
                                value = email,
                                onValueChange = { email = it },
                                label = { Text("Correo electrónico") }
                            )
                            Spacer(modifier = Modifier.height(20.dp))
                            OutlinedTextField(
                                value = password,
                                modifier = Modifier
                                    .background(Color.White)
                                    .fillMaxWidth(),
                                onValueChange = { password = it },
                                label = { Text("Contraseña") },
                                visualTransformation = PasswordVisualTransformation()
                            )
                            Spacer(modifier = Modifier.height(20.dp))


                            Button(
                                modifier = Modifier
                                    .padding(vertical = 8.dp),
                                onClick = { launcher.launch("image/*") },
                                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                    containerColor = colorResource(R.color.hielo),
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
                                    containerColor = colorResource(R.color.hielo),
                                    contentColor = colorResource(R.color.white)
                                ),
                                shape = RoundedCornerShape(10.dp),
                                onClick = {
                                        val usuarioCambios = UserFb(//objeto aux con los cambios
                                            nick,
                                            email,
                                            password,
                                            avatarLink,
                                            usuario.key.toString()
                                        )
                                        //referencia a Firebase
                                        //appwrite para el avater
                                        val identificadorAppWrite = usuario.key.toString().substring(1, 20) ?: "" // coge el identificador
                                        val inputStream = context.contentResolver.openInputStream(selectedImageUri!!)
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
                                                        storage.deleteFile(
                                                            bucketId = "6738855e0002d76f1141",
                                                            fileId = identificadorAppWrite
                                                        )
                                                        delay(500)
                                                        storage.createFile(
                                                            bucketId = "6738855e0002d76f1141",
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
                                                    //relanzamos la activity
                                                    edicion=true
                                                    recreate(context as Activity)
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
                                    containerColor = colorResource(R.color.hielo),
                                    contentColor = colorResource(R.color.white)
                                ),
                                shape = RoundedCornerShape(10.dp),
                                onClick = {
                                    mostrar=""
                                })
                            {
                                Text("Cancela")
                            }
                        }
                    }

                }
                ""->{
                    Text(text = "DUMMY")
                }
            }

        }





    }

}
/*
@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    val usuario = UserFb("Nick","email@ejemplo.com","******","https://cloud.appwrite.io/v1/storage/buckets/6738855e0002d76f1141/files/OC-RhiaNiRTlU0Qc7tr/view?project=6738854a0011e2bc643f&project=6738854a0011e2bc643f&mode=admin")
    PerfilUser(usuario)
}*/