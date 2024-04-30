package br.com.tiagoprudente.literalura.service.api;

import java.util.ArrayList;

public record BookGutendexResponse(Long count, ArrayList<BookData> results) {
}
