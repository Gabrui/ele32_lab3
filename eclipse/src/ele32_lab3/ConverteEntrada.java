package ele32_lab3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;

public class ConverteEntrada {

	/**
	 * @throws IOException 
	 * 
	 */
	public static LinkedList<byte[]> bytesParaArray(String arquivoEntrada, String arquivoSaida, int tamanho) throws IOException {
		LinkedList<byte[]> listaDeArrays = new LinkedList<byte[]>();
		String stringEntrada = new String(Files.readAllBytes(Paths.get(arquivoEntrada)));
		int index = 0;
		
		while(index < stringEntrada.length()) { /* fica no loop enquanto ainda houver byte a ser lido na entrada */
			byte[] byteArray = new byte[tamanho];
			int count = 0; /* contador que vai de 0 a 4: sao as posicoes dos arrays de bytes */
			while(count<tamanho) {
				if(index+count < stringEntrada.length()) {
					if(stringEntrada.charAt(index+count) == '0') {
						byteArray[count] = 0;
					}
					else byteArray[count] = 1;
				}
				count++;
			}
			listaDeArrays.add(byteArray); // estou com problemas: estou mudando o byteArray a cada iteração, aí o listaDeArrays muda os valores de cada posicao tb
			index = index + 4;
		}
		index = 0;
		return listaDeArrays;
	}
	
	public static String arrayParaBytes(String arquivoEntrada, String arquivoSaida) throws IOException {
		String stringEntrada = new String(Files.readAllBytes(Paths.get(arquivoEntrada)));
		String stringSaida = new String();
		byte[] byteEntrada = new byte[stringEntrada.length()];
		byteEntrada = stringEntrada.getBytes("UTF-8");
		int index = 0;
		while(index < stringEntrada.length()) {
			if(stringEntrada.charAt(index) == '0') {
				stringSaida += '0';
			}
			else if(stringEntrada.charAt(index) == '1') {
				stringSaida += '1';
			}
		}
		return stringSaida;
	}
	
}
