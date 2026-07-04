package com.cynthiasalazar.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cynthiasalazar.models.Jugo;

import java.util.Optional;


@Repository
public interface RepositorioJugos extends CrudRepository<Jugo, Long>{
	
	Optional<Jugo> findByTitulo(String titulo);

}
