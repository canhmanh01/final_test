package com.fis.system.repo;

import java.util.List;

import javax.persistence.CascadeType;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fis.system.entity.CaseStatus;
import com.fis.system.entity.CriminalCase;

public interface CriminalCaseRepo extends JpaRepository<CriminalCase, Long> {
	
	boolean existsByNumber(String number);
	
	CriminalCase findByNumber(String number);
	
	List<CriminalCase> findByStatus(CaseStatus status);

	List<CriminalCase> findByType(CascadeType type);
	
	

}
