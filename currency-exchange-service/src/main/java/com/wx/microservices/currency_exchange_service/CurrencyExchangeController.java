package com.wx.microservices.currency_exchange_service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	@Autowired
	CurrencyExchangeRepository repo;
	
	@Autowired
	Environment env;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(
			@PathVariable String from,
			@PathVariable String to)
	{
		//CurrencyExchange currencyExchange = new CurrencyExchange(1000L, from, to, BigDecimal.valueOf(50));
		CurrencyExchange currencyExchange= repo.findByFromAndTo(from, to);
		
		if(currencyExchange==null)
			throw new RuntimeException("cand find conversion");
		String port = env.getProperty("local.server.port");
		currencyExchange.setEnvironment(port);
		
		//repo.
		
		return currencyExchange;
	}

}
