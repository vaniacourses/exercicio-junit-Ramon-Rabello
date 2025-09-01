package calculadora;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTestGpt {

    private Calculadora calculadora;

    @BeforeEach
    void setUp() {
        calculadora = new Calculadora();
    }

    @Test
    @DisplayName("Deve somar dois inteiros corretamente")
    void testSoma() {
        assertEquals(5, calculadora.soma(2, 3));
        assertEquals(0, calculadora.soma(-2, 2));
        assertEquals(-7, calculadora.soma(-3, -4));
    }

    @Test
    @DisplayName("Deve subtrair dois inteiros corretamente")
    void testSubtracao() {
        assertEquals(-1, calculadora.subtracao(2, 3));
        assertEquals(4, calculadora.subtracao(2, -2));
        assertEquals(1, calculadora.subtracao(-3, -4));
    }

    @Test
    @DisplayName("Deve multiplicar dois inteiros corretamente")
    void testMultiplicacao() {
        assertEquals(6, calculadora.multiplicacao(2, 3));
        assertEquals(-4, calculadora.multiplicacao(2, -2));
        assertEquals(0, calculadora.multiplicacao(5, 0));
    }

    @Test
    @DisplayName("Deve dividir dois inteiros corretamente")
    void testDivisao() {
        assertEquals(2, calculadora.divisao(6, 3));
        assertEquals(-3, calculadora.divisao(6, -2));
    }

    @Test
    @DisplayName("Deve lançar ArithmeticException ao dividir por zero")
    void testDivisaoPorZero() {
        assertThrows(ArithmeticException.class, () -> calculadora.divisao(5, 0));
    }

    @Test
    @DisplayName("Deve calcular a somatória corretamente")
    void testSomatoria() {
        assertEquals(0, calculadora.somatoria(0));   // 0
        assertEquals(6, calculadora.somatoria(3));   // 0+1+2+3
        assertEquals(55, calculadora.somatoria(10)); // 0 até 10
    }

    @Test
    @DisplayName("Deve retornar true para número positivo ou zero")
    void testEhPositivoTrue() {
        assertTrue(calculadora.ehPositivo(0));
        assertTrue(calculadora.ehPositivo(5));
    }

    @Test
    @DisplayName("Deve retornar false para número negativo")
    void testEhPositivoFalse() {
        assertFalse(calculadora.ehPositivo(-1));
        assertFalse(calculadora.ehPositivo(-100));
    }

    @Test
    @DisplayName("Deve comparar dois números corretamente")
    void testCompara() {
        assertEquals(0, calculadora.compara(5, 5));
        assertEquals(1, calculadora.compara(10, 5));
        assertEquals(-1, calculadora.compara(3, 7));
    }
}
