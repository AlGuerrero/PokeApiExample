package com.a13x.pokeapiexample.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Alejandro on 28/11/2016.
 */

public interface PokeAPIService {

    @GET("api/v2/{endpoint}")
    Call<PokemonResponse> ListPokemons(@Path("endpoint") String endPoint);

}