package com.caionilson.core.tema16.command;

import com.caionilson.core.tema16.Bank;

public class Withdraw implements Command{

	private Bank bank;
	private double value;
	
	public Withdraw (Bank newBank, double newValue) {
		bank = newBank;
		value = newValue;
	}
	
	@Override
	public void execute() {
		bank.deposit(value);
		bank.getExtract().add(Withdraw.this);
	}

	public double getValue() {
		return value;
	}
}
