package com.david.pokedex_pruebas.interfaz

import android.content.Intent
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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.david.pokedex_pruebas.R
import com.david.pokedex_pruebas.interfaz.ui.theme.Pokedex_pruebasTheme
import com.david.pokedex_pruebas.modelo.PokemonFB
import com.david.pokedex_pruebas.modelo.UserFb
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import io.appwrite.models.InputFile
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

private lateinit var refBBDD: DatabaseReference
private lateinit var sesionUser: ArrayList<UserFb>

class ComposeLoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        if (intent.hasExtra("sesion")) {
            sesionUser = intent.getParcelableArrayListExtra("sesion")!!
        }else{
            sesionUser = arrayListOf()
        }
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Login()
        }
    }
}

@Composable
fun Login() {
    var email by remember { mutableStateOf(if (sesionUser.isNullOrEmpty()) "" else sesionUser[0].email) }
    var password by remember { mutableStateOf(if (sesionUser.isNullOrEmpty()) "" else sesionUser[0].pass) }
//    var mailVacio by remember { mutableStateOf(true) }
//    var passVacio by remember { mutableStateOf(true) }
    var loginExiste by remember { mutableStateOf(false) }
    val context = LocalContext.current
    var arraySesion=ArrayList<UserFb>()

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 0.dp)
            .background(colorResource(R.color.fuego))

    ) {
        val (col1, col2)=createRefs()
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .constrainAs(col1){
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(col2.top)
                }
                .fillMaxHeight(0.5f)
        ){}
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .constrainAs(col2){
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
                value = email,
                onValueChange = { email = it },
                label = { Text("Correo electrónico") }
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth(),
                value = password,
                onValueChange = { password = it },
                label = { Text("Contraseña") },
                visualTransformation = PasswordVisualTransformation()
            )
            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {

                refBBDD = FirebaseDatabase.getInstance().reference
                if (email.isNotEmpty() && password.isNotEmpty()) {
                    refBBDD.child("usuarios")
                        .addValueEventListener(object : ValueEventListener {
                            override fun onDataChange(snapshot: DataSnapshot) {
                                loginExiste = false
                                for (pojo in snapshot.children) {
                                    val checkUser = pojo.getValue(UserFb::class.java)
                                    if (email == checkUser?.email && password == checkUser?.pass) {
                                        loginExiste = true
                                        arraySesion.add(checkUser)
                                        Toast.makeText(context, "Login correcto", Toast.LENGTH_SHORT).show()
                                        val intent = Intent(context, ComposeListaActivity::class.java)
                                        intent.putParcelableArrayListExtra("sesion", arraySesion)
                                        context.startActivity(intent)
                                        break
                                    }
                                }
                                if (!loginExiste) {
                                    Toast.makeText(context, "Usuario o Contraseña incorrectos", Toast.LENGTH_SHORT).show()
                                }
                            }
                            override fun onCancelled(error: DatabaseError) {
                                Toast.makeText(context, "Error en la conexión", Toast.LENGTH_SHORT).show()
                            }
                        })
                } else {
                    Toast.makeText(context, "Rellena todos los campos", Toast.LENGTH_SHORT).show()
                }
            }) {
                Text("Login")
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text="¿No tienes cuenta? ¡Regístrate!",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = {
                val intent = Intent(context, ComposeCreaUser::class.java)
                context.startActivity(intent)
            }) {
                Text("Crear cuenta")
            }
        }
    }




}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    Login()
}