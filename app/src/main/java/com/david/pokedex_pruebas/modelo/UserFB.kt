package com.david.pokedex_pruebas.modelo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
data class UserFb(
    var id: String="",
    var imagenFB: String? = null,
    var nick: String="",
    var desc: String="",
    var admin: Boolean,
    var denunciado: Boolean,
    var detallesDenuncia: String? = null
): Serializable, Parcelable {
    constructor(
        id: String,
        nick: String,
        desc: String
    ) : this(id, null, nick, desc, false,false,null)
}
