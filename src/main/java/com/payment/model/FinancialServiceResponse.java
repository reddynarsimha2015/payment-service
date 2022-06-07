/**@Copyright 2022 keybank pvt ltd.
 * All rights are reserved,you should 
*disclose the information outside
* otherwise terms and condition will apply
 */
package com.payment.model;

import lombok.Data;

/**
 * @author YNBR 28-Apr-2022
 *
 */
@Data
public class FinancialServiceResponse {
	private String respCode;
	private String respMsg;
	private String ackNum;
	private String description;
}
