/**@Copyright 2022 keybank pvt ltd.
 * All rights are reserved,you should 
*disclose the information outside
* otherwise terms and condition will apply
 */
package com.paymentadvice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.payment.exception.BusinessException;
import com.payment.model.PaymentResponse;
import com.payment.model.PaymentStatus;
import com.payment.model.StatusBock;

/**
 * @author YNBR 20-May-2022
 *
 */
@ControllerAdvice
public class PaymentControllerAdvice {

	@ExceptionHandler(value = BusinessException.class)
	public PaymentResponse handleBusinessException(BusinessException be) {
		PaymentResponse resp=new PaymentResponse();
		StatusBock s=new StatusBock();
		s.setRespCode(be.getRespCode());
		s.setRespMsg(be.getRespMsg());
		resp.setStatus(s);
		return resp;

		//resp.setStatus(s);
	}
}
