package org.springframework.samples.petclinic.service;

import java.util.Collection;

import org.springframework.samples.petclinic.model.RequestVisit;;

public interface RequestVisitService {

	Collection<RequestVisit> findRequestVisitAll();
	
	void saveRequestVisit(RequestVisit requestVisit);
	
	Collection<RequestVisit> findRequestVisitByOwnerId(Integer id);
	
	RequestVisit findById(int id);
	
	RequestVisit updateState(RequestVisit requestVisit);
}
