package com.jonathan.CrudSecurity.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jonathan.CrudSecurity.dao.UsuarioDao;
import com.jonathan.CrudSecurity.modelo.Usuario;

@Service("usuarioDetailService")
public class UserDetailService implements UserDetailsService {

	@Autowired
	@Qualifier("usuarioDao")
	private UsuarioDao usuarioDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		Usuario user = usuarioDao.findByUsuario(username);
		return new User(user.getUsuario(), passwordEncoder.encode(user.getPassword()), user.isEstado(), user.isEstado(),
				user.isEstado(), user.isEstado(), buildgrante(user.getRole()));
	}

	public List<GrantedAuthority> buildgrante(byte rol) {
		String[] roles = { "LECTURA", "SUPERVSOR", "ADMINISTRADOR" };
		List<GrantedAuthority> auths = new ArrayList<>();
		for (int i = 0; i < rol; i++) {
			auths.add(new SimpleGrantedAuthority(roles[i]));
		}
		System.out.println("ROL: " + auths);
		return auths;
	}

}
