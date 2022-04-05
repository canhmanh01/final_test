package com.fis.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fis.system.entity.CaseStatus;
import com.fis.system.entity.CriminalCase;
import com.fis.system.service.CriminalCaseService;

@RestController
@RequestMapping("/criminalCase")
public class CriminalCaseController {
	
	@Autowired
	CriminalCaseService criminalCaseService;
	
	@GetMapping("criminalCase")
	@ResponseBody
	public ResponseEntity<?> getAllcriminalCase(){
		
		return new ResponseEntity<>(criminalCaseService.criminalCasesfillall(),HttpStatus.OK);
		
	}
	@PostMapping("/add")
	@ResponseBody
	public ResponseEntity<?> add(@RequestBody CriminalCase criminalcase) {
		return ResponseEntity.ok(criminalCaseService.addcriminalCase(criminalcase));
	}
	
	@PutMapping("/update")
	@ResponseBody
	public ResponseEntity<?> update(@RequestBody CriminalCase criminalcase) {
		
		
		return ResponseEntity.ok(criminalCaseService.updatecriminalCase(criminalcase));
	}
	
	@DeleteMapping("/delete")
	@ResponseBody
	public ResponseEntity<?> delete(@PathVariable(name ="id") Long accountId){
		
		criminalCaseService.deletecriminalCase(accountId);
		
		return new ResponseEntity<String>("Delete successfullt" , HttpStatus.OK);
	

	}
	@GetMapping("criminalCasess")
	@ResponseBody
	public ResponseEntity<?> getfindByid(@PathVariable(name = "id") Long accountId){
		
		return new ResponseEntity<>(criminalCaseService.findByid(accountId),HttpStatus.OK);
		
	}
	
	@GetMapping("criminalstatus")
	@ResponseBody
	public ResponseEntity<?> getBystatus(@PathVariable(name = "status")  CaseStatus status){
		
		return ResponseEntity.ok(criminalCaseService.findByStatus(status));
		
	}
}
