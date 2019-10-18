package com.jonathan.CrudSecurity.service;

import java.util.List;
import java.util.Optional;

import com.jonathan.CrudSecurity.modelo.Usuario;

public interface UsuarioService {

	public List<Usuario> findAllUsuario();

	public void createUsuario(Usuario usuario);

	public void updateUsuario(Usuario usuario);

	public void deleteUsuario(Integer idUser);

	public Optional<Usuario> findById(Integer idUser);

}
