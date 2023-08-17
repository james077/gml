package com.gml.technicalproof.service.impl;

import com.gml.pokemon.GetPokemonsRequest;
import com.gml.pokemon.GetPokemonsResponse;
import com.gml.technicalproof.service.IPokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class PokemonService implements IPokemonService {

    @Value("${client.pokemon.api.url}")
    private String pokemonApiUrl;

    private final RestTemplate restTemplate;
    @Override
    public GetPokemonsResponse getPokemons(GetPokemonsRequest request) {
        if(hasInvalidedParams(request))
            throw new IllegalArgumentException("No se han enviado los parametros de paginación validos");

        ResponseEntity<GetPokemonsResponse> response =
                restTemplate.getForEntity(
                        pokemonApiUrl+"?offset=" + request.getOffset() +"&limit="+request.getLimit(),
                        GetPokemonsResponse.class
                );
        return response.getBody();
    }

    private boolean hasInvalidedParams(GetPokemonsRequest request){
        return request == null || request.getLimit() == 0;
    }
}
