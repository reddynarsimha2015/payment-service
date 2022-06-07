/**@Copyright 2022 keybank pvt ltd.
 * All rights are reserved,you should 
*disclose the information outside
* otherwise terms and condition will apply
 */
package com.payment.exception;

import lombok.Getter;

/**
 * @author YNBR 11-Apr-2022
 *
 */
@Getter
public class PaymentRequestInvalidException extends Exception {

	
	private String respCode;
	private String respMsg;
	/**
	 * @param respCode
	 * @param respMsg
	 */
	public PaymentRequestInvalidException(String respCode, String respMsg) {
		this.respCode = respCode;
		this.respMsg = respMsg;
	}
	
}
