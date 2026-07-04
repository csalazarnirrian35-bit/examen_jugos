package com.cynthiasalazar.controllers;

import com.cynthiasalazar.models.LoginUsuario;
import com.cynthiasalazar.models.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cynthiasalazar.services.ServicioUsuarios;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
public class ControladorUsuarios {
	

	@Autowired
	private ServicioUsuarios servicioUsuarios;

	
	
	@GetMapping("/")
	public String formularioLogin(Model modelo) {
		modelo.addAttribute("loginUsuario", new LoginUsuario());
		 return "login.jsp";
			
		}
	
	
	@PostMapping("/login")
	public String procesaLogin(@Valid @ModelAttribute("loginUsuario") LoginUsuario loginUsuario, BindingResult validaciones, HttpSession sesion) {
		validaciones = this.servicioUsuarios.validarLogin(validaciones, loginUsuario);
		if(validaciones.hasErrors()) {
			return "login.jsp";
		}
		Usuario usuarioBD = this.servicioUsuarios.obtenerPorCorreo(loginUsuario.getCorreo());
		sesion.setAttribute("nombreCompleto", usuarioBD.getNombre() + " " + usuarioBD.getApellido());
		sesion.setAttribute("idUsuario", usuarioBD.getId());
		return "redirect:/jugos";
	}
	
	@GetMapping("/formulario/registro")
	public String formuarioRegistro(Model modelo) {
		modelo.addAttribute("usuario", new Usuario());
		return "registro.jsp";
	}
	
	@PostMapping("/procesa/registro")
	public String procesaregistro(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult validaciones, HttpSession sesion) {
		validaciones = this.servicioUsuarios.validarRegistro(validaciones, usuario);
		if(validaciones.hasErrors()) {
			return "registro.jsp";
		}
		Usuario usuarioregistrado = this.servicioUsuarios.registra(usuario);
		sesion.setAttribute("nombreCompleto", usuarioregistrado.getNombre() + " " + usuarioregistrado.getApellido());
		sesion.setAttribute("idUsuario", usuarioregistrado.getId());
		return "redirect:/jugos";
	}
	
	
	@GetMapping("/logout")
	public String cierreSesion(HttpSession sesion) {
		sesion.invalidate();
		return "redirect:/";
	}
	
	
	
		
	
}


