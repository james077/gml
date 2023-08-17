package com.gml.technicalproof.dto;

import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetPokemonsResponseDto {
    private int count;
    private String next;
    private String previous;
    private ArrayList<PokemonDto> results;
}
