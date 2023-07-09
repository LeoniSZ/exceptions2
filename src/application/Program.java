package application;

import java.util.Scanner;

import model.entities.BankAccount;
import model.exception.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Enter account data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		
		System.out.print("Holder: ");
		String holder = sc.nextLine();
		
		System.out.print("Initial balance: ");
		double balance = sc.nextDouble();
		
		System.out.print("Withdraw limit: ");
		double withdrawLimit = sc.nextDouble();
		
		
		BankAccount bankAccount = new BankAccount(number, holder, balance, withdrawLimit);
		try {
			System.out.println("Enter amount for withdraw");
			Double amount = sc.nextDouble();
			bankAccount.withdraw(amount);
		}
		catch(DomainException e) {
			System.out.println("Error in BankAccount: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error.");
		}
		
		
		sc.close();
	}

}
