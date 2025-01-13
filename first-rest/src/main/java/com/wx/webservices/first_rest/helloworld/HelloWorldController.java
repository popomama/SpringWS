package com.wx.webservices.first_rest.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping(path="/hello")
	public String hellowRold()
	{
		return "Hello World";
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
