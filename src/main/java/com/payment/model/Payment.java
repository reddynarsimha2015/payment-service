/**@Copyright 2022 keybank pvt ltd.
 * All rights are reserved,you should 
*disclose the information outside
* otherwise terms and condition will apply
 */
package com.payment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author YNBR 20-May-2022
 *
 */
@Entity
@Table(name="payments")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="mob_num")
	private String mobileNum;
	
@Column(name="card_number")	
private String cardNumber;
@Column(name="cvvNum")
private String cvvNum;
@Column(name="expDate")
private String expDate;
@Column(name="nameOnCard")
private String nameOnCard;
@Column(name="paymentStatus")
private String paymentStatus;

}
