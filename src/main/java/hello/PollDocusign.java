package hello;

import java.net.URI;

import javax.ws.rs.core.MediaType;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class PollDocusign {

	
	public String run() {
		try {
			RestTemplate rt = new RestTemplate();
			MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
			headers.add("X-Tenant-Name", "default");

			String headerName;
			String headerValues;
			RequestEntity<String> req = new RequestEntity<String>(headers,HttpMethod.GET,
					new URI("http://gturnquist-quoters.cfapps.io/api/random"));

			ResponseEntity<String> resp = rt.exchange(req,String.class);
			return resp.getBody();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return "";
		}
	}
}
