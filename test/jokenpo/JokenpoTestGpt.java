package jokenpo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JokenpoTestGpt {

    private Jokenpo jokenpo;

    @BeforeEach
    void setUp() {
        jokenpo = new Jokenpo();
    }

    // ================= EMPATES =================
    @Test
    void deveRetornarEmpateQuandoAmbosEscolhemPapel() {
        assertEquals(0, jokenpo.jogar(1, 1));
    }

    @Test
    void deveRetornarEmpateQuandoAmbosEscolhemPedra() {
        assertEquals(0, jokenpo.jogar(2, 2));
    }

    @Test
    void deveRetornarEmpateQuandoAmbosEscolhemTesoura() {
        assertEquals(0, jokenpo.jogar(3, 3));
    }

    // ================= VITÓRIAS DO JOGADOR 1 =================
    @Test
    void deveVencerJogador1QuandoPapelVencePedra() {
        assertEquals(1, jokenpo.jogar(1, 2));
    }

    @Test
    void deveVencerJogador1QuandoPedraVenceTesoura() {
        assertEquals(1, jokenpo.jogar(2, 3));
    }

    @Test
    void deveVencerJogador1QuandoTesouraVencePapel() {
        assertEquals(1, jokenpo.jogar(3, 1));
    }

    // ================= VITÓRIAS DO JOGADOR 2 =================
    @Test
    void deveVencerJogador2QuandoPedraPerdeParaPapel() {
        assertEquals(2, jokenpo.jogar(2, 1));
    }

    @Test
    void deveVencerJogador2QuandoTesouraPerdeParaPedra() {
        assertEquals(2, jokenpo.jogar(3, 2));
    }

    @Test
    void deveVencerJogador2QuandoPapelPerdeParaTesoura() {
        assertEquals(2, jokenpo.jogar(1, 3));
    }

    // ================= ENTRADAS INVÁLIDAS =================
    @Test
    void deveRetornarMenosUmQuandoJogador1EscolhaInvalida() {
        assertEquals(-1, jokenpo.jogar(0, 2));
        assertEquals(-1, jokenpo.jogar(4, 1));
        assertEquals(-1, jokenpo.jogar(-5, 3));
    }

    @Test
    void deveRetornarMenosUmQuandoJogador2EscolhaInvalida() {
        assertEquals(-1, jokenpo.jogar(1, 0));
        assertEquals(-1, jokenpo.jogar(3, 10));
        assertEquals(-1, jokenpo.jogar(2, -2));
    }

    @Test
    void deveRetornarMenosUmQuandoAmbosEscolhemInvalidos() {
        assertEquals(-1, jokenpo.jogar(0, 0));
        assertEquals(-1, jokenpo.jogar(10, -3));
    }
}
