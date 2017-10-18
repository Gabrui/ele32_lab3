package ele32_lab3;

import java.util.HashMap;

public class Decodificador {
	
	/**
	 * Gera uma tabela de síndrome para apenas um byte de troca, quantTotal de síndromes.
	 * @param quantInformacao
	 * @param quantTotal
	 * @return
	 */
	public static HashMap<ContemByteArray, ContemByteArray> gerarTabelaSindrome(byte[][] ht) {
		HashMap<ContemByteArray, ContemByteArray> resposta = new HashMap<>();
		int quantTotal = ht[0].length;
		byte[] erro = new byte[quantTotal];
		byte[] sindrome;
		
		for (int i=0; i<quantTotal+1; i++) {
			erro[i] = 0;
			sindrome = Matematica.multiplicarVetorComXor(erro, ht);
			resposta.put(new ContemByteArray(sindrome), new ContemByteArray(erro));
			erro[i] = 1;
		}
		
		return resposta;
	}
	
	public static byte[] decodificar(byte[] entradaCodificada, 
			HashMap<ContemByteArray, ContemByteArray> tabela, byte[][] ht) {
		byte[] sindrome = Matematica.multiplicarVetorComXor(entradaCodificada, ht);
		byte[] erro = tabela.get(new ContemByteArray(sindrome)).array;
		return Matematica.somaVetorComXor(entradaCodificada, erro);
	}
	
	
	
	public static byte[][] gerarHt(int quantInformacao, int quantTotal) {
		int quantLinhas = quantTotal;
		int quantColunas = quantTotal-quantInformacao;
		byte[][] resposta = new byte[quantLinhas][quantColunas];

		for (int linha=0; linha<quantLinhas; linha++) {
			for (int coluna=0; coluna<quantColunas; coluna++) {
				// Identidade invertida do topo
				if (linha == coluna)
					resposta[linha][coluna] = 0;
				else
					resposta[linha][coluna] = 1;
				
				// Identidade do chão
				if (coluna == linha - quantInformacao)
					resposta[linha][coluna] = 1;
				else
					resposta[linha][coluna] = 0;
			}
		}
		return resposta;
	}
}
