package br.edu.infnet.util;

import br.edu.infnet.exception.ResourceNotFoundException;
import br.edu.infnet.model.Livro;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.URI;
import java.net.http.HttpResponse;

public class LivroUtil {
    public Livro getBuyId(int id) {
        String uri = "https://stephen-king-api.onrender.com/api/book/" + id;
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(new URI(uri))
                    .version((HttpClient.Version.HTTP_2))
                    .build();
            HttpClient client = HttpClient.newBuilder().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode() == 404){
                throw new ResourceNotFoundException(response.body());
            }
            ObjectMapper objectMapper = new ObjectMapper();
            Livro livro = objectMapper.readValue(response.body(), Livro.class);
            return livro;
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
