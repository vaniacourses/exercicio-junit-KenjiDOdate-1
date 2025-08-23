package calculadora;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
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
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exce��o n�o lan�ada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}
	
	
	@Test
	public void testSubtracao() {
		assertEquals(1, calc.subtracao(5, 4));
		assertEquals(-1, calc.subtracao(4, 5));
	}


	@Test
	public void testMultiplicacao() {
		 assertEquals(20, calc.multiplicacao(4, 5));
		 assertEquals(0, calc.multiplicacao(4, 0));
	}



	@Test
	public void testSomatoria() {
		assertEquals(15, calc.somatoria(5)); // 0+1+2+3+4+5
		assertEquals(0, calc.somatoria(0));
	}


	@Test
	public void testEhPositivo() {
		assertTrue(calc.ehPositivo(5));
		assertTrue(calc.ehPositivo(0));
		assertEquals(false, calc.ehPositivo(-1));
	}


	@Test
	public void testCompara() {
		assertEquals(0, calc.compara(5, 5));
		assertEquals(1, calc.compara(6, 5));
		assertEquals(-1, calc.compara(4, 5));
	}

}
