/* Fazer um programa para ler os dados(nome,email e salário) de funcionários a partir de um
 * arquivo em formato csv. Em seguida mostrar, em ordem alfabética, o email dos funcionários cujo
 * salário seja superior a um dado valor fornecido pelo usuário.
 * Mostrar também a soma dos salários dos funcionários cujo nome começa com a letra 'M'.
 * 
 */



/* map: Transforma os elementos.EX: Acessa um atributo e aplica uma função no mesmo
 * filter: Seleciona elementos com base em uma condição 
 * reduce: Reduz todos os elementos a um único resultado
 */

package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter full file path: ");
		//C:\temp\employee.csv
		String path = sc.nextLine();
		
		System.out.println("Enter salary ");
	
		double salary = sc.nextDouble();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			List<Employee> list = new ArrayList<>();
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				list.add(new Employee(fields[0],fields[1] , Double.parseDouble(fields[2])));
				line = br.readLine();
			}
			
			Comparator<String> comp = (s1,s2)-> s1.toUpperCase().compareTo(s1.toUpperCase());
			
		List<String> names = list.stream()
				.filter(e -> e.getSalary()>salary)
				.map(e -> e.getEmail())
				.sorted()
				.collect(Collectors.toList());
		
		names.forEach(System.out::println);
		
		
		double totalSalary = list.stream()
				.filter(e -> e.getName().charAt(0) == 'M')
				.map(e -> e.getSalary())
				.reduce(0.0,(x,y)->x+y);
		
			System.out.println("Sum of salary of people whose name starts with 'M' : " + totalSalary);
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}

}
