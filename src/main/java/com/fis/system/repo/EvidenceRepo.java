package com.fis.system.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fis.system.entity.CriminalCase;
import com.fis.system.entity.Evidence;

public interface EvidenceRepo extends JpaRepository<Evidence, Long> {
	
	boolean existsByNumber(String number);
	
	Evidence findByNumber(String number);
	
	List<Evidence> findByCriminalCase(CriminalCase criminalCase);

}
