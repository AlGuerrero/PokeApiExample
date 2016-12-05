package com.a13x.pokeapiexample.api;

import com.a13x.pokeapiexample.entities.Pokemon;

import java.util.List;

/**
 * Created by Alejandro on 05/12/2016.
 */
public class PokemonResponse {
    private int count;
    private List<Pokemon> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Pokemon> getResults() {
        return results;
    }

    public void setResults(List<Pokemon> results) {
        this.results = results;
    }
}
