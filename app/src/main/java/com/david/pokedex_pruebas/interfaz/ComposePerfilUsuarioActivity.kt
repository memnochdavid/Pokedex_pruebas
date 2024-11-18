package com.david.pokedex_pruebas.interfaz

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.david.pokedex_pruebas.R
import com.david.pokedex_pruebas.interfaz.ui.theme.Pokedex_pruebasTheme
import com.david.pokedex_pruebas.modelo.UserFb

class ComposePerfilUsuarioActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sesion = intent.getParcelableArrayListExtra<UserFb>("sesion" ) as List<UserFb>
        setContent {
            PerfilUser(sesion[0])
        }
    }
}



@Composable
fun PerfilUser(usuario: UserFb) {
    ConstraintLayout(//parent
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.lista_con_foco))
            .padding(15.dp)
    ) {
        val (avatar, opciones) = createRefs()
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
                    .weight(0.3f),
                verticalArrangement = Arrangement.Center
            ){
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
            }
            Spacer(modifier = Modifier.weight(0.05f))
            Column(//Column Datos
                modifier = Modifier
                    .fillMaxHeight()
                    .background(colorResource(R.color.white),
                        RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
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
                            //TODO

                        }) {
                        Text("Editar")
                    }
                }


            }
        }
        Row(//Row de opciones
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(R.color.white),
                    RoundedCornerShape(topStart = 8.dp))
                .constrainAs(opciones) {
                    top.linkTo(avatar.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
                .fillMaxSize(0.8f)
                .padding(15.dp)
        ){
            Text(text = "DUMMY")

        }





    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    val usuario = UserFb("Nick","email@ejemplo.com","******","https://cloud.appwrite.io/v1/storage/buckets/6738855e0002d76f1141/files/OC-RhiaNiRTlU0Qc7tr/view?project=6738854a0011e2bc643f&project=6738854a0011e2bc643f&mode=admin")
    PerfilUser(usuario)
}