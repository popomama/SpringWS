package com.wx.microservices.currency_conversion_service;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//import com.wx.microservices.currency_exchange_service.CurrencyExchange;

//@FeignClient(name="currency-exchange-service", url="localhost:8000")
//@EnableFeignClients
@FeignClient(name="currency-exchange-service") 
//@FeignClient(name="currency-exchange-service", configuration=FeignClientsConfiguration.class) 
public interface CurrencyExchangeProxy  {
	

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retrieveExchangeValue(
			@PathVariable String from,
			@PathVariable String to);
	
}
