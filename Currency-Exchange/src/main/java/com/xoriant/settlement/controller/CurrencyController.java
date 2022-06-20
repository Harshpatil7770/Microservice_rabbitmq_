package com.xoriant.settlement.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.settlement.model.CurrencyExchange;
import com.xoriant.settlement.msg.MessageSender;
import com.xoriant.settlement.service.CurrencyExchangeService;

@RestController
@RequestMapping("/api/currency-exchange")
@CrossOrigin
@RefreshScope
public class CurrencyController {

	@Autowired
	private CurrencyExchangeService currencyExchangeService;

	@Autowired
	MessageSender messageSender;

	@PostMapping("/save")
	public String addNewCurrencyExchangeDetails(@Valid @RequestBody CurrencyExchange currencyExchange) {
		String result = currencyExchangeService.addNewCurrencyExchangeDatails(currencyExchange);
		if (result != null) {

			String msg = "New Currency Exchange Deatails Added !!!  From " + currencyExchange.getFrom() + "\n "
					+ " To:: " + currencyExchange.getTo();
			messageSender.sendNewCurrencyExchangeDatails(msg);
		}
		// return new ResponseEntity<String>(result, HttpStatus.OK);
		return result;
	}

}
