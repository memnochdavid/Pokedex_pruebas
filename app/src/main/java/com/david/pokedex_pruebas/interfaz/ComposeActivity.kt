package com.david.pokedex_pruebas.interfaz

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.david.pokedex_pruebas.R
//https://developer.android.com/develop/ui/compose/mental-model?hl=es-419
class ComposeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            saludo("David")
        }
    }
}

@Composable
fun saludo(name: String) {
    Text("Hola $name!")
}
@Composable
fun insertaImagen(draw: Drawable){

}


@Preview(showBackground = true, widthDp = 200, heightDp = 200)
@Composable
fun GreetingPreview2() {
    Text("Hola polla!")
}