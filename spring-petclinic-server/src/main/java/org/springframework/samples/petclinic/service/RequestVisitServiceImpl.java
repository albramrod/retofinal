package org.springframework.samples.petclinic.service;

import java.util.Collection;
import java.util.List;

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
	public List<RequestVisit> findRequestVisitAll() {
			return requestVisitRepository.findAll();
	}
	
	@Override
	@Transactional
	public void saveRequestVisit(RequestVisit requestVisit){
		requestVisitRepository.save(requestVisit);
	}

	@Override
	@Transactional
	public List<RequestVisit> findRequestVisitByOwnerId(Integer id) {
		return requestVisitRepository.findRequestVisitByOwnerId(id);
	}

	
}
