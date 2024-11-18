package com.david.pokedex_pruebas.interfaz

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.david.pokedex_pruebas.R
import com.david.pokedex_pruebas.interfaz.ui.theme.Pokedex_pruebasTheme
import com.david.pokedex_pruebas.modelo.PokemonFB
import com.david.pokedex_pruebas.modelo.UserFb
import com.david.pokedex_pruebas.modelo.enumToColorFB
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import io.appwrite.Client
import io.appwrite.models.InputFile
import io.appwrite.services.Storage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import kotlin.io.path.createFile
import kotlinx.coroutines.flow.collect

//para firebase
private lateinit var refBBDD: DatabaseReference
private lateinit var identificador: String
private lateinit var urlImagen: Uri
lateinit var scopeUser: CoroutineScope

class ComposeCreaUser : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            scopeUser = rememberCoroutineScope()
            FormNewUser(scopeUser)
        }
    }
}


@Composable
fun FormNewUser(scopeUser: CoroutineScope) {
    lateinit var newUser :UserFb
    val context = LocalContext.current


    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 0.dp)
            .background(colorResource(R.color.fuego))
    ) {
        var objetoCreado by remember { mutableStateOf(false) }
        var username by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var newUserAvatar by remember { mutableStateOf("") }
        var selectedImageUri by remember { mutableStateOf<Uri?>(null) }
        val launcher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.GetContent(),
            onResult = { uri: Uri? ->
                selectedImageUri = uri
            }
        )
        //var arraySesion=ArrayList<UserFb>()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .background(Color.White),
                value = username,
                onValueChange = { username = it },
                label = { Text("Nombre de usuario") }
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                modifier = Modifier
                    .background(Color.White),
                value = email,
                onValueChange = { email = it },
                label = { Text("Correo electrónico") }
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = password,
                modifier = Modifier
                    .background(Color.White),
                onValueChange = { password = it },
                label = { Text("Contraseña") },
                visualTransformation = PasswordVisualTransformation()
            )
            Spacer(modifier = Modifier.height(8.dp))


            Button(onClick = { launcher.launch("image/*") }) {
                Text("Seleccionar foto de perfil")
            }



            Spacer(modifier = Modifier.height(8.dp))



            Button(onClick = {
                if (username.isNotEmpty() || email.isNotEmpty() || password.isNotEmpty() || selectedImageUri != null) {
                    refBBDD = FirebaseDatabase.getInstance().reference
                    identificador = refBBDD.child("usuarios").push().key!!
                    val identificadorAppWrite = identificador.substring(1, 20) ?: "" // coge el identificador
                    val inputStream = context.contentResolver.openInputStream(selectedImageUri!!)
                    if (inputStream != null) {

                        scopeUser.launch {
                            try{
                                val file = inputStream.use { input ->
                                    val tempFile = kotlin.io.path.createTempFile().toFile()
                                    tempFile.outputStream().use { output ->
                                        input.copyTo(output)
                                    }
                                    InputFile.fromFile(tempFile) // Use fromFile method
                                }
                                withContext(Dispatchers.IO) {
                                    storage.createFile(
                                        bucketId = "6738855e0002d76f1141",
                                        fileId = identificadorAppWrite,
                                        file = file
                                    )
                                }
                                newUserAvatar = "https://cloud.appwrite.io/v1/storage/buckets/6738855e0002d76f1141/files/$identificadorAppWrite/preview?project=6738854a0011e2bc643f"
                                newUser = UserFb(username,email,password,newUserAvatar)
                                refBBDD.child("usuarios").child(identificador).setValue(newUser)

                            }catch (e: Exception){
                                Log.e("UploadError", "Failed to upload image: ${e.message}")
                            }
                            finally {
                                Toast.makeText(context, "Usuario $username creado con éxito", Toast.LENGTH_SHORT).show()
                            }
                            withContext(Dispatchers.Main) { // Update on main thread
                                objetoCreado = true
                            }
                        }
                    }





                }else{
                    Toast.makeText(context, "Rellena todos los campos y elige una imagen", Toast.LENGTH_SHORT).show()
                }
            }) {
                Text("Crear usuario")
            }



            if (selectedImageUri != null) {
                AsyncImage(
                    model = selectedImageUri,
                    contentDescription = "Selected image",
                    modifier = Modifier.size(100.dp)
                )
            }

            if (objetoCreado) {

                Text("El usuario se ha creado: ${newUser.nick}")

                //arraySesion.add(newUser)//debe ser un array para el intent
                //pasar a la siguiente pantalla con los datos de la sesión

                val intent = Intent(context, ComposeLoginActivity::class.java)
                //intent.putParcelableArrayListExtra("sesion", arraySesion)
                context.startActivity(intent)

                AsyncImage(
                    model = newUserAvatar,
                    contentDescription = "Selected image",
                    modifier = Modifier.size(100.dp)
                )


            }

        }
    }
}

/*
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FormNewUser(null)
}*/