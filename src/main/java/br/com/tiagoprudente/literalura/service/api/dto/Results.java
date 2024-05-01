package br.com.tiagoprudente.literalura.service.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Results(Long id,
                      String title,
                      List<AuthorsData> authors,
                      List<String> languages) {
}
