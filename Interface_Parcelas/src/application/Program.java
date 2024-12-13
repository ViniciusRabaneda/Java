package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.OnlinePaymentService;
import model.services.PaypalService;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.println("Entre os dados do contrato: ");

		System.out.printf("Numero: ");
		int number = sc.nextInt();

		System.out.printf("Data (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.next(),fmt);

		System.out.printf("Valor do Contrato: ");
		double totalValue = sc.nextDouble();

		Contract contract = new Contract(number, date, totalValue);

		System.out.printf("Entre com o numero de parcelas: ");
		int n = sc.nextInt();
		
		OnlinePaymentService onlinePaymentService = new PaypalService(); // upcasting para facilitar manutenção codigo
		

		ContractService contractService = new ContractService(onlinePaymentService);

		contractService.processContract(contract, n);
		
		System.out.println("Parcelas: ");

		for (Installment installment : contract.getInstallments()) {
			System.out.println(installment);

		}

		sc.close();
	}

}
