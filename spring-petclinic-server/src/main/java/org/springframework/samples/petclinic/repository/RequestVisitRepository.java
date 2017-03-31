package org.springframework.samples.petclinic.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.RequestVisit;

public interface RequestVisitRepository extends JpaRepository<RequestVisit, Integer>{

	@Query("select v from RequestVisit v where v.owner.id= :id")
	public Collection<RequestVisit> findRequestVisitByOwnerId(@Param("id") Integer id);
	
	
}
