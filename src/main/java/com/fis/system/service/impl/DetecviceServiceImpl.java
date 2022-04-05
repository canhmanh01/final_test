package com.fis.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.system.entity.Detecvice;
import com.fis.system.repo.DetecviceRepo;
import com.fis.system.service.DetecviceService;

@Service
public class DetecviceServiceImpl implements DetecviceService {
	
	@Autowired
	DetecviceRepo detecviceRepol;

	@Override
	public String adddetecvice(Detecvice detecvice) {
		
		String message  = "thatbai";
		if(detecviceRepol.existsByBadgeNumber(detecvice.getBadgeNumber())) {
			return message;
		}
		detecviceRepol.save(detecvice);
		return "thanh cong";
	}
		// TODO Auto-generated method stub

	

	@Override
	public String updatedetecvice(Detecvice detecvice) {
		
		// TODO Auto-generated method stub
		Detecvice dc = new Detecvice();
		if (detecviceRepol.findById(detecvice.getId()).equals(null)) {
			
			return "id không tồn tại không update";
			
		} else {
			dc.setPerson(dc.getPerson());
			detecviceRepol.save(detecvice);
			return "update thanh cong";
		}
		
	}

	@Override
	public void deletedetecvice(Long detecviceId) {
		// TODO Auto-generated method stub
		
		detecviceRepol.deleteById(detecviceId);
		
	}

	@Override
	public Detecvice findByid(Long detecviceId) {
		// TODO Auto-generated method stub
		return detecviceRepol.getById(detecviceId);
	}
	
	

}
