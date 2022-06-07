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
public class PaymentResponse {
private StatusBock status;
private PaymentStatus paymentStatus;
}
