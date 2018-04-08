package com.richlum;

/*
 * annotations to allow fasterxml to map json field names to this object.
 * Multiple entries of same type need help of annotations to disambiguate.
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StatusResponse {
	
	@JsonProperty("resultSetSize")
	public String resultSetSize;
	@JsonProperty("totalSetSize")
	public String totalSetSize;
	@JsonProperty("startPosition")
	public String startPosition;
	@JsonProperty("endPosition")
	public String endPosition;
	@JsonProperty("nextUri")
	public String nextUri;
	@JsonProperty("previousUri")
	public String previousUri;
	@JsonProperty("envelopes")
	public EnvelopStatus[] envelopes;
	
	
//	public StatusResponse() {};
//	@JsonCreator
//	public StatusResponse(
//			@JsonProperty("resultSetSize") String resultSetSize, 
//			@JsonProperty("totalSetSize") String totalSetSize, 
//			@JsonProperty("startPosition") String startPosition, 
//			@JsonProperty("endPosition") String endPosition,
//			@JsonProperty("nextUri") String nextUri, 
//			@JsonProperty("previousUri") String previousUri, 
//			@JsonProperty("envelopes") EnvelopStatus[] envelopes) {
//		super();
//		this.resultSetSize = resultSetSize;
//		this.totalSetSize = totalSetSize;
//		this.startPosition = startPosition;
//		this.endPosition = endPosition;
//		this.nextUri = nextUri;
//		this.previousUri = previousUri;
//		this.envelopes = envelopes;
//	}
	@JsonProperty("endPosition")
	public String getResultSetSize() {
		return resultSetSize;
	}
	@JsonProperty("endPosition")
	public void setResultSetSize(String resultSetSize) {
		this.resultSetSize = resultSetSize;
	}
	@JsonProperty("endPosition")
	public String getTotalSetSize() {
		return totalSetSize;
	}
	@JsonProperty("endPosition")
	public void setTotalSetSize(String totalSetSize) {
		this.totalSetSize = totalSetSize;
	}
	@JsonProperty("endPosition")
	public String getStartPosition() {
		return startPosition;
	}
	public void setStartPosition(String startPosition) {
		this.startPosition = startPosition;
	}
	public String getEndPosition() {
		return endPosition;
	}
	public void setEndPosition(String endPosition) {
		this.endPosition = endPosition;
	}
	public String getNextUri() {
		return nextUri;
	}
	public void setNextUri(String nextUri) {
		this.nextUri = nextUri;
	}
	public String getPreviousUri() {
		return previousUri;
	}
	public void setPreviousUri(String previousUri) {
		this.previousUri = previousUri;
	}
	public EnvelopStatus[] getEnvelopes() {
		return envelopes;
	}
	public void setEnvelopes(EnvelopStatus[] envelopes) {
		this.envelopes = envelopes;
	}
	
}
