package com.richlum;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.docusign.esign.model.Envelope;

public interface EnvelopeRepository extends CrudRepository<OurEnvelop,Long> {
	List<OurEnvelop> findByStatus(String status);
	
}
