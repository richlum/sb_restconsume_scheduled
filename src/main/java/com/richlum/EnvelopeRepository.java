package com.richlum;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.docusign.esign.model.Envelope;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/* the following annotation provides automapping of db to rest 
 * 	 some examples 
 * 
 * http://localhost:8080/envelop
 * http://localhost:8080/profile/envelop
 * http://localhost:8080/envelop/search
 * 
 * this is added by below added method to interface.
 * http://localhost:8080/envelop/search/findByStatus?status=voided
 * 
 */
@RepositoryRestResource(collectionResourceRel = "envelope", path = "envelop")
public interface EnvelopeRepository extends CrudRepository<OurEnvelop,Long> {
	List<OurEnvelop> findByStatus(String status);
	
}
