package ele32_lab3;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestaDecodificador {

	/*
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
	*/
	
	@Test
	public void testaDecodifica1CNulo() {
		byte[] entrada = {0, 0, 0, 0, 0, 0, 0};
		byte[] esperada = {0, 0, 0, 0};
		assertArrayEquals(esperada, Decodificador.decodificar1C(entrada, 4));
	}
	
	@Test
	public void testaDecodifica1CSemErro() {
		byte[] entrada = {1, 0, 1, 0, 0, 1, 0};
		byte[] esperada = {1, 0, 1, 0};

		assertArrayEquals(esperada, Decodificador.decodificar1C(entrada, 4));
	}
	
	@Test
	public void testaDecodifica1CNuloQuandoTemErroSimplesConserta() {
		byte[] entrada = {1, 0, 0, 0, 0, 0, 0};
		byte[] esperada = {0, 0, 0, 0};
		assertArrayEquals(esperada, Decodificador.decodificar1C(entrada, 4));
		for (int i=1; i<7; i++) {
			entrada[i] = 1;
			entrada[i-1] = 0;
			assertArrayEquals(esperada, Decodificador.decodificar1C(entrada, 4));
		}
	}
	
	
	@Test
	public void testaDecodifica1CQuandoTemErroSimplesConserta() {
		byte[] entrada = {0, 1, 0, 0, 0, 0, 1};
		byte[] esperada = {1, 1, 0, 0};
		assertArrayEquals(esperada, Decodificador.decodificar1C(entrada, 4));
		for (int i=1; i<entrada.length; i++) {
			entrada[i] = (byte) ((entrada[i]+1)%2);
			entrada[i-1] = (byte) ((entrada[i-1]+1)%2);
			assertArrayEquals(esperada, Decodificador.decodificar1C(entrada, 4));
		}
	}
	
	
	@Test
	public void testaDecodifica1CQuandoTemErroSimplesConsertaGrande() {
		byte[] entrada = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0};
		byte[] esperada = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
		assertArrayEquals(esperada, Decodificador.decodificar1C(entrada, 11));
		for (int i=1; i<entrada.length; i++) {
			entrada[i] = (byte) ((entrada[i]+1)%2);
			entrada[i-1] = (byte) ((entrada[i-1]+1)%2);
			assertArrayEquals(esperada, Decodificador.decodificar1C(entrada, 11));
		}
	}

}
