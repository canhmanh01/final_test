package com.fis.system;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.fis.system.entity.CriminalCase;
import com.fis.system.repo.CriminalCaseRepo;
import com.fis.system.service.CriminalCaseService;

@SpringBootTest
public class CriminalCaseTest {

	@Mock
	CriminalCaseRepo caseRepo;

	@InjectMocks
	CriminalCaseService caseService;

	@Test
	void add() {
		CriminalCase criminalCase = new CriminalCase();
		criminalCase.setNumber("1234");
		Mockito.when(caseRepo.existsByNumber("1234")).thenReturn(false);
		String kq = caseService.addcriminalCase(criminalCase);
		assertEquals("thành công", kq);
	}
}