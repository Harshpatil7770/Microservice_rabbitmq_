package com.xoriant.settlement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoriant.settlement.dao.CurrencyExchangeDao;
import com.xoriant.settlement.model.CurrencyExchange;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

	@Autowired
	CurrencyExchangeDao currencyExchangeDao;

	@Override
	public String addNewCurrencyExchangeDatails(CurrencyExchange currencyExchange) {
		currencyExchangeDao.save(currencyExchange);
		String result = "New Currency Exchange Details Added Succesfully !!!\n+" + "Form :: "
				+ currencyExchange.getFrom() + " To:: " + currencyExchange.getTo();
		return result;
	}

}
