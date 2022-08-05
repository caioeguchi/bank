package com.caionilson.core.tema16.command;

import com.caionilson.core.tema16.Bank;

public class Deposit implements Command{

	private Bank bank;
	private double value;
	
	public Deposit (Bank newBank, double newValue) {
		bank = newBank;
		value = newValue;
	}
	
	@Override
	public void execute() {
		bank.deposit(value);
		bank.getExtract().add(Deposit.this);
	}

	public double getValue() {
		return value;
	}
}
