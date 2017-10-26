package ele32_lab3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class CanalBSC {

	/**
	 * Escreve um arquivo de saída embaralhado (trocas) com probabilidade definida
	 * @param arquivoEntrada
	 * @param arquivoSaida
	 * @param probabiblidade
	 * @throws IOException 
	 */
	public static void canaliza(String arquivoEntrada, String arquivoSaida, double probabilidade) throws IOException {
		//InputStreamReader entrada = new InputStreamReader(new FileInputStream(arquivoEntrada), "UTF-8");
		OutputStreamWriter saida = new OutputStreamWriter(new FileOutputStream(arquivoSaida), "UTF-8");
		Random rand = new Random();
		int index = 0;
		String stringEntrada = new String(Files.readAllBytes(Paths.get(arquivoEntrada)));
		while (index < stringEntrada.length()) {
			double d = rand.nextDouble();
			if (d<=probabilidade) {
				if (stringEntrada.charAt(index) == '0') {
					saida.write(stringEntrada.charAt(index)+1);
				}
				else saida.write(stringEntrada.charAt(index)-1);
			}
			else saida.write(stringEntrada.charAt(index));
			index++;
		}
		saida.close();
	}
}
