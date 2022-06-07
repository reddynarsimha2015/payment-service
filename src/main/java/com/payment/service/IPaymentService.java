/**@Copyright 2022 keybank pvt ltd.
 * All rights are reserved,you should 
*disclose the information outside
* otherwise terms and condition will apply
 */
package com.payment.service;

import com.payment.exception.BusinessException;
import com.payment.model.PaymentRequest;
import com.payment.model.PaymentResponse;

/**
 * @author YNBR 11-Apr-2022
 *
 */
public interface IPaymentService {
PaymentResponse	doPayments (PaymentRequest request)throws BusinessException;
}
