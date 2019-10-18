package com.jonathan.CrudSecurity.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = -3698650480977806275L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "usuario", length = 12)
	private String usuario;

	@Column(name = "paassword", length = 12)
	private String password;

	@Column(name = "correo", length = 50)
	private String correo;

	@Column(name = "estado")
	private boolean estado;

	@Column(name = "ROL")
	private byte role;

	@JoinColumn(name = "idRol", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private Rol rol;

	public Usuario() {
	}

	public Usuario(Integer id, String usuario, String password, String correo, boolean estado, Rol rol) {
		this.id = id;
		this.usuario = usuario;
		this.password = password;
		this.correo = correo;
		this.estado = estado;
		this.rol = rol;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public byte getRole() {
		return role;
	}

	public void setRole(byte role) {
		this.role = role;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", usuario=" + usuario + ", password=" + password + ", correo=" + correo
				+ ", estado=" + estado + ", rol=" + rol + "]";
	}
}
