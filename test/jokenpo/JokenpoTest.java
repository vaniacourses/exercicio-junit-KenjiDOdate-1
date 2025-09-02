package jokenpo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste do Jokenpo")
public class JokenpoTest {

    private Jokenpo jogo;

    @BeforeEach
    public void inicializa() {
        jogo = new Jokenpo();
    }

    @DisplayName("Testa se jogador ganha")
    @Test
    public void testJogador1Ganha() {
        assertEquals(1, jogo.jogar(1, 2));
        assertEquals(1, jogo.jogar(2, 3));
        assertEquals(1, jogo.jogar(3, 1));
    }

 

    @DisplayName("Testa empates")
    @Test
    public void testEmpate() {
        assertEquals(0, jogo.jogar(1, 1));
        assertEquals(0, jogo.jogar(2, 2));
        assertEquals(0, jogo.jogar(3, 3));
    }

    @DisplayName("Testa opções inválidas")
    @Test
    public void testInvalido() {
        assertEquals(-1, jogo.jogar(0, 2));
        assertEquals(-1, jogo.jogar(4, 1));
        assertEquals(-1, jogo.jogar(2, 10));
    }

   
}
