package com.wx.webservices.first_rest.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties("f1")
@JsonFilter("SomeBeanFilter")
public class SomeBean {

	String f1;
	
	//@JsonIgnore
	String f2;
	String f3;
	
	
	public SomeBean(String f1, String f2, String f3) {
		super();
		this.f1 = f1;
		this.f2 = f2;
		this.f3 = f3;
	}


	public String getF1() {
		return f1;
	}


	public void setF1(String f1) {
		this.f1 = f1;
	}


	public String getF2() {
		return f2;
	}


	public void setF2(String f2) {
		this.f2 = f2;
	}


	public String getF3() {
		return f3;
	}


	public void setF3(String f3) {
		this.f3 = f3;
	}	
}
