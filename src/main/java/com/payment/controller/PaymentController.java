/**@Copyright 2022 keybank pvt ltd.
 * All rights are reserved,you should 
*disclose the information outside
* otherwise terms and condition will apply
 */
package com.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.payment.exception.BusinessException;
import com.payment.model.PaymentRequest;
import com.payment.model.PaymentResponse;
import com.payment.model.PaymentStatus;
import com.payment.model.StatusBock;
import com.payment.service.IPaymentService;
import com.payment.validator.PaymentRequestValidator;

/**
 * @author YNBR 11-Apr-2022
 *
 */
@RestController
@RequestMapping("/v1")
public class PaymentController {
	
	@Autowired
	PaymentRequestValidator paymentRequestValidator;
	
	@Autowired
	IPaymentService paymentService;

int i=0;
	@PostMapping(value="/payments")
	public PaymentResponse doPayments(@RequestBody PaymentRequest paymentRequest,
		@Validated	@RequestHeader("client-id") String clientId,
		@Validated	@RequestHeader("request-id") String requestId,
		@Validated	@RequestHeader("messageTS") String messageTs
			) throws BusinessException {
		// 1. validate the request
		paymentRequestValidator.validateRequest(paymentRequest);
		
		//2. Prepare the request for service
		PaymentResponse response = paymentService.doPayments(paymentRequest);
		//3. call the service and get the response
		//prepare the response and send to consumer/client
		//paymentResponse=responseBuilder.buildPaymentResponse(daoResponse, financialResponse);
		//System.out.println("=====================paymentResponse=========="+paymentResponse);
		PaymentResponse resp=new PaymentResponse();
		PaymentStatus s=new PaymentStatus();
		s.setMobileNumber("09999");
		s.setTxnStatus("sdsd12121");
		StatusBock st=new StatusBock();
		st.setRespCode("0");
		st.setRespMsg("Success");
		resp.setPaymentStatus(s);
		resp.setStatus(st);
		return resp;
		
	}
	//maunally  process files directly on the demand,instead wait run the batch jobs 
	//business tea, will upload files directly   to process data
	//soution: read file , process files
	@ResponseBody
	@RequestMapping(value="/upload",method=RequestMethod.POST,produces = "aplication/json",consumes="aplication/json")
	public PaymentResponse payments(@RequestParam("file") MultipartFile file
			) {
		// 1. got the file from customer/client
	    // 2. parse/read the file and read line by line file split file into mulptiple records
		//3. prpare the jave object
		return null;
		
	}
	//get Status based mobilenumber
	@RequestMapping(value="/payment/{mobileNum}/{paymentDate}",method=RequestMethod.GET,produces ="application/json")
	public String paymentStatus(@PathVariable("mobileNum") String mobileNum,@PathVariable("paymentDate") String paymentDate) {
	String 	status=null;
	return status;
	}
	
}
