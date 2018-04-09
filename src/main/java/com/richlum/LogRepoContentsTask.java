package com.richlum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogRepoContentsTask implements Task {
	protected static final Logger log = LoggerFactory.getLogger(PollDocusignTask.class);

	@Override
	public String run() {
		// TODO Auto-generated method stub
		/* dump values in EnvelopeRepository that was written to in PollDocusign */
		repo.findAll().forEach((env) -> {
			log.info("repo: " + env.toString());
		});
		log.info("repo cnt = " + repo.count() + " records");
		return "Total Record Count = " + String.valueOf(repo.count());
	}
	private EnvelopeRepository repo;
	@Autowired
	public void setRepository(EnvelopeRepository repo) {
		this.repo = repo;
	}
}
