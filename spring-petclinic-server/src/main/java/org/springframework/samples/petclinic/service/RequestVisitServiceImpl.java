package org.springframework.samples.petclinic.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.RequestVisit;
import org.springframework.samples.petclinic.repository.RequestVisitRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RequestVisitServiceImpl implements RequestVisitService{

	@Autowired
	private RequestVisitRepository requestVisitRepository;
	
	@Override
	@Transactional(readOnly=true)
	public Collection<RequestVisit> findRequestVisitAll() {
			return requestVisitRepository.findAll();
	}
	
	@Override
	@Transactional
	public void saveRequestVisit(RequestVisit requestVisit){
		requestVisitRepository.save(requestVisit);
	}

	@Override
	@Transactional
	public Collection<RequestVisit> findRequestVisitByOwnerId(Integer id) {
		return requestVisitRepository.findRequestVisitByOwnerId(id);
	}

	@Override
	@Transactional
	public RequestVisit findById(int id) {
		return requestVisitRepository.findOne(id);
	}

	@Override
	@Transactional
	public RequestVisit updateState(RequestVisit requestVisit) {
		if(requestVisit.getState()==0){
			requestVisit.setState(1);
			saveRequestVisit(requestVisit);
			return requestVisit;
		}
		requestVisit.setState(0);
		saveRequestVisit(requestVisit);
		return requestVisit;
	}

	
}
