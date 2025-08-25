package calculadora;


import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadoraa")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma de dois n�meros")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}
	
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}

	@Test
	public void testMultiplica() {
		int retorno = calc.multiplicacao(8, 4);
		assertTrue(retorno == 32);
	}

	@Test
	public void testSubtraçao() {
		int retorno = calc.subtracao(8, 4);
		assertTrue(retorno == 4);
	}

	@Test
	public void comparaMaior() {
		int retorno = calc.compara(8, 4);
		assertTrue(retorno == 1);
	}

	@Test
	public void comparaIgual() {
		int retorno = calc.compara(4, 4);
		assertTrue(retorno == 0);
	}

	@Test
	public void comparaMenor() {
		int retorno = calc.compara(2, 4);
		assertTrue(retorno == -1);
	}

	@Test
		public void testSomatoria(){
			int somatorio = calc.somatoria(3);
			assertEquals(somatorio, 6);
		}

	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exce��o n�o lan�ada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}

	@Test
		public void testEhPositivo(){
			boolean positivo = calc.ehPositivo(10);
			assertTrue(positivo);
		}
	
	@Test
		public void testEhnegativo(){
			boolean negativo = calc.ehPositivo(-9);
			assertFalse(negativo);
		}
	
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}

}
