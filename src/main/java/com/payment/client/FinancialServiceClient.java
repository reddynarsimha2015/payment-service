/**@Copyright 2022 keybank pvt ltd.
 * All rights are reserved,you should 
*disclose the information outside
* otherwise terms and condition will apply
 */
package com.payment.client;

import com.payment.model.FinancialServiceRequest;
import com.payment.model.FinancialServiceResponse;
import com.payment.model.PaymentResponse;

/**
 * @author YNBR 28-Apr-2022
 *
 */
public interface FinancialServiceClient {
	public FinancialServiceResponse doPayments(FinancialServiceRequest financialServiceRequest);
}
