/**@Copyright 2022 keybank pvt ltd.
 * All rights are reserved,you should 
*disclose the information outside
* otherwise terms and condition will apply
 */
package com.payment.client;

import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.payment.model.FinancialServiceRequest;
import com.payment.model.FinancialServiceResponse;

/**
 * @author YNBR 28-Apr-2022
 *
 */
@Component
public class FinancialServiceClientImpl  implements FinancialServiceClient{
	
	

	@Override
	public FinancialServiceResponse doPayments(FinancialServiceRequest financialServiceRequest) {
		// TODO  write the rest client code to connect with oracleFinacanceService
		
		FinancialServiceResponse  finanaceResponse=null;
		System.out.println("---------------FinancialServiceClientImpl-----------------"+financialServiceRequest);
		String uri="http://localhost:9992/v1/finservic";
		//create Header
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		header.set("correlationId",(String) UUID.randomUUID().toString().subSequence(0, 15));
		header.set("messageTS", new Date().toString());
		header.set("client-id", "batch");
		header.set("version", "1.00");
		HttpEntity<FinancialServiceRequest> entity=new HttpEntity<FinancialServiceRequest>(financialServiceRequest,header);
		 finanaceResponse=null;
		RestTemplate restemplate=new RestTemplate();
		restemplate.getMessageConverters()
		.add(new MappingJackson2HttpMessageConverter());
		try {
		ResponseEntity<FinancialServiceResponse> result = restemplate.exchange(uri, HttpMethod.POST,entity ,FinancialServiceResponse.class);
		System.out.println("-----result------"+result);
		System.out.println("-----body------"+result.getBody());
		if(result!=null && "200".equals(result.getStatusCode().OK)) {
			finanaceResponse=result.getBody();
		}
		System.out.println("-----finanaceResponse------"+finanaceResponse);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//PaymentResponse paymentResponse=null;
		
		return finanaceResponse;
	
		
		
	}

}
