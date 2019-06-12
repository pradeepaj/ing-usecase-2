package com.ing.bank.service;

public interface TransactionService {

	String debitTransaction(long senderAccNumber, long receiverAccNumber,double balance);

}
