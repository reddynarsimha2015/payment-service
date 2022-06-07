/**@Copyright 2022 keybank pvt ltd.
 * All rights are reserved,you should 
*disclose the information outside
* otherwise terms and condition will apply
 */
package com.payment.builder;

import org.springframework.stereotype.Component;

import com.payment.model.FinancialServiceResponse;
import com.payment.model.PaymentDaoRequest;
import com.payment.model.PaymentDaoResponse;
import com.payment.model.PaymentResponse;

/**
 * @author YNBR 11-Apr-2022
 *
 */
@Component
public class PaymentResponseBuilder {

 public  PaymentResponse buildPaymentResponse(PaymentDaoResponse daoResponse, FinancialServiceResponse finResp) {
	 
	//prepare final payment response;
	return null;
	 
 }
	
}
