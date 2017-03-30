package org.springframework.samples.petclinic.service;

import java.util.Collection;
import java.util.List;

import org.springframework.samples.petclinic.model.RequestVisit;;

public interface RequestVisitService {

	List<RequestVisit> findRequestVisitAll();
	
	void saveRequestVisit(RequestVisit requestVisit);
	
	List<RequestVisit> findRequestVisitByOwnerId(Integer id);
}
