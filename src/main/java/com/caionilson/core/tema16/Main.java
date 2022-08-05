package com.caionilson.core.tema16;

import java.util.Scanner;

import com.caionilson.core.tema16.command.Deposit;
import com.caionilson.core.tema16.command.Withdraw;

public class Main {
	private static final int DEPOSIT = 1;
	private static final int WITHDRAW = 2;
	private static final int QUIT = 0;

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Bank bank = new Bank();

		double value = 0;
		int op = 99;

		try {
			do {
				System.out.println("---Nilson's bank system---");
				System.out.println("Your balance: $" + bank.balance());
				System.out.println("1 - Deposit");
				System.out.println("2 - Withdraw");
				System.out.println("0 - Quit");

				op = sc.nextInt();
				sc.nextLine();

				switch (op) {
				case DEPOSIT:
					System.out.println("Type the value being deposited");
					value = sc.nextDouble();
					Deposit deposit = new Deposit(bank, value);
					deposit.execute();

					break;
				case WITHDRAW:
					System.out.println("Type the value being withdrawn");
					value = sc.nextDouble();
					Withdraw withdraw = new Withdraw(bank, value);
					withdraw.execute();

					break;
				case QUIT:

					break;
				default:
					System.out.println("Invalid option");

					break;
				}
			} while (op != QUIT);
			System.out.println("Program stopped");
		} catch (InputMismatchException e) {
			System.out.println("Invalid number");
		}
		catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
}
