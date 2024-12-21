package application;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enums.OrderStatus;

public class Main {

	public static void main(String[] args) {
		
        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter client data:");
		System.out.printf("Name: ");
		String name = sc.nextLine();
		
		System.out.printf("Email: ");
		String email = sc.nextLine();
		
		System.out.printf("Birth date (dd/MM/yyyy): ");
		LocalDate birthDate = LocalDate.parse(sc.next(),sdf);
		
		Client client = new Client(name,email,birthDate);
		
		System.out.println("Enter order data: ");
		System.out.printf("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		
		
		Order order = new Order(LocalDateTime.now(),status,client);
		
		
		
		System.out.println("How many items to this order? ");
		int N = sc.nextInt();
		for(int i = 1; i<=N;i++) {
			System.out.println("Enter "+(i)+" item data");
			System.out.println("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			
			System.out.println("Product price: ");
			double productPrice = sc.nextDouble();
			
			System.out.println("Quantity: ");
			int productQuantity = sc.nextInt();
			
			Product product = new Product(productName,productPrice);
			
			OrderItem it = new OrderItem(productQuantity,productPrice,product);
			
			order.addItem(it);
			
		}
		System.out.println();
		System.out.println(order);
		sc.close();
	}

}
