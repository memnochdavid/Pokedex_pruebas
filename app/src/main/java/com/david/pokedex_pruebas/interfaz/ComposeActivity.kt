package com.david.pokedex_pruebas.interfaz

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.david.pokedex_pruebas.R
//https://developer.android.com/develop/ui/compose/mental-model?hl=es-419
class ComposeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Row(Modifier
                .background(colorResource(R.color.fuego))
                .fillMaxSize()
                .padding(8.dp)){
                insertaImagen(R.drawable.charizard01)
            }
            Row{
                saludo("Charizard")
            }
        }
    }
}

@Composable
fun saludo(name: String) {
    Text("Hola $name!")
}
@Composable
fun insertaImagen(draw: Int){
    Image(painter = painterResource(draw),"", alignment = Alignment.Center, contentScale = ContentScale.Fit)
}


@Preview(widthDp = 200, heightDp = 200)
@Composable
fun setContent() {
    Row(Modifier
        .background(colorResource(R.color.fuego))
        .fillMaxSize()
        .padding(8.dp)){
        insertaImagen(R.drawable.charizard01)
    }
    Row{
        saludo("Charizard")
    }
}