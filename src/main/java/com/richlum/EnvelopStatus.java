package com.richlum;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EnvelopStatus {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
    public String status 			       ;
    public String documentsUri 	       ;
    public String recipientsUri 	       ;
    public String attachmentsUri 	       ;
    public String envelopeUri 		       ;
    public String envelopeId 		       ;
    public String customFieldsUri 	       ;
    public String notificationUri 		   ;
    public String statusChangedDateTime 	;
    public String documentsCombinedUri 	;
    public String certificateUri 			;
    public String templatesUri 			;
    
    
    
    public EnvelopStatus(Long id, String status, String documentsUri, String recipientsUri, String attachmentsUri,
			String envelopeUri, String envelopeId, String customFieldsUri, String notificationUri,
			String statusChangedDateTime, String documentsCombinedUri, String certificateUri, String templatesUri) {
		super();
		this.id = id;
		this.status = status;
		this.documentsUri = documentsUri;
		this.recipientsUri = recipientsUri;
		this.attachmentsUri = attachmentsUri;
		this.envelopeUri = envelopeUri;
		this.envelopeId = envelopeId;
		this.customFieldsUri = customFieldsUri;
		this.notificationUri = notificationUri;
		this.statusChangedDateTime = statusChangedDateTime;
		this.documentsCombinedUri = documentsCombinedUri;
		this.certificateUri = certificateUri;
		this.templatesUri = templatesUri;
	}



	@Override
    public String toString() {
    	return String.format("EnvelopeStatus[id=%s, status=%s, date=%s]",
    			envelopeId, status, statusChangedDateTime);
    }
    
}
