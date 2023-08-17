package com.gml.technicalproof.service;

import com.gml.pokemon.GetPokemonsRequest;
import com.gml.pokemon.GetPokemonsResponse;

public interface IPokemonService {

    GetPokemonsResponse getPokemons(GetPokemonsRequest request);
}
