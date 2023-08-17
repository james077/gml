package com.gml.technicalproof.facade.impl;

import com.gml.pokemon.GetPokemonsRequest;
import com.gml.pokemon.GetPokemonsResponse;
import com.gml.technicalproof.facade.IPokemonFacade;
import com.gml.technicalproof.service.IPokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class PokemonFacade implements IPokemonFacade {

    private final IPokemonService pokemonService;
    @Override
    public GetPokemonsResponse getPokemons(GetPokemonsRequest request) {
        return pokemonService.getPokemons(request);
    }
}
