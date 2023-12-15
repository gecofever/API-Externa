package br.edu.infnet;

import br.edu.infnet.exception.ResourceNotFoundException;
import br.edu.infnet.model.Livro;
import br.edu.infnet.util.LivroUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppTestes {
    @Test
    @DisplayName("Retorna um livro pelo ID")
    public void testaLivroPeloId(){

        LivroUtil livroutil = new LivroUtil();
        Livro livro = livroutil.getBuyId(10);

        Livro.LivroData livroData = livro.getData();

        assertEquals("Cujo", livroData.getTitle());
        assertEquals(10, livroData.getId());
    }

    @Test
    @DisplayName("Deve retornar Exception para Titulo ID Inexistente")
    public void testaIdInexistente(){
        LivroUtil livroutil = new LivroUtil();
        assertThrows(ResourceNotFoundException.class, () ->{
            livroutil.getBuyId(-10);
        });
    }

}
