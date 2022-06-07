/**@Copyright 2022 keybank pvt ltd.
 * All rights are reserved,you should 
*disclose the information outside
* otherwise terms and condition will apply
 */
package com.payment.builder;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.payment.exception.BusinessException;
import com.payment.model.FinancialServiceRequest;
import com.payment.model.FinancialServiceResponse;
import com.payment.model.Payment;
import com.payment.model.PaymentDaoRequest;
import com.payment.model.PaymentRequest;

/**
 * @author YNBR 11-Apr-2022
 *
 */
@Component
public class PaymentRequestBuilder {
  public FinancialServiceRequest buildFinancialRequest(PaymentRequest paymentRequest) {
	  
	  //prepare FinancialServiceRequest  with the hel of paymentRequest
	  FinancialServiceRequest request=new FinancialServiceRequest();
	  request.setAccountnumber("355555");
	  request.setAmount(paymentRequest.getAmount());
	  request.setBankName("Jp morgan");
	  request.setBillingDate(paymentRequest.getBillDate());
	  request.setCustomerName(paymentRequest.getCustomerName());
	  request.setMobilenum(paymentRequest.getMobileNumber());
	 // request.setPaymentDate(paymentRequest.get);
	  request.setRoutingnumber("0002");
	  request.setSwiftcode("JC002");
	  //request.setBillingDate(paymentRequest.getPa);
	  
	  
	return request;
	  
  }

/**
 * @param financialResponse
 * @return
 * @throws JsonProcessingException 
 * @throws BusinessException 
 */
public String buildKafkaMessagePublisher(FinancialServiceResponse financialResponse) throws BusinessException {
	
	String message=null;
	try {
		ObjectMapper mapper=new ObjectMapper();
		message = mapper.writeValueAsString(financialResponse);
	} catch (JsonProcessingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new BusinessException("ppps001", "finaancial service json failed");
	}
	// TODO  prepare the message with help of  finacnicl response
	return message;
}

/**
 * @param financialResponse
 * @return
 */
public Payment buildDaoRequest(FinancialServiceResponse financialResponse) {
	// TODO  prepare request with help FinancialService 
	
	return null;
}
}
