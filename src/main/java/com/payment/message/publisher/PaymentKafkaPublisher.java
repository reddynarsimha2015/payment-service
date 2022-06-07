/**@Copyright 2022 keybank pvt ltd.
 * All rights are reserved,you should 
*disclose the information outside
* otherwise terms and condition will apply
 */
package com.payment.message.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author YNBR 28-Apr-2022
 *
 */
@Component
public class PaymentKafkaPublisher {
	
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "st-topic";

	@Async
	public String  paymentStatus(String message) {
	// todo: need to write the  kakfa client code to publish the message into  kakf server	
		//push the message into kafka server queue
        kafkaTemplate.send(TOPIC, message);

        return "Published successfully";
	}
}
