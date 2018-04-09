package com.richlum;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import com.docusign.esign.model.EnvelopesInformation;
import com.docusign.esign.model.Envelope;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class PollDocusignTask implements Task {
	protected static final Logger log = LoggerFactory.getLogger(PollDocusignTask.class);
	
	@Value("${inform.docusign.acct}")
	private String acct;
	@Value("${inform.docusign.queryuri}")
	private String queryuri;
	@Value("${inform.docusign.username}")
	private String username;
	@Value("${inform.docusign.password}")
	private String password;
	@Value("${inform.docusign.apikey}")
	private String apikey;
	@Value("${inform.docusign.daysback:1}")
	private int daysback;

	public String run() {
		String targ_date = getTargDate();
		log.info(targ_date);
		String fulluri = queryuri + acct + "/envelopes?from_date=" + getTargDate();
		try {
			RestTemplate rt = new RestTemplate();
			MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
			URI uri = new URI(fulluri);
			headers.add("X-DocuSign-Authentication", 
					"{ \"Username\":\"" + username + 
					"\", \"Password\":\"" + password + 
					"\", \"IntegratorKey\":\"" + apikey +
					"\" }");
			
			RequestEntity<String> req = new RequestEntity<String>(headers,HttpMethod.GET,
					uri);
			
			try {
				ResponseEntity<EnvelopesInformation> resp = rt.exchange(req, EnvelopesInformation.class);
				String respAsString = "";
//				repo.deleteAll();   todo: do we want a clean reset each time?
				if ((resp!=null)&&(resp.getBody()!=null)) {
					for(Envelope  envStat : resp.getBody().getEnvelopes() ) {
						log.info(getShortVersion(envStat));
						repo.save(new OurEnvelop(envStat));
					}			
				}	
				return Long.toString(repo.count()) + " records in envelop repository";
			} catch (Exception e) {
				System.err.println(e.getMessage());
				return "error " + e.getMessage();
			}			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return "";
		}
	}
	
	public String getShortVersion(Envelope env) {
		return "[ ".concat(env.getStatus()).concat(", ")
					.concat(env.getEnvelopeId()).concat(", ")
					.concat(env.getStatusChangedDateTime()).concat(" ] ");
	}
	
	public String getTargDate() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, -(daysback));
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		return sdf.format(cal.getTime());
	}
	

	private EnvelopeRepository repo;
	@Autowired
	public void setRepository(EnvelopeRepository repo) {
		this.repo = repo;
	}
	
}
