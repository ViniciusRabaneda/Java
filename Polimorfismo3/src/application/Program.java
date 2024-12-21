package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		ArrayList<Product> list = new ArrayList<>();

		System.out.printf("Enter the number of products: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + " data: ");

			System.out.printf("Common,used or imported (c/u/i)?");
			sc.nextLine();
			char type = sc.nextLine().charAt(0);

			System.out.printf("Name: ");
			String name = sc.nextLine();

			System.out.printf("Price: ");
			double price = sc.nextDouble();

			if (type == 'c') {
				Product p = new Product(name, price);
				list.add(p);
			} else if (type == 'u') {
				System.out.println("Manufactured Date: ");
				sc.nextLine();
				LocalDate manufacturedDate = LocalDate.parse(sc.nextLine(), formatter);
				Product p = new UsedProduct(name, price, manufacturedDate);
				list.add(p);
			} else if (type == 'i') {
				System.out.println("Customs fee: ");
				double customsFee = sc.nextDouble();
				Product p = new ImportedProduct(name, price, customsFee);
				list.add(p);
			}

		}
		System.out.println("PRICES TAGS: ");
		for(Product p : list) {
			System.out.println(p.priceTag());  
		}
	}
}
