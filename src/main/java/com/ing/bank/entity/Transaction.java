package com.ing.bank.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TransactionDetails")

public class Transaction {
	public Transaction() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long transactionId;
	private long sender;
	private long receiver;
	private double amount;
	private String description;
	private Date date;
	@ManyToOne
	private User user;

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public long getSender() {
		return sender;
	}

	public void setSender(long sender) {
		this.sender = sender;
	}

	public long getReceiver() {
		return receiver;
	}

	public void setReceiver(long receiver) {
		this.receiver = receiver;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Transaction(long transactionId, long sender, long receiver, double amount, String description,
			Date date) {
		super();
		this.transactionId = transactionId;
		this.sender = sender;
		this.receiver = receiver;
		this.amount = amount;
		this.description = description;
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
