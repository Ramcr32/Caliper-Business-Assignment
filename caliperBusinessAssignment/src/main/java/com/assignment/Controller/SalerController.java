package com.assignment.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.model.Admin;
import com.assignment.model.Saler;
import com.assignment.service.AdminService;
import com.assignment.service.SalerService;

@RestController

public class SalerController {
	@Autowired
	private SalerService salerService;

	@PostMapping("/saler/")
	public ResponseEntity<Saler> insertAdminHandler(@RequestBody Saler saler) {
		Saler newsaler = salerService.saveSaler(saler);
		return new ResponseEntity<>(newsaler, HttpStatus.OK);
	}

	@DeleteMapping("/saler/{id}")
	public ResponseEntity<Saler> deleteMappingHandler(@PathVariable("id") Integer id) {
		Saler saler = salerService.delete(id);
		return new ResponseEntity<>(saler, HttpStatus.OK);
	}

	@PutMapping("/saler/")
	public ResponseEntity<Saler> updateAdminHandler(@RequestBody Saler saler) {
		Saler updatedsaler = salerService.update(saler);
		return new ResponseEntity<>(updatedsaler, HttpStatus.ACCEPTED);
	}
}
