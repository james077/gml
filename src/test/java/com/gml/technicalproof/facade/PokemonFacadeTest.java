package com.gml.technicalproof.facade;

import com.gml.pokemon.GetPokemonsRequest;
import com.gml.pokemon.GetPokemonsResponse;
import com.gml.pokemon.Pokemon;
import com.gml.technicalproof.dto.GetPokemonsResponseDto;
import com.gml.technicalproof.dto.PokemonDto;
import com.gml.technicalproof.facade.impl.PokemonFacade;
import com.gml.technicalproof.service.impl.PokemonService;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PokemonFacadeTest {
    @InjectMocks
    PokemonFacade pokemonFacade;

    @Mock
    private PokemonService pokemonService;

    @Test
    public void getPokemons() {
        // Arrange
        GetPokemonsRequest request = new GetPokemonsRequest();
        request.setOffset(0);
        request.setLimit(10);
        GetPokemonsResponse responseMock = getGetPokemonsResponse();
        when(pokemonService.getPokemons(any())).thenReturn(responseMock);
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
