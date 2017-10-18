package ele32_lab3;

public class Codificador {
	public static byte[][] g4e7 = gerarG(4, 7);
	
	public static byte[] codifica4e7(byte[] entrada) {
		return Matematica.multiplicarVetorComXor(entrada, g4e7);
	}
	
	/**
	 * Gera uma identidade normal concatenada com uma identidade invertida
	 * 
	 * Funciona bem para 2^n com 2^(n+1)-1
	 */
	public static byte[][] gerarG(int quantInformacao, int quantTotal) {
		byte[][] resposta = new byte[quantInformacao][quantTotal];
		
		// Gera a identidade
		for (int linha=0; linha<quantInformacao; linha++) {
			for (int coluna=0; coluna<quantTotal; coluna++) {
				// Identidade
				if (linha == coluna)
					resposta[linha][coluna] = 1;
				else
					resposta[linha][coluna] = 0;
				
				// Algoritmo
				if (coluna >= quantInformacao) {
					if (coluna == quantInformacao + linha)
						resposta[linha][coluna] = 0;
					else
						resposta[linha][coluna] = 1;
				}
			}
		}
		return resposta;
	}
	
}
