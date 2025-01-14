package com.wx.webservices.first_rest.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	MessageSource messageSource;
	
	public HelloWorldController(MessageSource messageSource) {
		super();
		this.messageSource = messageSource;
	}
	
	@GetMapping(path="/hello")
	public String helloworld()
	{
		return "Hello World";
	}
	
	
	@GetMapping(path="/hello-international")
	public String hellowworldInternal()
	{
		
		Locale locale=  LocaleContextHolder.getLocale();
		String msg =messageSource.getMessage("good.morning.message", null, "Default Message",locale );
		return msg;
	}
	
	
	


	@GetMapping(path="/hello-bean")
	public HelloWorldBean helloWorldBean()
	{
		return new HelloWorldBean("Hello World 1 Bean"); 
	}
	
	
	@GetMapping(path="/hello-bean/PV/{name}")
	public HelloWorldBean helloWorldBeanPV(@PathVariable String name)
	{
		return new HelloWorldBean("Hello World 1 Bean " + name); 
	}


}
