package com.wx.webservices.first_rest.versioning;


public class PersonV2 {
	String name;

	public PersonV2(String name) {
		super();
		this.name = name + " V2";
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "PersonV1 [name=" + name + "]";
	}

}
