package com.jonathan.CrudSecurity.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jonathan.CrudSecurity.modelo.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Integer> {

	public Usuario findByUsuario(String usuario);

}
