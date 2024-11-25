package com.david.pokedex_pruebas.modelo


import android.graphics.Bitmap
import android.os.Parcelable
import com.david.pokedex_pruebas.R
import kotlinx.android.parcel.Parcelize
import java.io.Serializable
import kotlin.text.replace
import kotlin.text.trim

@Parcelize
data class PokemonFB(
    var num:Int=0,
    var gen: String="",
    var foto:Int=0,//soporte local
    var imagenFB: String? = null,//soporte en la nube
    var name: String="",
    var desc: String="",
    var tipo: List<PokemonTipoFB> = listOf()
):Serializable, Parcelable{
    constructor(
        num: Int,
        gen: String,
        foto: Int,
        name: String,
        desc: String,
        tipo: List<PokemonTipoFB>
    ) : this(num, gen, foto, null, name, desc, tipo)
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


var listaPokeFB : List<PokemonFB> = listOf(
    PokemonFB(1,"1",R.drawable.bulbasaur,"Bulbasaur", "Puede sobrevivir largo tiempo sin probar bocado. Guarda energía en el bulbo de su espalda.", listOf(PokemonTipoFB.PLANTA, PokemonTipoFB.VENENO)),
    PokemonFB(2,"1",R.drawable.ivisaur01, "Ivysaur", "Su bulbo crece cuando absorbe energía. Desprende un fuerte aroma cuando florece.", listOf(PokemonTipoFB.PLANTA, PokemonTipoFB.VENENO)),
    PokemonFB(3,"1",R.drawable.venusaur, "Venusaur", "La flor de su espalda recoge los rayos del sol. Los transforma en energía.", listOf(PokemonTipoFB.PLANTA, PokemonTipoFB.VENENO)),
    PokemonFB(4,"1",R.drawable.charmander, "Charmander", "La llama en la punta de su cola chisporrotea al arder. Sólo se oye en lugares silenciosos.", listOf(PokemonTipoFB.FUEGO)),
    PokemonFB(5,"1",R.drawable.charmeleon, "Charmeleon", "Las duras luchas excitan a este Pokémon. Entonces, lanzará llamaradas blanco-azuladas.", listOf(PokemonTipoFB.FUEGO)),
    PokemonFB(6,"1",R.drawable.charizard, "Charizard", "Cuando lanza una descarga de fuego súper caliente, la roja llama de su cola brilla más intensamente.", listOf(PokemonTipoFB.FUEGO, PokemonTipoFB.VOLADOR)),
    PokemonFB(7,"1",R.drawable.squirtle01, "Squirtle", "Lanza agua a su presa desde el agua. Se esconde en su concha cuando se siente en peligro.", listOf(PokemonTipoFB.AGUA)),
    PokemonFB(8,"1",R.drawable.wartortle, "Wartortle", "Si es golpeado, esconderá su cabeza. Aun así, su cola puede seguir golpeando.", listOf(PokemonTipoFB.AGUA)),
    PokemonFB(9,"1",R.drawable.blastoise, "Blastoise", "Cuando ataca a un enemigo, su descarga de agua es aún más potente que una manga de bombero.", listOf(PokemonTipoFB.AGUA)),
    PokemonFB(10,"1",R.drawable.caterpie, "Caterpie", "Si tocas los receptores de su cabeza, soltará un terrible olor para protegerse.", listOf(PokemonTipoFB.BICHO)),
    PokemonFB(11,"1",R.drawable.metapod, "Metapod", "Endurece su concha para protegerse. De todos modos, un gran impacto puede afectarle.", listOf(PokemonTipoFB.BICHO)),
    PokemonFB(12,"1",R.drawable.butterfree, "Butterfree", "Sus alas están cubiertas de polvos venenosos. Como repelen el agua, puede volar bajo la lluvia.", listOf(PokemonTipoFB.BICHO, PokemonTipoFB.VOLADOR)),
    PokemonFB(13,"1",R.drawable.weedle, "Weedle", "Cuidado con el aguijón venenoso de su cabeza. Se esconde en la hierba y arbustos mientras come.", listOf(PokemonTipoFB.BICHO, PokemonTipoFB.VENENO)),
    PokemonFB(14,"1",R.drawable.kakuna, "Kakuna", "Sólo puede moverse un poco. Cuando está en peligro, envenena a su enemigo con su aguijón.", listOf(PokemonTipoFB.BICHO, PokemonTipoFB.VENENO)),
    PokemonFB(15,"1",R.drawable.beedril, "Beedril", "Tiene 3 aguijones venenosos en sus patas y cola. Suele pinchar a sus enemigos repetidas veces.", listOf(PokemonTipoFB.BICHO, PokemonTipoFB.VENENO)),
    PokemonFB(16,"1",R.drawable.pidgey, "Pidgey", "Son muy dóciles. Si son atacados, suelen lanzar arena en lugar de repeler el ataque.", listOf(PokemonTipoFB.NORMAL, PokemonTipoFB.VOLADOR)),
    PokemonFB(17,"1",R.drawable.pidgeotto, "Pidgeotto", "Su visión es extraordinaria. Aunque vuele muy alto, detectará todo movimiento de su presa.", listOf(PokemonTipoFB.NORMAL, PokemonTipoFB.VOLADOR)),
    PokemonFB(18,"1",R.drawable.pidgeot, "Pidgeot", "Este Pokémon vuela a velocidad Mach 2. Sus grandes garras son armas muy peligrosas.", listOf(PokemonTipoFB.NORMAL, PokemonTipoFB.VOLADOR)),
    PokemonFB(19,"1",R.drawable.rattata, "Rattata", "Muerde cualquier cosa con sus colmillos. Si ves uno, seguro que encuentras 40 más en la zona.", listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(20,"1",R.drawable.raticate, "Raticate", "Sus patas son palmeadas. Sirven de aletas, por lo que puede nadar por ríos en busca de presa.", listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(21,"1",R.drawable.spearow, "Spearow", "Es incapaz de volar a gran altura, pero es muy rápido, lo que le permite protegerse.", listOf(PokemonTipoFB.NORMAL, PokemonTipoFB.VOLADOR)),
    PokemonFB(22,"1",R.drawable.fearow, "Fearow", "Este Pokémon es conocido desde hace muchos años. Si siente peligro volará lejos inmediatamente.", listOf(PokemonTipoFB.NORMAL, PokemonTipoFB.VOLADOR)),
    PokemonFB(23,"1",R.drawable.ekans, "Ekans", "Cuanto más viejo, más crece este Pokémon. Por la noche, descansa en las ramas de los árboles.", listOf(PokemonTipoFB.VENENO)),
    PokemonFB(24,"1",R.drawable.arbok, "Arbok", "Los espantosos dibujos de su piel han sido estudiados. Seis variaciones han sido confirmadas.", listOf(PokemonTipoFB.VENENO)),
    PokemonFB(25,"1",R.drawable.pikachu, "Pikachu", "Mantiene su cola en alto para vigilar. Si das un tirón a su cola, querrá morderte.", listOf(PokemonTipoFB.ELECTRICO)),
    PokemonFB(26,"1",R.drawable.raichu, "Raichu", "Cuando la electricidad del cuerpo crece, se vuelve irritable. También brilla en la oscuridad.", listOf(PokemonTipoFB.ELECTRICO)),
    PokemonFB(27,"1",R.drawable.sandshrew, "Sandshrew", "Su cuerpo es muy seco. Cuando hace frío por la noche, su piel aparece cubierta con un fino rocío.", listOf(PokemonTipoFB.TIERRA)),
    PokemonFB(28,"1",R.drawable.sandslash, "Sandslash", "Es muy hábil al golpear a sus enemigos con sus garras. Si se rompen, crecerán en un solo día.", listOf(PokemonTipoFB.TIERRA)),
    PokemonFB(29,"1",R.drawable.nidoranf, "Nidoran♀", "A este Pokémon no le gusta luchar. Pero cuidado, sus pequeños cuernos segregan veneno.", listOf(PokemonTipoFB.VENENO)),
    PokemonFB(30,"1",R.drawable.nidorina, "Nidorina", "Cuando descansa profundamente, sus cuernos se contraen. Esto prueba que está relajado.", listOf(PokemonTipoFB.VENENO)),
    PokemonFB(31,"1",R.drawable.nidoqueen, "Nidoqueen", "Grandes escamas recubren el duro cuerpo de este Pokémon. Éstas crecen cíclicamente.", listOf(PokemonTipoFB.VENENO, PokemonTipoFB.TIERRA)),
    PokemonFB(32,"1",R.drawable.nidoranm, "Nidoran♂", "Sus largas orejas se mantienen siempre alerta. Si siente peligro, atacará con su venenoso cuerno.", listOf(PokemonTipoFB.VENENO)),
    PokemonFB(33,"1",R.drawable.nidorino, "Nidorino", "Sus cuernos contienen veneno. Si se introducen en el cuerpo del enemigo, soltarán su tóxica carga.", listOf(PokemonTipoFB.VENENO)),
    PokemonFB(34,"1",R.drawable.nidoking, "Nidoking", "Duro como el acero, posee una poderosa carga. Sus cuernos son tan duros como el diamante.", listOf(PokemonTipoFB.VENENO, PokemonTipoFB.TIERRA)),
    PokemonFB(35,"1",R.drawable.clefairy, "Clefairy", "Su aspecto jovial y vivaracho lo hace adorable. Piensan que son raros, ya que no son muy comunes.", listOf(PokemonTipoFB.HADA)),
    PokemonFB(36,"1",R.drawable.clefable, "Clefable", "Protege bastante bien su propio entorno. Es una especie de hada, raramente vista por los humanos.", listOf(PokemonTipoFB.HADA)),
    PokemonFB(37,"1",R.drawable.vulpix, "Vulpix", "Su piel y colas son preciosas. Cuando crecen las colas, se dividen formando nuevas colas.", listOf(PokemonTipoFB.FUEGO)),
    PokemonFB(38,"1",R.drawable.ninetales, "Ninetales", "De acuerdo con una antigua leyenda, este Pokémon es la reencarnación de 9 nobles santos.", listOf(PokemonTipoFB.FUEGO)),
    PokemonFB(39,"1",R.drawable.jigglypuff, "Jigglypuff", "Utiliza sus misteriosos ojos para engañar a su enemigo. También cantará para dormirlo.", listOf(PokemonTipoFB.NORMAL, PokemonTipoFB.HADA)),
    PokemonFB(40,"1",R.drawable.wigglytuff, "Wigglytuff", "Su cuerpo es muy elástico. Cuando inhala aire profundamente, puede inflarse sin límite.", listOf(PokemonTipoFB.NORMAL, PokemonTipoFB.HADA)),
    PokemonFB(41,"1",R.drawable.zubat, "Zubat", "Emite sonidos ultrasónicos mientras vuela. Los utiliza como sónar para evitar obstáculos.", listOf(PokemonTipoFB.VENENO, PokemonTipoFB.VOLADOR)),
    PokemonFB(42,"1",R.drawable.golbat, "Golbat", "Ataca de manera violenta sin avisar. Utiliza sus afilados colmillos para chupar sangre.", listOf(PokemonTipoFB.VENENO, PokemonTipoFB.VOLADOR)),
    PokemonFB(43,"1",R.drawable.oddish, "Oddish", "Suele ser confundido con un puñado de semillas. Si lo extraes del suelo, gritará.", listOf(PokemonTipoFB.PLANTA, PokemonTipoFB.VENENO)),
    PokemonFB(44,"1",R.drawable.gloom, "Gloom", "¡Huele bastante mal! De todas formas, 1 de cada 1000 personas aprecian su fétido olor.", listOf(PokemonTipoFB.PLANTA, PokemonTipoFB.VENENO)),
    PokemonFB(45,"1",R.drawable.vileplume, "Vileplume", "Aletea sus pétalos de flores para propagar su venenoso polen. El sonido que emite es agudo.", listOf(PokemonTipoFB.PLANTA, PokemonTipoFB.VENENO)),
    PokemonFB(46,"1",R.drawable.paras, "Paras", "Escarba bajo el suelo para roer las raíces de los árboles. Sus setas absorben sus energías.", listOf(PokemonTipoFB.BICHO, PokemonTipoFB.PLANTA)),
    PokemonFB(47,"1",R.drawable.parasect, "Parasect", "El parásito absorbe la energía con las setas de la espalda, que lo controlan.", listOf(PokemonTipoFB.BICHO, PokemonTipoFB.PLANTA)),
    PokemonFB(48,"1",R.drawable.venonat, "Venonat", "Sus grandes ojos actúan como radares. En lugares claros, verás montones de pequeños ojos.", listOf(PokemonTipoFB.BICHO, PokemonTipoFB.VENENO)),
    PokemonFB(49,"1",R.drawable.venomoth, "Venomoth", "Es difícil quitar el polvo de sus alas. También posee un veneno que se desprende al contacto.", listOf(PokemonTipoFB.BICHO, PokemonTipoFB.VENENO)),
    PokemonFB(50,"1",R.drawable.diglett, "Diglett", "Prefiere los lugares oscuros. Pasa el tiempo bajo tierra, aunque aparece en cuevas.", listOf(PokemonTipoFB.TIERRA)),
    PokemonFB(51,"1",R.drawable.dugtrio, "Dugtrio", "Un grupo de trillizos que cava a 90 KPH. Por ello, creen que se trata de un terremoto.", listOf(PokemonTipoFB.TIERRA)),
    PokemonFB(52,"1",R.drawable.meowth, "Meowth", "Parece que son más activos por la noche. Adoran las cosas redondas y brillantes.", listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(53,"1",R.drawable.persian, "Persian", "¡La gema en su frente brilla por sí misma! Camina con la elegancia de una reina.", listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(54,"1",R.drawable.psyduck, "Psyduck", "Siempre tiene dolores de cabeza. Posee poderes mentales, pero no sabes cuándo los usará.", listOf(PokemonTipoFB.AGUA)),
    PokemonFB(55,"1",R.drawable.golduck, "Golduck", "Sus delgados y largos miembros acaban en anchas aletas. Las usan para nadar en los lagos.", listOf(PokemonTipoFB.AGUA)),
    PokemonFB(56,"1",R.drawable.mankey, "Mankey", "Este ágil Pokémon vive en los arboles. Se enfada fácilmente y no dudará en atacar a todos.", listOf(PokemonTipoFB.LUCHA)),
    PokemonFB(57,"1",R.drawable.primeape, "Primeape", "Sólo se calma cuando nadie está cerca. Llegar a ver ese momento es realmente difícil.", listOf(PokemonTipoFB.LUCHA)),
    PokemonFB(58,"1",R.drawable.growlithe, "Growlithe", "Este Pokémon es muy amistoso. Aun así, gruñirá a cualquiera que invada su territorio.", listOf(PokemonTipoFB.FUEGO)),
    PokemonFB(59,"1",R.drawable.arcanine, "Arcanine", "Es un Pokémon legendario en China. Allí, adoran la gracia y belleza que exhibe al correr.", listOf(PokemonTipoFB.FUEGO)),
    PokemonFB(60,"1",R.drawable.poliwag, "Poliwag", "La dirección de la espiral en el vientre cambia según el área. Prefiere nadar a correr.", listOf(PokemonTipoFB.AGUA)),
    PokemonFB(61,"1",R.drawable.poliwhirl, "Poliwhirl", "Cuando lo atacan, usa la espiral del vientre para dormir al rival. Aprovecha para escapar entonces.", listOf(PokemonTipoFB.AGUA)),
    PokemonFB(62,"1",R.drawable.poliwrath, "Poliwrath", "Es capaz de nadar usando todos los músculos de su cuerpo. Podrá adelantar incluso a un campeón.", listOf(PokemonTipoFB.AGUA, PokemonTipoFB.LUCHA)),
    PokemonFB(63,"1",R.drawable.abra, "Abra", "Duerme 18 horas al día. Si siente peligro, se teletransporta a un lugar seguro, aun durmiendo.", listOf(PokemonTipoFB.PSIQUICO)),
    PokemonFB(64,"1",R.drawable.kadabra, "Kadabra", "Muchas cosas raras suceden si está cerca. Por ejemplo, hace que los relojes vayan al revés.", listOf(PokemonTipoFB.PSIQUICO)),
    PokemonFB(65,"1",R.drawable.alakazam, "Alakazam", "Este Pokémon lo recuerda todo. Nunca olvida lo que aprende. Es un Pokémon muy listo.", listOf(PokemonTipoFB.PSIQUICO)),
    PokemonFB(66,"1",R.drawable.machop, "Machop", "Muy poderoso a pesar de su pequeño tamaño. Su maestría en artes marciales lo hace muy duro.", listOf(PokemonTipoFB.LUCHA)),
    PokemonFB(67,"1",R.drawable.machoke, "Machoke", "El cinturón que rodea su cintura retiene toda su energía. Sin él, este Pokémon sería implacable.", listOf(PokemonTipoFB.LUCHA)),
    PokemonFB(68,"1",R.drawable.machamp, "Machamp", "Con sólo un brazo puede mover montañas. Usando los cuatro, este Pokémon puede ser terrible.", listOf(PokemonTipoFB.LUCHA)),
    PokemonFB(69,"1",R.drawable.bellsprout, "Bellsprout", "Prefiere los lugares calientes y húmedos. Atrapa pequeños insectos con sus ramas para devorarlos.", listOf(PokemonTipoFB.PLANTA, PokemonTipoFB.VENENO)),
    PokemonFB(70,"1",R.drawable.weepinbell, "Weepinbell", "Cuando está hambriento, ataca a todo lo que se mueva. Su pobre presa se derrite en fuertes ácidos.", listOf(PokemonTipoFB.PLANTA, PokemonTipoFB.VENENO)),
    PokemonFB(71,"1",R.drawable.victreebel, "Victreebel", "Engaña a su presa con un dulce aroma a miel. Una vez atrapada, la presa perderá hasta sus huesos.", listOf(PokemonTipoFB.PLANTA, PokemonTipoFB.VENENO)),
    PokemonFB(72,"1",R.drawable.tentacool, "Tentacool", "A veces puede ser encontrado seco y medio enterrado en una playa. Al lanzarlo otra vez al mar revivirá.", listOf(PokemonTipoFB.AGUA, PokemonTipoFB.VENENO)),
    PokemonFB(73,"1",R.drawable.tentacruel, "Tentacruel", "Puede controlar libremente sus 80 tentáculos. Éstos debilitan a la presa con su poderoso veneno.", listOf(PokemonTipoFB.AGUA, PokemonTipoFB.VENENO)),
    PokemonFB(74,"1",R.drawable.geodude, "Geodude", "Se encuentran normalmente en los caminos de montaña. Si te cruzas con uno, se enfadará.", listOf(PokemonTipoFB.ROCA, PokemonTipoFB.TIERRA)),
    PokemonFB(75,"1",R.drawable.graveler, "Graveler", "Se le suele ver rodando por las montañas. Los obstáculos no los evita. ¡Los arrolla!", listOf(PokemonTipoFB.ROCA, PokemonTipoFB.TIERRA)),
    PokemonFB(76,"1",R.drawable.golem, "Golem", "Cuando pierde su piel, su cuerpo se vuelve blando y blanquecino. Si esto ocurre, se esconderá.", listOf(PokemonTipoFB.ROCA, PokemonTipoFB.TIERRA)),
    PokemonFB(77,"1",R.drawable.ponyta, "Ponyta", "Es capaz de saltar muy alto. Con sus pezuñas y sus robustas patas, absorbe el impacto.", listOf(PokemonTipoFB.FUEGO)),
    PokemonFB(78,"1",R.drawable.rapidash, "Rapidash", "Le encanta correr. Si ve algo más rápido que él, intentará alcanzarlo a toda velocidad.", listOf(PokemonTipoFB.FUEGO)),
    PokemonFB(79,"1",R.drawable.slowpoke, "Slowpoke", "Es increíblemente lento y perezoso. Le encanta dormir sin preocuparse ni del tiempo ni de lo que ocurra.", listOf(PokemonTipoFB.AGUA, PokemonTipoFB.PSIQUICO)),
    PokemonFB(80,"1",R.drawable.slowbro, "Slowbro", "Vive tranquilo en el mar. Si el Shellder de su cola se cae, vuelve a ser un Slowpoke otra vez.", listOf(PokemonTipoFB.AGUA, PokemonTipoFB.PSIQUICO)),
    PokemonFB(81,"1",R.drawable.magnemite, "Magnemite", "Puede desafiar a la gravedad desde su nacimiento. Flota en el aire gracias a ondas electromagnéticas.", listOf(PokemonTipoFB.ELECTRICO, PokemonTipoFB.ACERO)),
    PokemonFB(82,"1",R.drawable.magneton, "Magneton", "Genera extrañas señales de radio. Es capaz de elevar la temperatura 3º centígrados.", listOf(PokemonTipoFB.ELECTRICO, PokemonTipoFB.ACERO)),
    PokemonFB(83,"1",R.drawable.farfetchd, "Farfetch'd", "Vive cerca de las plantas. Son raramente vistos, así que se piensa que se están extinguiendo.", listOf(PokemonTipoFB.NORMAL, PokemonTipoFB.VOLADOR)),
    PokemonFB(84,"1",R.drawable.doduo, "Doduo", "Sus cortas alas lo hacen volar con dificultad. De todos modos, puede correr a gran velocidad.", listOf(PokemonTipoFB.NORMAL, PokemonTipoFB.VOLADOR)),
    PokemonFB(85,"1",R.drawable.dodrio, "Dodrio", "Una de las dos cabezas de Doduo se divide para formar un nuevo PkMn. Es capaz de correr a 40 KPH.", listOf(PokemonTipoFB.NORMAL, PokemonTipoFB.VOLADOR)),
    PokemonFB(86,"1",R.drawable.seel, "Seel", "A este Pokémon le encanta el frío. Le encanta nadar en climas polares, sea cual sea la temperatura.", listOf(PokemonTipoFB.AGUA)),
    PokemonFB(87,"1",R.drawable.dewgong, "Dewgong", "Su cuerpo es como una bola de nieve. Inmune al frío intenso, nada rápidamente en aguas heladas.", listOf(PokemonTipoFB.AGUA, PokemonTipoFB.HIELO)),
    PokemonFB(88,"1",R.drawable.grimer, "Grimer", "Está hecho de fango endurecido. Huele a pútrido. ¡Por donde pasa, no crece la hierba!", listOf(PokemonTipoFB.VENENO)),
    PokemonFB(89,"1",R.drawable.muk, "Muk", "Huele tan mal que puede provocar desmayos. Ha degenerado tanto, que ya ni él mismo se huele.", listOf(PokemonTipoFB.VENENO)),
    PokemonFB(90,"1",R.drawable.shellder, "Shellder", "Su concha puede evitar cualquier ataque. El débil cuerpo sólo está expuesto cuando está abierta.", listOf(PokemonTipoFB.AGUA)),
    PokemonFB(91,"1",R.drawable.cloyster, "Cloyster", "Utiliza su concha para protegerse. Dicen que es más dura que el diamante. También lanza espinas.", listOf(PokemonTipoFB.AGUA, PokemonTipoFB.HIELO)),
    PokemonFB(92,"1",R.drawable.gastly, "Gastly", "Solo aparece en edificios en ruinas. No tiene forma real, ya que parece que está hecho de gas.", listOf(PokemonTipoFB.FANTASMA, PokemonTipoFB.VENENO)),
    PokemonFB(93,"1",R.drawable.haunter, "Haunter", "Toma la vida de su adversario a lengüetazos. Esto produce mareos hasta que la víctima fallece.", listOf(PokemonTipoFB.FANTASMA, PokemonTipoFB.VENENO)),
    PokemonFB(94,"1",R.drawable.gengar, "Gengar", "Sabrás que un Gengar está cerca cuando sufras de sudores fríos. Intentará echarte un hechizo.", listOf(PokemonTipoFB.FANTASMA, PokemonTipoFB.VENENO)),
    PokemonFB(95,"1",R.drawable.onix, "Onix", "Cava a gran velocidad en busca de comida. Los túneles que deja son usados por los Diglett.", listOf(PokemonTipoFB.ROCA, PokemonTipoFB.TIERRA)),
    PokemonFB(96,"1",R.drawable.drowzee, "Drowzee", "Si duermes cerca de uno todo el tiempo, en alguna ocasión podrás ver sueños que se haya comido antes.", listOf(PokemonTipoFB.PSIQUICO)),
    PokemonFB(97,"1",R.drawable.hypno, "Hypno", "Intenta evitar cualquier tipo de contacto visual con este Pokémon. Puede hipnotizar con su péndulo.", listOf(PokemonTipoFB.PSIQUICO)),
    PokemonFB(98,"1",R.drawable.krabby, "Krabby", "Sus pinzas son armas perfectas. En alguna ocasión pueden romperse en combate, pero crecerán rápido.", listOf(PokemonTipoFB.AGUA)),
    PokemonFB(99,"1",R.drawable.kingler, "Kingler", "Una de sus pinzas crece más que la otra, y es dura como el acero. De todos modos, pesa demasiado.", listOf(PokemonTipoFB.AGUA)),
    PokemonFB(100,"1",R.drawable.voltorb, "Voltorb", "Se dice que se camufla como una Poké Ball. Al más mínimo estímulo se autodestruirá.", listOf(PokemonTipoFB.ELECTRICO)),
    PokemonFB(101,"1",R.drawable.electrode, "Electrode", "Almacena energía eléctrica en su cuerpo. El más leve shock puede provocar una gran explosión.", listOf(PokemonTipoFB.ELECTRICO)),
    PokemonFB(102,"1",R.drawable.exeggcute, "Exeggcute", "Sus cabezas se atraen unas a otras, y giran entre sí. Debe tener seis para equilibrarse.", listOf(PokemonTipoFB.PLANTA, PokemonTipoFB.PSIQUICO)),
    PokemonFB(103,"1",R.drawable.exeggutor, "Exeggutor", "Este Pokémon es muy ruidoso. Esto es debido a que cada una de sus cabezas hace lo que quiere.", listOf(PokemonTipoFB.PLANTA, PokemonTipoFB.PSIQUICO)),
    PokemonFB(104,"1",R.drawable.cubone, "Cubone", "Siempre lleva el cráneo de su difunta madre. Su grito hace eco y parece una triste melodía.", listOf(PokemonTipoFB.TIERRA)),
    PokemonFB(105,"1",R.drawable.marowak, "Marowak", "Pequeño y débil, este Pokémon siempre va acompañado de su palo de hueso de Pokémon.", listOf(PokemonTipoFB.TIERRA)),
    PokemonFB(106,"1",R.drawable.hitmonlee, "Hitmonlee", "Cuando da patadas al enemigo, la planta de sus pies se vuelve tan dura como el diamante.", listOf(PokemonTipoFB.LUCHA)),
    PokemonFB(107,"1",R.drawable.hitmonchan, "Hitmonchan", "Sus golpes se asemejan a una taladradora. Puede atravesar un muro de hormigón como si nada.", listOf(PokemonTipoFB.LUCHA)),
    PokemonFB(108,"1",R.drawable.lickitung, "Lickitung", "Su lengua mide casi dos metros y se mueve libremente. Sus lametazos pueden causar parálisis.", listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(109,"1",R.drawable.koffing, "Koffing", "A veces puede explotar sin avisar, ya que en lugares calurosos su gas interno se expande.", listOf(PokemonTipoFB.VENENO)),
    PokemonFB(110,"1",R.drawable.weezing, "Weezing", "Este Pokémon vive absorbiendo gases venenosos, gérmenes, y el polvo que existe en la basura.", listOf(PokemonTipoFB.VENENO)),
    PokemonFB(111,"1",R.drawable.rhyhorn, "Rhyhorn", "Este Pokémon no tiene muchas luces. Una vez inicia la carga, no para hasta que cae dormido.", listOf(PokemonTipoFB.TIERRA, PokemonTipoFB.ROCA)),
    PokemonFB(112,"1",R.drawable.rhydon, "Rhydon", "Camina sobre sus patas traseras, y muestra signos de inteligencia. Es capaz de aguantar lava hirviendo.", listOf(PokemonTipoFB.TIERRA, PokemonTipoFB.ROCA)),
    PokemonFB(113,"1",R.drawable.chansey, "Chansey", "Este amable Pokémon es capaz de compartir sus nutrientes huevos con un Pokémon herido.", listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(114,"1",R.drawable.tangela, "Tangela", "Se camufla tras una gran masa de enredaderas azules. Se dice que nunca dejan de crecer.", listOf(PokemonTipoFB.PLANTA)),
    PokemonFB(115,"1",R.drawable.kangaskhan, "Kangaskhan", "Cuida de su cría en la bolsa de su tripa. No evitará ninguna pelea para protegerla.", listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(116,"1",R.drawable.horsea, "Horsea", "Si se siente en peligro, arrojará un potente chorro de agua, o de una tinta especial, por su boca.", listOf(PokemonTipoFB.AGUA)),
    PokemonFB(117,"1",R.drawable.seadra, "Seadra", "Tocar su aleta trasera causa parálisis. Se engancha al coral para mantenerse mientras duerme.", listOf(PokemonTipoFB.AGUA)),
    PokemonFB(118,"1",R.drawable.goldeen, "Goldeen", "En su época de puesta de huevos, suelen ser vistos nadando por ríos contracorriente en grandes grupos.", listOf(PokemonTipoFB.AGUA)),
    PokemonFB(119,"1",R.drawable.seaking, "Seaking", "Este Pokémon hace sus nidos tallando cantos de riachuelo con el cuerno de su cabeza.", listOf(PokemonTipoFB.AGUA)),
    PokemonFB(120,"1",R.drawable.staryu, "Staryu", "Mientras su parte central se mantenga intacta, crecerá de nuevo aunque haya sido destrozado.", listOf(PokemonTipoFB.AGUA)),
    PokemonFB(121,"1",R.drawable.starmie, "Starmie", "Su zona central es conocida como el núcleo. Se piensa que se comunica mediante colores.", listOf(PokemonTipoFB.AGUA, PokemonTipoFB.PSIQUICO)),
    PokemonFB(122,"1",R.drawable.mrmime, "Mr. Mime", "Siempre practica la misma pantomima. Hace creer al enemigo que existe algo que no es real.", listOf(PokemonTipoFB.PSIQUICO, PokemonTipoFB.HADA)),
    PokemonFB(123,"1",R.drawable.scyther, "Scyther", "Se agazapa en la hierba alta para saltar sobre su enemigo con sus guadañas. Se mueve como un ninja.", listOf(PokemonTipoFB.BICHO, PokemonTipoFB.VOLADOR)),
    PokemonFB(124,"1",R.drawable.jynx, "Jynx", "Parece moverse como si estuviera bailando un ritmo de su propia creación. Menea mucho sus caderas.", listOf(PokemonTipoFB.HIELO, PokemonTipoFB.PSIQUICO)),
    PokemonFB(125,"1",R.drawable.electabuzz, "Electabuzz", "Cuando hay un apagón, es más que posible que este Pokémon se haya comido la energía.", listOf(PokemonTipoFB.ELECTRICO)),
    PokemonFB(126,"1",R.drawable.magmar, "Magmar", "Nacen en volcanes activos. Su cuerpo parece una gran bola de fuego ya que están en llamas.", listOf(PokemonTipoFB.FUEGO)),
    PokemonFB(127,"1",R.drawable.pinsir, "Pinsir", "Atrapa a su presa con sus pinzas, y aprieta fuerte. No se puede mover si hace mucho frío.", listOf(PokemonTipoFB.BICHO)),
    PokemonFB(128,"1",R.drawable.tauros, "Tauros", "Un rudo Pokémon repleto de energía vital. Cuando corre, no para hasta que choca con algo.", listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(129,"1",R.drawable.magikarp, "Magikarp", "Famoso por ser poco fiable. Puede encontrarse nadando en mares, lagos, ríos y charcos.", listOf(PokemonTipoFB.AGUA)),
    PokemonFB(130,"1",R.drawable.gyarados, "Gyarados", "Este Pokémon es enormemente destructivo. En la antigüedad, era conocido por destruir ciudades.", listOf(PokemonTipoFB.AGUA, PokemonTipoFB.VOLADOR)),
    PokemonFB(131,"1",R.drawable.lapras, "Lapras", "Este espíritu gentil es capaz de leer la mente. Puede llevar a la gente a través del mar.", listOf(PokemonTipoFB.AGUA, PokemonTipoFB.HIELO)),
    PokemonFB(132,"1",R.drawable.ditto, "Ditto", "Cuando se fija en un enemigo, su cuerpo se transforma en una copia perfecta del mismo.", listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(133,"1",R.drawable.eevee, "Eevee", "Su código genético es muy inestable. Puede evolucionar en diversas razas de Pokémon.", listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(134,"1",R.drawable.vaporeon, "Vaporeon", "Su estructura celular se parece a las moléculas de agua. Es invisible cuando está en el agua.", listOf(PokemonTipoFB.AGUA)),
    PokemonFB(135,"1",R.drawable.jolteon, "Jolteon", "Un Pokémon muy sensible. Se entristece o enfada con mucha facilidad, lo que le da energía.", listOf(PokemonTipoFB.ELECTRICO)),
    PokemonFB(136,"1",R.drawable.flareon, "Flareon", "El cuerpo de este Pokémon posee una cámara ígnea. Cuando exhala aire, éste está a 3.000º Celsius.", listOf(PokemonTipoFB.FUEGO)),
    PokemonFB(137,"1",R.drawable.porygon, "Porygon", "La gente dice que se trata del único Pokémon que puede volar por el espacio. Aún no lo ha logrado.", listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(138,"1",R.drawable.omanyte, "Omanyte", "Este antiguo Pokémon fue recuperado de un fósil. Nada muy bien gracias al movimiento de sus 10 tentáculos.", listOf(PokemonTipoFB.ROCA, PokemonTipoFB.AGUA)),
    PokemonFB(139,"1",R.drawable.omastar, "Omastar", "Picos afilados rodean su boca. Su concha es demasiado grande como para que se mueva libremente.", listOf(PokemonTipoFB.ROCA, PokemonTipoFB.AGUA)),
    PokemonFB(140,"1",R.drawable.kabuto, "Kabuto", "Este Pokémon fue recuperado desde un fósil. Usa los ojos de su espalda al ocultarse en el lecho marino.", listOf(PokemonTipoFB.ROCA, PokemonTipoFB.AGUA)),
    PokemonFB(141,"1",R.drawable.kabutops, "Kabutops", "Este Pokémon es un hábil y rápido nadador. Atrapa a su presa para drenar sus fluidos vitales.", listOf(PokemonTipoFB.ROCA, PokemonTipoFB.AGUA)),
    PokemonFB(142,"1",R.drawable.aerodactyl, "Aerodactyl", "Este Pokémon salvaje, extinto hace siglos, fue resucitado usando ADN tomado de un ámbar.", listOf(PokemonTipoFB.ROCA, PokemonTipoFB.VOLADOR)),
    PokemonFB(143,"1",R.drawable.snorlax, "Snorlax", "Come cualquier cosa. Incluso la comida pasada de fecha. Su estómago nunca se llena.", listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(144,"1",R.drawable.articuno, "Articuno", "Un legendario pájaro Pokémon. Congela el agua que encuentra en el aire para generar nieve.", listOf(PokemonTipoFB.HIELO, PokemonTipoFB.VOLADOR)),
    PokemonFB(145,"1",R.drawable.zapdos, "Zapdos", "Este legendario pájaro Pokémon solo aparece cuando el cielo se torna oscuro y caen rayos.", listOf(PokemonTipoFB.ELECTRICO, PokemonTipoFB.VOLADOR)),
    PokemonFB(146,"1",R.drawable.moltres, "Moltres", "Un legendario pájaro Pokémon. Cuando aletea sus flamígeras alas, la oscura noche se torna roja.", listOf(PokemonTipoFB.FUEGO, PokemonTipoFB.VOLADOR)),
    PokemonFB(147,"1",R.drawable.dratini, "Dratini", "La existencia de este Pokémon ha sido confirmada recientemente por un pescador que cogió uno.", listOf(PokemonTipoFB.DRAGON)),
    PokemonFB(148,"1",R.drawable.dragonair, "Dragonair", "De acuerdo con un testigo, un aura de extraña forma lo rodea, dándole un misterioso y místico aspecto.", listOf(PokemonTipoFB.DRAGON)),
    PokemonFB(149,"1",R.drawable.dragonite, "Dragonite", "Se dice que este Pokémon vive en algún lugar del mar, y que vuela. De todos modos, sólo es un rumor.", listOf(PokemonTipoFB.DRAGON, PokemonTipoFB.VOLADOR)),
    PokemonFB(150,"1",R.drawable.mewtwo, "Mewtwo", "Fue creado por un científico tras años de horribles experimentos de manipulación genética.", listOf(PokemonTipoFB.PSIQUICO)),
    PokemonFB(151,"1",R.drawable.mew, "Mew", "Se dice que contiene la composición genética de todos los Pokémon. Es muy raramente visto.", listOf(PokemonTipoFB.PSIQUICO)),
    PokemonFB(152,"2",R.drawable.chikorita, "Chikorita","Un dulce aroma se desprende de la hoja de su cabeza. Es dócil y le encanta absorber los rayos de sol.",listOf(PokemonTipoFB.PLANTA)),
    PokemonFB(153,"2",R.drawable.bayleef, "Bayleef","Su cuello huele a especias. Dicen que por alguna razón, su simple olor te incita a luchar.",listOf(PokemonTipoFB.PLANTA)),
    PokemonFB(154,"2",R.drawable.meganium, "Meganium","El olor que desprenden sus pétalos contiene una sustancia que calma el instinto agresivo.",listOf(PokemonTipoFB.PLANTA)),
    PokemonFB(155,"2",R.drawable.cyndaquil, "Cyndaquil","Es tímido y siempre se enrosca como una pelota. Si es atacado, enciende el lomo para protegerse.",listOf(PokemonTipoFB.FUEGO)),
    PokemonFB(156,"2",R.drawable.quilava, "Quilava","Ten cuidado si te da la espalda en combate. Significa que te va a atacar con su lomo de fuego.",listOf(PokemonTipoFB.FUEGO)),
    PokemonFB(157,"2",R.drawable.typhlosion, "Typhlosion","Si su furia crece, se calienta tanto que cualquier cosa que toque se prenderá al instante.",listOf(PokemonTipoFB.FUEGO)),
    PokemonFB(158,"2",R.drawable.totodile, "Totodile","Sus desarrolladas y potentes fauces puede romper cualquier cosa. Su Entrenador debe tener cuidado.",listOf(PokemonTipoFB.AGUA)),
    PokemonFB(159,"2",R.drawable.croconaw, "Croconaw","Si pierde un colmillo, uno nuevo crecerá en su lugar. Hay siempre 48 colmillos revistiendo su boca.",listOf(PokemonTipoFB.AGUA)),
    PokemonFB(160,"2",R.drawable.feraligatr, "Feraligatr","Le cuesta soportar su propio peso fuera del agua, así que va a cuatro patas. Aún así es rápido.",listOf(PokemonTipoFB.AGUA)),
    PokemonFB(161,"2",R.drawable.sentret, "Sentret","Es un Pokémon muy precavido. Se levanta apoyándose en la cola para tener una mejor vista de los alrededores.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(162,"2",R.drawable.furret, "Furret","Construye un nido donde introducir su largo y delgado cuerpo, en el que no pueden entrar otros Pokémon.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(163,"2",R.drawable.hoothoot, "Hoothoot","Se apoya en una sola pata y cuando hace el cambio, se mueve tan rápido que apenas se nota.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.VOLADOR)),
    PokemonFB(164,"2",R.drawable.noctowl, "Noctowl","Sus ojos se adaptan muy bien a la oscuridad; cuando hay poca luz, la condensan para poder ver.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.VOLADOR)),
    PokemonFB(165,"2",R.drawable.ledyba, "Ledyba","Es muy tímido. Tiene miedo de moverse cuando va solo. Pero si va en grupo, se vuelve muy activo.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.VOLADOR)),
    PokemonFB(166,"2",R.drawable.ledian, "Ledian","Se nutre de la luz de las estrellas. Cuanto más estrellada está la noche, más crecen los dibujos de su lomo.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.VOLADOR)),
    PokemonFB(167,"2",R.drawable.spinarak, "Spinarak","Mantiene la misma postura en su telaraña durante días, esperando a que se acerque una presa inocente.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.VENENO)),
    PokemonFB(168,"2",R.drawable.ariados, "Ariados","Pega hilos de seda a sus presas y las libera para seguirlas más tarde y localizar también a sus amigos.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.VENENO)),
    PokemonFB(169,"2",R.drawable.crobat, "Crobat","Es tan silencioso cuando vuela en la oscuridad con sus cuatro alas, que cuesta percibirlo cuando se acerca.",listOf(PokemonTipoFB.VENENO,PokemonTipoFB.VOLADOR)),
    PokemonFB(170,"2",R.drawable.chinchou, "Chinchou","Libera cargas positivas y negativas entre las puntas de las dos antenas que tiene, y electrocuta al enemigo.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.ELECTRICO)),
    PokemonFB(171,"2",R.drawable.lanturn, "Lanturn","La luz que emite es tan brillante que puede iluminar la superficie del mar desde unos 5 km de profundidad.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.ELECTRICO)),
    PokemonFB(172,"2",R.drawable.pichu, "Pichu","Todavía no domina el almacenamiento de electricidad, y descarga rayos cuando se divierte o se asusta.",listOf(PokemonTipoFB.ELECTRICO)),
    PokemonFB(173,"2",R.drawable.cleffa, "Cleffa","Por su inusual forma estrellada, la gente cree que procede de un meteorito que cayó a la tierra.",listOf(PokemonTipoFB.HADA)),
    PokemonFB(174,"2",R.drawable.igglybuff, "Igglybuff","Su cuerpo es muy blando. Cuando se pone a rodar, rebota contra todo y es imposible de parar.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.HADA)),
    PokemonFB(175,"2",R.drawable.togepi, "Togepi","El cascarón parece estar lleno de alegría. Dicen que trae buena suerte si se le trata con cariño.",listOf(PokemonTipoFB.HADA)),
    PokemonFB(176,"2",R.drawable.togetic, "Togetic","Dicen que aparece entre gentes cuidadosas y de buen corazón, a quienes inunda de felicidad.",listOf(PokemonTipoFB.HADA,PokemonTipoFB.VOLADOR)),
    PokemonFB(177,"2",R.drawable.natu, "Natu","Va dando saltitos porque sus alas no han crecido lo suficiente. Siempre está pendiente de algo.",listOf(PokemonTipoFB.PSIQUICO,PokemonTipoFB.VOLADOR)),
    PokemonFB(178,"2",R.drawable.xatu, "Xatu","Dicen que se mantiene quieto y en silencio porque observa el pasado y el futuro al mismo tiempo.",listOf(PokemonTipoFB.PSIQUICO,PokemonTipoFB.VOLADOR)),
    PokemonFB(179,"2",R.drawable.mareep, "Mareep","Cuando almacena electricidad en su organismo, duplica su volumen. Tócalo y recibirás una descarga.",listOf(PokemonTipoFB.ELECTRICO)),
    PokemonFB(180,"2",R.drawable.flaaffy, "Flaaffy","Como almacena tanta electricidad, ha desarrollado parches donde no crece ni la lana.",listOf(PokemonTipoFB.ELECTRICO)),
    PokemonFB(181,"2",R.drawable.ampharos, "Ampharos","El brillo de su cola es visible desde lejos. En la antigüedad se usaba mucho como faro.",listOf(PokemonTipoFB.ELECTRICO)),
    PokemonFB(182,"2",R.drawable.bellossom, "Bellossom","Los Bellossom suelen reunirse para bailar. Dicen que sus danzas son un ritual para invocar al sol.",listOf(PokemonTipoFB.PLANTA)),
    PokemonFB(183,"2",R.drawable.marill, "Marill","Usa el extremo de su cola como boya, así no se ahoga aunque lo arrastre una fuerte corriente.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.HADA)),
    PokemonFB(184,"2",R.drawable.azumarill, "Azumarill","Guardando silencio y prestando mucha atención puede saber lo que hay en los rápidos y salvajes ríos.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.HADA)),
    PokemonFB(185,"2",R.drawable.sudowoodo, "Sudowoodo","Aunque pretende ser un árbol, en su composición se parece más a una roca que a una planta.",listOf(PokemonTipoFB.ROCA)),
    PokemonFB(186,"2",R.drawable.politoed, "Politoed","Si Poliwag y Poliwhirl oyen su grito, responderán y se reunirán estén donde estén.",listOf(PokemonTipoFB.AGUA)),
    PokemonFB(187,"2",R.drawable.hoppip, "Hoppip","Para evitar ser arrastrados por el viento, se reúnen en grupos, aunque adoran las brisas suaves.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.VOLADOR)),
    PokemonFB(188,"2",R.drawable.skiploom, "Skiploom","Abre sus pétalos para absorber la luz solar. También flota en el aire para estar más cerca del sol.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.VOLADOR)),
    PokemonFB(189,"2",R.drawable.jumpluff, "Jumpluff","Se desplaza con los vientos estacionales y suelta sus esporas por todo el mundo para reproducirse.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.VOLADOR)),
    PokemonFB(190,"2",R.drawable.aipom, "Aipom","Vive en las copas de árboles gigantes. Mientras duerme, enrolla la cola en una rama para no caerse.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(191,"2",R.drawable.sunkern, "Sunkern","Cae de repente del cielo por las mañanas. Los años de veranos suaves su número se multiplica.",listOf(PokemonTipoFB.PLANTA)),
    PokemonFB(192,"2",R.drawable.sunflora, "Sunflora","Convierte la luz solar en energía. En la oscuridad, tras el atardecer, cierra sus pétalos y queda inmóvil.",listOf(PokemonTipoFB.PLANTA)),
    PokemonFB(193,"2",R.drawable.yanma, "Yanma","Si agita muy rápido las alas, genera ondas expansivas capaces de hacer añicos las ventanas que haya cerca.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.VOLADOR)),
    PokemonFB(194,"2",R.drawable.wooper, "Wooper","Cuando anda por la tierra cubre su cuerpo con una capa venenosa para mantener hidratada su piel.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.TIERRA)),
    PokemonFB(195,"2",R.drawable.quagsire, "Quagsire","Este despreocupado Pokémon es de naturaleza tranquila. Siempre que nada, se choca con los barcos.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.TIERRA)),
    PokemonFB(196,"2",R.drawable.espeon, "Espeon","Basándose en las corrientes de aire predice cosas como el clima o el próximo ataque del enemigo.",listOf(PokemonTipoFB.PSIQUICO)),
    PokemonFB(197,"2",R.drawable.umbreon, "Umbreon","Cuando oscurece, los anillos de su cuerpo comienzan a brillar, asustando a cualquiera que se acerque.",listOf(PokemonTipoFB.SINIESTRO)),
    PokemonFB(198,"2",R.drawable.murkrow, "Murkrow","Temido y odiado por muchos, dicen que trae la desgracia a todos aquellos que lo ven por la noche.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.VOLADOR)),
    PokemonFB(199,"2",R.drawable.slowking, "Slowking","Al ser mordido en la cabeza, Slowpoke absorbió unas toxinas que liberaron su poder oculto.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.PSIQUICO)),
    PokemonFB(200,"2",R.drawable.misdreavus, "Misdreavus","Le gusta hacer travesuras como gritar y aullar por la noche, para asustar a la gente.",listOf(PokemonTipoFB.FANTASMA)),
    PokemonFB(201,"2",R.drawable.unown, "Unown","Su cuerpo fino y plano aparece siempre en los muros. Su forma parece tener algún significado.",listOf(PokemonTipoFB.PSIQUICO)),
    PokemonFB(202,"2",R.drawable.wobbuffet, "Wobbuffet","Para mantener oculta su negra cola, vive en silencio en la oscuridad. Nunca ataca primero.",listOf(PokemonTipoFB.PSIQUICO)),
    PokemonFB(203,"2",R.drawable.girafarig, "Girafarig","La cola, que también tiene un pequeño cerebro, muerde por su cuenta si nota un olor seductor.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.PSIQUICO)),
    PokemonFB(204,"2",R.drawable.pineco, "Pineco","Le gusta engrosar su coraza añadiendo cortezas de árbol. El aumento de peso no le molesta.",listOf(PokemonTipoFB.BICHO)),
    PokemonFB(205,"2",R.drawable.forretress, "Forretress","Todo su cuerpo está protegido por una concha de metal. Lo que esconde la concha es un misterio.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.ACERO)),
    PokemonFB(206,"2",R.drawable.dunsparce, "Dunsparce","Este Pokémon escapa perforando el suelo con la cola y enterrándose de espaldas, si es descubierto.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(207,"2",R.drawable.gligar, "Gligar","A veces se sujeta a los precipicios. Cuando divisa una presa, despliega las alas y planea para atacar.",listOf(PokemonTipoFB.TIERRA,PokemonTipoFB.VOLADOR)),
    PokemonFB(208,"2",R.drawable.steelix, "Steelix","Su cuerpo ha sido comprimido en el interior de la tierra, y por eso es hasta más duro que el diamante.",listOf(PokemonTipoFB.TIERRA,PokemonTipoFB.ACERO)),
    PokemonFB(209,"2",R.drawable.snubbull, "Snubbull","Muy travieso por naturaleza, a muchas mujeres les gusta jugar con él porque es muy cariñoso.",listOf(PokemonTipoFB.HADA)),
    PokemonFB(210,"2",R.drawable.granbull, "Granbull","Como le pesan mucho los colmillos, se le va la cabeza hacia delante. Su mordisco es muy potente.",listOf(PokemonTipoFB.HADA)),
    PokemonFB(211,"2",R.drawable.qwilfish, "Qwilfish","Las pequeñas púas que cubren su cuerpo eran escamas. Inyectan una toxina que debilita.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.VENENO)),
    PokemonFB(212,"2",R.drawable.scizor, "Scizor","Mueve sus pinzas para asustar al enemigo. Por los dibujos de su cuerpo parece tener 3 cabezas.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.ACERO)),
    PokemonFB(213,"2",R.drawable.shuckle, "Shuckle","Suele ser dócil, pero si se le molesta mientras succiona miel, perseguirá con su cuerno al intruso.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.ROCA)),
    PokemonFB(214,"2",R.drawable.heracross, "Heracross","Forman grupos en los bosques para buscar savia de árboles, su comida favorita. Puede voltear a su presa.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.LUCHA)),
    PokemonFB(215,"2",R.drawable.sneasel, "Sneasel","Se alimenta de huevos robados en nidos. Clava sus afiladas garras en los puntos débiles de sus rivales.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.HIELO)),
    PokemonFB(216,"2",R.drawable.teddiursa, "Teddiursa","Cuando encuentra miel, le brilla la marca que tiene en la frente. Si se llena las garras de miel, se las lame.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(217,"2",R.drawable.ursaring, "Ursaring","Capaz de percibir cualquier tipo de aroma, encuentra sin problemas todo alimento enterrado bajo tierra.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(218,"2",R.drawable.slugma, "Slugma","No duerme nunca. Tiene que seguir moviéndose porque si se detiene, su cuerpo de lava podría enfriarse.",listOf(PokemonTipoFB.FUEGO)),
    PokemonFB(219,"2",R.drawable.magcargo, "Magcargo","En ocasiones, lanza por la resbaladiza coraza que tiene intensas llamaradas que recorren todo su cuerpo.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.ROCA)),
    PokemonFB(220,"2",R.drawable.swinub, "Swinub","Si percibe un aroma tentador, se tira de cabeza para encontrar el origen de dicho olor.",listOf(PokemonTipoFB.HIELO,PokemonTipoFB.TIERRA)),
    PokemonFB(221,"2",R.drawable.piloswine, "Piloswine","Como su largo vello corporal le impide ver con claridad, sigue atacando repetidamente.",listOf(PokemonTipoFB.HIELO,PokemonTipoFB.TIERRA)),
    PokemonFB(222,"2",R.drawable.corsola, "Corsola","Tiene muy buena puntería. Dispara agua a sus presas, hasta cuando se mueven, a más de 100 metros.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.ROCA)),
    PokemonFB(223,"2",R.drawable.remoraid, "Remoraid","En ocasiones, lanza por la resbaladiza coraza que tiene intensas llamaradas que recorren todo su cuerpo.",listOf(PokemonTipoFB.AGUA)),
    PokemonFB(224,"2",R.drawable.octillery, "Octillery","Instintivamente se escabulle entre las rocas. Si le entra sueño, robará la guarida de otro Octillery.",listOf(PokemonTipoFB.AGUA)),
    PokemonFB(225,"2",R.drawable.delibird, "Delibird","Anida en el borde de escarpados acantilados. Se pasa todo el día llevando comida a sus polluelos.",listOf(PokemonTipoFB.HIELO,PokemonTipoFB.VOLADOR)),
    PokemonFB(226,"2",R.drawable.mantine, "Mantine","Nada con gran elegancia e ignora a los Remoraid que se aferran a sus aletas buscando restos de comida.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.VOLADOR)),
    PokemonFB(227,"2",R.drawable.skarmory, "Skarmory","Sus fuertes alas parecen pesadas, aunque son huecas y ligeras, y le permiten volar libremente.",listOf(PokemonTipoFB.ACERO,PokemonTipoFB.VOLADOR)),
    PokemonFB(228,"2",R.drawable.houndour, "Houndour","Usa diferentes tipos de gritos para comunicarse con los de su especie o para seguir a su presa.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.FUEGO)),
    PokemonFB(229,"2",R.drawable.houndoom, "Houndoom","Hace mucho, la gente creía que sus horripilantes aullidos eran de la muerte personificada.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.FUEGO)),
    PokemonFB(230,"2",R.drawable.kingdra, "Kingdra","Duerme en el fondo del océano para recargarse de energía. Dicen que causa tornados cuando se levanta.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.DRAGON)),
    PokemonFB(231,"2",R.drawable.phanpy, "Phanpy","A pesar de su tamaño reducido, es tan fuerte que puede llevar a un humano a su espalda con facilidad.",listOf(PokemonTipoFB.TIERRA)),
    PokemonFB(232,"2",R.drawable.donphan, "Donphan","Cuanto más grandes son sus colmillos, mayor su estatus en la manada. Los colmillos tardan mucho en crecer.",listOf(PokemonTipoFB.TIERRA)),
    PokemonFB(233,"2",R.drawable.porygon2, "Porygon2","Esta versión mejorada de Porygon fue creada para explorar el espacio, aunque no puede volar.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(234,"2",R.drawable.stantler, "Stantler","Su cornamenta cambia el flujo del aire para crear un espacio de realidad distorsionada.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(235,"2",R.drawable.smeargle, "Smeargle","La punta de la cola rezuma un fluido especial. Lo pinta todo con este líquido para marcar su terreno.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(236,"2",R.drawable.tyrogue, "Tyrogue","Famoso por su disposición a la lucha. Siempre tiene heridas por luchar con enemigos más grandes.",listOf(PokemonTipoFB.LUCHA)),
    PokemonFB(237,"2",R.drawable.hitmontop, "Hitmontop","Si te quedas embobado con las suaves, elegantes y danzarinas patadas que da, puedes acabar lleno de magulladuras.",listOf(PokemonTipoFB.LUCHA)),
    PokemonFB(238,"2",R.drawable.smoochum, "Smoochum","Sus labios son la parte más sensible de su cuerpo. Siempre los usa para examinar las cosas.",listOf(PokemonTipoFB.HIELO,PokemonTipoFB.PSIQUICO)),
    PokemonFB(239,"2",R.drawable.elekid, "Elekid","Entre sus cuernos pasa una débil corriente eléctrica. Quien ponga ahí la mano se dará un calambrazo.",listOf(PokemonTipoFB.ELECTRICO)),
    PokemonFB(240,"2",R.drawable.magby, "Magby","Aparece en los cráteres de los volcanes. Puede alcanzar los 600 grados de temperatura, así que no lo subestimes.",listOf(PokemonTipoFB.FUEGO)),
    PokemonFB(241,"2",R.drawable.miltank, "Miltank","Se dice que si un niño bebe leche de Miltank crecerá y se convertirá en un adulto sano y campechano.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(242,"2",R.drawable.blissey, "Blissey","Cualquiera que pruebe un poco de huevo de Blissey, se volverá más amable y agradable con todos.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(243,"2",R.drawable.raikou, "Raikou","Las nubes de lluvia que lleva le permiten lanzar rayos a voluntad. Dicen que apareció con un rayo.",listOf(PokemonTipoFB.ELECTRICO)),
    PokemonFB(244,"2",R.drawable.entei, "Entei","Cuando ladra, los volcanes entran en erupción. Como no puede controlar su poder, corre siempre en cabeza.",listOf(PokemonTipoFB.FUEGO)),
    PokemonFB(245,"2",R.drawable.suicune, "Suicune","Conocido como la reencarnación de los vientos del norte, puede purificar aguas turbias y sucias.",listOf(PokemonTipoFB.AGUA)),
    PokemonFB(246,"2",R.drawable.larvitar, "Larvitar","Nace muy profundo en el suelo, y no podrá salir hasta que se haya comido la tierra que le rodea.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.TIERRA)),
    PokemonFB(247,"2",R.drawable.pupitar, "Pupitar","Hasta encerrado en su coraza, se mueve libremente. Duro y rápido, su poder destructivo es enorme.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.TIERRA)),
    PokemonFB(248,"2",R.drawable.tyranitar, "Tyranitar","Tiene tanta fuerza que puede cambiar el paisaje. Su naturaleza insolente le hace ser muy egoísta.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.SINIESTRO)),
    PokemonFB(249,"2",R.drawable.lugia, "Lugia","Dicen que es el guardián de los mares. Hay rumores de que fue visto en una noche de tormenta.",listOf(PokemonTipoFB.PSIQUICO,PokemonTipoFB.VOLADOR)),
    PokemonFB(250,"2",R.drawable.hooh, "Ho-Oh","Cuenta la leyenda que este Pokémon vuela por el cielo con sus magníficas alas de siete colores.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.VOLADOR)),
    PokemonFB(251,"2",R.drawable.celebi, "Celebi","Este Pokémon vaga por el tiempo. La hierba y los árboles crecen por los campos por donde pasa.",listOf(PokemonTipoFB.PSIQUICO,PokemonTipoFB.PLANTA)),
    PokemonFB(252,"3",R.drawable.treecko, "Treecko","Escala superficies verticales muy rápido. Con la cola detecta la humedad y prevé el tiempo que va a hacer.",listOf(PokemonTipoFB.PLANTA)),
    PokemonFB(253,"3",R.drawable.grovyle, "Grovyle","Con su magnífica fuerza se desplaza saltando grácilmente de rama en rama por los árboles más altos.",listOf(PokemonTipoFB.PLANTA)),
    PokemonFB(254,"3",R.drawable.sceptile, "Sceptile","Corre con elegancia de un lugar a otro de la selva y usa las afiladas hojas de sus brazos para cazar.",listOf(PokemonTipoFB.PLANTA)),
    PokemonFB(255,"3",R.drawable.torchic, "Torchic","La bolsa de fuego que arde en su interior hace que al abrazarlo esté tan caliente como un calientapiés.",listOf(PokemonTipoFB.FUEGO)),
    PokemonFB(256,"3",R.drawable.combusken, "Combusken","Al pelear, el fuego de su interior se intensifica. Es capaz de propinar unas patadas demoledoras.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.LUCHA)),
    PokemonFB(257,"3",R.drawable.blaziken, "Blaziken","Ante un rival difícil, expulsa llamas por las muñecas. Tiene mucha fuerza en las patas; hasta puede saltar edificios.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.LUCHA)),
    PokemonFB(258,"3",R.drawable.mudkip, "Mudkip","La aleta de su cabeza detecta las corrientes de agua y los peligros. Tiene fuerza para levantar rocas.",listOf(PokemonTipoFB.AGUA)),
    PokemonFB(259,"3",R.drawable.marshtomp, "Marshtomp","Sus piernas robustas impiden que pierda el equilibrio y caiga, incluso en el barro. Duerme bajo la arena.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.TIERRA)),
    PokemonFB(260,"3",R.drawable.swampert, "Swampert","Con sus brazos duros como el acero puede partir rocas gigantescas en mil pedazos de un solo golpe.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.TIERRA)),
    PokemonFB(261,"3",R.drawable.poochyena, "Poochyena","Si se fija en una presa, no cejará hasta que se canse, pero si esta contraataca, se acobardará.",listOf(PokemonTipoFB.SINIESTRO)),
    PokemonFB(262,"3",R.drawable.mightyena, "Mightyena","Forman manadas de diez individuos y cercan a sus presas valiéndose de un trabajo en equipo impecable.",listOf(PokemonTipoFB.SINIESTRO)),
    PokemonFB(263,"3",R.drawable.zigzagoon, "Zigzagoon","Le llaman la atención muchas cosas, por lo que se mueve en zigzag. Se le da bien encontrar cosas.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(264,"3",R.drawable.linoone, "Linoone","Carga contra sus enemigos a más de 100 km por hora. Como solo va en línea recta, falla a menudo.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(265,"3",R.drawable.wurmple, "Wurmple","Es el blanco favorito de muchos Pokémon pájaro. Se defiende con el veneno de las púas de su cola.",listOf(PokemonTipoFB.BICHO)),
    PokemonFB(266,"3",R.drawable.silcoon, "Silcoon","Se agarra con su seda a las ramas de un árbol y espera su evolución bebiendo agua de lluvia.",listOf(PokemonTipoFB.BICHO)),
    PokemonFB(267,"3",R.drawable.beautifly, "Beautifly","Aunque no lo parece, es un Pokémon agresivo. Si se le molesta cuando recoge polen, atacará.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.VOLADOR)),
    PokemonFB(268,"3",R.drawable.cascoon, "Cascoon","Jamás olvida a quienes lo atacaron mientras estaba en su capullo. Cuando evoluciona busca venganza.",listOf(PokemonTipoFB.BICHO)),
    PokemonFB(269,"3",R.drawable.dustox, "Dustox","Bate las alas para esparcir polvo tóxico. De noche se come las hojas de los árboles de las avenidas.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.VENENO)),
    PokemonFB(270,"3",R.drawable.lotad, "Lotad","Como la hoja de su cabeza se hizo muy grande y pesada, empezó a vivir flotando en el agua.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.PLANTA)),
    PokemonFB(271,"3",R.drawable.lombre, "Lombre","Pokémon nocturno que entra en acción al caer la tarde. Se alimenta de musgos del lecho de los ríos.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.PLANTA)),
    PokemonFB(272,"3",R.drawable.ludicolo, "Ludicolo","Cuando oye música alegre sus músculos se llenan de energía y no puede evitar ponerse a bailar.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.PLANTA)),
    PokemonFB(273,"3",R.drawable.seedot, "Seedot","Se cuelga de las ramas con el extremo de su cabeza. A veces se cae cuando soplan vientos fuertes.",listOf(PokemonTipoFB.PLANTA)),
    PokemonFB(274,"3",R.drawable.nuzleaf, "Nuzleaf","Cuando usa la hoja de su cabeza como flauta asusta a la gente. Vive en lo más profundo de los bosques.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.SINIESTRO)),
    PokemonFB(275,"3",R.drawable.shiftry, "Shiftry","Vive sigiloso en lo más profundo del bosque. Dicen que con sus abanicos puede generar vientos gélidos.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.SINIESTRO)),
    PokemonFB(276,"3",R.drawable.taillow, "Taillow","Es un Pokémon valiente que no teme a los rivales fuertes. Vuela en busca de climas templados.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.VOLADOR)),
    PokemonFB(277,"3",R.drawable.swellow, "Swellow","Vive en los bosques. Si encuentra una presa, se lanza en picado y la atrapa con sus garras.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.VOLADOR)),
    PokemonFB(278,"3",R.drawable.wingull, "Wingull","Aprovecha las corrientes ascendentes para ganar altura. Suele llevar comida en el pico.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.VOLADOR)),
    PokemonFB(279,"3",R.drawable.pelipper, "Pelipper","Protege a sus crías de los enemigos metiéndolos en su pico. En días de poco oleaje reposa sobre el agua.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.VOLADOR)),
    PokemonFB(280,"3",R.drawable.ralts, "Ralts","Si sus cuernos perciben emociones positivas de personas o Pokémon, su cuerpo se calienta un poco.",listOf(PokemonTipoFB.PSIQUICO,PokemonTipoFB.HADA)),
    PokemonFB(281,"3",R.drawable.kirlia, "Kirlia","Si su entrenador está contento, se llena de energía y baila de forma alegre dando giros.",listOf(PokemonTipoFB.PSIQUICO,PokemonTipoFB.HADA)),
    PokemonFB(282,"3",R.drawable.gardevoir, "Gardevoir","Para proteger a su Entrenador emplea todo su poder psíquico en crear un pequeño agujero negro.",listOf(PokemonTipoFB.PSIQUICO,PokemonTipoFB.HADA)),
    PokemonFB(283,"3",R.drawable.surskit, "Surskit","Del extremo de su cabeza mana un líquido de aroma almibarado. Vive en estanques repletos de plantas.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.AGUA)),
    PokemonFB(284,"3",R.drawable.masquerain, "Masquerain","Sus antenas tienen dibujos de ojos, mientras que sus alas le permiten volar en cualquier dirección.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.VOLADOR)),
    PokemonFB(285,"3",R.drawable.shroomish, "Shroomish","Si presiente peligro, se protege esparciendo esporas venenosas desde la parte superior de su cabeza.",listOf(PokemonTipoFB.PLANTA)),
    PokemonFB(286,"3",R.drawable.breloom, "Pelipper","Esparce esporas venenosas muy nocivas y asesta puñetazos de gran intensidad a sus enemigos.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.LUCHA)),
    PokemonFB(287,"3",R.drawable.slakoth, "Slakoth","Si se come tres hojas al día ya queda satisfecho. Aparte de eso, se pasa durmiendo 20 horas al día.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(288,"3",R.drawable.slaking, "Slaking","Su corazón late a un ritmo diez veces más rápido de lo normal. No se está quieto ni un instante.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(289,"3",R.drawable.vigoroth, "Vigoroth","El Pokémon más perezoso del mundo. Si está tumbado, es que reúne fuerzas para contraatacar.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(290,"3",R.drawable.nincada, "Nincada","Crece bajo tierra y explora el entorno con sus antenas, que sustituyen a ojos atrofiados.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.TIERRA)),
    PokemonFB(291,"3",R.drawable.ninjask, "Ninjask","Escuchar su zumbido de forma continuada provoca jaquecas. Casi no se le ve de lo rápido que es.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.VOLADOR)),
    PokemonFB(292,"3",R.drawable.shedinja, "Shedinja","Es un Pokémon muy peculiar; aparece de repente en una Poké Ball cuando Nincada evoluciona.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.FANTASMA)),
    PokemonFB(293,"3",R.drawable.whismur, "Whismur","Cuando percibe peligro, lanza gritos con volumen similar al de un reactor e intimida a sus enemigos.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(294,"3",R.drawable.loudred, "Loudred","Las ondas de sus gritos pueden voltear a un camión. Patea el suelo para ganar potencia.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(295,"3",R.drawable.exploud, "Exploud","El bramido que emite al atacar puede sacudir la tierra con la intensidad de un terremoto.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(296,"3",R.drawable.makuhita, "Makuhita","Endurece su cuerpo golpeando grandes árboles. Cerca de su hogar suele haber árboles golpeados.",listOf(PokemonTipoFB.LUCHA)),
    PokemonFB(297,"3",R.drawable.hariyama, "Hariyama","Le encanta enfrentarse a Pokémon grandes y probar su fuerza. Sus brazos pueden derribar un camión.",listOf(PokemonTipoFB.LUCHA)),
    PokemonFB(298,"3",R.drawable.azurill, "Azurill","Su cola rebota como una pelota. Para luchar contra enemigos más grandes, la agita en el aire.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.HADA)),
    PokemonFB(299,"3",R.drawable.nosepass, "Nosepass","Se protege del peligro aumentando su magnetismo y atrayendo objetos de hierro hacia sí.",listOf(PokemonTipoFB.ROCA)),
    PokemonFB(300,"3",R.drawable.skitty, "Skitty","No puede evitar ir tras las cosas que se mueven. Hasta corre en círculos persiguiéndose la cola.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(301,"3",R.drawable.delcatty, "Delcatty","Tiene mucho éxito entre las entrenadoras por su suave pelaje. No vive en un sitio fijo.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(302,"3",R.drawable.sableye, "Sableye","Hace su guarida en cuevas oscuras. Usa sus afiladas garras para desenterrar las gemas que se come.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.FANTASMA)),
    PokemonFB(303,"3",R.drawable.mawile, "Mawile","Las grandes fauces de su cabeza están formadas por cuernos. Puede romper el hierro con ellas.",listOf(PokemonTipoFB.ACERO,PokemonTipoFB.HADA)),
    PokemonFB(304,"3",R.drawable.aron, "Aron","Suele vivir en lugares inaccesibles de las montañas, pero el hambre lo empuja a comer raíles y coches.",listOf(PokemonTipoFB.ACERO,PokemonTipoFB.ROCA)),
    PokemonFB(305,"3",R.drawable.lairon, "Lairon","Le encanta comer hierro. Lucha por su territorio embistiendo a sus rivales con su cuerpo de acero.",listOf(PokemonTipoFB.ACERO,PokemonTipoFB.ROCA)),
    PokemonFB(306,"3",R.drawable.aggron, "Aggron","Se puede calcular su edad por la longitud de sus cuernos de acero. Su territorio es toda una montaña.",listOf(PokemonTipoFB.ACERO,PokemonTipoFB.ROCA)),
    PokemonFB(307,"3",R.drawable.meditite, "Meditite","Se entrena en la profundidad de las montañas. Cuando aumenta su poder espiritual con meditación, levita.",listOf(PokemonTipoFB.LUCHA,PokemonTipoFB.PSIQUICO)),
    PokemonFB(308,"3",R.drawable.medicham, "Medicham","Perfecciona su poder espiritual con una meditación diaria. Puede sentir lo que piensan los demás.",listOf(PokemonTipoFB.LUCHA,PokemonTipoFB.PSIQUICO)),
    PokemonFB(309,"3",R.drawable.electrike, "Electrike","Almacena electricidad estática en su pelaje. En estaciones secas, suelta chispas por todo el cuerpo.",listOf(PokemonTipoFB.ELECTRICO)),
    PokemonFB(310,"3",R.drawable.manectric, "Manectric","Se dice que coloca sus nidos donde caen rayos. Descarga electricidad desde su melena.",listOf(PokemonTipoFB.ELECTRICO)),
    PokemonFB(311,"3",R.drawable.plusle, "Plusle","Anima a sus compañeros con pompones de chispas. Roba energía de los postes telefónicos.",listOf(PokemonTipoFB.ELECTRICO)),
    PokemonFB(312,"3",R.drawable.minun, "Minun","La electricidad de Minun y Plusle es buena para la circulación y para desentumecer músculos.",listOf(PokemonTipoFB.ELECTRICO)),
    PokemonFB(313,"3",R.drawable.volbeat, "Volbeat","Se comunica con otros iluminando su cola por la noche. Le encanta el suave aroma de Illumise.",listOf(PokemonTipoFB.BICHO)),
    PokemonFB(314,"3",R.drawable.illumise, "Illumise","Con su dulce aroma guía a Volbeat para que tracen hasta 200 dibujos distintos en el cielo nocturno.",listOf(PokemonTipoFB.BICHO)),
    PokemonFB(315,"3",R.drawable.roselia, "Roselia","Si goza de mejor salud, el aroma de sus flores será más agradable. Es un aroma que relaja a la gente.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.VENENO)),
    PokemonFB(316,"3",R.drawable.gulpin, "Gulpin","Sus sesos y su corazón son diminutos; es casi todo estómago. Sus jugos gástricos disuelven lo que sea.",listOf(PokemonTipoFB.VENENO)),
    PokemonFB(317,"3",R.drawable.swalot, "Swalot","Se traga cualquier cosa de una pieza. Sus poros segregan fluidos tóxicos que dañan a sus enemigos.",listOf(PokemonTipoFB.VENENO)),
    PokemonFB(318,"3",R.drawable.carvanha, "Carvanha","Rodean a los enemigos que osan invadir su territorio. Sus afilados colmillos dañan los barcos.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.SINIESTRO)),
    PokemonFB(319,"3",R.drawable.sharpedo, "Sharpedo","Con sus colmillos puede atravesar el acero. Nada a 120 Km por hora. Le llaman el terror de los mares.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.SINIESTRO)),
    PokemonFB(320,"3",R.drawable.wailmer, "Wailmer","En días soleados se tumba en las playas para jugar y botar como una pelota. Lanza agua por la nariz.",listOf(PokemonTipoFB.AGUA)),
    PokemonFB(321,"3",R.drawable.wailord, "Wailord","Es el más grande de los Pokémon. Puede nadar a una profundidad de 3000 m aguantando la respiración.",listOf(PokemonTipoFB.AGUA)),
    PokemonFB(322,"3",R.drawable.numel, "Numel","Acumula magma en ebullición en la joroba de su lomo que transforma en una energía extraordinaria.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.TIERRA)),
    PokemonFB(323,"3",R.drawable.camerupt, "Camerupt","Vive en cráteres de volcanes. Es famoso por las jorobas de su lomo, que entran en erupción cada diez años.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.TIERRA)),
    PokemonFB(324,"3",R.drawable.torkoal, "Torkoal","Quema carbón en su caparazón para obtener energía. Si le atacan, echa un denso humo negro.",listOf(PokemonTipoFB.FUEGO)),
    PokemonFB(325,"3",R.drawable.spoink, "Spoink","Bota usando su cola para mantener el latido de su corazón. Lleva una perla de Clamperl en la cabeza.",listOf(PokemonTipoFB.PSIQUICO)),
    PokemonFB(326,"3",R.drawable.grumpig, "Grumpig","Usa perlas negras para potenciar sus poderes psíquicos. Con su raro baile controla a los rivales.",listOf(PokemonTipoFB.PSIQUICO)),
    PokemonFB(327,"3",R.drawable.spinda, "Spinda","La probabilidad de que dos Spinda con dibujos idénticos en su pelaje se encuentren es casi inexistente.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(328,"3",R.drawable.trapinch, "Trapinch","Si una presa cae en las fosas cóncavas de arena que cava en el desierto no podrá salir de ellas.",listOf(PokemonTipoFB.TIERRA)),
    PokemonFB(329,"3",R.drawable.vibrava, "Vibrava","Genera ondas ultrasónicas al batir las alas violentamente, causando intensos dolores de cabeza.",listOf(PokemonTipoFB.TIERRA,PokemonTipoFB.DRAGON)),
    PokemonFB(330,"3",R.drawable.flygon, "Flygon","El batir de sus alas suena como un canto de mujer. Se le conoce como el Alma del Desierto.",listOf(PokemonTipoFB.TIERRA,PokemonTipoFB.DRAGON)),
    PokemonFB(331,"3",R.drawable.cacnea, "Cacnea","Habita en el desierto. Aguanta treinta días sin agua gracias a la que almacena en su cuerpo.",listOf(PokemonTipoFB.PLANTA)),
    PokemonFB(332,"3",R.drawable.cacturne, "Cacturne","Es un Pokémon nocturno. Busca presas agotadas por el calor diurno del desierto.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.SINIESTRO)),
    PokemonFB(333,"3",R.drawable.swablu, "Swablu","Si su cuerpo o su entorno no están limpios, no puede relajarse. Utiliza sus alas para limpiar la suciedad.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.VOLADOR)),
    PokemonFB(334,"3",R.drawable.altaria, "Altaria","Cuando vuela, parece una nube de algodón. Entona bellas melodías con su voz de soprano.",listOf(PokemonTipoFB.DRAGON,PokemonTipoFB.VOLADOR)),
    PokemonFB(335,"3",R.drawable.zangoose, "Zangoose","Se le eriza todo el pelaje con solo oler un Seviper. Con sus afiladas zarpas puede rajar a sus enemigos.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(336,"3",R.drawable.seviper, "Seviper","Se ha enfrentado durante muchos años a Zangoose. Usa rocas para mantener afilada su cola.",listOf(PokemonTipoFB.VENENO)),
    PokemonFB(337,"3",R.drawable.lunatone, "Lunatone","Se piensa que está muy influido por las fases lunares, ya que solo actúa en noches de luna llena.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.PSIQUICO)),
    PokemonFB(338,"3",R.drawable.solrock, "Solrock","Una nueva especie de Pokémon que se rumorea procede del Sol. Emite luz al girar.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.PSIQUICO)),
    PokemonFB(339,"3",R.drawable.barboach, "Barboach","Los bigotes de Barboach le permiten saborear los alimentos como si fueran una lengua humana.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.TIERRA)),
    PokemonFB(340,"3",R.drawable.whiscash, "Whiscash","Habita en grandes pantanos. Si se acerca un enemigo, se alborota y causa temblores monumentales.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.TIERRA)),
    PokemonFB(341,"3",R.drawable.corphish, "Corphish","Llegó del extranjero y se halla en estado salvaje. Puede vivir hasta en los ríos más sucios.",listOf(PokemonTipoFB.AGUA)),
    PokemonFB(342,"3",R.drawable.crawdaunt, "Crawdaunt","Este malandrín usa sus pinzas para atosigar y expulsar a los otros Pokémon que viven en su estanque.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.SINIESTRO)),
    PokemonFB(343,"3",R.drawable.baltoy, "Baltoy","Se mueve girando sobre su eje. Es un extraño Pokémon que fue encontrado en unas viejas ruinas.",listOf(PokemonTipoFB.TIERRA,PokemonTipoFB.PSIQUICO)),
    PokemonFB(344,"3",R.drawable.claydol, "Claydol","Este Pokémon es una vieja figurilla de barro que cobró vida mediante la exposición a extraños rayos de luz.",listOf(PokemonTipoFB.TIERRA,PokemonTipoFB.PSIQUICO)),
    PokemonFB(345,"3",R.drawable.lileep, "Lileep","Vivió en los fondos marinos hace unos 100 millones de años y fue recreado científicamente.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.PLANTA)),
    PokemonFB(346,"3",R.drawable.cradily, "Cradily","Vive en el fondo de los mares de aguas templadas. Emerge para cazar cuando baja la marea.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.PLANTA)),
    PokemonFB(347,"3",R.drawable.anorith, "Anorith","Pokémon de origen prehistórico. Al pasar a vivir en el agua, sus ocho patas se convirtieron en alas.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.BICHO)),
    PokemonFB(348,"3",R.drawable.armaldo, "Armaldo","Tras evolucionar, este Pokémon fue a tierra firme. Una dura coraza protege todo su cuerpo.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.BICHO)),
    PokemonFB(349,"3",R.drawable.feebas, "Feebas","Su apariencia deja bastante que desear, pero es muy resistente y puede sobrevivir con poca agua.",listOf(PokemonTipoFB.AGUA)),
    PokemonFB(350,"3",R.drawable.milotic, "Milotic","Se dice que su hermosa figura puede apaciguar el corazón de aquellos que tienen un carácter agriado.",listOf(PokemonTipoFB.AGUA)),
    PokemonFB(351,"3",R.drawable.castform, "Castform","La meteorología determina su aspecto. Hace poco se ha sabido que sus células son como el agua.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(352,"3",R.drawable.kecleon, "Kecleon","Puede mudar el color de su cuerpo a voluntad, pero el dibujo en zigzag de su panza nunca desaparece.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(353,"3",R.drawable.shuppet, "Shuppet","Dicen que con su cuerno se alimenta de sentimientos de celos y envidia. Es muy activo a medianoche.",listOf(PokemonTipoFB.FANTASMA)),
    PokemonFB(354,"3",R.drawable.banette, "Bannette","Este muñeco se convirtió en un Pokémon cuando lo tiraron a la basura. Busca a su antiguo dueño.",listOf(PokemonTipoFB.FANTASMA)),
    PokemonFB(355,"3",R.drawable.duskull, "Duskull","Persigue a su presa como un perro allá donde vaya. No obstante, abandona la caza al amanecer.",listOf(PokemonTipoFB.FANTASMA)),
    PokemonFB(356,"3",R.drawable.dusclops, "Dusclops","Su cuerpo está hueco. Se dice que quien mire dentro, será tragado por un agujero negro.",listOf(PokemonTipoFB.FANTASMA)),
    PokemonFB(357,"3",R.drawable.tropius, "Tropius","Los racimos de su cuello dan fruto cada 6 meses. A los niños de zonas tropicales les encanta su dulzor.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.VOLADOR)),
    PokemonFB(358,"3",R.drawable.chimecho, "Chimecho","Sus gritos resuenan en su cuerpo hueco y emergen como hermosas notas que aturden a los enemigos.",listOf(PokemonTipoFB.PSIQUICO)),
    PokemonFB(359,"3",R.drawable.absol, "Absol","Cuando se supo que presentía los desastres con su cuerno, tuvo que buscar refugio en las montañas.",listOf(PokemonTipoFB.SINIESTRO)),
    PokemonFB(360,"3",R.drawable.wynaut, "Wynaut","Suelen ir en grupo. Templan su paciencia jugando a empujarse los unos a los otros.",listOf(PokemonTipoFB.PSIQUICO)),
    PokemonFB(361,"3",R.drawable.snorunt, "Snorunt","En las zonas nevadas, las leyendas dicen que si un Snorunt vive en una casa, trae prosperidad.",listOf(PokemonTipoFB.HIELO)),
    PokemonFB(362,"3",R.drawable.glalie, "Glalie","Congela a sus presas enfriando en un momento la humedad contenida en el aire que lo rodea.",listOf(PokemonTipoFB.HIELO)),
    PokemonFB(363,"3",R.drawable.spheal, "Spheal","Rueda por los témpanos de hielo hasta la orilla, ya que su cuerpo no está bien adaptado para nadar.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.HIELO)),
    PokemonFB(364,"3",R.drawable.sealeo, "Sealeo","Su nariz es muy sensible. Cuando ve algo por primera vez, lo toca con ella para recordarlo después.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.HIELO)),
    PokemonFB(365,"3",R.drawable.walrein, "Walrein","Sus fuertes colmillos destrozan los témpanos hielo. Su capa de grasa lo protege de sus enemigos.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.HIELO)),
    PokemonFB(366,"3",R.drawable.clamperl, "Clamperl","Durante toda su vida, crea una sola perla que, según se dice, aumenta los poderes psíquicos.",listOf(PokemonTipoFB.AGUA)),
    PokemonFB(367,"3",R.drawable.huntail, "Huntail","Vive en oscuros abismos marinos. Usa su cola como si fuera un ser vivo para atraer a sus presas.",listOf(PokemonTipoFB.AGUA)),
    PokemonFB(368,"3",R.drawable.gorebyss, "Gorebyss","Su cuerpo se torna de un rosa vivo en primavera debido a que aumenta la temperatura del fondo del mar.",listOf(PokemonTipoFB.AGUA)),
    PokemonFB(369,"3",R.drawable.relicanth, "Relicanth","Un Pokémon raro descubierto en una exploración marina. No ha cambiado en más de 100 millones de años.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.ROCA)),
    PokemonFB(370,"3",R.drawable.luvdisc, "Luvdisc","Popular por su forma de corazón. En algunos sitios es costumbre que las parejas se regalen Luvdisc.",listOf(PokemonTipoFB.AGUA)),
    PokemonFB(371,"3",R.drawable.bagon, "Bagon","Su desarrollado cuello y su cabeza dura como el acero le permiten reducir a añicos rocas enormes.",listOf(PokemonTipoFB.DRAGON)),
    PokemonFB(372,"3",R.drawable.shelgon, "Shelgon","Las células han empezado a cambiar dentro de su dura concha, que se separa cuando evoluciona.",listOf(PokemonTipoFB.DRAGON)),
    PokemonFB(373,"3",R.drawable.salamence, "Salamence","Si se enfada, no hay forma de que se calme. Echa a volar e incendia campos y montañas desde el cielo.",listOf(PokemonTipoFB.DRAGON,PokemonTipoFB.VOLADOR)),
    PokemonFB(374,"3",R.drawable.beldum, "Beldum","Se comunican mediante pulsos magnéticos. Cuando van en grupos, se mueven al unísono.",listOf(PokemonTipoFB.ACERO,PokemonTipoFB.PSIQUICO)),
    PokemonFB(375,"3",R.drawable.metang, "Metang","Lo forman dos Beldum unidos. Puede chocarse con un avión sin que su cuerpo de acero sufra ni rasguño.",listOf(PokemonTipoFB.ACERO,PokemonTipoFB.PSIQUICO)),
    PokemonFB(376,"3",R.drawable.metagross, "Metagross","Está formado por varios Metang. Con cuatro cerebros, tiene la inteligencia de un superordenador.",listOf(PokemonTipoFB.ACERO,PokemonTipoFB.PSIQUICO)),
    PokemonFB(377,"3",R.drawable.regirock, "Regirock","Las rocas que componen el cuerpo de Regirock pueden encontrarse en todos los estratos geológicos.",listOf(PokemonTipoFB.ROCA)),
    PokemonFB(378,"3",R.drawable.regice, "Regice","Dicen que ha yacido durmiendo en un glaciar durante milenios. Ni el magma puede derretir su cuerpo.",listOf(PokemonTipoFB.HIELO)),
    PokemonFB(379,"3",R.drawable.registeel, "Registeel","Su cuerpo ha estado sometido a la presión subterránea durante miles de años y no puede arañarse.",listOf(PokemonTipoFB.ACERO)),
    PokemonFB(380,"3",R.drawable.latias, "Latias","Se comunica por telepatía. Su plumaje refleja la luz, lo que le permite hacerse invisible.",listOf(PokemonTipoFB.DRAGON,PokemonTipoFB.PSIQUICO)),
    PokemonFB(381,"3",R.drawable.latios, "Latios","Es muy inteligente y entiende el lenguaje humano. Es un Pokémon muy dócil y no le gusta nada combatir.",listOf(PokemonTipoFB.DRAGON,PokemonTipoFB.PSIQUICO)),
    PokemonFB(382,"3",R.drawable.kyogre, "Kyogre","Se dice que aumentó el nivel del mar a base de aguaceros. Ha estado durmiendo en una fosa marina.",listOf(PokemonTipoFB.AGUA)),
    PokemonFB(383,"3",R.drawable.groudon, "Groudon","Dicen que este Pokémon legendario simboliza la tierra. Tras batirse en duelo con Kyogre se echó a dormir.",listOf(PokemonTipoFB.TIERRA)),
    PokemonFB(384,"3",R.drawable.rayquaza, "Rayquaza","Ha vivido durante cientos de millones de años en la capa de ozono. Cuando vuela, parece un meteorito.",listOf(PokemonTipoFB.DRAGON,PokemonTipoFB.VOLADOR)),
    PokemonFB(385,"3",R.drawable.jirachi, "Jirachi","Desde antaño se dice que concederá los deseos escritos en las notas de su cabeza cuando se despierte.",listOf(PokemonTipoFB.ACERO,PokemonTipoFB.PSIQUICO)),
    PokemonFB(386,"3",R.drawable.deoxys, "Deoxys","Surgió a raíz de la mutación de ADN de un virus alienígena que cayó a la Tierra en un meteorito.",listOf(PokemonTipoFB.PSIQUICO)),
    PokemonFB(387,"4",R.drawable.turtwig, "Turtwig","Realiza la fotosíntesis para obtener oxígeno. Si tiene sed, las hojas de la cabeza se marchitan.",listOf(PokemonTipoFB.TIERRA)),
    PokemonFB(388,"4",R.drawable.grotle, "Grotle","Sabe dónde encontrar manantiales de agua pura y lleva a los Pokémon amigos hasta allí en su lomo.",listOf(PokemonTipoFB.TIERRA)),
    PokemonFB(389,"4",R.drawable.torterra, "Torterra","Las gentes de antaño creían que el planeta se sustentaba en la espalda de un gran Torterra.",listOf(PokemonTipoFB.TIERRA)),
    PokemonFB(390,"4",R.drawable.chimchar, "Chimchar","El fuego que arde en su cola lo generan los gases de su estómago y disminuye cuando está débil.",listOf(PokemonTipoFB.FUEGO)),
    PokemonFB(391,"4",R.drawable.monferno, "Monferno","Controla hábilmente la intensidad del fuego de su cola para mantener al enemigo a una distancia ideal.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.LUCHA)),
    PokemonFB(392,"4",R.drawable.infernape, "Infernape","Maneja a sus rivales con tremenda agilidad. En su especial forma de luchar usa todos sus miembros.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.LUCHA)),
    PokemonFB(393,"4",R.drawable.piplup, "Piplup","No le gusta que lo cuiden. Como no aprecia el apoyo de su Entrenador, le cuesta coger confianza con él.",listOf(PokemonTipoFB.AGUA)),
    PokemonFB(394,"4",R.drawable.prinplup, "Prinplup","Los golpes de sus alas pueden partir los árboles más gruesos. Busca sus presas en aguas heladas.",listOf(PokemonTipoFB.AGUA)),
    PokemonFB(395,"4",R.drawable.empoleon, "Empoleon","Aunque nunca pelea en vano, si amenazan la seguridad de los suyos los defiende implacablemente.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.ACERO)),
    PokemonFB(396,"4",R.drawable.starly, "Starly","Son débiles individualmente, por eso forman grupos. Pero, si el grupo crece demasiado, se pelean.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.VOLADOR)),
    PokemonFB(397,"4",R.drawable.staravia, "Staravia","Son conscientes de su debilidad, así que siempre viven en grupo. Si se encuentran solos, lloran a gritos.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.VOLADOR)),
    PokemonFB(398,"4",R.drawable.staraptor, "Staraptor","Jamás deja de atacar, aunque le hayan herido. Le preocupa mucho la forma de su cresta.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.VOLADOR)),
    PokemonFB(399,"4",R.drawable.bidoof, "Bidoof","Forman colonias en las riberas de los ríos. Cerca de su madriguera se pueden ver rocas y troncos roídos.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(400,"4",R.drawable.bibarel, "Bibarel","Un río en el que un Bibarel cree una presa jamás se desbordará. Por esa razón la gente los aprecia.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.AGUA)),
    PokemonFB(401,"4",R.drawable.kricketot, "Kricketot","Tiene las patas cortas. Cada vez que se tropieza, sus antenas chocan y suenan como un xilófono.",listOf(PokemonTipoFB.BICHO)),
    PokemonFB(402,"4",R.drawable.kricketune, "Kriketune","Hay un pueblo en el que celebran un concurso basado en la increíble variedad de sus gritos",listOf(PokemonTipoFB.BICHO)),
    PokemonFB(403,"4",R.drawable.shinx, "Shinx","Produce electricidad contrayendo sus músculos. Si siente peligro, su pelaje brilla resplandeciente.",listOf(PokemonTipoFB.ELECTRICO)),
    PokemonFB(404,"4",R.drawable.luxio, "Luxio","Por las puntas de sus garras pasa una fuerte corriente eléctrica. El mínimo roce debilita al enemigo.",listOf(PokemonTipoFB.ELECTRICO)),
    PokemonFB(405,"4",R.drawable.luxray, "Luxray","Cuando sus ojos brillan como el oro, puede ver presas escondidas, incluso detrás de un muro.",listOf(PokemonTipoFB.ELECTRICO)),
    PokemonFB(406,"4",R.drawable.budew, "Budew","Es muy sensible a los cambios de temperatura. Si hace calor, su capullo florece y esparce polen venenoso.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.VENENO)),
    PokemonFB(407,"4",R.drawable.roserade, "Roserade","Atrae a sus presas con un dulce aroma y las derriba con veneno. Cuanto más venenoso, mejor huele.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.VENENO)),
    PokemonFB(408,"4",R.drawable.cranidos, "Cranidos","Vivía en la jungla hace 100 millones de años. Apartaba los árboles del camino a cabezazos.",listOf(PokemonTipoFB.ROCA)),
    PokemonFB(409,"4",R.drawable.rampardos, "Rampardos","Tiene sesos pequeños porque su duro cráneo, que soporta cualquier golpe, les impide desarrollarse.",listOf(PokemonTipoFB.ROCA)),
    PokemonFB(410,"4",R.drawable.shieldon, "Shieldon","Gracias a su imponente protección facial, puede comer hierba y bayas donde quiera sin que le molesten.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.ACERO)),
    PokemonFB(411,"4",R.drawable.bastiodon, "Bastiodon","Se alineaban y creaban una barrera que ningún enemigo podía cruzar. Así protegían a sus crías.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.ACERO)),
    PokemonFB(412,"4",R.drawable.burmy, "Burmy","En épocas frías recubre su cuerpo con una capa de ramas y hojas. Al llegar el calor la hace más fina.",listOf(PokemonTipoFB.BICHO)),
    PokemonFB(413,"4",R.drawable.wormadam, "Wormadam","Su apariencia varía según dónde evolucione. Los materiales que halla pasan a formar parte de su cuerpo.",listOf(PokemonTipoFB.BICHO)),
    PokemonFB(414,"4",R.drawable.mothim, "Mothim","Hace vida nocturna. Revolotea y roba la miel de las colmenas de Combee cuando duermen.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.VOLADOR)),
    PokemonFB(415,"4",R.drawable.combee, "Combee","El trío se forma al nacer y se pasa la vida recogiendo miel de las flores para satisfacer a Vespiquen.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.VOLADOR)),
    PokemonFB(416,"4",R.drawable.vespiquen, "Vespiquen","Cría larvas en los panales de su cuerpo. Segrega diversas feromonas de su cuerpo con las cuales controla a sus crías.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.VOLADOR)),
    PokemonFB(417,"4",R.drawable.pachirisu, "Pachirisu","A veces se ve a dos frotándose las bolsas de las mejillas para compartir electricidad almacenada.",listOf(PokemonTipoFB.ELECTRICO)),
    PokemonFB(418,"4",R.drawable.buizel, "Buizel","Para impulsarse por el agua gira sus dos colas como una hélice. Así también corta las algas del camino.",listOf(PokemonTipoFB.AGUA)),
    PokemonFB(419,"4",R.drawable.floatzel, "Floatzel","Con el flotador inflado puede llevar a personas sobre su espalda. Si lo desinfla, se sumerge.",listOf(PokemonTipoFB.AGUA)),
    PokemonFB(420,"4",R.drawable.cherubi, "Cherubi","Obtiene la energía necesaria para evolucionar de esa pequeña esfera que está cargada de nutrientes.",listOf(PokemonTipoFB.PLANTA)),
    PokemonFB(421,"4",R.drawable.cherrim, "Cherrim","Cuando los rayos del sol inundan su capullo, abre de par en par sus pétalos y se vuelve muy dinámico.",listOf(PokemonTipoFB.PLANTA)),
    PokemonFB(422,"4",R.drawable.shellos, "Shellos","No hay que apretarle muy fuerte, ya que si lo haces, segrega un misterioso fluido morado.",listOf(PokemonTipoFB.AGUA)),
    PokemonFB(423,"4",R.drawable.gastrodon, "Gastrodon","Si se ve amenazado por sus enemigos naturales, segrega un líquido morado y huye rápidamente.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.TIERRA)),
    PokemonFB(424,"4",R.drawable.aipom, "Aipom","Usando sus colas, AMBIPOM puede propinar golpes sucesivos a velocidad de vértigo que son imposibles de esquivar.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(425,"4",R.drawable.drifloon, "Drifloon","Se dice que a veces desaparecen niños que agarran un Drifloon pensando que es un globo.",listOf(PokemonTipoFB.FANTASMA,PokemonTipoFB.VOLADOR)),
    PokemonFB(426,"4",R.drawable.drifblim, "Driflim","Transporta a gente y Pokémon volando pero, como se deja llevar, puede acabar en cualquier sitio.",listOf(PokemonTipoFB.FANTASMA,PokemonTipoFB.VOLADOR)),
    PokemonFB(427,"4",R.drawable.buneary, "Buneary","Lleva las orejas enrolladas. Cuando las extiende, golpea con tal fuerza que incluso puede romper rocas.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(428,"4",R.drawable.lopunny, "Lopunny","Cada seis meses cambia su pelaje, que en las estaciones frías se vuelve muy suave y de gran calidad.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(429,"4",R.drawable.mismagius, "Mismagius","Sus gritos parecen cánticos. Se dice que en alguna rara ocasión han imbuido felicidad a quien los oía.",listOf(PokemonTipoFB.FANTASMA)),
    PokemonFB(430,"4",R.drawable.honchkrow, "Shellos","Si uno lanza un grito profundo, los demás acuden. Por eso se le llama también invocador de la noche.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.VOLADOR)),
    PokemonFB(431,"4",R.drawable.glameow, "Shellos","Oculta una tendencia rencorosa que le hace arañar la nariz de su entrenador si no le da de comer.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(432,"4",R.drawable.purugly, "Shellos","Rodea su cuerpo con las colas para parecer más grande. Si fija la mirada, no se perderá un detalle.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(433,"4",R.drawable.chingling, "Shellos","Emite chillidos en unas frecuencias imperceptibles para las personas. Cuando empieza no puede parar.",listOf(PokemonTipoFB.PSIQUICO)),
    PokemonFB(434,"4",R.drawable.stunky, "Stunky","Expulsa un fluido maloliente por sus cuartos traseros. El hedor repele Pokémon en un radio de 2 km.",listOf(PokemonTipoFB.VENENO,PokemonTipoFB.SINIESTRO)),
    PokemonFB(435,"4",R.drawable.skuntank, "Skuntank","Ataca emitiendo un fluido maloliente por la punta de su cola. Los ataques aéreos le confunden.",listOf(PokemonTipoFB.VENENO,PokemonTipoFB.SINIESTRO)),
    PokemonFB(436,"4",R.drawable.bronzor, "Bronzor","Se descubrieron herramientas con su forma en tumbas antiguas, pero se desconoce si tiene relación.",listOf(PokemonTipoFB.ACERO,PokemonTipoFB.PSIQUICO)),
    PokemonFB(437,"4",R.drawable.bronzong, "Bronzong","Se produjo un gran revuelo cuando encontraron uno en una obra después de 2000 años durmiendo.",listOf(PokemonTipoFB.ACERO,PokemonTipoFB.PSIQUICO)),
    PokemonFB(438,"4",R.drawable.bonsly, "Bonsly","Parece que siempre está llorando, pero en realidad está eliminando el exceso de fluidos corporales.",listOf(PokemonTipoFB.ROCA)),
    PokemonFB(439,"4",R.drawable.mimejr, "Mime Jr.","Cuando tiene a alguien delante imita su expresión y movimientos para extender sus sentimientos.",listOf(PokemonTipoFB.PSIQUICO,PokemonTipoFB.HADA)),
    PokemonFB(440,"4",R.drawable.happiny, "Happiny","Le encantan las cosas blancas y redondas. Imita a Chansey llevando una roca en forma de huevo.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(441,"4",R.drawable.chatot, "Chatot","Pueden aprender y hablar lenguas humanas. Si se juntan, todos aprenden las mismas palabras.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.VOLADOR)),
    PokemonFB(442,"4",R.drawable.spiritomb, "Spiritomb","Como castigo por una fechoría 500 años atrás, está unido a la fisura de una piedra angular mística.",listOf(PokemonTipoFB.FANTASMA,PokemonTipoFB.SINIESTRO)),
    PokemonFB(443,"4",R.drawable.gible, "Gible","Vive en agujeros en las cuevas, al amparo del calor geotérmico. Si se acerca un enemigo, le muerde.",listOf(PokemonTipoFB.DRAGON,PokemonTipoFB.TIERRA)),
    PokemonFB(444,"4",R.drawable.gabite, "Gabite","Suele buscar y acumular gemas en su nido. Su botín es objetivo constante de ladrones.",listOf(PokemonTipoFB.DRAGON,PokemonTipoFB.TIERRA)),
    PokemonFB(445,"4",R.drawable.garchomp, "Garchomp","Cuando despliega su cuerpo y sus alas, parece un avión a reacción. Vuela a velocidad sónica.",listOf(PokemonTipoFB.DRAGON,PokemonTipoFB.TIERRA)),
    PokemonFB(446,"4",R.drawable.munchlax, "Munchlax","En su desesperación por engullir comida, se suele olvidar de la que esconde debajo de su pelaje.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(447,"4",R.drawable.riolu, "Riolu","Su cuerpo es ágil pero fuerte. Puede subir tres montañas y cruzar dos cañones en una noche.",listOf(PokemonTipoFB.LUCHA)),
    PokemonFB(448,"4",R.drawable.lucario, "Lucario","Si se ha entrenado bien, puede percibir auras e identificar y asimilar sentimientos a 1 km.",listOf(PokemonTipoFB.LUCHA,PokemonTipoFB.ACERO)),
    PokemonFB(449,"4",R.drawable.hippopotas, "Hippopotas","Cierra la nariz y luego atraviesa la arena con toda tranquilidad. Suele formar colonias de diez individuos.",listOf(PokemonTipoFB.TIERRA)),
    PokemonFB(450,"4",R.drawable.hippowdon, "Hippowdon","Hace gala de su fuerza abriendo su enorme boca. Para atacar levanta gran cantidad de arena.",listOf(PokemonTipoFB.TIERRA)),
    PokemonFB(451,"4",R.drawable.skorupi, "Skorupi","Agarra a sus presas con las garras de la cola y les inyecta veneno. Espera hasta que hace efecto.",listOf(PokemonTipoFB.VENENO,PokemonTipoFB.BICHO)),
    PokemonFB(452,"4",R.drawable.drapion, "Drapion","Está dentro de una fuerte coraza. Su cabeza rota 180 grados para poder ver en todas direcciones.",listOf(PokemonTipoFB.VENENO,PokemonTipoFB.SINIESTRO)),
    PokemonFB(453,"4",R.drawable.croagunk, "Croagunk","Las toxinas que segrega por los dedos alivian el dolor de espalda y se usan en ciertos medicamentos.",listOf(PokemonTipoFB.VENENO,PokemonTipoFB.LUCHA)),
    PokemonFB(454,"4",R.drawable.toxicroak, "Toxicroak","Sus bolsas venenosas almacenan una toxina que le llega a las garras por unos tubos en los brazos.",listOf(PokemonTipoFB.VENENO,PokemonTipoFB.LUCHA)),
    PokemonFB(455,"4",R.drawable.carnivine, "Carnivine","Se desplaza hábilmente con sus tentáculos buscando ramas desde las que acechar a sus presas.",listOf(PokemonTipoFB.PLANTA)),
    PokemonFB(456,"4",R.drawable.finneon, "Finneon","La línea que le recorre el costado puede almacenar luz solar. Brilla con mucha fuerza por la noche.",listOf(PokemonTipoFB.AGUA)),
    PokemonFB(457,"4",R.drawable.lumineon, "Lumineon","Vive en las profundidades marinas. Atrae a sus presas con parpadeos del dibujo de sus cuatro aletas.",listOf(PokemonTipoFB.AGUA)),
    PokemonFB(458,"4",R.drawable.mantyke, "Mantyke","La gente organiza excursiones para ver a este Pokémon retozando por las olas con Remoraid.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.VOLADOR)),
    PokemonFB(459,"4",R.drawable.snover, "Snover","Siente mucha curiosidad por los humanos. Si uno encuentra huellas en la nieve, acuden todos a mirar.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.HIELO)),
    PokemonFB(460,"4",R.drawable.abomasnow, "Abomasnow","Es el abominable hombre de las nieves. Produce ventiscas en las montañas cubiertas de nieve.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.HIELO)),
    PokemonFB(461,"4",R.drawable.weavile, "Wwavile","Vive en zonas nevadas. Deja marcas en los árboles con sus garras para comunicarse con sus compañeros.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.HIELO)),
    PokemonFB(462,"4",R.drawable.magnezone, "Magnezone","Fruto de la evolución de Magneton cuando un campo magnético singular altera su estructura molecular.",listOf(PokemonTipoFB.ELECTRICO,PokemonTipoFB.ACERO)),
    PokemonFB(463,"4",R.drawable.lickilicky, "Lickilicky","Su larga lengua está siempre llena de babas. El contacto con su saliva causa entumecimiento.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(464,"4",R.drawable.rhyperior, "Rhyperior","Pone rocas en los agujeros de sus manos y las lanza con los músculos. Pocas veces ataca a Geodude.",listOf(PokemonTipoFB.TIERRA,PokemonTipoFB.ROCA)),
    PokemonFB(465,"4",R.drawable.tangrowth, "Tangrowth","Sus brazos están hechos de plantas que se agarran a las cosas. Si se le cortan vuelven a crecer enseguida.",listOf(PokemonTipoFB.PLANTA)),
    PokemonFB(466,"4",R.drawable.electivire, "Electivire","Al almacenar mucha electricidad, desprende chispas de una claridad increíble entre sus dos cuernos.",listOf(PokemonTipoFB.ELECTRICO)),
    PokemonFB(467,"4",R.drawable.magmortar, "Magmortar","Cuando lanza sus bolas de fuego a 2000 grados, su cuerpo adquiere un tono blanquecino por el calor.",listOf(PokemonTipoFB.FUEGO)),
    PokemonFB(468,"4",R.drawable.togekiss, "Togekiss","Congenia muy bien con las personas que respetan los derechos de los demás y evitan riñas innecesarias.",listOf(PokemonTipoFB.HADA,PokemonTipoFB.VOLADOR)),
    PokemonFB(469,"4",R.drawable.yanmega, "Yanmega","Con sus seis patas puede llevar a un adulto y volar con comodidad. Se equilibra con las alas de su cola.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.VOLADOR)),
    PokemonFB(470,"4",R.drawable.leafeon, "Leafeon","Al igual que una planta, hace la fotosíntesis. Como consecuencia, siempre está rodeado de aire puro.",listOf(PokemonTipoFB.PLANTA,)),
    PokemonFB(471,"4",R.drawable.glaceon, "Glaceon","Para protegerse, puede congelar completamente su pelaje, de modo que los pelos parecen agujas.",listOf(PokemonTipoFB.HIELO)),
    PokemonFB(472,"4",R.drawable.gliscor, "Gliscor","Espera a sus presas colgado de una rama bocabajo. Cuando llega su oportunidad, se lanza en picado.",listOf(PokemonTipoFB.TIERRA,PokemonTipoFB.VOLADOR)),
    PokemonFB(473,"4",R.drawable.mamoswine, "Mamoswine","Ya existía en la antigüedad. Se encontró uno bajo hielo de hace más de 10 000 años.",listOf(PokemonTipoFB.HIELO,PokemonTipoFB.TIERRA)),
    PokemonFB(474,"4",R.drawable.porygonz, "Porygon-Z","Se le instaló un software para mejorarlo. Sin embargo, comenzó a comportarse de manera extraña.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(475,"4",R.drawable.gallade, "Gallade","Cuando quiere proteger a alguien, extiende los codos como si fueran espadas y lucha con fiereza.",listOf(PokemonTipoFB.PSIQUICO,PokemonTipoFB.LUCHA)),
    PokemonFB(476,"4",R.drawable.probopass, "Probopass","Controla magnéticamente sus tres Mini-Narices y ataca a sus enemigos desde tres direcciones diferentes.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.ACERO)),
    PokemonFB(477,"4",R.drawable.dusknoir, "Dusknoir","Se dice que recoge en su cuerpo flexible a los espíritus extraviados y los guía hasta casa.",listOf(PokemonTipoFB.FANTASMA)),
    PokemonFB(478,"4",R.drawable.froslass, "Froslass","Congela a sus enemigos con un aliento gélido de 50 grados bajo cero. Está hueco por dentro.",listOf(PokemonTipoFB.HIELO,PokemonTipoFB.FANTASMA)),
    PokemonFB(479,"4",R.drawable.rotom, "Rotom","Desde hace mucho tiempo se estudia su singular motor como fuente de energía motriz.",listOf(PokemonTipoFB.ELECTRICO,PokemonTipoFB.FANTASMA)),
    PokemonFB(480,"4",R.drawable.uxie, "Uxie","Voló y las personas adquirieron la capacidad para resolver problemas. Así nació la sabiduría.",listOf(PokemonTipoFB.PSIQUICO)),
    PokemonFB(481,"4",R.drawable.mesprit, "Mesprit","Dicen que Mesprit lleva a los corazones de la gente los sentimientos de alegría y tristeza.",listOf(PokemonTipoFB.PSIQUICO)),
    PokemonFB(482,"4",R.drawable.azelf, "Azelf","Se le conoce como el Ser de la Voluntad. Duerme en el fondo de un lago para equilibrar el mundo.",listOf(PokemonTipoFB.PSIQUICO)),
    PokemonFB(483,"4",R.drawable.dialga, "Dialga","Tiene el poder de controlar el tiempo. Aparece en los mitos de Sinnoh como una vieja deidad.",listOf(PokemonTipoFB.ACERO,PokemonTipoFB.DRAGON)),
    PokemonFB(484,"4",R.drawable.palkia, "Palkia","Tiene la habilidad de distorsionar el espacio. La mitología de Sinnoh lo describe como una deidad.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.DRAGON)),
    PokemonFB(485,"4",R.drawable.heatran, "Heatran","Habita cuevas volcánicas. Cava con sus pies en forma de cruz para trepar por techos y paredes.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.ACERO)),
    PokemonFB(486,"4",R.drawable.regigigas, "Regigigas","Se dice que usó rocas, magma y un hielo especial de montaña para crear Pokémon con su aspecto.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(487,"4",R.drawable.giratina, "Giratina","Vive en el Mundo Distorsión, un mundo opuesto al nuestro y cuyas leyes desafían el sentido común.",listOf(PokemonTipoFB.FANTASMA,PokemonTipoFB.DRAGON)),
    PokemonFB(488,"4",R.drawable.cresselia, "Cresselia","Si alguien se duerme con una pluma suya, tendrá sueños maravillosos. Encarna el creciente lunar.",listOf(PokemonTipoFB.PSIQUICO)),
    PokemonFB(489,"4",R.drawable.phione, "Phione","Si sube la temperatura del mar, infla el flotador de su cabeza y flota en grupo en la superficie.",listOf(PokemonTipoFB.AGUA)),
    PokemonFB(490,"4",R.drawable.manaphy, "Manaphy","Nace con un maravilloso poder que le permite establecer vínculos con cualquier tipo de Pokémon.",listOf(PokemonTipoFB.AGUA)),
    PokemonFB(491,"4",R.drawable.darkrai, "Darkrai","Para protegerse causa pesadillas a los que le rodean. Pero no lo hace con intención de hacer daño.",listOf(PokemonTipoFB.SINIESTRO)),
    PokemonFB(492,"4",R.drawable.shaymin, "Shaymin","Vive entre las flores. Para evitar ser descubierto, se enrosca como si fuera una planta.",listOf(PokemonTipoFB.PLANTA)),
    PokemonFB(493,"4",R.drawable.arceus, "Arceus","Se dice que surgió de un huevo en un lugar en el que no había nada. Y luego dio forma al mundo.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(494,"5",R.drawable.victini, "Victini","Pokémon que atrae la victoria. Dicen que el Entrenador que lo lleve saldrá vencedor de cualquier batalla.",listOf(PokemonTipoFB.PSIQUICO,PokemonTipoFB.FUEGO)),
    PokemonFB(495,"5",R.drawable.snivy, "Snivy","Sintetiza la luz del sol que recoge con su cola. Esta se le queda abatida cuando le faltan las energías.",listOf(PokemonTipoFB.PLANTA)),
    PokemonFB(496,"5",R.drawable.servine, "Servine","Parece que se desliza al correr. Engaña a sus rivales con su velocidad y los fustiga con su látigo.",listOf(PokemonTipoFB.PLANTA)),
    PokemonFB(497,"5",R.drawable.serperior, "Serperior","Detiene los movimientos del rival con una sola mirada. Expande la energía solar dentro de su cuerpo.",listOf(PokemonTipoFB.PLANTA)),
    PokemonFB(498,"5",R.drawable.tepig, "Tepig","Le encanta comer bayas tostadas, pero a veces se emociona demasiado y termina churruscándolas.",listOf(PokemonTipoFB.FUEGO)),
    PokemonFB(499,"5",R.drawable.pignite, "Pignite","Cuando las llamas de su interior se avivan, aumenta su velocidad y agilidad. Emite humo si está en peligro.",listOf(PokemonTipoFB.FUEGO, PokemonTipoFB.LUCHA)),
    PokemonFB(500,"5",R.drawable.emboar, "Emboar","Calienta sus puños con las llamas de su barbilla para propinar puñetazos ardientes. Es muy fiel a sus compañeros.",listOf(PokemonTipoFB.FUEGO, PokemonTipoFB.LUCHA)),
    PokemonFB(501,"5",R.drawable.oshawott, "Oshawott","Ataca con la vieira de su ombligo. En cuanto para un ataque, pasa al contraataque sin dilación.",listOf(PokemonTipoFB.PSIQUICO)),
    PokemonFB(502,"5",R.drawable.dewott, "Dewott","Tras un exhaustivo entrenamiento, Dewott puede dominar diversas técnicas para usar con sus vieiras.",listOf(PokemonTipoFB.PSIQUICO)),
    PokemonFB(503,"5",R.drawable.samurott, "Samurott","En un abrir y cerrar de ojos, puede desenvainar y envainar los sables que hay en sus patas delanteras.",listOf(PokemonTipoFB.PSIQUICO)),
    PokemonFB(504,"5",R.drawable.patrat, "Patrat","Siempre está alerta y no quita la mirada de su madriguera. Cuando no está vigilando, le invade la inquietud.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(505,"5",R.drawable.watchog, "Watchog","Hace brillar las rayas de su cuerpo para intimidar al enemigo. Sus ojos lo ven todo, hasta en la oscuridad.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(506,"5",R.drawable.lillipup, "Lillipup","Aunque se trata de un Pokémon valeroso, también es lo bastante inteligente como para escapar si el rival es muy fuerte.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(507,"5",R.drawable.herdier, "Herdier","Un robusto pelaje cubre su cuerpo a modo de capa y disminuye el daño que recibe en los ataques.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(508,"5",R.drawable.stoutland, "Stoutland","Es especialista en socorrer a personas extraviadas en el mar o en las montañas. Es muy inteligente.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(509,"5",R.drawable.purrloin, "Purrloin","Su aspecto tierno es una farsa. Lo aprovechan para robar a los humanos y contemplar qué cara ponen.",listOf(PokemonTipoFB.SINIESTRO)),
    PokemonFB(510,"5",R.drawable.liepard, "Liepard","Su bella y grácil silueta le viene dada por su desarrollada musculatura, que le permite andar de noche sin hacer ruido.",listOf(PokemonTipoFB.SINIESTRO)),
    PokemonFB(511,"5",R.drawable.pansage, "Pansage","Es todo un experto en la búsqueda de bayas y es tan gentil que las comparte con todos sus compañeros.",listOf(PokemonTipoFB.PLANTA)),
    PokemonFB(512,"5",R.drawable.simisage, "Simisage","Agita su cola revestida de espinas para atacar a su enemigo. La hoja que crece sobre su cabeza es muy amarga.",listOf(PokemonTipoFB.PLANTA)),
    PokemonFB(513,"5",R.drawable.pansear, "Pansear","Pokémon muy inteligente que tiene la costumbre de tostar las bayas antes de comérselas. Ayuda mucho a los humanos.",listOf(PokemonTipoFB.FUEGO)),
    PokemonFB(514,"5",R.drawable.simisear, "Simisear","Cuando se emociona, echa chispas por la cola y por la cabeza, y calienta su cuerpo. Por alguna razón le encantan los dulces.",listOf(PokemonTipoFB.FUEGO)),
    PokemonFB(515,"5",R.drawable.panpour, "Panpour","El agua acumulada en su mata de pelo es rica en nutrientes. Usa la cola para regar plantas con esa misma agua.",listOf(PokemonTipoFB.AGUA)),
    PokemonFB(516,"5",R.drawable.simipour, "Simipour","Le encantan los lugares con agua limpia. Cuando desciende el nivel de agua de su pelo, se abastece a través de su cola.",listOf(PokemonTipoFB.AGUA)),
    PokemonFB(517,"5",R.drawable.munna, "Munna","Se alimenta de los sueños de humanos y Pokémon. Si los sueños son felices, despide humo rosa.",listOf(PokemonTipoFB.PSIQUICO)),
    PokemonFB(518,"5",R.drawable.musharna, "Musharna","Multitud de sueños de humanos y Pokémon se encuentran atrapados en el humo que despide por su frente.",listOf(PokemonTipoFB.PSIQUICO)),
    PokemonFB(519,"5",R.drawable.pidove, "Pidove","Es un Pokémon muy despistado. Aunque reciba órdenes de su Entrenador, se le olvidan, y se queda esperando.",listOf(PokemonTipoFB.NORMAL, PokemonTipoFB.VOLADOR)),
    PokemonFB(520,"5",R.drawable.tranquill, "Tranquill","Puede regresar sin problema alguno a su nido desde cualquier lugar del globo y jamás se separa de quien lo entrena.",listOf(PokemonTipoFB.NORMAL, PokemonTipoFB.VOLADOR)),
    PokemonFB(521,"5",R.drawable.unfezant, "Unfezant","El macho amenaza al enemigo meciendo el adorno de su cabeza. Al volar, la hembra es mucho más diestra que el macho.",listOf(PokemonTipoFB.NORMAL, PokemonTipoFB.VOLADOR)),
    PokemonFB(522,"5",R.drawable.blitzle, "Blitzle","Su crin brilla cuando emite una descarga eléctrica. Se comunica con los suyos mediante el ritmo y el número de brillos.",listOf(PokemonTipoFB.ELECTRICO)),
    PokemonFB(523,"5",R.drawable.zebstrika, "Zebstrika","Es un Pokémon con mucho temperamento. Cuando se enoja, lanza rayos desde su crin en todas direcciones.",listOf(PokemonTipoFB.ELECTRICO)),
    PokemonFB(524,"5",R.drawable.roggenrola, "Roggenrola","El agujero hexagonal es su oído, y tiene el hábito de caminar en la dirección de donde provienen los sonidos.",listOf(PokemonTipoFB.ROCA)),
    PokemonFB(525,"5",R.drawable.boldore, "Boldore","La energía que no puede contener en el interior de su cuerpo se escapa formando cristales naranjas.",listOf(PokemonTipoFB.ROCA)),
    PokemonFB(526,"5",R.drawable.gigalith, "Gigalith","Absorbe los rayos solares, procesa esa energía en su núcleo y lanza poderosas bolas de luz a sus enemigos.",listOf(PokemonTipoFB.ROCA)),
    PokemonFB(527,"5",R.drawable.woobat, "Woobat","Este peculiar Pokémon pega sus fosas nasales a la pared para dormir y, cuando las retira, deja un corazón marcado.",listOf(PokemonTipoFB.PSIQUICO, PokemonTipoFB.VOLADOR)),
    PokemonFB(528,"5",R.drawable.swoobat, "Swoobat","Cuando emite ondas ultrasónicas, que incluso pueden reventar el cemento, agita su cola con vehemencia.",listOf(PokemonTipoFB.PSIQUICO, PokemonTipoFB.VOLADOR)),
    PokemonFB(529,"5",R.drawable.drilbur, "Drilbur","Puede girar su cuerpo a una velocidad de 50 km/h y, si la mantiene, puede perforar el suelo y atravesarlo.",listOf(PokemonTipoFB.TIERRA)),
    PokemonFB(530,"5",R.drawable.excadrill, "Excadrill","Coloca sus garras y su cabeza de manera que se convierten en un taladro. Puede incluso taladrar una plancha de acero.",listOf(PokemonTipoFB.TIERRA, PokemonTipoFB.ACERO)),
    PokemonFB(531,"5",R.drawable.audino, "Audino","Su sentido del oído es infalible: capta cualquier ruido de su alrededor y hace las veces de radar.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(532,"5",R.drawable.timburr, "Timburr","Siempre lleva una viga de madera y ayuda en las construcciones. Se busca una viga más grande cuando se hace más fuerte.",listOf(PokemonTipoFB.LUCHA)),
    PokemonFB(533,"5",R.drawable.gurdurr, "Gurdurr","Gracias a su entrenada musculatura, puede blandir vigas de acero sin problema para así derribar edificios enteros.",listOf(PokemonTipoFB.LUCHA)),
    PokemonFB(534,"5",R.drawable.conkeldurr, "Conkeldurr","Se cree que Conkeldurr enseñó a los humanos la técnica para elaborar cemento hace más de 2000 años.",listOf(PokemonTipoFB.LUCHA)),
    PokemonFB(535,"5",R.drawable.tympole, "Tympole","Emite sonidos imperceptibles para los humanos con la vibración de sus mejillas y se comunica al ritmo de los mismos.",listOf(PokemonTipoFB.AGUA)),
    PokemonFB(536,"5",R.drawable.palpitoad, "Palpitoad","Vive tanto en tierra como en el fondo del mar. Con su larga y viscosa lengua, inmoviliza a sus contrincantes.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.TIERRA)),
    PokemonFB(537,"5",R.drawable.seismitoad, "Seismitoad","Despide un líquido paralizador por los bultos de su cabeza. Atormenta a sus oponentes con enormes vibraciones.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.TIERRA)),
    PokemonFB(538,"5",R.drawable.throh, "Throh","Si se topa con un rival más fuerte, ansía lanzarlo por los aires. Al hacerse más fuerte, cambia su cinturón.",listOf(PokemonTipoFB.LUCHA)),
    PokemonFB(539,"5",R.drawable.sawk, "Sawk","Para lograr dominar las técnicas de kárate más letales, se retiran a las montañas y entrenan día y noche.",listOf(PokemonTipoFB.LUCHA)),
    PokemonFB(540,"5",R.drawable.sewaddle, "Sewaddle","Recorta hojas y las teje con el líquido viscoso que segrega por la boca para hacerse su propia ropa.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.PLANTA)),
    PokemonFB(541,"5",R.drawable.swadloon, "Swadloon","Le gustan los lugares lóbregos y húmedos. Se pasa todo el día comiendo las hojas esparcidas por el suelo.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.PLANTA)),
    PokemonFB(542,"5",R.drawable.leavanny, "Leavanny","Si se encuentra con un Pokémon joven, segrega por la boca hilos pegadizos con los que le teje una prenda de ropa.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.PLANTA)),
    PokemonFB(543,"5",R.drawable.venipede, "Venipede","Percibe su entorno con su sentido del tacto, residente en su cabeza y cola. Su carácter es violento por naturaleza.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.VENENO)),
    PokemonFB(544,"5",R.drawable.whirlipede, "Whirlipede","Lo protege un duro caparazón. Gira como una rueda y realiza brutales placajes contra sus enemigos.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.VENENO)),
    PokemonFB(545,"5",R.drawable.scolipede, "Scolipede","Atenaza a sus presas con las garras que sobresalen de su cuello hasta que no se pueden mover y las remata con veneno.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.VENENO)),
    PokemonFB(546,"5",R.drawable.cottonee, "Cottonee","Despide motas de algodón cuando lo atacan para confundir a los enemigos y poner pies en polvorosa.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.HADA)),
    PokemonFB(547,"5",R.drawable.whimsicott, "Whimsicott","Aparece con remolinos de viento. Entra en las casas por las rendijas y les encanta hacer travesuras.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.HADA)),
    PokemonFB(548,"5",R.drawable.petilil, "Petilil","Mordisquear las hojas de su cabeza permite recuperar toda la vitalidad, a pesar de que están muy amargas.",listOf(PokemonTipoFB.PLANTA)),
    PokemonFB(549,"5",R.drawable.lilligant, "Lilligant","Todos los famosos quieren uno. Incluso a los Entrenadores más curtidos les cuesta que florezca.",listOf(PokemonTipoFB.PLANTA)),
    PokemonFB(550,"5",R.drawable.basculin, "Basculin","Los de color azul y los de color rojo siempre se pelean. Son muy violentos, pero su sabor es excepcional.",listOf(PokemonTipoFB.AGUA)),
    PokemonFB(551,"5",R.drawable.sandile, "Sandile","Viven en los desiertos y se sumergen en las cálidas arenas para que su temperatura corporal no se reduzca.",listOf(PokemonTipoFB.TIERRA,PokemonTipoFB.SINIESTRO)),
    PokemonFB(552,"5",R.drawable.krokorok, "Krokorok","Gracias a la película que recubre sus ojos, pueden ver incluso de noche. Viven en pequeñas manadas.",listOf(PokemonTipoFB.TIERRA,PokemonTipoFB.SINIESTRO)),
    PokemonFB(553,"5",R.drawable.krookodile, "Krookodile","Un Pokémon bastante violento. Ataca todo lo que se mueva delante de él con sus mortíferas mandíbulas.",listOf(PokemonTipoFB.TIERRA,PokemonTipoFB.SINIESTRO)),
    PokemonFB(554,"5",R.drawable.darumaka, "Darumaka","Como sus excrementos están muy calientes, la gente de antaño se los metía en los bolsillos para calentarse.",listOf(PokemonTipoFB.FUEGO)),
    PokemonFB(555,"5",R.drawable.darmanitan, "Darmanitan","Cuando resulta gravemente herido, se endurece como una piedra y medita para agudizar la mente.",listOf(PokemonTipoFB.FUEGO)),
    PokemonFB(556,"5",R.drawable.maractus, "Maractus","Vive en territorio árido. Emite un sonido parecido a unas maracas si se mueve de forma rítmica.",listOf(PokemonTipoFB.PLANTA)),
    PokemonFB(557,"5",R.drawable.dwebble, "Dwebble","Si encuentran una piedra de tamaño ideal, segregan un líquido por la boca para crear un agujero y deslizarse dentro.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.ROCA)),
    PokemonFB(558,"5",R.drawable.crustle, "Crustle","Su inmensa capacidad motriz le permite desplazarse cargando a sus espaldas rocas enormes durante días.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.ROCA)),
    PokemonFB(559,"5",R.drawable.scraggy, "Scraggy","Propina un cabezazo inmediato a todo aquel que lo mira a los ojos. Su cráneo es muy duro.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.LUCHA)),
    PokemonFB(560,"5",R.drawable.scrafty, "Scrafty","Ataca en grupo con violencia a todo aquel que se interne en su territorio. Lanza ácido por la boca.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.LUCHA)),
    PokemonFB(561,"5",R.drawable.sigilyph, "Sigilyph","Deidad protectora de una antigua ciudad. Siempre merodea por la misma ruta y permanece alerta en busca de intrusos..",listOf(PokemonTipoFB.PSIQUICO,PokemonTipoFB.VOLADOR)),
    PokemonFB(562,"5",R.drawable.yamask, "Yamask","Almas de humanos sepultados en tumbas que han adquirido forma de Pokémon. Recuerdan su vida antes de la muerte.",listOf(PokemonTipoFB.FANTASMA)),
    PokemonFB(563,"5",R.drawable.cofagrigus, "Cofagrigus","Atrapan en su interior a los ladrones de tumbas que los confunden con ataúdes de verdad.",listOf(PokemonTipoFB.FANTASMA,PokemonTipoFB.TIERRA)),
    PokemonFB(564,"5",R.drawable.tirtouga, "Tirtouga","Pokémon renacido a partir de un fósil. Es muy hábil nadando y puede sumergirse a una profundidad de 1000 m.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.ROCA)),
    PokemonFB(565,"5",R.drawable.carracosta, "Carracosta","Un golpe con sus desarrolladas aletas delanteras puede hacer perder a un rival el conocimiento o romperle los huesos.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.ROCA)),
    PokemonFB(566,"5",R.drawable.archen, "Archen","Dicen que es el Pokémon pájaro primigenio. No puede volar, así que solo salta de rama en rama.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.VOLADOR)),
    PokemonFB(567,"5",R.drawable.archeops, "Archeops","Se le da mejor correr que volar. Atrapa a sus presas corriendo más rápido que un coche.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.VOLADOR)),
    PokemonFB(568,"5",R.drawable.trubbish, "Trubbish","Pokémon nacido de la reacción química entre una bolsa de basura y residuos industriales.",listOf(PokemonTipoFB.VENENO)),
    PokemonFB(569,"5",R.drawable.garbodor, "Garbodor","Apresa a su rival con el brazo izquierdo y le da el golpe de gracia exhalando por la boca un apestoso gas venenoso.",listOf(PokemonTipoFB.VENENO)),
    PokemonFB(570,"5",R.drawable.zorua, "Zorua","Se transforma en humanos o en otros Pokémon. Se defiende del peligro ocultando su verdadera apariencia.",listOf(PokemonTipoFB.SINIESTRO)),
    PokemonFB(571,"5",R.drawable.zoroark, "Zoroark","Tiene la facultad de confundir a muchos humanos a la vez. Protege su guarida creando un paisaje ilusorio.",listOf(PokemonTipoFB.SINIESTRO)),
    PokemonFB(572,"5",R.drawable.minccino, "Minccino","Le encanta la limpieza. Usa su cola a modo de escoba y se pasa el día barre que barre.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(573,"5",R.drawable.cinccino, "Cinccino","Su pelaje blanco está recubierto por una grasa especial que hace resbalar los ataques enemigos.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(574,"5",R.drawable.gothita, "Gothita","Clava su mirada en Pokémon y Entrenadores como si observara algo solo perceptible por él.",listOf(PokemonTipoFB.PSIQUICO)),
    PokemonFB(575,"5",R.drawable.gothorita, "Gothorita","La luz de las estrellas origina su poder. De noche, marca su posición haciendo levitar piedras con su poder psíquico.",listOf(PokemonTipoFB.PSIQUICO)),
    PokemonFB(576,"5",R.drawable.gothitelle, "Gothitelle","Predice el futuro analizando la posición de los astros y su movimiento. Conoce la esperanza de vida de los Entrenadores.",listOf(PokemonTipoFB.PSIQUICO)),
    PokemonFB(577,"5",R.drawable.solosis, "Solosis","Puede vivir en cualquier ambiente gracias al líquido especial que recubre su cuerpo.",listOf(PokemonTipoFB.PSIQUICO)),
    PokemonFB(578,"5",R.drawable.duosion, "Duosion","Cuando las dos partes de su cerebro piensan lo mismo, saca todo su poder a relucir.",listOf(PokemonTipoFB.PSIQUICO)),
    PokemonFB(579,"5",R.drawable.reuniclus, "Reuniclus","La fortaleza de sus brazos le permite hacer añicos hasta rocas. Está dotado de una inteligencia superior.",listOf(PokemonTipoFB.PSIQUICO)),
    PokemonFB(580,"5",R.drawable.ducklett, "Ducklett","Cuando se ve atacado, las plumas que lo recubren despiden ráfagas de agua que lo ayudan a escapar.",listOf(PokemonTipoFB.AGUA, PokemonTipoFB.VOLADOR)),
    PokemonFB(581,"5",R.drawable.swanna, "Swanna","La potencia de su pico es brutal. Arquea su largo cuello y picotea repetidamente al enemigo.",listOf(PokemonTipoFB.AGUA, PokemonTipoFB.VOLADOR)),
    PokemonFB(582,"5",R.drawable.vanillite, "Vanillite","Nació de un carámbano que absorbió la energía del sol al alba. Duerme arropado por la nieve.",listOf(PokemonTipoFB.HIELO)),
    PokemonFB(583,"5",R.drawable.vanillish, "Vanillish","Enfrían el aire a su alrededor y crean partículas de hielo mediante las cuales congelan a sus oponentes.",listOf(PokemonTipoFB.HIELO)),
    PokemonFB(584,"5",R.drawable.vanilluxe, "Vanilluxe","Absorben grandes cantidades de agua y la transforman en ventisca en su cuerpo, expulsándola cuando se enojan.",listOf(PokemonTipoFB.HIELO)),
    PokemonFB(585,"5",R.drawable.deerling, "Deerling","El color de su cuerpo cambia no solo con las estaciones, sino también con los cambios de humedad y temperatura.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.PLANTA)),
    PokemonFB(586,"5",R.drawable.sawsbuck, "Sawsbuck","Migra con el cambio de estación, por lo que hay quien considera a Sawsbuck el heraldo de la primavera.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.PLANTA)),
    PokemonFB(587,"5",R.drawable.emolga, "Emolga","Puede volar al extender sus membranas y electrocutar a sus enemigos mediante la electricidad acumulada en sus mejillas.",listOf(PokemonTipoFB.ELECTRICO,PokemonTipoFB.VOLADOR)),
    PokemonFB(588,"5",R.drawable.karrablast, "Karrablast","Si recibe una descarga eléctrica durante un combate contra un Shelmet, puede evolucionar. Se desconoce el porqué.",listOf(PokemonTipoFB.BICHO)),
    PokemonFB(589,"5",R.drawable.escavalier, "Escavalier","Pokémon que evolucionó poniéndose el caparazón de Shelmet. Su armazón de acero le protege todo el cuerpo.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.ACERO)),
    PokemonFB(590,"5",R.drawable.foongus, "Foongus","Por razones desconocidas, se parece a una Poké Ball. Lanza esporas de veneno para repeler al enemigo.",listOf(PokemonTipoFB.PLANTA, PokemonTipoFB.VENENO)),
    PokemonFB(591,"5",R.drawable.amoonguss, "Amoonguss","Aunque intenta pasar por parte superior de una Poké Ball para atraer a sus presas, consigue engañar a pocos.",listOf(PokemonTipoFB.PLANTA, PokemonTipoFB.VENENO)),
    PokemonFB(592,"5",R.drawable.frillish, "Frillish","Rodea a sus presas con sus tentáculos, las entumece y las arrastra a 8000 m de profundidad hasta que las ahoga.",listOf(PokemonTipoFB.AGUA, PokemonTipoFB.FANTASMA)),
    PokemonFB(593,"5",R.drawable.jellicent, "Jellicent","Su cuerpo se compone de agua salada. Dicen que ha construido un palacio en el fondo del mar con restos de barcos.",listOf(PokemonTipoFB.AGUA, PokemonTipoFB.FANTASMA)),
    PokemonFB(594,"5",R.drawable.alomomola, "Alomomola","La membrana viscosa que recubre el cuerpo de Alomomola tiene facultades curativas.",listOf(PokemonTipoFB.AGUA)),
    PokemonFB(595,"5",R.drawable.joltik, "Joltik","Se agarra a Pokémon de gran tamaño, absorbe su electricidad estática y la guarda en una bolsa interna.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.ELECTRICO)),
    PokemonFB(596,"5",R.drawable.galvantula, "Galvantula","Pone trampas con hilos electrificados. De este modo, electrocuta a sus enemigos y los inmoviliza por completo.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.ELECTRICO)),
    PokemonFB(597,"5",R.drawable.ferroseed, "Ferroseed","Lanza numerosas púas al detectar peligro. En cuanto tiene ocasión, echa a rodar y se escapa.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.ACERO)),
    PokemonFB(598,"5",R.drawable.ferrothorn, "Ferrothorn","Se pega al techo de cuevas y lanza púas de metal a todo el que pase por debajo de donde se encuentre.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.ACERO)),
    PokemonFB(599,"5",R.drawable.klink, "Klink","La combinación fija de dos cuerpos le permite generar energía cuando se ponen a girar.",listOf(PokemonTipoFB.ACERO)),
    PokemonFB(600,"5",R.drawable.klang, "Klang","Muestra sus sentimientos cambiando la dirección de su giro. Cuanto más se enfade, más rápido girará.",listOf(PokemonTipoFB.ACERO)),
    PokemonFB(601,"5",R.drawable.klinklang, "Klinklang","Recarga su energía rápidamente haciendo girar con gran velocidad el engranaje con un núcleo rojo.",listOf(PokemonTipoFB.ACERO)),
    PokemonFB(602,"5",R.drawable.tynamo, "Tynamo","Actúa siempre en su cardumen. Cuenta con un mecanismo que genera electricidad y la libera cuando está en peligro.",listOf(PokemonTipoFB.ELECTRICO)),
    PokemonFB(603,"5",R.drawable.eelektrik, "Eelektrik","Pokémon de apetito voraz. En cuanto encuentra una presa, la paraliza con electricidad y la engulle.",listOf(PokemonTipoFB.ELECTRICO)),
    PokemonFB(604,"5",R.drawable.eelektross, "Eelektross","Sale del mar con la fuerza de sus brazos y ataca a sus presas en la costa. Luego se las lleva de vuelta al mar.",listOf(PokemonTipoFB.ELECTRICO)),
    PokemonFB(605,"5",R.drawable.elgyem, "Elgyem","Según cuentan los rumores, procede de un desierto donde hace 50 años se estrelló un ovni.",listOf(PokemonTipoFB.PSIQUICO)),
    PokemonFB(606,"5",R.drawable.beheeyem, "Beheeyem","Parece que se comunica haciendo brillar sus dedos tricolores, pero nadie ha conseguido descifrar aún su patrón.",listOf(PokemonTipoFB.PSIQUICO)),
    PokemonFB(607,"5",R.drawable.litwick, "Litwick","Finge ser una luz guía en el camino, pero en realidad solo quiere absorber la energía vital de quien lo sigue.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.FANTASMA)),
    PokemonFB(608,"5",R.drawable.lampent, "Lampent","Aparece hacia el final de la vida y absorbe el alma en cuanto esta se separa del cuerpo.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.FANTASMA)),
    PokemonFB(609,"5",R.drawable.chandelure, "Chandelure","Las almas que han ardido bajo sus oscuras llamas vagan sin rumbo y eternamente por este mundo.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.FANTASMA)),
    PokemonFB(610,"5",R.drawable.axew, "Axew","Deja la huella de sus colmillos en los árboles para marcar su territorio. Si se le rompen, se regeneran muy rápido.",listOf(PokemonTipoFB.DRAGON)),
    PokemonFB(611,"5",R.drawable.fraxure, "Fraxure","Sus colmillos no vuelven a crecer, por lo que, al término de cada combate, los afila cuidadosamente con cantos de río.",listOf(PokemonTipoFB.DRAGON)),
    PokemonFB(612,"5",R.drawable.haxorus, "Haxorus","Sus colmillos poseen una increíble fuerza destructiva, capaz de desgarrar incluso una dura y espesa columna de acero.",listOf(PokemonTipoFB.DRAGON)),
    PokemonFB(613,"5",R.drawable.cubchoo, "Cubchoo","Siempre está con mucosidades colgando. Las aspira para hacer un movimiento, ya que son su materia prima para esto.",listOf(PokemonTipoFB.HIELO)),
    PokemonFB(614,"5",R.drawable.beartic, "Beartic","Adoran los mares gélidos del norte. Congelan su aliento para crear sendas por las que caminar sobre el agua.",listOf(PokemonTipoFB.HIELO)),
    PokemonFB(615,"5",R.drawable.cryogonal, "Cryogonal","Aparece hacia el final de la vida y absorbe el alma en cuanto esta se separa del cuerpo.",listOf(PokemonTipoFB.HIELO)),
    PokemonFB(616,"5",R.drawable.shelmet, "Shelmet","Las almas que han ardido bajo sus oscuras llamas vagan sin rumbo y eternamente por este mundo.",listOf(PokemonTipoFB.BICHO)),
    PokemonFB(617,"5",R.drawable.accelgor, "Accelgor","Deja la huella de sus colmillos en los árboles para marcar su territorio. Si se le rompen, se regeneran muy rápido.",listOf(PokemonTipoFB.BICHO)),
    PokemonFB(618,"5",R.drawable.stunfisk, "Stunfisk","Sus colmillos no vuelven a crecer, por lo que, al término de cada combate, los afila cuidadosamente con cantos de río.",listOf(PokemonTipoFB.TIERRA,PokemonTipoFB.ELECTRICO)),
    PokemonFB(619,"5",R.drawable.mienfoo, "Mienfoo","Usa gráciles movimientos sucesivos. Si se concentra, aumenta su eficacia y rapidez.",listOf(PokemonTipoFB.LUCHA)),
    PokemonFB(620,"5",R.drawable.mienshao, "Mienshao","Usa el pelaje de sus brazos a modo de látigos para encadenar ataques que nadie puede parar una vez iniciados.",listOf(PokemonTipoFB.LUCHA)),
    PokemonFB(621,"5",R.drawable.druddigon, "Druddigon","Corre por estrechas cavernas y atrapa a sus presas con sus afiladas garras. La piel de su cara es más dura que una roca.",listOf(PokemonTipoFB.DRAGON)),
    PokemonFB(622,"5",R.drawable.golett, "Golett","Los rumores apuntan a que fue un Pokémon creado por la ciencia de una antigua y misteriosa civilización.",listOf(PokemonTipoFB.TIERRA,PokemonTipoFB.FANTASMA)),
    PokemonFB(623,"5",R.drawable.golurk, "Golurk","Al parecer, aquel que antaño lo creó le ordenó proteger a los Pokémon y a los humanos.",listOf(PokemonTipoFB.TIERRA,PokemonTipoFB.FANTASMA)),
    PokemonFB(624,"5",R.drawable.pawniard, "Pawniard","Lucha bajo las órdenes de Bisharp. Se agarra a sus oponentes y les inflige daño utilizando sus cuchillas.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.ACERO)),
    PokemonFB(625,"5",R.drawable.bisharp, "Bisharp","Su séquito son los Pawniard. Acorralan a su presa con todo el grupo y Bisharp propina el golpe de gracia.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.ACERO)),
    PokemonFB(626,"5",R.drawable.bouffalant, "Bouffalant","Embiste con la cabeza sin distinción. Su potencia es capaz de hacer descarrilar un tren en marcha.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(627,"5",R.drawable.rufflet, "Rufflet","Desafía indiscriminadamente a rivales poderosos. Librar numerosas batallas lo hace fuerte.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.VOLADOR)),
    PokemonFB(628,"5",R.drawable.braviary, "Braviary","Guerrero avezado. Su número de cicatrices es directamente proporcional al respeto que recibe de los suyos.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.VOLADOR)),
    PokemonFB(629,"5",R.drawable.vullaby, "Vullaby","Usa una calavera para proteger sus posaderas. Es proclive a perseguir Pokémon débiles.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.VOLADOR)),
    PokemonFB(630,"5",R.drawable.mandibuzz, "Mandibuzz","Vuela en círculos. Cuando avista una presa, la ataca y la transporta a su nido con suma facilidad.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.VOLADOR)),
    PokemonFB(631,"5",R.drawable.heatmor, "Heatmor","Usa su lengua de fuego para derretir la armadura de los Durant y llegar así hasta su interior.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.VOLADOR)),
    PokemonFB(632,"5",R.drawable.durant, "Durant","Abre agujeros en las montañas. Los intrincados túneles son obras laberínticas de los Durant.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.ACERO)),
    PokemonFB(633,"5",R.drawable.deino, "Deino","Mordisquea todo aquello a su paso y se come todo aquello que sea comestible. Es peligroso acercarse a él sin cuidado.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.DRAGON)),
    PokemonFB(634,"5",R.drawable.zweilous, "Zweilous","Sus dos cabezas se llevan mal y se disputan la comida con brutalidad. Por eso acaban comiendo más de la cuenta.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.DRAGON)),
    PokemonFB(635,"5",R.drawable.hydreigon, "Hydreigon","Las cabezas de sus dos brazos no tienen cerebro. Con sus tres cabezas destruye y devora todo a su paso.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.DRAGON)),
    PokemonFB(636,"5",R.drawable.larvesta, "Larvesta","Vive en las laderas de los volcanes. Emite fuego por sus cinco cuernos para ahuyentar a sus enemigos.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.FUEGO)),
    PokemonFB(637,"5",R.drawable.volcarona, "Volcarona","Cuando combate, despide escamas ardientes de sus seis alas y genera un mar ígneo a su alrededor.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.FUEGO)),
    PokemonFB(638,"5",R.drawable.cobalion, "Cobalion","Posee un cuerpo y un corazón de acero. Basta una mirada suya para que Pokémon violentos le obedezcan.",listOf(PokemonTipoFB.ACERO,PokemonTipoFB.LUCHA)),
    PokemonFB(639,"5",R.drawable.terrakion, "Terrakion","Su potencia al embestir es capaz de derribar las murallas de un castillo. Las leyendas hablan de sus proezas.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.LUCHA)),
    PokemonFB(640,"5",R.drawable.virizion, "Virizion","Sus cuernos son hojas afiladas. Sacude a sus enemigos con sus relampagueantes movimientos y los reduce.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.LUCHA)),
    PokemonFB(641,"5",R.drawable.tornadus, "Tornadus","La energía que desprende de su cola genera violentas tempestades capaces de echar abajo casas.",listOf(PokemonTipoFB.VOLADOR)),
    PokemonFB(642,"5",R.drawable.thundurus, "Thundurus","Lanza descargas eléctricas por las púas de su cola. Sobrevuela Teselia dejando caer rayos.",listOf(PokemonTipoFB.ELECTRICO,PokemonTipoFB.VOLADOR)),
    PokemonFB(643,"5",R.drawable.reshiram, "Reshiram","Cuando la cola de Reshiram arde, su energía calorífica altera la atmósfera, y el tiempo meteorológico cambia.",listOf(PokemonTipoFB.DRAGON,PokemonTipoFB.FUEGO)),
    PokemonFB(644,"5",R.drawable.zekrom, "Zekrom","Pokémon que aparece en los mitos de antaño. Su cola está provista de un enorme generador de electricidad.",listOf(PokemonTipoFB.DRAGON,PokemonTipoFB.ELECTRICO)),
    PokemonFB(645,"5",R.drawable.landorus, "Landorus","Utiliza energía que obtiene del viento y del relámpago para nutrir el suelo y generar abundantes cosechas.",listOf(PokemonTipoFB.TIERRA,PokemonTipoFB.VOLADOR)),
    PokemonFB(646,"5",R.drawable.kyurem, "Kyurem","Pokémon legendario que aguarda al héroe que compense el vacío de su cuerpo de hielo con verdad e ideales.",listOf(PokemonTipoFB.DRAGON,PokemonTipoFB.HIELO)),
    PokemonFB(647,"5",R.drawable.keldeo, "Keldeo","Desprende agua por sus pezuñas para poder deslizarse. Es especialista en atacar usando sus patas.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.LUCHA)),
    PokemonFB(648,"5",R.drawable.meloetta, "Meloetta","Se han creado innumerables canciones inspiradas en las melodías que emite Meloetta.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.PSIQUICO)),
    PokemonFB(649,"5",R.drawable.genesect, "Benesect","Pokémon de tipo bicho de la antigüedad, modificado por el Equipo Plasma. El cañón de su lomo ha sido mejorado.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.ACERO)),
    PokemonFB(650,"6",R.drawable.chespin, "Chespin","Cuando acumula energía, las suaves púas de su cabeza se vuelven tan duras y afiladas que hasta pueden atravesar rocas.",listOf(PokemonTipoFB.PLANTA)),
    PokemonFB(651,"6",R.drawable.quilladin, "Quilladin","Chocan contra sus congéneres para fortalecer sus piernas. Debido a su carácter afable, nunca son los que provocan un combate.",listOf(PokemonTipoFB.PLANTA)),
    PokemonFB(652,"6",R.drawable.chesnaught, "Chesnaught","Su fuerza es tal que, de un empellón, puede hacer volcar un tanque de 50 toneladas. Protege a sus aliados cuando hace de escudo.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.LUCHA)),
    PokemonFB(653,"6",R.drawable.fennekin, "Fennekin","Tras masticar e ingerir pequeñas ramas se siente pletórico y expulsa aire caliente por sus grandes orejas a temperaturas superiores a los 200 °C.",listOf(PokemonTipoFB.FUEGO)),
    PokemonFB(654,"6",R.drawable.braixen, "Braixen","Al extraer la rama que tiene en la cola, esta prende debido a la fricción. Usa esa rama candente para enviar señales a sus compañeros.",listOf(PokemonTipoFB.FUEGO)),
    PokemonFB(655,"6",R.drawable.delphox, "Delphox","Fija la mirada en la llama que arde en la punta de su bastón para concentrarse y prever sucesos que tienen lugar en el futuro.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.LUCHA)),
    PokemonFB(656,"6",R.drawable.froakie, "Froakie","Protege su piel cubriendo el cuerpo con una fina capa de burbujas. Aunque parezca despreocupado, no deja de vigilar con astucia lo que le rodea.",listOf(PokemonTipoFB.AGUA)),
    PokemonFB(657,"6",R.drawable.frogadier, "Frogadier","Su agilidad no tiene parangón. De hecho, es capaz de escalar una torre de más de 600 metros en tan solo un minuto.",listOf(PokemonTipoFB.AGUA)),
    PokemonFB(658,"6",R.drawable.greninja, "Greninja","Aparece y desaparece de improvisto, cual ninja. Marea al oponente con su soberbia agilidad y lo hace trizas con sus Shuriken de Agua.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.SINIESTRO)),
    PokemonFB(659,"6",R.drawable.bunnelby, "Bunnelby","Tiene unas orejas tan grandes que parecen palas. Las ha fortalecido tanto usándolas para excavar que son capaces de arrancar raíces bien gruesas.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(660,"6",R.drawable.diggersby, "Diggersby","Sus grandes orejas tienen tal fuerza que con ellas puede levantar con facilidad rocas de más de una tonelada. Es de una ayuda inestimable en las obras.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.TIERRA)),
    PokemonFB(661,"6",R.drawable.fletchling, "Fletchling","Su melodioso gorjeo lo dota de una gran belleza, pero adopta una actitud agresiva y despiadada hacia cualquiera que ose invadir su territorio.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.VOLADOR)),
    PokemonFB(662,"6",R.drawable.fletchinder, "Fletchinder","Cuanto más intenso sea el calor que se genera en la saca de fuego de su vientre, más rápido es capaz de volar. Sin embargo, la llama tarda en prender.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.VOLADOR)),
    PokemonFB(663,"6",R.drawable.talonflame, "Talonflame","Llega a alcanzar los 500 km/h al perseguir a su presa, a quien le asesta el golpe de gracia con una patada muy potente.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.VOLADOR)),
    PokemonFB(664,"6",R.drawable.scatterbug, "Scatterbug","Cuando recibe el ataque de un Pokémon pájaro, expulsa unas escamas negras que provocan parálisis si se entra en contacto con ellas.",listOf(PokemonTipoFB.BICHO)),
    PokemonFB(665,"6",R.drawable.spewpa, "Spewpa","Habita en la sombra de la espesura. Si percibe alguna amenaza, su pelaje se eriza y se vuelve muy afilado para así intimidar al enemigo.",listOf(PokemonTipoFB.BICHO)),
    PokemonFB(666,"6",R.drawable.vivillon, "Vivillon","En el mundo existen Vivillon con diferentes motivos en sus alas. El clima de cada región influye en sus rasgos.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.VOLADOR)),
    PokemonFB(667,"6",R.drawable.litleo, "Litleo","Cuanto más poderoso es el enemigo al que se enfrenta, más calor desprende su mechón y más energía recorre todo su cuerpo.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.NORMAL)),
    PokemonFB(668,"6",R.drawable.pyroar, "Pyroar","El macho con la melena de fuego más grande de toda la manada es el líder de sus compañeros.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.NORMAL)),
    PokemonFB(669,"6",R.drawable.flabebe, "Flabebe","Puede controlar el poder oculto de las flores. La flor que lleva consigo es como si formara parte de su cuerpo.",listOf(PokemonTipoFB.HADA)),
    PokemonFB(670,"6",R.drawable.floette, "Floette","Revolotea alrededor de campos de flores y cuida de aquellas que empiezan a marchitarse. Usa en combate el poder oculto de las flores.",listOf(PokemonTipoFB.HADA)),
    PokemonFB(671,"6",R.drawable.florges, "Florges","Habita en preciosos jardines floridos. Absorbe la energía que emiten las plantas y la convierte en su fuente de poder.",listOf(PokemonTipoFB.HADA)),
    PokemonFB(672,"6",R.drawable.skiddo, "Skiddo","Se dice que fue la primera especie de Pokémon que se acostumbró a vivir con los seres humanos. Tiene una naturaleza muy afable.",listOf(PokemonTipoFB.PLANTA)),
    PokemonFB(673,"6",R.drawable.gogoat, "Gogoat","Percibe los sentimientos del Entrenador por la forma en la que agarra sus cuernos, aunque sean variaciones sutiles, y así avanzan como si fueran un solo ente.",listOf(PokemonTipoFB.PLANTA)),
    PokemonFB(674,"6",R.drawable.pancham, "Pancham","Se desvive tratando de fulminar a su rival con una mirada aterradora, pero en cuanto le acarician la cabeza, no puede evitar sonreír de oreja a oreja.",listOf(PokemonTipoFB.LUCHA)),
    PokemonFB(675,"6",R.drawable.pangoro, "Pangoro","Es muy temperamental, pero no permite que nadie se meta con los débiles. Mediante su hoja, predice los movimientos del enemigo.",listOf(PokemonTipoFB.LUCHA,PokemonTipoFB.SINIESTRO)),
    PokemonFB(676,"6",R.drawable.furfrou, "Flabebe","Cuando le esquilan su mullido pelaje, no solo mejora su apariencia, sino que aumenta su agilidad.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(677,"6",R.drawable.espurr, "Espurr","Protege con las orejas el órgano con el que irradia su intenso poder psíquico para evitar que este escape al exterior.",listOf(PokemonTipoFB.PSIQUICO)),
    PokemonFB(678,"6",R.drawable.meowstic, "Meowstic","Cuando percibe peligro, yergue sus orejas y desata un poder psíquico capaz de levantar un camión de unas 10 toneladas.",listOf(PokemonTipoFB.PSIQUICO)),
    PokemonFB(679,"6",R.drawable.honedge, "Honedge","Si alguien osa empuñarlo, se enrolla en el brazo del desafortunado con su paño azul y le absorbe toda la energía hasta que pierde el sentido.",listOf(PokemonTipoFB.ACERO,PokemonTipoFB.FANTASMA)),
    PokemonFB(680,"6",R.drawable.doublade, "Doublade","Ni siquiera el espadachín más ducho conseguiría esquivar los complejos ataques que encadenan ambas espadas a la vez.",listOf(PokemonTipoFB.ACERO,PokemonTipoFB.FANTASMA)),
    PokemonFB(681,"6",R.drawable.aegislash, "Aegislash","Han permanecido junto a estirpes de reyes durante generaciones. Mediante su poder espectral pueden controlar a humanos y a Pokémon.",listOf(PokemonTipoFB.ACERO,PokemonTipoFB.FANTASMA)),
    PokemonFB(682,"6",R.drawable.spritzee, "Spritzee","Su cuerpo emana una fragancia que embelesa a quien la huele. La fragancia es diferente según los alimentos que ingiere.",listOf(PokemonTipoFB.HADA)),
    PokemonFB(683,"6",R.drawable.aromatisse, "Aromatisse","Puede producir multitud de olores diferentes y, en combate, secreta los que le resultan molestos al enemigo para así contar con cierta ventaja.",listOf(PokemonTipoFB.HADA)),
    PokemonFB(684,"6",R.drawable.swirlix, "Swirlix","Como se alimenta exclusivamente de dulces, su pelaje es tan pegajoso y dulzón como el algodón de azúcar.",listOf(PokemonTipoFB.HADA)),
    PokemonFB(685,"6",R.drawable.slurpuff, "Slurpuff","Puede rastrear hasta el más débil de los olores. Hace uso de su fino olfato para ayudar a los pasteleros más exquisitos.",listOf(PokemonTipoFB.HADA)),
    PokemonFB(686,"6",R.drawable.inkay, "Inkay","La luz intermitente que emite aplaca el ánimo de lucha del enemigo. Aprovecha la ocasión para esconderse.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.PSIQUICO)),
    PokemonFB(687,"6",R.drawable.malamar, "Malamar","Tiene a su disposición los poderes hipnóticos más poderosos de entre todos los Pokémon. Controla al enemigo a su voluntad.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.PSIQUICO)),
    PokemonFB(688,"6",R.drawable.binacle, "Binacle","Dos Binacle conviven en la misma roca, pero cuando se produce un altercado entre ambos, uno de ellos se muda a otra.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.AGUA)),
    PokemonFB(689,"6",R.drawable.barbaracle, "Barbaracle","Si bien todas las extremidades de Barbaracle tienen cerebro propio y se mueven a su antojo, suelen seguir órdenes que imparte la cabeza.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.AGUA)),
    PokemonFB(690,"6",R.drawable.skrelp, "Skrelp","Adopta la apariencia de algas podridas y lanza un líquido venenoso a las presas desprevenidas que pasan cerca.",listOf(PokemonTipoFB.VENENO,PokemonTipoFB.AGUA)),
    PokemonFB(691,"6",R.drawable.dragalge, "Dragalge","Según se dice, los barcos que se aventuran en aguas donde habitan Dragalge desaparecen del mapa y no regresan a puerto.",listOf(PokemonTipoFB.VENENO,PokemonTipoFB.DRAGON)),
    PokemonFB(692,"6",R.drawable.clauncher, "Clauncher","Abate a enemigos voladores disparando agua a presión con su enorme pinza como si de una pistola se tratara.",listOf(PokemonTipoFB.AGUA)),
    PokemonFB(693,"6",R.drawable.clawitzer, "Clawitzer","Posee una enorme pinza que dispara bolas de agua que podrían atravesar incluso el casco de un petrolero.",listOf(PokemonTipoFB.AGUA)),
    PokemonFB(694,"6",R.drawable.heliolisk, "Heliolisk","Habita en los desiertos y, cuando toma el sol, acumula energía, lo que le permite vivir sin la necesidad de ingerir alimentos.",listOf(PokemonTipoFB.ELECTRICO,PokemonTipoFB.NORMAL)),
    PokemonFB(695,"6",R.drawable.helioptile, "Helioptile","Extiende su gorguera y genera energía eléctrica suficiente para cubrir el consumo de electricidad de un rascacielos entero.",listOf(PokemonTipoFB.ELECTRICO,PokemonTipoFB.NORMAL)),
    PokemonFB(696,"6",R.drawable.tyrunt, "Tyrunt","Pokémon recreado a partir de fósiles. Cuando sucede algo que no es de su agrado, se enfurece y se vuelve violento.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.DRAGON)),
    PokemonFB(697,"6",R.drawable.tyrantrum, "Tyrantrum","Hace 100 millones de años, este Pokémon se comportaba como un rey, sin nadie que osase hacerle frente.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.DRAGON)),
    PokemonFB(698,"6",R.drawable.amaura, "Amaura","Pokémon que ha sido regenerado a partir de un trozo de su antiguo cuerpo, que quedó congelado hace unos 100 millones de años.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.HIELO)),
    PokemonFB(699,"6",R.drawable.aurorus, "Aurorus","Expulsa un gas gélido a temperaturas inferiores a los -150 °C a través de sus cristales romboides y congela así a su enemigo.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.HIELO)),
    PokemonFB(700,"6",R.drawable.sylveon, "Sylveon","A través de sus apéndices sensitivos con forma de cinta, emite unas ondas tranquilizadoras mediante las cuales detiene los combates.",listOf(PokemonTipoFB.HADA)),
    PokemonFB(701,"6",R.drawable.hawlucha, "Hawlucha","Controla su posición en el aire con las alas. Lanza ataques desde gran altura que resultan difíciles de evitar.",listOf(PokemonTipoFB.LUCHA,PokemonTipoFB.VOLADOR)),
    PokemonFB(702,"6",R.drawable.dedenne, "Dedenne","Con su cola absorbe la electricidad procedente de las centrales de energía o los enchufes de las casas, para liberarla en forma de ataque por los bigotes.",listOf(PokemonTipoFB.ELECTRICO,PokemonTipoFB.HADA)),
    PokemonFB(703,"6",R.drawable.carbink, "Carbink","Nace en las profundidades subterráneas, a altas temperaturas y a gran presión. Irradia energía por la roca que tiene en la cabeza.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.HADA)),
    PokemonFB(704,"6",R.drawable.goomy, "Goomy","Es el Pokémon de tipo Dragón más débil. Habita en zonas oscuras y húmedas para evitar que su viscoso cuerpo se seque.",listOf(PokemonTipoFB.DRAGON)),
    PokemonFB(705,"6",R.drawable.sliggoo, "Sliggoo","Segrega una mucosidad que corroe todo lo que toca y consigue así ahuyentar al enemigo. Sus ojos han involucionado, por lo que no puede ver.",listOf(PokemonTipoFB.DRAGON)),
    PokemonFB(706,"6",R.drawable.goodra, "Goodra","Ataca con sus antenas retráctiles, desplegando una fuerza comparable a los puñetazos de 100 boxeadores profesionales.",listOf(PokemonTipoFB.DRAGON)),
    PokemonFB(707,"6",R.drawable.klefki, "Klefki","Tiene el hábito de coleccionar llaves. Cuando un enemigo lo ataca, las hace tintinear como método de intimidación.",listOf(PokemonTipoFB.ACERO,PokemonTipoFB.HADA)),
    PokemonFB(708,"6",R.drawable.phantump, "Phantump","Nace cuando el alma de un niño perdido habita un tocón. Su grito se asemeja a un escalofriante chillido.",listOf(PokemonTipoFB.FANTASMA,PokemonTipoFB.PLANTA)),
    PokemonFB(709,"6",R.drawable.trevenant, "Trevenant","Es amable con los seres que habitan los bosques, pero se cuenta que devora a quienes los mancillan.",listOf(PokemonTipoFB.FANTASMA,PokemonTipoFB.PLANTA)),
    PokemonFB(710,"6",R.drawable.pumpkaboo, "Pumpkaboo","En el interior de la calabaza reside un espíritu que ha permanecido atrapado en este mundo. Entra en acción al caer la noche.",listOf(PokemonTipoFB.FANTASMA,PokemonTipoFB.PLANTA)),
    PokemonFB(711,"6",R.drawable.gourgeist, "Gourgeist","En las noches de luna nueva deambula por las calles de las ciudades y emite espeluznantes alaridos que maldicen a quienes los oyen.",listOf(PokemonTipoFB.FANTASMA,PokemonTipoFB.PLANTA)),
    PokemonFB(712,"6",R.drawable.bergmite, "Bergmite","Envuelve su cuerpo en una capa de hielo que le permite evitar los ataques del enemigo. Si se resquebraja, la recompone con aire gélido.",listOf(PokemonTipoFB.HIELO)),
    PokemonFB(713,"6",R.drawable.avalugg, "Avalugg","Parece un portaaviones de hielo, por el aspecto que presenta al llevar varios Bergmite en su espalda.",listOf(PokemonTipoFB.HIELO)),
    PokemonFB(714,"6",R.drawable.noibat, "Noibat","Habita en cuevas donde reina la más absoluta oscuridad y emite ondas ultrasónicas de 200 000 Hz a través de sus enormes orejas.",listOf(PokemonTipoFB.VOLADOR,PokemonTipoFB.DRAGON)),
    PokemonFB(715,"6",R.drawable.noivern, "Noivern","Surca el cielo nocturno cuando ni siquiera la luna brilla y ataca a presas incautas. Es imbatible en combates que tienen lugar a oscuras.",listOf(PokemonTipoFB.VOLADOR,PokemonTipoFB.DRAGON)),
    PokemonFB(716,"6",R.drawable.xerneas, "Xerneas","Cuando los cuernos de su cabeza brillan en siete colores, se dice que comparte el don de la vida eterna.",listOf(PokemonTipoFB.HADA)),
    PokemonFB(717,"6",R.drawable.yveltal, "Yveltal","Pokémon legendario que, al extender sus alas y las plumas de la cola, emite un brillo carmesí que absorbe la energía vital de su enemigo.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.VOLADOR)),
    PokemonFB(718,"6",R.drawable.zygarde, "Zygarde","Cuando el ecosistema de Kalos se encuentra en peligro, aparece y revela su poder secreto.",listOf(PokemonTipoFB.DRAGON,PokemonTipoFB.TIERRA)),
    PokemonFB(719,"6",R.drawable.diancie, "Diancie","Es una transformación súbita de Carbink. Se dice que su cuerpo, que irradia destellos rosados, es lo más bonito de este mundo.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.HADA)),
    PokemonFB(720,"6",R.drawable.hoopa, "Hoopa","Reúne los objetos que le atraen para esconderlos en una guarida secreta, teletransportándolos a través de sus anillos.",listOf(PokemonTipoFB.PSIQUICO,PokemonTipoFB.FANTASMA)),
    PokemonFB(721,"6",R.drawable.volcanion, "Volcanion","Expulsa vapor y desaparece entre la densa niebla. Dicen que habita en montañas solitarias.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.AGUA)),
    PokemonFB(722,"7",R.drawable.rowlet, "Rowlet","Es cauteloso, desconfiado y de naturaleza nocturna. Durante el día acumula energía mediante la fotosíntesis.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.VOLADOR)),
    PokemonFB(723,"7",R.drawable.dartrix, "Dartrix","Ataca a sus presas y enemigos lanzándoles plumas sorprendentemente afiladas. Acierta prácticamente siempre.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.VOLADOR)),
    PokemonFB(724,"7",R.drawable.decidueye, "Decidueye","Las plumas de sus alas le sirven de flechas con las que puede acertar a un guijarro a 100 m.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.FANTASMA)),
    PokemonFB(725,"7",R.drawable.litten, "Litten","Prende las bolas de pelo que se forman en su estómago tras acicalarse. Las llamas que escupe tienen formas variopintas.",listOf(PokemonTipoFB.FUEGO)),
    PokemonFB(726,"7",R.drawable.torracat, "Torracat","Luce al cuello un cascabel incandescente que tintinea con fuerza cuando desprende llamas.",listOf(PokemonTipoFB.FUEGO)),
    PokemonFB(727,"7",R.drawable.incineroar, "Incineroar","Posee un carácter rudo y egoísta. Si un Entrenador no le cae en gracia, ignora sus órdenes con total impasibilidad.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.SINIESTRO)),
    PokemonFB(728,"7",R.drawable.popplio, "Popplio","Maneja con soltura los globos de agua que crea, pero, para poder hacer uno bien grande, necesita practicar sin descanso.",listOf(PokemonTipoFB.AGUA)),
    PokemonFB(729,"7",R.drawable.brionne, "Brionne","Un bailarín consumado. Crea globos de agua con los que golpea a sus rivales una y otra vez sin dejar de bailar.",listOf(PokemonTipoFB.AGUA)),
    PokemonFB(730,"7",R.drawable.primarina, "Primarina","Se vale de su canto para atacar a los rivales. Su Entrenador deberá velar por que sus cuerdas vocales estén siempre en perfecto estado.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.HADA)),
    PokemonFB(731,"7",R.drawable.pikipek, "Pikipek","Hace agujeros en los árboles a una velocidad de 16 picotazos por segundo y los utiliza como despensa o como su nido.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.VOLADOR)),
    PokemonFB(732,"7",R.drawable.trumbeak, "Trumbeak","Puede deformar su pico para producir los sonidos más diversos. Debido al estruendo que crea, se granjea la enemistad de sus vecinos.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.VOLADOR)),
    PokemonFB(733,"7",R.drawable.toucannon, "Toucannon","Cuando va a combatir, calienta su pico hasta temperaturas que superan los 100 °C, lo que puede causar graves quemaduras al contacto.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.VOLADOR)),
    PokemonFB(734,"7",R.drawable.yungoos, "Yungoos","Sus afilados colmillos lo atraviesan todo. No es autóctono de Alola, sino que proviene de otra región.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(735,"7",R.drawable.gumshoos, "Gumshoos","Al detectar el rastro de una presa, la acecha con tenacidad, pero al ponerse el sol le vence el sueño.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(736,"7",R.drawable.grubbin, "Grubbin","Con sus duras mandíbulas arranca la corteza de los árboles y sorbe la savia. Suele habitar bajo tierra.",listOf(PokemonTipoFB.BICHO)),
    PokemonFB(737,"7",R.drawable.charjabug, "Charjabug","Al hacer la digestión genera energía eléctrica que almacena en la bolsa que posee para tal efecto.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.ELECTRICO)),
    PokemonFB(738,"7",R.drawable.vikavolt, "Vikavolt","Sobrevuela un área en busca de presas. Puede concentrar una potente carga eléctrica entre sus mandíbulas para atacar a sus rivales.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.ELECTRICO)),
    PokemonFB(739,"7",R.drawable.crabrawler, "Crabrawler","Protege sus puntos débiles con las pinzas y propina puñetazos en cuanto tiene ocasión. Cuando pierde, llora lágrimas espumosas.",listOf(PokemonTipoFB.LUCHA)),
    PokemonFB(740,"7",R.drawable.crabominable, "Crabominable","Tras perderse intentando coronar una alta montaña, desarrolló una capa de pelo para protegerse del frío.",listOf(PokemonTipoFB.LUCHA,PokemonTipoFB.HIELO)),
    PokemonFB(741,"7",R.drawable.oricorio, "Oricorio","Junta las alas y lanza voraces llamas al rival. Su ataque se asemeja a una elaborada coreografía de fuego.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.VOLADOR)),
    PokemonFB(742,"7",R.drawable.cutiefly, "Cutiefly","Se alimenta de néctar y polen. Es capaz de detectar los capullos que están a punto de abrirse.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.HADA)),
    PokemonFB(743,"7",R.drawable.ribombee, "Ribombee","Fabrica varios tipos de bolas de polen. Algunas se usan como alimento y otras para el combate.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.HADA)),
    PokemonFB(744,"7",R.drawable.rockruff, "Rockruff","Su carácter amigable lo convierte en el Pokémon ideal para Entrenadores novatos. Sin embargo, al crecer suele volverse un poco agresivo.",listOf(PokemonTipoFB.ROCA)),
    PokemonFB(745,"7",R.drawable.lycanroc, "Lycanroc","Cuanto más fuerte es su rival, más se crece. Sus ansias de ganar lo llevan a arrojarse sobre él sin consideración por su propia vida.",listOf(PokemonTipoFB.ROCA)),
    PokemonFB(746,"7",R.drawable.wishiwashi, "Wishiwashi","Cuando los pequeños y débiles Wishiwashi se agrupan en bancos, se convierten en una bestia marina temida por todos.",listOf(PokemonTipoFB.AGUA)),
    PokemonFB(747,"7",R.drawable.mareanie, "Mareanie","Aturde a su presa con los aguijones venenosos de la cabeza. Cuando esta se debilita, la rodea con sus diez extremidades y la remata.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.VENENO)),
    PokemonFB(748,"7",R.drawable.toxapex, "Toxapex","Se arrastra por el lecho marino con sus doce extremidades. Deja siempre una estela de restos de Corsola por donde pasa.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.VENENO)),
    PokemonFB(749,"7",R.drawable.mudbray, "Mudbray","El lodo que impregna sus patas le otorga una fuerte tracción, lo que le permite alcanzar altas velocidades al correr.",listOf(PokemonTipoFB.TIERRA)),
    PokemonFB(750,"7",R.drawable.mudsdale, "Mudsdale","El lodo que segrega por la boca se vuelve impermeable al secarse, por lo que solía usarse como capa aislante en las paredes de las casas.",listOf(PokemonTipoFB.TIERRA)),
    PokemonFB(751,"7",R.drawable.dewpider, "Dewpider","Emerge a la superficie para alimentarse. La burbuja con la que se rodea le sirve para respirar y proteger su delicada cabeza.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.BICHO)),
    PokemonFB(752,"7",R.drawable.araquanid, "Araquanid","Es más atento de lo que parece. Si encuentra a uno de los suyos débil o vulnerable, lo protege envolviéndolo con su burbuja.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.BICHO)),
    PokemonFB(753,"7",R.drawable.fomantis, "Fomantis","Desprende un aroma fresco y dulce. En la hierba alta donde se esconde también suelen acudir Cutiefly.",listOf(PokemonTipoFB.PLANTA)),
    PokemonFB(754,"7",R.drawable.lurantis, "Lurantis","Dedica mucho tiempo y esfuerzo a acicalarse y preservar sus vivos colores. A algunos ejemplares incluso les lleva todo el día.",listOf(PokemonTipoFB.PLANTA)),
    PokemonFB(755,"7",R.drawable.morelull, "Morelull","Cuando titila, esparce esporas luminosas a su alrededor. Todo aquel que ve esta luz cae en un profundo sueño.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.HADA)),
    PokemonFB(756,"7",R.drawable.shiinotic, "Shiinotic","Las esporas parpadeantes que despide tienen un efecto somnífero. Absorbe la vitalidad de su presa cuando esta se queda dormida.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.HADA)),
    PokemonFB(757,"7",R.drawable.salandit, "Salandit","Aturde a sus oponentes con un gas venenoso que produce al quemar sus fluidos corporales y luego se abalanza sobre ellos.",listOf(PokemonTipoFB.VENENO,PokemonTipoFB.FUEGO)),
    PokemonFB(758,"7",R.drawable.salazzle, "Salazzle","Por algún motivo desconocido, solo hay hembras. Suele formarse su propio harén compuesto por Salandit machos.",listOf(PokemonTipoFB.VENENO,PokemonTipoFB.FUEGO)),
    PokemonFB(759,"7",R.drawable.stufful, "Stufful","Pese a su aspecto encantador, cuando se enoja, sus pataletas son tan feroces que pueden derribar hasta a un luchador profesional.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.LUCHA)),
    PokemonFB(760,"7",R.drawable.bewear, "Bewear","Es un Pokémon muy peligroso por su fuerza descomunal. Normalmente se desaconseja penetrar en su hábitat.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.LUCHA)),
    PokemonFB(761,"7",R.drawable.bounsweet, "Bounsweet","Atraídos por el apetitoso aroma que desprende su cuerpo, los Toucannon los engullen con avidez sin ni siquiera masticar.",listOf(PokemonTipoFB.PLANTA)),
    PokemonFB(762,"7",R.drawable.steenee, "Steenee","Puede jugar con Pokémon pájaro sin peligro gracias al duro cáliz que protege su cuerpo. No le importa que lo picoteen.",listOf(PokemonTipoFB.PLANTA)),
    PokemonFB(763,"7",R.drawable.tsareena, "Tsareena","Propina bellas patadas con elegancia. Una sola bastaría para dejar fuera de combate a un campeón de kickboxing.",listOf(PokemonTipoFB.PLANTA)),
    PokemonFB(764,"7",R.drawable.comfey, "Comfey","Prende flores en su tallo, que es muy rico en nutrientes. Las flores se revitalizan y desprenden una agradable fragancia.",listOf(PokemonTipoFB.HADA)),
    PokemonFB(765,"7",R.drawable.oranguru, "Oranguru","Es un Pokémon famoso por su astucia e ingenio. Desprecia a los Entrenadores novatos y prefiere a los más veteranos.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.PSIQUICO)),
    PokemonFB(766,"7",R.drawable.passimian, "Passimian","Suele ir en grupos de unos veinte ejemplares. Sus miembros permanecen siempre unidos y nunca se abandonan unos a otros.",listOf(PokemonTipoFB.LUCHA)),
    PokemonFB(767,"7",R.drawable.wimpod, "Wimpod","Cuando se asusta, huye despavorido moviendo rápidamente sus múltiples patas. Deja el suelo limpio y pulido allí por donde pasa.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.AGUA)),
    PokemonFB(768,"7",R.drawable.golisopod, "Golisopod","Gracias a su destreza y sus enormes y afiladas garras, puede cortar hasta el aire y el agua de un solo tajo.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.AGUA)),
    PokemonFB(769,"7",R.drawable.sandygast, "Sandygast","Surgió cuando una persona murió abandonada en plena calle y su resentimiento poseyó un montículo de arena apilado por un niño.",listOf(PokemonTipoFB.FANTASMA,PokemonTipoFB.TIERRA)),
    PokemonFB(770,"7",R.drawable.palossand, "Palossand","Manipulando a la gente ha conseguido transformarse en todo un castillo de arena, lo que ha aumentado su poder maligno.",listOf(PokemonTipoFB.FANTASMA,PokemonTipoFB.TIERRA)),
    PokemonFB(771,"7",R.drawable.pyukumuku, "Pyukumuku","Vive en las playas y en aguas poco profundas. Expulsa sus entrañas para engañar a sus depredadores y librarse de ellos.",listOf(PokemonTipoFB.AGUA)),
    PokemonFB(772,"7",R.drawable.codigocero, "Código Cero","La pesada máscara le impide liberar toda su fuerza, que se cree que es extraordinaria.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(773,"7",R.drawable.silvally, "Silvally","Tras descubrir la máscara de contención que lo controlaba, ahora puede modificar su tipo en función del disco que utilice.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(774,"7",R.drawable.minior, "Minior","Se alimenta de las partículas que flotan la atmósfera. El color de su núcleo depende de la composición de estas.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.VOLADOR)),
    PokemonFB(775,"7",R.drawable.komala, "Komala","Pasa la vida entera sumido en un profundo sueño. Toda su actividad parece reflejar los sueños que tiene en ese momento.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(776,"7",R.drawable.turtonator, "Turtonator","Posee un caparazón que estalla al contacto. El orificio que se aprecia en su vientre es su punto débil.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.DRAGON)),
    PokemonFB(777,"7",R.drawable.togedemaru, "Togedemaru","Cuando se siente amenazado, eriza las púas de su lomo para pinchar a quien ose atacarlo.",listOf(PokemonTipoFB.ELECTRICO,PokemonTipoFB.ACERO)),
    PokemonFB(778,"7",R.drawable.mimikyu, "Mimikyu","Su verdadero aspecto es un misterio total. Un investigador que intentó mirar dentro del saco recibió, literalmente, un susto de muerte.",listOf(PokemonTipoFB.FANTASMA,PokemonTipoFB.HADA)),
    PokemonFB(779,"7",R.drawable.bruxish, "Bruxish","Cuando la protuberancia que tiene en la cabeza emite poderes psíquicos, se escucha como un ruido de dientes rechinando muy molesto.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.PSIQUICO)),
    PokemonFB(780,"7",R.drawable.drampa, "Drampa","Es de naturaleza mansa, pero si se le provoca y monta en cólera, destruye todo lo que le rodea con su aliento devastador.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.DRAGON)),
    PokemonFB(781,"7",R.drawable.dhelmise, "Dhelmise","Los giros de su enorme ancla son capaces de noquear al mismísimo Wailord de un solo golpe. El alga verde es su verdadero cuerpo.",listOf(PokemonTipoFB.FANTASMA,PokemonTipoFB.PLANTA)),
    PokemonFB(782,"7",R.drawable.jangmoo, "Jangmo-o","Habita en montañas despobladas. Luchan entre ellos para fortalecerse poco a poco.",listOf(PokemonTipoFB.DRAGON)),
    PokemonFB(783,"7",R.drawable.hakamoo, "Hakamo-o","Se lanza sobre su presa entonando un grito de guerra. Golpea al enemigo y lo hace trizas con sus escamas.",listOf(PokemonTipoFB.DRAGON,PokemonTipoFB.LUCHA)),
    PokemonFB(784,"7",R.drawable.kommoo, "Kommo-o","Sus sólidas escamas le sirven tanto para atacar como para defenderse. Antaño se usaban para fabricar armas u objetos de uso cotidiano.",listOf(PokemonTipoFB.DRAGON,PokemonTipoFB.LUCHA)),
    PokemonFB(785,"7",R.drawable.tapukoko, "Tapu Koko","El espíritu guardián de Melemele, curioso e inquisitivo. Invoca nubes de tormenta y acumula el poder de los rayos en su cuerpo.",listOf(PokemonTipoFB.ELECTRICO,PokemonTipoFB.HADA)),
    PokemonFB(786,"7",R.drawable.tapulele, "Tapu Lele","El espíritu guardián de Akala, tan inocente como cruel. La fragancia de las flores constituye su fuente de energía.",listOf(PokemonTipoFB.PSIQUICO,PokemonTipoFB.HADA)),
    PokemonFB(787,"7",R.drawable.tapubulu, "Tapu Bulu","Arranca de cuajo árboles grandes para hacerlos girar. Vuelve exuberante la vegetación y luego absorbe su energía.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.HADA)),
    PokemonFB(788,"7",R.drawable.tapufini, "Tapu Fini","Desconcierta al enemigo provocando una espesa niebla que se convierte en su perdición. Las corrientes marinas son su fuente de energía.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.HADA)),
    PokemonFB(789,"7",R.drawable.cosmog, "Cosmog","Su cuerpo se compone de una materia gaseosa inestable. Crece poco a poco al acumular las motas de polvo que flotan en el aire.",listOf(PokemonTipoFB.PSIQUICO)),
    PokemonFB(790,"7",R.drawable.cosmoem, "Cosmoem","Permanece inmóvil, como si estuviera muerto, aunque al tocarlo se percibe un ligero calor. Antaño se le llamaba Crisálida de las Estrellas.",listOf(PokemonTipoFB.PSIQUICO)),
    PokemonFB(791,"7",R.drawable.solgaleo, "Solgaleo","Se cree que proviene de otro mundo. El brillo que emite su cuerpo es tal que puede hacer que la noche más profunda parezca pleno día.",listOf(PokemonTipoFB.PSIQUICO,PokemonTipoFB.ACERO)),
    PokemonFB(792,"7",R.drawable.lunala, "Lunala","Se dice que es la evolución final hembra de Cosmog. Su tercer ojo aparece cuando se traslada a un mundo distinto.",listOf(PokemonTipoFB.PSIQUICO,PokemonTipoFB.FANTASMA)),
    PokemonFB(793,"7",R.drawable.nihilego, "Nihilego","Se desconoce si este Ultraente posee consciencia propia, pero en ocasiones se comporta como una chica joven.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.VENENO)),
    PokemonFB(794,"7",R.drawable.buzzwole, "Buzzwole","Un Ultraente rodeado de misterio. Se le ha visto reducir a añicos un camión de un solo puñetazo.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.LUCHA)),
    PokemonFB(795,"7",R.drawable.pheromosa, "Pheromosa","Uno de los temibles Ultraentes. Se dice que ha sido avistado recorriendo la superficie terrestre a velocidades de vértigo.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.LUCHA)),
    PokemonFB(796,"7",R.drawable.xurkitree, "Xurkitree","Un Ultraente rodeado de misterio. Se dice que su cuerpo desprende descargas eléctricas de inmensa potencia.",listOf(PokemonTipoFB.ELECTRICO)),
    PokemonFB(797,"7",R.drawable.celesteela, "Celesteela","Este Ultraente surgió de un Ultraumbral. Parece haber sido avistado surcando los cielos a velocidades vertiginosas.",listOf(PokemonTipoFB.ACERO,PokemonTipoFB.VOLADOR)),
    PokemonFB(798,"7",R.drawable.kartana, "Kartana","Este Ultraente surgió de un Ultraumbral. Se dice que no es muy agresivo, pero su afilado cuerpo es un arma realmente peligrosa.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.ACERO)),
    PokemonFB(799,"7",R.drawable.guzzlord, "Guzzlord","Se dice que este Ultraente ha sido avistado devorando montañas enteras y tragándose prominentes edificios.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.DRAGON)),
    PokemonFB(800,"7",R.drawable.necrozma, "Necrozma","Se dice que yacía en el interior de la tierra. Se cree que esta criatura, parecida a un Ultraente, vino de otro mundo hace muchísimo tiempo.",listOf(PokemonTipoFB.PSIQUICO)),
    PokemonFB(801,"7",R.drawable.magearna, "Magearna","Pokémon artificial creado hace más de 500 años. Es capaz de entender el lenguaje humano pero carece de la facultad del habla.",listOf(PokemonTipoFB.ACERO,PokemonTipoFB.HADA)),
    PokemonFB(802,"7",R.drawable.marshadow, "Marshadow","Debido a que siempre se ha ocultado en las sombras y no le gusta dejarse ver, su misma existencia es todo un misterio.",listOf(PokemonTipoFB.LUCHA,PokemonTipoFB.FANTASMA)),
    PokemonFB(803,"7",R.drawable.poipole, "Poipole","En su mundo, este Ultraente se considera tan entrañable como para ser elegido compañero de viaje.",listOf(PokemonTipoFB.VENENO)),
    PokemonFB(804,"7",R.drawable.naganadel, "Naganadel","Uno de los Ultraentes. Su aguijón segrega un líquido tóxico cuya viscosidad le da una apariencia brillante.",listOf(PokemonTipoFB.VENENO,PokemonTipoFB.DRAGON)),
    PokemonFB(805,"7",R.drawable.stakataka, "Stakataka","Extraña criatura que podría ser un Ultraente. Parece un muro rocoso hasta que se mueve de repente y ataca.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.ACERO)),
    PokemonFB(806,"7",R.drawable.blacephalon, "Blacephalon","Un Ultraente surgido de un Ultraumbral. Crea una explosión para sorprender al oponente y aprovecha para absorber su energía vital.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.FANTASMA)),
    PokemonFB(807,"7",R.drawable.zeraora, "Zeraora","Tan veloz como el rayo, hace trizas a cualquier rival con sus garras cargadas de electricidad de alto voltaje.",listOf(PokemonTipoFB.ELECTRICO)),
    PokemonFB(808,"7",R.drawable.meltan, "Meltan","Funde metales para ingerirlos. Una vez licuados, los hace circular por el interior de su cuerpo para generar energía.",listOf(PokemonTipoFB.ACERO)),
    PokemonFB(809,"7",R.drawable.melmetal, "Melmetal","En la antigüedad se le veneraba por su poder de crear hierro. Después de tres milenios, ha regresado misteriosamente.",listOf(PokemonTipoFB.ACERO)),


















)

