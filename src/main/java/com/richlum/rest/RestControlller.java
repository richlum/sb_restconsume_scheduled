package com.richlum.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.richlum.EnvelopeRepository;
import com.richlum.OurEnvelop;
import com.richlum.SchedulerTask;

@RestController
public class RestControlller {
	protected static final Logger log = LoggerFactory.getLogger(RestControlller.class);
	
	@Value("${message:Hello default}")
	private String message;
	
	@RequestMapping("/")
	public String getMessage() {
		return this.message;
	}
	
	// this gives us access to the enveloperepository 
	private EnvelopeRepository repo = null;
	@Autowired
	public void setRepo(EnvelopeRepository repo) {
		this.repo = repo;
	}
	
	
	@RequestMapping("/envelopes")
	public String getEnvelopes() {
		
		log.info("request /envelopes " + repo.count());
		String response = "";
		for (OurEnvelop env: repo.findAll()) {
			response = response.concat(env.toString()).concat("\n");
		}
		return response;
	}
}
