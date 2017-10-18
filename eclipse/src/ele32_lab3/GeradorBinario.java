package ele32_lab3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;


public class GeradorBinario {
	
	public static void escreveAleatorio (String arquivo, int tamanho) throws IOException {
		OutputStreamWriter saida = new OutputStreamWriter(new FileOutputStream(arquivo), "UTF-8");
		
		Random rand = new Random();
		
		for (int i=0; i<tamanho; i++)
			saida.write(rand.nextInt(2)+48);
		
		saida.close();
	}

}
