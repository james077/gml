package com.gml.technicalproof.facade;

import com.gml.pokemon.GetPokemonsRequest;
import com.gml.pokemon.GetPokemonsResponse;

public interface IPokemonFacade {
    GetPokemonsResponse getPokemons(GetPokemonsRequest request);
}
