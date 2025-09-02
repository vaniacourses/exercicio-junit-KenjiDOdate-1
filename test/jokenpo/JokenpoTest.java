package jokenpo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Testes unitários da classe Jokenpo")
public class JokenpoTest {

    private Jokenpo jogo;

    @BeforeEach
    void setup() {
        jogo = new Jokenpo();
    }

    @DisplayName("Jogador 1 vence")
    @ParameterizedTest(name = "jogador1={0}, jogador2={1} deve retornar 1")
    @CsvSource({
        "1,2", // papel > pedra
        "2,3", // pedra > tesoura
        "3,1"  // tesoura > papel
    })
    void testJogador1Ganha(int jogador1, int jogador2) {
        assertEquals(1, jogo.jogar(jogador1, jogador2),
                () -> "Esperava que jogador 1 ganhasse com " + jogador1 + " vs " + jogador2);
    }

    @DisplayName("Jogador 2 vence")
    @ParameterizedTest(name = "jogador1={0}, jogador2={1} deve retornar 2")
    @CsvSource({
        "2,1", // pedra < papel
        "3,2", // tesoura < pedra
        "1,3"  // papel < tesoura
    })
    void testJogador2Ganha(int jogador1, int jogador2) {
        assertEquals(2, jogo.jogar(jogador1, jogador2),
                () -> "Esperava que jogador 2 ganhasse com " + jogador1 + " vs " + jogador2);
    }

    @DisplayName("Empates")
    @ParameterizedTest(name = "jogador1={0}, jogador2={0} deve retornar 0")
    @CsvSource({ "1", "2", "3" })
    void testEmpates(int escolha) {
        assertEquals(0, jogo.jogar(escolha, escolha),
                () -> "Esperava empate quando ambos escolhem " + escolha);
    }

    @DisplayName("Entradas inválidas")
    @ParameterizedTest(name = "jogador1={0}, jogador2={1} deve retornar -1")
    @CsvSource({
        "0,1",
        "1,0",
        "4,2",
        "2,4",
        "-1,3",
        "3,-5"
    })
    void testEntradasInvalidas(int jogador1, int jogador2) {
        assertEquals(-1, jogo.jogar(jogador1, jogador2),
                () -> "Esperava -1 para entradas inválidas: " + jogador1 + " vs " + jogador2);
    }
}
