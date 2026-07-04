package com.cynthiasalazar.models;

import org.hibernate.validator.constraints.URL;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="jugos")
public class Jugo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="El campo es requerido.")
	@Size(min= 3, message="Debe tener al menos 5 caracteres.")
	private String titulo;
	
	@NotBlank(message="El campo es requerido.")
	@Size(min= 3, message="Debe tener al menos 10 caracteres.")
	private String descripcion;
	
	@NotBlank(message="El campo es requerido.")
	@Size(min= 3, message="Debe tener al menos 10 caracteres.")
	private String ingrediente;
	
	@NotBlank(message="El campo es requerido.")
	@Size(min= 3, message="Debe tener al menos 10 caracteres.")
	private String instruccion;
	
	@URL(message="No es una URL válida.")
	private String portada;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario creador;
	
	
	
	
	
	
	public Jugo() {
		super();
	}




	public Jugo(Long id, String titulo, String descripcion, String ingrediente, String instruccion, String portada,
			Usuario creador) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.ingrediente = ingrediente;
		this.instruccion = instruccion;
		this.portada = portada;
		this.creador = creador;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getTitulo() {
		return titulo;
	}




	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}




	public String getDescripcion() {
		return descripcion;
	}




	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}




	public String getIngrediente() {
		return ingrediente;
	}




	public void setIngrediente(String ingrediente) {
		this.ingrediente = ingrediente;
	}




	public String getInstruccion() {
		return instruccion;
	}




	public void setInstruccion(String instruccion) {
		this.instruccion = instruccion;
	}




	public String getPortada() {
		return portada;
	}




	public void setPortada(String portada) {
		this.portada = portada;
	}




	public Usuario getCreador() {
		return creador;
	}




	public void setCreador(Usuario creador) {
		this.creador = creador;
	}


	
	
	
}

	