package com.gml.technicalproof.service;

import com.gml.pokemon.GetPokemonsRequest;
import com.gml.pokemon.GetPokemonsResponse;
import com.gml.pokemon.Pokemon;
import com.gml.technicalproof.facade.impl.PokemonFacade;
import com.gml.technicalproof.service.impl.PokemonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PokemonServiceTest {
    @InjectMocks
    PokemonService pokemonService;

    @Mock()
    private RestTemplate restTemplate;


    @Test
    public void getPokemons() {
        // Arrange
        GetPokemonsRequest request = new GetPokemonsRequest();
        request.setOffset(0);
        request.setLimit(10);
        GetPokemonsResponse responseMock = getGetPokemonsResponse();
        when(restTemplate.getForEntity(anyString(), any())).thenReturn(new ResponseEntity<>(responseMock, HttpStatus.OK));
        // Act
        GetPokemonsResponse response = pokemonService.getPokemons(request);
        // Assert
        Assertions.assertEquals(response.getNext(), "https://pokeapi.co/api/v2/pokemon?offset=20&limit=20");
        Assertions.assertEquals(response.getResults().size(), 2);
    }
    @Test
    public void getPokemons_whenRequesIsNull_shouldThrowIllegalArgumentException() {
        // Act and Assert
        Exception thrown = assertThrows(
                Exception.class,
                () -> pokemonService.getPokemons(null)
        );

        assertNotNull(thrown);
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
