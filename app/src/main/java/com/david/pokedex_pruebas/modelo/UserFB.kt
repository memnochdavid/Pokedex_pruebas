package com.david.pokedex_pruebas.modelo

import android.os.Parcelable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.get
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.GenericTypeIndicator
import kotlinx.android.parcel.Parcelize
import java.io.Serializable
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

//@Parcelize
data class UserFb(
    var nick: String="",
    var email: String="",
    var pass: String="",
    var avatar: String? = null,
    var key: String? = null,
    var equipo: MutableList<PokemonFB> =mutableListOf<PokemonFB>(),
    var admin: Boolean=false,
    var denunciado: Boolean=false,
    var detallesDenuncia: String? = null,
): Serializable {//), Parcelable{

    override fun toString(): String {
        return "UserFb(nick='$nick'\n, email='$email'\n, pass='$pass'\n, avatar='$avatar'\n,equipo='$equipo'\n, admin=$admin\n, denunciado=$denunciado\n, detallesDenuncia='$detallesDenuncia'\n)"
    }
}

fun addPokemon(user: UserFb, pokemon: PokemonFB): UserFb{
    if(user.equipo==null){
        user.equipo?.plusAssign(pokemon)
    }else if(user.equipo!!.size<6){
        user.equipo?.plusAssign(pokemon)
    }
    return user
}

@Composable
fun UsuarioFromKey(usuario_key: String, refBBDD: DatabaseReference): UserFb {
    val usuarioState = remember { mutableStateOf<UserFb?>(null) }

    LaunchedEffect(usuario_key) {
        usuarioState.value = fetchUserData(usuario_key, refBBDD)
    }

    return usuarioState.value ?: UserFb() // Return default UserFb if null
}

suspend fun fetchUserData(usuario_key: String, refBBDD: DatabaseReference): UserFb {
    return suspendCoroutine { continuation ->
        refBBDD.child("usuarios").child(usuario_key).get().addOnSuccessListener { snapshot ->
            val equipo = snapshot.child("equipo").getValue(object : GenericTypeIndicator<MutableList<PokemonFB>>() {})
                ?: mutableListOf()
            val user = UserFb(
                nick = snapshot.child("nick").value.toString(),
                email = snapshot.child("email").value.toString(),
                pass = snapshot.child("pass").value.toString(),
                avatar = snapshot.child("avatar").value.toString(),
                key = snapshot.child("key").value.toString(),
                equipo = equipo
            )
            continuation.resume(user)
        }.addOnFailureListener { exception ->
            continuation.resumeWithException(exception)
        }
    }
}