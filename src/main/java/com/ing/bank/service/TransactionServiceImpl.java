package com.ing.bank.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.bank.entity.Transaction;
import com.ing.bank.entity.User;
import com.ing.bank.repository.TransactionRepository;
import com.ing.bank.repository.UserRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public String debitTransaction(long senderAccNumber, long receiverAccNumber, double balance) {

		User senderUser = userRepository.findBysenderAccNumber(senderAccNumber);
		User receiveUser = userRepository.findByreceiverAccNumber(receiverAccNumber);
		if (senderUser != null && receiveUser != null) {
			double senderBalance = senderUser.getBalance();
			if (senderBalance >= balance) {
				double newSenderBalance = senderBalance - balance;
				double receiverBalance = receiveUser.getBalance() + balance;
				senderUser.setBalance(newSenderBalance);
				receiveUser.setBalance(receiverBalance);
				userRepository.save(senderUser);
				userRepository.save(receiveUser);
				Transaction transaction1 = new Transaction();
				transaction1.setSender(senderUser.getAccountNumber());
				transaction1.setAmount(balance);
				transaction1.setDescription("debited");
				transaction1.setReceiver(receiveUser.getAccountNumber());
				transaction1.setDate(new Date());
				transactionRepository.save(transaction1);

				Transaction transaction2 = new Transaction();
				transaction2.setSender(senderUser.getAccountNumber());
				transaction2.setAmount(balance);
				transaction2.setDescription("credited");
				transaction2.setReceiver(receiveUser.getAccountNumber());
				transaction2.setDate(new Date());
				transactionRepository.save(transaction2);

				return "Transaction Successfull";

			} else {
				return "Invalid Credetials";

			}

		} else {
			return "Transaction Failed";
		}

	}
}
