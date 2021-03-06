package dib;

import java.io.*;

public class SimpleFileWriter {

    public static void main(String[] args) {
        try {
            // Conteudo do arquivo
            String content = "Teste";
            
            String nomeArquivo = "teste.txt";
            
            createFile(content, nomeArquivo);
            
            readFile(nomeArquivo);

            System.out.println("----- Feito! ------");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static void createFile(String content, String nomeArquivo){
    	
        try {
			// Cria arquivo
			File file = new File("c:/temp/" + nomeArquivo);
			
			 // Se o arquivo nao existir, ele gera
			if (!file.exists()) {
			    file.createNewFile();
			}

			// Prepara para escrever no arquivo
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			
			// Escreve e fecha arquivo
			bw.write(content);
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}    	
    }    
    
	private static void readFile(String nomeArquivo) throws FileNotFoundException, IOException {
		
		// Le o arquivo
		FileReader ler = new FileReader("c:/temp/" + nomeArquivo);
		BufferedReader reader = new BufferedReader(ler);  
		
		String linha;
		while( (linha = reader.readLine()) != null ){
		    System.out.println(linha);
		}
		reader.close();
	}
    
}