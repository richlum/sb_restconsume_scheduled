package com.richlum;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.docusign.esign.model.Envelope;

@Entity
public class OurEnvelop {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String status;
	private String envelopId;
	private String documentsUri;
	private String recipientsUri;
	private String attachmentsUri;
	private String envelopeUri;
	private String customFieldsUri;
	private String notificationUri;
	private String statusChangedDateTime;
	private String documentsCombinedUri;
	private String certificateUri;
	private String templatesUri;
	
	
	
	public OurEnvelop(Long id, String status, String envelopId, String documentsUri, String recipientsUri,
			String attachmentsUri, String envelopeUri, String customFieldsUri, String notificationUri,
			String statusChangedDateTime, String documentsCombinedUri, String certiricateUri, String templatesUri) {
		super();
		this.id = id;
		this.status = status;
		this.envelopId = envelopId;
		this.documentsUri = documentsUri;
		this.recipientsUri = recipientsUri;
		this.attachmentsUri = attachmentsUri;
		this.envelopeUri = envelopeUri;
		this.customFieldsUri = customFieldsUri;
		this.notificationUri = notificationUri;
		this.statusChangedDateTime = statusChangedDateTime;
		this.documentsCombinedUri = documentsCombinedUri;
		this.certificateUri = certiricateUri;
		this.templatesUri = templatesUri;

	}

	// empty ctor required by jpa since it uses reflection to instantiate
	public OurEnvelop() {};

	public OurEnvelop(Long id, String status, String envelopId, String statusChangedDateTime) {
		super();
		this.id = id;
		this.status = status;
		this.envelopId = envelopId;
		this.statusChangedDateTime = statusChangedDateTime;
	}



	public OurEnvelop(Envelope envStat) {
		// TODO Auto-generated constructor stub
		this.status                 = envStat.getStatus();
		this.envelopId              = envStat.getEnvelopeId();
		this.documentsUri           = envStat.getDocumentsUri();
		this.recipientsUri          = envStat.getRecipientsUri();
		this.attachmentsUri         = envStat.getAttachmentsUri();
		this.envelopeUri            = envStat.getEnvelopeUri();
		this.customFieldsUri        = envStat.getCustomFieldsUri();
		this.notificationUri        = envStat.getNotificationUri();
		this.statusChangedDateTime  = envStat.getStatusChangedDateTime();
		this.documentsCombinedUri   = envStat.getDocumentsCombinedUri();
		this.certificateUri         = envStat.getCertificateUri();
		this.templatesUri           = envStat.getTemplatesUri();
		
		
		
		
		
		
		
		
		
	}



	public String toString() {
		return String.format("[status=%s, id=%s, date=%s]", status, envelopId,statusChangedDateTime);
	}
}
