package br.com.tiagoprudente.literalura.service.api;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AuthorsData(String name,
                          @JsonAlias("birth_year") int birthYear,
                          @JsonAlias("death_year") int deathYear) {
}
