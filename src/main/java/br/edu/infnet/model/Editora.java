package br.edu.infnet.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Editora {
    private LivroData Data;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class LivroData {
        @JsonProperty("Publisher")
        private String Publisher;
    }

}
