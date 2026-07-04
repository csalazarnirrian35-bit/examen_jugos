package com.cynthiasalazar.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.cynthiasalazar.models.Jugo;
import com.cynthiasalazar.services.ServicioJugos;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorJugos {
	
	@Autowired
	private ServicioJugos servicioJugos;
	
	
	@GetMapping("/jugos")
	public String verJugos(HttpSession sesion, Model modelo) {
		Long idUsuario = (Long) sesion.getAttribute("idUsuario");
		if(idUsuario == null) {
			return "redirect:/";	
		}
		List<Jugo> jugos = this.servicioJugos.obtenerTodos();
		modelo.addAttribute("jugos", jugos);
		return "jugos.jsp";
		
	}
	
	@GetMapping("/formulario/agregar")
	public String formularioAgregar(HttpSession sesion, Model modelo) {
		Long idUsuario = (Long) sesion.getAttribute("idUsuario");
		if(idUsuario == null) {
			return "redirect:/";
		}
		modelo.addAttribute("jugo", new Jugo());
		return "agregar.jsp";
	}
	
	@PostMapping("/agregar")
	public String guardar(@Valid @ModelAttribute("jugo") Jugo jugo, BindingResult validaciones) {
		validaciones = this.servicioJugos.validarTituloUnico(validaciones, jugo);
		if(validaciones.hasErrors()) {
			return "agregar.jsp";
			
		}
		this.servicioJugos.agregar(jugo);
		return "redirect:/jugos";
	}
	
	@GetMapping("formulario/editar/{id}")
	public String formularioEditar(HttpSession sesion, Model modelo, @PathVariable("id") Long id) {
		Long idUsuario = (Long) sesion.getAttribute("idUsuario");
		if(idUsuario == null) {
			return "redirect:/";
		}
		modelo.addAttribute("jugo", this.servicioJugos.obtenerPorId(id));
		return "editar.jsp";
			
	}
	
	
	@PutMapping("/editar")
	public String editarJugo(@Valid @ModelAttribute("jugo") Jugo jugo, BindingResult validaciones) {
		validaciones = this.servicioJugos.validarTituloUnico(validaciones, jugo);
		if(validaciones.hasErrors()) {
			return "editar.jsp";
			
		}
		this.servicioJugos.actualiza(jugo);
		return "redirect:/jugos";
		
	}
	
	@GetMapping("/detalle/{id}")
	public String detalle(@PathVariable("id") Long id, HttpSession sesion, Model modelo) {
		Long idUsuario = (Long) sesion.getAttribute("idUsuario");
		if(idUsuario == null) {
			return "redirect:/";
			
		}
		modelo.addAttribute("jugo", this.servicioJugos.obtenerPorId(id));
		return "detalle.jsp";
	}
	

	@DeleteMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		this.servicioJugos.eliminar(id);
		return "redirect:/jugos";
	}
	
}
