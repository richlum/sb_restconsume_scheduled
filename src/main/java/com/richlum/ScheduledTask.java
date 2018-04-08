package com.richlum;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@EnableScheduling
@Component
public class ScheduledTask {
	protected static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);
	protected static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	private List<Task> tasks;
	public List<Task> getTasks() {
		return tasks;
	}
	
	// this allows any implementers of Task to be autowired into our same scheduler.
	// nice to put all into same file for scheduling but not required.
	@Autowired
	public void setTask(List<Task> tasks) {
		this.tasks = tasks;
	}

	@Scheduled(fixedRate = 900000)
	public void runTask() {
		
		AtomicInteger cnt = new AtomicInteger();
		tasks.forEach(task -> {
			log.info(cnt.incrementAndGet() + " *** TASK *** " +   task.run());
		});
		
		/* dump values in EnvelopeRepository that was written to in PollDocusign */
		repo.findAll().forEach((env) -> {
			log.info("repo: " + env.toString());
		});
	}

	// this gives us access to the enveloperepository 
	private EnvelopeRepository repo = null;
	@Autowired
	public void setRepo(EnvelopeRepository repo) {
		this.repo = repo;
	}
}
