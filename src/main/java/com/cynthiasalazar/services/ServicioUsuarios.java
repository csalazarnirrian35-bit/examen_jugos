package com.cynthiasalazar.services;



import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.cynthiasalazar.models.LoginUsuario;
import com.cynthiasalazar.models.Usuario;
import com.cynthiasalazar.repositories.RepositorioUsuarios;

@Service
public class ServicioUsuarios {
	
	@Autowired
	private RepositorioUsuarios repositorioUsuarios;
	
	public Usuario registra(Usuario usuario) {
		String hashPassword = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
		usuario.setPassword(hashPassword);
		return this.repositorioUsuarios.save(usuario);
	}
	
	public List<Usuario> obtenerTodos(){
		return (List<Usuario>) this.repositorioUsuarios.findAll();
	}
	
	
	public Usuario obtenerPorId(Long id) {
		return this.repositorioUsuarios.findById(id).orElse(null);
		
	}
	
	public Usuario obtenerPorCorreo(String email) {
		return this.repositorioUsuarios.findByCorreo(email).orElse(null);
		
	}
	
	public Usuario actualizar(Usuario usuario) {
		return this.repositorioUsuarios.save(usuario);
	}
	
	public void eliminar(Long id) {
		this.repositorioUsuarios.deleteById(id);

	}
	
	
	public BindingResult validarLogin(BindingResult validaciones, LoginUsuario loginusuario) {
		Usuario usuarioDB =  this.obtenerPorCorreo(loginusuario.getCorreo());
		if(usuarioDB == null) {
			validaciones.rejectValue("correo", "correoInexistente", "Usuario no encontrado");
		}else {
			if(!BCrypt.checkpw(loginusuario.getPassword(), usuarioDB.getPassword())) {
					validaciones.rejectValue("password", "passwordIcorrecta", "Contraseña Incorrecta");
				}
			}
			return validaciones;
		}
	
	public BindingResult validarRegistro(BindingResult validaciones, Usuario usuario) {
		Usuario usuarioBD = this.obtenerPorCorreo(usuario.getCorreo());
		if(usuarioBD == null) {
			if(!usuario.getPassword().equals(usuario.getConfirmarPassword())) {
				validaciones.rejectValue("confirmar Password", "passwordNoCoincide","Las contraseñas no coinciden" );
				
			}
		}else {
			validaciones.rejectValue("correo", "usuarioExistente", "Este usuario ya existe");
		}
		return validaciones;
	}
	
	
	}	
	
	

