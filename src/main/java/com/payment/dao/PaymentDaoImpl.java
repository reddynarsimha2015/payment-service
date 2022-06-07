/**@Copyright 2022 keybank pvt ltd.
 * All rights are reserved,you should 
*disclose the information outside
* otherwise terms and condition will apply
 */
package com.payment.dao;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.payment.model.Payment;
import com.payment.model.PaymentDaoRequest;
import com.payment.model.PaymentDaoResponse;

/**
 * @author YNBR 11-Apr-2022
 *
 */
@Component
public class PaymentDaoImpl implements IPaymentDao {

	@Override
	@Async
	public PaymentDaoResponse paymentStatusUpdate(Payment paymentDaoRequest) {
		// TODO Auto-generated method stub
		return null;
	}

}
