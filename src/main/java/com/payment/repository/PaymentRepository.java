/**@Copyright 2022 keybank pvt ltd.
 * All rights are reserved,you should 
*disclose the information outside
* otherwise terms and condition will apply
 */
package com.payment.repository;

import org.hibernate.annotations.Polymorphism;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payment.model.Payment;

/**
 * @author YNBR 20-May-2022
 *
 */
@Repository
public interface PaymentRepository  extends JpaRepository<Payment, String>{

}
