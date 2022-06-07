/**@Copyright 2022 keybank pvt ltd.
 * All rights are reserved,you should 
*disclose the information outside
* otherwise terms and condition will apply
 */
package com.payment.model;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author YNBR 11-Apr-2022
 *
 */
public class JsonToJavaObject {
	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		ObjectMapper o=new ObjectMapper();
		PaymentRequest req = o.readValue(new File("D:\\javaRealTime_project_15_03_2022\\payment-service\\src\\main\\resources\\payment-request.json"),PaymentRequest.class);
	System.out.println("------req----------"+req);
	}

}
