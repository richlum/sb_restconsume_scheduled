package hello;

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
	}

}
