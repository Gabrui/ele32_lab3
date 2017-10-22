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
	
	/**
	 * A matriz G é composta por uma identidade
	 * @param entrada Deve ter tamanho 2^n - n - 1
	 * @param quantTotal Deve ser do tipo 2^n - 1
	 * @return Codificado no qual se consegue consertar um byte
	 */
	public static byte[] codifica1C(byte[] entrada, int quantTotal) {
		byte[] resposta = new byte[quantTotal];
		int informacao = entrada.length;
		
		// Transfere a parte inicial, relativa à matriz identidade
		for (int i=0; i<informacao; i++)
			resposta[i] = entrada[i];
		
		byte[] paridade = paridade1C(entrada, quantTotal - informacao);
		// Transfere a paridade para a parte final
		for (int i=informacao; i<quantTotal; i++)
			resposta[i] = paridade[i-informacao];
		
		return resposta;
	}
	
	public static byte[] paridade1C(byte[] entrada, int quantParidade) {
		byte[] resposta = new byte[quantParidade];
		int quantTotal = entrada.length + quantParidade;
		for (int i=0; i<quantParidade; i++) {
			int mascara = 1 << (quantParidade - i - 1);
			int posicaoExcluida = 1 << (quantParidade - 1);
			int paridade = 0;
			for (int mascaravel=quantTotal, pos=0; mascaravel>mascara; mascaravel--) {
				if (mascaravel == posicaoExcluida) {
					posicaoExcluida = posicaoExcluida >> 1;
				} else {
					if ( ((mascara & mascaravel) != 0) && (entrada[pos] != 0) )
						paridade = (paridade + 1) % 2;
					pos++;
				}
			}
			resposta[i] = (byte) paridade;
		}
		return resposta;
	}
	
}
