package org.springframework.samples.petclinic.web;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.samples.petclinic.model.RequestVisit;
import org.springframework.samples.petclinic.service.RequestVisitService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestVisitResource extends AbstractResourceController{

	private final RequestVisitService requestVisitService;
	
	@Autowired
	public RequestVisitResource(RequestVisitService requestVisitService) {
		this.requestVisitService=requestVisitService;
	}
	
	@GetMapping("/requestvisits/list")
	public List<RequestVisit> findRequestVisitAll(){
		return requestVisitService.findRequestVisitAll();
	}
	
	@PostMapping("/requestvisit/newvisitrequest")
	@ResponseStatus(HttpStatus.CREATED)
	public void saveRequestVisit(@Valid @RequestBody RequestVisit requestVisit){
		requestVisitService.saveRequestVisit(requestVisit);
	}
	
	@GetMapping("/requestvisit/{ownerId}/list")
	public Collection<RequestVisit> findRequestVisitByOwnerId(@PathVariable("ownerId") int ownerId){
		return requestVisitService.findRequestVisitByOwnerId(ownerId);
	}
	
	
}
