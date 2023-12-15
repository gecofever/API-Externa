package br.edu.infnet.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@Data
public class Livro {
    private LivroData Data;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class LivroData {
        @JsonProperty("id")
        private int id;
        @JsonProperty("Year")
        private int Year;
        @JsonProperty("Title")
        private String Title;
        @JsonProperty("Publisher")
        private String Publisher;
        @JsonProperty("Notes")
        private List<String> Notes;
    }
}
