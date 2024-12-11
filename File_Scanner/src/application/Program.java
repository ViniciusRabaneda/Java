/* Faça um programa para ler o caminho de um arquivo.csv contendo os dados de itens vendidos. Cada item possui nome
 * ,preço unitário e quantidade, separados por virgula. Você deve gerar um novo arquivo chamado "summary.csv", localizado
 * em uma subpasta chamada "out" a partir da pasta original do arquivo de origem, contendo apenas o nome e o valor total para 
 * aquele item( preço unitário multiplicado pela quantidade).
 */

package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Product> list = new ArrayList<>();
		
		System.out.println("Enter file path: ");
		String sourceFileStr = sc.nextLine();
		
		//serve para instanciar um arquivo ou caminho
		File sourceFile = new File(sourceFileStr);
		
		//pega somente o caminho do arquivo desconsiderando seu nome
		String sourceFolderStr = sourceFile.getParent();
		System.out.println(sourceFolderStr);
		
		//cria uma pasta e retorna um boolean de true ou false
		boolean success = new File(sourceFolderStr + "\\out").mkdir();
		
		//concatena o caminho da pasta out e adiciona o nome do arquivo final
		String targetFileStr = sourceFolderStr + "\\out\\summary.csv";
		
		// instancia um buffer reader com base no caminho final do arquivo
		try(BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))){
			
			
			String itemCsv = br.readLine();
		//faz a leitura de linha por linha do arquivo cujo caminho foi passado	
			while(itemCsv != null) {
				
		// como é um arquivo csv(input), o comando pega a linha quebra na virgula e aloca em um vetor
				String[] fields = itemCsv.split(",");
				String name = fields[0];
				double price = Double.parseDouble(fields[1]);
				int quantity = Integer.parseInt(fields[2]);
		// instancia os dados separados por virgula como um objeto do tipo Product		
				list.add(new Product(name,price,quantity));	
				itemCsv = br.readLine(); // verifica linha seguinte até chegar no null
			}
			
		// utilizar o bufferwriter para gravar um arquivo no caminho do targetFilStr--> sourceFolderStr + "\\out\\summary.csv";
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))){
				
		//foreach para ler todos os intens do list		
				for(Product item : list) {
					bw.write(item.getName() + ", " +String.format("%.2f",item.total())); // grava os atributos do objeto Product
					bw.newLine(); // pula linha
				}
				System.out.println(targetFileStr + " CREATED");
			}
			catch(IOException e) {
				System.out.println("Error writing file: " + e.getMessage()); // tratamento de erro direcionado ao bufferwriter
			}
			
			
		}
		catch(IOException e){
			System.out.println("Error Writing file: " + e.getMessage()); // tratamento de erro direcionado ao bufferreader
		}
		
		
		sc.close(); // fecha o scanner
		
	}
}
