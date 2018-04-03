package hello;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class ScheduledTask {
	private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Scheduled(fixedRate = 5000)
	public void runTask() {
		RestTemplate  restTemplate = new RestTemplate();
		Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
		log.info(quote.toString());
		reportCurrentTime();
	}
	
	
	public void reportCurrentTime() {
		log.info("Time is now {}", dateFormat.format(new Date()) );
	}
}
