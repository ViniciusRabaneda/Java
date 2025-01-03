package entities;

import exceptions.DomainException;

public class Account {
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}
	
	public Account() {
		
	}

	public Integer getNumber() {
		return number;
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

	public void deposit(Double amount) {
		 balance +=amount;
		
	}
	
	public double withdraw(Double amount) throws DomainException {
		if(amount > withdrawLimit) {
			throw new DomainException("The amount exceeds withdraw limit");
		}
		if(amount > balance) {
			throw new DomainException("Not Enough Balance");
		}
		return balance -=amount;
	}
	
	
	
	
}
