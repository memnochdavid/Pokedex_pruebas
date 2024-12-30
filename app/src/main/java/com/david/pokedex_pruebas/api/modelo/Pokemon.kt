package com.david.pokedex_pruebas.api.modelo

import android.content.Intent
import android.util.Log
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.compose.rememberAsyncImagePainter
import com.david.pokedex_pruebas.R
import com.david.pokedex_pruebas.api.ApiService
import com.david.pokedex_pruebas.api.PokeApiResponse
import com.david.pokedex_pruebas.interfaz.ComposeVistaActivity
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory
import kotlinx.coroutines.flow.asStateFlow
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.david.pokedex_pruebas.modelo.PokemonTipoFB
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.net.URLDecoder

data class Pokemon(
    @Expose @SerializedName("id") val id: Int,
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("base_experience") val baseExperience: Int,
    @Expose @SerializedName("height") val height: Int,
    @Expose @SerializedName("is_default") val isDefault: Boolean,
    @Expose @SerializedName("order") val order: Int,
    @Expose @SerializedName("weight") val weight: Int,
    @Expose @SerializedName("sprites") val sprites: Sprites,
    @Expose @SerializedName("abilities") val abilities: List<Ability>,
    @Expose @SerializedName("forms") val forms: List<Form>,
    @Expose @SerializedName("game_indices") val gameIndices: List<GameIndex>,
    @Expose @SerializedName("held_items") val heldItems: List<HeldItem>,
    @Expose @SerializedName("location_area_encounters") val locationAreaEncounters: String,
    @Expose @SerializedName("moves") val moves: List<Move>,
    @Expose @SerializedName("species") val species: Species,
    @Expose @SerializedName("stats") val stats: List<Stat>,
    @Expose @SerializedName("types") val types: List<Type>,
    @Expose @SerializedName("flavor_text_entries") val flavorTextEntries: List<FlavorTextEntry>,
// added property for the Spanish flavor text entries
    var spanishFlavorTextEntries: List<String> = emptyList()
)

data class FlavorTextEntry(
    @Expose @SerializedName("flavor_text") val flavorText: String,
    @Expose @SerializedName("language") val language: Language
)

data class Language(
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("url") val url: String
)
data class Sprites(
    @Expose @SerializedName("back_default") val backDefault: String?,
    @Expose @SerializedName("back_female") val backFemale: String?,
    @Expose @SerializedName("back_shiny") val backShiny: String?,
    @Expose @SerializedName("back_shiny_female") val backShinyFemale: String?,
    @Expose @SerializedName("front_default") val frontDefault: String?,
    @Expose @SerializedName("front_female") val frontFemale: String?,
    @Expose @SerializedName("front_shiny") val frontShiny: String?,
    @Expose @SerializedName("front_shiny_female") val frontShinyFemale: String?
)

data class Ability(
    @Expose @SerializedName("ability") val ability: AbilityInfo,
    @Expose @SerializedName("is_hidden") val isHidden: Boolean,
    @Expose @SerializedName("slot") val slot: Int
)
data class PokeResult (
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("url") val url: String
)
data class AbilityInfo(
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("url") val url: String
)

data class Form(
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("url") val url: String
)

data class GameIndex(
    @Expose @SerializedName("game_index") val gameIndex: Int,
    @Expose @SerializedName("version") val version: Version
)

data class Version(
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("url") val url: String
)

data class HeldItem(
    @Expose @SerializedName("item") val item: Item,
    @Expose @SerializedName("version_details") val versionDetails: List<VersionDetail>
)

data class Item(
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("url") val url: String
)

data class VersionDetail(
    @Expose @SerializedName("rarity") val rarity: Int,
    @Expose @SerializedName("version") val version: Version
)

data class Move(
    @Expose @SerializedName("move") val move: MoveInfo,
    @Expose @SerializedName("version_group_details") val versionGroupDetails: List<VersionGroupDetail>
)

data class MoveInfo(
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("url") val url: String
)

data class VersionGroupDetail(
    @Expose @SerializedName("level_learned_at") val levelLearnedAt: Int,
    @Expose @SerializedName("move_learn_method") val moveLearnMethod: MoveLearnMethod,
    @Expose @SerializedName("version_group") val versionGroup: VersionGroup
)

data class MoveLearnMethod(
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("url") val url: String
)

data class VersionGroup(
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("url") val url: String
)

data class Species(
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("url") val url: String
)

data class Stat(
    @Expose @SerializedName("base_stat") val baseStat: Int,
    @Expose @SerializedName("effort") val effort: Int,
    @Expose @SerializedName("stat") val stat: StatInfo
)

data class StatInfo(
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("url") val url: String
)

data class Type(
    @Expose @SerializedName("slot") val slot: Int,
    @Expose @SerializedName("type") val type: TypeInfo
)

data class TypeInfo(
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("url") val url: String
)

object RetrofitClient {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/") // Replace with your API base URL
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun create(serviceClass: Class<ApiService>): ApiService {
        return retrofit.create(serviceClass)
    }
}

class PokeInfoViewModel() : ViewModel() {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service: ApiService = retrofit.create(ApiService::class.java)
    val pokemonInfo = MutableLiveData<Pokemon>()

    private val _pokemonList = MutableLiveData<List<Pokemon>>(emptyList())
    val pokemonList: LiveData<List<Pokemon>> = _pokemonList

    private val _spanishDescription = mutableStateOf("")
    val spanishDescription: State<String> = _spanishDescription

    private val _pokemonListByGen = MutableLiveData<List<Pokemon>>(emptyList())
    val pokemonListByGen: LiveData<List<Pokemon>> = _pokemonListByGen

    private val _pokemonTypeList = MutableLiveData<List<Pokemon>>(emptyList())
    val pokemonTypeList: LiveData<List<Pokemon>> = _pokemonTypeList

    fun getPokemonInfo(id: Int){
        val call = service.getPokemonInfo(id)

        call.enqueue(object : Callback<Pokemon> {
            override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
                response.body()?.let { pokemon ->
                    pokemonInfo.postValue(pokemon)
                }
            }

            override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                call.cancel()
            }

        })

    }
    fun getPokemonDescription(id: Int) {
        viewModelScope.launch {
            val callDescription = service.getPokemonSpecies(id)
            try {
                val response = callDescription.awaitResponse()
                if (response.isSuccessful) {
                    val pokemon = response.body()
                    val spanishEntries = pokemon?.flavorTextEntries?.filter { it.language.name == "es" }
                    _spanishDescription.value = spanishEntries?.firstOrNull()?.flavorText ?: ""
                } else {
                    // Handle error
                    Log.e("PokeInfoViewModel", "Error fetching Pokemon description: ${response.errorBody()?.string()}")
                    _spanishDescription.value = "Error loading description"
                }
            } catch (e: Exception) {
                // Handle network or other errors
                Log.e("PokeInfoViewModel", "Error fetching Pokemon description: ${e.message}")
                _spanishDescription.value = "Error loading description"
            }
        }
    }
    fun getPokemonList(pokemonIds: List<Int>) {
        var apiService = RetrofitClient.create(ApiService::class.java)
        viewModelScope.launch {
            try {
                // Fetch Pokemon info for each ID and await the responses
                val pokemonInfoList = pokemonIds.map { id ->
                    apiService.getPokemonInfo(id).awaitResponse().body() // Get the Pokemon object from the response body
                }
                // Update pokemonList LiveData
                _pokemonList.value = pokemonInfoList.filterNotNull() // Filter out null values in case of errors
            } catch (e: Exception) {
                // Handle error
                Log.e("PokeInfoViewModel", "Error fetching Pokemon info: ${e.message}")
            }
        }
    }
    fun getListByGeneration(id: Int) {
        viewModelScope.launch {
            try {
                // 1. Get the generation details
                val generationResponse = service.getGeneration(id).awaitResponse()
                if (generationResponse.isSuccessful) {
                    val generation = generationResponse.body()
                    Log.d("PokeInfoViewModel", "Generation Response: ${generationResponse.body()?.pokemonSpecies}")
                    val pokemonSpecies = generation?.pokemonSpecies ?: emptyList()

                    // 2. Fetch Pokemon details for each species
                    val pokemonInfoList = pokemonSpecies.mapNotNull { species ->
                        val pokemonId = species.url.extractPokemonId() // Extract Pokemon ID from URL
                        if (pokemonId != null) {
                            service.getPokemonInfo(pokemonId).awaitResponse().body()
                        } else {
                            null
                        }
                    }
                    // 3. Sort pokemonInfoList by ID
                    val sortedPokemonList = pokemonInfoList.sortedBy { it.id }

                    // 4. Update pokemonListByGen LiveData with sorted list
                    _pokemonListByGen.value = sortedPokemonList

                    // Update pokemonListByGen LiveData
                    //_pokemonListByGen.value = pokemonInfoList
                    Log.d("PokeInfoViewModel", "Pokemon IDs: ${pokemonSpecies.mapNotNull { it.url.extractPokemonId() }}")
                } else {
                    // Handle error
                    Log.e("PokeInfoViewModel", "Error fetching generation details: ${generationResponse.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                // Handle network or other errors
                Log.e("PokeInfoViewModel", "Error fetching Pokemon list by generation: ${e.message}")
            }
        }
    }
    fun getTypeList() {
        viewModelScope.launch {
            try {
                // 1. Fetch the list of types
                val typeListResponse = service.getTypeList(id = 1).awaitResponse() // Assuming you want to fetch all types, you can use any valid type ID here.

                if (typeListResponse.isSuccessful) {
                    val typeList = typeListResponse.body()
                    Log.d("PokeInfoViewModel", "Type List Response: $typeList")

                    // 2. Extract the type names
                    val typeNames = typeList?.type?.name ?: ""

                    // 3. Fetch Pokemon details for each type
                    val pokemonInfoList = listOf(typeNames).mapNotNull { typeName -> // Create a list with typeNames
                        val pokemonId = typeName.extractPokemonId2() // Call on the typeName variable
                        if (pokemonId != null) {
                            service.getPokemonInfo(pokemonId).awaitResponse().body()
                        } else {
                            null
                        }
                    }
                    // 3. Sort pokemonInfoList by ID
                    val sortedPokemonList = pokemonInfoList.sortedBy { it.id }

                    // 4. Update pokemonListByGen LiveData with sorted list
                    _pokemonTypeList.value = sortedPokemonList

                    // Update pokemonListByGen LiveData
                    //_pokemonListByGen.value = pokemonInfoList
                    //Log.d("PokeInfoViewModel", "Pokemon IDs: ${typeNames.mapNotNull { it.extractPokemonId2() }}")
                } else {
                    // Handle error
                    Log.e("PokeInfoViewModel", "Error fetching type list: ${typeListResponse.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                // Handle network or other errors
                Log.e("PokeInfoViewModel", "Error fetching Pokemon list by type: ${e.message}")
            }
        }
    }
}


fun TypeToDrawableAPI(tipo: Type):Int{
    return when (tipo.type.name) {
        "grass" -> R.drawable.planta
        "water" -> R.drawable.agua
        "fire" -> R.drawable.fuego
        "fighting" -> R.drawable.lucha
        "poison" -> R.drawable.veneno
        "steel" -> R.drawable.acero
        "bug" -> R.drawable.bicho
        "dragon" -> R.drawable.dragon
        "electric" -> R.drawable.electrico
        "fairy" -> R.drawable.hada
        "ice" -> R.drawable.hielo
        "psychic" -> R.drawable.psiquico
        "rock" -> R.drawable.roca
        "ground" -> R.drawable.tierra
        "dark" -> R.drawable.siniestro
        "normal" -> R.drawable.normal
        "flying" -> R.drawable.volador
        "ghost" -> R.drawable.fantasma
        else -> { R.drawable.charmander}
    }
}
fun String.firstMayus(): String {
    return this.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
}
private fun String.extractPokemonId(): Int? {
    if (this.isNullOrEmpty()) return null // Check for null or empty URLs

    val decodedUrl = URLDecoder.decode(this, "UTF-8") // Decode URL if necessary

    val pattern = "/pokemon-species/(\\d+)/".toRegex() // Updated regex pattern
    val matchResult = pattern.find(decodedUrl)
    return matchResult?.groupValues?.getOrNull(1)?.toIntOrNull()
}

fun String.extractPokemonId2(): Int? {
    val pattern = "/pokemon/(\\d+)/".toRegex()
    val matchResult = pattern.find(this)
    return matchResult?.groupValues?.get(1)?.toIntOrNull()
}
















/*
@Composable
fun PokemonCardApi(poke: Pokemon){
    var isPressed by remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }
    val scale = animateFloatAsState(
        targetValue = if (isPressed) 0.90f else 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy, // Moderate bouncing
            stiffness = Spring.StiffnessMedium // Moderate stiffness
        )
    )
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val(foto,forma,tipos)=createRefs()
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .scale(scale.value)
                .clickable(
                    interactionSource = interactionSource,
                    indication = null, // Remove default ripple effect

                    onClick = {
                        //
                    }
                )
                .indication(
                    interactionSource = interactionSource,
                    indication = null
                )
                .pointerInput(Unit) {//lo que hace al pulsar en el Card()
                    detectTapGestures(
                        onPress = {


                            isPressed = true
                            try {
                                awaitRelease()
                            } finally {
                                isPressed = false // Reset isPressed in finally block
                            }


                        }
                    )
                }
        ) {
            ConstraintLayout(
                modifier = Modifier
                    .wrapContentWidth()
                    .background(colorResource(R.color.objeto_lista))
                    .padding(end = 30.dp)
            ) {

                //imagen remota
                AsyncImage(
                    model = poke.sprites.frontDefault,
                    contentDescription = "Pokemon Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .fillMaxSize()
                        .constrainAs(foto) {
                            start.linkTo(parent.start)
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                        }
                )

                Text(
                    text = poke.name,
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 15.dp)
                        .constrainAs(forma) {
                            start.linkTo(foto.end)
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                            end.linkTo(parent.end)
                        }
                )
                Text(
                    text = poke.types.toString(),
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 15.dp)
                        .constrainAs(tipos) {
                            start.linkTo(foto.end)
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                            end.linkTo(parent.end)
                        }
                )
            }
        }
    }
}
*/