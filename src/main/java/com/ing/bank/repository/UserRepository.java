package com.ing.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ing.bank.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByAccountNumber(long accountNumber);
	@Query("select u from User u where u.accountNumber=:senderAccNumber")
	User findBysenderAccNumber(@Param ("senderAccNumber")long senderAccNumber);
	
	  @Query("select u from User u where u.accountNumber=:receiverAccNumber") 
	 User findByreceiverAccNumber(@Param ("receiverAccNumber")long receiverAccNumber);
	
}
