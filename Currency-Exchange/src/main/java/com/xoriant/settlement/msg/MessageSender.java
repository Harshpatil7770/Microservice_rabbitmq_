package com.xoriant.settlement.msg;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller
public class MessageSender {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Bean
	public Queue addNewTransactionDetails() {
		return new Queue("CurrencyExchangeQ", false);
	}

	public void sendNewCurrencyExchangeDatails(String msg) {
		System.out.println("===============================");
		System.out.println(msg);
		System.out.println("===============================");
		rabbitTemplate.convertAndSend("CurrencyExchangeQ", msg);
	}
}
