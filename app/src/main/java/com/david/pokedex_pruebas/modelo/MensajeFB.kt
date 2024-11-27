package com.david.pokedex_pruebas.modelo


import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class MensajeFB(
    var emisor:UserFb,
    var receptor:UserFb,
    var fecha: String,
    var texto:String,
    //var leido:Boolean
):Serializable{
    init{
        val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm:ss",
            Locale.getDefault())
        fecha = dateFormat.format(Date())
    }
}

data class ConversacionFB(
    var emisor:UserFb,
    var receptor:UserFb,
    var mensajes:MutableList<MensajeFB>
):Serializable