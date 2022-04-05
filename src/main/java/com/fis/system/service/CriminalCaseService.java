package com.fis.system.service;

import java.util.List;

import com.fis.system.entity.CaseStatus;
import com.fis.system.entity.CriminalCase;

public interface CriminalCaseService {

	List<CriminalCase> criminalCasesfillall();

	String addcriminalCase(CriminalCase criminalCase);

	String updatecriminalCase(CriminalCase criminalCase);

	void deletecriminalCase(Long criminalCaseId);

	CriminalCase findByid(Long criminalCaseId);
	
	List<CriminalCase> findByStatus(CaseStatus status);
}
