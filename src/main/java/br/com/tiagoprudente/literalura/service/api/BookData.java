package br.com.tiagoprudente.literalura.service.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookData(List<Results> results,
                       Long count) {
}
