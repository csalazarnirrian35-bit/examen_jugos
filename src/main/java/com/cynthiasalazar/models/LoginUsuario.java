package com.cynthiasalazar.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginUsuario {
	
	@NotBlank(message="Por favor proporciona tu correo")
	@Email(message= "Por favor ingresa un correo válido")
	private String correo;
	
	@NotBlank(message="Por favor proporciona tu contraseña")
	@Size(min= 8, message="Debe contener al menos 8 caracteres.")
	private String password;

	public LoginUsuario() {
		super();
	}

	public LoginUsuario(String correo, String password) {
		super();
		this.correo = correo;
		this.password = password;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
