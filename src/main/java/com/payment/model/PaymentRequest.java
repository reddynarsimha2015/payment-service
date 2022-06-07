/**@Copyright 2022 keybank pvt ltd.
 * All rights are reserved,you should 
*disclose the information outside
* otherwise terms and condition will apply
 */
package com.payment.model;

import java.util.List;

import lombok.Data;

/**
 * @author YNBR 11-Apr-2022
 *
 */
@Data
public class PaymentRequest {
	private String customerName;
	private String cardNumber;
	private  String cvvNum;
	private String expDate;
	private String mobileNumber;
	private String amount;
	private String billDate; 
}
