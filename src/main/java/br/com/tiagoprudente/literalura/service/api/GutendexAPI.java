package br.com.tiagoprudente.literalura.service.api;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GutendexAPI implements IBookAPI {
    private final String BASE_URL = "https://gutendex.com/books/";

    @Override
    public String execute() {
        ObjectMapper objectMapper = new ObjectMapper();
        String searchParam = "?search=dom%20casmurro";
        URI uri = URI.create(BASE_URL + searchParam);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(uri).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            BookData json = objectMapper.readValue(response.body(), BookData.class);
            System.out.println(json.toString());

            return response.toString();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
