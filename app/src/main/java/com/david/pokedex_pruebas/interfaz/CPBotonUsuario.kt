package com.david.pokedex_pruebas.interfaz

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ErrorResult
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.david.pokedex_pruebas.R
import com.david.pokedex_pruebas.modelo.UserFb
import com.david.pokedex_pruebas.modelo.UsuarioFromKey
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.Dispatchers

//private lateinit var refBBDD: DatabaseReference
@Composable
fun UserButton(context: Context){
    //refBBDD = FirebaseDatabase.getInstance().reference

    val sesion= UsuarioFromKey( usuario_key, refBBDD)

    IconButton(
        onClick = {//para abrir el activity perfil de usuario

            val intent = Intent(context, ComposePerfilUsuarioActivity::class.java)
            intent.putExtra("sesion", sesion.key)
            context.startActivity(intent)

        },
        modifier = Modifier
            .size(90.dp)
            .padding(10.dp)
    ) {

        Surface(modifier = Modifier.fillMaxSize()) {

            val placeholder = R.drawable.placeholder
            val imageUrl = sesion.avatar

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
                .diskCacheKey(imageUrl)
                .placeholder(placeholder)
                .error(placeholder)
                .fallback(placeholder)
                .diskCachePolicy(CachePolicy.DISABLED)
                .memoryCachePolicy(CachePolicy.DISABLED)
                .build()

            // Load and display the image with AsyncImage
            AsyncImage(
                model = imageRequest,
                contentDescription = "Image Description",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape)
                    .background(colorResource(R.color.fuego))
            )

/*
        AsyncImage(
            model = sesion.avatar,
            contentDescription = "avatar de usuario",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape)
                .background(colorResource(R.color.fuego))
        )*/
        }
    }
}

