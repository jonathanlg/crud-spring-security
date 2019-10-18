package com.jonathan.CrudSecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonathan.CrudSecurity.dao.RolDao;
import com.jonathan.CrudSecurity.modelo.Rol;

@Service("rolService")
public class RolServiceImpl implements RolService {
	
	@Autowired
	private RolDao rolDao;

	@Override
	public List<Rol> getAllRoles() {
		return (List<Rol>) rolDao.findAll();
	}

}
