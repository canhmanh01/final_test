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

import com.fis.system.entity.Evidence;
import com.fis.system.service.EvidenceServcie;

@RestController
@RequestMapping("/evidence")
public class EvidenceController {

	@Autowired
	EvidenceServcie evidenceServcie;

	@PostMapping("/add")
	@ResponseBody

	public ResponseEntity<?> addevidence(@RequestBody Evidence evidence) {

		return ResponseEntity.ok(evidenceServcie.addevidence(evidence));

	}

	@PutMapping("/update")
	@ResponseBody

	public ResponseEntity<?> updateevidence(@RequestBody Evidence evidence) {

		
		return ResponseEntity.ok(evidenceServcie.updateevidence(evidence));

	}
	
	@DeleteMapping("/delete")
	@ResponseBody
	public ResponseEntity<?> deleteevidence(@PathVariable(name = "id") Long evidenceid) {
		
		evidenceServcie.deleteevidence(evidenceid);
		return new ResponseEntity<String>("delete success",HttpStatus.OK);
		
	}
	
	@GetMapping("evidencee")
	@ResponseBody
	public ResponseEntity<?> getfindByid(@PathVariable(name = "id") Long evidenceid){
		
		return new ResponseEntity<>(evidenceServcie.findByid(evidenceid),HttpStatus.OK);
		
	}

}
