package com.fis.system;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.fis.system.entity.CriminalCase;
import com.fis.system.entity.Evidence;
import com.fis.system.entity.Storage;
import com.fis.system.repo.CriminalCaseRepo;
import com.fis.system.repo.EvidenceRepo;
import com.fis.system.service.impl.EvidenceServcieImpl;

@SpringBootTest
public class EvidenceServiceTest {
	@Mock
	Storage storageRepo;
	
	@Mock
	EvidenceRepo evidenceRepo;
	
	@Mock
	CriminalCaseRepo criminalCaseRepo;
	
	@InjectMocks
	EvidenceServcieImpl evidenceService;
	
	@Test
	void add_success() {
		Storage s=new Storage();
		s.setName("1");
		CriminalCase c=new CriminalCase();
		c.setNumber("1");
		Evidence e=new Evidence();
		e.setNumber("1");
		e.setCriminalCase(c);
		e.setStorage(s);
		Mockito.when(evidenceRepo.save(e)).thenReturn(e);
		Mockito.when(evidenceRepo.findByNumber("1")).thenReturn(null);
		Mockito.when(criminalCaseRepo.findByNumber("1")).thenReturn(new CriminalCase());
		String kq=evidenceService.addevidence(e);
		assertEquals(e, kq);

  }

	
}
