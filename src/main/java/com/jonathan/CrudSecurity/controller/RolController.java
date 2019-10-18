package com.jonathan.CrudSecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonathan.CrudSecurity.modelo.Rol;
import com.jonathan.CrudSecurity.service.RolService;

@RestController
@RequestMapping("/api")
public class RolController {

	@Autowired
	@Qualifier("rolService")
	private RolService rolService;

	@GetMapping("/roles")
	public ResponseEntity<List<Rol>> getRoles() {
		List<Rol> roles = rolService.getAllRoles();
		if (roles.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(roles, HttpStatus.OK);
	}

}
