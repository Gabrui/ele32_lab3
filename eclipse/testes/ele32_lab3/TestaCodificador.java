package ele32_lab3;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestaCodificador {


	@Test
	public void testaGerarG4por7() {
		byte[][] saida = Codificador.gerarG(4, 7);
		byte[][] esperado = {
				{1, 0, 0, 0, 0, 1, 1},
				{0, 1, 0, 0, 1, 0, 1},
				{0, 0, 1, 0, 1, 1, 0},
				{0, 0, 0, 1, 1, 1, 1}
				};
		assertEquals(4, saida.length);
		assertEquals(7, saida[0].length);
		for (int linha=0; linha<esperado.length; linha++)
			for (int coluna=0; coluna<esperado[0].length; coluna++)
				assertEquals(esperado[linha][coluna], saida[linha][coluna]);
	}
	
	
	@Test
	public void testaCodificacao4por7Trivial() {
		byte[] entrada = {0, 0, 0, 0};
		byte[] esperado = {0, 0, 0, 0, 0, 0, 0};
		
		assertArrayEquals(esperado, Codificador.codifica4e7(entrada));
	}
	
	@Test
	public void testaCodificacao4por7() {
		byte[] entrada = {1, 0, 0, 0};
		byte[] esperado = {1, 0, 0, 0, 0, 1, 1};
		
		assertArrayEquals(esperado, Codificador.codifica4e7(entrada));
	}
	

	@Test
	public void testaCodificacao4por7Total() {
		byte[] entrada = {1, 0, 1, 0};
		byte[] esperado = {1, 0, 1, 0, 1, 0, 1};
		
		assertArrayEquals(esperado, Codificador.codifica4e7(entrada));
	}

}
