package com.jonathan.CrudSecurity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonathan.CrudSecurity.dao.UsuarioDao;
import com.jonathan.CrudSecurity.modelo.Usuario;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDao usuarioDao;

	@Override
	public List<Usuario> findAllUsuario() {
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	public void createUsuario(Usuario usuario) {
		usuarioDao.save(usuario);
	}

	@Override
	public void updateUsuario(Usuario usuario) {
		usuarioDao.save(usuario);
	}

	@Override
	public void deleteUsuario(Integer idUser) {
		usuarioDao.deleteById(idUser);
	}

	@Override
	public Optional<Usuario> findById(Integer idUser) {
		return usuarioDao.findById(idUser);
	}

}
