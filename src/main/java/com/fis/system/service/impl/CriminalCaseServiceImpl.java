package com.fis.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.system.entity.CaseStatus;
import com.fis.system.entity.CriminalCase;
import com.fis.system.repo.CriminalCaseRepo;
import com.fis.system.service.CriminalCaseService;

@Service
public class CriminalCaseServiceImpl implements CriminalCaseService {
	
	@Autowired 
	CriminalCaseRepo creCaseRepo;
	

	@Override
	public List<CriminalCase> criminalCasesfillall() {
		// TODO Auto-generated method stub
		return creCaseRepo.findAll();
	}

	@Override
	public String addcriminalCase(CriminalCase criminalCase) {
		// TODO Auto-generated method stub
		String message  = "thatbai";
		if(creCaseRepo.existsByNumber(criminalCase.getNumber())) {
			return message;
		}
		creCaseRepo.save(criminalCase);
		return "thanh cong";
	}

	@Override
	public String updatecriminalCase(CriminalCase criminalCase) {
		CriminalCase cs = new CriminalCase();
		//kiem tra id đã tồn tại hay chưa, nếu chưa tồn tại thì ko update, nếu tồn tại update
		if (creCaseRepo.findById(criminalCase.getId()).equals(null)) {

			return "Id không tồn tại!";
		} else {
			cs.setNumber(cs.getNumber());
			cs.setDetailedDescription(cs.getDetailedDescription());
			cs.setNotes(cs.getNotes());
			cs.setShortDescription(cs.getShortDescription());
			cs.setStatus(cs.getStatus());
			cs.setType(cs.getType());
			creCaseRepo.save(criminalCase);
			return "Update thành công!";
		}
		// TODO Auto-generated method stub

	}

	@Override
	public void deletecriminalCase(Long criminalCaseId) {
		// TODO Auto-generated method stub
		creCaseRepo.deleteById(criminalCaseId);
		
	}

	@Override
	public CriminalCase findByid(Long criminalCaseId) {
		// TODO Auto-generated method stub
		return creCaseRepo.getById(criminalCaseId);
	}

	@Override
	public List<CriminalCase> findByStatus(CaseStatus status) {
		// TODO Auto-generated method stub
		return creCaseRepo.findByStatus(status);
	}

}
