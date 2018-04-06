package hello;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.docusign.esign.api.EnvelopesApi;
import com.docusign.esign.client.ApiException;
import com.docusign.esign.model.Envelope;
import com.docusign.esign.model.EnvelopesInformation;
import com.docusign.esign.model.Recipients;

@Component
public class ScheduledTask {
	private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Scheduled(fixedRate = 5000)
	public void runTask() {
//		String url = "https://demo.docusign.com/accounts/{accountid}/envelopes?from_date= {fr_date}";
//		String method = "get";
//		HttpEntity requestEntity = new HttpEntity();
//		restTemplate.exchange(url, method, requestEntity, responseType)
		
		PollDocusign pd = new PollDocusign();
		log.info(pd.run());
		
//		RestTemplate  restTemplate = new RestTemplate();
//		Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
//		log.info(quote.toString());
		reportCurrentTime();
	}
	
	
	public void pollDocusignEnvelop(String accountId, String envelopeId) {
		EnvelopesApi envelopesApi = new EnvelopesApi();
		Envelope env = null;
		try {
			env = envelopesApi.getEnvelope(accountId, envelopeId);
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		String details = (
			env.getStatus() +  ", " +
			env.getSentDateTime() +  ", " +
			env.getInitialSentDateTime());
			
			Recipients recipients = env.getRecipients();
			recipients.getSigners().forEach(recip -> {
				
			});
			
	}
	
	public void pollDocusignChanged(String accountId ,String frDate) { // "yyyy/dd/mm" 
		EnvelopesApi envelopesApi = new EnvelopesApi();
		EnvelopesApi.ListStatusChangesOptions options = envelopesApi.new ListStatusChangesOptions();
		options.setFromDate(frDate);
		EnvelopesInformation envelopes = null;
		try {
			envelopes = envelopesApi.listStatusChanges(accountId, options);
		} catch (ApiException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("EnvelopesInformation: " + envelopes);
	}
	
	public void reportCurrentTime() {
		log.info("Time is now {}", dateFormat.format(new Date()) );
	}
}
