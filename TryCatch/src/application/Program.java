/* Fazer um programa para ler os dados de uma conta bancária e depois realizar um saque nesta conta, mostrando o novo saldo.
 * Um saque não pode ocorrer ou se não houver saldo na conta, ou se o valor do saque for superior ao limite do saque da conta.
 * Implemente a conta bancária:
 */
package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter account data");

		

			System.out.printf("Number: ");
			int number = sc.nextInt();

			System.out.printf("Holder: ");
			sc.nextLine();
			String holder = sc.nextLine();

			System.out.println("Initial Balance: ");
			double balance = sc.nextDouble();

			System.out.println("Withdraw limit:  ");
			double limit = sc.nextDouble();
			
			Account account = new Account(number, holder, balance, limit);
			
			System.out.println("Enter the amount for withdraw: ");
			double amount = sc.nextDouble();
			
			try {
			double finalBalance = account.withdraw(amount);
			
			System.out.println("New Balance: " + finalBalance);
			}
			
			
		catch(

	DomainException e)
	{
		System.out.println(e.getMessage());

	}sc.close();
}}
