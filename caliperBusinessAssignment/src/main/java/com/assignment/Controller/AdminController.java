package com.assignment.Controller;

import javax.validation.Valid;

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
import com.assignment.model.Items;
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
	public ResponseEntity<Admin> updateAdminHandler(@RequestBody Admin admin) {
		Admin updatedAdmin = adminService.update(admin);
		return new ResponseEntity<>(updatedAdmin, HttpStatus.ACCEPTED);
	}
	@PostMapping("/items")
	public ResponseEntity<Items> addItemsHandler(@RequestBody @Valid Items item) {
		Items newItem = adminService.addNewItem(item);
		return new ResponseEntity<>(newItem, HttpStatus.OK);
	}
	@PutMapping("/items")
	public ResponseEntity<Items> updateItemHandler(@RequestBody Items item) {
		Items updatedItem = adminService.updateItem(item);
		return new ResponseEntity<>(updatedItem, HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/items/{id}")
	public ResponseEntity<Items> deleteItemHandler(@PathVariable Integer id) {
		Items deletedItem = adminService.deleteItem(id);
		return new ResponseEntity<>(deletedItem, HttpStatus.ACCEPTED);
	}
}
