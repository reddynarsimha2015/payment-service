/**@Copyright 2022 keybank pvt ltd.
 * All rights are reserved,you should 
*disclose the information outside
* otherwise terms and condition will apply
 */
package com.payment.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author YNBR 11-Apr-2022
 *
 *
 */
public class javaObjectToJsonDemo {
public static void main(String[] args) throws JsonProcessingException {
	PaymentRequest cust=new PaymentRequest();
	
	cust.setAmount("1000");
	cust.setBillDate("22-04-2022");
	cust.setCardNumber("121212121");
	cust.setCustomerName("sreenu");
	cust.setCvvNum("1212");
	cust.setExpDate("11-2029");
	cust.setMobileNumber("998999999");
	
	
	ObjectMapper obj=new ObjectMapper();
	String s=obj.writerWithDefaultPrettyPrinter().writeValueAsString(cust);
	System.out.println(s);
	
	
	
}
}
