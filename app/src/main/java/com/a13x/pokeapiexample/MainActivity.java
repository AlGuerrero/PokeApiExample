package com.a13x.pokeapiexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import com.a13x.pokeapiexample.api.PokeAPIClient;
import com.a13x.pokeapiexample.api.PokeAPIService;
import com.a13x.pokeapiexample.api.PokemonResponse;
import com.a13x.pokeapiexample.entities.Pokemon;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    PokeAPIService pokeApiService;
    PokeAPIClient pokeApiClient = new PokeAPIClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pokeApiService = pokeApiClient.getPokeApiService();


        Call<PokemonResponse> call = pokeApiService.ListPokemons("pokemon");

        call.enqueue(new Callback<PokemonResponse>() {
            @Override
            public void onResponse(Call<PokemonResponse> call, Response<PokemonResponse> response) {
                int count = response.body().getCount();
                List<Pokemon> pokemons = response.body().getResults();
                Log.v("Count", Integer.toString(count));

                for(int i = 0; i < pokemons.size(); i++) {
                    Log.v("Pokemon-URL", pokemons.get(i).getUrl());
                    Log.v("Pokemon-Name", pokemons.get(i).getName());
                }

            }

            @Override
            public void onFailure(Call<PokemonResponse> call, Throwable t) {
                Log.e("ERROR", "Someting went wrong: " + t.getMessage());

            }
        });
    }
}