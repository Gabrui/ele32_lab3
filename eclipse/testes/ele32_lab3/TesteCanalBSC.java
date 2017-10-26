package ele32_lab3;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

public class TesteCanalBSC {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() throws IOException {
		String arquivo = "../testes/entradaCanal/100";
		String saida = "../testes/saidaCanal/100";
		String stringSaida = new String(Files.readAllBytes(Paths.get(saida)));
		CanalBSC.canaliza(arquivo, saida, 0.5);
		//System.out.println(stringSaida.length());
		assertEquals(100, stringSaida.length());
		assertTrue(stringSaida.matches("[01]+"));
	}

}
