/**@Copyright 2022 keybank pvt ltd.
 * All rights are reserved,you should 
*disclose the information outside
* otherwise terms and condition will apply
 */
package com.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.payment.builder.PaymentRequestBuilder;
import com.payment.builder.PaymentResponseBuilder;
import com.payment.client.FinancialServiceClient;
import com.payment.dao.IPaymentDao;
import com.payment.exception.BusinessException;
import com.payment.message.publisher.PaymentKafkaPublisher;
import com.payment.model.FinancialServiceRequest;
import com.payment.model.FinancialServiceResponse;
import com.payment.model.Payment;
import com.payment.model.PaymentDaoRequest;
import com.payment.model.PaymentDaoResponse;
import com.payment.model.PaymentRequest;
import com.payment.model.PaymentResponse;
import com.payment.model.PaymentStatus;
import com.payment.model.StatusBock;
import com.payment.repository.PaymentRepository;

/**
 * @author YNBR 11-Apr-2022
 *
 */
@Component
public class PaymentServiceImpl  implements IPaymentService{
	
	@Autowired
	FinancialServiceClient financialService;
	
	
	
	@Autowired
	PaymentKafkaPublisher  kafkaPublisher;
	
	@Autowired
	IPaymentDao paymentDao;
	
	
	@Autowired
	PaymentRequestBuilder requestBuilder;
	
	@Autowired
	PaymentResponseBuilder responseBuilder;
	
	
	@Autowired
	PaymentRepository respository;

	@Override
	public PaymentResponse doPayments(PaymentRequest request) throws BusinessException {
		
		PaymentDaoResponse	daoResponse=null;
		
		PaymentResponse paymentResponse=null;
		
		// TODO Auto-generated method stub
		
		// 1. prepare the request for financial service
		FinancialServiceRequest financialRequest=requestBuilder.buildFinancialRequest(request);
		
		// 2. call financial service and get response
		FinancialServiceResponse financialResponse = financialService.doPayments(financialRequest);
		
		
		//3. validate financialResponse object , if it isvalid then call kakfaMessagePublisher and dao calls
		
		//4. prepare reqquest for  kafka message publisher
		if(financialResponse!=null  && "0".equals(financialResponse.getRespCode())) {
		  String message = requestBuilder.buildKafkaMessagePublisher(financialResponse);
		
		Payment  paymentDaoRequest=requestBuilder.buildDaoRequest(financialResponse);
		

		kafkaPublisher.paymentStatus(message);
		
		respository.save(paymentDaoRequest);
		
			
		}
		 
		
		
		return paymentResponse;
	}

}
