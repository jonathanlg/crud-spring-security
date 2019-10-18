package com.jonathan.CrudSecurity.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jonathan.CrudSecurity.modelo.Usuario;
import com.jonathan.CrudSecurity.service.UsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioController {
	
	@Autowired
	@Qualifier("usuarioService")
	private UsuarioService usuarioService;
	
	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuario>> getUsuarios() {
		List<Usuario> usuarios = usuarioService.findAllUsuario();
		if (usuarios.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(usuarios, HttpStatus.OK);
	}
	
	@PostMapping("/usuario")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario addUsuario(@RequestBody Usuario usuario) {
		usuario.setId(null);
		usuarioService.createUsuario(usuario);
		return usuario;
	}
	
	@PutMapping("/usuario")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario updateUsuario(@RequestBody Usuario usuario) {
		usuarioService.updateUsuario(usuario);
		return usuario;
	}
	
	@GetMapping("/usuario/{usuarioId}")
	public ResponseEntity<Optional<Usuario>> getUsuario(@PathVariable Integer usuarioId) {
		Optional<Usuario> usuario = usuarioService.findById(usuarioId);
		if (!usuario.isPresent()) {
			System.out.println("No encontrado");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		System.out.println("Encontrado");
		return new ResponseEntity<>(usuario, HttpStatus.OK);
	}
	
	@DeleteMapping("/usuario/{usuarioId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<String> deleteUser(@PathVariable Integer usuarioId) {
		Optional<Usuario> usuario = usuarioService.findById(usuarioId);
		if((!usuario.isPresent())) {
			System.out.println("No Encontrado");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			System.out.println("Encontrado");
			usuarioService.deleteUsuario(usuarioId);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

}
