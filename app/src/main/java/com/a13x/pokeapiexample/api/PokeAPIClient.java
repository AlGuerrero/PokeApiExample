package com.a13x.pokeapiexample.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Alejandro on 28/11/2016.
 */
public class PokeAPIClient {
    private Retrofit retrofit;
    private final static String BASE_URL = "http://pokeapi.co/";

    public PokeAPIClient() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public PokeAPIService getPokeApiService() {
        return this.retrofit.create(PokeAPIService.class);
    }
}