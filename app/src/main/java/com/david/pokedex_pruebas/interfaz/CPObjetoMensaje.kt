package com.david.pokedex_pruebas.interfaz

import android.content.Context
import android.content.Intent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.david.pokedex_pruebas.R
import com.david.pokedex_pruebas.interfaz.ui.theme.Pokedex_pruebasTheme
import com.david.pokedex_pruebas.modelo.MensajeFB
import com.david.pokedex_pruebas.modelo.UsuarioFromKey
import com.google.firebase.database.FirebaseDatabase
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.height
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.width
import androidx.core.content.ContextCompat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun Mensaje(mensaje:MensajeFB, color:Color){
    //vamos a acotar la fecha del mensaje si es de hoy
    //fecha hoy
    val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm:ss",
        Locale.getDefault())
    val hoy = dateFormat.format(Date())
    //se comparan las fechas
    var fecha_mensaje_muestra=""

    var hoy_sin_hora=hoy.substring(0,10)
    var mensaje_sin_hora=mensaje.fecha.substring(0,10)
    if(hoy_sin_hora==mensaje_sin_hora){
        fecha_mensaje_muestra=mensaje.fecha.substring(11,16)
    }else{
        fecha_mensaje_muestra=mensaje.fecha.substring(11,19)
    }

    Column(
        modifier = Modifier
            .wrapContentWidth()
            .fillMaxHeight()
            .background(color, RoundedCornerShape(4.dp))
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .wrapContentHeight()
        ) {
            Text(text = mensaje.texto, color = Color.White)
        }
        Spacer(modifier = Modifier.height(4.dp))
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                text = fecha_mensaje_muestra,
                color = Color.White,
                fontSize = 8.sp
            )
        }
    }
}
