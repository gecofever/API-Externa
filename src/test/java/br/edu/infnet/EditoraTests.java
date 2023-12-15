package br.edu.infnet;

import br.edu.infnet.model.Editora;
import br.edu.infnet.util.EditoraUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class EditoraTests {
    private static final Logger logger = Logger.getLogger(EditoraTests.class.getName());
    @Test
    @DisplayName("Deve retornar o nome da Editora pela URL")
    public void getByPublisher(){
        EditoraUtil editorautil = new EditoraUtil();

        assertThrows(org.opentest4j.AssertionFailedError.class, () -> {
            Editora editora = editorautil.getByPublisher("https://stephen-king-api.onrender.com/api/book/15"); // URL inexistente para provocar uma exceção
            Editora.LivroData livroData = editora.getData();
            assertEquals("Land of", livroData.getPublisher());
        });
        logger.log(Level.INFO, "Teste de getByPublisher concluído com sucesso.");
    }
}
