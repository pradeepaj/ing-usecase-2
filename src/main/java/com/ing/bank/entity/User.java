package com.ing.bank.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table
public class User {
	@Id
	@GeneratedValue(generator = "pooled")
	@GenericGenerator(name = "pooled", strategy = "enhanced-table", parameters = {
			@Parameter(name = "value_column_name", value = "sequence_next_hi_value"),
			@Parameter(name = "prefer_entity_table_as_segment_value", value = "true"),

			@Parameter(name = "optimizer", value = "pooled-lo"), @Parameter(name = "increment_size", value = "9836") })

	private long accountNumber;
	private String name;
	private String ifsc;
	private double balance;
	private String bankName;
	@OneToMany
	private List<Transaction> transaction;

	

	public User(long accountNumber, String name, String ifsc, double balance, String bankName) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.ifsc = ifsc;
		this.balance = balance;
		this.bankName = bankName;
	}

	@Override
	public String toString() {
		return "User [accountNumber=" + accountNumber + ", name=" + name + ", ifsc=" + ifsc + ", balance=" + balance
				+ ", bankName=" + bankName + "]";
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public User() {

	}

	public List<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}


}
