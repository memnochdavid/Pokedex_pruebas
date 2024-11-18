package com.david.pokedex_pruebas.modelo


import android.graphics.Bitmap
import android.os.Parcelable
import com.david.pokedex_pruebas.R
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
data class PokemonFB(
    var num:Int=0,
    var id: String="",
    var foto:Int=0,//soporte local
    var imagenFB: String? = null,//soporte en la nube
    var name: String="",
    var desc: String="",
    var tipo: List<PokemonTipoFB> = listOf()
):Serializable, Parcelable{
    constructor(
        num: Int,
        id: String,
        foto: Int,
        name: String,
        desc: String,
        tipo: List<PokemonTipoFB>
    ) : this(num, id, foto, null, name, desc, tipo)
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


/*
fun drawableToEnumFB(drawable:Int):PokemonTipoFB{
    return when(drawable){
        R.drawable.planta -> PokemonTipoFB.PLANTA
        R.drawable.agua -> PokemonTipoFB.AGUA
        R.drawable.fuego -> PokemonTipoFB.FUEGO
        R.drawable.lucha -> PokemonTipoFB.LUCHA
        R.drawable.veneno -> PokemonTipoFB.VENENO
        R.drawable.acero -> PokemonTipoFB.ACERO
        R.drawable.bicho -> PokemonTipoFB.BICHO
        R.drawable.dragon -> PokemonTipoFB.DRAGON
        R.drawable.electrico -> PokemonTipoFB.ELECTRICO
        R.drawable.hada -> PokemonTipoFB.HADA
        R.drawable.hielo -> PokemonTipoFB.HIELO
        R.drawable.psiquico -> PokemonTipoFB.PSIQUICO
        R.drawable.roca -> PokemonTipoFB.ROCA
        R.drawable.tierra -> PokemonTipoFB.TIERRA
        R.drawable.siniestro -> PokemonTipoFB.SINIESTRO
        R.drawable.normal -> PokemonTipoFB.NORMAL
        R.drawable.volador -> PokemonTipoFB.VOLADOR
        R.drawable.fantasma -> PokemonTipoFB.FANTASMA
        else -> { PokemonTipoFB.NULL}
    }
}
*/


var listaPokeFB : List<PokemonFB> = listOf(
    PokemonFB(1,"",R.drawable.bulbasaur,"Bulbasaur", "Puede sobrevivir largo tiempo sin probar bocado. Guarda energía en el bulbo de su espalda.", listOf(PokemonTipoFB.PLANTA, PokemonTipoFB.VENENO)),
    PokemonFB(2,"",R.drawable.ivisaur01, "Ivysaur", "Su bulbo crece cuando absorbe energía. Desprende un fuerte aroma cuando florece.", listOf(PokemonTipoFB.PLANTA, PokemonTipoFB.VENENO)),
    PokemonFB(3,"",R.drawable.venusaur, "Venusaur", "La flor de su espalda recoge los rayos del sol. Los transforma en energía.", listOf(PokemonTipoFB.PLANTA, PokemonTipoFB.VENENO)),
    PokemonFB(4,"",R.drawable.charmander, "Charmander", "La llama en la punta de su cola chisporrotea al arder. Sólo se oye en lugares silenciosos.", listOf(PokemonTipoFB.FUEGO)),
    PokemonFB(5,"",R.drawable.charmeleon, "Charmeleon", "Las duras luchas excitan a este Pokémon. Entonces, lanzará llamaradas blanco-azuladas.", listOf(PokemonTipoFB.FUEGO)),
    PokemonFB(6,"",R.drawable.charizard, "Charizard", "Cuando lanza una descarga de fuego súper caliente, la roja llama de su cola brilla más intensamente.", listOf(PokemonTipoFB.FUEGO, PokemonTipoFB.VOLADOR)),
    PokemonFB(7,"",R.drawable.squirtle01, "Squirtle", "Lanza agua a su presa desde el agua. Se esconde en su concha cuando se siente en peligro.", listOf(PokemonTipoFB.AGUA)),
    PokemonFB(8,"",R.drawable.wartortle, "Wartortle", "Si es golpeado, esconderá su cabeza. Aun así, su cola puede seguir golpeando.", listOf(PokemonTipoFB.AGUA)),
    PokemonFB(9,"",R.drawable.blastoise, "Blastoise", "Cuando ataca a un enemigo, su descarga de agua es aún más potente que una manga de bombero.", listOf(PokemonTipoFB.AGUA)),
    PokemonFB(10,"",R.drawable.caterpie, "Caterpie", "Si tocas los receptores de su cabeza, soltará un terrible olor para protegerse.", listOf(PokemonTipoFB.BICHO)),
    PokemonFB(11,"",R.drawable.metapod, "Metapod", "Endurece su concha para protegerse. De todos modos, un gran impacto puede afectarle.", listOf(PokemonTipoFB.BICHO)),
    PokemonFB(12,"",R.drawable.butterfree, "Butterfree", "Sus alas están cubiertas de polvos venenosos. Como repelen el agua, puede volar bajo la lluvia.", listOf(PokemonTipoFB.BICHO, PokemonTipoFB.VOLADOR)),
    PokemonFB(13,"",R.drawable.weedle, "Weedle", "Cuidado con el aguijón venenoso de su cabeza. Se esconde en la hierba y arbustos mientras come.", listOf(PokemonTipoFB.BICHO, PokemonTipoFB.VENENO)),
    PokemonFB(14,"",R.drawable.kakuna, "Kakuna", "Sólo puede moverse un poco. Cuando está en peligro, envenena a su enemigo con su aguijón.", listOf(PokemonTipoFB.BICHO, PokemonTipoFB.VENENO)),
    PokemonFB(15,"",R.drawable.beedril, "Beedril", "Tiene 3 aguijones venenosos en sus patas y cola. Suele pinchar a sus enemigos repetidas veces.", listOf(PokemonTipoFB.BICHO, PokemonTipoFB.VENENO)),
    PokemonFB(16,"",R.drawable.pidgey, "Pidgey", "Son muy dóciles. Si son atacados, suelen lanzar arena en lugar de repeler el ataque.", listOf(PokemonTipoFB.NORMAL, PokemonTipoFB.VOLADOR)),
    PokemonFB(17,"",R.drawable.pidgeotto, "Pidgeotto", "Su visión es extraordinaria. Aunque vuele muy alto, detectará todo movimiento de su presa.", listOf(PokemonTipoFB.NORMAL, PokemonTipoFB.VOLADOR)),
    PokemonFB(18,"",R.drawable.pidgeot, "Pidgeot", "Este Pokémon vuela a velocidad Mach 2. Sus grandes garras son armas muy peligrosas.", listOf(PokemonTipoFB.NORMAL, PokemonTipoFB.VOLADOR)),
    PokemonFB(19,"",R.drawable.rattata, "Rattata", "Muerde cualquier cosa con sus colmillos. Si ves uno, seguro que encuentras 40 más en la zona.", listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(20,"",R.drawable.raticate, "Raticate", "Sus patas son palmeadas. Sirven de aletas, por lo que puede nadar por ríos en busca de presa.", listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(21,"",R.drawable.spearow, "Spearow", "Es incapaz de volar a gran altura, pero es muy rápido, lo que le permite protegerse.", listOf(PokemonTipoFB.NORMAL, PokemonTipoFB.VOLADOR)),
    PokemonFB(22,"",R.drawable.fearow, "Fearow", "Este Pokémon es conocido desde hace muchos años. Si siente peligro volará lejos inmediatamente.", listOf(PokemonTipoFB.NORMAL, PokemonTipoFB.VOLADOR)),
    PokemonFB(23,"",R.drawable.ekans, "Ekans", "Cuanto más viejo, más crece este Pokémon. Por la noche, descansa en las ramas de los árboles.", listOf(PokemonTipoFB.VENENO)),
    PokemonFB(24,"",R.drawable.arbok, "Arbok", "Los espantosos dibujos de su piel han sido estudiados. Seis variaciones han sido confirmadas.", listOf(PokemonTipoFB.VENENO)),
    PokemonFB(25,"",R.drawable.pikachu, "Pikachu", "Mantiene su cola en alto para vigilar. Si das un tirón a su cola, querrá morderte.", listOf(PokemonTipoFB.ELECTRICO)),
    PokemonFB(26,"",R.drawable.raichu, "Raichu", "Cuando la electricidad del cuerpo crece, se vuelve irritable. También brilla en la oscuridad.", listOf(PokemonTipoFB.ELECTRICO)),
    PokemonFB(27,"",R.drawable.sandshrew, "Sandshrew", "Su cuerpo es muy seco. Cuando hace frío por la noche, su piel aparece cubierta con un fino rocío.", listOf(PokemonTipoFB.TIERRA)),
    PokemonFB(28,"",R.drawable.sandslash, "Sandslash", "Es muy hábil al golpear a sus enemigos con sus garras. Si se rompen, crecerán en un solo día.", listOf(PokemonTipoFB.TIERRA)),
    PokemonFB(29,"",R.drawable.nidoranf, "Nidoran♀", "A este Pokémon no le gusta luchar. Pero cuidado, sus pequeños cuernos segregan veneno.", listOf(PokemonTipoFB.VENENO)),
    PokemonFB(30,"",R.drawable.nidorina, "Nidorina", "Cuando descansa profundamente, sus cuernos se contraen. Esto prueba que está relajado.", listOf(PokemonTipoFB.VENENO)),
    PokemonFB(31,"",R.drawable.nidoqueen, "Nidoqueen", "Grandes escamas recubren el duro cuerpo de este Pokémon. Éstas crecen cíclicamente.", listOf(PokemonTipoFB.VENENO, PokemonTipoFB.TIERRA)),
    PokemonFB(32,"",R.drawable.nidoranm, "Nidoran♂", "Sus largas orejas se mantienen siempre alerta. Si siente peligro, atacará con su venenoso cuerno.", listOf(PokemonTipoFB.VENENO)),
    PokemonFB(33,"",R.drawable.nidorino, "Nidorino", "Sus cuernos contienen veneno. Si se introducen en el cuerpo del enemigo, soltarán su tóxica carga.", listOf(PokemonTipoFB.VENENO)),
    PokemonFB(34,"",R.drawable.nidoking, "Nidoking", "Duro como el acero, posee una poderosa carga. Sus cuernos son tan duros como el diamante.", listOf(PokemonTipoFB.VENENO, PokemonTipoFB.TIERRA)),
    PokemonFB(35,"",R.drawable.clefairy, "Clefairy", "Su aspecto jovial y vivaracho lo hace adorable. Piensan que son raros, ya que no son muy comunes.", listOf(PokemonTipoFB.HADA)),
    PokemonFB(36,"",R.drawable.clefable, "Clefable", "Protege bastante bien su propio entorno. Es una especie de hada, raramente vista por los humanos.", listOf(PokemonTipoFB.HADA)),
    PokemonFB(37,"",R.drawable.vulpix, "Vulpix", "Su piel y colas son preciosas. Cuando crecen las colas, se dividen formando nuevas colas.", listOf(PokemonTipoFB.FUEGO)),
    PokemonFB(38,"",R.drawable.ninetales, "Ninetales", "De acuerdo con una antigua leyenda, este Pokémon es la reencarnación de 9 nobles santos.", listOf(PokemonTipoFB.FUEGO)),
    PokemonFB(39,"",R.drawable.jigglypuff, "Jigglypuff", "Utiliza sus misteriosos ojos para engañar a su enemigo. También cantará para dormirlo.", listOf(PokemonTipoFB.NORMAL, PokemonTipoFB.HADA)),
    PokemonFB(40,"",R.drawable.wigglytuff, "Wigglytuff", "Su cuerpo es muy elástico. Cuando inhala aire profundamente, puede inflarse sin límite.", listOf(PokemonTipoFB.NORMAL, PokemonTipoFB.HADA)),
    PokemonFB(41,"",R.drawable.zubat, "Zubat", "Emite sonidos ultrasónicos mientras vuela. Los utiliza como sónar para evitar obstáculos.", listOf(PokemonTipoFB.VENENO, PokemonTipoFB.VOLADOR)),
    PokemonFB(42,"",R.drawable.golbat, "Golbat", "Ataca de manera violenta sin avisar. Utiliza sus afilados colmillos para chupar sangre.", listOf(PokemonTipoFB.VENENO, PokemonTipoFB.VOLADOR)),
    PokemonFB(43,"",R.drawable.oddish, "Oddish", "Suele ser confundido con un puñado de semillas. Si lo extraes del suelo, gritará.", listOf(PokemonTipoFB.PLANTA, PokemonTipoFB.VENENO)),
    PokemonFB(44,"",R.drawable.gloom, "Gloom", "¡Huele bastante mal! De todas formas, 1 de cada 1000 personas aprecian su fétido olor.", listOf(PokemonTipoFB.PLANTA, PokemonTipoFB.VENENO)),
    PokemonFB(45,"",R.drawable.vileplume, "Vileplume", "Aletea sus pétalos de flores para propagar su venenoso polen. El sonido que emite es agudo.", listOf(PokemonTipoFB.PLANTA, PokemonTipoFB.VENENO)),
    PokemonFB(46,"",R.drawable.paras, "Paras", "Escarba bajo el suelo para roer las raíces de los árboles. Sus setas absorben sus energías.", listOf(PokemonTipoFB.BICHO, PokemonTipoFB.PLANTA)),
    PokemonFB(47,"",R.drawable.parasect, "Parasect", "El parásito absorbe la energía con las setas de la espalda, que lo controlan.", listOf(PokemonTipoFB.BICHO, PokemonTipoFB.PLANTA)),
    PokemonFB(48,"",R.drawable.venonat, "Venonat", "Sus grandes ojos actúan como radares. En lugares claros, verás montones de pequeños ojos.", listOf(PokemonTipoFB.BICHO, PokemonTipoFB.VENENO)),
    PokemonFB(49,"",R.drawable.venomoth, "Venomoth", "Es difícil quitar el polvo de sus alas. También posee un veneno que se desprende al contacto.", listOf(PokemonTipoFB.BICHO, PokemonTipoFB.VENENO)),
    PokemonFB(50,"",R.drawable.diglett, "Diglett", "Prefiere los lugares oscuros. Pasa el tiempo bajo tierra, aunque aparece en cuevas.", listOf(PokemonTipoFB.TIERRA)),
    PokemonFB(51,"",R.drawable.dugtrio, "Dugtrio", "Un grupo de trillizos que cava a 90 KPH. Por ello, creen que se trata de un terremoto.", listOf(PokemonTipoFB.TIERRA)),
    PokemonFB(52,"",R.drawable.meowth, "Meowth", "Parece que son más activos por la noche. Adoran las cosas redondas y brillantes.", listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(53,"",R.drawable.persian, "Persian", "¡La gema en su frente brilla por sí misma! Camina con la elegancia de una reina.", listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(54,"",R.drawable.psyduck, "Psyduck", "Siempre tiene dolores de cabeza. Posee poderes mentales, pero no sabes cuándo los usará.", listOf(PokemonTipoFB.AGUA)),
    PokemonFB(55,"",R.drawable.golduck, "Golduck", "Sus delgados y largos miembros acaban en anchas aletas. Las usan para nadar en los lagos.", listOf(PokemonTipoFB.AGUA)),
    PokemonFB(56,"",R.drawable.mankey, "Mankey", "Este ágil Pokémon vive en los arboles. Se enfada fácilmente y no dudará en atacar a todos.", listOf(PokemonTipoFB.LUCHA)),
    PokemonFB(57,"",R.drawable.primeape, "Primeape", "Sólo se calma cuando nadie está cerca. Llegar a ver ese momento es realmente difícil.", listOf(PokemonTipoFB.LUCHA)),
    PokemonFB(58,"",R.drawable.growlithe, "Growlithe", "Este Pokémon es muy amistoso. Aun así, gruñirá a cualquiera que invada su territorio.", listOf(PokemonTipoFB.FUEGO)),
    PokemonFB(59,"",R.drawable.arcanine, "Arcanine", "Es un Pokémon legendario en China. Allí, adoran la gracia y belleza que exhibe al correr.", listOf(PokemonTipoFB.FUEGO)),
    PokemonFB(60,"",R.drawable.poliwag, "Poliwag", "La dirección de la espiral en el vientre cambia según el área. Prefiere nadar a correr.", listOf(PokemonTipoFB.AGUA)),
    PokemonFB(61,"",R.drawable.poliwhirl, "Poliwhirl", "Cuando lo atacan, usa la espiral del vientre para dormir al rival. Aprovecha para escapar entonces.", listOf(PokemonTipoFB.AGUA)),
    PokemonFB(62,"",R.drawable.poliwrath, "Poliwrath", "Es capaz de nadar usando todos los músculos de su cuerpo. Podrá adelantar incluso a un campeón.", listOf(PokemonTipoFB.AGUA, PokemonTipoFB.LUCHA)),
    PokemonFB(63,"",R.drawable.abra, "Abra", "Duerme 18 horas al día. Si siente peligro, se teletransporta a un lugar seguro, aun durmiendo.", listOf(PokemonTipoFB.PSIQUICO)),
    PokemonFB(64,"",R.drawable.kadabra, "Kadabra", "Muchas cosas raras suceden si está cerca. Por ejemplo, hace que los relojes vayan al revés.", listOf(PokemonTipoFB.PSIQUICO)),
    PokemonFB(65,"",R.drawable.alakazam, "Alakazam", "Este Pokémon lo recuerda todo. Nunca olvida lo que aprende. Es un Pokémon muy listo.", listOf(PokemonTipoFB.PSIQUICO)),
    PokemonFB(66,"",R.drawable.machop, "Machop", "Muy poderoso a pesar de su pequeño tamaño. Su maestría en artes marciales lo hace muy duro.", listOf(PokemonTipoFB.LUCHA)),
    PokemonFB(67,"",R.drawable.machoke, "Machoke", "El cinturón que rodea su cintura retiene toda su energía. Sin él, este Pokémon sería implacable.", listOf(PokemonTipoFB.LUCHA)),
    PokemonFB(68,"",R.drawable.machamp, "Machamp", "Con sólo un brazo puede mover montañas. Usando los cuatro, este Pokémon puede ser terrible.", listOf(PokemonTipoFB.LUCHA)),
    PokemonFB(69,"",R.drawable.bellsprout, "Bellsprout", "Prefiere los lugares calientes y húmedos. Atrapa pequeños insectos con sus ramas para devorarlos.", listOf(PokemonTipoFB.PLANTA, PokemonTipoFB.VENENO)),
    PokemonFB(70,"",R.drawable.weepinbell, "Weepinbell", "Cuando está hambriento, ataca a todo lo que se mueva. Su pobre presa se derrite en fuertes ácidos.", listOf(PokemonTipoFB.PLANTA, PokemonTipoFB.VENENO)),
    PokemonFB(71,"",R.drawable.victreebel, "Victreebel", "Engaña a su presa con un dulce aroma a miel. Una vez atrapada, la presa perderá hasta sus huesos.", listOf(PokemonTipoFB.PLANTA, PokemonTipoFB.VENENO)),
    PokemonFB(72,"",R.drawable.tentacool, "Tentacool", "A veces puede ser encontrado seco y medio enterrado en una playa. Al lanzarlo otra vez al mar revivirá.", listOf(PokemonTipoFB.AGUA, PokemonTipoFB.VENENO)),
    PokemonFB(73,"",R.drawable.tentacruel, "Tentacruel", "Puede controlar libremente sus 80 tentáculos. Éstos debilitan a la presa con su poderoso veneno.", listOf(PokemonTipoFB.AGUA, PokemonTipoFB.VENENO)),
    PokemonFB(74,"",R.drawable.geodude, "Geodude", "Se encuentran normalmente en los caminos de montaña. Si te cruzas con uno, se enfadará.", listOf(PokemonTipoFB.ROCA, PokemonTipoFB.TIERRA)),
    PokemonFB(75,"",R.drawable.graveler, "Graveler", "Se le suele ver rodando por las montañas. Los obstáculos no los evita. ¡Los arrolla!", listOf(PokemonTipoFB.ROCA, PokemonTipoFB.TIERRA)),
    PokemonFB(76,"",R.drawable.golem, "Golem", "Cuando pierde su piel, su cuerpo se vuelve blando y blanquecino. Si esto ocurre, se esconderá.", listOf(PokemonTipoFB.ROCA, PokemonTipoFB.TIERRA)),
    PokemonFB(77,"",R.drawable.ponyta, "Ponyta", "Es capaz de saltar muy alto. Con sus pezuñas y sus robustas patas, absorbe el impacto.", listOf(PokemonTipoFB.FUEGO)),
    PokemonFB(78,"",R.drawable.rapidash, "Rapidash", "Le encanta correr. Si ve algo más rápido que él, intentará alcanzarlo a toda velocidad.", listOf(PokemonTipoFB.FUEGO)),
    PokemonFB(79,"",R.drawable.slowpoke, "Slowpoke", "Es increíblemente lento y perezoso. Le encanta dormir sin preocuparse ni del tiempo ni de lo que ocurra.", listOf(PokemonTipoFB.AGUA, PokemonTipoFB.PSIQUICO)),
    PokemonFB(80,"",R.drawable.slowbro, "Slowbro", "Vive tranquilo en el mar. Si el Shellder de su cola se cae, vuelve a ser un Slowpoke otra vez.", listOf(PokemonTipoFB.AGUA, PokemonTipoFB.PSIQUICO)),
    PokemonFB(81,"",R.drawable.magnemite, "Magnemite", "Puede desafiar a la gravedad desde su nacimiento. Flota en el aire gracias a ondas electromagnéticas.", listOf(PokemonTipoFB.ELECTRICO, PokemonTipoFB.ACERO)),
    PokemonFB(82,"",R.drawable.magneton, "Magneton", "Genera extrañas señales de radio. Es capaz de elevar la temperatura 3º centígrados.", listOf(PokemonTipoFB.ELECTRICO, PokemonTipoFB.ACERO)),
    PokemonFB(83,"",R.drawable.farfetchd, "Farfetch'd", "Vive cerca de las plantas. Son raramente vistos, así que se piensa que se están extinguiendo.", listOf(PokemonTipoFB.NORMAL, PokemonTipoFB.VOLADOR)),
    PokemonFB(84,"",R.drawable.doduo, "Doduo", "Sus cortas alas lo hacen volar con dificultad. De todos modos, puede correr a gran velocidad.", listOf(PokemonTipoFB.NORMAL, PokemonTipoFB.VOLADOR)),
    PokemonFB(85,"",R.drawable.dodrio, "Dodrio", "Una de las dos cabezas de Doduo se divide para formar un nuevo PkMn. Es capaz de correr a 40 KPH.", listOf(PokemonTipoFB.NORMAL, PokemonTipoFB.VOLADOR)),
    PokemonFB(86,"",R.drawable.seel, "Seel", "A este Pokémon le encanta el frío. Le encanta nadar en climas polares, sea cual sea la temperatura.", listOf(PokemonTipoFB.AGUA)),
    PokemonFB(87,"",R.drawable.dewgong, "Dewgong", "Su cuerpo es como una bola de nieve. Inmune al frío intenso, nada rápidamente en aguas heladas.", listOf(PokemonTipoFB.AGUA, PokemonTipoFB.HIELO)),
    PokemonFB(88,"",R.drawable.grimer, "Grimer", "Está hecho de fango endurecido. Huele a pútrido. ¡Por donde pasa, no crece la hierba!", listOf(PokemonTipoFB.VENENO)),
    PokemonFB(89,"",R.drawable.muk, "Muk", "Huele tan mal que puede provocar desmayos. Ha degenerado tanto, que ya ni él mismo se huele.", listOf(PokemonTipoFB.VENENO)),
    PokemonFB(90,"",R.drawable.shellder, "Shellder", "Su concha puede evitar cualquier ataque. El débil cuerpo sólo está expuesto cuando está abierta.", listOf(PokemonTipoFB.AGUA)),
    PokemonFB(91,"",R.drawable.cloyster, "Cloyster", "Utiliza su concha para protegerse. Dicen que es más dura que el diamante. También lanza espinas.", listOf(PokemonTipoFB.AGUA, PokemonTipoFB.HIELO)),
    PokemonFB(92,"",R.drawable.gastly, "Gastly", "Solo aparece en edificios en ruinas. No tiene forma real, ya que parece que está hecho de gas.", listOf(PokemonTipoFB.FANTASMA, PokemonTipoFB.VENENO)),
    PokemonFB(93,"",R.drawable.haunter, "Haunter", "Toma la vida de su adversario a lengüetazos. Esto produce mareos hasta que la víctima fallece.", listOf(PokemonTipoFB.FANTASMA, PokemonTipoFB.VENENO)),
    PokemonFB(94,"",R.drawable.gengar, "Gengar", "Sabrás que un Gengar está cerca cuando sufras de sudores fríos. Intentará echarte un hechizo.", listOf(PokemonTipoFB.FANTASMA, PokemonTipoFB.VENENO)),
    PokemonFB(95,"",R.drawable.onix, "Onix", "Cava a gran velocidad en busca de comida. Los túneles que deja son usados por los Diglett.", listOf(PokemonTipoFB.ROCA, PokemonTipoFB.TIERRA)),
    PokemonFB(96,"",R.drawable.drowzee, "Drowzee", "Si duermes cerca de uno todo el tiempo, en alguna ocasión podrás ver sueños que se haya comido antes.", listOf(PokemonTipoFB.PSIQUICO)),
    PokemonFB(97,"",R.drawable.hypno, "Hypno", "Intenta evitar cualquier tipo de contacto visual con este Pokémon. Puede hipnotizar con su péndulo.", listOf(PokemonTipoFB.PSIQUICO)),
    PokemonFB(98,"",R.drawable.krabby, "Krabby", "Sus pinzas son armas perfectas. En alguna ocasión pueden romperse en combate, pero crecerán rápido.", listOf(PokemonTipoFB.AGUA)),
    PokemonFB(99,"",R.drawable.kingler, "Kingler", "Una de sus pinzas crece más que la otra, y es dura como el acero. De todos modos, pesa demasiado.", listOf(PokemonTipoFB.AGUA)),
    PokemonFB(100,"",R.drawable.voltorb, "Voltorb", "Se dice que se camufla como una Poké Ball. Al más mínimo estímulo se autodestruirá.", listOf(PokemonTipoFB.ELECTRICO)),
    PokemonFB(101,"",R.drawable.electrode, "Electrode", "Almacena energía eléctrica en su cuerpo. El más leve shock puede provocar una gran explosión.", listOf(PokemonTipoFB.ELECTRICO)),
    PokemonFB(102,"",R.drawable.exeggcute, "Exeggcute", "Sus cabezas se atraen unas a otras, y giran entre sí. Debe tener seis para equilibrarse.", listOf(PokemonTipoFB.PLANTA, PokemonTipoFB.PSIQUICO)),
    PokemonFB(103,"",R.drawable.exeggutor, "Exeggutor", "Este Pokémon es muy ruidoso. Esto es debido a que cada una de sus cabezas hace lo que quiere.", listOf(PokemonTipoFB.PLANTA, PokemonTipoFB.PSIQUICO)),
    PokemonFB(104,"",R.drawable.cubone, "Cubone", "Siempre lleva el cráneo de su difunta madre. Su grito hace eco y parece una triste melodía.", listOf(PokemonTipoFB.TIERRA)),
    PokemonFB(105,"",R.drawable.marowak, "Marowak", "Pequeño y débil, este Pokémon siempre va acompañado de su palo de hueso de Pokémon.", listOf(PokemonTipoFB.TIERRA)),
    PokemonFB(106,"",R.drawable.hitmonlee, "Hitmonlee", "Cuando da patadas al enemigo, la planta de sus pies se vuelve tan dura como el diamante.", listOf(PokemonTipoFB.LUCHA)),
    PokemonFB(107,"",R.drawable.hitmonchan, "Hitmonchan", "Sus golpes se asemejan a una taladradora. Puede atravesar un muro de hormigón como si nada.", listOf(PokemonTipoFB.LUCHA)),
    PokemonFB(108,"",R.drawable.lickitung, "Lickitung", "Su lengua mide casi dos metros y se mueve libremente. Sus lametazos pueden causar parálisis.", listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(109,"",R.drawable.koffing, "Koffing", "A veces puede explotar sin avisar, ya que en lugares calurosos su gas interno se expande.", listOf(PokemonTipoFB.VENENO)),
    PokemonFB(110,"",R.drawable.weezing, "Weezing", "Este Pokémon vive absorbiendo gases venenosos, gérmenes, y el polvo que existe en la basura.", listOf(PokemonTipoFB.VENENO)),
    PokemonFB(111,"",R.drawable.rhyhorn, "Rhyhorn", "Este Pokémon no tiene muchas luces. Una vez inicia la carga, no para hasta que cae dormido.", listOf(PokemonTipoFB.TIERRA, PokemonTipoFB.ROCA)),
    PokemonFB(112,"",R.drawable.rhydon, "Rhydon", "Camina sobre sus patas traseras, y muestra signos de inteligencia. Es capaz de aguantar lava hirviendo.", listOf(PokemonTipoFB.TIERRA, PokemonTipoFB.ROCA)),
    PokemonFB(113,"",R.drawable.chansey, "Chansey", "Este amable Pokémon es capaz de compartir sus nutrientes huevos con un Pokémon herido.", listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(114,"",R.drawable.tangela, "Tangela", "Se camufla tras una gran masa de enredaderas azules. Se dice que nunca dejan de crecer.", listOf(PokemonTipoFB.PLANTA)),
    PokemonFB(115,"",R.drawable.kangaskhan, "Kangaskhan", "Cuida de su cría en la bolsa de su tripa. No evitará ninguna pelea para protegerla.", listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(116,"",R.drawable.horsea, "Horsea", "Si se siente en peligro, arrojará un potente chorro de agua, o de una tinta especial, por su boca.", listOf(PokemonTipoFB.AGUA)),
    PokemonFB(117,"",R.drawable.seadra, "Seadra", "Tocar su aleta trasera causa parálisis. Se engancha al coral para mantenerse mientras duerme.", listOf(PokemonTipoFB.AGUA)),
    PokemonFB(118,"",R.drawable.goldeen, "Goldeen", "En su época de puesta de huevos, suelen ser vistos nadando por ríos contracorriente en grandes grupos.", listOf(PokemonTipoFB.AGUA)),
    PokemonFB(119,"",R.drawable.seaking, "Seaking", "Este Pokémon hace sus nidos tallando cantos de riachuelo con el cuerno de su cabeza.", listOf(PokemonTipoFB.AGUA)),
    PokemonFB(120,"",R.drawable.staryu, "Staryu", "Mientras su parte central se mantenga intacta, crecerá de nuevo aunque haya sido destrozado.", listOf(PokemonTipoFB.AGUA)),
    PokemonFB(121,"",R.drawable.starmie, "Starmie", "Su zona central es conocida como el núcleo. Se piensa que se comunica mediante colores.", listOf(PokemonTipoFB.AGUA, PokemonTipoFB.PSIQUICO)),
    PokemonFB(122,"",R.drawable.mrmime, "Mr. Mime", "Siempre practica la misma pantomima. Hace creer al enemigo que existe algo que no es real.", listOf(PokemonTipoFB.PSIQUICO, PokemonTipoFB.HADA)),
    PokemonFB(123,"",R.drawable.scyther, "Scyther", "Se agazapa en la hierba alta para saltar sobre su enemigo con sus guadañas. Se mueve como un ninja.", listOf(PokemonTipoFB.BICHO, PokemonTipoFB.VOLADOR)),
    PokemonFB(124,"",R.drawable.jynx, "Jynx", "Parece moverse como si estuviera bailando un ritmo de su propia creación. Menea mucho sus caderas.", listOf(PokemonTipoFB.HIELO, PokemonTipoFB.PSIQUICO)),
    PokemonFB(125,"",R.drawable.electabuzz, "Electabuzz", "Cuando hay un apagón, es más que posible que este Pokémon se haya comido la energía.", listOf(PokemonTipoFB.ELECTRICO)),
    PokemonFB(126,"",R.drawable.magmar, "Magmar", "Nacen en volcanes activos. Su cuerpo parece una gran bola de fuego ya que están en llamas.", listOf(PokemonTipoFB.FUEGO)),
    PokemonFB(127,"",R.drawable.pinsir, "Pinsir", "Atrapa a su presa con sus pinzas, y aprieta fuerte. No se puede mover si hace mucho frío.", listOf(PokemonTipoFB.BICHO)),
    PokemonFB(128,"",R.drawable.tauros, "Tauros", "Un rudo Pokémon repleto de energía vital. Cuando corre, no para hasta que choca con algo.", listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(129,"",R.drawable.magikarp, "Magikarp", "Famoso por ser poco fiable. Puede encontrarse nadando en mares, lagos, ríos y charcos.", listOf(PokemonTipoFB.AGUA)),
    PokemonFB(130,"",R.drawable.gyarados, "Gyarados", "Este Pokémon es enormemente destructivo. En la antigüedad, era conocido por destruir ciudades.", listOf(PokemonTipoFB.AGUA, PokemonTipoFB.VOLADOR)),
    PokemonFB(131,"",R.drawable.lapras, "Lapras", "Este espíritu gentil es capaz de leer la mente. Puede llevar a la gente a través del mar.", listOf(PokemonTipoFB.AGUA, PokemonTipoFB.HIELO)),
    PokemonFB(132,"",R.drawable.ditto, "Ditto", "Cuando se fija en un enemigo, su cuerpo se transforma en una copia perfecta del mismo.", listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(133,"",R.drawable.eevee, "Eevee", "Su código genético es muy inestable. Puede evolucionar en diversas razas de Pokémon.", listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(134,"",R.drawable.vaporeon, "Vaporeon", "Su estructura celular se parece a las moléculas de agua. Es invisible cuando está en el agua.", listOf(PokemonTipoFB.AGUA)),
    PokemonFB(135,"",R.drawable.jolteon, "Jolteon", "Un Pokémon muy sensible. Se entristece o enfada con mucha facilidad, lo que le da energía.", listOf(PokemonTipoFB.ELECTRICO)),
    PokemonFB(136,"",R.drawable.flareon, "Flareon", "El cuerpo de este Pokémon posee una cámara ígnea. Cuando exhala aire, éste está a 3.000º Celsius.", listOf(PokemonTipoFB.FUEGO)),
    PokemonFB(137,"",R.drawable.porygon, "Porygon", "La gente dice que se trata del único Pokémon que puede volar por el espacio. Aún no lo ha logrado.", listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(138,"",R.drawable.omanyte, "Omanyte", "Este antiguo Pokémon fue recuperado de un fósil. Nada muy bien gracias al movimiento de sus 10 tentáculos.", listOf(PokemonTipoFB.ROCA, PokemonTipoFB.AGUA)),
    PokemonFB(139,"",R.drawable.omastar, "Omastar", "Picos afilados rodean su boca. Su concha es demasiado grande como para que se mueva libremente.", listOf(PokemonTipoFB.ROCA, PokemonTipoFB.AGUA)),
    PokemonFB(140,"",R.drawable.kabuto, "Kabuto", "Este Pokémon fue recuperado desde un fósil. Usa los ojos de su espalda al ocultarse en el lecho marino.", listOf(PokemonTipoFB.ROCA, PokemonTipoFB.AGUA)),
    PokemonFB(141,"",R.drawable.kabutops, "Kabutops", "Este Pokémon es un hábil y rápido nadador. Atrapa a su presa para drenar sus fluidos vitales.", listOf(PokemonTipoFB.ROCA, PokemonTipoFB.AGUA)),
    PokemonFB(142,"",R.drawable.aerodactyl, "Aerodactyl", "Este Pokémon salvaje, extinto hace siglos, fue resucitado usando ADN tomado de un ámbar.", listOf(PokemonTipoFB.ROCA, PokemonTipoFB.VOLADOR)),
    PokemonFB(143,"",R.drawable.snorlax, "Snorlax", "Come cualquier cosa. Incluso la comida pasada de fecha. Su estómago nunca se llena.", listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(144,"",R.drawable.articuno, "Articuno", "Un legendario pájaro Pokémon. Congela el agua que encuentra en el aire para generar nieve.", listOf(PokemonTipoFB.HIELO, PokemonTipoFB.VOLADOR)),
    PokemonFB(145,"",R.drawable.zapdos, "Zapdos", "Este legendario pájaro Pokémon solo aparece cuando el cielo se torna oscuro y caen rayos.", listOf(PokemonTipoFB.ELECTRICO, PokemonTipoFB.VOLADOR)),
    PokemonFB(146,"",R.drawable.moltres, "Moltres", "Un legendario pájaro Pokémon. Cuando aletea sus flamígeras alas, la oscura noche se torna roja.", listOf(PokemonTipoFB.FUEGO, PokemonTipoFB.VOLADOR)),
    PokemonFB(147,"",R.drawable.dratini, "Dratini", "La existencia de este Pokémon ha sido confirmada recientemente por un pescador que cogió uno.", listOf(PokemonTipoFB.DRAGON)),
    PokemonFB(148,"",R.drawable.dragonair, "Dragonair", "De acuerdo con un testigo, un aura de extraña forma lo rodea, dándole un misterioso y místico aspecto.", listOf(PokemonTipoFB.DRAGON)),
    PokemonFB(149,"",R.drawable.dragonite, "Dragonite", "Se dice que este Pokémon vive en algún lugar del mar, y que vuela. De todos modos, sólo es un rumor.", listOf(PokemonTipoFB.DRAGON, PokemonTipoFB.VOLADOR)),
    PokemonFB(150,"",R.drawable.mewtwo, "Mewtwo", "Fue creado por un científico tras años de horribles experimentos de manipulación genética.", listOf(PokemonTipoFB.PSIQUICO)),
    PokemonFB(151,"",R.drawable.mew, "Mew", "Se dice que contiene la composición genética de todos los Pokémon. Es muy raramente visto.", listOf(PokemonTipoFB.PSIQUICO)),
    PokemonFB(152,"",R.drawable.chikorita, "Chikorita","Un dulce aroma se desprende de la hoja de su cabeza. Es dócil y le encanta absorber los rayos de sol.",listOf(PokemonTipoFB.PLANTA)),
    PokemonFB(153,"",R.drawable.bayleef, "Bayleef","Su cuello huele a especias. Dicen que por alguna razón, su simple olor te incita a luchar.",listOf(PokemonTipoFB.PLANTA)),
    PokemonFB(154,"",R.drawable.meganium, "Meganium","El olor que desprenden sus pétalos contiene una sustancia que calma el instinto agresivo.",listOf(PokemonTipoFB.PLANTA)),
    PokemonFB(155,"",R.drawable.cyndaquil, "Cyndaquil","Es tímido y siempre se enrosca como una pelota. Si es atacado, enciende el lomo para protegerse.",listOf(PokemonTipoFB.FUEGO)),
    PokemonFB(156,"",R.drawable.quilava, "Quilava","Ten cuidado si te da la espalda en combate. Significa que te va a atacar con su lomo de fuego.",listOf(PokemonTipoFB.FUEGO)),
    PokemonFB(157,"",R.drawable.typhlosion, "Typhlosion","Si su furia crece, se calienta tanto que cualquier cosa que toque se prenderá al instante.",listOf(PokemonTipoFB.FUEGO)),
    PokemonFB(158,"",R.drawable.totodile, "Totodile","Sus desarrolladas y potentes fauces puede romper cualquier cosa. Su Entrenador debe tener cuidado.",listOf(PokemonTipoFB.AGUA)),
    PokemonFB(159,"",R.drawable.croconaw, "Croconaw","Si pierde un colmillo, uno nuevo crecerá en su lugar. Hay siempre 48 colmillos revistiendo su boca.",listOf(PokemonTipoFB.AGUA)),
    PokemonFB(160,"",R.drawable.feraligatr, "Feraligatr","Le cuesta soportar su propio peso fuera del agua, así que va a cuatro patas. Aún así es rápido.",listOf(PokemonTipoFB.AGUA)),
    PokemonFB(161,"",R.drawable.sentret, "Sentret","Es un Pokémon muy precavido. Se levanta apoyándose en la cola para tener una mejor vista de los alrededores.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(162,"",R.drawable.furret, "Furret","Construye un nido donde introducir su largo y delgado cuerpo, en el que no pueden entrar otros Pokémon.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(163,"",R.drawable.hoothoot, "Hoothoot","Se apoya en una sola pata y cuando hace el cambio, se mueve tan rápido que apenas se nota.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.VOLADOR)),
    PokemonFB(164,"",R.drawable.noctowl, "Noctowl","Sus ojos se adaptan muy bien a la oscuridad; cuando hay poca luz, la condensan para poder ver.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.VOLADOR)),
    PokemonFB(165,"",R.drawable.ledyba, "Ledyba","Es muy tímido. Tiene miedo de moverse cuando va solo. Pero si va en grupo, se vuelve muy activo.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.VOLADOR)),
    PokemonFB(166,"",R.drawable.ledian, "Ledian","Se nutre de la luz de las estrellas. Cuanto más estrellada está la noche, más crecen los dibujos de su lomo.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.VOLADOR)),
    PokemonFB(167,"",R.drawable.spinarak, "Spinarak","Mantiene la misma postura en su telaraña durante días, esperando a que se acerque una presa inocente.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.VENENO)),
    PokemonFB(168,"",R.drawable.ariados, "Ariados","Pega hilos de seda a sus presas y las libera para seguirlas más tarde y localizar también a sus amigos.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.VENENO)),
    PokemonFB(169,"",R.drawable.crobat, "Crobat","Es tan silencioso cuando vuela en la oscuridad con sus cuatro alas, que cuesta percibirlo cuando se acerca.",listOf(PokemonTipoFB.VENENO,PokemonTipoFB.VOLADOR)),
    PokemonFB(170,"",R.drawable.chinchou, "Chinchou","Libera cargas positivas y negativas entre las puntas de las dos antenas que tiene, y electrocuta al enemigo.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.ELECTRICO)),
    PokemonFB(171,"",R.drawable.lanturn, "Lanturn","La luz que emite es tan brillante que puede iluminar la superficie del mar desde unos 5 km de profundidad.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.ELECTRICO)),
    PokemonFB(172,"",R.drawable.pichu, "Pichu","Todavía no domina el almacenamiento de electricidad, y descarga rayos cuando se divierte o se asusta.",listOf(PokemonTipoFB.ELECTRICO)),
    PokemonFB(173,"",R.drawable.cleffa, "Cleffa","Por su inusual forma estrellada, la gente cree que procede de un meteorito que cayó a la tierra.",listOf(PokemonTipoFB.HADA)),
    PokemonFB(174,"",R.drawable.igglybuff, "Igglybuff","Su cuerpo es muy blando. Cuando se pone a rodar, rebota contra todo y es imposible de parar.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.HADA)),
    PokemonFB(175,"",R.drawable.togepi, "Togepi","El cascarón parece estar lleno de alegría. Dicen que trae buena suerte si se le trata con cariño.",listOf(PokemonTipoFB.HADA)),
    PokemonFB(176,"",R.drawable.togetic, "Togetic","Dicen que aparece entre gentes cuidadosas y de buen corazón, a quienes inunda de felicidad.",listOf(PokemonTipoFB.HADA,PokemonTipoFB.VOLADOR)),
    PokemonFB(177,"",R.drawable.natu, "Natu","Va dando saltitos porque sus alas no han crecido lo suficiente. Siempre está pendiente de algo.",listOf(PokemonTipoFB.PSIQUICO,PokemonTipoFB.VOLADOR)),
    PokemonFB(178,"",R.drawable.xatu, "Xatu","Dicen que se mantiene quieto y en silencio porque observa el pasado y el futuro al mismo tiempo.",listOf(PokemonTipoFB.PSIQUICO,PokemonTipoFB.VOLADOR)),
    PokemonFB(179,"",R.drawable.mareep, "Mareep","Cuando almacena electricidad en su organismo, duplica su volumen. Tócalo y recibirás una descarga.",listOf(PokemonTipoFB.ELECTRICO)),
    PokemonFB(180,"",R.drawable.flaaffy, "Flaaffy","Como almacena tanta electricidad, ha desarrollado parches donde no crece ni la lana.",listOf(PokemonTipoFB.ELECTRICO)),
    PokemonFB(181,"",R.drawable.ampharos, "Ampharos","El brillo de su cola es visible desde lejos. En la antigüedad se usaba mucho como faro.",listOf(PokemonTipoFB.ELECTRICO)),
    PokemonFB(182,"",R.drawable.bellossom, "Bellossom","Los Bellossom suelen reunirse para bailar. Dicen que sus danzas son un ritual para invocar al sol.",listOf(PokemonTipoFB.PLANTA)),
    PokemonFB(183,"",R.drawable.marill, "Marill","Usa el extremo de su cola como boya, así no se ahoga aunque lo arrastre una fuerte corriente.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.HADA)),
    PokemonFB(184,"",R.drawable.azumarill, "Azumarill","Guardando silencio y prestando mucha atención puede saber lo que hay en los rápidos y salvajes ríos.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.HADA)),
    PokemonFB(185,"",R.drawable.sudowoodo, "Sudowoodo","Aunque pretende ser un árbol, en su composición se parece más a una roca que a una planta.",listOf(PokemonTipoFB.ROCA)),
    PokemonFB(186,"",R.drawable.politoed, "Politoed","Si Poliwag y Poliwhirl oyen su grito, responderán y se reunirán estén donde estén.",listOf(PokemonTipoFB.AGUA)),
    PokemonFB(187,"",R.drawable.hoppip, "Hoppip","Para evitar ser arrastrados por el viento, se reúnen en grupos, aunque adoran las brisas suaves.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.VOLADOR)),
    PokemonFB(188,"",R.drawable.skiploom, "Skiploom","Abre sus pétalos para absorber la luz solar. También flota en el aire para estar más cerca del sol.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.VOLADOR)),
    PokemonFB(189,"",R.drawable.jumpluff, "Jumpluff","Se desplaza con los vientos estacionales y suelta sus esporas por todo el mundo para reproducirse.",listOf(PokemonTipoFB.PLANTA,PokemonTipoFB.VOLADOR)),
    PokemonFB(190,"",R.drawable.aipom, "Aipom","Vive en las copas de árboles gigantes. Mientras duerme, enrolla la cola en una rama para no caerse.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(191,"",R.drawable.sunkern, "Sunkern","Cae de repente del cielo por las mañanas. Los años de veranos suaves su número se multiplica.",listOf(PokemonTipoFB.PLANTA)),
    PokemonFB(192,"",R.drawable.sunflora, "Sunflora","Convierte la luz solar en energía. En la oscuridad, tras el atardecer, cierra sus pétalos y queda inmóvil.",listOf(PokemonTipoFB.PLANTA)),
    PokemonFB(193,"",R.drawable.yanma, "Yanma","Si agita muy rápido las alas, genera ondas expansivas capaces de hacer añicos las ventanas que haya cerca.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.VOLADOR)),
    PokemonFB(194,"",R.drawable.wooper, "Wooper","Cuando anda por la tierra cubre su cuerpo con una capa venenosa para mantener hidratada su piel.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.TIERRA)),
    PokemonFB(195,"",R.drawable.quagsire, "Quagsire","Este despreocupado Pokémon es de naturaleza tranquila. Siempre que nada, se choca con los barcos.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.TIERRA)),
    PokemonFB(196,"",R.drawable.espeon, "Espeon","Basándose en las corrientes de aire predice cosas como el clima o el próximo ataque del enemigo.",listOf(PokemonTipoFB.PSIQUICO)),
    PokemonFB(197,"",R.drawable.umbreon, "Umbreon","Cuando oscurece, los anillos de su cuerpo comienzan a brillar, asustando a cualquiera que se acerque.",listOf(PokemonTipoFB.SINIESTRO)),
    PokemonFB(198,"",R.drawable.murkrow, "Murkrow","Temido y odiado por muchos, dicen que trae la desgracia a todos aquellos que lo ven por la noche.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.VOLADOR)),
    PokemonFB(199,"",R.drawable.slowking, "Slowking","Al ser mordido en la cabeza, Slowpoke absorbió unas toxinas que liberaron su poder oculto.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.PSIQUICO)),
    PokemonFB(200,"",R.drawable.misdreavus, "Misdreavus","Le gusta hacer travesuras como gritar y aullar por la noche, para asustar a la gente.",listOf(PokemonTipoFB.FANTASMA)),
    PokemonFB(201,"",R.drawable.unown, "Unown","Su cuerpo fino y plano aparece siempre en los muros. Su forma parece tener algún significado.",listOf(PokemonTipoFB.PSIQUICO)),
    PokemonFB(202,"",R.drawable.wobbuffet, "Wobbuffet","Para mantener oculta su negra cola, vive en silencio en la oscuridad. Nunca ataca primero.",listOf(PokemonTipoFB.PSIQUICO)),
    PokemonFB(203,"",R.drawable.girafarig, "Girafarig","La cola, que también tiene un pequeño cerebro, muerde por su cuenta si nota un olor seductor.",listOf(PokemonTipoFB.NORMAL,PokemonTipoFB.PSIQUICO)),
    PokemonFB(204,"",R.drawable.pineco, "Pineco","Le gusta engrosar su coraza añadiendo cortezas de árbol. El aumento de peso no le molesta.",listOf(PokemonTipoFB.BICHO)),
    PokemonFB(205,"",R.drawable.forretress, "Forretress","Todo su cuerpo está protegido por una concha de metal. Lo que esconde la concha es un misterio.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.ACERO)),
    PokemonFB(206,"",R.drawable.dunsparce, "Dunsparce","Este Pokémon escapa perforando el suelo con la cola y enterrándose de espaldas, si es descubierto.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(207,"",R.drawable.gligar, "Gligar","A veces se sujeta a los precipicios. Cuando divisa una presa, despliega las alas y planea para atacar.",listOf(PokemonTipoFB.TIERRA,PokemonTipoFB.VOLADOR)),
    PokemonFB(208,"",R.drawable.steelix, "Steelix","Su cuerpo ha sido comprimido en el interior de la tierra, y por eso es hasta más duro que el diamante.",listOf(PokemonTipoFB.TIERRA,PokemonTipoFB.ACERO)),
    PokemonFB(209,"",R.drawable.snubbull, "Snubbull","Muy travieso por naturaleza, a muchas mujeres les gusta jugar con él porque es muy cariñoso.",listOf(PokemonTipoFB.HADA)),
    PokemonFB(210,"",R.drawable.granbull, "Granbull","Como le pesan mucho los colmillos, se le va la cabeza hacia delante. Su mordisco es muy potente.",listOf(PokemonTipoFB.HADA)),
    PokemonFB(211,"",R.drawable.qwilfish, "Qwilfish","Las pequeñas púas que cubren su cuerpo eran escamas. Inyectan una toxina que debilita.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.VENENO)),
    PokemonFB(212,"",R.drawable.scizor, "Scizor","Mueve sus pinzas para asustar al enemigo. Por los dibujos de su cuerpo parece tener 3 cabezas.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.ACERO)),
    PokemonFB(213,"",R.drawable.shuckle, "Shuckle","Suele ser dócil, pero si se le molesta mientras succiona miel, perseguirá con su cuerno al intruso.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.ROCA)),
    PokemonFB(214,"",R.drawable.heracross, "Heracross","Forman grupos en los bosques para buscar savia de árboles, su comida favorita. Puede voltear a su presa.",listOf(PokemonTipoFB.BICHO,PokemonTipoFB.LUCHA)),
    PokemonFB(215,"",R.drawable.sneasel, "Sneasel","Se alimenta de huevos robados en nidos. Clava sus afiladas garras en los puntos débiles de sus rivales.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.HIELO)),
    PokemonFB(216,"",R.drawable.teddiursa, "Teddiursa","Cuando encuentra miel, le brilla la marca que tiene en la frente. Si se llena las garras de miel, se las lame.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(217,"",R.drawable.ursaring, "Ursaring","Capaz de percibir cualquier tipo de aroma, encuentra sin problemas todo alimento enterrado bajo tierra.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(218,"",R.drawable.slugma, "Slugma","No duerme nunca. Tiene que seguir moviéndose porque si se detiene, su cuerpo de lava podría enfriarse.",listOf(PokemonTipoFB.FUEGO)),
    PokemonFB(219,"",R.drawable.magcargo, "Magcargo","En ocasiones, lanza por la resbaladiza coraza que tiene intensas llamaradas que recorren todo su cuerpo.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.ROCA)),
    PokemonFB(220,"",R.drawable.swinub, "Swinub","Si percibe un aroma tentador, se tira de cabeza para encontrar el origen de dicho olor.",listOf(PokemonTipoFB.HIELO,PokemonTipoFB.TIERRA)),
    PokemonFB(221,"",R.drawable.piloswine, "Piloswine","Como su largo vello corporal le impide ver con claridad, sigue atacando repetidamente.",listOf(PokemonTipoFB.HIELO,PokemonTipoFB.TIERRA)),
    PokemonFB(222,"",R.drawable.corsola, "Corsola","Tiene muy buena puntería. Dispara agua a sus presas, hasta cuando se mueven, a más de 100 metros.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.ROCA)),
    PokemonFB(223,"",R.drawable.remoraid, "Remoraid","En ocasiones, lanza por la resbaladiza coraza que tiene intensas llamaradas que recorren todo su cuerpo.",listOf(PokemonTipoFB.AGUA)),
    PokemonFB(224,"",R.drawable.octillery, "Octillery","Instintivamente se escabulle entre las rocas. Si le entra sueño, robará la guarida de otro Octillery.",listOf(PokemonTipoFB.AGUA)),
    PokemonFB(225,"",R.drawable.delibird, "Delibird","Anida en el borde de escarpados acantilados. Se pasa todo el día llevando comida a sus polluelos.",listOf(PokemonTipoFB.HIELO,PokemonTipoFB.VOLADOR)),
    PokemonFB(226,"",R.drawable.mantine, "Mantine","Nada con gran elegancia e ignora a los Remoraid que se aferran a sus aletas buscando restos de comida.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.VOLADOR)),
    PokemonFB(227,"",R.drawable.skarmory, "Skarmory","Sus fuertes alas parecen pesadas, aunque son huecas y ligeras, y le permiten volar libremente.",listOf(PokemonTipoFB.ACERO,PokemonTipoFB.VOLADOR)),
    PokemonFB(228,"",R.drawable.houndour, "Houndour","Usa diferentes tipos de gritos para comunicarse con los de su especie o para seguir a su presa.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.FUEGO)),
    PokemonFB(229,"",R.drawable.houndoom, "Houndoom","Hace mucho, la gente creía que sus horripilantes aullidos eran de la muerte personificada.",listOf(PokemonTipoFB.SINIESTRO,PokemonTipoFB.FUEGO)),
    PokemonFB(230,"",R.drawable.kingdra, "Kingdra","Duerme en el fondo del océano para recargarse de energía. Dicen que causa tornados cuando se levanta.",listOf(PokemonTipoFB.AGUA,PokemonTipoFB.DRAGON)),
    PokemonFB(231,"",R.drawable.phanpy, "Phanpy","A pesar de su tamaño reducido, es tan fuerte que puede llevar a un humano a su espalda con facilidad.",listOf(PokemonTipoFB.TIERRA)),
    PokemonFB(232,"",R.drawable.donphan, "Donphan","Cuanto más grandes son sus colmillos, mayor su estatus en la manada. Los colmillos tardan mucho en crecer.",listOf(PokemonTipoFB.TIERRA)),
    PokemonFB(233,"",R.drawable.porygon2, "Porygon2","Esta versión mejorada de Porygon fue creada para explorar el espacio, aunque no puede volar.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(234,"",R.drawable.stantler, "Stantler","Su cornamenta cambia el flujo del aire para crear un espacio de realidad distorsionada.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(235,"",R.drawable.smeargle, "Smeargle","La punta de la cola rezuma un fluido especial. Lo pinta todo con este líquido para marcar su terreno.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(236,"",R.drawable.tyrogue, "Tyrogue","Famoso por su disposición a la lucha. Siempre tiene heridas por luchar con enemigos más grandes.",listOf(PokemonTipoFB.LUCHA)),
    PokemonFB(237,"",R.drawable.hitmontop, "Hitmontop","Si te quedas embobado con las suaves, elegantes y danzarinas patadas que da, puedes acabar lleno de magulladuras.",listOf(PokemonTipoFB.LUCHA)),
    PokemonFB(238,"",R.drawable.smoochum, "Smoochum","Sus labios son la parte más sensible de su cuerpo. Siempre los usa para examinar las cosas.",listOf(PokemonTipoFB.HIELO,PokemonTipoFB.PSIQUICO)),
    PokemonFB(239,"",R.drawable.elekid, "Elekid","Entre sus cuernos pasa una débil corriente eléctrica. Quien ponga ahí la mano se dará un calambrazo.",listOf(PokemonTipoFB.ELECTRICO)),
    PokemonFB(240,"",R.drawable.magby, "Magby","Aparece en los cráteres de los volcanes. Puede alcanzar los 600 grados de temperatura, así que no lo subestimes.",listOf(PokemonTipoFB.FUEGO)),
    PokemonFB(241,"",R.drawable.miltank, "Miltank","Se dice que si un niño bebe leche de Miltank crecerá y se convertirá en un adulto sano y campechano.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(242,"",R.drawable.blissey, "Blissey","Cualquiera que pruebe un poco de huevo de Blissey, se volverá más amable y agradable con todos.",listOf(PokemonTipoFB.NORMAL)),
    PokemonFB(243,"",R.drawable.raikou, "Raikou","Las nubes de lluvia que lleva le permiten lanzar rayos a voluntad. Dicen que apareció con un rayo.",listOf(PokemonTipoFB.ELECTRICO)),
    PokemonFB(244,"",R.drawable.entei, "Entei","Cuando ladra, los volcanes entran en erupción. Como no puede controlar su poder, corre siempre en cabeza.",listOf(PokemonTipoFB.FUEGO)),
    PokemonFB(245,"",R.drawable.suicune, "Suicune","Conocido como la reencarnación de los vientos del norte, puede purificar aguas turbias y sucias.",listOf(PokemonTipoFB.AGUA)),
    PokemonFB(246,"",R.drawable.larvitar, "Larvitar","Nace muy profundo en el suelo, y no podrá salir hasta que se haya comido la tierra que le rodea.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.TIERRA)),
    PokemonFB(247,"",R.drawable.pupitar, "Pupitar","Hasta encerrado en su coraza, se mueve libremente. Duro y rápido, su poder destructivo es enorme.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.TIERRA)),
    PokemonFB(248,"",R.drawable.tyranitar, "Tyranitar","Tiene tanta fuerza que puede cambiar el paisaje. Su naturaleza insolente le hace ser muy egoísta.",listOf(PokemonTipoFB.ROCA,PokemonTipoFB.SINIESTRO)),
    PokemonFB(249,"",R.drawable.lugia, "Lugia","Dicen que es el guardián de los mares. Hay rumores de que fue visto en una noche de tormenta.",listOf(PokemonTipoFB.PSIQUICO,PokemonTipoFB.VOLADOR)),
    PokemonFB(250,"",R.drawable.hooh, "Ho-Oh","Cuenta la leyenda que este Pokémon vuela por el cielo con sus magníficas alas de siete colores.",listOf(PokemonTipoFB.FUEGO,PokemonTipoFB.VOLADOR)),
    PokemonFB(251,"",R.drawable.celebi, "Celebi","Este Pokémon vaga por el tiempo. La hierba y los árboles crecen por los campos por donde pasa.",listOf(PokemonTipoFB.PSIQUICO,PokemonTipoFB.PLANTA))
)

