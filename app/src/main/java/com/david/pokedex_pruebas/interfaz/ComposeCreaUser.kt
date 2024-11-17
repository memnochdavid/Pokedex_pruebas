package com.david.pokedex_pruebas.interfaz

import android.graphics.Bitmap
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.david.pokedex_pruebas.R
import com.david.pokedex_pruebas.interfaz.ui.theme.Pokedex_pruebasTheme
import com.david.pokedex_pruebas.modelo.PokemonFB
import com.david.pokedex_pruebas.modelo.enumToColorFB
import com.google.firebase.database.DatabaseReference
import io.appwrite.Client
import io.appwrite.services.Storage

//para firebase
private lateinit var refBBDD: DatabaseReference
private lateinit var identificador: String


class ComposeCreaUser : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FormNewUser()
        }
    }
}


@Composable
fun FormNewUser() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 0.dp)
            .background(colorResource(R.color.fuego))
    ) {
        var username by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var profilePicture by remember { mutableStateOf<Bitmap?>(null) }

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

            // Para la foto de perfil, puedes usar un Image composable y un botón para seleccionar una imagen.
            // Aquí hay un ejemplo simple:
            if (profilePicture != null) {
                Image(
                    bitmap = profilePicture!!.asImageBitmap(),
                    contentDescription = "Foto de perfil",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                )
            } else {
                // Mostrar un icono o un marcador de posición si no hay una foto de perfil
            }
            Button(onClick = {

            }) {
                Text("Seleccionar foto de perfil")
            }
            Button(onClick = {
                // Lógica para seleccionar una imagen de la galería o la cámara
            }) {
                Text("Confirmar Datos")
            }
        }
    }


}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FormNewUser()
}