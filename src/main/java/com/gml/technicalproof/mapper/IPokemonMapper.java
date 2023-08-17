package com.gml.technicalproof.mapper;

import com.gml.pokemon.GetPokemonsResponse;
import com.gml.pokemon.Pokemon;
import com.gml.technicalproof.dto.GetPokemonsRequestDto;
import com.gml.technicalproof.dto.GetPokemonsResponseDto;
import org.mapstruct.*;

import java.util.List;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface IPokemonMapper {
   @Mappings({
           @Mapping(target = "count",source = "getPokemonsResponse.count"),
           @Mapping(target = "next",source = "getPokemonsResponse.next"),
           @Mapping(target = "previous",source = "getPokemonsResponse.previous"),
           @Mapping(target = "results",source = "pokemons")
    })
   GetPokemonsResponseDto pokemonRsToDto(com.gml.pokemon.GetPokemonsResponse getPokemonsResponse, List<Pokemon> pokemons);
    @Mappings({
            @Mapping(target = "count",source = "count"),
            @Mapping(target = "next",source = "next"),
            @Mapping(target = "previous",source = "previous"),
            @Mapping(target = "results",source = "results")
    })
    GetPokemonsResponse pokemonDtoToRs(GetPokemonsResponseDto getPokemonsResponseDto);

    @Mappings({
            @Mapping(source = "offset",target = "offset"),
            @Mapping(source = "limit",target = "limit")
    })
    com.gml.pokemon.GetPokemonsRequest dtoToPokemonRq(GetPokemonsRequestDto getPokemonsRequestDto);

}