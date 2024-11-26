package com.david.pokedex_pruebas.old

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.david.pokedex_pruebas.R
import com.bumptech.glide.Glide
import com.david.pokedex_pruebas.interfaz.ComposeLoginActivity


@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vista_splash) // Si tienes un layout para el splash screen

        var pokeball_splash=findViewById<ImageView>(R.id.pokeball_splash)
        Glide.with(this)
            .asGif()
            .load(R.drawable.pokeball_splash)
            .fitCenter()
            .into(pokeball_splash)
        var poke_logo=findViewById<ImageView>(R.id.poke_logo)

        Glide.with(this)
            .asGif()
            .load(R.drawable.logo)
            .fitCenter()
            .into(poke_logo)


        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, ComposeLoginActivity::class.java))
            finish() // Cierra la activity del splash screen
        }, 1) // CAMBIAAARRRR
    }
}