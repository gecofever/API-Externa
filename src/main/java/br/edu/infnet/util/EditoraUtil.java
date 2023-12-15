package br.edu.infnet.util;

import br.edu.infnet.model.Editora;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.util.logging.Level;
import java.util.logging.Logger;

public class EditoraUtil {
    private static final Logger logger = Logger.getLogger(EditoraUtil.class.getName());
    public Editora getByPublisher(String publisher) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .version(HttpClient.Version.HTTP_2)
                    .uri(new URI(publisher))
                    .build();
            HttpClient client = HttpClient.newBuilder().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            int statusCode = response.statusCode();
            logger.log(Level.INFO, "Status Code: " + statusCode);

            ObjectMapper objectMapper = new ObjectMapper();
            Editora editora = objectMapper.readValue(response.body(), Editora.class);
            logger.log(Level.INFO, "Editora: " + editora);
            return editora;

        } catch (URISyntaxException | IOException | InterruptedException e) {
            logger.log(Level.SEVERE, "Erro durante a execução: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
