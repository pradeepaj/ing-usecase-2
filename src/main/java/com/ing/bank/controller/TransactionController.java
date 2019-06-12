package com.ing.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.bank.service.TransactionService;



@RestController
@RequestMapping("/user")
public class TransactionController{
	@Autowired
	private TransactionService transactionService;

	@PostMapping("/transaction/{senderAccNumber}/{receiverAccNumber}/{balance}")

	public String moneyTransfer(@PathVariable long senderAccNumber, @PathVariable long receiverAccNumber,
			@PathVariable double balance) {

		String msg = transactionService.debitTransaction(senderAccNumber, receiverAccNumber,balance);
		return msg;
	}
}
