/**@Copyright 2022 keybank pvt ltd.
 * All rights are reserved,you should 
*disclose the information outside
* otherwise terms and condition will apply
 */
package com.payment.validator;

import org.springframework.stereotype.Component;

import com.payment.model.PaymentRequest;

/**
 * @author YNBR 11-Apr-2022
 *
 */
@Component
public class PaymentRequestValidator {

	public void validateRequest(PaymentRequest paymentRequest) {
		//validate the all manditory request eleements ,if any of  the elements is invalid then
		// throw the userdefined exception
		
	}
}
