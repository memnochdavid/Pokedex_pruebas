package com.david.pokedex_pruebas.api

import com.david.pokedex_pruebas.api.modelo.EvolutionChain
import com.david.pokedex_pruebas.api.modelo.Pokemon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("pokemon/{id}")
    fun getPokemonInfo(@Path("id") id: Int): Call<Pokemon>
    @GET("pokemon")
    fun getPokemonList(@Query("limit") limit: Int, @Query("offset") offset: Int): Call<PokeApiResponse>
    @GET("pokemon-species/{id}")
    fun getPokemonSpecies(@Path("id") id: Int): Call<Pokemon>
    @GET("evolution-chain/{id}")
    fun getEvolutionChain(@Path("id") id: Int): Call<EvolutionChain>


}