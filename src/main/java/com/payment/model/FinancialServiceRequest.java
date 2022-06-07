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
public class FinancialServiceRequest {
	private String routingnumber;
	private String accountnumber;
	private String swiftcode;
	private String bankName;

	private String amount;
	private String customerName;
	private String mobilenum;
	private String billingDate;
	private String paymentDate;
}
