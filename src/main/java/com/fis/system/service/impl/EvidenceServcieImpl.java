package com.fis.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.system.entity.CriminalCase;
import com.fis.system.entity.Evidence;
import com.fis.system.repo.CriminalCaseRepo;
import com.fis.system.repo.EvidenceRepo;
import com.fis.system.service.EvidenceServcie;

@Service
public class EvidenceServcieImpl implements EvidenceServcie {
	@Autowired
	EvidenceRepo evidenceRepo;
	
	@Autowired 
	CriminalCaseRepo creCaseRepo;

	@Override
	public String addevidence(Evidence evidence) {
		String message  = "thatbai";
		if(evidenceRepo.existsByNumber(evidence.getNumber())) {
			return message;
		}
		evidenceRepo.save(evidence);
		return "thanh cong";
	}

	@Override
	public String updateevidence(Evidence evidence) {
		// TODO Auto-generated method stub
		Evidence evd = new Evidence();
		if (evidenceRepo.findById(evidence.getId()).equals(null)) {

			return "id không tồn tại";

		} else {
			evd.setArchived(evd.getArchived());
			evd.setCriminalCase(evd.getCriminalCase());
			evd.setItemName(evd.getItemName());
			evd.setNotes(evd.getNotes());
			evd.setNumber(evd.getNumber());
			return "update thanh cong";
		}

	}

	@Override
	public void deleteevidence(Long evidenceId) {
		// TODO Auto-generated method stub

		evidenceRepo.deleteById(evidenceId);

	}

	@Override
	public Evidence findByid(Long evidenceId) {
		// TODO Auto-generated method stub
		return evidenceRepo.getById(evidenceId);
	}

	@Override
	public List<Evidence> findEvidences(CascadeType type) {
		// TODO Auto-generated method stub
		List<CriminalCase> listCri = creCaseRepo.findByType(type);
		List<Evidence> listEvil = new ArrayList<>();
		for (CriminalCase criminalCase : listCri) {
			
			List<Evidence> listEvi= evidenceRepo.findByCriminalCase(criminalCase);
			listEvil.addAll(listEvi);
			
		}
		return listEvil;
	}

}
