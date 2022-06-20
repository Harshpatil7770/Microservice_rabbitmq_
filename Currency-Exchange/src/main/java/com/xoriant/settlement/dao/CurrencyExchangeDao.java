package com.xoriant.settlement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xoriant.settlement.model.CurrencyExchange;
@Repository
public interface CurrencyExchangeDao extends JpaRepository<CurrencyExchange, Integer>{

}
