package com.richlum;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Component
public class ReportCurrentTimeTask implements Task {
	protected static final org.slf4j.Logger log = LoggerFactory.getLogger(ReportCurrentTimeTask.class);
	protected static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Override
	public String run() {
		log.info("Time is now {}", dateFormat.format(new Date()) );
		return "Time is now " +  dateFormat.format(new Date()) ;
	}

}