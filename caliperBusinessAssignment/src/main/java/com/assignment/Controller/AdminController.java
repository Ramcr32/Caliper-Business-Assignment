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
import com.assignment.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;

	@PostMapping("/")
	public ResponseEntity<Admin> insertAdminHandler(@RequestBody Admin admin) {
		Admin savedAdmin = adminService.saveAdmin(admin);
		return new ResponseEntity<Admin>(savedAdmin, HttpStatus.OK);
	}

	@DeleteMapping("/{adminId}")
	public ResponseEntity<Admin> deleteMappingHandler(@PathVariable("adminId") Integer adminId) {
		Admin returnAdmin = adminService.delete(adminId);
		return new ResponseEntity<Admin>(returnAdmin, HttpStatus.OK);
	}

	@PutMapping("/")
	public ResponseEntity<String> updateAdminHandler(@RequestBody Admin admin) {
		Admin updatedAdmin = adminService.update(admin);
		return new ResponseEntity<String>("admin updated " + updatedAdmin, HttpStatus.ACCEPTED);
	}
}
