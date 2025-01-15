package com.wx.webservices.first_rest.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

	@GetMapping("/v1/person")
	public PersonV1 getFirstVersion() {
		return new PersonV1("Bob");
	}
	
	
	@GetMapping("/v2/person")
	public PersonV2 getSecondVersion() {
		return new PersonV2("Bob");
	}

	
	// http://localhost:8080/person?version=2
	@GetMapping(path="/person", params="version=1")
	public PersonV1 getFirstVersionPar() {
		return new PersonV1("Bob");
	}
	
	
	@GetMapping(path="/person", params="version=2")
	public PersonV2 getSecondVersionPar() {
		return new PersonV2("Bob");
	}
	
	//the name of the headers is not significant.
	@GetMapping(path="/person/header", headers="X-API-VERSION=1")
	public PersonV1 getFirstVersionHeader() {
		return new PersonV1("Bob");
	}
	
	
	@GetMapping(path="/person/header", headers="X-API-VERSION=2")
	public PersonV2 getSecondVersionHeader() {
		return new PersonV2("Bob");
	}
	
}
