package com.gml.technicalproof.endpoint;

import com.gml.pokemon.GetPokemonsRequest;
import com.gml.pokemon.GetPokemonsResponse;
import com.gml.technicalproof.facade.IPokemonFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@RequiredArgsConstructor
@Endpoint
public class PokemonEndpoint {

    private static final String NAMESPACE_URI = "http://gml.com/pokemon";
    private final IPokemonFacade pokemonFacade;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetPokemonsRequest")
    @ResponsePayload
    public GetPokemonsResponse getPokemons(@RequestPayload GetPokemonsRequest request) {
        return pokemonFacade.getPokemons(request);
    }

}
