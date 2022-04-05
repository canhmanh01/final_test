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

import com.fis.system.entity.Detecvice;
import com.fis.system.service.DetecviceService;

@RestController
@RequestMapping("/detecvice")
public class DetecviceController {

	@Autowired
	DetecviceService detecviceService;

	@PostMapping("/add")
	@ResponseBody

	public ResponseEntity<?> adddetecvice(@RequestBody Detecvice detecvice) {

		return ResponseEntity.ok(detecviceService.adddetecvice(detecvice));

	}

	@PutMapping("/update")
	@ResponseBody
	public ResponseEntity<?> updatedetecvice( @RequestBody Detecvice detecvice) {
		
		return ResponseEntity.ok(detecviceService.updatedetecvice(detecvice));

	}

	@DeleteMapping("/delete")
	@ResponseBody
	public ResponseEntity<?> deleteetecvice(@PathVariable(name = "id") Long detecviceId) {

		detecviceService.deletedetecvice(detecviceId);
		return new ResponseEntity<String>("delete success", HttpStatus.OK);

	}
	
	@GetMapping("/adds")
	@ResponseBody
	
	public ResponseEntity<?> findByid(@PathVariable(name = "id") Long detecviceId){
		
		return ResponseEntity.ok(detecviceService.findByid(detecviceId));
		
	}

}
