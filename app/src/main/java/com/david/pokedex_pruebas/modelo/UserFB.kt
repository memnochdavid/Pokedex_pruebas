package com.david.pokedex_pruebas.modelo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
data class UserFb(
    var nick: String="",
    var email: String="",
    var pass: String="",
    var avatar: String? = null,
    var key: String? = null,
    var equipo: MutableList<PokemonFB>?=null,
    var admin: Boolean=false,
    var denunciado: Boolean=false,
    var detallesDenuncia: String? = null,
): Serializable, Parcelable{

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
