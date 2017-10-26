package ele32_lab3;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Test;

public class TesteConverteEntrada {
	
	@Test
	public void test() throws IOException {
		String arquivo = "../testes/entradaCanal/testeConverteEntrada100";
		String saida = "../testes/saidaCanal/100";
		LinkedList<byte[]> arrayDeBytes = new LinkedList<byte[]>();
		arrayDeBytes = ConverteEntrada.bytesParaArray(arquivo, saida, 4);
		LinkedList<String> arrayEsperada = new LinkedList<String>();
		int index = 0;
		while(index<5) {
			arrayEsperada.add("[0, 1, 0, 0]");
			arrayEsperada.add("[1, 1, 1, 0]");
			arrayEsperada.add("[1, 0, 1, 1]");
			arrayEsperada.add("[1, 1, 1, 0]");
			arrayEsperada.add("[1, 1, 1, 0]");
			index++;
		}
		index = 0;
		while(index<25) {
			assertEquals(arrayEsperada.get(index), Arrays.toString(arrayDeBytes.get(index)));
			index++;
		}
	}
}
