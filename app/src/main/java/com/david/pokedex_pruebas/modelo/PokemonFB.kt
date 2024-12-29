package com.david.pokedex_pruebas.modelo


import android.os.Parcelable
import android.util.Log
import com.david.pokedex_pruebas.R
import kotlinx.android.parcel.Parcelize
import java.io.Serializable
import kotlin.text.replace

@Parcelize
data class PokemonFB(
    var num:Int=0,
    var gen: String="",
    var foto:Int=0,//soporte local
    var imagenFB: String? = null,//soporte en la nube
    var name: String="",
    var desc: String="",
    var tipo: List<PokemonTipoFB> = listOf(),
    var evos: List<Int> = listOf(),
    var key: String? = null,
    var stability:Int=0
):Serializable, Parcelable{
    constructor(
        num: Int,
        gen: String,
        foto: Int,
        name: String,
        desc: String,
        tipo: List<PokemonTipoFB>,
        evos: List<Int>,

    ) : this(num, gen, foto, null, name, desc, tipo, evos)
}

@Parcelize
data class UnonwnFormas(
    var name:String="",
    var foto:Int=0,
    var imagenFB: String? = null,//soporte en la nube
    var key: String? = null,
    var stability:Int=0
):Serializable, Parcelable{
    constructor(
        name: String,
        foto: Int,
    ) : this(name, foto, null)
}

enum class PokemonTipoFB(val tag: String) {
    PLANTA("planta"),
    AGUA("agua"),
    FUEGO("fuego"),
    LUCHA("lucha"),
    VENENO("veneno"),
    ACERO("acero"),
    BICHO("bicho"),
    DRAGON("dragon"),
    ELECTRICO("electrico"),
    HADA("hada"),
    HIELO("hielo"),
    PSIQUICO("psiquico"),
    ROCA("roca"),
    TIERRA("tierra"),
    SINIESTRO("siniestro"),
    NORMAL("normal"),
    VOLADOR("volador"),
    FANTASMA("fantasma"),
    NULL("null");
}

fun enumToDrawableFB(tipo:PokemonTipoFB):Int{
    return when(tipo){
        PokemonTipoFB.PLANTA -> R.drawable.planta
        PokemonTipoFB.AGUA -> R.drawable.agua
        PokemonTipoFB.FUEGO -> R.drawable.fuego
        PokemonTipoFB.LUCHA -> R.drawable.lucha
        PokemonTipoFB.VENENO -> R.drawable.veneno
        PokemonTipoFB.ACERO -> R.drawable.acero
        PokemonTipoFB.BICHO -> R.drawable.bicho
        PokemonTipoFB.DRAGON -> R.drawable.dragon
        PokemonTipoFB.ELECTRICO -> R.drawable.electrico
        PokemonTipoFB.HADA -> R.drawable.hada
        PokemonTipoFB.HIELO -> R.drawable.hielo
        PokemonTipoFB.PSIQUICO -> R.drawable.psiquico
        PokemonTipoFB.ROCA -> R.drawable.roca
        PokemonTipoFB.TIERRA -> R.drawable.tierra
        PokemonTipoFB.SINIESTRO -> R.drawable.siniestro
        PokemonTipoFB.NORMAL -> R.drawable.normal
        PokemonTipoFB.VOLADOR -> R.drawable.volador
        PokemonTipoFB.FANTASMA -> R.drawable.fantasma
        else -> { R.drawable.charmander}
    }
}
fun enumToDrawable2FB(tipo:PokemonTipoFB):Int{
    return when(tipo){
        PokemonTipoFB.PLANTA -> R.drawable.planta2
        PokemonTipoFB.AGUA -> R.drawable.agua2
        PokemonTipoFB.FUEGO -> R.drawable.fuego2
        PokemonTipoFB.LUCHA -> R.drawable.lucha2
        PokemonTipoFB.VENENO -> R.drawable.veneno2
        PokemonTipoFB.ACERO -> R.drawable.acero2
        PokemonTipoFB.BICHO -> R.drawable.bicho2
        PokemonTipoFB.DRAGON -> R.drawable.dragon2
        PokemonTipoFB.ELECTRICO -> R.drawable.electrico2
        PokemonTipoFB.HADA -> R.drawable.hada2
        PokemonTipoFB.HIELO -> R.drawable.hielo2
        PokemonTipoFB.PSIQUICO -> R.drawable.psiquico2
        PokemonTipoFB.ROCA -> R.drawable.roca2
        PokemonTipoFB.TIERRA -> R.drawable.tierra2
        PokemonTipoFB.SINIESTRO -> R.drawable.siniestro2
        PokemonTipoFB.NORMAL -> R.drawable.normal2
        PokemonTipoFB.VOLADOR -> R.drawable.volador2
        PokemonTipoFB.FANTASMA -> R.drawable.fantasma2
        else -> { R.drawable.charmander}
    }
}
fun enumToDrawableFB_busqueda(tipo:PokemonTipoFB):Int{
    return when(tipo){
        PokemonTipoFB.PLANTA -> R.drawable.planta2
        PokemonTipoFB.AGUA -> R.drawable.agua2
        PokemonTipoFB.FUEGO -> R.drawable.fuego2
        PokemonTipoFB.LUCHA -> R.drawable.lucha2
        PokemonTipoFB.VENENO -> R.drawable.veneno2
        PokemonTipoFB.ACERO -> R.drawable.acero2
        PokemonTipoFB.BICHO -> R.drawable.bicho2
        PokemonTipoFB.DRAGON -> R.drawable.dragon2
        PokemonTipoFB.ELECTRICO -> R.drawable.electrico2
        PokemonTipoFB.HADA -> R.drawable.hada2
        PokemonTipoFB.HIELO -> R.drawable.hielo2
        PokemonTipoFB.PSIQUICO -> R.drawable.psiquico2
        PokemonTipoFB.ROCA -> R.drawable.roca2
        PokemonTipoFB.TIERRA -> R.drawable.tierra2
        PokemonTipoFB.SINIESTRO -> R.drawable.siniestro2
        PokemonTipoFB.NORMAL -> R.drawable.normal2
        PokemonTipoFB.VOLADOR -> R.drawable.volador2
        PokemonTipoFB.FANTASMA -> R.drawable.fantasma2
        else -> { R.drawable.charmander}
    }
}
fun enumToColorFB(tipo:PokemonTipoFB):Int{
    return when(tipo){
        PokemonTipoFB.PLANTA -> R.color.planta
        PokemonTipoFB.AGUA -> R.color.agua
        PokemonTipoFB.FUEGO -> R.color.fuego
        PokemonTipoFB.LUCHA -> R.color.lucha
        PokemonTipoFB.VENENO -> R.color.veneno
        PokemonTipoFB.ACERO -> R.color.acero
        PokemonTipoFB.BICHO -> R.color.bicho
        PokemonTipoFB.DRAGON -> R.color.dragon
        PokemonTipoFB.ELECTRICO -> R.color.electrico
        PokemonTipoFB.HADA -> R.color.hada
        PokemonTipoFB.HIELO -> R.color.hielo
        PokemonTipoFB.PSIQUICO -> R.color.psiquico
        PokemonTipoFB.ROCA -> R.color.roca
        PokemonTipoFB.TIERRA -> R.color.tierra
        PokemonTipoFB.SINIESTRO -> R.color.siniestro
        PokemonTipoFB.NORMAL -> R.color.normal
        PokemonTipoFB.VOLADOR -> R.color.volador
        PokemonTipoFB.FANTASMA -> R.color.fantasma
        else -> { R.color.black}
    }
}
val efectividadFB = mapOf(
    Pair(PokemonTipoFB.PLANTA, PokemonTipoFB.AGUA) to "2",
    Pair(PokemonTipoFB.PLANTA, PokemonTipoFB.TIERRA) to "2",
    Pair(PokemonTipoFB.PLANTA, PokemonTipoFB.ROCA) to "2",
    Pair(PokemonTipoFB.PLANTA, PokemonTipoFB.ACERO) to "0.5",
    Pair(PokemonTipoFB.PLANTA, PokemonTipoFB.BICHO) to "0.5",
    Pair(PokemonTipoFB.PLANTA, PokemonTipoFB.DRAGON) to "0.5",
    Pair(PokemonTipoFB.PLANTA, PokemonTipoFB.FUEGO) to "0.5",
    Pair(PokemonTipoFB.PLANTA, PokemonTipoFB.PLANTA) to "0.5",
    Pair(PokemonTipoFB.PLANTA, PokemonTipoFB.VENENO) to "0.5",
    Pair(PokemonTipoFB.PLANTA, PokemonTipoFB.VOLADOR) to "0.5",
    Pair(PokemonTipoFB.AGUA, PokemonTipoFB.FUEGO) to "2",
    Pair(PokemonTipoFB.AGUA, PokemonTipoFB.TIERRA) to "2",
    Pair(PokemonTipoFB.AGUA, PokemonTipoFB.ROCA) to "2",
    Pair(PokemonTipoFB.AGUA, PokemonTipoFB.AGUA) to "0.5",
    Pair(PokemonTipoFB.AGUA, PokemonTipoFB.DRAGON) to "0.5",
    Pair(PokemonTipoFB.AGUA, PokemonTipoFB.PLANTA) to "0.5",
    Pair(PokemonTipoFB.FUEGO, PokemonTipoFB.PLANTA) to "2",
    Pair(PokemonTipoFB.FUEGO, PokemonTipoFB.BICHO) to "2",
    Pair(PokemonTipoFB.FUEGO, PokemonTipoFB.HIELO) to "2",
    Pair(PokemonTipoFB.FUEGO, PokemonTipoFB.ACERO) to "2",
    Pair(PokemonTipoFB.FUEGO, PokemonTipoFB.FUEGO) to "0.5",
    Pair(PokemonTipoFB.FUEGO, PokemonTipoFB.DRAGON) to "0.5",
    Pair(PokemonTipoFB.FUEGO, PokemonTipoFB.FUEGO) to "0.5",
    Pair(PokemonTipoFB.FUEGO, PokemonTipoFB.ROCA) to "0.5",
    Pair(PokemonTipoFB.FUEGO, PokemonTipoFB.TIERRA) to "0.5",
    Pair(PokemonTipoFB.LUCHA, PokemonTipoFB.NORMAL) to "2",
    Pair(PokemonTipoFB.LUCHA, PokemonTipoFB.SINIESTRO) to "2",
    Pair(PokemonTipoFB.LUCHA, PokemonTipoFB.ACERO) to "2",
    Pair(PokemonTipoFB.LUCHA, PokemonTipoFB.HIELO) to "2",
    Pair(PokemonTipoFB.LUCHA, PokemonTipoFB.ROCA) to "2",
    Pair(PokemonTipoFB.LUCHA, PokemonTipoFB.BICHO) to "0.5",
    Pair(PokemonTipoFB.LUCHA, PokemonTipoFB.HADA) to "0.5",
    Pair(PokemonTipoFB.LUCHA, PokemonTipoFB.PSIQUICO) to "0.5",
    Pair(PokemonTipoFB.LUCHA, PokemonTipoFB.VENENO) to "0.5",
    Pair(PokemonTipoFB.LUCHA, PokemonTipoFB.VOLADOR) to "0.5",
    Pair(PokemonTipoFB.LUCHA, PokemonTipoFB.FANTASMA) to "0",
    Pair(PokemonTipoFB.VENENO, PokemonTipoFB.HADA) to "2",
    Pair(PokemonTipoFB.VENENO, PokemonTipoFB.PLANTA) to "2",
    Pair(PokemonTipoFB.VENENO, PokemonTipoFB.FANTASMA) to "0.5",
    Pair(PokemonTipoFB.VENENO, PokemonTipoFB.ROCA) to "0.5",
    Pair(PokemonTipoFB.VENENO, PokemonTipoFB.TIERRA) to "0.5",
    Pair(PokemonTipoFB.VENENO, PokemonTipoFB.VENENO) to "0.5",
    Pair(PokemonTipoFB.VENENO, PokemonTipoFB.ACERO) to "0",
    Pair(PokemonTipoFB.ACERO, PokemonTipoFB.HADA) to "2",
    Pair(PokemonTipoFB.ACERO, PokemonTipoFB.HIELO) to "2",
    Pair(PokemonTipoFB.ACERO, PokemonTipoFB.ROCA) to "2",
    Pair(PokemonTipoFB.ACERO, PokemonTipoFB.ACERO) to "0.5",
    Pair(PokemonTipoFB.ACERO, PokemonTipoFB.AGUA) to "0.5",
    Pair(PokemonTipoFB.ACERO, PokemonTipoFB.ELECTRICO) to "0.5",
    Pair(PokemonTipoFB.ACERO, PokemonTipoFB.FUEGO) to "0.5",
    Pair(PokemonTipoFB.BICHO, PokemonTipoFB.PLANTA) to "2",
    Pair(PokemonTipoFB.BICHO, PokemonTipoFB.PSIQUICO) to "2",
    Pair(PokemonTipoFB.BICHO, PokemonTipoFB.SINIESTRO) to "2",
    Pair(PokemonTipoFB.BICHO, PokemonTipoFB.ACERO) to "0.5",
    Pair(PokemonTipoFB.BICHO, PokemonTipoFB.FANTASMA) to "0.5",
    Pair(PokemonTipoFB.BICHO, PokemonTipoFB.FUEGO) to "0.5",
    Pair(PokemonTipoFB.BICHO, PokemonTipoFB.HADA) to "0.5",
    Pair(PokemonTipoFB.BICHO, PokemonTipoFB.LUCHA) to "0.5",
    Pair(PokemonTipoFB.BICHO, PokemonTipoFB.VENENO) to "0.5",
    Pair(PokemonTipoFB.BICHO, PokemonTipoFB.VOLADOR) to "0.5",
    Pair(PokemonTipoFB.DRAGON, PokemonTipoFB.DRAGON) to "2",
    Pair(PokemonTipoFB.DRAGON, PokemonTipoFB.ACERO) to "0.5",
    Pair(PokemonTipoFB.DRAGON, PokemonTipoFB.HADA) to "0",
    Pair(PokemonTipoFB.ELECTRICO, PokemonTipoFB.AGUA) to "2",
    Pair(PokemonTipoFB.ELECTRICO, PokemonTipoFB.VOLADOR) to "2",
    Pair(PokemonTipoFB.ELECTRICO, PokemonTipoFB.DRAGON) to "0.5",
    Pair(PokemonTipoFB.ELECTRICO, PokemonTipoFB.ELECTRICO) to "0.5",
    Pair(PokemonTipoFB.ELECTRICO, PokemonTipoFB.PLANTA) to "0.5",
    Pair(PokemonTipoFB.ELECTRICO, PokemonTipoFB.TIERRA) to "0",
    Pair(PokemonTipoFB.HADA, PokemonTipoFB.DRAGON) to "2",
    Pair(PokemonTipoFB.HADA, PokemonTipoFB.LUCHA) to "2",
    Pair(PokemonTipoFB.HADA, PokemonTipoFB.SINIESTRO) to "2",
    Pair(PokemonTipoFB.HADA, PokemonTipoFB.FUEGO) to "0.5",
    Pair(PokemonTipoFB.HADA, PokemonTipoFB.VENENO) to "0.5",
    Pair(PokemonTipoFB.HIELO, PokemonTipoFB.PLANTA) to "2",
    Pair(PokemonTipoFB.HIELO, PokemonTipoFB.TIERRA) to "2",
    Pair(PokemonTipoFB.HIELO, PokemonTipoFB.VOLADOR) to "2",
    Pair(PokemonTipoFB.HIELO, PokemonTipoFB.DRAGON) to "2",
    Pair(PokemonTipoFB.HIELO, PokemonTipoFB.ROCA) to "2",
    Pair(PokemonTipoFB.HIELO, PokemonTipoFB.ACERO) to "0.5",
    Pair(PokemonTipoFB.HIELO, PokemonTipoFB.AGUA) to "0.5",
    Pair(PokemonTipoFB.HIELO, PokemonTipoFB.FUEGO) to "0.5",
    Pair(PokemonTipoFB.HIELO, PokemonTipoFB.HIELO) to "0.5",
    Pair(PokemonTipoFB.PSIQUICO, PokemonTipoFB.LUCHA) to "2",
    Pair(PokemonTipoFB.PSIQUICO, PokemonTipoFB.VENENO) to "2",
    Pair(PokemonTipoFB.PSIQUICO, PokemonTipoFB.ACERO) to "0.5",
    Pair(PokemonTipoFB.PSIQUICO, PokemonTipoFB.PSIQUICO) to "0.5",
    Pair(PokemonTipoFB.PSIQUICO, PokemonTipoFB.SINIESTRO) to "0",
    Pair(PokemonTipoFB.ROCA, PokemonTipoFB.BICHO) to "2",
    Pair(PokemonTipoFB.ROCA, PokemonTipoFB.FUEGO) to "2",
    Pair(PokemonTipoFB.ROCA, PokemonTipoFB.HIELO) to "2",
    Pair(PokemonTipoFB.ROCA, PokemonTipoFB.VOLADOR) to "2",
    Pair(PokemonTipoFB.ROCA, PokemonTipoFB.ACERO) to "0.5",
    Pair(PokemonTipoFB.ROCA, PokemonTipoFB.LUCHA) to "0.5",
    Pair(PokemonTipoFB.ROCA, PokemonTipoFB.TIERRA) to "0.5",
    Pair(PokemonTipoFB.TIERRA, PokemonTipoFB.ACERO) to "2",
    Pair(PokemonTipoFB.TIERRA, PokemonTipoFB.ELECTRICO) to "2",
    Pair(PokemonTipoFB.TIERRA, PokemonTipoFB.FUEGO) to "2",
    Pair(PokemonTipoFB.TIERRA, PokemonTipoFB.ROCA) to "2",
    Pair(PokemonTipoFB.TIERRA, PokemonTipoFB.VENENO) to "2",
    Pair(PokemonTipoFB.TIERRA, PokemonTipoFB.BICHO) to "0.5",
    Pair(PokemonTipoFB.TIERRA, PokemonTipoFB.PLANTA) to "0.5",
    Pair(PokemonTipoFB.TIERRA, PokemonTipoFB.VOLADOR) to "0",
    Pair(PokemonTipoFB.SINIESTRO, PokemonTipoFB.PSIQUICO) to "2",
    Pair(PokemonTipoFB.SINIESTRO, PokemonTipoFB.FANTASMA) to "2",
    Pair(PokemonTipoFB.SINIESTRO, PokemonTipoFB.LUCHA) to "0.5",
    Pair(PokemonTipoFB.SINIESTRO, PokemonTipoFB.HADA) to "0.5",
    Pair(PokemonTipoFB.SINIESTRO, PokemonTipoFB.SINIESTRO) to "0.5",
    Pair(PokemonTipoFB.VOLADOR, PokemonTipoFB.PLANTA) to "2",
    Pair(PokemonTipoFB.VOLADOR, PokemonTipoFB.BICHO) to "2",
    Pair(PokemonTipoFB.VOLADOR, PokemonTipoFB.LUCHA) to "2",
    Pair(PokemonTipoFB.VOLADOR, PokemonTipoFB.ACERO) to "0.5",
    Pair(PokemonTipoFB.VOLADOR, PokemonTipoFB.ELECTRICO) to "0.5",
    Pair(PokemonTipoFB.VOLADOR, PokemonTipoFB.ROCA) to "0.5",
    Pair(PokemonTipoFB.VOLADOR, PokemonTipoFB.HIELO) to "0.5",////
    Pair(PokemonTipoFB.FANTASMA, PokemonTipoFB.FANTASMA) to "2",
    Pair(PokemonTipoFB.FANTASMA, PokemonTipoFB.PSIQUICO) to "2",
    Pair(PokemonTipoFB.FANTASMA, PokemonTipoFB.SINIESTRO) to "0.5",
    Pair(PokemonTipoFB.FANTASMA, PokemonTipoFB.NORMAL) to "0",
    Pair(PokemonTipoFB.NORMAL, PokemonTipoFB.ACERO) to "0.5",
    Pair(PokemonTipoFB.NORMAL, PokemonTipoFB.ROCA) to "0.5",
    Pair(PokemonTipoFB.NORMAL, PokemonTipoFB.FANTASMA) to "0"
)

fun debsFB(poke: PokemonFB): List<Int> {
    val debilidades = mutableListOf<Int>()

    when (poke.tipo.size) {
        1 -> {
            for ((key, value) in efectividadFB) {
                if (key.second == poke.tipo[0] && value == "2") {
                    debilidades.add(enumToDrawableFB(key.first))
                }
            }
        }
        2 -> {
            // 1. Accumulate weaknesses from both types
            for ((key, value) in efectividadFB) {
                if (key.second == poke.tipo[0] && value == "2") {
                    debilidades.add(enumToDrawableFB(key.first))
                }
                if (key.second == poke.tipo[1] && value == "2") {
                    //if (!debilidades.contains(enumToDrawable(key.first))) {
                    debilidades.add(enumToDrawableFB(key.first))
                    //}
                }
            }

            for ((key, value) in efectividadFB) {
                if ((key.first == poke.tipo[0] || key.first == poke.tipo[1]) && (value == "0.5" || value == "0")) {
                    if (efectividadFB[Pair(key.second, poke.tipo[0])] == "0.5" ||
                        efectividadFB[Pair(key.second, poke.tipo[0])] == "0" ||
                        efectividadFB[Pair(key.second, poke.tipo[1])] == "0.5" ||
                        efectividadFB[Pair(key.second, poke.tipo[1])] == "0") {
                        debilidades.remove(enumToDrawableFB(key.second))
                    }
                }
            }
        }
    }
    return debilidades.distinct()
}
fun fortsFB(poke:PokemonFB):List<Int>{
    val fortalezas: MutableList<Int> = mutableListOf()
    when(poke.tipo.size){
        1->{
            for(i in efectividadFB){
                if(i.key.first==poke.tipo[0] && i.value.equals("2")) {
                    fortalezas.add(enumToDrawableFB(i.key.second))
                }
            }
        }
        2->{
            for(i in efectividadFB){
                if(i.key.first==poke.tipo[0] && i.value.equals("2")) {
                    fortalezas.add(enumToDrawableFB(i.key.second))
                }
            }
            for(i in efectividadFB){
                if(i.key.first==poke.tipo[1] && i.value.equals("2")) {
                    //if(!fortalezas.contains(enumToDrawable(i.key.second)))fortalezas.add(enumToDrawable(i.key.second))
                    fortalezas.add(enumToDrawableFB(i.key.second))
                }
            }
        }
    }

    return fortalezas.distinct()
}
fun inmuneFB(poke:PokemonFB):List<Int>{
    val inmu: MutableList<Int> = mutableListOf()
    when(poke.tipo.size){
        1-> {
            for (i in efectividadFB) {
                if (i.key.second == poke.tipo[0] && i.value.equals("0")) {
                    inmu.add(enumToDrawableFB(i.key.first))
                }
            }
        }
        2-> {
            for (i in efectividadFB) {
                if (i.key.second == poke.tipo[0] && i.value.equals("0")) {
                    inmu.add(enumToDrawableFB(i.key.first))
                }
            }
            for (i in efectividadFB) {
                if (i.key.second == poke.tipo[1] && i.value.equals("0")) {
                    inmu.add(enumToDrawableFB(i.key.first))
                }
            }
        }
    }
    return inmu.distinct()
}

fun adaptaNombre(nombre:String):String{
    val devuelve = nombre
        .replace(Regex("[áéíóúü]"), {
            when (it.value) {
                "á" -> "a"
                "é" -> "e"
                "í" -> "i"
                "ó" -> "o"
                "ú" -> "u"
                "ü" -> "u"
                else -> it.value
            }
        })
        .replace("[^a-zA-Z0-9]".toRegex(), "") // Elimina otros caracteres especiales
        .replace("-", "") // Elimina guiones
        .lowercase()
    return devuelve
}


fun debilidadesEquipo(lista:List<PokemonFB>):List<Int>{
    val debilidades: MutableList<Int> = mutableListOf()
    for(poke in lista){
        debilidades.addAll(debsFB(poke))
    }
    return debilidades.distinct()
}
fun fortalezasEquipo(lista:List<PokemonFB>):List<Int>{
    val fortalezas: MutableList<Int> = mutableListOf()
    for(poke in lista){
        fortalezas.addAll(fortsFB(poke))
    }
    return fortalezas.distinct()
}
fun inmunidadesEquipo(lista:List<PokemonFB>):List<Int>{
    val inmunidades: MutableList<Int> = mutableListOf()
    for(poke in lista){
        inmunidades.addAll(inmuneFB(poke))
    }
    return inmunidades.distinct()
}
fun limpiaNombrePoke(nombre:String):String{
    val nombrePokeLimpio=nombre
        .lowercase()
        .replace("á", "a")
        .replace("é", "e")
        .replace("í", "i")
        .replace("ó", "o")
        .replace("ú", "u")
        .replace(" ","")
        .replace("-","")
        .replace(".","")
        .replace("'","")
        .replace("dealola","")
        .replace("degalar","")
        .replace("dehisui","")
        .replace("depaldea","")
        .replace("combatiente","")
        .replace("ardiente","")
        .replace("acuatico","")
    Log.v("NOMBRE - POKE", nombrePokeLimpio)
    return nombrePokeLimpio
}



var formasUnown:List<UnonwnFormas> = listOf(
    UnonwnFormas("A",R.drawable.unonwna),
    UnonwnFormas("B",R.drawable.unonwnb),
    UnonwnFormas("C",R.drawable.unonwnc),
    UnonwnFormas("D",R.drawable.unonwnd),
    UnonwnFormas("E",R.drawable.unonwne),
    UnonwnFormas("F",R.drawable.unonwnf),
    UnonwnFormas("G",R.drawable.unonwng),
    UnonwnFormas("H",R.drawable.unonwnh),
    UnonwnFormas("I",R.drawable.unonwni),
    UnonwnFormas("J",R.drawable.unonwnj),
    UnonwnFormas("K",R.drawable.unonwnk),
    UnonwnFormas("L",R.drawable.unonwnl),
    UnonwnFormas("M",R.drawable.unonwnm),
    UnonwnFormas("N",R.drawable.unonwnn),
    UnonwnFormas("O",R.drawable.unonwno),
    UnonwnFormas("P",R.drawable.unonwnp),
    UnonwnFormas("Q",R.drawable.unonwnq),
    UnonwnFormas("R",R.drawable.unonwnr),
    UnonwnFormas("S",R.drawable.unonwns),
    UnonwnFormas("T",R.drawable.unonwnt),
    UnonwnFormas("U",R.drawable.unonwnu),
    UnonwnFormas("V",R.drawable.unonwnv),
    UnonwnFormas("W",R.drawable.unonwnw),
    UnonwnFormas("X",R.drawable.unonwnx),
    UnonwnFormas("Y",R.drawable.unonwny),
    UnonwnFormas("Z",R.drawable.unonwnz)
)
/*
var evosGigamax:List<PokemonFB> = listOf(
    PokemonFB(3,"",R.drawable.gigamaxvenusaur,"Venusaur Gigamax","", listOf(), listOf()),
    PokemonFB(6,"",R.drawable.gigamaxcharizard,"Charizard Gigamax","", listOf(), listOf()),
    PokemonFB(9,"",R.drawable.gigamaxblastoise,"Blastoise Gigamax","", listOf(), listOf()),
    PokemonFB(12,"",R.drawable.gigamaxbutterfree,"Butterfree Gigamax","", listOf(), listOf()),
    PokemonFB(25,"",R.drawable.gigamaxpikachu,"Pikachu Gigamax","", listOf(), listOf()),
    PokemonFB(52,"",R.drawable.gigamaxmeowth,"Meowth Gigamax","", listOf(), listOf()),
    PokemonFB(67,"",R.drawable.gigamaxmachamp,"Machamp Gigamax","", listOf(), listOf()),
    PokemonFB(94,"",R.drawable.gigamaxgengar,"Gengar Gigamax","", listOf(), listOf()),
    PokemonFB(99,"",R.drawable.gigamaxkingler,"Kingler Gigamax","", listOf(), listOf()),
    PokemonFB(131,"",R.drawable.gigamaxlapras,"Lapras Gigamax","", listOf(), listOf()),
    PokemonFB(133,"",R.drawable.gigamaxeevee,"Eevee Gigamax","", listOf(), listOf()),
    PokemonFB(143,"",R.drawable.gigamaxsnorlax,"Snorlax Gigamax","", listOf(), listOf()),
    PokemonFB(569,"",R.drawable.gigamaxgarbodor,"Garbodor Gigamax","", listOf(), listOf()),
    PokemonFB(809,"",R.drawable.gigamaxmelmetal,"Melmetal Gigamax","", listOf(), listOf()),
    PokemonFB(812,"",R.drawable.gigamaxrillaboom,"Rillaboom Gigamax","", listOf(), listOf()),
    PokemonFB(815,"",R.drawable.gigamaxcinderace,"Cinderace Gigamax","", listOf(), listOf()),
    PokemonFB(817,"",R.drawable.gigamaxinteleon,"Inteleon Gigamax","", listOf(), listOf()),
    PokemonFB(823,"",R.drawable.gigamaxcorviknight,"Corviknight Gigamax","", listOf(), listOf()),
    PokemonFB(826,"",R.drawable.gigamaxorbeetle,"Orbeetle Gigamax","", listOf(), listOf()),
    PokemonFB(834,"",R.drawable.gigamaxdrednaw,"Drednaw Gigamax","", listOf(), listOf()),
    PokemonFB(839,"",R.drawable.gigamaxcoalossal,"Coalossal Gigamax","", listOf(), listOf()),
    PokemonFB(841,"",R.drawable.gigamaxflapple,"Flapple Gigamax","", listOf(), listOf()),
    PokemonFB(842,"",R.drawable.gigamaxappletun,"Appletun Gigamax","", listOf(), listOf()),
    PokemonFB(844,"",R.drawable.gigamaxsandaconda,"Sandaconda Gigamax","", listOf(), listOf()),
    PokemonFB(849,"",R.drawable.gigamaxtoxtricity,"Toxtricity Gigamax","", listOf(), listOf()),
    PokemonFB(850,"",R.drawable.gigamaxcentiskorch,"Centiskorch Gigamax","", listOf(), listOf()),
    PokemonFB(858,"",R.drawable.gigamaxhatterene,"Hatterene Gigamax","", listOf(), listOf()),
    PokemonFB(861,"",R.drawable.gigamaxgrimmsnarl,"Grimmsnarl Gigamax","", listOf(), listOf()),
    PokemonFB(869,"",R.drawable.gigamaxalcremie,"Alcremie Gigamax","", listOf(), listOf()),
    PokemonFB(879,"",R.drawable.gigamaxcopperajah,"Copperajah Gigamax","", listOf(), listOf()),
    PokemonFB(884,"",R.drawable.gigamaxduraludon,"Duraludon Gigamax","", listOf(), listOf()),
    PokemonFB(892,"",R.drawable.gigamaxurshifubrusco,"Urshifu Brusco Gigamax","", listOf(), listOf()),
    PokemonFB(892,"",R.drawable.gigamaxurshifufluido,"Urshifu Fluído Gigamax","", listOf(), listOf()),
)
*/

val evosGigamax: Map<Int, PokemonFB> = listOf(
    PokemonFB(3,"",R.drawable.gigamaxvenusaur,"Venusaur Gigamax",R.string.desc_gigamax.toString(), listOf(), listOf()),
    PokemonFB(3,"",R.drawable.gigamaxvenusaur,"Venusaur Gigamax",R.string.desc_gigamax.toString(), listOf(), listOf()),
    PokemonFB(6,"",R.drawable.gigamaxcharizard,"Charizard Gigamax",R.string.desc_gigamax.toString(), listOf(), listOf()),
    PokemonFB(9,"",R.drawable.gigamaxblastoise,"Blastoise Gigamax",R.string.desc_gigamax.toString(), listOf(), listOf()),
    PokemonFB(12,"",R.drawable.gigamaxbutterfree,"Butterfree Gigamax",R.string.desc_gigamax.toString(), listOf(), listOf()),
    PokemonFB(25,"",R.drawable.gigamaxpikachu,"Pikachu Gigamax",R.string.desc_gigamax.toString(), listOf(), listOf()),
    PokemonFB(52,"",R.drawable.gigamaxmeowth,"Meowth Gigamax",R.string.desc_gigamax.toString(), listOf(), listOf()),
    PokemonFB(67,"",R.drawable.gigamaxmachamp,"Machamp Gigamax",R.string.desc_gigamax.toString(), listOf(), listOf()),
    PokemonFB(94,"",R.drawable.gigamaxgengar,"Gengar Gigamax",R.string.desc_gigamax.toString(), listOf(), listOf()),
    PokemonFB(99,"",R.drawable.gigamaxkingler,"Kingler Gigamax",R.string.desc_gigamax.toString(), listOf(), listOf()),
    PokemonFB(131,"",R.drawable.gigamaxlapras,"Lapras Gigamax",R.string.desc_gigamax.toString(), listOf(), listOf()),
    PokemonFB(133,"",R.drawable.gigamaxeevee,"Eevee Gigamax",R.string.desc_gigamax.toString(), listOf(), listOf()),
    PokemonFB(143,"",R.drawable.gigamaxsnorlax,"Snorlax Gigamax",R.string.desc_gigamax.toString(), listOf(), listOf()),
    PokemonFB(569,"",R.drawable.gigamaxgarbodor,"Garbodor Gigamax",R.string.desc_gigamax.toString(), listOf(), listOf()),
    PokemonFB(809,"",R.drawable.gigamaxmelmetal,"Melmetal Gigamax",R.string.desc_gigamax.toString(), listOf(), listOf()),
    PokemonFB(812,"",R.drawable.gigamaxrillaboom,"Rillaboom Gigamax",R.string.desc_gigamax.toString(), listOf(), listOf()),
    PokemonFB(815,"",R.drawable.gigamaxcinderace,"Cinderace Gigamax",R.string.desc_gigamax.toString(), listOf(), listOf()),
    PokemonFB(817,"",R.drawable.gigamaxinteleon,"Inteleon Gigamax",R.string.desc_gigamax.toString(), listOf(), listOf()),
    PokemonFB(823,"",R.drawable.gigamaxcorviknight,"Corviknight Gigamax",R.string.desc_gigamax.toString(), listOf(), listOf()),
    PokemonFB(826,"",R.drawable.gigamaxorbeetle,"Orbeetle Gigamax",R.string.desc_gigamax.toString(), listOf(), listOf()),
    PokemonFB(834,"",R.drawable.gigamaxdrednaw,"Drednaw Gigamax",R.string.desc_gigamax.toString(), listOf(), listOf()),
    PokemonFB(839,"",R.drawable.gigamaxcoalossal,"Coalossal Gigamax",R.string.desc_gigamax.toString(), listOf(), listOf()),
    PokemonFB(841,"",R.drawable.gigamaxflapple,"Flapple Gigamax",R.string.desc_gigamax.toString(), listOf(), listOf()),
    PokemonFB(842,"",R.drawable.gigamaxappletun,"Appletun Gigamax",R.string.desc_gigamax.toString(), listOf(), listOf()),
    PokemonFB(844,"",R.drawable.gigamaxsandaconda,"Sandaconda Gigamax",R.string.desc_gigamax.toString(), listOf(), listOf()),
    PokemonFB(849,"",R.drawable.gigamaxtoxtricity,"Toxtricity Gigamax",R.string.desc_gigamax.toString(), listOf(), listOf()),
    PokemonFB(850,"",R.drawable.gigamaxcentiskorch,"Centiskorch Gigamax",R.string.desc_gigamax.toString(), listOf(), listOf()),
    PokemonFB(858,"",R.drawable.gigamaxhatterene,"Hatterene Gigamax",R.string.desc_gigamax.toString(), listOf(), listOf()),
    PokemonFB(861,"",R.drawable.gigamaxgrimmsnarl,"Grimmsnarl Gigamax",R.string.desc_gigamax.toString(), listOf(), listOf()),
    PokemonFB(869,"",R.drawable.gigamaxalcremie,"Alcremie Gigamax",R.string.desc_gigamax.toString(), listOf(), listOf()),
    PokemonFB(879,"",R.drawable.gigamaxcopperajah,"Copperajah Gigamax",R.string.desc_gigamax.toString(), listOf(), listOf()),
    PokemonFB(884,"",R.drawable.gigamaxduraludon,"Duraludon Gigamax",R.string.desc_gigamax.toString(), listOf(), listOf()),
    PokemonFB(892,"",R.drawable.gigamaxurshifubrusco,"Urshifu Brusco Gigamax",R.string.desc_gigamax.toString(), listOf(), listOf()),
    PokemonFB(892,"",R.drawable.gigamaxurshifufluido,"Urshifu Fluído Gigamax",R.string.desc_gigamax.toString(), listOf(), listOf()),
).associateBy { it.num }










var listaPokeFB : List<PokemonFB> = listOf(

/*
    PokemonFB(1,"1",R.drawable.bulbasaur,"Bulbasaur", "Puede sobrevivir largo tiempo sin probar bocado. Guarda energía en el bulbo de su espalda.", listOf(PokemonTipoFB.PLANTA, PokemonTipoFB.VENENO),listOf(1,2, 3)),
    PokemonFB(2,"1",R.drawable.ivisaur01, "Ivysaur", "Su bulbo crece cuando absorbe energía. Desprende un fuerte aroma cuando florece.", listOf(PokemonTipoFB.PLANTA, PokemonTipoFB.VENENO),listOf(1,2, 3)),
    PokemonFB(3,"1",R.drawable.venusaur, "Venusaur", "La flor de su espalda recoge los rayos del sol. Los transforma en energía.", listOf(PokemonTipoFB.PLANTA, PokemonTipoFB.VENENO), listOf(1, 2,3)),
    PokemonFB(4,"1",R.drawable.charmander, "Charmander", "La llama en la punta de su cola chisporrotea al arder. Sólo se oye en lugares silenciosos.", listOf(PokemonTipoFB.FUEGO), listOf(4,5,6)),
    PokemonFB(5,"1",R.drawable.charmeleon, "Charmeleon", "Las duras luchas excitan a este Pokémon. Entonces, lanzará llamaradas blanco-azuladas.", listOf(PokemonTipoFB.FUEGO),listOf(4,5,6)),
    PokemonFB(6,"1",R.drawable.charizard, "Charizard", "Cuando lanza una descarga de fuego súper caliente, la roja llama de su cola brilla más intensamente.", listOf(PokemonTipoFB.FUEGO, PokemonTipoFB.VOLADOR),listOf(4,5,6)),
    PokemonFB(7,"1",R.drawable.squirtle01, "Squirtle", "Lanza agua a su presa desde el agua. Se esconde en su concha cuando se siente en peligro.", listOf(PokemonTipoFB.AGUA), listOf(7,8,9)),
    PokemonFB(8,"1",R.drawable.wartortle, "Wartortle", "Si es golpeado, esconderá su cabeza. Aun así, su cola puede seguir golpeando.", listOf(PokemonTipoFB.AGUA), listOf(7,8,9)),
    PokemonFB(9,"1",R.drawable.blastoise, "Blastoise", "Cuando ataca a un enemigo, su descarga de agua es aún más potente que una manga de bombero.", listOf(PokemonTipoFB.AGUA), listOf(7,8,9)),
    PokemonFB(10,"1",R.drawable.caterpie, "Caterpie", "Si tocas los receptores de su cabeza, soltará un terrible olor para protegerse.", listOf(PokemonTipoFB.BICHO), listOf(10,11,12)),
    PokemonFB(11,"1",R.drawable.metapod, "Metapod", "Endurece su concha para protegerse. De todos modos, un gran impacto puede afectarle.", listOf(PokemonTipoFB.BICHO), listOf(10,11,12)),
    PokemonFB(12,"1",R.drawable.butterfree, "Butterfree", "Sus alas están cubiertas de polvos venenosos. Como repelen el agua, puede volar bajo la lluvia.", listOf(PokemonTipoFB.BICHO, PokemonTipoFB.VOLADOR), listOf(10,11,12)),
    PokemonFB(13,"1",R.drawable.weedle, "Weedle", "Cuidado con el aguijón venenoso de su cabeza. Se esconde en la hierba y arbustos mientras come.", listOf(PokemonTipoFB.BICHO, PokemonTipoFB.VENENO), listOf(13,14,15)),
    PokemonFB(14,"1",R.drawable.kakuna, "Kakuna", "Sólo puede moverse un poco. Cuando está en peligro, envenena a su enemigo con su aguijón.", listOf(PokemonTipoFB.BICHO, PokemonTipoFB.VENENO), listOf(13,14,15)),
    PokemonFB(15,"1",R.drawable.beedril, "Beedril", "Tiene 3 aguijones venenosos en sus patas y cola. Suele pinchar a sus enemigos repetidas veces.", listOf(PokemonTipoFB.BICHO, PokemonTipoFB.VENENO), listOf(13,14,15)),
    PokemonFB(16,"1",R.drawable.pidgey, "Pidgey", "Son muy dóciles. Si son atacados, suelen lanzar arena en lugar de repeler el ataque.", listOf(PokemonTipoFB.NORMAL, PokemonTipoFB.VOLADOR), listOf(16,17,18)),
    PokemonFB(17,"1",R.drawable.pidgeotto, "Pidgeotto", "Su visión es extraordinaria. Aunque vuele muy alto, detectará todo movimiento de su presa.", listOf(PokemonTipoFB.NORMAL, PokemonTipoFB.VOLADOR), listOf(16,17,18)),
    PokemonFB(18,"1",R.drawable.pidgeot, "Pidgeot", "Este Pokémon vuela a velocidad Mach 2. Sus grandes garras son armas muy peligrosas.", listOf(PokemonTipoFB.NORMAL, PokemonTipoFB.VOLADOR), listOf(16,17,18)),
    PokemonFB(19,"1",R.drawable.rattata, "Rattata", "Muerde cualquier cosa con sus colmillos. Si ves uno, seguro que encuentras 40 más en la zona.", listOf(PokemonTipoFB.NORMAL), listOf(19,20)),
    PokemonFB(20,"1",R.drawable.raticate, "Raticate", "Sus patas son palmeadas. Sirven de aletas, por lo que puede nadar por ríos en busca de presa.", listOf(PokemonTipoFB.NORMAL), listOf(19,20)),
    PokemonFB(21,"1",R.drawable.spearow, "Spearow", "Es incapaz de volar a gran altura, pero es muy rápido, lo que le permite protegerse.", listOf(PokemonTipoFB.NORMAL, PokemonTipoFB.VOLADOR), listOf(21,22)),
    PokemonFB(22,"1",R.drawable.fearow, "Fearow", "Este Pokémon es conocido desde hace muchos años. Si siente peligro volará lejos inmediatamente.", listOf(PokemonTipoFB.NORMAL, PokemonTipoFB.VOLADOR), listOf(21,22)),
    PokemonFB(23,"1",R.drawable.ekans, "Ekans", "Cuanto más viejo, más crece este Pokémon. Por la noche, descansa en las ramas de los árboles.", listOf(PokemonTipoFB.VENENO), listOf(23,24)),
    PokemonFB(24,"1",R.drawable.arbok, "Arbok", "Los espantosos dibujos de su piel han sido estudiados. Seis variaciones han sido confirmadas.", listOf(PokemonTipoFB.VENENO), listOf(23,24)),
    PokemonFB(25,"1",R.drawable.pikachu, "Pikachu", "Mantiene su cola en alto para vigilar. Si das un tirón a su cola, querrá morderte.", listOf(PokemonTipoFB.ELECTRICO), listOf(172,25,26)),
    PokemonFB(26,"1",R.drawable.raichu, "Raichu", "Cuando la electricidad del cuerpo crece, se vuelve irritable. También brilla en la oscuridad.", listOf(PokemonTipoFB.ELECTRICO), listOf(172,25,26)),
    PokemonFB(27,"1",R.drawable.sandshrew, "Sandshrew", "Su cuerpo es muy seco. Cuando hace frío por la noche, su piel aparece cubierta con un fino rocío.", listOf(PokemonTipoFB.TIERRA), listOf(27,28)),
    PokemonFB(28,"1",R.drawable.sandslash, "Sandslash", "Es muy hábil al golpear a sus enemigos con sus garras. Si se rompen, crecerán en un solo día.", listOf(PokemonTipoFB.TIERRA), listOf(27,28)),
    PokemonFB(29,"1",R.drawable.nidoranf, "Nidoran♀", "A este Pokémon no le gusta luchar. Pero cuidado, sus pequeños cuernos segregan veneno.", listOf(PokemonTipoFB.VENENO), listOf(29,30,31)),
    PokemonFB(30,"1",R.drawable.nidorina, "Nidorina", "Cuando descansa profundamente, sus cuernos se contraen. Esto prueba que está relajado.", listOf(PokemonTipoFB.VENENO), listOf(29,30,31)),
    PokemonFB(31,"1",R.drawable.nidoqueen, "Nidoqueen", "Grandes escamas recubren el duro cuerpo de este Pokémon. Éstas crecen cíclicamente.", listOf(PokemonTipoFB.VENENO, PokemonTipoFB.TIERRA), listOf(29,30,31)),
    PokemonFB(32,"1",R.drawable.nidoranm, "Nidoran♂", "Sus largas orejas se mantienen siempre alerta. Si siente peligro, atacará con su venenoso cuerno.", listOf(PokemonTipoFB.VENENO), listOf(32,33,34)),
    PokemonFB(33,"1",R.drawable.nidorino, "Nidorino", "Sus cuernos contienen veneno. Si se introducen en el cuerpo del enemigo, soltarán su tóxica carga.", listOf(PokemonTipoFB.VENENO), listOf(32,33,34)),
    PokemonFB(34,"1",R.drawable.nidoking, "Nidoking", "Duro como el acero, posee una poderosa carga. Sus cuernos son tan duros como el diamante.", listOf(PokemonTipoFB.VENENO, PokemonTipoFB.TIERRA), listOf(32,33,34)),
    PokemonFB(35,"1",R.drawable.clefairy, "Clefairy", "Su aspecto jovial y vivaracho lo hace adorable. Piensan que son raros, ya que no son muy comunes.", listOf(PokemonTipoFB.HADA), listOf(173,35,36)),
    PokemonFB(36,"1",R.drawable.clefable, "Clefable", "Protege bastante bien su propio entorno. Es una especie de hada, raramente vista por los humanos.", listOf(PokemonTipoFB.HADA), listOf(173,35,36)),
    PokemonFB(37,"1",R.drawable.vulpix, "Vulpix", "Su piel y colas son preciosas. Cuando crecen las colas, se dividen formando nuevas colas.", listOf(PokemonTipoFB.FUEGO), listOf(37,38)),
    PokemonFB(38,"1",R.drawable.ninetales, "Ninetales", "De acuerdo con una antigua leyenda, este Pokémon es la reencarnación de 9 nobles santos.", listOf(PokemonTipoFB.FUEGO), listOf(37,38)),
    PokemonFB(39,"1",R.drawable.jigglypuff, "Jigglypuff", "Utiliza sus misteriosos ojos para engañar a su enemigo. También cantará para dormirlo.", listOf(PokemonTipoFB.NORMAL, PokemonTipoFB.HADA), listOf(174,39,40)),
    PokemonFB(40,"1",R.drawable.wigglytuff, "Wigglytuff", "Su cuerpo es muy elástico. Cuando inhala aire profundamente, puede inflarse sin límite.", listOf(PokemonTipoFB.NORMAL, PokemonTipoFB.HADA), listOf(174,39,40)),
    PokemonFB(41,"1",R.drawable.zubat, "Zubat", "Emite sonidos ultrasónicos mientras vuela. Los utiliza como sónar para evitar obstáculos.", listOf(PokemonTipoFB.VENENO, PokemonTipoFB.VOLADOR), listOf(41,42,169)),
    PokemonFB(42,"1",R.drawable.golbat, "Golbat", "Ataca de manera violenta sin avisar. Utiliza sus afilados colmillos para chupar sangre.", listOf(PokemonTipoFB.VENENO, PokemonTipoFB.VOLADOR), listOf(41,42,169)),
    PokemonFB(43,"1",R.drawable.oddish, "Oddish", "Suele ser confundido con un puñado de semillas. Si lo extraes del suelo, gritará.", listOf(PokemonTipoFB.PLANTA, PokemonTipoFB.VENENO), listOf(43,44,45,182)),
    PokemonFB(44,"1",R.drawable.gloom, "Gloom", "¡Huele bastante mal! De todas formas, 1 de cada 1000 personas aprecian su fétido olor.", listOf(PokemonTipoFB.PLANTA, PokemonTipoFB.VENENO), listOf(43,44,45,182)),
    PokemonFB(45,"1",R.drawable.vileplume, "Vileplume", "Aletea sus pétalos de flores para propagar su venenoso polen. El sonido que emite es agudo.", listOf(PokemonTipoFB.PLANTA, PokemonTipoFB.VENENO), listOf(43,44,45,182)),
    PokemonFB(46,"1",R.drawable.paras, "Paras", "Escarba bajo el suelo para roer las raíces de los árboles. Sus setas absorben sus energías.", listOf(PokemonTipoFB.BICHO, PokemonTipoFB.PLANTA), listOf(46,47)),
    PokemonFB(47,"1",R.drawable.parasect, "Parasect", "El parásito absorbe la energía con las setas de la espalda, que lo controlan.", listOf(PokemonTipoFB.BICHO, PokemonTipoFB.PLANTA), listOf(46,47)),
    PokemonFB(48,"1",R.drawable.venonat, "Venonat", "Sus grandes ojos actúan como radares. En lugares claros, verás montones de pequeños ojos.", listOf(PokemonTipoFB.BICHO, PokemonTipoFB.VENENO), listOf(48,49)),
    PokemonFB(49,"1",R.drawable.venomoth, "Venomoth", "Es difícil quitar el polvo de sus alas. También posee un veneno que se desprende al contacto.", listOf(PokemonTipoFB.BICHO, PokemonTipoFB.VENENO), listOf(48,49)),
    PokemonFB(50,"1",R.drawable.diglett, "Diglett", "Prefiere los lugares oscuros. Pasa el tiempo bajo tierra, aunque aparece en cuevas.", listOf(PokemonTipoFB.TIERRA), listOf(50,51)),
    PokemonFB(51,"1",R.drawable.dugtrio, "Dugtrio", "Un grupo de trillizos que cava a 90 KPH. Por ello, creen que se trata de un terremoto.", listOf(PokemonTipoFB.TIERRA), listOf(50,51)),
    PokemonFB(52,"1",R.drawable.meowth, "Meowth", "Parece que son más activos por la noche. Adoran las cosas redondas y brillantes.", listOf(PokemonTipoFB.NORMAL), listOf(52,53)),
    PokemonFB(53,"1",R.drawable.persian, "Persian", "¡La gema en su frente brilla por sí misma! Camina con la elegancia de una reina.", listOf(PokemonTipoFB.NORMAL), listOf(52,53)),
    PokemonFB(54,"1",R.drawable.psyduck, "Psyduck", "Siempre tiene dolores de cabeza. Posee poderes mentales, pero no sabes cuándo los usará.", listOf(PokemonTipoFB.AGUA), listOf(54,55)),
    PokemonFB(55,"1",R.drawable.golduck, "Golduck", "Sus delgados y largos miembros acaban en anchas aletas. Las usan para nadar en los lagos.", listOf(PokemonTipoFB.AGUA), listOf(54,55)),
    PokemonFB(56,"1",R.drawable.mankey, "Mankey", "Este ágil Pokémon vive en los arboles. Se enfada fácilmente y no dudará en atacar a todos.", listOf(PokemonTipoFB.LUCHA), listOf(56,57,979)),
    PokemonFB(57,"1",R.drawable.primeape, "Primeape", "Sólo se calma cuando nadie está cerca. Llegar a ver ese momento es realmente difícil.", listOf(PokemonTipoFB.LUCHA), listOf(56,57,979)),
    PokemonFB(58,"1",R.drawable.growlithe, "Growlithe", "Este Pokémon es muy amistoso. Aun así, gruñirá a cualquiera que invada su territorio.", listOf(PokemonTipoFB.FUEGO), listOf(58,59)),
    PokemonFB(59,"1",R.drawable.arcanine, "Arcanine", "Es un Pokémon legendario en China. Allí, adoran la gracia y belleza que exhibe al correr.", listOf(PokemonTipoFB.FUEGO), listOf(58,59)),
    PokemonFB(60,"1",R.drawable.poliwag, "Poliwag", "La dirección de la espiral en el vientre cambia según el área. Prefiere nadar a correr.", listOf(PokemonTipoFB.AGUA), listOf(60,61,62,186)),
    PokemonFB(61,"1",R.drawable.poliwhirl, "Poliwhirl", "Cuando lo atacan, usa la espiral del vientre para dormir al rival. Aprovecha para escapar entonces.", listOf(PokemonTipoFB.AGUA), listOf(60,61,62,186)),
    PokemonFB(62,"1",R.drawable.poliwrath, "Poliwrath", "Es capaz de nadar usando todos los músculos de su cuerpo. Podrá adelantar incluso a un campeón.", listOf(PokemonTipoFB.AGUA, PokemonTipoFB.LUCHA), listOf(60,61,62,186)),
    PokemonFB(63,"1",R.drawable.abra, "Abra", "Duerme 18 horas al día. Si siente peligro, se teletransporta a un lugar seguro, aun durmiendo.", listOf(PokemonTipoFB.PSIQUICO), listOf(63,64,65)),
    PokemonFB(64,"1",R.drawable.kadabra, "Kadabra", "Muchas cosas raras suceden si está cerca. Por ejemplo, hace que los relojes vayan al revés.", listOf(PokemonTipoFB.PSIQUICO), listOf(63,64,65)),
    PokemonFB(65,"1",R.drawable.alakazam, "Alakazam", "Este Pokémon lo recuerda todo. Nunca olvida lo que aprende. Es un Pokémon muy listo.", listOf(PokemonTipoFB.PSIQUICO), listOf(63,64,65)),
    PokemonFB(66,"1",R.drawable.machop, "Machop", "Muy poderoso a pesar de su pequeño tamaño. Su maestría en artes marciales lo hace muy duro.", listOf(PokemonTipoFB.LUCHA), listOf(66,67,68)),
    PokemonFB(67,"1",R.drawable.machoke, "Machoke", "El cinturón que rodea su cintura retiene toda su energía. Sin él, este Pokémon sería implacable.", listOf(PokemonTipoFB.LUCHA), listOf(66,67,68)),
    PokemonFB(68,"1",R.drawable.machamp, "Machamp", "Con sólo un brazo puede mover montañas. Usando los cuatro, este Pokémon puede ser terrible.", listOf(PokemonTipoFB.LUCHA), listOf(66,67,68)),
    PokemonFB(69,"1",R.drawable.bellsprout, "Bellsprout", "Prefiere los lugares calientes y húmedos. Atrapa pequeños insectos con sus ramas para devorarlos.", listOf(PokemonTipoFB.PLANTA, PokemonTipoFB.VENENO), listOf(69,70,71)),
    PokemonFB(70,"1",R.drawable.weepinbell, "Weepinbell", "Cuando está hambriento, ataca a todo lo que se mueva. Su pobre presa se derrite en fuertes ácidos.", listOf(PokemonTipoFB.PLANTA, PokemonTipoFB.VENENO), listOf(69,70,71)),
    PokemonFB(71,"1",R.drawable.victreebel, "Victreebel", "Engaña a su presa con un dulce aroma a miel. Una vez atrapada, la presa perderá hasta sus huesos.", listOf(PokemonTipoFB.PLANTA, PokemonTipoFB.VENENO), listOf(69,70,71)),
    PokemonFB(72,"1",R.drawable.tentacool, "Tentacool", "A veces puede ser encontrado seco y medio enterrado en una playa. Al lanzarlo otra vez al mar revivirá.", listOf(PokemonTipoFB.AGUA, PokemonTipoFB.VENENO), listOf(72,71)),
    PokemonFB(73,"1",R.drawable.tentacruel, "Tentacruel", "Puede controlar libremente sus 80 tentáculos. Éstos debilitan a la presa con su poderoso veneno.", listOf(PokemonTipoFB.AGUA, PokemonTipoFB.VENENO), listOf(72,71)),
    PokemonFB(74,"1",R.drawable.geodude, "Geodude", "Se encuentran normalmente en los caminos de montaña. Si te cruzas con uno, se enfadará.", listOf(PokemonTipoFB.ROCA, PokemonTipoFB.TIERRA), listOf(74,75,76)),
    PokemonFB(75,"1",R.drawable.graveler, "Graveler", "Se le suele ver rodando por las montañas. Los obstáculos no los evita. ¡Los arrolla!", listOf(PokemonTipoFB.ROCA, PokemonTipoFB.TIERRA), listOf(74,75,76)),
    PokemonFB(76,"1",R.drawable.golem, "Golem", "Cuando pierde su piel, su cuerpo se vuelve blando y blanquecino. Si esto ocurre, se esconderá.", listOf(PokemonTipoFB.ROCA, PokemonTipoFB.TIERRA), listOf(74,75,76)),
    PokemonFB(77,"1",R.drawable.ponyta, "Ponyta", "Es capaz de saltar muy alto. Con sus pezuñas y sus robustas patas, absorbe el impacto.", listOf(PokemonTipoFB.FUEGO), listOf(77,78)),
    PokemonFB(78,"1",R.drawable.rapidash, "Rapidash", "Le encanta correr. Si ve algo más rápido que él, intentará alcanzarlo a toda velocidad.", listOf(PokemonTipoFB.FUEGO), listOf(77,78)),
    PokemonFB(79,"1",R.drawable.slowpoke, "Slowpoke", "Es increíblemente lento y perezoso. Le encanta dormir sin preocuparse ni del tiempo ni de lo que ocurra.", listOf(PokemonTipoFB.AGUA, PokemonTipoFB.PSIQUICO), listOf(79,80,199)),
    PokemonFB(80,"1",R.drawable.slowbro, "Slowbro", "Vive tranquilo en el mar. Si el Shellder de su cola se cae, vuelve a ser un Slowpoke otra vez.", listOf(PokemonTipoFB.AGUA, PokemonTipoFB.PSIQUICO), listOf(79,80,199)),
    PokemonFB(81,"1",R.drawable.magnemite, "Magnemite", "Puede desafiar a la gravedad desde su nacimiento. Flota en el aire gracias a ondas electromagnéticas.", listOf(PokemonTipoFB.ELECTRICO, PokemonTipoFB.ACERO), listOf(81,82,462)),
    PokemonFB(82,"1",R.drawable.magneton, "Magneton", "Genera extrañas señales de radio. Es capaz de elevar la temperatura 3º centígrados.", listOf(PokemonTipoFB.ELECTRICO, PokemonTipoFB.ACERO), listOf(81,82,462)),
    PokemonFB(83,"1",R.drawable.farfetchd, "Farfetch'd", "Vive cerca de las plantas. Son raramente vistos, así que se piensa que se están extinguiendo.", listOf(PokemonTipoFB.NORMAL, PokemonTipoFB.VOLADOR), listOf(83,865)),
    PokemonFB(84,"1",R.drawable.doduo, "Doduo", "Sus cortas alas lo hacen volar con dificultad. De todos modos, puede correr a gran velocidad.", listOf(PokemonTipoFB.NORMAL, PokemonTipoFB.VOLADOR), listOf(84,85)),
    PokemonFB(85,"1",R.drawable.dodrio, "Dodrio", "Una de las dos cabezas de Doduo se divide para formar un nuevo PkMn. Es capaz de correr a 40 KPH.", listOf(PokemonTipoFB.NORMAL, PokemonTipoFB.VOLADOR), listOf(84,85)),
    PokemonFB(86,"1",R.drawable.seel, "Seel", "A este Pokémon le encanta el frío. Le encanta nadar en climas polares, sea cual sea la temperatura.", listOf(PokemonTipoFB.AGUA), listOf(86,87)),
    PokemonFB(87,"1",R.drawable.dewgong, "Dewgong", "Su cuerpo es como una bola de nieve. Inmune al frío intenso, nada rápidamente en aguas heladas.", listOf(PokemonTipoFB.AGUA, PokemonTipoFB.HIELO), listOf(86,87)),
    PokemonFB(88,"1",R.drawable.grimer, "Grimer", "Está hecho de fango endurecido. Huele a pútrido. ¡Por donde pasa, no crece la hierba!", listOf(PokemonTipoFB.VENENO), listOf(88,89)),
    PokemonFB(89,"1",R.drawable.muk, "Muk", "Huele tan mal que puede provocar desmayos. Ha degenerado tanto, que ya ni él mismo se huele.", listOf(PokemonTipoFB.VENENO), listOf(88,89)),
    PokemonFB(90,"1",R.drawable.shellder, "Shellder", "Su concha puede evitar cualquier ataque. El débil cuerpo sólo está expuesto cuando está abierta.", listOf(PokemonTipoFB.AGUA), listOf(90,91)),
    PokemonFB(91,"1",R.drawable.cloyster, "Cloyster", "Utiliza su concha para protegerse. Dicen que es más dura que el diamante. También lanza espinas.", listOf(PokemonTipoFB.AGUA, PokemonTipoFB.HIELO), listOf(90,91)),
    PokemonFB(92,"1",R.drawable.gastly, "Gastly", "Solo aparece en edificios en ruinas. No tiene forma real, ya que parece que está hecho de gas.", listOf(PokemonTipoFB.FANTASMA, PokemonTipoFB.VENENO), listOf(92,93,94)),
    PokemonFB(93,"1",R.drawable.haunter, "Haunter", "Toma la vida de su adversario a lengüetazos. Esto produce mareos hasta que la víctima fallece.", listOf(PokemonTipoFB.FANTASMA, PokemonTipoFB.VENENO), listOf(92,93,94)),
    PokemonFB(94,"1",R.drawable.gengar, "Gengar", "Sabrás que un Gengar está cerca cuando sufras de sudores fríos. Intentará echarte un hechizo.", listOf(PokemonTipoFB.FANTASMA, PokemonTipoFB.VENENO), listOf(92,93,94)),
    PokemonFB(95,"1",R.drawable.onix, "Onix", "Cava a gran velocidad en busca de comida. Los túneles que deja son usados por los Diglett.", listOf(PokemonTipoFB.ROCA, PokemonTipoFB.TIERRA), listOf(95,208)),
    PokemonFB(96,"1",R.drawable.drowzee, "Drowzee", "Si duermes cerca de uno todo el tiempo, en alguna ocasión podrás ver sueños que se haya comido antes.", listOf(PokemonTipoFB.PSIQUICO), listOf(96,97)),
    PokemonFB(97,"1",R.drawable.hypno, "Hypno", "Intenta evitar cualquier tipo de contacto visual con este Pokémon. Puede hipnotizar con su péndulo.", listOf(PokemonTipoFB.PSIQUICO), listOf(96,97)),
    PokemonFB(98,"1",R.drawable.krabby, "Krabby", "Sus pinzas son armas perfectas. En alguna ocasión pueden romperse en combate, pero crecerán rápido.", listOf(PokemonTipoFB.AGUA), listOf(98,99)),
    PokemonFB(99,"1",R.drawable.kingler, "Kingler", "Una de sus pinzas crece más que la otra, y es dura como el acero. De todos modos, pesa demasiado.", listOf(PokemonTipoFB.AGUA), listOf(98,99)),
    PokemonFB(100,"1",R.drawable.voltorb, "Voltorb", "Se dice que se camufla como una Poké Ball. Al más mínimo estímulo se autodestruirá.", listOf(PokemonTipoFB.ELECTRICO), listOf(100,101)),
    PokemonFB(101,"1",R.drawable.electrode, "Electrode", "Almacena energía eléctrica en su cuerpo. El más leve shock puede provocar una gran explosión.", listOf(PokemonTipoFB.ELECTRICO), listOf(100,101)),
    PokemonFB(102,"1",R.drawable.exeggcute, "Exeggcute", "Sus cabezas se atraen unas a otras, y giran entre sí. Debe tener seis para equilibrarse.", listOf(PokemonTipoFB.PLANTA, PokemonTipoFB.PSIQUICO), listOf(102,103)),
    PokemonFB(103,"1",R.drawable.exeggutor, "Exeggutor", "Este Pokémon es muy ruidoso. Esto es debido a que cada una de sus cabezas hace lo que quiere.", listOf(PokemonTipoFB.PLANTA, PokemonTipoFB.PSIQUICO), listOf(102,103)),
    PokemonFB(104,"1",R.drawable.cubone, "Cubone", "Siempre lleva el cráneo de su difunta madre. Su grito hace eco y parece una triste melodía.", listOf(PokemonTipoFB.TIERRA), listOf(104,105)),
    PokemonFB(105,"1",R.drawable.marowak, "Marowak", "Pequeño y débil, este Pokémon siempre va acompañado de su palo de hueso de Pokémon.", listOf(PokemonTipoFB.TIERRA), listOf(104,105)),
    PokemonFB(106,"1",R.drawable.hitmonlee, "Hitmonlee", "Cuando da patadas al enemigo, la planta de sus pies se vuelve tan dura como el diamante.", listOf(PokemonTipoFB.LUCHA), listOf(236,106,107,237)),
    PokemonFB(107,"1",R.drawable.hitmonchan, "Hitmonchan", "Sus golpes se asemejan a una taladradora. Puede atravesar un muro de hormigón como si nada.", listOf(PokemonTipoFB.LUCHA), listOf(236,106,107,237)),
    PokemonFB(108,"1",R.drawable.lickitung, "Lickitung", "Su lengua mide casi dos metros y se mueve libremente. Sus lametazos pueden causar parálisis.", listOf(PokemonTipoFB.NORMAL), listOf(108,463)),
    PokemonFB(109,"1",R.drawable.koffing, "Koffing", "A veces puede explotar sin avisar, ya que en lugares calurosos su gas interno se expande.", listOf(PokemonTipoFB.VENENO), listOf(109,110)),
    PokemonFB(110,"1",R.drawable.weezing, "Weezing", "Este Pokémon vive absorbiendo gases venenosos, gérmenes, y el polvo que existe en la basura.", listOf(PokemonTipoFB.VENENO), listOf(109,110)),
    PokemonFB(111,"1",R.drawable.rhyhorn, "Rhyhorn", "Este Pokémon no tiene muchas luces. Una vez inicia la carga, no para hasta que cae dormido.", listOf(PokemonTipoFB.TIERRA, PokemonTipoFB.ROCA), listOf(111,112,464)),
    PokemonFB(112,"1",R.drawable.rhydon, "Rhydon", "Camina sobre sus patas traseras, y muestra signos de inteligencia. Es capaz de aguantar lava hirviendo.", listOf(PokemonTipoFB.TIERRA, PokemonTipoFB.ROCA), listOf(111,112,464)),
    PokemonFB(113,"1",R.drawable.chansey, "Chansey", "Este amable Pokémon es capaz de compartir sus nutrientes huevos con un Pokémon herido.", listOf(PokemonTipoFB.NORMAL), listOf(440,113,242)),
    PokemonFB(114,"1",R.drawable.tangela, "Tangela", "Se camufla tras una gran masa de enredaderas azules. Se dice que nunca dejan de crecer.", listOf(PokemonTipoFB.PLANTA), listOf(114,465)),
    PokemonFB(115,"1",R.drawable.kangaskhan, "Kangaskhan", "Cuida de su cría en la bolsa de su tripa. No evitará ninguna pelea para protegerla.", listOf(PokemonTipoFB.NORMAL), listOf(115)),
    PokemonFB(116,"1",R.drawable.horsea, "Horsea", "Si se siente en peligro, arrojará un potente chorro de agua, o de una tinta especial, por su boca.", listOf(PokemonTipoFB.AGUA), listOf(116,117,230)),
    PokemonFB(117,"1",R.drawable.seadra, "Seadra", "Tocar su aleta trasera causa parálisis. Se engancha al coral para mantenerse mientras duerme.", listOf(PokemonTipoFB.AGUA), listOf(116,117,230)),
    PokemonFB(118,"1",R.drawable.goldeen, "Goldeen", "En su época de puesta de huevos, suelen ser vistos nadando por ríos contracorriente en grandes grupos.", listOf(PokemonTipoFB.AGUA), listOf(118,119)),
    PokemonFB(119,"1",R.drawable.seaking, "Seaking", "Este Pokémon hace sus nidos tallando cantos de riachuelo con el cuerno de su cabeza.", listOf(PokemonTipoFB.AGUA), listOf(118,119)),
    PokemonFB(120,"1",R.drawable.staryu, "Staryu", "Mientras su parte central se mantenga intacta, crecerá de nuevo aunque haya sido destrozado.", listOf(PokemonTipoFB.AGUA), listOf(120,121)),
    PokemonFB(121,"1",R.drawable.starmie, "Starmie", "Su zona central es conocida como el núcleo. Se piensa que se comunica mediante colores.", listOf(PokemonTipoFB.AGUA, PokemonTipoFB.PSIQUICO), listOf(120,121)),
    PokemonFB(122,"1",R.drawable.mrmime, "Mr. Mime", "Siempre practica la misma pantomima. Hace creer al enemigo que existe algo que no es real.", listOf(PokemonTipoFB.PSIQUICO, PokemonTipoFB.HADA), listOf(439,122)),
    PokemonFB(123,"1",R.drawable.scyther, "Scyther", "Se agazapa en la hierba alta para saltar sobre su enemigo con sus guadañas. Se mueve como un ninja.", listOf(PokemonTipoFB.BICHO, PokemonTipoFB.VOLADOR), listOf(123,212,900)),
    PokemonFB(124,"1",R.drawable.jynx, "Jynx", "Parece moverse como si estuviera bailando un ritmo de su propia creación. Menea mucho sus caderas.", listOf(PokemonTipoFB.HIELO, PokemonTipoFB.PSIQUICO), listOf(238,124)),
    PokemonFB(125,"1",R.drawable.electabuzz, "Electabuzz", "Cuando hay un apagón, es más que posible que este Pokémon se haya comido la energía.", listOf(PokemonTipoFB.ELECTRICO), listOf(239,125,466)),
    PokemonFB(126,"1",R.drawable.magmar, "Magmar", "Nacen en volcanes activos. Su cuerpo parece una gran bola de fuego ya que están en llamas.", listOf(PokemonTipoFB.FUEGO), listOf(240,126,467)),
    PokemonFB(127,"1",R.drawable.pinsir, "Pinsir", "Atrapa a su presa con sus pinzas, y aprieta fuerte. No se puede mover si hace mucho frío.", listOf(PokemonTipoFB.BICHO), listOf(127)),
    PokemonFB(128,"1",R.drawable.tauros, "Tauros", "Un rudo Pokémon repleto de energía vital. Cuando corre, no para hasta que choca con algo.", listOf(PokemonTipoFB.NORMAL), listOf(128)),
    PokemonFB(129,"1",R.drawable.magikarp, "Magikarp", "Famoso por ser poco fiable. Puede encontrarse nadando en mares, lagos, ríos y charcos.", listOf(PokemonTipoFB.AGUA), listOf(129,130)),
    PokemonFB(130,"1",R.drawable.gyarados, "Gyarados", "Este Pokémon es enormemente destructivo. En la antigüedad, era conocido por destruir ciudades.", listOf(PokemonTipoFB.AGUA, PokemonTipoFB.VOLADOR), listOf(129,130)),
    PokemonFB(131,"1",R.drawable.lapras, "Lapras", "Este espíritu gentil es capaz de leer la mente. Puede llevar a la gente a través del mar.", listOf(PokemonTipoFB.AGUA, PokemonTipoFB.HIELO), listOf(131)),
    PokemonFB(132,"1",R.drawable.ditto, "Ditto", "Cuando se fija en un enemigo, su cuerpo se transforma en una copia perfecta del mismo.", listOf(PokemonTipoFB.NORMAL), listOf(132)),
    PokemonFB(133,"1",R.drawable.eevee, "Eevee", "Su código genético es muy inestable. Puede evolucionar en diversas razas de Pokémon.", listOf(PokemonTipoFB.NORMAL), listOf(133,134,135,136,196,197,470,471,700)),
    PokemonFB(134,"1",R.drawable.vaporeon, "Vaporeon", "Su estructura celular se parece a las moléculas de agua. Es invisible cuando está en el agua.", listOf(PokemonTipoFB.AGUA), listOf(133,134,135,136,196,197,470,471,700)),
    PokemonFB(135,"1",R.drawable.jolteon, "Jolteon", "Un Pokémon muy sensible. Se entristece o enfada con mucha facilidad, lo que le da energía.", listOf(PokemonTipoFB.ELECTRICO), listOf(133,134,135,136,196,197,470,471,700)),
    PokemonFB(136,"1",R.drawable.flareon, "Flareon", "El cuerpo de este Pokémon posee una cámara ígnea. Cuando exhala aire, éste está a 3.000º Celsius.", listOf(PokemonTipoFB.FUEGO), listOf(133,134,135,136,196,197,470,471,700)),
    PokemonFB(137,"1",R.drawable.porygon, "Porygon", "La gente dice que se trata del único Pokémon que puede volar por el espacio. Aún no lo ha logrado.", listOf(PokemonTipoFB.NORMAL), listOf(137,233,474)),
    PokemonFB(138,"1",R.drawable.omanyte, "Omanyte", "Este antiguo Pokémon fue recuperado de un fósil. Nada muy bien gracias al movimiento de sus 10 tentáculos.", listOf(PokemonTipoFB.ROCA, PokemonTipoFB.AGUA), listOf(138,139)),
    PokemonFB(139,"1",R.drawable.omastar, "Omastar", "Picos afilados rodean su boca. Su concha es demasiado grande como para que se mueva libremente.", listOf(PokemonTipoFB.ROCA, PokemonTipoFB.AGUA), listOf(138,139)),
    PokemonFB(140,"1",R.drawable.kabuto, "Kabuto", "Este Pokémon fue recuperado desde un fósil. Usa los ojos de su espalda al ocultarse en el lecho marino.", listOf(PokemonTipoFB.ROCA, PokemonTipoFB.AGUA), listOf(140,141)),
    PokemonFB(141,"1",R.drawable.kabutops, "Kabutops", "Este Pokémon es un hábil y rápido nadador. Atrapa a su presa para drenar sus fluidos vitales.", listOf(PokemonTipoFB.ROCA, PokemonTipoFB.AGUA), listOf(140,141)),
    PokemonFB(142,"1",R.drawable.aerodactyl, "Aerodactyl", "Este Pokémon salvaje, extinto hace siglos, fue resucitado usando ADN tomado de un ámbar.", listOf(PokemonTipoFB.ROCA, PokemonTipoFB.VOLADOR), listOf(142)),
    PokemonFB(143,"1",R.drawable.snorlax, "Snorlax", "Come cualquier cosa. Incluso la comida pasada de fecha. Su estómago nunca se llena.", listOf(PokemonTipoFB.NORMAL), listOf(446,143)),
    PokemonFB(144,"1",R.drawable.articuno, "Articuno", "Un legendario pájaro Pokémon. Congela el agua que encuentra en el aire para generar nieve.", listOf(PokemonTipoFB.HIELO, PokemonTipoFB.VOLADOR), listOf(144)),
    PokemonFB(145,"1",R.drawable.zapdos, "Zapdos", "Este legendario pájaro Pokémon solo aparece cuando el cielo se torna oscuro y caen rayos.", listOf(PokemonTipoFB.ELECTRICO, PokemonTipoFB.VOLADOR), listOf(145)),
    PokemonFB(146,"1",R.drawable.moltres, "Moltres", "Un legendario pájaro Pokémon. Cuando aletea sus flamígeras alas, la oscura noche se torna roja.", listOf(PokemonTipoFB.FUEGO, PokemonTipoFB.VOLADOR), listOf(146)),
    PokemonFB(147,"1",R.drawable.dratini, "Dratini", "La existencia de este Pokémon ha sido confirmada recientemente por un pescador que cogió uno.", listOf(PokemonTipoFB.DRAGON), listOf(147,148,149)),
    PokemonFB(148,"1",R.drawable.dragonair, "Dragonair", "De acuerdo con un testigo, un aura de extraña forma lo rodea, dándole un misterioso y místico aspecto.", listOf(PokemonTipoFB.DRAGON), listOf(147,148,149)),
    PokemonFB(149,"1",R.drawable.dragonite, "Dragonite", "Se dice que este Pokémon vive en algún lugar del mar, y que vuela. De todos modos, sólo es un rumor.", listOf(PokemonTipoFB.DRAGON, PokemonTipoFB.VOLADOR), listOf(147,148,149)),
    PokemonFB(150,"1",R.drawable.mewtwo, "Mewtwo", "Fue creado por un científico tras años de horribles experimentos de manipulación genética.", listOf(PokemonTipoFB.PSIQUICO), listOf(150)),
    PokemonFB(151,"1",R.drawable.mew, "Mew", "Se dice que contiene la composición genética de todos los Pokémon. Es muy raramente visto.", listOf(PokemonTipoFB.PSIQUICO), listOf(151)),
    PokemonFB(152,"2",R.drawable.chikorita, "Chikorita","Un dulce aroma se desprende de la hoja de su cabeza. Es dócil y le encanta absorber los rayos de sol.",listOf(PokemonTipoFB.PLANTA), listOf(152,153,154)),
    PokemonFB(153,"2",R.drawable.bayleef, "Bayleef","Su cuello huele a especias. Dicen que por alguna razón, su simple olor te incita a luchar.",listOf(PokemonTipoFB.PLANTA), listOf(152,153,154)),
    PokemonFB(154,"2",R.drawable.meganium, "Meganium","El olor que desprenden sus pétalos contiene una sustancia que calma el instinto agresivo.",listOf(PokemonTipoFB.PLANTA), listOf(152,153,154)),
    PokemonFB(155,"2",R.drawable.cyndaquil, "Cyndaquil","Es tímido y siempre se enrosca como una pelota. Si es atacado, enciende el lomo para protegerse.",listOf(PokemonTipoFB.FUEGO), listOf(155,156,157)),
    PokemonFB(156,"2",R.drawable.quilava, "Quilava","Ten cuidado si te da la espalda en combate. Significa que te va a atacar con su lomo de fuego.",listOf(PokemonTipoFB.FUEGO), listOf(155,156,157)),
    PokemonFB(157,"2",R.drawable.typhlosion, "Typhlosion","Si su furia crece, se calienta tanto que cualquier cosa que toque se prenderá al instante.",listOf(PokemonTipoFB.FUEGO), listOf(155,156,157)),
    PokemonFB(158,"2",R.drawable.totodile, "Totodile","Sus desarrolladas y potentes fauces puede romper cualquier cosa. Su Entrenador debe tener cuidado.",listOf(PokemonTipoFB.AGUA), listOf(158,159,160)),
    PokemonFB(159,"2",R.drawable.croconaw, "Croconaw","Si pierde un colmillo, uno nuevo crecerá en su lugar. Hay siempre 48 colmillos revistiendo su boca.",listOf(PokemonTipoFB.AGUA), listOf(158,159,160)),
    PokemonFB(160,"2",R.drawable.feraligatr, "Feraligatr","Le cuesta soportar su propio peso fuera del agua, así que va a cuatro patas. Aún así es rápido.",listOf(PokemonTipoFB.AGUA), listOf(158,159,160)),
    PokemonFB(161,"2",R.drawable.sentret, "Sentret","Es un Pokémon muy precavido. Se levanta apoyándose en la cola para tener una mejor vista de los alrededores.",listOf(PokemonTipoFB.NORMAL), listOf(161,162)),
    PokemonFB(162,"2",R.drawable.furret, "Furret","Construye un nido donde introducir su largo y delgado cuerpo, en el que no pueden entrar otros Pokémon.",listOf(PokemonTipoFB.NORMAL), listOf(161,162)),
    PokemonFB(163,"2",R.drawable.hoothoot, "Hoothoot","Se apoya en una sola pata y cuando hace el cambio, se mueve tan rápido que apenas se nota.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.VOLADOR), listOf(163,164)),
    PokemonFB(164,"2",R.drawable.noctowl, "Noctowl","Sus ojos se adaptan muy bien a la oscuridad; cuando hay poca luz, la condensan para poder ver.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.VOLADOR), listOf(163,164)),
    PokemonFB(165,"2",R.drawable.ledyba, "Ledyba","Es muy tímido. Tiene miedo de moverse cuando va solo. Pero si va en grupo, se vuelve muy activo.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.VOLADOR), listOf(165,166)),
    PokemonFB(166,"2",R.drawable.ledian, "Ledian","Se nutre de la luz de las estrellas. Cuanto más estrellada está la noche, más crecen los dibujos de su lomo.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.VOLADOR), listOf(165,166)),
    PokemonFB(167,"2",R.drawable.spinarak, "Spinarak","Mantiene la misma postura en su telaraña durante días, esperando a que se acerque una presa inocente.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.VENENO), listOf(167,168)),
    PokemonFB(168,"2",R.drawable.ariados, "Ariados","Pega hilos de seda a sus presas y las libera para seguirlas más tarde y localizar también a sus amigos.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.VENENO), listOf(167,168)),
    PokemonFB(169,"2",R.drawable.crobat, "Crobat","Es tan silencioso cuando vuela en la oscuridad con sus cuatro alas, que cuesta percibirlo cuando se acerca.",listOf(PokemonTipoFB.VENENO,PokemonTipoFB.VOLADOR), listOf(41,42,169)),
    PokemonFB(170,"2",R.drawable.chinchou, "Chinchou","Libera cargas positivas y negativas entre las puntas de las dos antenas que tiene, y electrocuta al enemigo.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.ELECTRICO), listOf(170,171)),
    PokemonFB(171,"2",R.drawable.lanturn, "Lanturn","La luz que emite es tan brillante que puede iluminar la superficie del mar desde unos 5 km de profundidad.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.ELECTRICO), listOf(170,171)),
    PokemonFB(172,"2",R.drawable.pichu, "Pichu","Todavía no domina el almacenamiento de electricidad, y descarga rayos cuando se divierte o se asusta.",listOf(PokemonTipoFB.ELECTRICO), listOf(172,25,26)),
    PokemonFB(173,"2",R.drawable.cleffa, "Cleffa","Por su inusual forma estrellada, la gente cree que procede de un meteorito que cayó a la tierra.",listOf(PokemonTipoFB.HADA), listOf(173,35,36)),
    PokemonFB(174,"2",R.drawable.igglybuff, "Igglybuff","Su cuerpo es muy blando. Cuando se pone a rodar, rebota contra todo y es imposible de parar.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.HADA), listOf(174,39,40)),
    PokemonFB(175,"2",R.drawable.togepi, "Togepi","El cascarón parece estar lleno de alegría. Dicen que trae buena suerte si se le trata con cariño.",listOf(PokemonTipoFB.HADA), listOf(175,176,468)),
    PokemonFB(176,"2",R.drawable.togetic, "Togetic","Dicen que aparece entre gentes cuidadosas y de buen corazón, a quienes inunda de felicidad.",listOf(PokemonTipoFB.HADA,PokemonTipoFB.VOLADOR), listOf(175,176,468)),
    PokemonFB(177,"2",R.drawable.natu, "Natu","Va dando saltitos porque sus alas no han crecido lo suficiente. Siempre está pendiente de algo.",listOf(PokemonTipoFB.PSIQUICO,PokemonTipoFB.VOLADOR), listOf(177,178)),
    PokemonFB(178,"2",R.drawable.xatu, "Xatu","Dicen que se mantiene quieto y en silencio porque observa el pasado y el futuro al mismo tiempo.",listOf(PokemonTipoFB.PSIQUICO,PokemonTipoFB.VOLADOR), listOf(177,178)),
    PokemonFB(179,"2",R.drawable.mareep, "Mareep","Cuando almacena electricidad en su organismo, duplica su volumen. Tócalo y recibirás una descarga.",listOf(PokemonTipoFB.ELECTRICO), listOf(179,180,181)),
    PokemonFB(180,"2",R.drawable.flaaffy, "Flaaffy","Como almacena tanta electricidad, ha desarrollado parches donde no crece ni la lana.",listOf(PokemonTipoFB.ELECTRICO), listOf(179,180,181)),
    PokemonFB(181,"2",R.drawable.ampharos, "Ampharos","El brillo de su cola es visible desde lejos. En la antigüedad se usaba mucho como faro.",listOf(PokemonTipoFB.ELECTRICO), listOf(179,180,181)),
    PokemonFB(182,"2",R.drawable.bellossom, "Bellossom","Los Bellossom suelen reunirse para bailar. Dicen que sus danzas son un ritual para invocar al sol.",listOf(PokemonTipoFB.PLANTA), listOf(43,44,45,182)),
    PokemonFB(183,"2",R.drawable.marill, "Marill","Usa el extremo de su cola como boya, así no se ahoga aunque lo arrastre una fuerte corriente.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.HADA), listOf(298,183,184)),
    PokemonFB(184,"2",R.drawable.azumarill, "Azumarill","Guardando silencio y prestando mucha atención puede saber lo que hay en los rápidos y salvajes ríos.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.HADA), listOf(298,183,184)),
    PokemonFB(185,"2",R.drawable.sudowoodo, "Sudowoodo","Aunque pretende ser un árbol, en su composición se parece más a una roca que a una planta.",listOf(PokemonTipoFB.ROCA), listOf(438,185)),
    PokemonFB(186,"2",R.drawable.politoed, "Politoed","Si Poliwag y Poliwhirl oyen su grito, responderán y se reunirán estén donde estén.",listOf(PokemonTipoFB.AGUA), listOf(60,61,62,186)),
    PokemonFB(187,"2",R.drawable.hoppip, "Hoppip","Para evitar ser arrastrados por el viento, se reúnen en grupos, aunque adoran las brisas suaves.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.VOLADOR), listOf(187,188,189)),
    PokemonFB(188,"2",R.drawable.skiploom, "Skiploom","Abre sus pétalos para absorber la luz solar. También flota en el aire para estar más cerca del sol.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.VOLADOR), listOf(187,188,189)),
    PokemonFB(189,"2",R.drawable.jumpluff, "Jumpluff","Se desplaza con los vientos estacionales y suelta sus esporas por todo el mundo para reproducirse.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.VOLADOR), listOf(187,188,189)),
    PokemonFB(190,"2",R.drawable.aipom, "Aipom","Vive en las copas de árboles gigantes. Mientras duerme, enrolla la cola en una rama para no caerse.",listOf(PokemonTipoFB.NORMAL), listOf(190,424)),
    PokemonFB(191,"2",R.drawable.sunkern, "Sunkern","Cae de repente del cielo por las mañanas. Los años de veranos suaves su número se multiplica.",listOf(PokemonTipoFB.PLANTA), listOf(191,192)),
    PokemonFB(192,"2",R.drawable.sunflora, "Sunflora","Convierte la luz solar en energía. En la oscuridad, tras el atardecer, cierra sus pétalos y queda inmóvil.",listOf(PokemonTipoFB.PLANTA), listOf(191,192)),
    PokemonFB(193,"2",R.drawable.yanma, "Yanma","Si agita muy rápido las alas, genera ondas expansivas capaces de hacer añicos las ventanas que haya cerca.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.VOLADOR), listOf(193,469)),
    PokemonFB(194,"2",R.drawable.wooper, "Wooper","Cuando anda por la tierra cubre su cuerpo con una capa venenosa para mantener hidratada su piel.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.TIERRA), listOf(194,195)),
    PokemonFB(195,"2",R.drawable.quagsire, "Quagsire","Este despreocupado Pokémon es de naturaleza tranquila. Siempre que nada, se choca con los barcos.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.TIERRA), listOf(194,195)),
    PokemonFB(196,"2",R.drawable.espeon, "Espeon","Basándose en las corrientes de aire predice cosas como el clima o el próximo ataque del enemigo.",listOf(PokemonTipoFB.PSIQUICO), listOf(133,134,135,136,196,197,470,471,700)),
    PokemonFB(197,"2",R.drawable.umbreon, "Umbreon","Cuando oscurece, los anillos de su cuerpo comienzan a brillar, asustando a cualquiera que se acerque.",listOf(PokemonTipoFB.SINIESTRO), listOf(133,134,135,136,196,197,470,471,700)),
    PokemonFB(198,"2",R.drawable.murkrow, "Murkrow","Temido y odiado por muchos, dicen que trae la desgracia a todos aquellos que lo ven por la noche.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.VOLADOR), listOf(198,430)),
    PokemonFB(199,"2",R.drawable.slowking, "Slowking","Al ser mordido en la cabeza, Slowpoke absorbió unas toxinas que liberaron su poder oculto.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.PSIQUICO), listOf(79,80,199)),
    PokemonFB(200,"2",R.drawable.misdreavus, "Misdreavus","Le gusta hacer travesuras como gritar y aullar por la noche, para asustar a la gente.",listOf(PokemonTipoFB.FANTASMA), listOf(200,429)),
    PokemonFB(201,"2",R.drawable.unown, "Unown","Su cuerpo fino y plano aparece siempre en los muros. Su forma parece tener algún significado.",listOf(PokemonTipoFB.PSIQUICO), listOf(201)),
    PokemonFB(202,"2",R.drawable.wobbuffet, "Wobbuffet","Para mantener oculta su negra cola, vive en silencio en la oscuridad. Nunca ataca primero.",listOf(PokemonTipoFB.PSIQUICO), listOf(360,202)),
    PokemonFB(203,"2",R.drawable.girafarig, "Girafarig","La cola, que también tiene un pequeño cerebro, muerde por su cuenta si nota un olor seductor.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.PSIQUICO), listOf(203,981)),
    PokemonFB(204,"2",R.drawable.pineco, "Pineco","Le gusta engrosar su coraza añadiendo cortezas de árbol. El aumento de peso no le molesta.",listOf(PokemonTipoFB.BICHO), listOf(204,205)),
    PokemonFB(205,"2",R.drawable.forretress, "Forretress","Todo su cuerpo está protegido por una concha de metal. Lo que esconde la concha es un misterio.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.ACERO), listOf(204,205)),
    PokemonFB(206,"2",R.drawable.dunsparce, "Dunsparce","Este Pokémon escapa perforando el suelo con la cola y enterrándose de espaldas, si es descubierto.",listOf(PokemonTipoFB.NORMAL), listOf(206,982)),
    PokemonFB(207,"2",R.drawable.gligar, "Gligar","A veces se sujeta a los precipicios. Cuando divisa una presa, despliega las alas y planea para atacar.",listOf(PokemonTipoFB.TIERRA,PokemonTipoFB.VOLADOR), listOf(207,472)),
    PokemonFB(208,"2",R.drawable.steelix, "Steelix","Su cuerpo ha sido comprimido en el interior de la tierra, y por eso es hasta más duro que el diamante.",listOf(PokemonTipoFB.TIERRA,PokemonTipoFB.ACERO), listOf(95,208)),
    PokemonFB(209,"2",R.drawable.snubbull, "Snubbull","Muy travieso por naturaleza, a muchas mujeres les gusta jugar con él porque es muy cariñoso.",listOf(PokemonTipoFB.HADA), listOf(209,210)),
    PokemonFB(210,"2",R.drawable.granbull, "Granbull","Como le pesan mucho los colmillos, se le va la cabeza hacia delante. Su mordisco es muy potente.",listOf(PokemonTipoFB.HADA), listOf(209,210)),
    PokemonFB(211,"2",R.drawable.qwilfish, "Qwilfish","Las pequeñas púas que cubren su cuerpo eran escamas. Inyectan una toxina que debilita.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.VENENO), listOf(211)),
    PokemonFB(212,"2",R.drawable.scizor, "Scizor","Mueve sus pinzas para asustar al enemigo. Por los dibujos de su cuerpo parece tener 3 cabezas.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.ACERO), listOf(123,212,900)),
    PokemonFB(213,"2",R.drawable.shuckle, "Shuckle","Suele ser dócil, pero si se le molesta mientras succiona miel, perseguirá con su cuerno al intruso.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.ROCA), listOf(213)),
    PokemonFB(214,"2",R.drawable.heracross, "Heracross","Forman grupos en los bosques para buscar savia de árboles, su comida favorita. Puede voltear a su presa.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.LUCHA), listOf(214)),
    PokemonFB(215,"2",R.drawable.sneasel, "Sneasel","Se alimenta de huevos robados en nidos. Clava sus afiladas garras en los puntos débiles de sus rivales.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.HIELO), listOf(215,461)),
    PokemonFB(216,"2",R.drawable.teddiursa, "Teddiursa","Cuando encuentra miel, le brilla la marca que tiene en la frente. Si se llena las garras de miel, se las lame.",listOf(PokemonTipoFB.NORMAL), listOf(216,217,901)),
    PokemonFB(217,"2",R.drawable.ursaring, "Ursaring","Capaz de percibir cualquier tipo de aroma, encuentra sin problemas todo alimento enterrado bajo tierra.",listOf(PokemonTipoFB.NORMAL), listOf(216,217,901)),
    PokemonFB(218,"2",R.drawable.slugma, "Slugma","No duerme nunca. Tiene que seguir moviéndose porque si se detiene, su cuerpo de lava podría enfriarse.",listOf(PokemonTipoFB.FUEGO), listOf(218,219)),
    PokemonFB(219,"2",R.drawable.magcargo, "Magcargo","En ocasiones, lanza por la resbaladiza coraza que tiene intensas llamaradas que recorren todo su cuerpo.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.ROCA), listOf(218,219)),
    PokemonFB(220,"2",R.drawable.swinub, "Swinub","Si percibe un aroma tentador, se tira de cabeza para encontrar el origen de dicho olor.",listOf(PokemonTipoFB.HIELO,PokemonTipoFB.TIERRA), listOf(220,221,473)),
    PokemonFB(221,"2",R.drawable.piloswine, "Piloswine","Como su largo vello corporal le impide ver con claridad, sigue atacando repetidamente.",listOf(PokemonTipoFB.HIELO,PokemonTipoFB.TIERRA), listOf(220,221,473)),
    PokemonFB(222,"2",R.drawable.corsola, "Corsola","Tiene muy buena puntería. Dispara agua a sus presas, hasta cuando se mueven, a más de 100 metros.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.ROCA), listOf(222)),
    PokemonFB(223,"2",R.drawable.remoraid, "Remoraid","En ocasiones, lanza por la resbaladiza coraza que tiene intensas llamaradas que recorren todo su cuerpo.",listOf(PokemonTipoFB.AGUA), listOf(223,224)),
    PokemonFB(224,"2",R.drawable.octillery, "Octillery","Instintivamente se escabulle entre las rocas. Si le entra sueño, robará la guarida de otro Octillery.",listOf(PokemonTipoFB.AGUA), listOf(223,224)),
    PokemonFB(225,"2",R.drawable.delibird, "Delibird","Anida en el borde de escarpados acantilados. Se pasa todo el día llevando comida a sus polluelos.",listOf(PokemonTipoFB.HIELO,PokemonTipoFB.VOLADOR), listOf(225)),
    PokemonFB(226,"2",R.drawable.mantine, "Mantine","Nada con gran elegancia e ignora a los Remoraid que se aferran a sus aletas buscando restos de comida.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.VOLADOR), listOf(458,226)),
    PokemonFB(227,"2",R.drawable.skarmory, "Skarmory","Sus fuertes alas parecen pesadas, aunque son huecas y ligeras, y le permiten volar libremente.",listOf(PokemonTipoFB.ACERO,PokemonTipoFB.VOLADOR), listOf(227)),
    PokemonFB(228,"2",R.drawable.houndour, "Houndour","Usa diferentes tipos de gritos para comunicarse con los de su especie o para seguir a su presa.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.FUEGO), listOf(228,229)),
    PokemonFB(229,"2",R.drawable.houndoom, "Houndoom","Hace mucho, la gente creía que sus horripilantes aullidos eran de la muerte personificada.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.FUEGO), listOf(228,229)),
    PokemonFB(230,"2",R.drawable.kingdra, "Kingdra","Duerme en el fondo del océano para recargarse de energía. Dicen que causa tornados cuando se levanta.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.DRAGON), listOf(116,117,230)),
    PokemonFB(231,"2",R.drawable.phanpy, "Phanpy","A pesar de su tamaño reducido, es tan fuerte que puede llevar a un humano a su espalda con facilidad.",listOf(PokemonTipoFB.TIERRA), listOf(231,232)),
    PokemonFB(232,"2",R.drawable.donphan, "Donphan","Cuanto más grandes son sus colmillos, mayor su estatus en la manada. Los colmillos tardan mucho en crecer.",listOf(PokemonTipoFB.TIERRA), listOf(231,232)),
    PokemonFB(233,"2",R.drawable.porygon2, "Porygon2","Esta versión mejorada de Porygon fue creada para explorar el espacio, aunque no puede volar.",listOf(PokemonTipoFB.NORMAL), listOf(137,233,474)),
    PokemonFB(234,"2",R.drawable.stantler, "Stantler","Su cornamenta cambia el flujo del aire para crear un espacio de realidad distorsionada.",listOf(PokemonTipoFB.NORMAL), listOf(234,899)),
    PokemonFB(235,"2",R.drawable.smeargle, "Smeargle","La punta de la cola rezuma un fluido especial. Lo pinta todo con este líquido para marcar su terreno.",listOf(PokemonTipoFB.NORMAL), listOf(235)),
    PokemonFB(236,"2",R.drawable.tyrogue, "Tyrogue","Famoso por su disposición a la lucha. Siempre tiene heridas por luchar con enemigos más grandes.",listOf(PokemonTipoFB.LUCHA), listOf(106, 107, 236, 237)),
    PokemonFB(237,"2",R.drawable.hitmontop, "Hitmontop","Si te quedas embobado con las suaves, elegantes y danzarinas patadas que da, puedes acabar lleno de magulladuras.",listOf(PokemonTipoFB.LUCHA), listOf(106, 107, 236, 237)),
    PokemonFB(238,"2",R.drawable.smoochum, "Smoochum","Sus labios son la parte más sensible de su cuerpo. Siempre los usa para examinar las cosas.",listOf(PokemonTipoFB.HIELO,PokemonTipoFB.PSIQUICO), listOf(238,124)),
    PokemonFB(239,"2",R.drawable.elekid, "Elekid","Entre sus cuernos pasa una débil corriente eléctrica. Quien ponga ahí la mano se dará un calambrazo.",listOf(PokemonTipoFB.ELECTRICO), listOf(239,125,466)),
    PokemonFB(240,"2",R.drawable.magby, "Magby","Aparece en los cráteres de los volcanes. Puede alcanzar los 600 grados de temperatura, así que no lo subestimes.",listOf(PokemonTipoFB.FUEGO), listOf(240,126,467)),
    PokemonFB(241,"2",R.drawable.miltank, "Miltank","Se dice que si un niño bebe leche de Miltank crecerá y se convertirá en un adulto sano y campechano.",listOf(PokemonTipoFB.NORMAL), listOf(241)),
    PokemonFB(242,"2",R.drawable.blissey, "Blissey","Cualquiera que pruebe un poco de huevo de Blissey, se volverá más amable y agradable con todos.",listOf(PokemonTipoFB.NORMAL), listOf(440,113,242)),
    PokemonFB(243,"2",R.drawable.raikou, "Raikou","Las nubes de lluvia que lleva le permiten lanzar rayos a voluntad. Dicen que apareció con un rayo.",listOf(PokemonTipoFB.ELECTRICO), listOf(243)),
    PokemonFB(244,"2",R.drawable.entei, "Entei","Cuando ladra, los volcanes entran en erupción. Como no puede controlar su poder, corre siempre en cabeza.",listOf(PokemonTipoFB.FUEGO), listOf(244)),
    PokemonFB(245,"2",R.drawable.suicune, "Suicune","Conocido como la reencarnación de los vientos del norte, puede purificar aguas turbias y sucias.",listOf(PokemonTipoFB.AGUA), listOf(245)),
    PokemonFB(246,"2",R.drawable.larvitar, "Larvitar","Nace muy profundo en el suelo, y no podrá salir hasta que se haya comido la tierra que le rodea.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.TIERRA), listOf(246, 247, 248)),
    PokemonFB(247,"2",R.drawable.pupitar, "Pupitar","Hasta encerrado en su coraza, se mueve libremente. Duro y rápido, su poder destructivo es enorme.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.TIERRA), listOf(246, 247, 248)),
    PokemonFB(248,"2",R.drawable.tyranitar, "Tyranitar","Tiene tanta fuerza que puede cambiar el paisaje. Su naturaleza insolente le hace ser muy egoísta.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.SINIESTRO), listOf(246, 247, 248)),
    PokemonFB(249,"2",R.drawable.lugia, "Lugia","Dicen que es el guardián de los mares. Hay rumores de que fue visto en una noche de tormenta.",listOf(PokemonTipoFB.PSIQUICO,PokemonTipoFB.VOLADOR), listOf(249)),
    PokemonFB(250,"2",R.drawable.hooh, "Ho-Oh","Cuenta la leyenda que este Pokémon vuela por el cielo con sus magníficas alas de siete colores.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.VOLADOR), listOf(250)),
    PokemonFB(251,"2",R.drawable.celebi, "Celebi","Este Pokémon vaga por el tiempo. La hierba y los árboles crecen por los campos por donde pasa.",listOf(PokemonTipoFB.PSIQUICO,PokemonTipoFB.PLANTA), listOf(251)),
    PokemonFB(252,"3",R.drawable.treecko, "Treecko","Escala superficies verticales muy rápido. Con la cola detecta la humedad y prevé el tiempo que va a hacer.",listOf(PokemonTipoFB.PLANTA), listOf(252, 253, 254)),
    PokemonFB(253,"3",R.drawable.grovyle, "Grovyle","Con su magnífica fuerza se desplaza saltando grácilmente de rama en rama por los árboles más altos.",listOf(PokemonTipoFB.PLANTA), listOf(252, 253, 254)),
    PokemonFB(254,"3",R.drawable.sceptile, "Sceptile","Corre con elegancia de un lugar a otro de la selva y usa las afiladas hojas de sus brazos para cazar.",listOf(PokemonTipoFB.PLANTA), listOf(252, 253, 254)),
    PokemonFB(255,"3",R.drawable.torchic, "Torchic","La bolsa de fuego que arde en su interior hace que al abrazarlo esté tan caliente como un calientapiés.",listOf(PokemonTipoFB.FUEGO), listOf(255, 256, 257)),
    PokemonFB(256,"3",R.drawable.combusken, "Combusken","Al pelear, el fuego de su interior se intensifica. Es capaz de propinar unas patadas demoledoras.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.LUCHA), listOf(255, 256, 257)),
    PokemonFB(257,"3",R.drawable.blaziken, "Blaziken","Ante un rival difícil, expulsa llamas por las muñecas. Tiene mucha fuerza en las patas; hasta puede saltar edificios.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.LUCHA), listOf(255, 256, 257)),
    PokemonFB(258,"3",R.drawable.mudkip, "Mudkip","La aleta de su cabeza detecta las corrientes de agua y los peligros. Tiene fuerza para levantar rocas.",listOf(PokemonTipoFB.AGUA), listOf(258, 259, 260)),
    PokemonFB(259,"3",R.drawable.marshtomp, "Marshtomp","Sus piernas robustas impiden que pierda el equilibrio y caiga, incluso en el barro. Duerme bajo la arena.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.TIERRA), listOf(258, 259, 260)),
    PokemonFB(260,"3",R.drawable.swampert, "Swampert","Con sus brazos duros como el acero puede partir rocas gigantescas en mil pedazos de un solo golpe.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.TIERRA), listOf(258, 259, 260)),
    PokemonFB(261,"3",R.drawable.poochyena, "Poochyena","Si se fija en una presa, no cejará hasta que se canse, pero si esta contraataca, se acobardará.",listOf(PokemonTipoFB.SINIESTRO), listOf(261, 262)),
    PokemonFB(262,"3",R.drawable.mightyena, "Mightyena","Forman manadas de diez individuos y cercan a sus presas valiéndose de un trabajo en equipo impecable.",listOf(PokemonTipoFB.SINIESTRO), listOf(261, 262)),
    PokemonFB(263,"3",R.drawable.zigzagoon, "Zigzagoon","Le llaman la atención muchas cosas, por lo que se mueve en zigzag. Se le da bien encontrar cosas.",listOf(PokemonTipoFB.NORMAL), listOf(263, 264)),
    PokemonFB(264,"3",R.drawable.linoone, "Linoone","Carga contra sus enemigos a más de 100 km por hora. Como solo va en línea recta, falla a menudo.",listOf(PokemonTipoFB.NORMAL), listOf(263, 264)),
    PokemonFB(265,"3",R.drawable.wurmple, "Wurmple","Es el blanco favorito de muchos Pokémon pájaro. Se defiende con el veneno de las púas de su cola.",listOf(PokemonTipoFB.BICHO), listOf(265, 266, 267, 268, 269)),
    PokemonFB(266,"3",R.drawable.silcoon, "Silcoon","Se agarra con su seda a las ramas de un árbol y espera su evolución bebiendo agua de lluvia.",listOf(PokemonTipoFB.BICHO), listOf(265, 266, 267)),
    PokemonFB(267,"3",R.drawable.beautifly, "Beautifly","Aunque no lo parece, es un Pokémon agresivo. Si se le molesta cuando recoge polen, atacará.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.VOLADOR), listOf(265, 266, 267)),
    PokemonFB(268,"3",R.drawable.cascoon, "Cascoon","Jamás olvida a quienes lo atacaron mientras estaba en su capullo. Cuando evoluciona busca venganza.",listOf(PokemonTipoFB.BICHO), listOf(265, 268, 269)),
    PokemonFB(269,"3",R.drawable.dustox, "Dustox","Bate las alas para esparcir polvo tóxico. De noche se come las hojas de los árboles de las avenidas.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.VENENO), listOf(265, 268, 269)),
    PokemonFB(270,"3",R.drawable.lotad, "Lotad","Como la hoja de su cabeza se hizo muy grande y pesada, empezó a vivir flotando en el agua.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.PLANTA), listOf(270, 271, 272)),
    PokemonFB(271,"3",R.drawable.lombre, "Lombre","Pokémon nocturno que entra en acción al caer la tarde. Se alimenta de musgos del lecho de los ríos.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.PLANTA), listOf(270, 271, 272)),
    PokemonFB(272,"3",R.drawable.ludicolo, "Ludicolo","Cuando oye música alegre sus músculos se llenan de energía y no puede evitar ponerse a bailar.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.PLANTA), listOf(270, 271, 272)),
    PokemonFB(273,"3",R.drawable.seedot, "Seedot","Se cuelga de las ramas con el extremo de su cabeza. A veces se cae cuando soplan vientos fuertes.",listOf(PokemonTipoFB.PLANTA), listOf(273, 274, 275)),
    PokemonFB(274,"3",R.drawable.nuzleaf, "Nuzleaf","Cuando usa la hoja de su cabeza como flauta asusta a la gente. Vive en lo más profundo de los bosques.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.SINIESTRO), listOf(273, 274, 275)),
    PokemonFB(275,"3",R.drawable.shiftry, "Shiftry","Vive sigiloso en lo más profundo del bosque. Dicen que con sus abanicos puede generar vientos gélidos.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.SINIESTRO), listOf(273, 274, 275)),
    PokemonFB(276,"3",R.drawable.taillow, "Taillow","Es un Pokémon valiente que no teme a los rivales fuertes. Vuela en busca de climas templados.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.VOLADOR), listOf(276, 277)),
    PokemonFB(277,"3",R.drawable.swellow, "Swellow","Vive en los bosques. Si encuentra una presa, se lanza en picado y la atrapa con sus garras.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.VOLADOR), listOf(276, 277)),
    PokemonFB(278,"3",R.drawable.wingull, "Wingull","Aprovecha las corrientes ascendentes para ganar altura. Suele llevar comida en el pico.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.VOLADOR), listOf(278, 279)),
    PokemonFB(279,"3",R.drawable.pelipper, "Pelipper","Protege a sus crías de los enemigos metiéndolos en su pico. En días de poco oleaje reposa sobre el agua.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.VOLADOR), listOf(278, 279)),
    PokemonFB(280,"3",R.drawable.ralts, "Ralts","Si sus cuernos perciben emociones positivas de personas o Pokémon, su cuerpo se calienta un poco.",listOf(PokemonTipoFB.PSIQUICO,PokemonTipoFB.HADA), listOf(280, 281, 475, 282)),
    PokemonFB(281,"3",R.drawable.kirlia, "Kirlia","Si su entrenador está contento, se llena de energía y baila de forma alegre dando giros.",listOf(PokemonTipoFB.PSIQUICO,PokemonTipoFB.HADA), listOf(280, 281, 475, 282)),
    PokemonFB(282,"3",R.drawable.gardevoir, "Gardevoir","Para proteger a su Entrenador emplea todo su poder psíquico en crear un pequeño agujero negro.",listOf(PokemonTipoFB.PSIQUICO,PokemonTipoFB.HADA), listOf(280, 281, 282)),
    PokemonFB(283,"3",R.drawable.surskit, "Surskit","Del extremo de su cabeza mana un líquido de aroma almibarado. Vive en estanques repletos de plantas.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.AGUA), listOf(283, 284)),
    PokemonFB(284,"3",R.drawable.masquerain, "Masquerain","Sus antenas tienen dibujos de ojos, mientras que sus alas le permiten volar en cualquier dirección.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.VOLADOR), listOf(283, 284)),
    PokemonFB(285,"3",R.drawable.shroomish, "Shroomish","Si presiente peligro, se protege esparciendo esporas venenosas desde la parte superior de su cabeza.",listOf(PokemonTipoFB.PLANTA), listOf(285, 286)),
    PokemonFB(286,"3",R.drawable.breloom, "Breloom","Esparce esporas venenosas muy nocivas y asesta puñetazos de gran intensidad a sus enemigos.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.LUCHA), listOf(285, 286)),
    PokemonFB(287,"3",R.drawable.slakoth, "Slakoth","Si se come tres hojas al día ya queda satisfecho. Aparte de eso, se pasa durmiendo 20 horas al día.",listOf(PokemonTipoFB.NORMAL), listOf(287, 288, 289)),
    PokemonFB(288,"3",R.drawable.vigoroth, "Vigoroth","El Pokémon más perezoso del mundo. Si está tumbado, es que reúne fuerzas para contraatacar.",listOf(PokemonTipoFB.NORMAL), listOf(287, 288, 289)),
    PokemonFB(289,"3",R.drawable.slaking, "Slaking","Su corazón late a un ritmo diez veces más rápido de lo normal. No se está quieto ni un instante.",listOf(PokemonTipoFB.NORMAL), listOf(287, 288, 289)),
    PokemonFB(290,"3",R.drawable.nincada, "Nincada","Crece bajo tierra y explora el entorno con sus antenas, que sustituyen a ojos atrofiados.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.TIERRA), listOf(290, 291, 292)),
    PokemonFB(291,"3",R.drawable.ninjask, "Ninjask","Escuchar su zumbido de forma continuada provoca jaquecas. Casi no se le ve de lo rápido que es.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.VOLADOR), listOf(290, 291, 292)),
    PokemonFB(292,"3",R.drawable.shedinja, "Shedinja","Es un Pokémon muy peculiar; aparece de repente en una Poké Ball cuando Nincada evoluciona.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.FANTASMA), listOf(290, 291, 292)),
    PokemonFB(293,"3",R.drawable.whismur, "Whismur","Cuando percibe peligro, lanza gritos con volumen similar al de un reactor e intimida a sus enemigos.",listOf(PokemonTipoFB.NORMAL), listOf(293, 294, 295)),
    PokemonFB(294,"3",R.drawable.loudred, "Loudred","Las ondas de sus gritos pueden voltear a un camión. Patea el suelo para ganar potencia.",listOf(PokemonTipoFB.NORMAL), listOf(293, 294, 295)),
    PokemonFB(295,"3",R.drawable.exploud, "Exploud","El bramido que emite al atacar puede sacudir la tierra con la intensidad de un terremoto.",listOf(PokemonTipoFB.NORMAL), listOf(293, 294, 295)),
    PokemonFB(296,"3",R.drawable.makuhita, "Makuhita","Endurece su cuerpo golpeando grandes árboles. Cerca de su hogar suele haber árboles golpeados.",listOf(PokemonTipoFB.LUCHA), listOf(296, 297)),
    PokemonFB(297,"3",R.drawable.hariyama, "Hariyama","Le encanta enfrentarse a Pokémon grandes y probar su fuerza. Sus brazos pueden derribar un camión.",listOf(PokemonTipoFB.LUCHA), listOf(296, 297)),
    PokemonFB(298,"3",R.drawable.azurill, "Azurill","Su cola rebota como una pelota. Para luchar contra enemigos más grandes, la agita en el aire.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.HADA), listOf(298,183,184)),
    PokemonFB(299,"3",R.drawable.nosepass, "Nosepass","Se protege del peligro aumentando su magnetismo y atrayendo objetos de hierro hacia sí.",listOf(PokemonTipoFB.ROCA), listOf(299, 476)),
    PokemonFB(300,"3",R.drawable.skitty, "Skitty","No puede evitar ir tras las cosas que se mueven. Hasta corre en círculos persiguiéndose la cola.",listOf(PokemonTipoFB.NORMAL), listOf(300, 301)),
    PokemonFB(301,"3",R.drawable.delcatty, "Delcatty","Tiene mucho éxito entre las entrenadoras por su suave pelaje. No vive en un sitio fijo.",listOf(PokemonTipoFB.NORMAL), listOf(300, 301)),
    PokemonFB(302,"3",R.drawable.sableye, "Sableye","Hace su guarida en cuevas oscuras. Usa sus afiladas garras para desenterrar las gemas que se come.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.FANTASMA), listOf(302, 778)),
    PokemonFB(303,"3",R.drawable.mawile, "Mawile","Las grandes fauces de su cabeza están formadas por cuernos. Puede romper el hierro con ellas.",listOf(PokemonTipoFB.ACERO,PokemonTipoFB.HADA), listOf(303, 779)),
    PokemonFB(304,"3",R.drawable.aron, "Aron","Suele vivir en lugares inaccesibles de las montañas, pero el hambre lo empuja a comer raíles y coches.",listOf(PokemonTipoFB.ACERO,PokemonTipoFB.ROCA), listOf(304, 305, 306)),
    PokemonFB(305,"3",R.drawable.lairon, "Lairon","Le encanta comer hierro. Lucha por su territorio embistiendo a sus rivales con su cuerpo de acero.",listOf(PokemonTipoFB.ACERO,PokemonTipoFB.ROCA), listOf(304, 305, 306)),
    PokemonFB(306,"3",R.drawable.aggron, "Aggron","Se puede calcular su edad por la longitud de sus cuernos de acero. Su territorio es toda una montaña.",listOf(PokemonTipoFB.ACERO,PokemonTipoFB.ROCA), listOf(304, 305, 306)),
    PokemonFB(307,"3",R.drawable.meditite, "Meditite","Se entrena en la profundidad de las montañas. Cuando aumenta su poder espiritual con meditación, levita.",listOf(PokemonTipoFB.LUCHA,PokemonTipoFB.PSIQUICO), listOf(307, 308)),
    PokemonFB(308,"3",R.drawable.medicham, "Medicham","Perfecciona su poder espiritual con una meditación diaria. Puede sentir lo que piensan los demás.",listOf(PokemonTipoFB.LUCHA,PokemonTipoFB.PSIQUICO), listOf(307, 308)),
    PokemonFB(309,"3",R.drawable.electrike, "Electrike","Almacena electricidad estática en su pelaje. En estaciones secas, suelta chispas por todo el cuerpo.",listOf(PokemonTipoFB.ELECTRICO), listOf(309, 310)),
    PokemonFB(310,"3",R.drawable.manectric, "Manectric","Se dice que coloca sus nidos donde caen rayos. Descarga electricidad desde su melena.",listOf(PokemonTipoFB.ELECTRICO), listOf(309, 310)),
    PokemonFB(311,"3",R.drawable.plusle, "Plusle","Anima a sus compañeros con pompones de chispas. Roba energía de los postes telefónicos.",listOf(PokemonTipoFB.ELECTRICO), listOf(311, 312)),
    PokemonFB(312,"3",R.drawable.minun, "Minun","La electricidad de Minun y Plusle es buena para la circulación y para desentumecer músculos.",listOf(PokemonTipoFB.ELECTRICO), listOf(311, 312)),
    PokemonFB(313,"3",R.drawable.volbeat, "Volbeat","Se comunica con otros iluminando su cola por la noche. Le encanta el suave aroma de Illumise.",listOf(PokemonTipoFB.BICHO), listOf(313)),
    PokemonFB(314,"3",R.drawable.illumise, "Illumise","Con su dulce aroma guía a Volbeat para que tracen hasta 200 dibujos distintos en el cielo nocturno.",listOf(PokemonTipoFB.BICHO), listOf(314)),
    PokemonFB(315,"3",R.drawable.roselia, "Roselia","Si goza de mejor salud, el aroma de sus flores será más agradable. Es un aroma que relaja a la gente.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.VENENO), listOf(406, 315, 407)),
    PokemonFB(316,"3",R.drawable.gulpin, "Gulpin","Sus sesos y su corazón son diminutos; es casi todo estómago. Sus jugos gástricos disuelven lo que sea.",listOf(PokemonTipoFB.VENENO), listOf(316, 317)),
    PokemonFB(317,"3",R.drawable.swalot, "Swalot","Se traga cualquier cosa de una pieza. Sus poros segregan fluidos tóxicos que dañan a sus enemigos.",listOf(PokemonTipoFB.VENENO), listOf(316, 317)),
    PokemonFB(318,"3",R.drawable.carvanha, "Carvanha","Rodean a los enemigos que osan invadir su territorio. Sus afilados colmillos dañan los barcos.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.SINIESTRO), listOf(318, 319)),
    PokemonFB(319,"3",R.drawable.sharpedo, "Sharpedo","Con sus colmillos puede atravesar el acero. Nada a 120 Km por hora. Le llaman el terror de los mares.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.SINIESTRO), listOf(318, 319)),
    PokemonFB(320,"3",R.drawable.wailmer, "Wailmer","En días soleados se tumba en las playas para jugar y botar como una pelota. Lanza agua por la nariz.",listOf(PokemonTipoFB.AGUA), listOf(320, 321)),
    PokemonFB(321,"3",R.drawable.wailord, "Wailord","Es el más grande de los Pokémon. Puede nadar a una profundidad de 3000 m aguantando la respiración.",listOf(PokemonTipoFB.AGUA), listOf(320, 321)),
    PokemonFB(322,"3",R.drawable.numel, "Numel","Acumula magma en ebullición en la joroba de su lomo que transforma en una energía extraordinaria.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.TIERRA), listOf(322, 323)),
    PokemonFB(323,"3",R.drawable.camerupt, "Camerupt","Vive en cráteres de volcanes. Es famoso por las jorobas de su lomo, que entran en erupción cada diez años.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.TIERRA), listOf(322, 323)),
    PokemonFB(324,"3",R.drawable.torkoal, "Torkoal","Quema carbón en su caparazón para obtener energía. Si le atacan, echa un denso humo negro.",listOf(PokemonTipoFB.FUEGO), listOf(324)),
    PokemonFB(325,"3",R.drawable.spoink, "Spoink","Bota usando su cola para mantener el latido de su corazón. Lleva una perla de Clamperl en la cabeza.",listOf(PokemonTipoFB.PSIQUICO), listOf(325, 326)),
    PokemonFB(326,"3",R.drawable.grumpig, "Grumpig","Usa perlas negras para potenciar sus poderes psíquicos. Con su raro baile controla a los rivales.",listOf(PokemonTipoFB.PSIQUICO), listOf(325, 326)),
    PokemonFB(327,"3",R.drawable.spinda, "Spinda","La probabilidad de que dos Spinda con dibujos idénticos en su pelaje se encuentren es casi inexistente.",listOf(PokemonTipoFB.NORMAL), listOf(327)),
    PokemonFB(328,"3",R.drawable.trapinch, "Trapinch","Si una presa cae en las fosas cóncavas de arena que cava en el desierto no podrá salir de ellas.",listOf(PokemonTipoFB.TIERRA), listOf(328, 329, 330)),
    PokemonFB(329,"3",R.drawable.vibrava, "Vibrava","Genera ondas ultrasónicas al batir las alas violentamente, causando intensos dolores de cabeza.",listOf(PokemonTipoFB.TIERRA,PokemonTipoFB.DRAGON), listOf(328, 329, 330)),
    PokemonFB(330,"3",R.drawable.flygon, "Flygon","El batir de sus alas suena como un canto de mujer. Se le conoce como el Alma del Desierto.",listOf(PokemonTipoFB.TIERRA,PokemonTipoFB.DRAGON), listOf(328, 329, 330)),
    PokemonFB(331,"3",R.drawable.cacnea, "Cacnea","Habita en el desierto. Aguanta treinta días sin agua gracias a la que almacena en su cuerpo.",listOf(PokemonTipoFB.PLANTA), listOf(331, 332)),
    PokemonFB(332,"3",R.drawable.cacturne, "Cacturne","Es un Pokémon nocturno. Busca presas agotadas por el calor diurno del desierto.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.SINIESTRO), listOf(331, 332)),
    PokemonFB(333,"3",R.drawable.swablu, "Swablu","Si su cuerpo o su entorno no están limpios, no puede relajarse. Utiliza sus alas para limpiar la suciedad.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.VOLADOR), listOf(333, 334)),
    PokemonFB(334,"3",R.drawable.altaria, "Altaria","Cuando vuela, parece una nube de algodón. Entona bellas melodías con su voz de soprano.",listOf(PokemonTipoFB.DRAGON,PokemonTipoFB.VOLADOR), listOf(333, 334)),
    PokemonFB(335,"3",R.drawable.zangoose, "Zangoose","Se le eriza todo el pelaje con solo oler un Seviper. Con sus afiladas zarpas puede rajar a sus enemigos.",listOf(PokemonTipoFB.NORMAL), listOf(335)),
    PokemonFB(336,"3",R.drawable.seviper, "Seviper","Se ha enfrentado durante muchos años a Zangoose. Usa rocas para mantener afilada su cola.",listOf(PokemonTipoFB.VENENO), listOf(336)),
    PokemonFB(337,"3",R.drawable.lunatone, "Lunatone","Se piensa que está muy influido por las fases lunares, ya que solo actúa en noches de luna llena.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.PSIQUICO), listOf(337)),
    PokemonFB(338,"3",R.drawable.solrock, "Solrock","Una nueva especie de Pokémon que se rumorea procede del Sol. Emite luz al girar.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.PSIQUICO), listOf(338)),
    PokemonFB(339,"3",R.drawable.barboach, "Barboach","Los bigotes de Barboach le permiten saborear los alimentos como si fueran una lengua humana.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.TIERRA), listOf(339, 340)),
    PokemonFB(340,"3",R.drawable.whiscash, "Whiscash","Habita en grandes pantanos. Si se acerca un enemigo, se alborota y causa temblores monumentales.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.TIERRA), listOf(339, 340)),
    PokemonFB(341,"3",R.drawable.corphish, "Corphish","Llegó del extranjero y se halla en estado salvaje. Puede vivir hasta en los ríos más sucios.",listOf(PokemonTipoFB.AGUA), listOf(341, 342)),
    PokemonFB(342,"3",R.drawable.crawdaunt, "Crawdaunt","Este malandrín usa sus pinzas para atosigar y expulsar a los otros Pokémon que viven en su estanque.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.SINIESTRO), listOf(341, 342)),
    PokemonFB(343,"3",R.drawable.baltoy, "Baltoy","Se mueve girando sobre su eje. Es un extraño Pokémon que fue encontrado en unas viejas ruinas.",listOf(PokemonTipoFB.TIERRA,PokemonTipoFB.PSIQUICO), listOf(343, 344)),
    PokemonFB(344,"3",R.drawable.claydol, "Claydol","Este Pokémon es una vieja figurilla de barro que cobró vida mediante la exposición a extraños rayos de luz.",listOf(PokemonTipoFB.TIERRA,PokemonTipoFB.PSIQUICO), listOf(343, 344)),
    PokemonFB(345,"3",R.drawable.lileep, "Lileep","Vivió en los fondos marinos hace unos 100 millones de años y fue recreado científicamente.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.PLANTA), listOf(345, 346)),
    PokemonFB(346,"3",R.drawable.cradily, "Cradily","Vive en el fondo de los mares de aguas templadas. Emerge para cazar cuando baja la marea.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.PLANTA), listOf(345, 346)),
    PokemonFB(347,"3",R.drawable.anorith, "Anorith","Pokémon de origen prehistórico. Al pasar a vivir en el agua, sus ocho patas se convirtieron en alas.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.BICHO), listOf(347, 348)),
    PokemonFB(348,"3",R.drawable.armaldo, "Armaldo","Tras evolucionar, este Pokémon fue a tierra firme. Una dura coraza protege todo su cuerpo.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.BICHO), listOf(347, 348)),
    PokemonFB(349,"3",R.drawable.feebas, "Feebas","Su apariencia deja bastante que desear, pero es muy resistente y puede sobrevivir con poca agua.",listOf(PokemonTipoFB.AGUA), listOf(349, 350)),
    PokemonFB(350,"3",R.drawable.milotic, "Milotic","Se dice que su hermosa figura puede apaciguar el corazón de aquellos que tienen un carácter agriado.",listOf(PokemonTipoFB.AGUA), listOf(349, 350)),
    PokemonFB(351,"3",R.drawable.castform, "Castform","La meteorología determina su aspecto. Hace poco se ha sabido que sus células son como el agua.",listOf(PokemonTipoFB.NORMAL), listOf(351)),
    PokemonFB(352,"3",R.drawable.kecleon, "Kecleon","Puede mudar el color de su cuerpo a voluntad, pero el dibujo en zigzag de su panza nunca desaparece.",listOf(PokemonTipoFB.NORMAL), listOf(352)),
    PokemonFB(353,"3",R.drawable.shuppet, "Shuppet","Dicen que con su cuerno se alimenta de sentimientos de celos y envidia. Es muy activo a medianoche.",listOf(PokemonTipoFB.FANTASMA), listOf(353, 354)),
    PokemonFB(354,"3",R.drawable.banette, "Bannette","Este muñeco se convirtió en un Pokémon cuando lo tiraron a la basura. Busca a su antiguo dueño.",listOf(PokemonTipoFB.FANTASMA), listOf(353, 354)),
    PokemonFB(355,"3",R.drawable.duskull, "Duskull","Persigue a su presa como un perro allá donde vaya. No obstante, abandona la caza al amanecer.",listOf(PokemonTipoFB.FANTASMA), listOf(355, 356, 477)),
    PokemonFB(356,"3",R.drawable.dusclops, "Dusclops","Su cuerpo está hueco. Se dice que quien mire dentro, será tragado por un agujero negro.",listOf(PokemonTipoFB.FANTASMA), listOf(355, 356, 477)),
    PokemonFB(357,"3",R.drawable.tropius, "Tropius","Los racimos de su cuello dan fruto cada 6 meses. A los niños de zonas tropicales les encanta su dulzor.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.VOLADOR), listOf(357)),
    PokemonFB(358,"3",R.drawable.chimecho, "Chimecho","Sus gritos resuenan en su cuerpo hueco y emergen como hermosas notas que aturden a los enemigos.",listOf(PokemonTipoFB.PSIQUICO), listOf(358, 433)),
    PokemonFB(359,"3",R.drawable.absol, "Absol","Cuando se supo que presentía los desastres con su cuerno, tuvo que buscar refugio en las montañas.",listOf(PokemonTipoFB.SINIESTRO), listOf(359, 779)),
    PokemonFB(360,"3",R.drawable.wynaut, "Wynaut","Suelen ir en grupo. Templan su paciencia jugando a empujarse los unos a los otros.",listOf(PokemonTipoFB.PSIQUICO), listOf(360, 202)),
    PokemonFB(361,"3",R.drawable.snorunt, "Snorunt","En las zonas nevadas, las leyendas dicen que si un Snorunt vive en una casa, trae prosperidad.",listOf(PokemonTipoFB.HIELO), listOf(361, 362, 478)),
    PokemonFB(362,"3",R.drawable.glalie, "Glalie","Congela a sus presas enfriando en un momento la humedad contenida en el aire que lo rodea.",listOf(PokemonTipoFB.HIELO), listOf(361, 362)),
    PokemonFB(363,"3",R.drawable.spheal, "Spheal","Rueda por los témpanos de hielo hasta la orilla, ya que su cuerpo no está bien adaptado para nadar.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.HIELO), listOf(363, 364, 365)),
    PokemonFB(364,"3",R.drawable.sealeo, "Sealeo","Su nariz es muy sensible. Cuando ve algo por primera vez, lo toca con ella para recordarlo después.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.HIELO), listOf(363, 364, 365)),
    PokemonFB(365,"3",R.drawable.walrein, "Walrein","Sus fuertes colmillos destrozan los témpanos hielo. Su capa de grasa lo protege de sus enemigos.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.HIELO), listOf(363, 364, 365)),
    PokemonFB(366,"3",R.drawable.clamperl, "Clamperl","Durante toda su vida, crea una sola perla que, según se dice, aumenta los poderes psíquicos.",listOf(PokemonTipoFB.AGUA), listOf(366, 367, 368)),
    PokemonFB(367,"3",R.drawable.huntail, "Huntail","Vive en oscuros abismos marinos. Usa su cola como si fuera un ser vivo para atraer a sus presas.",listOf(PokemonTipoFB.AGUA), listOf(366, 367)),
    PokemonFB(368,"3",R.drawable.gorebyss, "Gorebyss","Su cuerpo se torna de un rosa vivo en primavera debido a que aumenta la temperatura del fondo del mar.",listOf(PokemonTipoFB.AGUA), listOf(366, 368)),
    PokemonFB(369,"3",R.drawable.relicanth, "Relicanth","Un Pokémon raro descubierto en una exploración marina. No ha cambiado en más de 100 millones de años.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.ROCA), listOf(369)),
    PokemonFB(370,"3",R.drawable.luvdisc, "Luvdisc","Popular por su forma de corazón. En algunos sitios es costumbre que las parejas se regalen Luvdisc.",listOf(PokemonTipoFB.AGUA), listOf(370)),
    PokemonFB(371,"3",R.drawable.bagon, "Bagon","Su desarrollado cuello y su cabeza dura como el acero le permiten reducir a añicos rocas enormes.",listOf(PokemonTipoFB.DRAGON), listOf(371, 372, 373)),
    PokemonFB(372,"3",R.drawable.shelgon, "Shelgon","Las células han empezado a cambiar dentro de su dura concha, que se separa cuando evoluciona.",listOf(PokemonTipoFB.DRAGON), listOf(371, 372, 373)),
    PokemonFB(373,"3",R.drawable.salamence, "Salamence","Si se enfada, no hay forma de que se calme. Echa a volar e incendia campos y montañas desde el cielo.",listOf(PokemonTipoFB.DRAGON,PokemonTipoFB.VOLADOR), listOf(371, 372, 373)),
    PokemonFB(374,"3",R.drawable.beldum, "Beldum","Se comunican mediante pulsos magnéticos. Cuando van en grupos, se mueven al unísono.",listOf(PokemonTipoFB.ACERO,PokemonTipoFB.PSIQUICO), listOf(374, 375, 376)),
    PokemonFB(375,"3",R.drawable.metang, "Metang","Lo forman dos Beldum unidos. Puede chocarse con un avión sin que su cuerpo de acero sufra ni rasguño.",listOf(PokemonTipoFB.ACERO,PokemonTipoFB.PSIQUICO), listOf(374, 375, 376)),
    PokemonFB(376,"3",R.drawable.metagross, "Metagross","Está formado por varios Metang. Con cuatro cerebros, tiene la inteligencia de un superordenador.",listOf(PokemonTipoFB.ACERO,PokemonTipoFB.PSIQUICO), listOf(374, 375, 376)),
    PokemonFB(377,"3",R.drawable.regirock, "Regirock","Las rocas que componen el cuerpo de Regirock pueden encontrarse en todos los estratos geológicos.",listOf(PokemonTipoFB.ROCA), listOf(377)),
    PokemonFB(378,"3",R.drawable.regice, "Regice","Dicen que ha yacido durmiendo en un glaciar durante milenios. Ni el magma puede derretir su cuerpo.",listOf(PokemonTipoFB.HIELO), listOf(378)),
    PokemonFB(379,"3",R.drawable.registeel, "Registeel","Su cuerpo ha estado sometido a la presión subterránea durante miles de años y no puede arañarse.",listOf(PokemonTipoFB.ACERO), listOf(379)),
    PokemonFB(380,"3",R.drawable.latias, "Latias","Se comunica por telepatía. Su plumaje refleja la luz, lo que le permite hacerse invisible.",listOf(PokemonTipoFB.DRAGON,PokemonTipoFB.PSIQUICO), listOf(380)),
    PokemonFB(381,"3",R.drawable.latios, "Latios","Es muy inteligente y entiende el lenguaje humano. Es un Pokémon muy dócil y no le gusta nada combatir.",listOf(PokemonTipoFB.DRAGON,PokemonTipoFB.PSIQUICO), listOf(381)),
    PokemonFB(382,"3",R.drawable.kyogre, "Kyogre","Se dice que aumentó el nivel del mar a base de aguaceros. Ha estado durmiendo en una fosa marina.",listOf(PokemonTipoFB.AGUA), listOf(382, 780)),
    PokemonFB(383,"3",R.drawable.groudon, "Groudon","Dicen que este Pokémon legendario simboliza la tierra. Tras batirse en duelo con Kyogre se echó a dormir.",listOf(PokemonTipoFB.TIERRA), listOf(383, 781)),
    PokemonFB(384,"3",R.drawable.rayquaza, "Rayquaza","Ha vivido durante cientos de millones de años en la capa de ozono. Cuando vuela, parece un meteorito.",listOf(PokemonTipoFB.DRAGON,PokemonTipoFB.VOLADOR), listOf(384, 782)),
    PokemonFB(385,"3",R.drawable.jirachi, "Jirachi","Desde antaño se dice que concederá los deseos escritos en las notas de su cabeza cuando se despierte.",listOf(PokemonTipoFB.ACERO,PokemonTipoFB.PSIQUICO), listOf(385)),
    PokemonFB(386,"3",R.drawable.deoxys, "Deoxys","Surgió a raíz de la mutación de ADN de un virus alienígena que cayó a la Tierra en un meteorito.",listOf(PokemonTipoFB.PSIQUICO), listOf(386)),
    PokemonFB(387,"4",R.drawable.turtwig, "Turtwig","Realiza la fotosíntesis para obtener oxígeno. Si tiene sed, las hojas de la cabeza se marchitan.",listOf(PokemonTipoFB.TIERRA), listOf(387, 388, 389)),
    PokemonFB(388,"4",R.drawable.grotle, "Grotle","Sabe dónde encontrar manantiales de agua pura y lleva a los Pokémon amigos hasta allí en su lomo.",listOf(PokemonTipoFB.TIERRA), listOf(387, 388, 389)),
    PokemonFB(389,"4",R.drawable.torterra, "Torterra","Las gentes de antaño creían que el planeta se sustentaba en la espalda de un gran Torterra.",listOf(PokemonTipoFB.TIERRA), listOf(387, 388, 389)),
    PokemonFB(390,"4",R.drawable.chimchar, "Chimchar","El fuego que arde en su cola lo generan los gases de su estómago y disminuye cuando está débil.",listOf(PokemonTipoFB.FUEGO), listOf(390, 391, 392)),
    PokemonFB(391,"4",R.drawable.monferno, "Monferno","Controla hábilmente la intensidad del fuego de su cola para mantener al enemigo a una distancia ideal.",listOf(PokemonTipoFB.FUEGO, PokemonTipoFB.LUCHA), listOf(390, 391, 392)),
    PokemonFB(392,"4",R.drawable.infernape, "Infernape","Maneja a sus rivales con tremenda agilidad. En su especial forma de luchar usa todos sus miembros.",listOf(PokemonTipoFB.FUEGO, PokemonTipoFB.LUCHA), listOf(390, 391, 392)),
    PokemonFB(393,"4",R.drawable.piplup, "Piplup","No le gusta que lo cuiden. Como no aprecia el apoyo de su Entrenador, le cuesta coger confianza con él.",listOf(PokemonTipoFB.AGUA), listOf(393, 394, 395)),
    PokemonFB(394,"4",R.drawable.prinplup, "Prinplup","Los golpes de sus alas pueden partir los árboles más gruesos. Busca sus presas en aguas heladas.",listOf(PokemonTipoFB.AGUA), listOf(393, 394, 395)),
    PokemonFB(395,"4",R.drawable.empoleon, "Empoleon","Aunque nunca pelea en vano, si amenazan la seguridad de los suyos los defiende implacablemente.",listOf(PokemonTipoFB.AGUA, PokemonTipoFB.ACERO), listOf(393, 394, 395)),
    PokemonFB(396,"4",R.drawable.starly, "Starly","Son débiles individualmente, por eso forman grupos. Pero, si el grupo crece demasiado, se pelean.",listOf(PokemonTipoFB.NORMAL, PokemonTipoFB.VOLADOR), listOf(396, 397, 398)),
    PokemonFB(397,"4",R.drawable.staravia, "Staravia","Son conscientes de su debilidad, así que siempre viven en grupo. Si se encuentran solos, lloran a gritos.",listOf(PokemonTipoFB.NORMAL, PokemonTipoFB.VOLADOR), listOf(396, 397, 398)),
    PokemonFB(398,"4",R.drawable.staraptor, "Staraptor","Jamás deja de atacar, aunque le hayan herido. Le preocupa mucho la forma de su cresta.",listOf(PokemonTipoFB.NORMAL, PokemonTipoFB.VOLADOR), listOf(396, 397, 398)),
    PokemonFB(399,"4",R.drawable.bidoof, "Bidoof","Forman colonias en las riberas de los ríos. Cerca de su madriguera se pueden ver rocas y troncos roídos.",listOf(PokemonTipoFB.NORMAL), listOf(399, 400)),
    PokemonFB(400,"4",R.drawable.bibarel, "Bibarel","Un río en el que un Bibarel cree una presa jamás se desbordará. Por esa razón la gente los aprecia.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.AGUA), listOf(399, 400)),
    PokemonFB(401,"4",R.drawable.kricketot, "Kricketot","Tiene las patas cortas. Cada vez que se tropieza, sus antenas chocan y suenan como un xilófono.",listOf(PokemonTipoFB.BICHO), listOf(401, 402)),
    PokemonFB(402,"4",R.drawable.kricketune, "Kriketune","Hay un pueblo en el que celebran un concurso basado en la increíble variedad de sus gritos",listOf(PokemonTipoFB.BICHO), listOf(401, 402)),
    PokemonFB(403,"4",R.drawable.shinx, "Shinx","Produce electricidad contrayendo sus músculos. Si siente peligro, su pelaje brilla resplandeciente.",listOf(PokemonTipoFB.ELECTRICO), listOf(403, 404, 405)),
    PokemonFB(404,"4",R.drawable.luxio, "Luxio","Por las puntas de sus garras pasa una fuerte corriente eléctrica. El mínimo roce debilita al enemigo.",listOf(PokemonTipoFB.ELECTRICO), listOf(403, 404, 405)),
    PokemonFB(405,"4",R.drawable.luxray, "Luxray","Cuando sus ojos brillan como el oro, puede ver presas escondidas, incluso detrás de un muro.",listOf(PokemonTipoFB.ELECTRICO), listOf(403, 404, 405)),
    PokemonFB(406,"4",R.drawable.budew, "Budew","Es muy sensible a los cambios de temperatura. Si hace calor, su capullo florece y esparce polen venenoso.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.VENENO), listOf(406, 315, 407)),
    PokemonFB(407,"4",R.drawable.roserade, "Roserade","Atrae a sus presas con un dulce aroma y las derriba con veneno. Cuanto más venenoso, mejor huele.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.VENENO), listOf(406, 315, 407)),
    PokemonFB(408,"4",R.drawable.cranidos, "Cranidos","Vivía en la jungla hace 100 millones de años. Apartaba los árboles del camino a cabezazos.",listOf(PokemonTipoFB.ROCA), listOf(408, 409)),
    PokemonFB(409,"4",R.drawable.rampardos, "Rampardos","Tiene sesos pequeños porque su duro cráneo, que soporta cualquier golpe, les impide desarrollarse.",listOf(PokemonTipoFB.ROCA), listOf(408, 409)),
    PokemonFB(410,"4",R.drawable.shieldon, "Shieldon","Gracias a su imponente protección facial, puede comer hierba y bayas donde quiera sin que le molesten.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.ACERO), listOf(410, 411)),
    PokemonFB(411,"4",R.drawable.bastiodon, "Bastiodon","Se alineaban y creaban una barrera que ningún enemigo podía cruzar. Así protegían a sus crías.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.ACERO), listOf(410, 411)),
    PokemonFB(412,"4",R.drawable.burmy, "Burmy","En épocas frías recubre su cuerpo con una capa de ramas y hojas. Al llegar el calor la hace más fina.",listOf(PokemonTipoFB.BICHO), listOf(412, 413, 414)),
    PokemonFB(413,"4",R.drawable.wormadam, "Wormadam","Su apariencia varía según dónde evolucione. Los materiales que halla pasan a formar parte de su cuerpo.",listOf(PokemonTipoFB.BICHO), listOf(412, 413)),
    PokemonFB(414,"4",R.drawable.mothim, "Mothim","Hace vida nocturna. Revolotea y roba la miel de las colmenas de Combee cuando duermen.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.VOLADOR), listOf(412, 414)),
    PokemonFB(415,"4",R.drawable.combee, "Combee","El trío se forma al nacer y se pasa la vida recogiendo miel de las flores para satisfacer a Vespiquen.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.VOLADOR), listOf(415, 416)),
    PokemonFB(416,"4",R.drawable.vespiquen, "Vespiquen","Cría larvas en los panales de su cuerpo. Segrega diversas feromonas de su cuerpo con las cuales controla a sus crías.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.VOLADOR), listOf(415, 416)),
    PokemonFB(417,"4",R.drawable.pachirisu, "Pachirisu","A veces se ve a dos frotándose las bolsas de las mejillas para compartir electricidad almacenada.",listOf(PokemonTipoFB.ELECTRICO), listOf(417)),
    PokemonFB(418,"4",R.drawable.buizel, "Buizel","Para impulsarse por el agua gira sus dos colas como una hélice. Así también corta las algas del camino.",listOf(PokemonTipoFB.AGUA), listOf(418, 419)),
    PokemonFB(419,"4",R.drawable.floatzel, "Floatzel","Con el flotador inflado puede llevar a personas sobre su espalda. Si lo desinfla, se sumerge.",listOf(PokemonTipoFB.AGUA), listOf(418, 419)),
    PokemonFB(420,"4",R.drawable.cherubi, "Cherubi","Obtiene la energía necesaria para evolucionar de esa pequeña esfera que está cargada de nutrientes.",listOf(PokemonTipoFB.PLANTA), listOf(420, 421)),
    PokemonFB(421,"4",R.drawable.cherrim, "Cherrim","Cuando los rayos del sol inundan su capullo, abre de par en par sus pétalos y se vuelve muy dinámico.",listOf(PokemonTipoFB.PLANTA), listOf(420, 421)),
    PokemonFB(422,"4",R.drawable.shellos, "Shellos","No hay que apretarle muy fuerte, ya que si lo haces, segrega un misterioso fluido morado.",listOf(PokemonTipoFB.AGUA), listOf(422, 423)),
    PokemonFB(423,"4",R.drawable.gastrodon, "Gastrodon","Si se ve amenazado por sus enemigos naturales, segrega un líquido morado y huye rápidamente.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.TIERRA), listOf(422, 423)),
    PokemonFB(424,"4",R.drawable.ambipom, "Ambipom","Usando sus colas, AMBIPOM puede propinar golpes sucesivos a velocidad de vértigo que son imposibles de esquivar.",listOf(PokemonTipoFB.NORMAL), listOf(190,424)),
    PokemonFB(425,"4",R.drawable.drifloon, "Drifloon","Se dice que a veces desaparecen niños que agarran un Drifloon pensando que es un globo.",listOf(PokemonTipoFB.FANTASMA,PokemonTipoFB.VOLADOR), listOf(425, 426)),
    PokemonFB(426,"4",R.drawable.drifblim, "Driflim","Transporta a gente y Pokémon volando pero, como se deja llevar, puede acabar en cualquier sitio.",listOf(PokemonTipoFB.FANTASMA,PokemonTipoFB.VOLADOR), listOf(425, 426)),
    PokemonFB(427,"4",R.drawable.buneary, "Buneary","Lleva las orejas enrolladas. Cuando las extiende, golpea con tal fuerza que incluso puede romper rocas.",listOf(PokemonTipoFB.NORMAL), listOf(427, 428)),
    PokemonFB(428,"4",R.drawable.lopunny, "Lopunny","Cada seis meses cambia su pelaje, que en las estaciones frías se vuelve muy suave y de gran calidad.",listOf(PokemonTipoFB.NORMAL), listOf(427, 428)),
    PokemonFB(429,"4",R.drawable.mismagius, "Mismagius","Sus gritos parecen cánticos. Se dice que en alguna rara ocasión han imbuido felicidad a quien los oía.",listOf(PokemonTipoFB.FANTASMA), listOf(200, 429)),
    PokemonFB(430,"4",R.drawable.honchkrow, "Honchkrow","Si uno lanza un grito profundo, los demás acuden. Por eso se le llama también invocador de la noche.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.VOLADOR), listOf(198, 430)),
    PokemonFB(431,"4",R.drawable.glameow, "Glameow","Oculta una tendencia rencorosa que le hace arañar la nariz de su entrenador si no le da de comer.",listOf(PokemonTipoFB.NORMAL), listOf(431, 432)),
    PokemonFB(432,"4",R.drawable.purugly, "Purugly","Rodea su cuerpo con las colas para parecer más grande. Si fija la mirada, no se perderá un detalle.",listOf(PokemonTipoFB.NORMAL), listOf(431, 432)),
    PokemonFB(433,"4",R.drawable.chingling, "Chingling","Emite chillidos en unas frecuencias imperceptibles para las personas. Cuando empieza no puede parar.",listOf(PokemonTipoFB.PSIQUICO), listOf(358, 433)),
    PokemonFB(434,"4",R.drawable.stunky, "Stunky","Expulsa un fluido maloliente por sus cuartos traseros. El hedor repele Pokémon en un radio de 2 km.",listOf(PokemonTipoFB.VENENO,PokemonTipoFB.SINIESTRO), listOf(434, 435)),
    PokemonFB(435,"4",R.drawable.skuntank, "Skuntank","Ataca emitiendo un fluido maloliente por la punta de su cola. Los ataques aéreos le confunden.",listOf(PokemonTipoFB.VENENO,PokemonTipoFB.SINIESTRO), listOf(434, 435)),
    PokemonFB(436,"4",R.drawable.bronzor, "Bronzor","Se descubrieron herramientas con su forma en tumbas antiguas, pero se desconoce si tiene relación.",listOf(PokemonTipoFB.ACERO,PokemonTipoFB.PSIQUICO), listOf(436, 437)),
    PokemonFB(437,"4",R.drawable.bronzong, "Bronzong","Se produjo un gran revuelo cuando encontraron uno en una obra después de 2000 años durmiendo.",listOf(PokemonTipoFB.ACERO,PokemonTipoFB.PSIQUICO), listOf(436, 437)),
    PokemonFB(438,"4",R.drawable.bonsly, "Bonsly","Parece que siempre está llorando, pero en realidad está eliminando el exceso de fluidos corporales.",listOf(PokemonTipoFB.ROCA), listOf(438, 185)),
    PokemonFB(439,"4",R.drawable.mimejr, "Mime Jr.","Cuando tiene a alguien delante imita su expresión y movimientos para extender sus sentimientos.",listOf(PokemonTipoFB.PSIQUICO,PokemonTipoFB.HADA), listOf(439, 122,1049,866)),
    PokemonFB(440,"4",R.drawable.happiny, "Happiny","Le encantan las cosas blancas y redondas. Imita a Chansey llevando una roca en forma de huevo.",listOf(PokemonTipoFB.NORMAL), listOf(440,113,242)),
    PokemonFB(441,"4",R.drawable.chatot, "Chatot","Pueden aprender y hablar lenguas humanas. Si se juntan, todos aprenden las mismas palabras.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.VOLADOR), listOf(441)),
    PokemonFB(442,"4",R.drawable.spiritomb, "Spiritomb","Como castigo por una fechoría 500 años atrás, está unido a la fisura de una piedra angular mística.",listOf(PokemonTipoFB.FANTASMA,PokemonTipoFB.SINIESTRO), listOf(442)),
    PokemonFB(443,"4",R.drawable.gible, "Gible","Vive en agujeros en las cuevas, al amparo del calor geotérmico. Si se acerca un enemigo, le muerde.",listOf(PokemonTipoFB.DRAGON,PokemonTipoFB.TIERRA), listOf(443, 444, 445)),
    PokemonFB(444,"4",R.drawable.gabite, "Gabite","Suele buscar y acumular gemas en su nido. Su botín es objetivo constante de ladrones.",listOf(PokemonTipoFB.DRAGON,PokemonTipoFB.TIERRA), listOf(443, 444, 445)),
    PokemonFB(445,"4",R.drawable.garchomp, "Garchomp","Cuando despliega su cuerpo y sus alas, parece un avión a reacción. Vuela a velocidad sónica.",listOf(PokemonTipoFB.DRAGON,PokemonTipoFB.TIERRA), listOf(443, 444, 445)),
    PokemonFB(446,"4",R.drawable.munchlax, "Munchlax","En su desesperación por engullir comida, se suele olvidar de la que esconde debajo de su pelaje.",listOf(PokemonTipoFB.NORMAL), listOf(143, 446)),
    PokemonFB(447,"4",R.drawable.riolu, "Riolu","Su cuerpo es ágil pero fuerte. Puede subir tres montañas y cruzar dos cañones en una noche.",listOf(PokemonTipoFB.LUCHA), listOf(447, 448)),
    PokemonFB(448,"4",R.drawable.lucario, "Lucario","Si se ha entrenado bien, puede percibir auras e identificar y asimilar sentimientos a 1 km.",listOf(PokemonTipoFB.LUCHA,PokemonTipoFB.ACERO), listOf(447, 448)),
    PokemonFB(449,"4",R.drawable.hippopotas, "Hippopotas","Cierra la nariz y luego atraviesa la arena con toda tranquilidad. Suele formar colonias de diez individuos.",listOf(PokemonTipoFB.TIERRA), listOf(449, 450)),
    PokemonFB(450,"4",R.drawable.hippowdon, "Hippowdon","Hace gala de su fuerza abriendo su enorme boca. Para atacar levanta gran cantidad de arena.",listOf(PokemonTipoFB.TIERRA), listOf(449, 450)),
    PokemonFB(451,"4",R.drawable.skorupi, "Skorupi","Agarra a sus presas con las garras de la cola y les inyecta veneno. Espera hasta que hace efecto.",listOf(PokemonTipoFB.VENENO,PokemonTipoFB.BICHO), listOf(451, 452)),
    PokemonFB(452,"4",R.drawable.drapion, "Drapion","Está dentro de una fuerte coraza. Su cabeza rota 180 grados para poder ver en todas direcciones.",listOf(PokemonTipoFB.VENENO,PokemonTipoFB.SINIESTRO), listOf(451, 452)),
    PokemonFB(453,"4",R.drawable.croagunk, "Croagunk","Las toxinas que segrega por los dedos alivian el dolor de espalda y se usan en ciertos medicamentos.",listOf(PokemonTipoFB.VENENO,PokemonTipoFB.LUCHA), listOf(453, 454)),
    PokemonFB(454,"4",R.drawable.toxicroak, "Toxicroak","Sus bolsas venenosas almacenan una toxina que le llega a las garras por unos tubos en los brazos.",listOf(PokemonTipoFB.VENENO,PokemonTipoFB.LUCHA), listOf(453, 454)),
    PokemonFB(455,"4",R.drawable.carnivine, "Carnivine","Se desplaza hábilmente con sus tentáculos buscando ramas desde las que acechar a sus presas.",listOf(PokemonTipoFB.PLANTA), listOf(455)),
    PokemonFB(456,"4",R.drawable.finneon, "Finneon","La línea que le recorre el costado puede almacenar luz solar. Brilla con mucha fuerza por la noche.",listOf(PokemonTipoFB.AGUA), listOf(456, 457)),
    PokemonFB(457,"4",R.drawable.lumineon, "Lumineon","Vive en las profundidades marinas. Atrae a sus presas con parpadeos del dibujo de sus cuatro aletas.",listOf(PokemonTipoFB.AGUA), listOf(456, 457)),
    PokemonFB(458,"4",R.drawable.mantyke, "Mantyke","La gente organiza excursiones para ver a este Pokémon retozando por las olas con Remoraid.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.VOLADOR), listOf(458, 226)),
    PokemonFB(459,"4",R.drawable.snover, "Snover","Siente mucha curiosidad por los humanos. Si uno encuentra huellas en la nieve, acuden todos a mirar.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.HIELO), listOf(459, 460)),
    PokemonFB(460,"4",R.drawable.abomasnow, "Abomasnow","Es el abominable hombre de las nieves. Produce ventiscas en las montañas cubiertas de nieve.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.HIELO), listOf(459, 460)),
    PokemonFB(461,"4",R.drawable.weavile, "Weavile","Vive en zonas nevadas. Deja marcas en los árboles con sus garras para comunicarse con sus compañeros.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.HIELO), listOf(215, 461)),
    PokemonFB(462,"4",R.drawable.magnezone, "Magnezone","Fruto de la evolución de Magneton cuando un campo magnético singular altera su estructura molecular.",listOf(PokemonTipoFB.ELECTRICO,PokemonTipoFB.ACERO), listOf(81, 82, 462)),
    PokemonFB(463,"4",R.drawable.lickilicky, "Lickilicky","Su larga lengua está siempre llena de babas. El contacto con su saliva causa entumecimiento.",listOf(PokemonTipoFB.NORMAL), listOf(108, 463)),
    PokemonFB(464,"4",R.drawable.rhyperior, "Rhyperior","Pone rocas en los agujeros de sus manos y las lanza con los músculos. Pocas veces ataca a Geodude.",listOf(PokemonTipoFB.TIERRA,PokemonTipoFB.ROCA), listOf(74, 75, 76, 464)),
    PokemonFB(465,"4",R.drawable.tangrowth, "Tangrowth","Sus brazos están hechos de plantas que se agarran a las cosas. Si se le cortan vuelven a crecer enseguida.",listOf(PokemonTipoFB.PLANTA), listOf(114, 465)),
    PokemonFB(466,"4",R.drawable.electivire, "Electivire","Al almacenar mucha electricidad, desprende chispas de una claridad increíble entre sus dos cuernos.",listOf(PokemonTipoFB.ELECTRICO), listOf(239,125,466)),
    PokemonFB(467,"4",R.drawable.magmortar, "Magmortar","Cuando lanza sus bolas de fuego a 2000 grados, su cuerpo adquiere un tono blanquecino por el calor.",listOf(PokemonTipoFB.FUEGO), listOf(240,126,467)),
    PokemonFB(468,"4",R.drawable.togekiss, "Togekiss","Congenia muy bien con las personas que respetan los derechos de los demás y evitan riñas innecesarias.",listOf(PokemonTipoFB.HADA,PokemonTipoFB.VOLADOR), listOf(175, 176, 468)),
    PokemonFB(469,"4",R.drawable.yanmega, "Yanmega","Con sus seis patas puede llevar a un adulto y volar con comodidad. Se equilibra con las alas de su cola.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.VOLADOR), listOf(193, 469)),
    PokemonFB(470,"4",R.drawable.leafeon, "Leafeon","Al igual que una planta, hace la fotosíntesis. Como consecuencia, siempre está rodeado de aire puro.",listOf(PokemonTipoFB.PLANTA,), listOf(133, 134, 135, 136, 196, 197, 470, 471, 700)),
    PokemonFB(471,"4",R.drawable.glaceon, "Glaceon","Para protegerse, puede congelar completamente su pelaje, de modo que los pelos parecen agujas.",listOf(PokemonTipoFB.HIELO), listOf(133, 134, 135, 136, 196, 197, 470, 471, 700)),
    PokemonFB(472,"4",R.drawable.gliscor, "Gliscor","Espera a sus presas colgado de una rama bocabajo. Cuando llega su oportunidad, se lanza en picado.",listOf(PokemonTipoFB.TIERRA,PokemonTipoFB.VOLADOR), listOf(207, 472)),
    PokemonFB(473,"4",R.drawable.mamoswine, "Mamoswine","Ya existía en la antigüedad. Se encontró uno bajo hielo de hace más de 10 000 años.",listOf(PokemonTipoFB.HIELO,PokemonTipoFB.TIERRA), listOf(220, 221, 473)),
    PokemonFB(474,"4",R.drawable.porygonz, "Porygon-Z","Se le instaló un software para mejorarlo. Sin embargo, comenzó a comportarse de manera extraña.",listOf(PokemonTipoFB.NORMAL), listOf(137, 233, 474)),
    PokemonFB(475,"4",R.drawable.gallade, "Gallade","Cuando quiere proteger a alguien, extiende los codos como si fueran espadas y lucha con fiereza.",listOf(PokemonTipoFB.PSIQUICO,PokemonTipoFB.LUCHA), listOf(280, 281, 475)),
    PokemonFB(476,"4",R.drawable.probopass, "Probopass","Controla magnéticamente sus tres Mini-Narices y ataca a sus enemigos desde tres direcciones diferentes.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.ACERO), listOf(299, 476)),
    PokemonFB(477,"4",R.drawable.dusknoir, "Dusknoir","Se dice que recoge en su cuerpo flexible a los espíritus extraviados y los guía hasta casa.",listOf(PokemonTipoFB.FANTASMA), listOf(355, 356, 477)),
    PokemonFB(478,"4",R.drawable.froslass, "Froslass","Congela a sus enemigos con un aliento gélido de 50 grados bajo cero. Está hueco por dentro.",listOf(PokemonTipoFB.HIELO,PokemonTipoFB.FANTASMA), listOf(361, 478)),
    PokemonFB(479,"4",R.drawable.rotom, "Rotom","Desde hace mucho tiempo se estudia su singular motor como fuente de energía motriz.",listOf(PokemonTipoFB.ELECTRICO,PokemonTipoFB.FANTASMA), listOf(479)),
    PokemonFB(480,"4",R.drawable.uxie, "Uxie","Voló y las personas adquirieron la capacidad para resolver problemas. Así nació la sabiduría.",listOf(PokemonTipoFB.PSIQUICO), listOf(480)),
    PokemonFB(481,"4",R.drawable.mesprit, "Mesprit","Dicen que Mesprit lleva a los corazones de la gente los sentimientos de alegría y tristeza.",listOf(PokemonTipoFB.PSIQUICO), listOf(481)),
    PokemonFB(482,"4",R.drawable.azelf, "Azelf","Se le conoce como el Ser de la Voluntad. Duerme en el fondo de un lago para equilibrar el mundo.",listOf(PokemonTipoFB.PSIQUICO), listOf(482)),
    PokemonFB(483,"4",R.drawable.dialga, "Dialga","Tiene el poder de controlar el tiempo. Aparece en los mitos de Sinnoh como una vieja deidad.",listOf(PokemonTipoFB.ACERO,PokemonTipoFB.DRAGON), listOf(483)),
    PokemonFB(484,"4",R.drawable.palkia, "Palkia","Tiene la habilidad de distorsionar el espacio. La mitología de Sinnoh lo describe como una deidad.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.DRAGON), listOf(484)),
    PokemonFB(485,"4",R.drawable.heatran, "Heatran","Habita cuevas volcánicas. Cava con sus pies en forma de cruz para trepar por techos y paredes.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.ACERO), listOf(485)),
    PokemonFB(486,"4",R.drawable.regigigas, "Regigigas","Se dice que usó rocas, magma y un hielo especial de montaña para crear Pokémon con su aspecto.",listOf(PokemonTipoFB.NORMAL), listOf(486)),
    PokemonFB(487,"4",R.drawable.giratina, "Giratina","Vive en el Mundo Distorsión, un mundo opuesto al nuestro y cuyas leyes desafían el sentido común.",listOf(PokemonTipoFB.FANTASMA,PokemonTipoFB.DRAGON), listOf(487)),
    PokemonFB(488,"4",R.drawable.cresselia, "Cresselia","Si alguien se duerme con una pluma suya, tendrá sueños maravillosos. Encarna el creciente lunar.",listOf(PokemonTipoFB.PSIQUICO), listOf(488)),
    PokemonFB(489,"4",R.drawable.phione, "Phione","Si sube la temperatura del mar, infla el flotador de su cabeza y flota en grupo en la superficie.",listOf(PokemonTipoFB.AGUA), listOf(489)),
    PokemonFB(490,"4",R.drawable.manaphy, "Manaphy","Nace con un maravilloso poder que le permite establecer vínculos con cualquier tipo de Pokémon.",listOf(PokemonTipoFB.AGUA), listOf(490)),
    PokemonFB(491,"4",R.drawable.darkrai, "Darkrai","Para protegerse causa pesadillas a los que le rodean. Pero no lo hace con intención de hacer daño.",listOf(PokemonTipoFB.SINIESTRO), listOf(491)),
    PokemonFB(492,"4",R.drawable.shaymin, "Shaymin","Vive entre las flores. Para evitar ser descubierto, se enrosca como si fuera una planta.",listOf(PokemonTipoFB.PLANTA), listOf(492)),
    PokemonFB(493,"4",R.drawable.arceus, "Arceus","Se dice que surgió de un huevo en un lugar en el que no había nada. Y luego dio forma al mundo.",listOf(PokemonTipoFB.NORMAL), listOf(493)),
    PokemonFB(494,"5",R.drawable.victini, "Victini","Pokémon que atrae la victoria. Dicen que el Entrenador que lo lleve saldrá vencedor de cualquier batalla.",listOf(PokemonTipoFB.PSIQUICO,PokemonTipoFB.FUEGO), listOf(494)),
    PokemonFB(495,"5",R.drawable.snivy, "Snivy","Sintetiza la luz del sol que recoge con su cola. Esta se le queda abatida cuando le faltan las energías.",listOf(PokemonTipoFB.PLANTA), listOf(495, 496, 497)),
    PokemonFB(496,"5",R.drawable.servine, "Servine","Parece que se desliza al correr. Engaña a sus rivales con su velocidad y los fustiga con su látigo.",listOf(PokemonTipoFB.PLANTA), listOf(495, 496, 497)),
    PokemonFB(497,"5",R.drawable.serperior, "Serperior","Detiene los movimientos del rival con una sola mirada. Expande la energía solar dentro de su cuerpo.",listOf(PokemonTipoFB.PLANTA), listOf(495, 496, 497)),
    PokemonFB(498,"5",R.drawable.tepig, "Tepig","Le encanta comer bayas tostadas, pero a veces se emociona demasiado y termina churruscándolas.",listOf(PokemonTipoFB.FUEGO), listOf(498, 499, 500)),
    PokemonFB(499,"5",R.drawable.pignite, "Pignite","Cuando las llamas de su interior se avivan, aumenta su velocidad y agilidad. Emite humo si está en peligro.",listOf(PokemonTipoFB.FUEGO, PokemonTipoFB.LUCHA), listOf(498, 499, 500)),
    PokemonFB(500,"5",R.drawable.emboar, "Emboar","Calienta sus puños con las llamas de su barbilla para propinar puñetazos ardientes. Es muy fiel a sus compañeros.",listOf(PokemonTipoFB.FUEGO, PokemonTipoFB.LUCHA), listOf(498, 499, 500)),
    PokemonFB(501,"5",R.drawable.oshawott, "Oshawott","Ataca con la vieira de su ombligo. En cuanto para un ataque, pasa al contraataque sin dilación.",listOf(PokemonTipoFB.AGUA), listOf(501, 502, 503)),
    PokemonFB(502,"5",R.drawable.dewott, "Dewott","Tras un exhaustivo entrenamiento, Dewott puede dominar diversas técnicas para usar con sus vieiras.",listOf(PokemonTipoFB.AGUA), listOf(501, 502, 503)),
    PokemonFB(503,"5",R.drawable.samurott, "Samurott","En un abrir y cerrar de ojos, puede desenvainar y envainar los sables que hay en sus patas delanteras.",listOf(PokemonTipoFB.AGUA), listOf(501, 502, 503)),
    PokemonFB(504,"5",R.drawable.patrat, "Patrat","Siempre está alerta y no quita la mirada de su madriguera. Cuando no está vigilando, le invade la inquietud.",listOf(PokemonTipoFB.NORMAL), listOf(504, 505)),
    PokemonFB(505,"5",R.drawable.watchog, "Watchog","Hace brillar las rayas de su cuerpo para intimidar al enemigo. Sus ojos lo ven todo, hasta en la oscuridad.",listOf(PokemonTipoFB.NORMAL), listOf(504, 505)),
    PokemonFB(506,"5",R.drawable.lillipup, "Lillipup","Aunque se trata de un Pokémon valeroso, también es lo bastante inteligente como para escapar si el rival es muy fuerte.",listOf(PokemonTipoFB.NORMAL), listOf(506, 507, 508)),
    PokemonFB(507,"5",R.drawable.herdier, "Herdier","Un robusto pelaje cubre su cuerpo a modo de capa y disminuye el daño que recibe en los ataques.",listOf(PokemonTipoFB.NORMAL), listOf(506, 507, 508)),
    PokemonFB(508,"5",R.drawable.stoutland, "Stoutland","Es especialista en socorrer a personas extraviadas en el mar o en las montañas. Es muy inteligente.",listOf(PokemonTipoFB.NORMAL), listOf(506, 507, 508)),
    PokemonFB(509,"5",R.drawable.purrloin, "Purrloin","Su aspecto tierno es una farsa. Lo aprovechan para robar a los humanos y contemplar qué cara ponen.",listOf(PokemonTipoFB.SINIESTRO), listOf(509, 510)),
    PokemonFB(510,"5",R.drawable.liepard, "Liepard","Su bella y grácil silueta le viene dada por su desarrollada musculatura, que le permite andar de noche sin hacer ruido.",listOf(PokemonTipoFB.SINIESTRO), listOf(509, 510)),
    PokemonFB(511,"5",R.drawable.pansage, "Pansage","Es todo un experto en la búsqueda de bayas y es tan gentil que las comparte con todos sus compañeros.",listOf(PokemonTipoFB.PLANTA), listOf(511, 512)),
    PokemonFB(512,"5",R.drawable.simisage, "Simisage","Agita su cola revestida de espinas para atacar a su enemigo. La hoja que crece sobre su cabeza es muy amarga.",listOf(PokemonTipoFB.PLANTA), listOf(511, 512)),
    PokemonFB(513,"5",R.drawable.pansear, "Pansear","Pokémon muy inteligente que tiene la costumbre de tostar las bayas antes de comérselas. Ayuda mucho a los humanos.",listOf(PokemonTipoFB.FUEGO), listOf(513, 514)),
    PokemonFB(514,"5",R.drawable.simisear, "Simisear","Cuando se emociona, echa chispas por la cola y por la cabeza, y calienta su cuerpo. Por alguna razón le encantan los dulces.",listOf(PokemonTipoFB.FUEGO), listOf(513, 514)),
    PokemonFB(515,"5",R.drawable.panpour, "Panpour","El agua acumulada en su mata de pelo es rica en nutrientes. Usa la cola para regar plantas con esa misma agua.",listOf(PokemonTipoFB.AGUA), listOf(515, 516)),
    PokemonFB(516,"5",R.drawable.simipour, "Simipour","Le encantan los lugares con agua limpia. Cuando desciende el nivel de agua de su pelo, se abastece a través de su cola.",listOf(PokemonTipoFB.AGUA), listOf(515, 516)),
    PokemonFB(517,"5",R.drawable.munna, "Munna","Se alimenta de los sueños de humanos y Pokémon. Si los sueños son felices, despide humo rosa.",listOf(PokemonTipoFB.PSIQUICO), listOf(517, 518)),
    PokemonFB(518,"5",R.drawable.musharna, "Musharna","Multitud de sueños de humanos y Pokémon se encuentran atrapados en el humo que despide por su frente.",listOf(PokemonTipoFB.PSIQUICO), listOf(517, 518)),
    PokemonFB(519,"5",R.drawable.pidove, "Pidove","Es un Pokémon muy despistado. Aunque reciba órdenes de su Entrenador, se le olvidan, y se queda esperando.",listOf(PokemonTipoFB.NORMAL, PokemonTipoFB.VOLADOR), listOf(519, 520, 521)),
    PokemonFB(520,"5",R.drawable.tranquill, "Tranquill","Puede regresar sin problema alguno a su nido desde cualquier lugar del globo y jamás se separa de quien lo entrena.",listOf(PokemonTipoFB.NORMAL, PokemonTipoFB.VOLADOR), listOf(519, 520, 521)),
    PokemonFB(521,"5",R.drawable.unfezant, "Unfezant","El macho amenaza al enemigo meciendo el adorno de su cabeza. Al volar, la hembra es mucho más diestra que el macho.",listOf(PokemonTipoFB.NORMAL, PokemonTipoFB.VOLADOR), listOf(519, 520, 521)),
    PokemonFB(522,"5",R.drawable.blitzle, "Blitzle","Su crin brilla cuando emite una descarga eléctrica. Se comunica con los suyos mediante el ritmo y el número de brillos.",listOf(PokemonTipoFB.ELECTRICO), listOf(522, 523)),
    PokemonFB(523,"5",R.drawable.zebstrika, "Zebstrika","Es un Pokémon con mucho temperamento. Cuando se enoja, lanza rayos desde su crin en todas direcciones.",listOf(PokemonTipoFB.ELECTRICO), listOf(522, 523)),
    PokemonFB(524,"5",R.drawable.roggenrola, "Roggenrola","El agujero hexagonal es su oído, y tiene el hábito de caminar en la dirección de donde provienen los sonidos.",listOf(PokemonTipoFB.ROCA), listOf(524, 525, 526)),
    PokemonFB(525,"5",R.drawable.boldore, "Boldore","La energía que no puede contener en el interior de su cuerpo se escapa formando cristales naranjas.",listOf(PokemonTipoFB.ROCA), listOf(524, 525, 526)),
    PokemonFB(526,"5",R.drawable.gigalith, "Gigalith","Absorbe los rayos solares, procesa esa energía en su núcleo y lanza poderosas bolas de luz a sus enemigos.",listOf(PokemonTipoFB.ROCA), listOf(524, 525, 526)),
    PokemonFB(527,"5",R.drawable.woobat, "Woobat","Este peculiar Pokémon pega sus fosas nasales a la pared para dormir y, cuando las retira, deja un corazón marcado.",listOf(PokemonTipoFB.PSIQUICO, PokemonTipoFB.VOLADOR), listOf(527, 528)),
    PokemonFB(528,"5",R.drawable.swoobat, "Swoobat","Cuando emite ondas ultrasónicas, que incluso pueden reventar el cemento, agita su cola con vehemencia.",listOf(PokemonTipoFB.PSIQUICO, PokemonTipoFB.VOLADOR), listOf(527, 528)),
    PokemonFB(529,"5",R.drawable.drilbur, "Drilbur","Puede girar su cuerpo a una velocidad de 50 km/h y, si la mantiene, puede perforar el suelo y atravesarlo.",listOf(PokemonTipoFB.TIERRA), listOf(529, 530)),
    PokemonFB(530,"5",R.drawable.excadrill, "Excadrill","Coloca sus garras y su cabeza de manera que se convierten en un taladro. Puede incluso taladrar una plancha de acero.",listOf(PokemonTipoFB.TIERRA, PokemonTipoFB.ACERO), listOf(529, 530)),
    PokemonFB(531,"5",R.drawable.audino, "Audino","Su sentido del oído es infalible: capta cualquier ruido de su alrededor y hace las veces de radar.",listOf(PokemonTipoFB.NORMAL), listOf(531, 778)),
    PokemonFB(532,"5",R.drawable.timburr, "Timburr","Siempre lleva una viga de madera y ayuda en las construcciones. Se busca una viga más grande cuando se hace más fuerte.",listOf(PokemonTipoFB.LUCHA), listOf(532, 533, 534)),
    PokemonFB(533,"5",R.drawable.gurdurr, "Gurdurr","Gracias a su entrenada musculatura, puede blandir vigas de acero sin problema para así derribar edificios enteros.",listOf(PokemonTipoFB.LUCHA), listOf(532, 533, 534)),
    PokemonFB(534,"5",R.drawable.conkeldurr, "Conkeldurr","Se cree que Conkeldurr enseñó a los humanos la técnica para elaborar cemento hace más de 2000 años.",listOf(PokemonTipoFB.LUCHA), listOf(532, 533, 534)),
    PokemonFB(535,"5",R.drawable.tympole, "Tympole","Emite sonidos imperceptibles para los humanos con la vibración de sus mejillas y se comunica al ritmo de los mismos.",listOf(PokemonTipoFB.AGUA), listOf(535, 536, 537)),
    PokemonFB(536,"5",R.drawable.palpitoad, "Palpitoad","Vive tanto en tierra como en el fondo del mar. Con su larga y viscosa lengua, inmoviliza a sus contrincantes.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.TIERRA), listOf(535, 536, 537)),
    PokemonFB(537,"5",R.drawable.seismitoad, "Seismitoad","Despide un líquido paralizador por los bultos de su cabeza. Atormenta a sus oponentes con enormes vibraciones.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.TIERRA), listOf(535, 536, 537)),
    PokemonFB(538,"5",R.drawable.throh, "Throh","Si se topa con un rival más fuerte, ansía lanzarlo por los aires. Al hacerse más fuerte, cambia su cinturón.",listOf(PokemonTipoFB.LUCHA), listOf(538)),
    PokemonFB(539,"5",R.drawable.sawk, "Sawk","Para lograr dominar las técnicas de kárate más letales, se retiran a las montañas y entrenan día y noche.",listOf(PokemonTipoFB.LUCHA), listOf(539)),
    PokemonFB(540,"5",R.drawable.sewaddle, "Sewaddle","Recorta hojas y las teje con el líquido viscoso que segrega por la boca para hacerse su propia ropa.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.PLANTA), listOf(540, 541, 542)),
    PokemonFB(541,"5",R.drawable.swadloon, "Swadloon","Le gustan los lugares lóbregos y húmedos. Se pasa todo el día comiendo las hojas esparcidas por el suelo.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.PLANTA), listOf(540, 541, 542)),
    PokemonFB(542,"5",R.drawable.leavanny, "Leavanny","Si se encuentra con un Pokémon joven, segrega por la boca hilos pegadizos con los que le teje una prenda de ropa.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.PLANTA), listOf(540, 541, 542)),
    PokemonFB(543,"5",R.drawable.venipede, "Venipede","Percibe su entorno con su sentido del tacto, residente en su cabeza y cola. Su carácter es violento por naturaleza.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.VENENO), listOf(543, 544, 545)),
    PokemonFB(544,"5",R.drawable.whirlipede, "Whirlipede","Lo protege un duro caparazón. Gira como una rueda y realiza brutales placajes contra sus enemigos.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.VENENO), listOf(543, 544, 545)),
    PokemonFB(545,"5",R.drawable.scolipede, "Scolipede","Atenaza a sus presas con las garras que sobresalen de su cuello hasta que no se pueden mover y las remata con veneno.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.VENENO), listOf(543, 544, 545)),
    PokemonFB(546,"5",R.drawable.cottonee, "Cottonee","Despide motas de algodón cuando lo atacan para confundir a los enemigos y poner pies en polvorosa.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.HADA), listOf(546, 547)),
    PokemonFB(547,"5",R.drawable.whimsicott, "Whimsicott","Aparece con remolinos de viento. Entra en las casas por las rendijas y les encanta hacer travesuras.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.HADA), listOf(546, 547)),
    PokemonFB(548,"5",R.drawable.petilil, "Petilil","Mordisquear las hojas de su cabeza permite recuperar toda la vitalidad, a pesar de que están muy amargas.",listOf(PokemonTipoFB.PLANTA), listOf(548, 549)),
    PokemonFB(549,"5",R.drawable.lilligant, "Lilligant","Todos los famosos quieren uno. Incluso a los Entrenadores más curtidos les cuesta que florezca.",listOf(PokemonTipoFB.PLANTA), listOf(548, 549)),
    PokemonFB(550,"5",R.drawable.basculin, "Basculin","Los de color azul y los de color rojo siempre se pelean. Son muy violentos, pero su sabor es excepcional.",listOf(PokemonTipoFB.AGUA), listOf(550,902)),
    PokemonFB(551,"5",R.drawable.sandile, "Sandile","Viven en los desiertos y se sumergen en las cálidas arenas para que su temperatura corporal no se reduzca.",listOf(PokemonTipoFB.TIERRA,PokemonTipoFB.SINIESTRO), listOf(551, 552, 553)),
    PokemonFB(552,"5",R.drawable.krokorok, "Krokorok","Gracias a la película que recubre sus ojos, pueden ver incluso de noche. Viven en pequeñas manadas.",listOf(PokemonTipoFB.TIERRA,PokemonTipoFB.SINIESTRO), listOf(551, 552, 553)),
    PokemonFB(553,"5",R.drawable.krookodile, "Krookodile","Un Pokémon bastante violento. Ataca todo lo que se mueva delante de él con sus mortíferas mandíbulas.",listOf(PokemonTipoFB.TIERRA,PokemonTipoFB.SINIESTRO), listOf(551, 552, 553)),
    PokemonFB(554,"5",R.drawable.darumaka, "Darumaka","Como sus excrementos están muy calientes, la gente de antaño se los metía en los bolsillos para calentarse.",listOf(PokemonTipoFB.FUEGO), listOf(554, 555, 777)),
    PokemonFB(555,"5",R.drawable.darmanitan, "Darmanitan","Cuando resulta gravemente herido, se endurece como una piedra y medita para agudizar la mente.",listOf(PokemonTipoFB.FUEGO), listOf(554, 555, 777)),
    PokemonFB(556,"5",R.drawable.maractus, "Maractus","Vive en territorio árido. Emite un sonido parecido a unas maracas si se mueve de forma rítmica.",listOf(PokemonTipoFB.PLANTA), listOf(556)),
    PokemonFB(557,"5",R.drawable.dwebble, "Dwebble","Si encuentran una piedra de tamaño ideal, segregan un líquido por la boca para crear un agujero y deslizarse dentro.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.ROCA), listOf(557, 558)),
    PokemonFB(558,"5",R.drawable.crustle, "Crustle","Su inmensa capacidad motriz le permite desplazarse cargando a sus espaldas rocas enormes durante días.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.ROCA), listOf(557, 558)),
    PokemonFB(559,"5",R.drawable.scraggy, "Scraggy","Propina un cabezazo inmediato a todo aquel que lo mira a los ojos. Su cráneo es muy duro.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.LUCHA), listOf(559, 560)),
    PokemonFB(560,"5",R.drawable.scrafty, "Scrafty","Ataca en grupo con violencia a todo aquel que se interne en su territorio. Lanza ácido por la boca.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.LUCHA), listOf(559, 560)),
    PokemonFB(561,"5",R.drawable.sigilyph, "Sigilyph","Deidad protectora de una antigua ciudad. Siempre merodea por la misma ruta y permanece alerta en busca de intrusos..",listOf(PokemonTipoFB.PSIQUICO,PokemonTipoFB.VOLADOR), listOf(561)),
    PokemonFB(562,"5",R.drawable.yamask, "Yamask","Almas de humanos sepultados en tumbas que han adquirido forma de Pokémon. Recuerdan su vida antes de la muerte.",listOf(PokemonTipoFB.FANTASMA), listOf(562, 563)),
    PokemonFB(563,"5",R.drawable.cofagrigus, "Cofagrigus","Atrapan en su interior a los ladrones de tumbas que los confunden con ataúdes de verdad.",listOf(PokemonTipoFB.FANTASMA), listOf(562, 563)),
    PokemonFB(564,"5",R.drawable.tirtouga, "Tirtouga","Pokémon renacido a partir de un fósil. Es muy hábil nadando y puede sumergirse a una profundidad de 1000 m.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.ROCA), listOf(564, 565)),
    PokemonFB(565,"5",R.drawable.carracosta, "Carracosta","Un golpe con sus desarrolladas aletas delanteras puede hacer perder a un rival el conocimiento o romperle los huesos.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.ROCA), listOf(564, 565)),
    PokemonFB(566,"5",R.drawable.archen, "Archen","Dicen que es el Pokémon pájaro primigenio. No puede volar, así que solo salta de rama en rama.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.VOLADOR), listOf(566, 567)),
    PokemonFB(567,"5",R.drawable.archeops, "Archeops","Se le da mejor correr que volar. Atrapa a sus presas corriendo más rápido que un coche.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.VOLADOR), listOf(566, 567)),
    PokemonFB(568,"5",R.drawable.trubbish, "Trubbish","Pokémon nacido de la reacción química entre una bolsa de basura y residuos industriales.",listOf(PokemonTipoFB.VENENO), listOf(568, 569)),
    PokemonFB(569,"5",R.drawable.garbodor, "Garbodor","Apresa a su rival con el brazo izquierdo y le da el golpe de gracia exhalando por la boca un apestoso gas venenoso.",listOf(PokemonTipoFB.VENENO), listOf(568, 569)),
    PokemonFB(570,"5",R.drawable.zorua, "Zorua","Se transforma en humanos o en otros Pokémon. Se defiende del peligro ocultando su verdadera apariencia.",listOf(PokemonTipoFB.SINIESTRO), listOf(570, 571)),
    PokemonFB(571,"5",R.drawable.zoroark, "Zoroark","Tiene la facultad de confundir a muchos humanos a la vez. Protege su guarida creando un paisaje ilusorio.",listOf(PokemonTipoFB.SINIESTRO), listOf(570, 571)),
    PokemonFB(572,"5",R.drawable.minccino, "Minccino","Le encanta la limpieza. Usa su cola a modo de escoba y se pasa el día barre que barre.",listOf(PokemonTipoFB.NORMAL), listOf(572, 573)),
    PokemonFB(573,"5",R.drawable.cinccino, "Cinccino","Su pelaje blanco está recubierto por una grasa especial que hace resbalar los ataques enemigos.",listOf(PokemonTipoFB.NORMAL), listOf(572, 573)),
    PokemonFB(574,"5",R.drawable.gothita, "Gothita","Clava su mirada en Pokémon y Entrenadores como si observara algo solo perceptible por él.",listOf(PokemonTipoFB.PSIQUICO), listOf(574, 575, 576)),
    PokemonFB(575,"5",R.drawable.gothorita, "Gothorita","La luz de las estrellas origina su poder. De noche, marca su posición haciendo levitar piedras con su poder psíquico.",listOf(PokemonTipoFB.PSIQUICO), listOf(574, 575, 576)),
    PokemonFB(576,"5",R.drawable.gothitelle, "Gothitelle","Predice el futuro analizando la posición de los astros y su movimiento. Conoce la esperanza de vida de los Entrenadores.",listOf(PokemonTipoFB.PSIQUICO), listOf(574, 575, 576)),
    PokemonFB(577,"5",R.drawable.solosis, "Solosis","Puede vivir en cualquier ambiente gracias al líquido especial que recubre su cuerpo.",listOf(PokemonTipoFB.PSIQUICO), listOf(577, 578, 579)),
    PokemonFB(578,"5",R.drawable.duosion, "Duosion","Cuando las dos partes de su cerebro piensan lo mismo, saca todo su poder a relucir.",listOf(PokemonTipoFB.PSIQUICO), listOf(577, 578, 579)),
    PokemonFB(579,"5",R.drawable.reuniclus, "Reuniclus","La fortaleza de sus brazos le permite hacer añicos hasta rocas. Está dotado de una inteligencia superior.",listOf(PokemonTipoFB.PSIQUICO), listOf(577, 578, 579)),
    PokemonFB(580,"5",R.drawable.ducklett, "Ducklett","Cuando se ve atacado, las plumas que lo recubren despiden ráfagas de agua que lo ayudan a escapar.",listOf(PokemonTipoFB.AGUA, PokemonTipoFB.VOLADOR), listOf(580, 581)),
    PokemonFB(581,"5",R.drawable.swanna, "Swanna","La potencia de su pico es brutal. Arquea su largo cuello y picotea repetidamente al enemigo.",listOf(PokemonTipoFB.AGUA, PokemonTipoFB.VOLADOR), listOf(580, 581)),
    PokemonFB(582,"5",R.drawable.vanillite, "Vanillite","Nació de un carámbano que absorbió la energía del sol al alba. Duerme arropado por la nieve.",listOf(PokemonTipoFB.HIELO), listOf(582, 583, 584)),
    PokemonFB(583,"5",R.drawable.vanillish, "Vanillish","Enfrían el aire a su alrededor y crean partículas de hielo mediante las cuales congelan a sus oponentes.",listOf(PokemonTipoFB.HIELO), listOf(582, 583, 584)),
    PokemonFB(584,"5",R.drawable.vanilluxe, "Vanilluxe","Absorben grandes cantidades de agua y la transforman en ventisca en su cuerpo, expulsándola cuando se enojan.",listOf(PokemonTipoFB.HIELO), listOf(582, 583, 584)),
    PokemonFB(585,"5",R.drawable.deerling, "Deerling","El color de su cuerpo cambia no solo con las estaciones, sino también con los cambios de humedad y temperatura.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.PLANTA), listOf(585, 586)),
    PokemonFB(586,"5",R.drawable.sawsbuck, "Sawsbuck","Migra con el cambio de estación, por lo que hay quien considera a Sawsbuck el heraldo de la primavera.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.PLANTA), listOf(585, 586)),
    PokemonFB(587,"5",R.drawable.emolga, "Emolga","Puede volar al extender sus membranas y electrocutar a sus enemigos mediante la electricidad acumulada en sus mejillas.",listOf(PokemonTipoFB.ELECTRICO,PokemonTipoFB.VOLADOR), listOf(587)),
    PokemonFB(588,"5",R.drawable.karrablast, "Karrablast","Si recibe una descarga eléctrica durante un combate contra un Shelmet, puede evolucionar. Se desconoce el porqué.",listOf(PokemonTipoFB.BICHO), listOf(588, 589)),
    PokemonFB(589,"5",R.drawable.escavalier, "Escavalier","Pokémon que evolucionó poniéndose el caparazón de Shelmet. Su armazón de acero le protege todo el cuerpo.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.ACERO), listOf(588, 589)),
    PokemonFB(590,"5",R.drawable.foongus, "Foongus","Por razones desconocidas, se parece a una Poké Ball. Lanza esporas de veneno para repeler al enemigo.",listOf(PokemonTipoFB.PLANTA, PokemonTipoFB.VENENO), listOf(590, 591)),
    PokemonFB(591,"5",R.drawable.amoonguss, "Amoonguss","Aunque intenta pasar por parte superior de una Poké Ball para atraer a sus presas, consigue engañar a pocos.",listOf(PokemonTipoFB.PLANTA, PokemonTipoFB.VENENO), listOf(590, 591)),
    PokemonFB(592,"5",R.drawable.frillish, "Frillish","Rodea a sus presas con sus tentáculos, las entumece y las arrastra a 8000 m de profundidad hasta que las ahoga.",listOf(PokemonTipoFB.AGUA, PokemonTipoFB.FANTASMA), listOf(592, 593)),
    PokemonFB(593,"5",R.drawable.jellicent, "Jellicent","Su cuerpo se compone de agua salada. Dicen que ha construido un palacio en el fondo del mar con restos de barcos.",listOf(PokemonTipoFB.AGUA, PokemonTipoFB.FANTASMA), listOf(592, 593)),
    PokemonFB(594,"5",R.drawable.alomomola, "Alomomola","La membrana viscosa que recubre el cuerpo de Alomomola tiene facultades curativas.",listOf(PokemonTipoFB.AGUA), listOf(594)),
    PokemonFB(595,"5",R.drawable.joltik, "Joltik","Se agarra a Pokémon de gran tamaño, absorbe su electricidad estática y la guarda en una bolsa interna.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.ELECTRICO), listOf(595, 596)),
    PokemonFB(596,"5",R.drawable.galvantula, "Galvantula","Pone trampas con hilos electrificados. De este modo, electrocuta a sus enemigos y los inmoviliza por completo.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.ELECTRICO), listOf(595, 596)),
    PokemonFB(597,"5",R.drawable.ferroseed, "Ferroseed","Lanza numerosas púas al detectar peligro. En cuanto tiene ocasión, echa a rodar y se escapa.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.ACERO), listOf(597, 598)),
    PokemonFB(598,"5",R.drawable.ferrothorn, "Ferrothorn","Se pega al techo de cuevas y lanza púas de metal a todo el que pase por debajo de donde se encuentre.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.ACERO), listOf(597, 598)),
    PokemonFB(599,"5",R.drawable.klink, "Klink","La combinación fija de dos cuerpos le permite generar energía cuando se ponen a girar.",listOf(PokemonTipoFB.ACERO), listOf(599, 600, 601)),
    PokemonFB(600,"5",R.drawable.klang, "Klang","Muestra sus sentimientos cambiando la dirección de su giro. Cuanto más se enfade, más rápido girará.",listOf(PokemonTipoFB.ACERO), listOf(599, 600, 601)),
    PokemonFB(601,"5",R.drawable.klinklang, "Klinklang","Recarga su energía rápidamente haciendo girar con gran velocidad el engranaje con un núcleo rojo.",listOf(PokemonTipoFB.ACERO), listOf(599, 600, 601)),
    PokemonFB(602,"5",R.drawable.tynamo, "Tynamo","Actúa siempre en su cardumen. Cuenta con un mecanismo que genera electricidad y la libera cuando está en peligro.",listOf(PokemonTipoFB.ELECTRICO), listOf(602, 603, 604)),
    PokemonFB(603,"5",R.drawable.eelektrik, "Eelektrik","Pokémon de apetito voraz. En cuanto encuentra una presa, la paraliza con electricidad y la engulle.",listOf(PokemonTipoFB.ELECTRICO), listOf(602, 603, 604)),
    PokemonFB(604,"5",R.drawable.eelektross, "Eelektross","Sale del mar con la fuerza de sus brazos y ataca a sus presas en la costa. Luego se las lleva de vuelta al mar.",listOf(PokemonTipoFB.ELECTRICO), listOf(602, 603, 604)),
    PokemonFB(605,"5",R.drawable.elgyem, "Elgyem","Según cuentan los rumores, procede de un desierto donde hace 50 años se estrelló un ovni.",listOf(PokemonTipoFB.PSIQUICO), listOf(605, 606)),
    PokemonFB(606,"5",R.drawable.beheeyem, "Beheeyem","Parece que se comunica haciendo brillar sus dedos tricolores, pero nadie ha conseguido descifrar aún su patrón.",listOf(PokemonTipoFB.PSIQUICO), listOf(605, 606)),
    PokemonFB(607,"5",R.drawable.litwick, "Litwick","Finge ser una luz guía en el camino, pero en realidad solo quiere absorber la energía vital de quien lo sigue.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.FANTASMA), listOf(607, 608, 609)),
    PokemonFB(608,"5",R.drawable.lampent, "Lampent","Aparece hacia el final de la vida y absorbe el alma en cuanto esta se separa del cuerpo.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.FANTASMA), listOf(607, 608, 609)),
    PokemonFB(609,"5",R.drawable.chandelure, "Chandelure","Las almas que han ardido bajo sus oscuras llamas vagan sin rumbo y eternamente por este mundo.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.FANTASMA), listOf(607, 608, 609)),
    PokemonFB(610,"5",R.drawable.axew, "Axew","Deja la huella de sus colmillos en los árboles para marcar su territorio. Si se le rompen, se regeneran muy rápido.",listOf(PokemonTipoFB.DRAGON), listOf(610, 611, 612)),
    PokemonFB(611,"5",R.drawable.fraxure, "Fraxure","Sus colmillos no vuelven a crecer, por lo que, al término de cada combate, los afila cuidadosamente con cantos de río.",listOf(PokemonTipoFB.DRAGON), listOf(610, 611, 612)),
    PokemonFB(612,"5",R.drawable.haxorus, "Haxorus","Sus colmillos poseen una increíble fuerza destructiva, capaz de desgarrar incluso una dura y espesa columna de acero.",listOf(PokemonTipoFB.DRAGON), listOf(610, 611, 612)),
    PokemonFB(613,"5",R.drawable.cubchoo, "Cubchoo","Siempre está con mucosidades colgando. Las aspira para hacer un movimiento, ya que son su materia prima para esto.",listOf(PokemonTipoFB.HIELO), listOf(613, 614)),
    PokemonFB(614,"5",R.drawable.beartic, "Beartic","Adoran los mares gélidos del norte. Congelan su aliento para crear sendas por las que caminar sobre el agua.",listOf(PokemonTipoFB.HIELO), listOf(613, 614)),
    PokemonFB(615,"5",R.drawable.cryogonal, "Cryogonal","Aparece hacia el final de la vida y absorbe el alma en cuanto esta se separa del cuerpo.",listOf(PokemonTipoFB.HIELO), listOf(615)),
    PokemonFB(616,"5",R.drawable.shelmet, "Shelmet","Las almas que han ardido bajo sus oscuras llamas vagan sin rumbo y eternamente por este mundo.",listOf(PokemonTipoFB.BICHO), listOf(616, 617)),
    PokemonFB(617,"5",R.drawable.accelgor, "Accelgor","Deja la huella de sus colmillos en los árboles para marcar su territorio. Si se le rompen, se regeneran muy rápido.",listOf(PokemonTipoFB.BICHO), listOf(616, 617)),
    PokemonFB(618,"5",R.drawable.stunfisk, "Stunfisk","Sus colmillos no vuelven a crecer, por lo que, al término de cada combate, los afila cuidadosamente con cantos de río.",listOf(PokemonTipoFB.TIERRA,PokemonTipoFB.ELECTRICO), listOf(618)),
    PokemonFB(619,"5",R.drawable.mienfoo, "Mienfoo","Usa gráciles movimientos sucesivos. Si se concentra, aumenta su eficacia y rapidez.",listOf(PokemonTipoFB.LUCHA), listOf(619, 620)),
    PokemonFB(620,"5",R.drawable.mienshao, "Mienshao","Usa el pelaje de sus brazos a modo de látigos para encadenar ataques que nadie puede parar una vez iniciados.",listOf(PokemonTipoFB.LUCHA), listOf(619, 620)),
    PokemonFB(621,"5",R.drawable.druddigon, "Druddigon","Corre por estrechas cavernas y atrapa a sus presas con sus afiladas garras. La piel de su cara es más dura que una roca.",listOf(PokemonTipoFB.DRAGON), listOf(621)),
    PokemonFB(622,"5",R.drawable.golett, "Golett","Los rumores apuntan a que fue un Pokémon creado por la ciencia de una antigua y misteriosa civilización.",listOf(PokemonTipoFB.TIERRA,PokemonTipoFB.FANTASMA), listOf(622, 623)),
    PokemonFB(623,"5",R.drawable.golurk, "Golurk","Al parecer, aquel que antaño lo creó le ordenó proteger a los Pokémon y a los humanos.",listOf(PokemonTipoFB.TIERRA,PokemonTipoFB.FANTASMA), listOf(622, 623)),
    PokemonFB(624,"5",R.drawable.pawniard, "Pawniard","Lucha bajo las órdenes de Bisharp. Se agarra a sus oponentes y les inflige daño utilizando sus cuchillas.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.ACERO), listOf(624, 625,983)),
    PokemonFB(625,"5",R.drawable.bisharp, "Bisharp","Su séquito son los Pawniard. Acorralan a su presa con todo el grupo y Bisharp propina el golpe de gracia.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.ACERO), listOf(624, 625,983)),
    PokemonFB(626,"5",R.drawable.bouffalant, "Bouffalant","Embiste con la cabeza sin distinción. Su potencia es capaz de hacer descarrilar un tren en marcha.",listOf(PokemonTipoFB.NORMAL), listOf(626)),
    PokemonFB(627,"5",R.drawable.rufflet, "Rufflet","Desafía indiscriminadamente a rivales poderosos. Librar numerosas batallas lo hace fuerte.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.VOLADOR), listOf(627, 628)),
    PokemonFB(628,"5",R.drawable.braviary, "Braviary","Guerrero avezado. Su número de cicatrices es directamente proporcional al respeto que recibe de los suyos.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.VOLADOR), listOf(627, 628)),
    PokemonFB(629,"5",R.drawable.vullaby, "Vullaby","Usa una calavera para proteger sus posaderas. Es proclive a perseguir Pokémon débiles.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.VOLADOR), listOf(629, 630)),
    PokemonFB(630,"5",R.drawable.mandibuzz, "Mandibuzz","Vuela en círculos. Cuando avista una presa, la ataca y la transporta a su nido con suma facilidad.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.VOLADOR), listOf(629, 630)),
    PokemonFB(631,"5",R.drawable.heatmor, "Heatmor","Usa su lengua de fuego para derretir la armadura de los Durant y llegar así hasta su interior.",listOf(PokemonTipoFB.FUEGO), listOf(631)),
    PokemonFB(632,"5",R.drawable.durant, "Durant","Abre agujeros en las montañas. Los intrincados túneles son obras laberínticas de los Durant.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.ACERO), listOf(632)),
    PokemonFB(633,"5",R.drawable.deino, "Deino","Mordisquea todo aquello a su paso y se come todo aquello que sea comestible. Es peligroso acercarse a él sin cuidado.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.DRAGON), listOf(633, 634, 635)),
    PokemonFB(634,"5",R.drawable.zweilous, "Zweilous","Sus dos cabezas se llevan mal y se disputan la comida con brutalidad. Por eso acaban comiendo más de la cuenta.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.DRAGON), listOf(633, 634, 635)),
    PokemonFB(635,"5",R.drawable.hydreigon, "Hydreigon","Las cabezas de sus dos brazos no tienen cerebro. Con sus tres cabezas destruye y devora todo a su paso.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.DRAGON), listOf(633, 634, 635)),
    PokemonFB(636,"5",R.drawable.larvesta, "Larvesta","Vive en las laderas de los volcanes. Emite fuego por sus cinco cuernos para ahuyentar a sus enemigos.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.FUEGO), listOf(636, 637)),
    PokemonFB(637,"5",R.drawable.volcarona, "Volcarona","Cuando combate, despide escamas ardientes de sus seis alas y genera un mar ígneo a su alrededor.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.FUEGO), listOf(636, 637)),
    PokemonFB(638,"5",R.drawable.cobalion, "Cobalion","Posee un cuerpo y un corazón de acero. Basta una mirada suya para que Pokémon violentos le obedezcan.",listOf(PokemonTipoFB.ACERO,PokemonTipoFB.LUCHA), listOf(638)),
    PokemonFB(639,"5",R.drawable.terrakion, "Terrakion","Su potencia al embestir es capaz de derribar las murallas de un castillo. Las leyendas hablan de sus proezas.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.LUCHA), listOf(639)),
    PokemonFB(640,"5",R.drawable.virizion, "Virizion","Sus cuernos son hojas afiladas. Sacude a sus enemigos con sus relampagueantes movimientos y los reduce.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.LUCHA), listOf(640)),
    PokemonFB(641,"5",R.drawable.tornadus, "Tornadus","La energía que desprende de su cola genera violentas tempestades capaces de echar abajo casas.",listOf(PokemonTipoFB.VOLADOR), listOf(641)),
    PokemonFB(642,"5",R.drawable.thundurus, "Thundurus","Lanza descargas eléctricas por las púas de su cola. Sobrevuela Teselia dejando caer rayos.",listOf(PokemonTipoFB.ELECTRICO,PokemonTipoFB.VOLADOR), listOf(642)),
    PokemonFB(643,"5",R.drawable.reshiram, "Reshiram","Cuando la cola de Reshiram arde, su energía calorífica altera la atmósfera, y el tiempo meteorológico cambia.",listOf(PokemonTipoFB.DRAGON,PokemonTipoFB.FUEGO), listOf(643)),
    PokemonFB(644,"5",R.drawable.zekrom, "Zekrom","Pokémon que aparece en los mitos de antaño. Su cola está provista de un enorme generador de electricidad.",listOf(PokemonTipoFB.DRAGON,PokemonTipoFB.ELECTRICO), listOf(644)),
    PokemonFB(645,"5",R.drawable.landorus, "Landorus","Utiliza energía que obtiene del viento y del relámpago para nutrir el suelo y generar abundantes cosechas.",listOf(PokemonTipoFB.TIERRA,PokemonTipoFB.VOLADOR), listOf(645)),
    PokemonFB(646,"5",R.drawable.kyurem, "Kyurem","Pokémon legendario que aguarda al héroe que compense el vacío de su cuerpo de hielo con verdad e ideales.",listOf(PokemonTipoFB.DRAGON,PokemonTipoFB.HIELO), listOf(646)),
    PokemonFB(647,"5",R.drawable.keldeo, "Keldeo","Desprende agua por sus pezuñas para poder deslizarse. Es especialista en atacar usando sus patas.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.LUCHA), listOf(647)),
    PokemonFB(648,"5",R.drawable.meloetta, "Meloetta","Se han creado innumerables canciones inspiradas en las melodías que emite Meloetta.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.PSIQUICO), listOf(648)),
    PokemonFB(649,"5",R.drawable.genesect, "Benesect","Pokémon de tipo bicho de la antigüedad, modificado por el Equipo Plasma. El cañón de su lomo ha sido mejorado.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.ACERO), listOf(649)),
    PokemonFB(650,"6",R.drawable.chespin, "Chespin","Cuando acumula energía, las suaves púas de su cabeza se vuelven tan duras y afiladas que hasta pueden atravesar rocas.",listOf(PokemonTipoFB.PLANTA), listOf(650, 651, 652)),
    PokemonFB(651,"6",R.drawable.quilladin, "Quilladin","Chocan contra sus congéneres para fortalecer sus piernas. Debido a su carácter afable, nunca son los que provocan un combate.",listOf(PokemonTipoFB.PLANTA), listOf(650, 651, 652)),
    PokemonFB(652,"6",R.drawable.chesnaught, "Chesnaught","Su fuerza es tal que, de un empellón, puede hacer volcar un tanque de 50 toneladas. Protege a sus aliados cuando hace de escudo.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.LUCHA), listOf(650, 651, 652)),
    PokemonFB(653,"6",R.drawable.fennekin, "Fennekin","Tras masticar e ingerir pequeñas ramas se siente pletórico y expulsa aire caliente por sus grandes orejas a temperaturas superiores a los 200 °C.",listOf(PokemonTipoFB.FUEGO), listOf(653, 654, 655)),
    PokemonFB(654,"6",R.drawable.braixen, "Braixen","Al extraer la rama que tiene en la cola, esta prende debido a la fricción. Usa esa rama candente para enviar señales a sus compañeros.",listOf(PokemonTipoFB.FUEGO), listOf(653, 654, 655)),
    PokemonFB(655,"6",R.drawable.delphox, "Delphox","Fija la mirada en la llama que arde en la punta de su bastón para concentrarse y prever sucesos que tienen lugar en el futuro.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.PSIQUICO), listOf(653, 654, 655)),
    PokemonFB(656,"6",R.drawable.froakie, "Froakie","Protege su piel cubriendo el cuerpo con una fina capa de burbujas. Aunque parezca despreocupado, no deja de vigilar con astucia lo que le rodea.",listOf(PokemonTipoFB.AGUA), listOf(656, 657, 658)),
    PokemonFB(657,"6",R.drawable.frogadier, "Frogadier","Su agilidad no tiene parangón. De hecho, es capaz de escalar una torre de más de 600 metros en tan solo un minuto.",listOf(PokemonTipoFB.AGUA), listOf(656, 657, 658)),
    PokemonFB(658,"6",R.drawable.greninja, "Greninja","Aparece y desaparece de improvisto, cual ninja. Marea al oponente con su soberbia agilidad y lo hace trizas con sus Shuriken de Agua.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.SINIESTRO), listOf(656, 657, 658)),
    PokemonFB(659,"6",R.drawable.bunnelby, "Bunnelby","Tiene unas orejas tan grandes que parecen palas. Las ha fortalecido tanto usándolas para excavar que son capaces de arrancar raíces bien gruesas.",listOf(PokemonTipoFB.NORMAL), listOf(659, 660)),
    PokemonFB(660,"6",R.drawable.diggersby, "Diggersby","Sus grandes orejas tienen tal fuerza que con ellas puede levantar con facilidad rocas de más de una tonelada. Es de una ayuda inestimable en las obras.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.TIERRA), listOf(659, 660)),
    PokemonFB(661,"6",R.drawable.fletchling, "Fletchling","Su melodioso gorjeo lo dota de una gran belleza, pero adopta una actitud agresiva y despiadada hacia cualquiera que ose invadir su territorio.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.VOLADOR), listOf(661, 662, 663)),
    PokemonFB(662,"6",R.drawable.fletchinder, "Fletchinder","Cuanto más intenso sea el calor que se genera en la saca de fuego de su vientre, más rápido es capaz de volar. Sin embargo, la llama tarda en prender.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.VOLADOR), listOf(661, 662, 663)),
    PokemonFB(663,"6",R.drawable.talonflame, "Talonflame","Llega a alcanzar los 500 km/h al perseguir a su presa, a quien le asesta el golpe de gracia con una patada muy potente.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.VOLADOR), listOf(661, 662, 663)),
    PokemonFB(664,"6",R.drawable.scatterbug, "Scatterbug","Cuando recibe el ataque de un Pokémon pájaro, expulsa unas escamas negras que provocan parálisis si se entra en contacto con ellas.",listOf(PokemonTipoFB.BICHO), listOf(664, 665, 666)),
    PokemonFB(665,"6",R.drawable.spewpa, "Spewpa","Habita en la sombra de la espesura. Si percibe alguna amenaza, su pelaje se eriza y se vuelve muy afilado para así intimidar al enemigo.",listOf(PokemonTipoFB.BICHO), listOf(664, 665, 666)),
    PokemonFB(666,"6",R.drawable.vivillon, "Vivillon","En el mundo existen Vivillon con diferentes motivos en sus alas. El clima de cada región influye en sus rasgos.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.VOLADOR), listOf(664, 665, 666)),
    PokemonFB(667,"6",R.drawable.litleo, "Litleo","Cuanto más poderoso es el enemigo al que se enfrenta, más calor desprende su mechón y más energía recorre todo su cuerpo.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.NORMAL), listOf(667, 668)),
    PokemonFB(668,"6",R.drawable.pyroar, "Pyroar","El macho con la melena de fuego más grande de toda la manada es el líder de sus compañeros.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.NORMAL), listOf(667, 668)),
    PokemonFB(669,"6",R.drawable.flabebe, "Flabebe","Puede controlar el poder oculto de las flores. La flor que lleva consigo es como si formara parte de su cuerpo.",listOf(PokemonTipoFB.HADA), listOf(669, 670, 671)),
    PokemonFB(670,"6",R.drawable.floette, "Floette","Revolotea alrededor de campos de flores y cuida de aquellas que empiezan a marchitarse. Usa en combate el poder oculto de las flores.",listOf(PokemonTipoFB.HADA), listOf(669, 670, 671)),
    PokemonFB(671,"6",R.drawable.florges, "Florges","Habita en preciosos jardines floridos. Absorbe la energía que emiten las plantas y la convierte en su fuente de poder.",listOf(PokemonTipoFB.HADA), listOf(669, 670, 671)),
    PokemonFB(672,"6",R.drawable.skiddo, "Skiddo","Se dice que fue la primera especie de Pokémon que se acostumbró a vivir con los seres humanos. Tiene una naturaleza muy afable.",listOf(PokemonTipoFB.PLANTA), listOf(672, 673)),
    PokemonFB(673,"6",R.drawable.gogoat, "Gogoat","Percibe los sentimientos del Entrenador por la forma en la que agarra sus cuernos, aunque sean variaciones sutiles, y así avanzan como si fueran un solo ente.",listOf(PokemonTipoFB.PLANTA), listOf(672, 673)),
    PokemonFB(674,"6",R.drawable.pancham, "Pancham","Se desvive tratando de fulminar a su rival con una mirada aterradora, pero en cuanto le acarician la cabeza, no puede evitar sonreír de oreja a oreja.",listOf(PokemonTipoFB.LUCHA), listOf(674, 675)),
    PokemonFB(675,"6",R.drawable.pangoro, "Pangoro","Es muy temperamental, pero no permite que nadie se meta con los débiles. Mediante su hoja, predice los movimientos del enemigo.",listOf(PokemonTipoFB.LUCHA,PokemonTipoFB.SINIESTRO), listOf(674, 675)),
    PokemonFB(676,"6",R.drawable.furfrou, "Flabebe","Cuando le esquilan su mullido pelaje, no solo mejora su apariencia, sino que aumenta su agilidad.",listOf(PokemonTipoFB.NORMAL), listOf(676)),
    PokemonFB(677,"6",R.drawable.espurr, "Espurr","Protege con las orejas el órgano con el que irradia su intenso poder psíquico para evitar que este escape al exterior.",listOf(PokemonTipoFB.PSIQUICO), listOf(677, 678)),
    PokemonFB(678,"6",R.drawable.meowstic, "Meowstic","Cuando percibe peligro, yergue sus orejas y desata un poder psíquico capaz de levantar un camión de unas 10 toneladas.",listOf(PokemonTipoFB.PSIQUICO), listOf(677, 678)),
    PokemonFB(679,"6",R.drawable.honedge, "Honedge","Si alguien osa empuñarlo, se enrolla en el brazo del desafortunado con su paño azul y le absorbe toda la energía hasta que pierde el sentido.",listOf(PokemonTipoFB.ACERO,PokemonTipoFB.FANTASMA), listOf(679, 680, 681)),
    PokemonFB(680,"6",R.drawable.doublade, "Doublade","Ni siquiera el espadachín más ducho conseguiría esquivar los complejos ataques que encadenan ambas espadas a la vez.",listOf(PokemonTipoFB.ACERO,PokemonTipoFB.FANTASMA), listOf(679, 680, 681)),
    PokemonFB(681,"6",R.drawable.aegislash, "Aegislash","Han permanecido junto a estirpes de reyes durante generaciones. Mediante su poder espectral pueden controlar a humanos y a Pokémon.",listOf(PokemonTipoFB.ACERO,PokemonTipoFB.FANTASMA), listOf(679, 680, 681)),
    PokemonFB(682,"6",R.drawable.spritzee, "Spritzee","Su cuerpo emana una fragancia que embelesa a quien la huele. La fragancia es diferente según los alimentos que ingiere.",listOf(PokemonTipoFB.HADA), listOf(682, 683)),
    PokemonFB(683,"6",R.drawable.aromatisse, "Aromatisse","Puede producir multitud de olores diferentes y, en combate, secreta los que le resultan molestos al enemigo para así contar con cierta ventaja.",listOf(PokemonTipoFB.HADA), listOf(682, 683)),
    PokemonFB(684,"6",R.drawable.swirlix, "Swirlix","Como se alimenta exclusivamente de dulces, su pelaje es tan pegajoso y dulzón como el algodón de azúcar.",listOf(PokemonTipoFB.HADA), listOf(684, 685)),
    PokemonFB(685,"6",R.drawable.slurpuff, "Slurpuff","Puede rastrear hasta el más débil de los olores. Hace uso de su fino olfato para ayudar a los pasteleros más exquisitos.",listOf(PokemonTipoFB.HADA), listOf(684, 685)),
    PokemonFB(686,"6",R.drawable.inkay, "Inkay","La luz intermitente que emite aplaca el ánimo de lucha del enemigo. Aprovecha la ocasión para esconderse.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.PSIQUICO), listOf(686, 687)),
    PokemonFB(687,"6",R.drawable.malamar, "Malamar","Tiene a su disposición los poderes hipnóticos más poderosos de entre todos los Pokémon. Controla al enemigo a su voluntad.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.PSIQUICO), listOf(686, 687)),
    PokemonFB(688,"6",R.drawable.binacle, "Binacle","Dos Binacle conviven en la misma roca, pero cuando se produce un altercado entre ambos, uno de ellos se muda a otra.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.AGUA), listOf(688, 689)),
    PokemonFB(689,"6",R.drawable.barbaracle, "Barbaracle","Si bien todas las extremidades de Barbaracle tienen cerebro propio y se mueven a su antojo, suelen seguir órdenes que imparte la cabeza.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.AGUA), listOf(688, 689)),
    PokemonFB(690,"6",R.drawable.skrelp, "Skrelp","Adopta la apariencia de algas podridas y lanza un líquido venenoso a las presas desprevenidas que pasan cerca.",listOf(PokemonTipoFB.VENENO,PokemonTipoFB.AGUA), listOf(690, 691)),
    PokemonFB(691,"6",R.drawable.dragalge, "Dragalge","Según se dice, los barcos que se aventuran en aguas donde habitan Dragalge desaparecen del mapa y no regresan a puerto.",listOf(PokemonTipoFB.VENENO,PokemonTipoFB.DRAGON), listOf(690, 691)),
    PokemonFB(692,"6",R.drawable.clauncher, "Clauncher","Abate a enemigos voladores disparando agua a presión con su enorme pinza como si de una pistola se tratara.",listOf(PokemonTipoFB.AGUA), listOf(692, 693)),
    PokemonFB(693,"6",R.drawable.clawitzer, "Clawitzer","Posee una enorme pinza que dispara bolas de agua que podrían atravesar incluso el casco de un petrolero.",listOf(PokemonTipoFB.AGUA), listOf(692, 693)),
    PokemonFB(694,"6",R.drawable.heliolisk, "Heliolisk","Habita en los desiertos y, cuando toma el sol, acumula energía, lo que le permite vivir sin la necesidad de ingerir alimentos.",listOf(PokemonTipoFB.ELECTRICO,PokemonTipoFB.NORMAL), listOf(695, 694)),
    PokemonFB(695,"6",R.drawable.helioptile, "Helioptile","Extiende su gorguera y genera energía eléctrica suficiente para cubrir el consumo de electricidad de un rascacielos entero.",listOf(PokemonTipoFB.ELECTRICO,PokemonTipoFB.NORMAL), listOf(695, 694)),
    PokemonFB(696,"6",R.drawable.tyrunt, "Tyrunt","Pokémon recreado a partir de fósiles. Cuando sucede algo que no es de su agrado, se enfurece y se vuelve violento.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.DRAGON), listOf(696, 697)),
    PokemonFB(697,"6",R.drawable.tyrantrum, "Tyrantrum","Hace 100 millones de años, este Pokémon se comportaba como un rey, sin nadie que osase hacerle frente.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.DRAGON), listOf(696, 697)),
    PokemonFB(698,"6",R.drawable.amaura, "Amaura","Pokémon que ha sido regenerado a partir de un trozo de su antiguo cuerpo, que quedó congelado hace unos 100 millones de años.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.HIELO), listOf(698, 699)),
    PokemonFB(699,"6",R.drawable.aurorus, "Aurorus","Expulsa un gas gélido a temperaturas inferiores a los -150 °C a través de sus cristales romboides y congela así a su enemigo.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.HIELO), listOf(698, 699)),
    PokemonFB(700,"6",R.drawable.sylveon, "Sylveon","A través de sus apéndices sensitivos con forma de cinta, emite unas ondas tranquilizadoras mediante las cuales detiene los combates.",listOf(PokemonTipoFB.HADA), listOf(133, 134, 135, 136, 196, 197, 470, 471, 700)),
    PokemonFB(701,"6",R.drawable.hawlucha, "Hawlucha","Controla su posición en el aire con las alas. Lanza ataques desde gran altura que resultan difíciles de evitar.",listOf(PokemonTipoFB.LUCHA,PokemonTipoFB.VOLADOR), listOf(701)),
    PokemonFB(702,"6",R.drawable.dedenne, "Dedenne","Con su cola absorbe la electricidad procedente de las centrales de energía o los enchufes de las casas, para liberarla en forma de ataque por los bigotes.",listOf(PokemonTipoFB.ELECTRICO,PokemonTipoFB.HADA), listOf(702)),
    PokemonFB(703,"6",R.drawable.carbink, "Carbink","Nace en las profundidades subterráneas, a altas temperaturas y a gran presión. Irradia energía por la roca que tiene en la cabeza.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.HADA), listOf(703)),
    PokemonFB(704,"6",R.drawable.goomy, "Goomy","Es el Pokémon de tipo Dragón más débil. Habita en zonas oscuras y húmedas para evitar que su viscoso cuerpo se seque.",listOf(PokemonTipoFB.DRAGON), listOf(704, 705, 706)),
    PokemonFB(705,"6",R.drawable.sliggoo, "Sliggoo","Segrega una mucosidad que corroe todo lo que toca y consigue así ahuyentar al enemigo. Sus ojos han involucionado, por lo que no puede ver.",listOf(PokemonTipoFB.DRAGON), listOf(704, 705, 706)),
    PokemonFB(706,"6",R.drawable.goodra, "Goodra","Ataca con sus antenas retráctiles, desplegando una fuerza comparable a los puñetazos de 100 boxeadores profesionales.",listOf(PokemonTipoFB.DRAGON), listOf(704, 705, 706)),
*/

/*
    PokemonFB(707,"6",R.drawable.klefki, "Klefki","Tiene el hábito de coleccionar llaves. Cuando un enemigo lo ataca, las hace tintinear como método de intimidación.",listOf(PokemonTipoFB.ACERO,PokemonTipoFB.HADA), listOf(707)),
    PokemonFB(708,"6",R.drawable.phantump, "Phantump","Nace cuando el alma de un niño perdido habita un tocón. Su grito se asemeja a un escalofriante chillido.",listOf(PokemonTipoFB.FANTASMA,PokemonTipoFB.PLANTA), listOf(708, 709)),
    PokemonFB(709,"6",R.drawable.trevenant, "Trevenant","Es amable con los seres que habitan los bosques, pero se cuenta que devora a quienes los mancillan.",listOf(PokemonTipoFB.FANTASMA,PokemonTipoFB.PLANTA), listOf(708, 709)),
    PokemonFB(710,"6",R.drawable.pumpkaboo, "Pumpkaboo","En el interior de la calabaza reside un espíritu que ha permanecido atrapado en este mundo. Entra en acción al caer la noche.",listOf(PokemonTipoFB.FANTASMA,PokemonTipoFB.PLANTA), listOf(710, 711)),
    PokemonFB(711,"6",R.drawable.gourgeist, "Gourgeist","En las noches de luna nueva deambula por las calles de las ciudades y emite espeluznantes alaridos que maldicen a quienes los oyen.",listOf(PokemonTipoFB.FANTASMA,PokemonTipoFB.PLANTA), listOf(710, 711)),
    PokemonFB(712,"6",R.drawable.bergmite, "Bergmite","Envuelve su cuerpo en una capa de hielo que le permite evitar los ataques del enemigo. Si se resquebraja, la recompone con aire gélido.",listOf(PokemonTipoFB.HIELO), listOf(712, 713)),
    PokemonFB(713,"6",R.drawable.avalugg, "Avalugg","Parece un portaaviones de hielo, por el aspecto que presenta al llevar varios Bergmite en su espalda.",listOf(PokemonTipoFB.HIELO), listOf(712, 713)),
    PokemonFB(714,"6",R.drawable.noibat, "Noibat","Habita en cuevas donde reina la más absoluta oscuridad y emite ondas ultrasónicas de 200 000 Hz a través de sus enormes orejas.",listOf(PokemonTipoFB.VOLADOR,PokemonTipoFB.DRAGON), listOf(714, 715)),
    PokemonFB(715,"6",R.drawable.noivern, "Noivern","Surca el cielo nocturno cuando ni siquiera la luna brilla y ataca a presas incautas. Es imbatible en combates que tienen lugar a oscuras.",listOf(PokemonTipoFB.VOLADOR,PokemonTipoFB.DRAGON), listOf(714, 715)),
    PokemonFB(716,"6",R.drawable.xerneas, "Xerneas","Cuando los cuernos de su cabeza brillan en siete colores, se dice que comparte el don de la vida eterna.",listOf(PokemonTipoFB.HADA), listOf(716)),
    PokemonFB(717,"6",R.drawable.yveltal, "Yveltal","Pokémon legendario que, al extender sus alas y las plumas de la cola, emite un brillo carmesí que absorbe la energía vital de su enemigo.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.VOLADOR), listOf(717)),
    PokemonFB(718,"6",R.drawable.zygarde, "Zygarde","Cuando el ecosistema de Kalos se encuentra en peligro, aparece y revela su poder secreto.",listOf(PokemonTipoFB.DRAGON,PokemonTipoFB.TIERRA), listOf(718)),
    PokemonFB(719,"6",R.drawable.diancie, "Diancie","Es una transformación súbita de Carbink. Se dice que su cuerpo, que irradia destellos rosados, es lo más bonito de este mundo.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.HADA), listOf(719)),
    PokemonFB(720,"6",R.drawable.hoopa, "Hoopa","Reúne los objetos que le atraen para esconderlos en una guarida secreta, teletransportándolos a través de sus anillos.",listOf(PokemonTipoFB.PSIQUICO,PokemonTipoFB.FANTASMA), listOf(720)),
    PokemonFB(721,"6",R.drawable.volcanion, "Volcanion","Expulsa vapor y desaparece entre la densa niebla. Dicen que habita en montañas solitarias.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.AGUA), listOf(721)),
    PokemonFB(722,"7",R.drawable.rowlet, "Rowlet","Es cauteloso, desconfiado y de naturaleza nocturna. Durante el día acumula energía mediante la fotosíntesis.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.VOLADOR), listOf(722, 723, 724)),
    PokemonFB(723,"7",R.drawable.dartrix, "Dartrix","Ataca a sus presas y enemigos lanzándoles plumas sorprendentemente afiladas. Acierta prácticamente siempre.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.VOLADOR), listOf(722, 723, 724)),
    PokemonFB(724,"7",R.drawable.decidueye, "Decidueye","Las plumas de sus alas le sirven de flechas con las que puede acertar a un guijarro a 100 m.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.FANTASMA), listOf(722, 723, 724)),
    PokemonFB(725,"7",R.drawable.litten, "Litten","Prende las bolas de pelo que se forman en su estómago tras acicalarse. Las llamas que escupe tienen formas variopintas.",listOf(PokemonTipoFB.FUEGO), listOf(725, 726, 727)),
    PokemonFB(726,"7",R.drawable.torracat, "Torracat","Luce al cuello un cascabel incandescente que tintinea con fuerza cuando desprende llamas.",listOf(PokemonTipoFB.FUEGO), listOf(725, 726, 727)),
    PokemonFB(727,"7",R.drawable.incineroar, "Incineroar","Posee un carácter rudo y egoísta. Si un Entrenador no le cae en gracia, ignora sus órdenes con total impasibilidad.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.SINIESTRO), listOf(725, 726, 727)),
    PokemonFB(728,"7",R.drawable.popplio, "Popplio","Maneja con soltura los globos de agua que crea, pero, para poder hacer uno bien grande, necesita practicar sin descanso.",listOf(PokemonTipoFB.AGUA), listOf(728, 729, 730)),
    PokemonFB(729,"7",R.drawable.brionne, "Brionne","Un bailarín consumado. Crea globos de agua con los que golpea a sus rivales una y otra vez sin dejar de bailar.",listOf(PokemonTipoFB.AGUA), listOf(728, 729, 730)),
    PokemonFB(730,"7",R.drawable.primarina, "Primarina","Se vale de su canto para atacar a los rivales. Su Entrenador deberá velar por que sus cuerdas vocales estén siempre en perfecto estado.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.HADA), listOf(728, 729, 730)),
    PokemonFB(731,"7",R.drawable.pikipek, "Pikipek","Hace agujeros en los árboles a una velocidad de 16 picotazos por segundo y los utiliza como despensa o como su nido.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.VOLADOR), listOf(731, 732, 733)),
    PokemonFB(732,"7",R.drawable.trumbeak, "Trumbeak","Puede deformar su pico para producir los sonidos más diversos. Debido al estruendo que crea, se granjea la enemistad de sus vecinos.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.VOLADOR), listOf(731, 732, 733)),
    PokemonFB(733,"7",R.drawable.toucannon, "Toucannon","Cuando va a combatir, calienta su pico hasta temperaturas que superan los 100 °C, lo que puede causar graves quemaduras al contacto.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.VOLADOR), listOf(731, 732, 733)),
    PokemonFB(734,"7",R.drawable.yungoos, "Yungoos","Sus afilados colmillos lo atraviesan todo. No es autóctono de Alola, sino que proviene de otra región.",listOf(PokemonTipoFB.NORMAL), listOf(734, 735)),
    PokemonFB(735,"7",R.drawable.gumshoos, "Gumshoos","Al detectar el rastro de una presa, la acecha con tenacidad, pero al ponerse el sol le vence el sueño.",listOf(PokemonTipoFB.NORMAL), listOf(734, 735)),
    PokemonFB(736,"7",R.drawable.grubbin, "Grubbin","Con sus duras mandíbulas arranca la corteza de los árboles y sorbe la savia. Suele habitar bajo tierra.",listOf(PokemonTipoFB.BICHO), listOf(736, 737, 738)),
    PokemonFB(737,"7",R.drawable.charjabug, "Charjabug","Al hacer la digestión genera energía eléctrica que almacena en la bolsa que posee para tal efecto.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.ELECTRICO), listOf(736, 737, 738)),
    PokemonFB(738,"7",R.drawable.vikavolt, "Vikavolt","Sobrevuela un área en busca de presas. Puede concentrar una potente carga eléctrica entre sus mandíbulas para atacar a sus rivales.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.ELECTRICO), listOf(736, 737, 738)),
    PokemonFB(739,"7",R.drawable.crabrawler, "Crabrawler","Protege sus puntos débiles con las pinzas y propina puñetazos en cuanto tiene ocasión. Cuando pierde, llora lágrimas espumosas.",listOf(PokemonTipoFB.LUCHA), listOf(739, 740)),
    PokemonFB(740,"7",R.drawable.crabominable, "Crabominable","Tras perderse intentando coronar una alta montaña, desarrolló una capa de pelo para protegerse del frío.",listOf(PokemonTipoFB.LUCHA,PokemonTipoFB.HIELO), listOf(739, 740)),
    PokemonFB(741,"7",R.drawable.oricorio, "Oricorio","Junta las alas y lanza voraces llamas al rival. Su ataque se asemeja a una elaborada coreografía de fuego.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.VOLADOR), listOf(741)),
    PokemonFB(742,"7",R.drawable.cutiefly, "Cutiefly","Se alimenta de néctar y polen. Es capaz de detectar los capullos que están a punto de abrirse.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.HADA), listOf(742, 743)),
    PokemonFB(743,"7",R.drawable.ribombee, "Ribombee","Fabrica varios tipos de bolas de polen. Algunas se usan como alimento y otras para el combate.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.HADA), listOf(742, 743)),
    PokemonFB(744,"7",R.drawable.rockruff, "Rockruff","Su carácter amigable lo convierte en el Pokémon ideal para Entrenadores novatos. Sin embargo, al crecer suele volverse un poco agresivo.",listOf(PokemonTipoFB.ROCA), listOf(744, 745)),
    PokemonFB(745,"7",R.drawable.lycanroc, "Lycanroc","Cuanto más fuerte es su rival, más se crece. Sus ansias de ganar lo llevan a arrojarse sobre él sin consideración por su propia vida.",listOf(PokemonTipoFB.ROCA), listOf(744, 745)),
    PokemonFB(746,"7",R.drawable.wishiwashi, "Wishiwashi","Cuando los pequeños y débiles Wishiwashi se agrupan en bancos, se convierten en una bestia marina temida por todos.",listOf(PokemonTipoFB.AGUA), listOf(746)),
    PokemonFB(747,"7",R.drawable.mareanie, "Mareanie","Aturde a su presa con los aguijones venenosos de la cabeza. Cuando esta se debilita, la rodea con sus diez extremidades y la remata.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.VENENO), listOf(747, 748)),
    PokemonFB(748,"7",R.drawable.toxapex, "Toxapex","Se arrastra por el lecho marino con sus doce extremidades. Deja siempre una estela de restos de Corsola por donde pasa.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.VENENO), listOf(747, 748)),
    PokemonFB(749,"7",R.drawable.mudbray, "Mudbray","El lodo que impregna sus patas le otorga una fuerte tracción, lo que le permite alcanzar altas velocidades al correr.",listOf(PokemonTipoFB.TIERRA), listOf(749, 750)),
    PokemonFB(750,"7",R.drawable.mudsdale, "Mudsdale","El lodo que segrega por la boca se vuelve impermeable al secarse, por lo que solía usarse como capa aislante en las paredes de las casas.",listOf(PokemonTipoFB.TIERRA), listOf(749, 750)),
    PokemonFB(751,"7",R.drawable.dewpider, "Dewpider","Emerge a la superficie para alimentarse. La burbuja con la que se rodea le sirve para respirar y proteger su delicada cabeza.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.BICHO), listOf(751, 752)),
    PokemonFB(752,"7",R.drawable.araquanid, "Araquanid","Es más atento de lo que parece. Si encuentra a uno de los suyos débil o vulnerable, lo protege envolviéndolo con su burbuja.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.BICHO), listOf(751, 752)),
    PokemonFB(753,"7",R.drawable.fomantis, "Fomantis","Desprende un aroma fresco y dulce. En la hierba alta donde se esconde también suelen acudir Cutiefly.",listOf(PokemonTipoFB.PLANTA), listOf(753, 754)),
    PokemonFB(754,"7",R.drawable.lurantis, "Lurantis","Dedica mucho tiempo y esfuerzo a acicalarse y preservar sus vivos colores. A algunos ejemplares incluso les lleva todo el día.",listOf(PokemonTipoFB.PLANTA), listOf(753, 754)),
    PokemonFB(755,"7",R.drawable.morelull, "Morelull","Cuando titila, esparce esporas luminosas a su alrededor. Todo aquel que ve esta luz cae en un profundo sueño.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.HADA), listOf(755, 756)),
    PokemonFB(756,"7",R.drawable.shiinotic, "Shiinotic","Las esporas parpadeantes que despide tienen un efecto somnífero. Absorbe la vitalidad de su presa cuando esta se queda dormida.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.HADA), listOf(755, 756)),
    PokemonFB(757,"7",R.drawable.salandit, "Salandit","Aturde a sus oponentes con un gas venenoso que produce al quemar sus fluidos corporales y luego se abalanza sobre ellos.",listOf(PokemonTipoFB.VENENO,PokemonTipoFB.FUEGO), listOf(757, 758)),
    PokemonFB(758,"7",R.drawable.salazzle, "Salazzle","Por algún motivo desconocido, solo hay hembras. Suele formarse su propio harén compuesto por Salandit machos.",listOf(PokemonTipoFB.VENENO,PokemonTipoFB.FUEGO), listOf(757, 758)),
    PokemonFB(759,"7",R.drawable.stufful, "Stufful","Pese a su aspecto encantador, cuando se enoja, sus pataletas son tan feroces que pueden derribar hasta a un luchador profesional.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.LUCHA), listOf(759, 760)),
    PokemonFB(760,"7",R.drawable.bewear, "Bewear","Es un Pokémon muy peligroso por su fuerza descomunal. Normalmente se desaconseja penetrar en su hábitat.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.LUCHA), listOf(759, 760)),
    PokemonFB(761,"7",R.drawable.bounsweet, "Bounsweet","Atraídos por el apetitoso aroma que desprende su cuerpo, los Toucannon los engullen con avidez sin ni siquiera masticar.",listOf(PokemonTipoFB.PLANTA), listOf(761, 762, 763)),
    PokemonFB(762,"7",R.drawable.steenee, "Steenee","Puede jugar con Pokémon pájaro sin peligro gracias al duro cáliz que protege su cuerpo. No le importa que lo picoteen.",listOf(PokemonTipoFB.PLANTA), listOf(761, 762, 763)),
    PokemonFB(763,"7",R.drawable.tsareena, "Tsareena","Propina bellas patadas con elegancia. Una sola bastaría para dejar fuera de combate a un campeón de kickboxing.",listOf(PokemonTipoFB.PLANTA), listOf(761, 762, 763)),
    PokemonFB(764,"7",R.drawable.comfey, "Comfey","Prende flores en su tallo, que es muy rico en nutrientes. Las flores se revitalizan y desprenden una agradable fragancia.",listOf(PokemonTipoFB.HADA), listOf(764)),
    PokemonFB(765,"7",R.drawable.oranguru, "Oranguru","Es un Pokémon famoso por su astucia e ingenio. Desprecia a los Entrenadores novatos y prefiere a los más veteranos.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.PSIQUICO), listOf(765)),
    PokemonFB(766,"7",R.drawable.passimian, "Passimian","Suele ir en grupos de unos veinte ejemplares. Sus miembros permanecen siempre unidos y nunca se abandonan unos a otros.",listOf(PokemonTipoFB.LUCHA), listOf(766)),
    PokemonFB(767,"7",R.drawable.wimpod, "Wimpod","Cuando se asusta, huye despavorido moviendo rápidamente sus múltiples patas. Deja el suelo limpio y pulido allí por donde pasa.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.AGUA), listOf(767, 768)),
    PokemonFB(768,"7",R.drawable.golisopod, "Golisopod","Gracias a su destreza y sus enormes y afiladas garras, puede cortar hasta el aire y el agua de un solo tajo.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.AGUA), listOf(767, 768)),
    PokemonFB(769,"7",R.drawable.sandygast, "Sandygast","Surgió cuando una persona murió abandonada en plena calle y su resentimiento poseyó un montículo de arena apilado por un niño.",listOf(PokemonTipoFB.FANTASMA,PokemonTipoFB.TIERRA), listOf(769, 770)),
    PokemonFB(770,"7",R.drawable.palossand, "Palossand","Manipulando a la gente ha conseguido transformarse en todo un castillo de arena, lo que ha aumentado su poder maligno.",listOf(PokemonTipoFB.FANTASMA,PokemonTipoFB.TIERRA), listOf(769, 770)),
    PokemonFB(771,"7",R.drawable.pyukumuku, "Pyukumuku","Vive en las playas y en aguas poco profundas. Expulsa sus entrañas para engañar a sus depredadores y librarse de ellos.",listOf(PokemonTipoFB.AGUA), listOf(771)),
    PokemonFB(772,"7",R.drawable.codigocero, "Código Cero","La pesada máscara le impide liberar toda su fuerza, que se cree que es extraordinaria.",listOf(PokemonTipoFB.NORMAL), listOf(772,773)),
    PokemonFB(773,"7",R.drawable.silvally, "Silvally","Tras descubrir la máscara de contención que lo controlaba, ahora puede modificar su tipo en función del disco que utilice.",listOf(PokemonTipoFB.NORMAL), listOf(772,773)),
    PokemonFB(774,"7",R.drawable.minior, "Minior","Se alimenta de las partículas que flotan la atmósfera. El color de su núcleo depende de la composición de estas.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.VOLADOR), listOf(774)),
    PokemonFB(775,"7",R.drawable.komala, "Komala","Pasa la vida entera sumido en un profundo sueño. Toda su actividad parece reflejar los sueños que tiene en ese momento.",listOf(PokemonTipoFB.NORMAL), listOf(775)),
    PokemonFB(776,"7",R.drawable.turtonator, "Turtonator","Posee un caparazón que estalla al contacto. El orificio que se aprecia en su vientre es su punto débil.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.DRAGON), listOf(776)),
    PokemonFB(777,"7",R.drawable.togedemaru, "Togedemaru","Cuando se siente amenazado, eriza las púas de su lomo para pinchar a quien ose atacarlo.",listOf(PokemonTipoFB.ELECTRICO,PokemonTipoFB.ACERO), listOf(777)),
    PokemonFB(778,"7",R.drawable.mimikyu, "Mimikyu","Su verdadero aspecto es un misterio total. Un investigador que intentó mirar dentro del saco recibió, literalmente, un susto de muerte.",listOf(PokemonTipoFB.FANTASMA,PokemonTipoFB.HADA), listOf(778)),
    PokemonFB(779,"7",R.drawable.bruxish, "Bruxish","Cuando la protuberancia que tiene en la cabeza emite poderes psíquicos, se escucha como un ruido de dientes rechinando muy molesto.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.PSIQUICO), listOf(779)),
    PokemonFB(780,"7",R.drawable.drampa, "Drampa","Es de naturaleza mansa, pero si se le provoca y monta en cólera, destruye todo lo que le rodea con su aliento devastador.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.DRAGON), listOf(780)),
    PokemonFB(781,"7",R.drawable.dhelmise, "Dhelmise","Los giros de su enorme ancla son capaces de noquear al mismísimo Wailord de un solo golpe. El alga verde es su verdadero cuerpo.",listOf(PokemonTipoFB.FANTASMA,PokemonTipoFB.PLANTA), listOf(781)),
    PokemonFB(782,"7",R.drawable.jangmoo, "Jangmo-o","Habita en montañas despobladas. Luchan entre ellos para fortalecerse poco a poco.",listOf(PokemonTipoFB.DRAGON), listOf(782, 783, 784)),
    PokemonFB(783,"7",R.drawable.hakamoo, "Hakamo-o","Se lanza sobre su presa entonando un grito de guerra. Golpea al enemigo y lo hace trizas con sus escamas.",listOf(PokemonTipoFB.DRAGON,PokemonTipoFB.LUCHA), listOf(782, 783, 784)),
    PokemonFB(784,"7",R.drawable.kommoo, "Kommo-o","Sus sólidas escamas le sirven tanto para atacar como para defenderse. Antaño se usaban para fabricar armas u objetos de uso cotidiano.",listOf(PokemonTipoFB.DRAGON,PokemonTipoFB.LUCHA), listOf(782, 783, 784)),
    PokemonFB(785,"7",R.drawable.tapukoko, "Tapu Koko","El espíritu guardián de Melemele, curioso e inquisitivo. Invoca nubes de tormenta y acumula el poder de los rayos en su cuerpo.",listOf(PokemonTipoFB.ELECTRICO,PokemonTipoFB.HADA), listOf(785)),
    PokemonFB(786,"7",R.drawable.tapulele, "Tapu Lele","El espíritu guardián de Akala, tan inocente como cruel. La fragancia de las flores constituye su fuente de energía.",listOf(PokemonTipoFB.PSIQUICO,PokemonTipoFB.HADA), listOf(786)),
    PokemonFB(787,"7",R.drawable.tapubulu, "Tapu Bulu","Arranca de cuajo árboles grandes para hacerlos girar. Vuelve exuberante la vegetación y luego absorbe su energía.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.HADA), listOf(787)),
    PokemonFB(788,"7",R.drawable.tapufini, "Tapu Fini","Desconcierta al enemigo provocando una espesa niebla que se convierte en su perdición. Las corrientes marinas son su fuente de energía.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.HADA), listOf(788)),
    PokemonFB(789,"7",R.drawable.cosmog, "Cosmog","Su cuerpo se compone de una materia gaseosa inestable. Crece poco a poco al acumular las motas de polvo que flotan en el aire.",listOf(PokemonTipoFB.PSIQUICO), listOf(789, 790, 791, 792)),
    PokemonFB(790,"7",R.drawable.cosmoem, "Cosmoem","Permanece inmóvil, como si estuviera muerto, aunque al tocarlo se percibe un ligero calor. Antaño se le llamaba Crisálida de las Estrellas.",listOf(PokemonTipoFB.PSIQUICO), listOf(789, 790, 791, 792)),
    PokemonFB(791,"7",R.drawable.solgaleo, "Solgaleo","Se cree que proviene de otro mundo. El brillo que emite su cuerpo es tal que puede hacer que la noche más profunda parezca pleno día.",listOf(PokemonTipoFB.PSIQUICO,PokemonTipoFB.ACERO), listOf(789, 790, 791)),
    PokemonFB(792,"7",R.drawable.lunala, "Lunala","Se dice que es la evolución final hembra de Cosmog. Su tercer ojo aparece cuando se traslada a un mundo distinto.",listOf(PokemonTipoFB.PSIQUICO,PokemonTipoFB.FANTASMA), listOf(789, 790, 792)),
    PokemonFB(793,"7",R.drawable.nihilego, "Nihilego","Se desconoce si este Ultraente posee consciencia propia, pero en ocasiones se comporta como una chica joven.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.VENENO), listOf(793)),
    PokemonFB(794,"7",R.drawable.buzzwole, "Buzzwole","Un Ultraente rodeado de misterio. Se le ha visto reducir a añicos un camión de un solo puñetazo.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.LUCHA), listOf(794)),
    PokemonFB(795,"7",R.drawable.pheromosa, "Pheromosa","Uno de los temibles Ultraentes. Se dice que ha sido avistado recorriendo la superficie terrestre a velocidades de vértigo.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.LUCHA), listOf(795)),
    PokemonFB(796,"7",R.drawable.xurkitree, "Xurkitree","Un Ultraente rodeado de misterio. Se dice que su cuerpo desprende descargas eléctricas de inmensa potencia.",listOf(PokemonTipoFB.ELECTRICO), listOf(796)),
    PokemonFB(797,"7",R.drawable.celesteela, "Celesteela","Este Ultraente surgió de un Ultraumbral. Parece haber sido avistado surcando los cielos a velocidades vertiginosas.",listOf(PokemonTipoFB.ACERO,PokemonTipoFB.VOLADOR), listOf(797)),
    PokemonFB(798,"7",R.drawable.kartana, "Kartana","Este Ultraente surgió de un Ultraumbral. Se dice que no es muy agresivo, pero su afilado cuerpo es un arma realmente peligrosa.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.ACERO), listOf(798)),
    PokemonFB(799,"7",R.drawable.guzzlord, "Guzzlord","Se dice que este Ultraente ha sido avistado devorando montañas enteras y tragándose prominentes edificios.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.DRAGON), listOf(799)),
    PokemonFB(800,"7",R.drawable.necrozma, "Necrozma","Se dice que yacía en el interior de la tierra. Se cree que esta criatura, parecida a un Ultraente, vino de otro mundo hace muchísimo tiempo.",listOf(PokemonTipoFB.PSIQUICO), listOf(800)),
    PokemonFB(801,"7",R.drawable.magearna, "Magearna","Pokémon artificial creado hace más de 500 años. Es capaz de entender el lenguaje humano pero carece de la facultad del habla.",listOf(PokemonTipoFB.ACERO,PokemonTipoFB.HADA), listOf(801)),
    PokemonFB(802,"7",R.drawable.marshadow, "Marshadow","Debido a que siempre se ha ocultado en las sombras y no le gusta dejarse ver, su misma existencia es todo un misterio.",listOf(PokemonTipoFB.LUCHA,PokemonTipoFB.FANTASMA), listOf(802)),
    PokemonFB(803,"7",R.drawable.poipole, "Poipole","En su mundo, este Ultraente se considera tan entrañable como para ser elegido compañero de viaje.",listOf(PokemonTipoFB.VENENO), listOf(803, 804)),
    PokemonFB(804,"7",R.drawable.naganadel, "Naganadel","Uno de los Ultraentes. Su aguijón segrega un líquido tóxico cuya viscosidad le da una apariencia brillante.",listOf(PokemonTipoFB.VENENO,PokemonTipoFB.DRAGON), listOf(803, 804)),
    PokemonFB(805,"7",R.drawable.stakataka, "Stakataka","Extraña criatura que podría ser un Ultraente. Parece un muro rocoso hasta que se mueve de repente y ataca.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.ACERO), listOf(805)),
    PokemonFB(806,"7",R.drawable.blacephalon, "Blacephalon","Un Ultraente surgido de un Ultraumbral. Crea una explosión para sorprender al oponente y aprovecha para absorber su energía vital.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.FANTASMA), listOf(806)),
    PokemonFB(807,"7",R.drawable.zeraora, "Zeraora","Tan veloz como el rayo, hace trizas a cualquier rival con sus garras cargadas de electricidad de alto voltaje.",listOf(PokemonTipoFB.ELECTRICO), listOf(807)),
    PokemonFB(808,"7",R.drawable.meltan, "Meltan","Funde metales para ingerirlos. Una vez licuados, los hace circular por el interior de su cuerpo para generar energía.",listOf(PokemonTipoFB.ACERO), listOf(808, 809)),
    PokemonFB(809,"7",R.drawable.melmetal, "Melmetal","En la antigüedad se le veneraba por su poder de crear hierro. Después de tres milenios, ha regresado misteriosamente.",listOf(PokemonTipoFB.ACERO), listOf(808, 809)),
    PokemonFB(810,"8",R.drawable.grookey, "Grookey","Al marcar el ritmo con su baqueta especial, produce unas ondas sonoras capaces de devolver la vitalidad a la flora.",listOf(PokemonTipoFB.PLANTA), listOf(810, 811, 812)),
    PokemonFB(811,"8",R.drawable.thwackey, "Thwackey","Los Thwackey que marcan el ritmo más contundente con sus dos baquetas son los más respetados por sus congéneres.",listOf(PokemonTipoFB.PLANTA), listOf(810, 811, 812)),
    PokemonFB(812,"8",R.drawable.rillaboom, "Rillaboom","Controla los poderes y las raíces de su singular tocón en combate golpeándolo como si fuera un tambor.",listOf(PokemonTipoFB.PLANTA), listOf(810, 811, 812)),
    PokemonFB(813,"8",R.drawable.scorbunny, "Scorbunny","Se pone a correr para elevar su temperatura corporal y propagar la energía ígnea por todo el cuerpo. Desata así su verdadera fuerza.",listOf(PokemonTipoFB.FUEGO), listOf(813, 814, 815)),
    PokemonFB(814,"8",R.drawable.raboot, "Raboot","Su suave pelaje lo protege del frío y le permite incrementar todavía más la temperatura de sus movimientos de tipo Fuego.",listOf(PokemonTipoFB.FUEGO), listOf(813, 814, 815)),
    PokemonFB(815,"8",R.drawable.cinderace, "Cinderace","Convierte piedras en balones de fuego dándoles toques y, luego, chuta con fuerza hacia el rival para chamuscarlo.",listOf(PokemonTipoFB.FUEGO), listOf(813, 814, 815)),
    PokemonFB(816,"8",R.drawable.sobble, "Sobble","Cuando se espanta, libera unas lágrimas con un factor lacrimógeno equivalente a 100 cebollas para hacer llorar también al rival.",listOf(PokemonTipoFB.AGUA), listOf(816, 817, 818)),
    PokemonFB(817,"8",R.drawable.drizzile, "Drizzile","Crea bolas de agua con el líquido que segrega por las palmas de las manos y las usa en combate de forma estratégica.",listOf(PokemonTipoFB.AGUA), listOf(816, 817, 818)),
    PokemonFB(818,"8",R.drawable.inteleon, "Inteleon","Esconde algunos trucos bajo la manga: puede disparar agua por los dedos o planear con las membranas de su espalda.",listOf(PokemonTipoFB.AGUA), listOf(816, 817, 818)),
    PokemonFB(819,"8",R.drawable.skwovet, "Skwovet","Este Pokémon se encuentra por todo Galar. No se queda tranquilo hasta que tiene ambos carrillos atiborrados de bayas.",listOf(PokemonTipoFB.NORMAL), listOf(819, 820)),
    PokemonFB(820,"8",R.drawable.greedent, "Greedent","Se obceca tanto en acumular bayas en la cola que no se da ni cuenta de cuando tiene demasiadas y se le acaban cayendo.",listOf(PokemonTipoFB.NORMAL), listOf(819, 820)),
    PokemonFB(821,"8",R.drawable.rookidee, "Rookidee","De naturaleza valiente, planta cara a cualquier rival, por muy fuerte que sea. Los contraataques que recibe le sirven para fortalecerse.",listOf(PokemonTipoFB.VOLADOR), listOf(821, 822, 823)),
    PokemonFB(822,"8",R.drawable.corvisquire, "Corvisquire","Su inteligencia le permite servirse de objetos. Por ejemplo, recoge y lanza piedras con las patas, o utiliza cuerdas para atrapar a su oponente.",listOf(PokemonTipoFB.VOLADOR), listOf(821, 822, 823)),
    PokemonFB(823,"8",R.drawable.corviknight, "Corviknight","No tiene rival en los cielos de Galar. El acero negro y lustroso de su cuerpo intimida a cualquier adversario.",listOf(PokemonTipoFB.VOLADOR,PokemonTipoFB.ACERO), listOf(821, 822, 823)),
    PokemonFB(824,"8",R.drawable.blipbug, "Blipbug","Siempre está recopilando información, por lo que es muy inteligente, aunque su fuerza deja bastante que desear.",listOf(PokemonTipoFB.BICHO), listOf(824, 825, 826)),
    PokemonFB(825,"8",R.drawable.dottler, "Dottler","Apenas se mueve, pero está vivo. Se cree que adquiere poderes psíquicos mientras permanece recluido en su caparazón sin comer ni beber.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.PSIQUICO), listOf(824, 825, 826)),
    PokemonFB(826,"8",R.drawable.orbeetle, "Orbeetle","Este Pokémon es conocido por su inteligencia. El gran tamaño de su cerebro es un indicio de la magnitud de sus poderes psíquicos.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.PSIQUICO), listOf(824, 825, 826)),
    PokemonFB(827,"8",R.drawable.nickit, "Nickit","Prudente y astuto, borra con la cola las huellas que deja al huir tras robarle el alimento a otro Pokémon.",listOf(PokemonTipoFB.SINIESTRO), listOf(827, 828)),
    PokemonFB(828,"8",R.drawable.thievul, "Thievul","Marca a su presa sin ser advertido. Sigue el olor y, cuando el otro Pokémon baja la guardia, aprovecha para robarle.",listOf(PokemonTipoFB.SINIESTRO), listOf(827, 828)),
    PokemonFB(829,"8",R.drawable.gossifleur, "Gossifleur","Si planta su única extremidad inferior en la tierra y se expone a abundante luz solar, sus pétalos cobran un color vivo.",listOf(PokemonTipoFB.PLANTA), listOf(829, 830)),
    PokemonFB(830,"8",R.drawable.eldegoss, "Eldegoss","El hilo fabricado a partir de su algodón es muy bello y brillante; uno de los productos estrella de la región de Galar.",listOf(PokemonTipoFB.PLANTA), listOf(829, 830)),
    PokemonFB(831,"8",R.drawable.wooloo, "Wooloo","Su lana rizada es tan acolchada que no se hace daño ni aunque se caiga por un precipicio.",listOf(PokemonTipoFB.NORMAL), listOf(831, 832)),
    PokemonFB(832,"8",R.drawable.dubwool, "Dubwool","Sus espléndidos cuernos sirven de reclamo para atraer al sexo opuesto. No los utiliza como arma.",listOf(PokemonTipoFB.NORMAL), listOf(831, 832)),
    PokemonFB(833,"8",R.drawable.chewtle, "Chewtle","Muerde todo lo que se le ponga por delante. Al parecer, lo hace para aliviar el dolor que siente cuando le crecen los incisivos.",listOf(PokemonTipoFB.AGUA), listOf(833, 834)),
    PokemonFB(834,"8",R.drawable.drednaw, "Drednaw","Un Pokémon de temperamento feroz que atenaza a su presa con sus fuertes mandíbulas, capaces de destrozar una barra de hierro.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.ROCA), listOf(833, 834)),
    PokemonFB(835,"8",R.drawable.yamper, "Yamper","Al correr, genera electricidad por la base de la cola. Es muy popular entre los pastores de Galar.",listOf(PokemonTipoFB.ELECTRICO), listOf(835, 836)),
    PokemonFB(836,"8",R.drawable.boltund, "Boltund","La electricidad que genera y envía a sus patas le ayuda a desplazarse rápidamente. Puede correr sin descanso durante tres días y tres noches.",listOf(PokemonTipoFB.ELECTRICO), listOf(835, 836)),
    PokemonFB(837,"8",R.drawable.rolycoly, "Rolycoly","Las partes envejecidas de la corteza que se le desprenden se utilizan como combustible en lugar del carbón.",listOf(PokemonTipoFB.ROCA), listOf(837, 838, 839)),
    PokemonFB(838,"8",R.drawable.carkol, "Carkol","Gira las patas a gran velocidad para correr a unos 30 km/h. Emite llamas a una temperatura de 1000 °C.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.FUEGO), listOf(837, 838, 839)),
    PokemonFB(839,"8",R.drawable.coalossal, "Coalossal","Cuando se enzarza en un combate, la montaña de carbón arde al rojo vivo y esparce chispas que calcinan todo lo que le rodea.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.FUEGO), listOf(837, 838, 839)),
    PokemonFB(840,"8",R.drawable.applin, "Applin","Vive dentro de una manzana. Si se separa de ella, su cuerpo se deshidrata y se queda sin fuerzas.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.DRAGON), listOf(840,842,1011,1019)),
    PokemonFB(841,"8",R.drawable.flapple, "Flapple","Usa fluidos corporales para reparar su manzana. Las de los más fuertes y curtidos en combate se vuelven de un color terroso.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.DRAGON), listOf(840,842,1011,1019)),
    PokemonFB(842,"8",R.drawable.appletun, "Appletun","Escupen una sustancia pegajosa para ahuyentar a los Lechonk que se acercan a lamerles el dulce néctar de la espalda.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.DRAGON), listOf(840,842,1011,1019)),
    PokemonFB(843,"8",R.drawable.silicobra, "Silicobra","Almacena la arena que ingiere al perforar hoyos en la saca del cuello, cuya capacidad llega a alcanzar incluso los 8 kg.",listOf(PokemonTipoFB.TIERRA), listOf(843, 844)),
    PokemonFB(844,"8",R.drawable.sandaconda, "Sandaconda","Estira y contrae su cuerpo al máximo para expulsar arena con tal potencia que puede mover incluso un camión.",listOf(PokemonTipoFB.TIERRA), listOf(843, 844)),
    PokemonFB(845,"8",R.drawable.cramorant, "Cramorant","Cuando tiene el estómago lleno, le cuesta moverse y corre el riesgo de ser engullido por algún Cramorant.",listOf(PokemonTipoFB.VOLADOR,PokemonTipoFB.AGUA), listOf(845)),
    PokemonFB(846,"8",R.drawable.arrokuda, "Arrokuda","Puede nadar a más de 100 nudos. Entabla encarnizadas batallas contra manadas de Finizen por la comida.",listOf(PokemonTipoFB.AGUA), listOf(846, 847)),
    PokemonFB(847,"8",R.drawable.barraskewda, "Barraskewda","Puede nadar a más de 100 nudos. Entabla encarnizadas batallas contra manadas de Finizen por la comida.",listOf(PokemonTipoFB.AGUA), listOf(846, 847)),
    PokemonFB(848,"8",R.drawable.toxel, "Toxel","Secreta toxinas por la piel y las almacena en una bolsa de veneno interna. Tocarlo da calambre.",listOf(PokemonTipoFB.ELECTRICO,PokemonTipoFB.VENENO), listOf(848, 849,849)),
    PokemonFB(849,"8",R.drawable.toxtricity, "Toxtricity","Cuando rasga las protuberancias del pecho para generar energía eléctrica, emite un sonido similar al de una guitarra, que reverbera en el entorno.",listOf(PokemonTipoFB.ELECTRICO,PokemonTipoFB.VENENO), listOf(848, 849,849)),
    PokemonFB(850,"8",R.drawable.sizzlipede, "Sizzlipede","Oprime a sus presas con su cuerpo candente. Una vez bien tostadas, las devora con fruición.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.BICHO), listOf(850, 851)),
    PokemonFB(851,"8",R.drawable.centiskorch, "Centiskorch","Cuando genera calor, su temperatura corporal alcanza aproximadamente los 800 °C. Usa el cuerpo a modo de látigo para lanzarse al ataque.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.BICHO), listOf(850, 851)),
    PokemonFB(852,"8",R.drawable.clobbopus, "Clobbopus","Emerge a tierra firme en busca de alimento. Su extrema curiosidad lo induce a golpear con los tentáculos todo lo que entra en su campo visual.",listOf(PokemonTipoFB.LUCHA), listOf(852, 853)),
    PokemonFB(853,"8",R.drawable.grapploct, "Grapploct","Se aventura en tierra firme para buscar rivales contra los que luchar para medir su valía. Tras terminar el combate, regresa al mar.",listOf(PokemonTipoFB.LUCHA), listOf(852, 853)),
    PokemonFB(854,"8",R.drawable.sinistea, "Sinistea","Según se dice, este Pokémon surgió de un alma solitaria que poseyó una taza abandonada llena de un té ya frío.",listOf(PokemonTipoFB.FANTASMA), listOf(854, 855)),
    PokemonFB(855,"8",R.drawable.polteageist, "Polteageist","Se hospeda en teteras dignas de un anticuario. Las originales son escasísimas, pero existe un gran número de burdas falsificaciones.",listOf(PokemonTipoFB.FANTASMA), listOf(854, 855)),
    PokemonFB(856,"8",R.drawable.hatenna, "Hatenna","Siente predilección por los lugares despoblados. Si percibe una emoción intensa, emprende la huida a toda prisa.",listOf(PokemonTipoFB.PSIQUICO), listOf(856, 857, 858)),
    PokemonFB(857,"8",R.drawable.hattrem, "Hattrem","Silencia al objetivo atizándole con los mechones. Despliega una potencia devastadora capaz de noquear a un boxeador profesional.",listOf(PokemonTipoFB.PSIQUICO), listOf(856, 857, 858)),
    PokemonFB(858,"8",R.drawable.hatterene, "Hatterene","Inmoviliza con un rayo y destroza con su garra reforzada con poder psíquico a todo aquel que se adentre en el bosque que habita.",listOf(PokemonTipoFB.PSIQUICO,PokemonTipoFB.HADA), listOf(856, 857, 858)),
    PokemonFB(859,"8",R.drawable.impidimp, "Impidimp","Con el fin de revitalizarse, inhala por la nariz la energía negativa que desprenden tanto personas como Pokémon cuando están descontentos.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.HADA), listOf(859, 860, 861)),
    PokemonFB(860,"8",R.drawable.morgrem, "Morgrem","De noche, atrae con astucia a su objetivo hasta el bosque. Al parecer, tiene la capacidad de hacer crecer productos agrícolas.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.HADA), listOf(859, 860, 861)),
    PokemonFB(861,"8",R.drawable.grimmsnarl, "Grimmsnarl","Vive en lo más profundo del bosque. A pesar de haber evolucionado, no abandona las pequeñas bromas y las trastadas.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.HADA), listOf(859, 860, 861)),
    PokemonFB(862,"8",R.drawable.obstagoon, "Obstagoon","La potencia de su voz es realmente pasmosa. La técnica que usa para intimidar al rival mientras grita recibe el nombre de Obstrucción.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.NORMAL), listOf(1055,1056,862)),
    PokemonFB(863,"8",R.drawable.perrserker, "Perrserker","El pelo de la cabeza se le ha endurecido hasta el punto de parecer un yelmo de hierro. Posee un temperamento muy combativo.",listOf(PokemonTipoFB.ACERO), listOf(863)),
    PokemonFB(864,"8",R.drawable.cursola, "Cursola","Su energía espiritual ha aumentado hasta hacerlo desprenderse de su base caliza. Protege el alma del núcleo con su cuerpo espectral.",listOf(PokemonTipoFB.FANTASMA), listOf(1054,864)),
    PokemonFB(865,"8",R.drawable.sirfetchd, "Sirfetch'd","Repele ataques con las hojas de su duro puerro y contraataca con su tallo afilado. El puerro que le sirve de armamento sigue siendo comestible.",listOf(PokemonTipoFB.LUCHA), listOf(865,827,865)),
    PokemonFB(866,"8",R.drawable.mrrime, "Mr. Rime","Es un bailarín consumado de claqué. Agita su bastón de hielo mientras exhibe su destreza con gráciles pasos.",listOf(PokemonTipoFB.HIELO,PokemonTipoFB.PSIQUICO), listOf(866,122,866)),
    PokemonFB(867,"8",R.drawable.runerigus, "Runerigus","Una poderosa maldición pesa sobre esta antigua imagen grabada, que ha cobrado vida tras adueñarse del alma de Yamask.",listOf(PokemonTipoFB.TIERRA,PokemonTipoFB.FANTASMA), listOf(867,543,867)),
    PokemonFB(868,"8",R.drawable.milcery, "Milcery","Su cremoso cuerpo surgió a partir de la unión de partículas odoríferas de dulces aromas presentes en el aire.",listOf(PokemonTipoFB.HADA), listOf(868, 869)),
    PokemonFB(869,"8",R.drawable.alcremie, "Alcremie","Obsequia bayas decoradas con nata a aquellos Entrenadores en los que confía.",listOf(PokemonTipoFB.HADA), listOf(868, 869)),
    PokemonFB(870,"8",R.drawable.falinks, "Falinks","Este Pokémon consta de cinco subalternos y un líder, cuyas órdenes obedecen sin rechistar.",listOf(PokemonTipoFB.LUCHA), listOf(870)),
    PokemonFB(871,"8",R.drawable.pincurchin, "Pincurchin","Libera electricidad por la punta de las púas. Con sus afilados dientes raspa las algas pegadas a las rocas para ingerirlas.",listOf(PokemonTipoFB.ELECTRICO), listOf(871)),
    PokemonFB(872,"8",R.drawable.snom, "Snom","Teje un hilo gélido que le permite aferrarse a las ramas y simula ser un carámbano mientras duerme.",listOf(PokemonTipoFB.HIELO,PokemonTipoFB.BICHO), listOf(872, 873)),
    PokemonFB(873,"8",R.drawable.frosmoth, "Frosmoth","La temperatura de sus alas es de -180 °C. Sobrevuela el campo esparciendo sus gélidas escamas, como si de nieve se tratase.",listOf(PokemonTipoFB.HIELO,PokemonTipoFB.BICHO), listOf(872, 873)),
    PokemonFB(874,"8",R.drawable.stonjourner, "Stonjourner","Una vez al año y en una fecha concreta, tienen la costumbre de aparecer de la nada para reunirse y formar un círculo.",listOf(PokemonTipoFB.ROCA), listOf(874)),
    PokemonFB(875,"8",R.drawable.eiscue, "Eiscue","La corriente lo ha transportado hasta aquí desde un lugar sumamente gélido. Utiliza el hielo para mantener la cara refrigerada en todo momento.",listOf(PokemonTipoFB.HIELO), listOf(875)),
    PokemonFB(876,"8",R.drawable.indeedee, "Indeedee","Percibe las emociones del objetivo con los cuernos de la cabeza. Los machos están atentos a cualquier cosa que necesite su Entrenador.",listOf(PokemonTipoFB.PSIQUICO,PokemonTipoFB.NORMAL), listOf(876)),
    PokemonFB(877,"8",R.drawable.morpeko, "Morpeko","Siempre tiene hambre. Se nutre de las semillas que guarda en una suerte de bolsillos para generar electricidad.",listOf(PokemonTipoFB.ELECTRICO,PokemonTipoFB.SINIESTRO), listOf(877)),
    PokemonFB(878,"8",R.drawable.cufant, "Cufant","Su constitución fornida le permite transportar sin inmutarse cargas de 5 toneladas. Utiliza la trompa para excavar la tierra.",listOf(PokemonTipoFB.ACERO), listOf(878, 879)),
    PokemonFB(879,"8",R.drawable.copperajah, "Copperajah","Es orgulloso y difícil de tratar. Aquellos con un tono de piel verde más vivo se ganan el respeto de sus congéneres.",listOf(PokemonTipoFB.ACERO), listOf(878, 879)),
    PokemonFB(880,"8",R.drawable.dracozolt, "Dracozolt","La robustez de su tren inferior lo hacía invencible en la antigüedad, pero se extinguió tras comerse todas las plantas de las que se nutría.",listOf(PokemonTipoFB.ELECTRICO,PokemonTipoFB.DRAGON), listOf(880)),
    PokemonFB(881,"8",R.drawable.arctozolt, "Arctozolt","La parte superior del cuerpo está congelada y, al temblar, genera electricidad. Camina con suma dificultad.",listOf(PokemonTipoFB.ELECTRICO,PokemonTipoFB.HIELO), listOf(881)),
    PokemonFB(882,"8",R.drawable.dracovish, "Dracovish","Exhibe con orgullo su inmensa capacidad motriz, que le permite superar los 60 km/h, pero solo puede respirar bajo el agua.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.DRAGON), listOf(882)),
    PokemonFB(883,"8",R.drawable.arctovish, "Arctovish","Atrapa a sus presas congelando su entorno, pero la ubicación de la boca encima de la cabeza le genera dificultades para deglutirlas.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.DRAGON), listOf(883)),
    PokemonFB(884,"8",R.drawable.duraludon, "Duraludon","Su cuerpo, compuesto de un metal especial, es tan liso como si tuviese un acabado de espejo. Además de ligero, es resistente a las rayaduras.",listOf(PokemonTipoFB.ACERO,PokemonTipoFB.DRAGON), listOf(884,1018)),
    PokemonFB(885,"8",R.drawable.dreepy, "Dreepy","Habitaba los mares en tiempos inmemoriales. Ha revivido en forma de Pokémon de tipo Fantasma para vagar por su antigua morada.",listOf(PokemonTipoFB.DRAGON,PokemonTipoFB.FANTASMA), listOf(885, 886, 887)),
    PokemonFB(886,"8",R.drawable.drakloak, "Drakloak","Vuela a una velocidad de 200 km/h. Lucha junto a un Dreepy, al que cuida hasta el momento de su evolución.",listOf(PokemonTipoFB.DRAGON,PokemonTipoFB.FANTASMA), listOf(885, 886, 887)),
    PokemonFB(887,"8",R.drawable.dragapult, "Dragapult","Vive en compañía de Dreepy, a los que hospeda en el interior de sus cuernos. Los dispara a velocidad supersónica en combate.",listOf(PokemonTipoFB.DRAGON,PokemonTipoFB.FANTASMA), listOf(885, 886, 887)),
    PokemonFB(888,"8",R.drawable.zacian, "Zacian","Este Pokémon está considerado como un héroe de leyenda. Absorbe el metal para transformarlo y emplearlo como armamento.",listOf(PokemonTipoFB.HADA,PokemonTipoFB.ACERO), listOf(888)),
    PokemonFB(889,"8",R.drawable.zamazenta, "Zamazenta","Este Pokémon se erigió en salvador de Galar, tras unir fuerzas con un rey de los hombres. Absorbe el metal para utilizarlo en combate.",listOf(PokemonTipoFB.LUCHA,PokemonTipoFB.ACERO), listOf(889)),
    PokemonFB(890,"8",R.drawable.eternatus, "Eternatus","Se alimenta de la energía que brota de la tierra de Galar absorbiéndola por el núcleo del pecho.",listOf(PokemonTipoFB.VENENO,PokemonTipoFB.DRAGON), listOf(890)),
    PokemonFB(891,"8",R.drawable.kubfu, "Kubfu","Perfecciona su técnica mediante una estricta disciplina. Según la corriente marcial que siga, adoptará una forma u otra al evolucionar.",listOf(PokemonTipoFB.LUCHA), listOf(891, 892)), // Urshifu tiene dos formas, Estilo Brusco y Estilo Fluido
    PokemonFB(892,"8",R.drawable.urshifu, "Urshifu","Su estilo de combate se inspira en el flujo del agua y consiste en castigar al oponente de forma constante e ininterrumpida.",listOf(PokemonTipoFB.LUCHA,PokemonTipoFB.SINIESTRO), listOf(891, 892)), // Urshifu tiene dos formas, Estilo Brusco y Estilo Fluido
    PokemonFB(893,"8",R.drawable.zarude, "Zarude","Viven en manada en la selva. Debido a su marcada agresividad, son muy temidos por otros Pokémon selváticos.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.PLANTA), listOf(893)),
    PokemonFB(894,"8",R.drawable.regieleki, "Regieleki","Su cuerpo entero es energía eléctrica. Por lo visto, quitarle los anillos que lleva libera su poder oculto.",listOf(PokemonTipoFB.ELECTRICO), listOf(894)),
    PokemonFB(895,"8",R.drawable.regidrago, "Regidrago","Todo su cuerpo es una gema de energía dragón cristalizada. Se cree que posee los poderes de todos los Pokémon dragón.",listOf(PokemonTipoFB.DRAGON), listOf(895)),
    PokemonFB(896,"8",R.drawable.glastrier, "Glastrier","Libera un potente vaho gélido por las pezuñas. Un ser violento que no duda en tomar a la fuerza todo cuanto desea.",listOf(PokemonTipoFB.HIELO), listOf(896)),
    PokemonFB(897,"8",R.drawable.spectrier, "Spectrier","Examina su entorno con todos los sentidos, salvo la vista. Se dice que sus coces son capaces de robarle el alma a quien las recibe.",listOf(PokemonTipoFB.FANTASMA), listOf(897)),
    PokemonFB(898,"8",R.drawable.calyrex, "Calyrex","Un Pokémon muy compasivo agraciado con el poder de la curación. Reinó en Galar en tiempos remotos.",listOf(PokemonTipoFB.PSIQUICO,PokemonTipoFB.PLANTA), listOf(898)),
    PokemonFB(899,"8",R.drawable.wyrdeer, "Wyrdeer","Sus orbes negros brillan con un fulgor misterioso cuando erige muros invisibles. El pelaje que se desprende de sus barbas es muy codiciado para crear cálidos ropajes para el invierno.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.PSIQUICO), listOf(234,899)),
    PokemonFB(900,"8",R.drawable.kleavor, "Kleavor","Un Pokémon violento, tosco y rudo. Blande sus enormes y pesadas hachas de piedra para acabar con sus presas.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.ROCA), listOf(123,900)),
    PokemonFB(901,"8",R.drawable.ursaluna, "Ursaluna","Tengo la teoría de que el terreno pantanoso de Hisui favoreció el desarrollo de su constitución robusta, así como su capacidad de manipular la turba a voluntad.",listOf(PokemonTipoFB.TIERRA,PokemonTipoFB.NORMAL), listOf(216,217,901)),
    PokemonFB(902,"8",R.drawable.basculegion, "Basculegion","Durante las remontadas de los ríos, se envuelve de las almas de sus congéneres caídos en la ardua travesía. No tiene rival en ninguna de las corrientes que fluyen por la región de Hisui.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.FANTASMA), listOf(550,902)),
    PokemonFB(903,"8",R.drawable.sneasler, "Sneasler","Gracias a su fortaleza física y potente veneno, ninguna especie de las alturas heladas le planta cara. Es de personalidad solitaria y no forma manadas.",listOf(PokemonTipoFB.LUCHA,PokemonTipoFB.VENENO), listOf(903,783,903)),
    PokemonFB(904,"8",R.drawable.overqwil, "Overqwil","Sus púas tóxicas reaccionan como acto reflejo ante cualquier movimiento, por lo que ensartará todo lo que se acerque incluso mientras duerme.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.VENENO), listOf(1067,904)),
    PokemonFB(905,"8",R.drawable.enamorus, "Enamorus","Su llegada de allende el mar significa el fin del duro invierno. De acuerdo con el folclore, su amor siempre trae consigo un soplo de vida nueva a Hisui.",listOf(PokemonTipoFB.HADA,PokemonTipoFB.VOLADOR), listOf(905)),
    PokemonFB(906,"9",R.drawable.sprigatito, "Sprigatito","Su sedoso pelaje se asemeja en composición a las plantas. Se lava la cara con diligencia para que no se le seque.",listOf(PokemonTipoFB.PLANTA), listOf(906, 907, 908)),
    PokemonFB(907,"9",R.drawable.floragato, "Floragato","Maneja diestramente la vid oculta bajo su largo pelaje y propina latigazos al enemigo con el capullo endurecido de la punta.",listOf(PokemonTipoFB.PLANTA), listOf(906, 907, 908)),
    PokemonFB(908,"9",R.drawable.meowscarada, "Meowscarada","Se sirve de la luz que reflejan los tricomas de su manto de hojas para camuflar la vid y crear la ilusión óptica de que la flor flota en el aire.",listOf(PokemonTipoFB.PLANTA, PokemonTipoFB.SINIESTRO), listOf(906, 907, 908)),
    PokemonFB(909,"9",R.drawable.fuecoco, "Fuecoco","Yace sobre rocas calientes, cuyo calor transforma en energía ígnea tras absorberlo por sus escamas rectangulares.",listOf(PokemonTipoFB.FUEGO), listOf(909, 910, 911)),
    PokemonFB(910,"9",R.drawable.crocalor, "Crocalor","La mezcla de energía ígnea con el exceso de su propia fuerza vital ha tomado la forma de una bola de fuego de aspecto oval sobre su cabeza.",listOf(PokemonTipoFB.FUEGO), listOf(909, 910, 911)),
    PokemonFB(911,"9",R.drawable.skeledirge, "Skeledirge","Su dulce canto calma el espíritu de quien lo oye. Achicharra a sus enemigos con llamas que llegan a alcanzar los 3000ºC.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.FANTASMA), listOf(909, 910, 911)),
    PokemonFB(912,"9",R.drawable.quaxly, "Quaxly","Un Pokémon llegado hace tiempo desde tierras lejanas y ya establecido en la región. El gel que secreta por las plumas repele el agua y la mugre.",listOf(PokemonTipoFB.AGUA), listOf(912, 913, 914)),
    PokemonFB(913,"9",R.drawable.quaxwell, "Quaxwell","Fortalece las extremidades corriendo con tesón por los bajíos. Compite con los suyos para ver cuál posee una técnica más grácil con las patas.",listOf(PokemonTipoFB.AGUA), listOf(912, 913, 914)),
    PokemonFB(914,"9",R.drawable.quaquaval, "Quaquaval","Embelesa a quien lo ve con una danza que rebosa de exotismo y corta a sus rivales con sus plumas ornamentales hechas de agua.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.LUCHA), listOf(912, 913, 914)),
    PokemonFB(915,"9",R.drawable.lechonk, "Lechonk","Posee un olfato muy desarrollado que emplea únicamente para buscar comida, actividad a la que dedica el día entero.",listOf(PokemonTipoFB.NORMAL), listOf(915, 916)), // Oinkologne tiene dos formas, macho y hembra
    PokemonFB(916,"9",R.drawable.oinkologne, "Oinkologne","Su piel suave y lustrosa es su mayor orgullo. Desprende una fragancia concentrada por la punta de la cola.",listOf(PokemonTipoFB.NORMAL), listOf(915, 916)), // Oinkologne tiene dos formas, macho y hembra
    PokemonFB(917,"9",R.drawable.tarountula, "Tarountula","La bola de hilo que le rodea el cuerpo es lo bastante elástica como para repeler las guadañas de los Scyther, su enemigo natural.",listOf(PokemonTipoFB.BICHO), listOf(917, 918)),
    PokemonFB(918,"9",R.drawable.spidops, "Spidops","Protege su territorio cubriéndolo con una tela de hilo resistente y pegajoso que actúa como una trampa frente a los intrusos.",listOf(PokemonTipoFB.BICHO), listOf(917, 918)),
    PokemonFB(919,"9",R.drawable.nymble, "Nymble","Mantiene plegado su tercer par de patas, cuya fuerza le permite saltar a más de 10 m de altura para huir en caso de apuro.",listOf(PokemonTipoFB.BICHO), listOf(919, 920)),
    PokemonFB(920,"9",R.drawable.lokix, "Lokix","Cuando decide luchar sin cuartel, se alza con su tercer par de patas y entra en modo asalto. Acaba con el rival en un abrir y cerrar de ojos.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.SINIESTRO), listOf(919, 920)),
    PokemonFB(921,"9",R.drawable.pawmi, "Pawmi","Como las bolsas de sus mejillas están poco desarrolladas, genera electricidad frotándolas con las almohadillas de sus patas delanteras.",listOf(PokemonTipoFB.ELECTRICO), listOf(921, 922, 923)),
    PokemonFB(922,"9",R.drawable.pawmo, "Pawmo","Usa un arte marcial caracterizado por emplear las patas delanteras para asestar golpes y liberar descargas eléctricas al mismo tiempo.",listOf(PokemonTipoFB.ELECTRICO,PokemonTipoFB.LUCHA), listOf(921, 922, 923)),
    PokemonFB(923,"9",R.drawable.pawmot, "Pawmot","Su mullido pelaje actúa como una batería. Es capaz de almacenar tanta electricidad como un coche eléctrico.",listOf(PokemonTipoFB.ELECTRICO,PokemonTipoFB.LUCHA), listOf(921, 922, 923)),
    PokemonFB(924,"9",R.drawable.tandemaus, "Tandemaus","Siempre van en pareja. Cuando encuentran comida, la dividen en dos partes idénticas para compartirla.",listOf(PokemonTipoFB.NORMAL), listOf(924, 925)), // Maushold tiene dos formas, Familia de tres y Familia de cuatro
    PokemonFB(925,"9",R.drawable.maushold, "Maushold","Construyen grandes nidos que dividen en varias cámaras destinadas a distintas funciones, como dormir o comer.",listOf(PokemonTipoFB.NORMAL), listOf(924, 925)), // Maushold tiene dos formas, Familia de tres y Familia de cuatro
    PokemonFB(926,"9",R.drawable.fidough, "Fidough","Resulta húmedo y suave al tacto. Hace fermentar las cosas a su alrededor con la levadura de su aliento.",listOf(PokemonTipoFB.HADA), listOf(926, 927)),
    PokemonFB(927,"9",R.drawable.dachsbun, "Dachsbun","La superficie de su piel se endurece cuando se expone a un calor intenso. Su cuerpo desprende un fragante aroma.",listOf(PokemonTipoFB.HADA), listOf(926, 927)),
    PokemonFB(928,"9",R.drawable.smoliv, "Smoliv","Se defiende de sus rivales segregando por el fruto de su cabeza un aceite tan amargo y agrio que cualquiera daría un respingo al probarlo.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.NORMAL), listOf(928, 929, 930)),
    PokemonFB(929,"9",R.drawable.dolliv, "Dolliv","No duda en compartir su delicioso aceite de fresco aroma. Convive con los seres humanos desde hace mucho tiempo.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.NORMAL), listOf(928, 929, 930)),
    PokemonFB(930,"9",R.drawable.arboliva, "Arboliva","Es pacífico y compasivo. Comparte su delicioso y nutritivo aceite con los Pokémon que han perdido las fuerzas.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.NORMAL), listOf(928, 929, 930)),
    PokemonFB(931,"9",R.drawable.squawkabilly, "Squawkabilly","Prefieren vivir en las ciudades. Forman bandadas según el color de su plumaje y libran disputas por el control de los territorios.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.VOLADOR), listOf(931)),
    PokemonFB(932,"9",R.drawable.nacli, "Nacli","Arrastra el cuerpo por el suelo al desplazarse, por lo que deja un rastro de sal. La fabrica y repone continuamente en su interior.",listOf(PokemonTipoFB.ROCA), listOf(932, 933, 934)),
    PokemonFB(933,"9",R.drawable.naclstack, "Naclstack","Escupe sal para recubrir con ella a sus presas y someterlas a un proceso de salazón que extrae la humedad de sus cuerpos.",listOf(PokemonTipoFB.ROCA), listOf(932, 933, 934)),
    PokemonFB(934,"9",R.drawable.garganacl, "Garganacl","Muchos Pokémon se arremolinan alrededor de Garganacl para lamer su sal rica en minerales.",listOf(PokemonTipoFB.ROCA), listOf(932, 933, 934)),
    PokemonFB(935,"9",R.drawable.charcadet, "Charcadet","Sus potentes llamas alcanzan los 1000ºC cuando combate. Siente predilección por las bayas con un alto contenido graso.",listOf(PokemonTipoFB.FUEGO), listOf(935, 936, 937)), // Charcadet evoluciona en Armarouge o Ceruledge
    PokemonFB(936,"9",R.drawable.armarouge, "Armarouge","Evolucionó al portar la armadura de un guerrero de renombre. Este Pokémon destaca por su gran lealtad.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.PSIQUICO), listOf(935, 936)),
    PokemonFB(937,"9",R.drawable.ceruledge, "Ceruledge","Evolucionó al portar una vieja armadura cargada de rencor. Despedaza a sus enemigos sin piedad alguna.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.FANTASMA), listOf(935, 937)),
    PokemonFB(938,"9",R.drawable.tadbulb, "Tadbulb","Produce electricidad agitando la cola. Si siente peligro, hace parpadear su cabeza para alertar a sus compañeros.",listOf(PokemonTipoFB.ELECTRICO), listOf(938, 939)),
    PokemonFB(939,"9",R.drawable.bellibolt, "Bellibolt","Los órganos que parecen ojos sirven en realidad para descargar toda la electricidad generada por la dinamo de su ombligo.",listOf(PokemonTipoFB.ELECTRICO), listOf(938, 939)),
    PokemonFB(940,"9",R.drawable.wattrel, "Wattrel","Anida en acantilados costeros. Su nido se considera un auténtico manjar debido a su extraña textura chisporroteante.",listOf(PokemonTipoFB.ELECTRICO,PokemonTipoFB.VOLADOR), listOf(940, 941)),
    PokemonFB(941,"9",R.drawable.kilowattrel, "Kilowattrel","Almacena la electricidad generada por sus alas en el saco gular. Su plumaje apenas contiene aceite, por lo que es un pésimo nadador.",listOf(PokemonTipoFB.ELECTRICO,PokemonTipoFB.VOLADOR), listOf(940, 941)),
    PokemonFB(942,"9",R.drawable.maschiff, "Maschiff","Mantiene el ceño fruncido para que sus rivales lo tomen en serio, pero hasta el niño más llorón estallaría en carcajadas al ver su mueca.",listOf(PokemonTipoFB.SINIESTRO), listOf(942, 943)),
    PokemonFB(943,"9",R.drawable.mabosstiff, "Mabosstiff","Almacena energía en la papada y la libera toda de golpe para arrasar con sus rivales.",listOf(PokemonTipoFB.SINIESTRO), listOf(942, 943)),
    PokemonFB(944,"9",R.drawable.shroodle, "Shroodle","Es manso, pero muerde y paraliza a quien lo enfada con sus afilados incisivos impregnados de toxinas.",listOf(PokemonTipoFB.VENENO,PokemonTipoFB.NORMAL), listOf(944, 945)),
    PokemonFB(945,"9",R.drawable.grafaiai, "Grafaiai","Cada individuo pinta un patrón único y distintivo que irá replicando de forma constante a lo largo de toda su vida.",listOf(PokemonTipoFB.VENENO,PokemonTipoFB.NORMAL), listOf(944, 945)),
    PokemonFB(946,"9",R.drawable.bramblin, "Bramblin","Rueda por los páramos a merced del viento, sin que él mismo sepa dónde recalará. No soporta mojarse.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.FANTASMA), listOf(946, 947)),
    PokemonFB(947,"9",R.drawable.brambleghast, "Brambleghast","Despliega las ramas para engullir a sus presas. Cuando ha terminado de absorber su energía vital, las escupe.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.FANTASMA), listOf(946, 947)),
    PokemonFB(948,"9",R.drawable.toedscool, "Toedscool","Los pliegues ondulados que se desprenden de su cuerpo cuentan con una textura curiosa y un sabor delicioso. Habita en bosques húmedos.",listOf(PokemonTipoFB.TIERRA,PokemonTipoFB.PLANTA), listOf(948, 949)),
    PokemonFB(949,"9",R.drawable.toedscruel, "Toedscruel","Forma colonias de varios ejemplares en lo más profundo de los bosques. No soporta las visitas indeseadas de extraños.",listOf(PokemonTipoFB.TIERRA,PokemonTipoFB.PLANTA), listOf(948, 949)),
    PokemonFB(950,"9",R.drawable.klawf, "Klawf","Habita en acantilados escarpados. Evade los ataques enemigos echándose a un lado y luego apunta a sus puntos vitales con las pinzas.",listOf(PokemonTipoFB.ROCA), listOf(950)),
    PokemonFB(951,"9",R.drawable.capsakid, "Capsakid","En Paldea es común emplear los incisivos caídos de los Capsakid como ingrediente, lo que aporta un toque muy picante a los platos.",listOf(PokemonTipoFB.PLANTA), listOf(951, 952)),
    PokemonFB(952,"9",R.drawable.scovillain, "Scovillain","La cabeza verde es mucho más despiadada por el efecto de los capsaicinoides sobre su cerebro. Cuando enloquece, no hay forma de detenerla.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.FUEGO), listOf(951, 952)),
    PokemonFB(953,"9",R.drawable.rellor, "Rellor","Hace rodar la bola de barro para madurar energía hasta que alcanza el grado necesario para su evolución.",listOf(PokemonTipoFB.BICHO), listOf(953, 954)),
    PokemonFB(954,"9",R.drawable.rabsca, "Rabsca","Mece la bola suavemente con las patas para asegurar el plácido sueño de la crisálida que duerme en su interior.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.PSIQUICO), listOf(953, 954)),
    PokemonFB(955,"9",R.drawable.flittle, "Flittle","La punta de sus extremidades levita a 1 cm del suelo a causa del poder psíquico que emiten los volantes de su abdomen.",listOf(PokemonTipoFB.PSIQUICO), listOf(955, 956)),
    PokemonFB(956,"9",R.drawable.espathra, "Espathra","Emite energía psíquica por los huecos entre sus volantes multicolor y alcanza los 200 km/h en carrera.",listOf(PokemonTipoFB.PSIQUICO), listOf(955, 956)),
    PokemonFB(957,"9",R.drawable.tinkatink, "Tinkatink","Agita su martillo forjado a mano para ahuyentar a posibles amenazas, pero los Pokémon que se alimentan a base de metal suelen robárselo.",listOf(PokemonTipoFB.HADA,PokemonTipoFB.ACERO), listOf(957, 958, 959)),
    PokemonFB(958,"9",R.drawable.tinkatuff, "Tinkatuff","Asalta el séquito entero de un Bisharp para reunir metal con el que forjar su enorme y robusto martillo.",listOf(PokemonTipoFB.HADA,PokemonTipoFB.ACERO), listOf(957, 958, 959)),
    PokemonFB(959,"9",R.drawable.tinkaton, "Tinkaton","Blande sin esfuerzo su pesado martillo de más de 100 kg. Cuando quiere algo, lo roba y se lo lleva de vuelta a su guarida.",listOf(PokemonTipoFB.HADA,PokemonTipoFB.ACERO), listOf(957, 958, 959)),
    PokemonFB(960,"9",R.drawable.wiglett, "Wiglett","Puede percibir el olor de los Veluza a 20m de distancia, lo que le permite ocultarse bajo la arena a tiempo.",listOf(PokemonTipoFB.AGUA), listOf(960, 961)),
    PokemonFB(961,"9",R.drawable.wugtrio, "Wugtrio","Es de temperamento agresivo, aunque no lo parezca. Envuelve a sus presas con sus largos cuerpos y las arrastra a su nido.",listOf(PokemonTipoFB.AGUA), listOf(960, 961)),
    PokemonFB(962,"9",R.drawable.bombirdier, "Bombirdier","Usa la bolsa del pecho para envolver comida y transportarla a su nido. Le encanta dejar caer objetos que hacen mucho ruido.",listOf(PokemonTipoFB.VOLADOR,PokemonTipoFB.SINIESTRO), listOf(962)),
    PokemonFB(963,"9",R.drawable.finizen, "Finizen","Su anillo de agua está compuesto por una mezcla de agua marina y de un líquido aglutinante que segrega por el espiráculo.",listOf(PokemonTipoFB.AGUA), listOf(963, 964)),
    PokemonFB(964,"9",R.drawable.palafin, "Palafin","Sus genes primigenios han despertado y lo han dotado de tal fuerza que es capaz de acarrear un crucero con una sola aleta sin problema.",listOf(PokemonTipoFB.AGUA), listOf(963, 964)),
    PokemonFB(965,"9",R.drawable.varoom, "Varoom","Se dice que surgió cuando un misterioso Pokémon venenoso tomó posesión de un motor abandonado en un desguace.",listOf(PokemonTipoFB.ACERO,PokemonTipoFB.VENENO), listOf(965, 966)),
    PokemonFB(966,"9",R.drawable.revavroom, "Revavroom","Posee ocho cilindros, con los que genera energía haciendo estallar el gas que produce al mezclar los minerales de las rocas con su veneno.",listOf(PokemonTipoFB.ACERO,PokemonTipoFB.VENENO), listOf(965, 966)),
    PokemonFB(967,"9",R.drawable.cyclizar, "Cyclizar","Según parece, ha permitido que los humanos monten en él desde tiempos remotos. Aparece en pinturas rupestres de hace diez mil años.",listOf(PokemonTipoFB.DRAGON,PokemonTipoFB.NORMAL), listOf(967)),
    PokemonFB(968,"9",R.drawable.orthworm, "Orthworm","Cuando lo atacan, usa los pelos de su cuerpo a modo de puños y hace llover un aluvión de puñetazos sobre sus enemigos.",listOf(PokemonTipoFB.ACERO), listOf(968)),
    PokemonFB(969,"9",R.drawable.glimmet, "Glimmet","Absorbe nutrientes de las paredes de las cuevas. Cubre su cuerpo con pétalos hechos de energía venenosa cristalizada.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.VENENO), listOf(969, 970)),
    PokemonFB(970,"9",R.drawable.glimmora, "Glimmora","En cuanto percibe peligro, abre sus pétalos de cristal y despide rayos por su cuerpo en forma de cono.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.VENENO), listOf(969, 970)),
    PokemonFB(971,"9",R.drawable.greavard, "Greavard","Se cree que es la reencarnación de un Pokémon perro vagabundo que murió sin haber tenido contacto con humanos.",listOf(PokemonTipoFB.FANTASMA), listOf(971, 972)),
    PokemonFB(972,"9",R.drawable.houndstone, "Houndstone","La reencarnación de un Pokémon muy querido y llorado. Odia que le toquen la protuberancia de la cabeza.",listOf(PokemonTipoFB.FANTASMA), listOf(971, 972)),
    PokemonFB(973,"9",R.drawable.flamigo, "Flamigo","Al parecer, se anudan la base del cuello para impedir que la energía que tienen almacenada en el estómago escape por el pico.",listOf(PokemonTipoFB.VOLADOR,PokemonTipoFB.LUCHA), listOf(973)),
    PokemonFB(974,"9",R.drawable.cetoddle, "Cetoddle","Viven en manadas de unos cinco individuos en regiones gélidas. Les encantan los minerales presentes en la nieve y el hielo.",listOf(PokemonTipoFB.HIELO), listOf(974, 975)),
    PokemonFB(975,"9",R.drawable.cetitan, "Cetitan","Este Pokémon vive en áreas cubiertas de nieve y hielo. Se protege con su fuerte musculatura y una gruesa capa de grasa subcutánea.",listOf(PokemonTipoFB.HIELO), listOf(974, 975)),
    PokemonFB(976,"9",R.drawable.veluza, "Veluza","Al desechar la carne que no necesita, agudiza la mente y sus poderes psíquicos se incrementan. Dicha carne tiene un sabor suave pero exquisito.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.PSIQUICO), listOf(976)),
    PokemonFB(977,"9",R.drawable.dondozo, "Dondozo","Le gusta mucho comer, pero no se le da bien cazar, por lo que aúna fuerzas con Tatsugiri con el fin de capturar presas.",listOf(PokemonTipoFB.AGUA), listOf(977)),
    PokemonFB(978,"9",R.drawable.tatsugiri, "Tatsugiri","Pokémon dragón de pequeño tamaño. Vive en la boca de un Dondozo para protegerse de los ataques de los depredadores.",listOf(PokemonTipoFB.DRAGON,PokemonTipoFB.AGUA), listOf(978)),
    PokemonFB(979,"9",R.drawable.annihilape, "Annihilape","Machaca sin piedad a sus rivales concentrando en los puños hasta el último ápice de ira albergada en su corazón.",listOf(PokemonTipoFB.LUCHA,PokemonTipoFB.FANTASMA), listOf(190,979)),
    PokemonFB(980,"9",R.drawable.clodsire, "Clodsire","Vive en el fondo de los estanques y pantanos. Nada con Wooper sobre el lomo para ayudarlos a cruzar de una orilla a otra.",listOf(PokemonTipoFB.VENENO,PokemonTipoFB.TIERRA), listOf(1080,980)),
    PokemonFB(981,"9",R.drawable.farigiraf, "Farigiraf","La dura cabeza de la cola protege a la principal cuando agita su largo cuello para propinar cabezazos a sus enemigos.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.PSIQUICO), listOf(203,981)),
    PokemonFB(982,"9",R.drawable.dudunsparce, "Dudunsparce","Usa su dura cola para horadar el lecho rocoso en las profundidades de la tierra y establecer su madriguera, cuyos túneles se extienden 10 km.",listOf(PokemonTipoFB.NORMAL), listOf(206,982)),
    PokemonFB(983,"9",R.drawable.kingambit, "Kingambit","Solo el Bisharp más destacado entre las filas de cada gran ejército tiene el honor de evolucionar a Kingambit.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.ACERO), listOf(624, 625,983)),
    PokemonFB(984,"9",R.drawable.colmilargo, "Colmilargo","Testigos afirman haberlo visto recientemente. El nombre Colmilargo está tomado de una criatura mencionada en cierto libro.",listOf(PokemonTipoFB.TIERRA,PokemonTipoFB.LUCHA), listOf(984)),
    PokemonFB(985,"9",R.drawable.colagrito, "Colagrito","Solo se había avistado una vez en el pasado. Su aspecto se asemeja al de una misteriosa criatura descrita en cierto diario antiguo.",listOf(PokemonTipoFB.HADA,PokemonTipoFB.PSIQUICO), listOf(985)),
    PokemonFB(986,"9",R.drawable.furioseta, "Furioseta","Es posible que se trate de la criatura que se menciona en cierto libro bajo el nombre de Furioseta.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.SINIESTRO), listOf(986)),
    PokemonFB(987,"9",R.drawable.melenaleteo, "Melenaleteo","Sus rasgos distintivos se asemejan a los del espíritu de un reptil volador mencionado en una revista esotérica.",listOf(PokemonTipoFB.FANTASMA,PokemonTipoFB.HADA), listOf(987)),
    PokemonFB(988,"9",R.drawable.reptalada, "Reptalada","Un misterioso Pokémon que presenta ciertas similitudes con Reptalada, una criatura descrita en un tomo antiguo.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.LUCHA), listOf(988)),
    PokemonFB(989,"9",R.drawable.pelarena, "Pelarena","Su aspecto recuerda ligeramente a un supuesto Magneton que ha vivido 10.000 años y cuya imagen se publicó en una revista esotérica.",listOf(PokemonTipoFB.ELECTRICO,PokemonTipoFB.TIERRA), listOf(989)),
    PokemonFB(990,"9",R.drawable.ferrodada, "Ferrodada","Su aspecto recuerda al de un arma científica de origen extraterrestre que apareció en un artículo de una revista esotérica.",listOf(PokemonTipoFB.TIERRA,PokemonTipoFB.ACERO), listOf(990)),
    PokemonFB(991,"9",R.drawable.ferrosaco, "Ferrosaco","Tiene una forma similar a la del robot construido por una civilización antigua mencionado en cierto artículo de una revista esotérica.",listOf(PokemonTipoFB.HIELO,PokemonTipoFB.AGUA), listOf(991)),
    PokemonFB(992,"9",R.drawable.ferropalmas, "Ferropalmas","Este Pokémon comparte muchas características con Ferropalmas, un objeto descrito en cierto diario.",listOf(PokemonTipoFB.LUCHA,PokemonTipoFB.ELECTRICO), listOf(992)),
    PokemonFB(993,"9",R.drawable.ferrocuello, "Ferrocuello","Se asemeja a un Pokémon que apareció en una revista esotérica descrito como el fruto de un romance entre un Hydreigon y un robot.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.VOLADOR), listOf(993)),
    PokemonFB(994,"9",R.drawable.ferropolilla, "Ferropolilla","Nunca se había capturado uno, ergo los datos son escasos. Su descripción coincide con la de un objeto mencionado en unos viejos escritos.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.VENENO), listOf(994)),
    PokemonFB(995,"9",R.drawable.ferropuas, "Ferropúas","Algunos de sus rasgos distintivos coinciden con los de Ferropúas, un objeto que aparece mencionado en cierto diario.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.ELECTRICO), listOf(995)),
    PokemonFB(996,"9",R.drawable.frigibax, "Frigibax","Absorbe el calor a través de la placa dorsal y lo convierte en energía gélida. Cuanto más alta es la temperatura, más energía acumula.",listOf(PokemonTipoFB.DRAGON,PokemonTipoFB.HIELO), listOf(996, 997, 998)),
    PokemonFB(997,"9",R.drawable.arctibax, "Arctibax","Congela el aire a su alrededor para cubrirse el rostro con una máscara de hielo protectora y dotar su placa dorsal de cuchillas glaciales.",listOf(PokemonTipoFB.DRAGON,PokemonTipoFB.HIELO), listOf(996, 997, 998)),
    PokemonFB(998,"9",R.drawable.baxcalibur, "Baxcalibur","Exhala un aliento extremadamente frío por la boca que es capaz de congelar al instante incluso magma al rojo vivo.",listOf(PokemonTipoFB.DRAGON,PokemonTipoFB.HIELO), listOf(996, 997, 998)),
    PokemonFB(999,"9",R.drawable.gimmighoul, "Gimmighoul","El cofre en el que nació data de hace 1500 años aproximadamente. Absorbe la energía vital de los granujas que intentan hacerse con su tesoro.",listOf(PokemonTipoFB.FANTASMA), listOf(999,1000)),
    PokemonFB(1000,"9",R.drawable.gholdengo, "Gholdengo","Se dice que su cuerpo está formado por 1000 monedas. Es capaz de hacer buenas migas con cualquiera rápidamente por su sociabilidad.",listOf(PokemonTipoFB.ACERO,PokemonTipoFB.FANTASMA), listOf(999,1000)),
    PokemonFB(1001,"9",R.drawable.wochien, "Wo-Chien","Este Pokémon nació al imbuirse en hojas marchitas el rencor de una persona castigada por enumerar las fechorías de su rey en unas tablillas.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.PLANTA), listOf(1001)),
    PokemonFB(1002,"9",R.drawable.chienpao, "Chien-Pao","Controla a su voluntad masas de nieve de hasta cien toneladas. Se divierte zambulléndose y saltando felizmente en los aludes que provoca.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.HIELO), listOf(1002)),
    PokemonFB(1003,"9",R.drawable.tinglu, "Ting-Lu","Este Pokémon nació al imbuirse en tierra y rocas el miedo vertido en un caldero que se utilizaba en rituales antiguos.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.TIERRA), listOf(1003)),
    PokemonFB(1004,"9",R.drawable.chiyu, "Chi-Yu","Controla a su voluntad llamas de hasta 3000ºC. Nada tranquilamente por los mares de magma que crea al derretir las rocas y la grava a su paso.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.FUEGO), listOf(1004)),
    PokemonFB(1005,"9",R.drawable.bramaluna, "Bramaluna","Podría tratarse de la criatura que aparece bajo el nombre de Bramaluna en cierto diario repleto de incógnitas.",listOf(PokemonTipoFB.DRAGON,PokemonTipoFB.SINIESTRO), listOf(1005)),
    PokemonFB(1006,"9",R.drawable.ferropaladin, "Ferropaladín","Comparte varios rasgos con el invento de un científico loco que apareció en un artículo de una revista esotérica.",listOf(PokemonTipoFB.HADA,PokemonTipoFB.LUCHA), listOf(1006)),
    PokemonFB(1007,"9",R.drawable.koraidon, "Koraidon","Parece tratarse de Reyalado, la criatura que, según lo narrado en un antiguo diario, fue capaz de dividir la tierra con sus puños.",listOf(PokemonTipoFB.LUCHA,PokemonTipoFB.DRAGON), listOf(1007)),
    PokemonFB(1008,"9",R.drawable.miraidon, "Miraidon","Pese a las similitudes con los Cyclizar, es mucho más fuerte y despiadado que ellos. Está rodeado de incógnitas.",listOf(PokemonTipoFB.ELECTRICO,PokemonTipoFB.DRAGON), listOf(1008)),
    PokemonFB(1009,"9",R.drawable.ondulagua, "Ondulagua","Se asemeja a la ilustración de un Suicune de tiempos inmemoriales que apareció publicada en cierta revista esotérica.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.DRAGON), listOf(1009)),
    PokemonFB(1010,"9",R.drawable.ferroverdor, "Ferroverdor","Presenta numerosas características en común con el Virizion del futuro que apareció publicado en cierta revista esotérica.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.PSIQUICO), listOf(1010)),
    PokemonFB(1011,"9",R.drawable.dipplin, "Dipplin","Ha evolucionado gracias a una manzana especial que solo se cultiva en cierta zona. Este Pokémon está formado por dos individuos.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.DRAGON), listOf(840,842,1011,1019)),
    PokemonFB(1012,"9",R.drawable.poltchageist, "Poltchageist","Según se dice, el resquemor de un practicante de la ceremonia del té que murió sin perfeccionar el arte poseyó el matcha y dio lugar a un Pokémon.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.FANTASMA), listOf(1012, 1013)),
    PokemonFB(1013,"9",R.drawable.sinistcha, "Sinistcha","Vive en un exquisito cuenco de té elaborado por un alfarero de renombre. Los coleccionistas más acérrimos se desviven por este Pokémon.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.FANTASMA), listOf(1012, 1013)),
    PokemonFB(1014,"9",R.drawable.okidogi, "Okidogi","Las toxinas de la cadena que lleva al cuello producen una estimulación muscular que le ha conferido un cuerpo de lo más robusto.",listOf(PokemonTipoFB.VENENO,PokemonTipoFB.LUCHA), listOf(1014)),
    PokemonFB(1015,"9",R.drawable.munkidori, "Munkidori","Las toxinas de la cadena, capaces de sacar a relucir su potencial, le han estimulado el cerebro y le han hecho desarrollar poderes psíquicos.",listOf(PokemonTipoFB.VENENO,PokemonTipoFB.PSIQUICO), listOf(1015)),
    PokemonFB(1016,"9",R.drawable.fezandipiti, "Fezandipiti","Al agitar sus majestuosas alas, libera unas feromonas que dejan embelesados tanto a humanos como a Pokémon.",listOf(PokemonTipoFB.VENENO,PokemonTipoFB.HADA), listOf(1016)),
    PokemonFB(1017,"9",R.drawable.ogerpon, "Ogerpon","Cambia de tipo según la máscara que lleve. Se vale de sus rápidos movimientos y patadas para jugar a su antojo con sus enemigos.",listOf(PokemonTipoFB.PLANTA), listOf(1017)),
    PokemonFB(1018,"9",R.drawable.archaludon, "Archaludon","Acumula la electricidad estática de su entorno. El rayo que dispara cuando está a cuatro patas posee una potencia colosal.",listOf(PokemonTipoFB.ACERO,PokemonTipoFB.DRAGON), listOf(884,1018)),
    PokemonFB(1019,"9",R.drawable.hydrapple, "Hydrapple","Se trata de siete seres llamados Viborappli que viven juntos en una manzana de caramelo. El del centro es el líder del grupo.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.DRAGON), listOf(840,842,1011,1019)),
    PokemonFB(1020,"9",R.drawable.flamariete, "Flamariete","Apenas constan avistamientos de este Pokémon, pero existe una breve grabación donde aparece desbocado y escupiendo ráfagas de fuego.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.DRAGON), listOf(1020)),
    PokemonFB(1021,"9",R.drawable.electrofuria, "Electrofuria","Se dice que calcina todo cuanto lo rodea con los rayos que libera su pelaje. Aparte de eso, se sabe muy poco sobre esta criatura.",listOf(PokemonTipoFB.ELECTRICO,PokemonTipoFB.DRAGON), listOf(1021)),
    PokemonFB(1022,"9",R.drawable.ferromole, "Ferromole","Su cuerpo parece estar compuesto enteramente de metal. Debe su nombre a un objeto descrito en un tomo antiguo.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.PSIQUICO), listOf(1022)),
    PokemonFB(1023,"9",R.drawable.ferrotesta, "Ferrotesta","Se dice que puede cortarlo todo a su alrededor lanzando afiladas hojas luminosas, pero nada más se sabe acerca de esta criatura.",listOf(PokemonTipoFB.ACERO,PokemonTipoFB.PSIQUICO), listOf(1023)),
    PokemonFB(1024,"9",R.drawable.terapagos, "Terapagos","Se vale de su capacidad para transformar energía en duros cristales para protegerse. Este Pokémon dio origen a la teracristalización.",listOf(PokemonTipoFB.NORMAL), listOf(1024)),
    PokemonFB(1025,"9",R.drawable.pecharunt, "Pecharunt","Su caparazón con forma de melocotón alberga un potente veneno con el que prepara un mochi tóxico que ofrece a humanos y Pokémon.",listOf(PokemonTipoFB.VENENO,PokemonTipoFB.FANTASMA), listOf(1025)),

*/

/*
    PokemonFB(1026,"7",R.drawable.alolarattata,"Rattata de Alola", "Por la noche se aventura en las casas en busca de comida. El elevado número de ejemplares se está convirtiendo en un problema.", listOf(PokemonTipoFB.SINIESTRO, PokemonTipoFB.NORMAL),listOf(1026,1027)),
    PokemonFB(1027,"7",R.drawable.alolaraticate,"Raticate de Alola", "Es de naturaleza avariciosa. Obliga a los Rattata a acumular tanta comida en su madriguera que a menudo no puede comérsela toda.", listOf(PokemonTipoFB.SINIESTRO, PokemonTipoFB.NORMAL),listOf(1026,1027)),
    PokemonFB(1028,"7",R.drawable.alolaraichu,"Raichu de Alola", "Concentra sus poderes psíquicos en la cola y se desplaza deslizándose sobre ella. Se lo conoce como el Surfista de Tierra Firme.", listOf(PokemonTipoFB.ELECTRICO, PokemonTipoFB.PSIQUICO),listOf(1028)),
    PokemonFB(1029,"7",R.drawable.alolasandshrew,"Sandshrew de Alola", "La piel de su espalda es dura como el acero. Para protegerse la tripa, que es blanda, se aferra al suelo con todas sus fuerzas.", listOf(PokemonTipoFB.HIELO, PokemonTipoFB.ACERO),listOf(1029,1030)),
    PokemonFB(1030,"7",R.drawable.alolasandslash,"Sandslash de Alola", "Atraviesa los parajes nevados a gran velocidad. Ha desarrollado unas garras robustas y afiladas para moverse mejor en la nieve.", listOf(PokemonTipoFB.HIELO, PokemonTipoFB.ACERO),listOf(1029,1030)),
    PokemonFB(1031,"7",R.drawable.alolavulpix,"Vulpix de Alola", "Aquellos incautos que se le acercan por su entrañable apariencia acaban congelados por el Ninetales que lidera la manada.", listOf(PokemonTipoFB.HIELO, PokemonTipoFB.HADA),listOf(1031,1032)),
    PokemonFB(1032,"7",R.drawable.alolaninetales,"Ninetales de Alola", "En su pelaje se crean cristales de hielo con los que cubre al enemigo. Quien lo enfada acaba congelado al instante.", listOf(PokemonTipoFB.HIELO, PokemonTipoFB.HADA),listOf(1031,1032)),
    PokemonFB(1033,"7",R.drawable.aloladiglett,"Diglett de Alola", "Los pelillos metálicos de la cabeza son fruto de una mutación. Se comunica con sus compañeros bamboleándose.", listOf(PokemonTipoFB.TIERRA, PokemonTipoFB.ACERO),listOf(1033,1034)),
    PokemonFB(1034,"7",R.drawable.aloladugtrio,"Dugtrio de Alola", "Su pelo dorado y brillante le sirve de protección. Se dice que recoger los pelos que se le caen trae mala suerte.", listOf(PokemonTipoFB.TIERRA, PokemonTipoFB.ACERO),listOf(1033,1034)),
    PokemonFB(1035,"7",R.drawable.alolageodude,"Geodude de Alola", "Los pelillos metálicos de la cabeza son fruto de una mutación. Se comunica con sus compañeros bamboleándose.", listOf(PokemonTipoFB.ROCA, PokemonTipoFB.ELECTRICO),listOf(1035,1036,1037)),
    PokemonFB(1036,"7",R.drawable.alolagraveler,"Graveler de Alola", "Su pelo dorado y brillante le sirve de protección. Se dice que recoger los pelos que se le caen trae mala suerte.", listOf(PokemonTipoFB.ROCA, PokemonTipoFB.ELECTRICO),listOf(1035,1036,1037)),
    PokemonFB(1037,"7",R.drawable.alolagolem,"Golem de Alola", "Su pelo dorado y brillante le sirve de protección. Se dice que recoger los pelos que se le caen trae mala suerte.", listOf(PokemonTipoFB.ROCA, PokemonTipoFB.ELECTRICO),listOf(1035,1036,1037)),
    PokemonFB(1038,"7",R.drawable.alolagrimer,"Grimer de Alola", "Los Grimer se introdujeron para remediar la nociva proliferación de residuos. Su aspecto cambió de un día para otro.", listOf(PokemonTipoFB.VENENO, PokemonTipoFB.SINIESTRO),listOf(1038,1039)),
    PokemonFB(1039,"7",R.drawable.alolamuk,"Muk de Alola", "Sus colmillos y uñas son toxinas cristalizadas. Envenenan al contacto, por lo que no conviene acercarse demasiado.", listOf(PokemonTipoFB.VENENO, PokemonTipoFB.SINIESTRO),listOf(1038,1039)),
    PokemonFB(1040,"7",R.drawable.alolaexeggutor,"Exeggutor de Alola", "Su poder psíquico ha desaparecido al crecer, pero ha despertado en cambio el poder dragón que tenía latente.", listOf(PokemonTipoFB.PLANTA, PokemonTipoFB.DRAGON),listOf(1040)),
    PokemonFB(1041,"7",R.drawable.alolamarowak,"Marowak de Alola", "La región de Alola, tan frondosa y fértil, no resulta un entorno acogedor para Marowak. Manipula el fuego para mantenerse vivo.", listOf(PokemonTipoFB.FUEGO, PokemonTipoFB.FANTASMA),listOf(1041)),
    PokemonFB(1042,"8",R.drawable.galarmeowth,"Meowth de Galar", "Algunas partes de su cuerpo se volvieron metálicas tras una larga convivencia con aguerrida gente del mar.", listOf(PokemonTipoFB.ACERO),listOf(863,1042)),
    PokemonFB(1043,"8",R.drawable.galarponyta,"Ponyta de Galar", "Su pequeño cuerno posee poderes curativos capaces de sanar heridas no muy graves con tan solo un leve roce.", listOf(PokemonTipoFB.PSIQUICO),listOf(1043,1044)),
    PokemonFB(1044,"8",R.drawable.galarrapidash,"Rapidash de Galar", "Es un Pokémon orgulloso y gallardo. Atraviesa bosques sin esfuerzo concentrando sus poderes psíquicos en el pelaje de las patas.", listOf(PokemonTipoFB.PSIQUICO, PokemonTipoFB.HADA),listOf(1043,1044)),
    PokemonFB(1045,"8",R.drawable.galarslowpoke,"Slowpoke de Galar", "Su pequeño cuerno posee poderes curativos capaces de sanar heridas no muy graves con tan solo un leve roce.", listOf(PokemonTipoFB.PSIQUICO),listOf(1045,1046,1053)),
    PokemonFB(1046,"8",R.drawable.galarslowbro,"Slowbro de Galar", "Es un Pokémon orgulloso y gallardo. Atraviesa bosques sin esfuerzo concentrando sus poderes psíquicos en el pelaje de las patas.", listOf(PokemonTipoFB.VENENO, PokemonTipoFB.PSIQUICO),listOf(1045,1046,1053)),
    PokemonFB(1047,"8",R.drawable.galarfarfetchd,"Farfetch'd de Galar", "Los Farfetch'd de Galar han adoptado esta forma de tanto blandir los puerros típicos de la región, que son gruesos y largos.", listOf(PokemonTipoFB.LUCHA),listOf(1047)),
    PokemonFB(1048,"8",R.drawable.galarweezing,"Weezing de Galar", "Se desconoce el motivo, pero adoptó esta forma tiempo atrás, cuando las numerosas chimeneas de las fábricas de la región contaminaban el aire.", listOf(PokemonTipoFB.VENENO, PokemonTipoFB.HADA),listOf(1048)),
    PokemonFB(1049,"8",R.drawable.galarmrmime,"Mr. Mime de Galar", "Emite un aire glacial por las plantas de los pies. Baila claqué con entusiasmo sobre las superficies que ha congelado.", listOf(PokemonTipoFB.HIELO, PokemonTipoFB.PSIQUICO),listOf(439,1049,866)),
    PokemonFB(1050,"8",R.drawable.galararticuno,"Articuno de Galar", "Su nombre evoca el frío ártico, tal vez por los rayos que emite y que inmovilizan a sus rivales como si estuvieran congelados.", listOf(PokemonTipoFB.PSIQUICO, PokemonTipoFB.VOLADOR),listOf(1050)),
    PokemonFB(1051,"8",R.drawable.galarzapdos,"Zapdos de Galar", "El origen de su nombre parece provenir del sonido que produce el roce de su plumaje, que recuerda al estallido de un chispazo eléctrico.", listOf(PokemonTipoFB.LUCHA, PokemonTipoFB.VOLADOR),listOf(1051)),
    PokemonFB(1052,"8",R.drawable.galarmoltres,"Moltres de Galar", "Este Pokémon legendario emite un aura maligna que le rodea el cuerpo y que arde cual llama.", listOf(PokemonTipoFB.SINIESTRO, PokemonTipoFB.VOLADOR),listOf(1052)),
    PokemonFB(1053,"8",R.drawable.galarslowking,"Slowking de Galar", "Fabrica un extraño brebaje mezclando lo que ingiere con sus propias toxinas mientras recita un ominoso encantamiento.", listOf(PokemonTipoFB.VENENO, PokemonTipoFB.PSIQUICO),listOf(1045,1046,1053)),
    PokemonFB(1054,"8",R.drawable.galarcorsola,"Corsola de Galar", "Perdió la vida hace miles de años debido a un repentino cambio en su hábitat. Absorbe la vitalidad de la gente con sus ramas.", listOf(PokemonTipoFB.FANTASMA),listOf(864,1054)),
    PokemonFB(1055,"8",R.drawable.galarzigzagoon,"Zigzagoon de Galar", "Corretea por doquier sin descanso. En cuanto ve a otro Pokémon, se lanza contra él para provocarlo y buscar pelea.", listOf(PokemonTipoFB.SINIESTRO, PokemonTipoFB.NORMAL),listOf(1055,1056,862)),
    PokemonFB(1056,"8",R.drawable.galarlinoone,"Linoone de Galar", "Provoca a sus presas con su larga lengua y arremete con fuerza contra ellas cuando montan en cólera.", listOf(PokemonTipoFB.SINIESTRO, PokemonTipoFB.NORMAL),listOf(1055,1056,862)),
    PokemonFB(1057,"8",R.drawable.galardarumaka,"Darumaka de Galar", "Cuanto menor es su temperatura corporal, mejor se siente. Juega a lanzar las bolas de nieve que crea congelando el aliento.", listOf(PokemonTipoFB.HIELO),listOf(1057,1058)),
    PokemonFB(1058,"8",R.drawable.galardarmanitan,"Darmanitan de Galar", "Transporta su alimento en la bola de nieve de la cabeza. Los días de ventisca desciende hasta las zonas habitadas por los humanos.", listOf(PokemonTipoFB.HIELO),listOf(1057,1058)),
    PokemonFB(1059,"8",R.drawable.galaryamask,"Yamask de Galar", "Se dice que este Pokémon no es sino un alma lastrada por un intenso rencor, atraída por una antigua tabla de arcilla.", listOf(PokemonTipoFB.TIERRA, PokemonTipoFB.FANTASMA),listOf(1059,867)),
    PokemonFB(1060,"8",R.drawable.galarstunfisk,"Stunfisk de Galar", "Atrae a su presa con los labios, que destacan al ocultar su cuerpo en el lodo, y la aferra con sus aletas serradas y duras como el acero.", listOf(PokemonTipoFB.TIERRA, PokemonTipoFB.ACERO),listOf(1060)),
    PokemonFB(1061,"8",R.drawable.hisuigrowlithe,"Growlithe de Hisui", "Patrullan su territorio en pareja. Las rocas ígneas que salpican su pelaje quizá sean el resultado de la actividad volcánica del lugar.", listOf(PokemonTipoFB.ROCA, PokemonTipoFB.FUEGO),listOf(1061,1062)),
    PokemonFB(1062,"8",R.drawable.hisuiarcanine,"Arcanine de Hisui", "Lanza dentelladas con colmillos envueltos en un intenso fuego. A pesar de su gran tamaño, es un maestro de las fintas y juguetea alrededor de sus oponentes como si danzara.", listOf(PokemonTipoFB.ROCA, PokemonTipoFB.FUEGO),listOf(1061,1062)),
    PokemonFB(1063,"8",R.drawable.hisuivoltorb,"Voltorb de Hisui", "Curioso ejemplar que guarda cierta similitud con una Poké Ball. Cuanto más se altera, mayor es la descarga eléctrica que libera de su vientre, a la que sigue una sonora carcajada.", listOf(PokemonTipoFB.ELECTRICO, PokemonTipoFB.PLANTA),listOf(1063,1064)),
    PokemonFB(1064,"8",R.drawable.hisuielectrode,"Electrode de Hisui", "Curiosamente, su complexión superficial es muy semejante a la de un bonguri. Cuando se enoja, la electricidad que emite es veinte veces más potente que la de un rayo.", listOf(PokemonTipoFB.ELECTRICO, PokemonTipoFB.PLANTA),listOf(1063,1064)),
    PokemonFB(1065,"8",R.drawable.hisuityphlosion,"Typhlosion de Hisui", "Mi teoría es que la montaña sagrada que se yergue en el centro de Hisui ha influido en su apariencia. Se dice que purifica con sus llamas a las almas errantes y las conduce al otro mundo.", listOf(PokemonTipoFB.FUEGO, PokemonTipoFB.FANTASMA),listOf(1063,1065)),
    PokemonFB(1066,"8",R.drawable.hisuiqwilfish,"Qwilfish de Hisui", "Vive en las aguas cercanas a tierras frías. Sus púas tóxicas son más gruesas y cortas que las de los Qwilfish de otras regiones.", listOf(PokemonTipoFB.SINIESTRO, PokemonTipoFB.VENENO),listOf(1066,904)),
    PokemonFB(1067,"8",R.drawable.hisuisneasel,"Sneasel de Hisui", "Sus robustas garras son ideales para moverse por los riscos más escarpados. De sus puntas rezuma un veneno que daña los nervios de las presas que captura.", listOf(PokemonTipoFB.LUCHA, PokemonTipoFB.VENENO),listOf(1067,904)),
    PokemonFB(1068,"8",R.drawable.hisuisamurott,"Samurott de Hisui", "De actitud indiferente y muy hábil con la espada, propina incesantes y violentos ataques cual maremoto. Se trata de una forma poco común que solo se da en Hisui.", listOf(PokemonTipoFB.AGUA, PokemonTipoFB.SINIESTRO),listOf(1068)),
    PokemonFB(1069,"8",R.drawable.hisuililligant,"Lilligant de Hisui", "Habitar en montañas cubiertas de nieves le ha permitido desarrollar unas piernas robustas. Expulsa un aroma por la flor de su corona que infunde ánimo a quien esté cerca.", listOf(PokemonTipoFB.PLANTA, PokemonTipoFB.LUCHA),listOf(1069)),
    PokemonFB(1070,"8",R.drawable.hisuizorua,"Zorua de Hisui", "Es un alma difunta resucitada en Hisui que transforma su rencor en energía. Esta surge de su cabeza y adopta la forma de su oponente, disipando así su inquina.", listOf(PokemonTipoFB.FANTASMA, PokemonTipoFB.NORMAL),listOf(1070,1071)),
    PokemonFB(1071,"8",R.drawable.hisuizoroark,"Zoroark de Hisui", "La revuelta melena blanca le hace parecer la personificación de la muerte. Abate a sus rivales sin consideración por su vida valiéndose de un profundo rencor que también daña su cuerpo.", listOf(PokemonTipoFB.FANTASMA, PokemonTipoFB.NORMAL),listOf(1070,1071)),
    PokemonFB(1072,"8",R.drawable.hisuibraviary,"Braviary de Hisui", "Esta enorme ave emite un espeluznante graznido de guerra cuando sale de caza. Lanza ondas contra los lagos y atrapa a las presas que afloran a la superficie.", listOf(PokemonTipoFB.PSIQUICO, PokemonTipoFB.VOLADOR),listOf(1072)),
    PokemonFB(1073,"8",R.drawable.hisuisliggoo,"Sliggoo de Hisui", "Adolece de una personalidad lúgubre. Sospecho que su concha metálica se formó mediante una reacción entre la mucosidad que recubre su piel y el contenido férreo del agua de Hisui.", listOf(PokemonTipoFB.ACERO, PokemonTipoFB.DRAGON),listOf(704,1073,1074)),
    PokemonFB(1074,"8",R.drawable.hisuigoodra,"Goodra de Hisui", "Puede alterar la dureza de su caparazón metálico a voluntad. De carácter dependiente, detesta la soledad y monta en cólera si lo abandona alguien a quien profese gran afecto.", listOf(PokemonTipoFB.ACERO, PokemonTipoFB.DRAGON),listOf(704,1073,1074)),
    PokemonFB(1075,"8",R.drawable.hisuiavalugg,"Avalugg de Hisui", "La coraza de hielo que cubre su mandíbula es más dura que el acero y le permite triturar rocas con facilidad. Avanza veloz por escarpados senderos montañosos apartando la nieve a su paso.", listOf(PokemonTipoFB.FANTASMA, PokemonTipoFB.NORMAL),listOf(1075)),
    PokemonFB(1076,"8",R.drawable.hisuidecidueye,"Decidueye de Hisui", "Almacena aire en el raquis de las plumas, lo que le permite aguantar las gélidas temperaturas de Hisui. Un claro ejemplo de cómo el entorno puede influir en la evolución de los Pokémon.", listOf(PokemonTipoFB.PSIQUICO, PokemonTipoFB.VOLADOR),listOf(1076)),
    PokemonFB(1077,"9",R.drawable.paldeatauroslucha,"Tauros Combatiente de Paldea", "Destaca en el combate cuerpo a cuerpo gracias a su constitución musculosa. Ataca los puntos vitales del enemigo con sus cortos cuernos.", listOf(PokemonTipoFB.LUCHA),listOf(1077)),
    PokemonFB(1078,"9",R.drawable.paldeataurosfuego,"Tauros Ardiente de Paldea", "Sus cuernos alcanzan los 1000ºC cuando los calienta con energía ígnea. Quienes reciben una de sus cornadas sufren heridas y quemaduras.", listOf(PokemonTipoFB.LUCHA, PokemonTipoFB.FUEGO),listOf(1078)),
    PokemonFB(1079,"9",R.drawable.paldeataurosagua,"Tauros Acuático de Paldea", "Perfora a sus rivales lanzando chorros de agua a alta presión por la cavidad que tiene en la punta de los cuernos.", listOf(PokemonTipoFB.LUCHA, PokemonTipoFB.AGUA),listOf(1079)),
    PokemonFB(1080,"9",R.drawable.paldeawooper,"Wooper de Paldea", "Ante el riesgo que le supone desplazarse solo, forma filas de tres o cuatro individuos que cuidan unos de otros mientras recorren los pantanos.", listOf(PokemonTipoFB.VENENO, PokemonTipoFB.TIERRA),listOf(1080,980)),

*/

)







