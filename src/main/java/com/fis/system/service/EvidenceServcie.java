package com.fis.system.service;

import java.util.List;

import javax.persistence.CascadeType;

import com.fis.system.entity.Evidence;

public interface EvidenceServcie {
	
	String addevidence(Evidence evidence);

	String updateevidence(Evidence evidence);

	void deleteevidence(Long evidenceId);

	Evidence findByid(Long evidenceId);

	List<Evidence> findEvidences(CascadeType type);
}
