package com.cynthiasalazar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.cynthiasalazar.models.Jugo;
import com.cynthiasalazar.repositories.RepositorioJugos;

@Service
public class ServicioJugos {
	
	@Autowired
	private RepositorioJugos repositorioJugos;
	
	public Jugo agregar(Jugo jugo) {
		return this.repositorioJugos.save(jugo);
	}

	
	public List<Jugo> obtenerTodos(){
		return (List<Jugo>) this.repositorioJugos.findAll();
		
	}
	
	public Jugo obtenerPorId(Long id) {
		return this.repositorioJugos.findById(id).orElse(null);
	}
	
	
	public Jugo obtenerPorTitulo(String titulo) {
		return this.repositorioJugos.findByTitulo(titulo).orElse(null);
		
	}
	
	public Jugo actualiza(Jugo jugo) {
		return this.repositorioJugos.save(jugo);
	}
	
	
	
	public void eliminar(Long id) {
		this.repositorioJugos.deleteById(id);
		
	}
	
	
	public BindingResult validarTituloUnico(BindingResult validaciones, Jugo jugo) {
		Jugo jugoDB = this.obtenerPorTitulo(jugo.getTitulo());
		if(jugoDB != null) {
			validaciones.rejectValue("titulo", "tituloRepetido", "El título debe ser único.");
		}
		return validaciones;
	}
	
	
	
	
}
