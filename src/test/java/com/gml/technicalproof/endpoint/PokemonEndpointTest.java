package com.gml.technicalproof.endpoint;

import com.gml.pokemon.GetPokemonsRequest;
import com.gml.pokemon.GetPokemonsResponse;
import com.gml.pokemon.Pokemon;
import com.gml.technicalproof.facade.PokemonFacadeTest;
import com.gml.technicalproof.facade.impl.PokemonFacade;
import com.gml.technicalproof.service.impl.PokemonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PokemonEndpointTest {
    @InjectMocks
    PokemonEndpoint pokemonEndpoint;

    @Mock
    private PokemonFacade pokemonFacade;

    @Test
    public void getPokemons() {
        // Arrange
        GetPokemonsRequest request = new GetPokemonsRequest();
        request.setOffset(0);
        request.setLimit(10);
        GetPokemonsResponse responseMock = getGetPokemonsResponse();
        when(pokemonFacade.getPokemons(any())).thenReturn(responseMock);
        // Act
        GetPokemonsResponse response = pokemonFacade.getPokemons(request);
        // Assert
        Assertions.assertEquals(response.getNext(), "https://pokeapi.co/api/v2/pokemon?offset=20&limit=20");
        Assertions.assertEquals(response.getResults().size(), 2);
    }

    private static GetPokemonsResponse getGetPokemonsResponse() {
        Pokemon bulbasaur = new Pokemon();
        bulbasaur.setName("bulbasaur");
        bulbasaur.setUrl("https://pokeapi.co/api/v2/pokemon/1/");
        Pokemon ivysaur = new Pokemon();
        bulbasaur.setName("ivysaur");
        bulbasaur.setUrl("https://pokeapi.co/api/v2/pokemon/2/");
        GetPokemonsResponse responseMock = new GetPokemonsResponse();
        responseMock.setCount(1281);
        responseMock.setNext("https://pokeapi.co/api/v2/pokemon?offset=20&limit=20");
        responseMock.setResults(Arrays.asList(bulbasaur, ivysaur));
        return responseMock;
    }
}
