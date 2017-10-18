package ele32_lab3;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestaDecodificador {

	@Test
	public void testaHt4por7() {
		byte[][] saida = Decodificador.gerarHt(4, 7);
		byte[][] esperado = {
				{0, 1, 1},
				{1, 0, 1},
				{1, 1, 0},
				{1, 1, 1},
				{1, 0, 0},
				{0, 1, 0},
				{0, 0, 1},
				};
		assertEquals(4, saida.length);
		assertEquals(7, saida[0].length);
		for (int linha=0; linha<esperado.length; linha++)
			assertArrayEquals(esperado[linha], saida[linha]);
	}
	

}
