package com.david.pokedex_pruebas.modelo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
data class UserFb(
    var nick: String="",
    var email: String="",
    var pass: String="",
    var imagenFB: String? = null,
    var admin: Boolean=false,
    var denunciado: Boolean=false,
    var detallesDenuncia: String? = null
): Serializable, Parcelable