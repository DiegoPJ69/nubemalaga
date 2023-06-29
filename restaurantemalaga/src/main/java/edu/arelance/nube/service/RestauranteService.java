package edu.arelance.nube.service;

import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import edu.arelance.nube.repository.entity.Restaurante;

public interface RestauranteService {
	
	Iterable<Restaurante> consultarTodos ();
	
	Optional<Restaurante> consultarRestaurante(Long id);

	Restaurante altaRestaurante(Restaurante restaurante);
	
	void borrarRestaurante (long id);
	
	Optional<Restaurante> modificarRestaurante(long id,Restaurante restaurante);

	public Iterable<Restaurante> consultarRestauranteRangoPrecio(int preciomin, int preciomax);
	
	public Iterable<Restaurante> consultarRestauranteCriterio(String criterio);
	
	

}