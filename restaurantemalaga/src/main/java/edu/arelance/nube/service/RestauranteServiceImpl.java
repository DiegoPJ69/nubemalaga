package edu.arelance.nube.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import edu.arelance.nube.repository.RestauranteRepository;
import edu.arelance.nube.repository.entity.Restaurante;

@Service

public class RestauranteServiceImpl implements RestauranteService {

	
	RestauranteRepository restauranteRepository;
	
	@Override
	@Transactional
	public Iterable<Restaurante> consultarTodos() {
		return this.restauranteRepository.findAll();
		//return null;
	}

	@Override
	@Transactional
	public Optional<Restaurante> consultarRestaurante(Long id) {
		return this.restauranteRepository.findById(id);
		//return Optional.empty();
	}

	@Override
	@Transactional
	public Restaurante altaRestaurante(Restaurante restaurante) {
		return this.restauranteRepository.save(restaurante);
		//return null;
	}

	@Override
	@Transactional
	public void borrarRestaurante(long id) {
		this.restauranteRepository.deleteById(id);
	}

	@Override
	@Transactional
	public Optional<Restaurante> modificarRestaurante(long id, Restaurante restaurante) {		
	return Optional.empty();
	}
	

}
