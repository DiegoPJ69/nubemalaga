package edu.arelance.nube.service;

import java.util.Optional;

import edu.arelance.nube.repository.entity.Restaurante;

public interface RestauranteService {
	
	Iterable<Restaurante> consultarTodos ();
	
	Optional<Restaurante> consultarRestaurante(Long id);

	Restaurante altaRestaurante(Restaurante restaurante);
	
	void borrarRestaurante (long id);
	
	Optional<Restaurante> modificarRestaurante(long id,Restaurante restaurante);

}