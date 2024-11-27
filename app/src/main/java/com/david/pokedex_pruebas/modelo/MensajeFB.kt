package com.david.pokedex_pruebas.modelo


import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import com.david.pokedex_pruebas.interfaz.ComposeListaActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

 class MensajeFB
    //var leido:Boolean
:Serializable{
     var idUser:String
     var fecha: String
     var texto:String

     constructor(idUser: String, fecha: String, texto: String){
         this.idUser=idUser
         this.fecha=fecha
         this.texto=texto
     }

    constructor():this("","", "")
    init{
        val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm:ss",
            Locale.getDefault())
        fecha = dateFormat.format(Date())
    }
}

class ConversacionFB:Serializable{

    var idChat:String
    var idUser:String
    var mensajes:MutableList<MensajeFB>
    constructor():this("","", mutableListOf<MensajeFB>())

    constructor(
        idChat:String="",
        idUser: String="",
        mensajes: MutableList<MensajeFB> = mutableListOf<MensajeFB>()){
        this.idUser=idUser
        this.idChat=idChat
        this.mensajes=mensajes
    }
    init{
        val refBBDD= FirebaseDatabase.getInstance().getReference()
        idChat=refBBDD.child("chats").push().key!!
    }
}


fun cargaChats(refBBDD: DatabaseReference, idUser: String, callback: (ConversacionFB?) -> Unit) {
        val idChat = refBBDD.child("chats").push().key!!
        val conversacionFB = ConversacionFB(idChat, idUser)

        refBBDD.child("chats").addListenerForSingleValueEvent( object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (chatSnapshot in snapshot.children) {
                    val chat = chatSnapshot.getValue(ConversacionFB::class.java)
                    Log.d("TAG2", "cargaChats: ${chat?.idChat}")
                    if (chat != null && chat.idUser == idUser) {
                        conversacionFB.mensajes.addAll(chat.mensajes)
                        break
                    }
                }

                callback(conversacionFB)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("TAG2", "cargaChats: ${error.message}")
            }

        })
        //Log.d("TAG1", "cargaChats: ${snapshot.value}")



}

































/*

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

*/