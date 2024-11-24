package com.david.pokedex_pruebas.interfaz

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.test.bottom
import androidx.compose.ui.test.top
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import coil.compose.AsyncImage
import com.david.pokedex_pruebas.R
import com.david.pokedex_pruebas.interfaz.ui.theme.ui.theme.Pokedex_pruebasTheme
import com.david.pokedex_pruebas.modelo.enumToColorFB
import kotlinx.coroutines.NonDisposableHandle.parent
import kotlinx.coroutines.delay
import java.lang.reflect.Modifier
import androidx.compose.ui.res.painterResource

@SuppressLint("CustomSplashScreen")
class ComposeSplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            setContent{
                Splash(3,R.drawable.pokeball_splash,R.drawable.logo,this@ComposeSplashActivity)
            }
        }
    }
}

@Composable
fun Splash(tiempo: Int, draw1: Int, draw2:Int, context: Context) {

    LaunchedEffect(key1 = true) {
        delay(tiempo.toLong() * 1000)
        context.startActivity(Intent(context, ComposeListaActivity::class.java))
        (context as Activity).finish()
    }
    Box(
        modifier = androidx.compose.ui.Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.black))
    ) {

        ConstraintLayout(
            modifier = androidx.compose.ui.Modifier
                .fillMaxSize()
                .padding(top = 0.dp)
        ) {
            val(logo, pokeball)= createRefs()
            val gifLogo = painterResource(id = R.drawable.logo)
            val gifPokeball = painterResource(id = R.drawable.pokeball_splash)

            Image(
                painter = gifLogo,
                contentDescription = null,
                modifier = androidx.compose.ui. Modifier
                    .size(350.dp)
                    .fillMaxWidth()
                    .constrainAs(logo) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(pokeball.top)
                    }
            )
            Image(
                painter = gifPokeball,
                contentDescription = null,
                modifier = androidx.compose.ui. Modifier
                    .size(350.dp)
                    .fillMaxWidth()
                    .constrainAs(pokeball) {
                        top.linkTo(logo.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.top)
                    }
            )
        }
    }
}


/*

@Preview(showBackground = true,widthDp = 350, heightDp = 600)
@Composable
fun GreetingPreview9() {
    Splash(3,R.drawable.pokeball_splash,R.drawable.logo)
}*/