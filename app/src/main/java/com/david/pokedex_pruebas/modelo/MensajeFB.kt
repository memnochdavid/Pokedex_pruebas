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
import com.google.firebase.database.GenericTypeIndicator
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine
/*
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
*/
data class MensajeFB(
    var idUser:String,
    var idReceptor:String,
    var fecha: String,
    var texto:String
    //var leido:Boolean
):Serializable{
    init{
        val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm:ss",
            Locale.getDefault())
        fecha = dateFormat.format(Date())
    }
    constructor():this("","","", "")
}

data class ConversacionFB(
    var idChat:String,
    var idUser:String,
    var idReceptor:String,
    var mensajes:MutableList<MensajeFB>
):Serializable{
    init{
        val refBBDD= FirebaseDatabase.getInstance().getReference()
        idChat=refBBDD.child("chats").push().key!!
    }
    constructor():this("","", "",mutableListOf<MensajeFB>())
}


suspend fun cargaChats(refBBDD: DatabaseReference, idUser: String, idReceptor: String): ConversacionFB? {
    return suspendCoroutine { continuation ->
        refBBDD.child("chats").get().addOnSuccessListener { snapshot ->
            var conversacionFB: ConversacionFB? = null
            for (chatSnapshot in snapshot.children) {
                val chat = chatSnapshot.getValue(ConversacionFB::class.java)
                if (chat != null && (chat.idUser == idUser || chat.idReceptor == idUser)) {
                    conversacionFB = chat
                    conversacionFB.idChat = chatSnapshot.key!!
                    break
                }
            }
            if(conversacionFB==null){
                conversacionFB=ConversacionFB("",idUser, idReceptor, mutableListOf<MensajeFB>())
            }
            continuation.resume(conversacionFB)
        }.addOnFailureListener { exception ->
            continuation.resumeWithException(exception)
        }
    }
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