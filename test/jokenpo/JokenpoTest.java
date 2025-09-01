package jokenpo;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



import jokenpo.Jokenpo;

public class JokenpoTest {

    private Jokenpo jogo;

    @BeforeEach
    public void inicializa(){
        jogo = new Jokenpo();
    }

    @Test
    public void testaEmpate(){

        assertEquals(jogo.jogar(1,1), 0);
        assertEquals(jogo.jogar(2,2), 0);
        assertEquals(jogo.jogar(3,3), 0);
    } 

    @Test 
    public void testaJogador1Vence(){

        assertEquals(jogo.jogar(1,2), 1);
        assertEquals(jogo.jogar(2,3), 1);
        assertEquals(jogo.jogar(3,1), 1);

    }
    @Test
    public void testaJogador2Vence(){
        assertEquals(jogo.jogar(2,1), 2);
        assertEquals(jogo.jogar(3,2), 2);
        assertEquals(jogo.jogar(1,3), 2);

    }

    

    
}
