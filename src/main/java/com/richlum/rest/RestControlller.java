package com.richlum.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControlller {
	@Value("${message:Hello default}")
	private String message;
	
	@RequestMapping("/")
	public String getMessage() {
		return this.message;
	}
	
	
}
