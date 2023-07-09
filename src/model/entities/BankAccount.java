package model.entities;

import model.exception.DomainException;

public class BankAccount {
	private Integer numer;
	private String holder;
	private double balance;
	private double withdrawLimit;
	
	
	public BankAccount(Integer numer, String holder, Double balance, Double withdrawLimit) {
		this.numer = numer;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}
	
	public Integer getNumer() {
		return numer;
	}
	public String getHolder() {
		return holder;
	}
	public void setHolder(String holder) {
		this.holder = holder;
	}
	public Double getBalance() {
		return balance;
	}
	public Double getWithdrawLimit() {
		return withdrawLimit;
	}
	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	
	public void deposit(Double amount) {
		this.balance += amount;
	}
	public Double withdraw(Double amount) {
		
		if(amount > this.withdrawLimit) {
			throw new DomainException("The amount exceeds withdraw limit.");
		}
		if(amount > this.balance) {
			throw new DomainException("The amount exceeds your balance.");
		}
		this.balance -= amount;
		
		System.out.println("New balance: " + this.balance);
		return amount;
	}
	
	
}
