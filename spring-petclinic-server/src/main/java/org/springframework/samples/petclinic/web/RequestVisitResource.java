package org.springframework.samples.petclinic.web;

import java.util.Collection;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.samples.petclinic.model.RequestVisit;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.samples.petclinic.service.RequestVisitService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestVisitResource extends AbstractResourceController{

	private final RequestVisitService requestVisitService;
	private final ClinicService clinicService;
	
	@Autowired
	public RequestVisitResource(RequestVisitService requestVisitService, ClinicService clinicService) {
		this.requestVisitService=requestVisitService;
		this.clinicService=clinicService;
	}
	
	@GetMapping("/requestvisits/list")
	public Collection<RequestVisit> findRequestVisitAll(){
		return requestVisitService.findRequestVisitAll();
	}
	
	@PostMapping("/requestvisit/{ownerId}/newvisitrequest")
	@ResponseStatus(HttpStatus.CREATED)
	public void saveRequestVisit(@Valid @RequestBody RequestVisitInput requestVisitInput, @PathVariable("ownerId") int ownerId){
		
		RequestVisit rv = new RequestVisit();
		rv.setOwner(clinicService.findOwnerById(ownerId));
		rv.setPet(clinicService.findPetById(requestVisitInput.getPetId()));
		rv.setVet(clinicService.findVetById(requestVisitInput.getVetId()));
		rv.setDate(requestVisitInput.getVisitDate());
		rv.setState(0);
		requestVisitService.saveRequestVisit(rv);
	}
	
	@PutMapping("/requestvisit/{requestVisitId}/changestate")
	public RequestVisit changeState(@PathVariable("requestVisitId") int requestVisitId){
		return requestVisitService.updateState(requestVisitService.findById(requestVisitId));
	}
	
	@GetMapping("/requestvisit/{ownerId}/list")
	public Collection<RequestVisit> findRequestVisitByOwnerId(@PathVariable("ownerId") int ownerId){
		return requestVisitService.findRequestVisitByOwnerId(ownerId);
	}
	
	static class RequestVisitInput{
		int vetId;
		int petId;
		Date visitDate;
		
		public int getVetId() {
			return vetId;
		}
		public void setVetId(int vetId) {
			this.vetId = vetId;
		}
		public int getPetId() {
			return petId;
		}
		public void setPetId(int petId) {
			this.petId = petId;
		}
		public Date getVisitDate() {
			return visitDate;
		}
		public void setVisitDate(Date visitDate) {
			this.visitDate = visitDate;
		}
		
		
	}
}
