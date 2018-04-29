package com.example.accountservice;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_ACCOUNT")
public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2428695169835321915L;

	private static Long nextId = 0L;
	
	@Id
	private long id;
	
	private String number;
	
	@Column(name = "name")
	private String owner;
	
	private BigDecimal balance;
	
	protected static long getNetId() {
		synchronized (nextId) {
			return nextId++;
		}
	}

	public Account() {
		super();
		balance = BigDecimal.ZERO;
	}

	public Account(String number, String owner) {
		super();
		id = getNetId();
		this.number = number;
		this.owner = owner;
		balance = BigDecimal.ZERO;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public BigDecimal getBalance() {
		return balance.setScale(2, RoundingMode.HALF_EVEN);
	}
	
	public void withdraw(BigDecimal amount) {
		balance = balance.subtract(amount);
	}
	
	public void deposit(BigDecimal amount) {
		balance = balance.add(amount);
	}
	
	@Override
	public String toString() {
		return number + " [" + owner + "]: $" + balance;
	}
}
