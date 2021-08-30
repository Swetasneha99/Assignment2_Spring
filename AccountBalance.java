package com.lti.ex11;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("account")
@Scope("prototype")
public class AccountBalance {
	private double balance;

	public AccountBalance() {
		System.out.println("Default constructor");
	}

	public AccountBalance(double bal) {
		System.out.println("Parameterised constructor");
		balance = bal;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void deposit(double amount) throws AmountException {
		if (amount < 0)
			throw new AmountException("Invalid Amount");
		balance += amount;
		System.out.println("Amount deposited = " + balance);
	}

	public void withdraw(double amount) throws AmountException, BalanceException {
		if (amount < 0)
			throw new AmountException("Invalid Amount");
		if (amount > balance)
			throw new BalanceException("Don't have enough balance");
		balance -= amount;
		System.out.println("Amount withdrawn = " + balance);
	}
}