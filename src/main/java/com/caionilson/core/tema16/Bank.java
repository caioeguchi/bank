package com.caionilson.core.tema16;

import java.util.ArrayList;
import java.util.List;

import com.caionilson.core.tema16.command.*;

public class Bank {

	private List<Command> extract;

	public Bank() {
		extract = new ArrayList<>();
	}

	public void deposit(double value) {
		System.out.println("Deposit money: $" + value);
	}

	public void withdraw(double value) {
		System.out.println("Withdraw money: $" + value);
	}

	public double balance() {
		double balance = 0;

		for (Command command : extract) {
			if (command instanceof Deposit) {
				balance += ((Deposit) command).getValue();
			} else {
				balance -= ((Withdraw) command).getValue();
			}
		}
		return balance;
	}

	public void setExtract(List<Command> extract) {
		this.extract = extract;
	}

	public List<Command> getExtract() {
		return extract;
	}

}
