package ele32_lab3;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

public class TesteGeradorBinario {

	@Test
	public void test() throws IOException {
		String arquivo = "../testes/entradaCanal/100";
		GeradorBinario.escreveAleatorio(arquivo, 100);
		String resposta = new String(Files.readAllBytes(Paths.get(arquivo)));
		assertEquals(100, resposta.length());
		assertTrue(resposta.matches("[01]+"));
	}

}
