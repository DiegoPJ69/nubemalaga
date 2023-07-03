package edu.arelance.nube.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.arelance.nube.repository.RestauranteRepository;
import edu.arelance.nube.repository.entity.Restaurante;

@Service
public class RestauranteServiceImpl implements RestauranteService {

	
	//busca una instancia de RestauranteService. In yectamos con Autyowired
	
	@Autowired
	RestauranteRepository restauranteRepository;
	
	@Override
	@Transactional(readOnly = true)//permitimos acceso concurrente a la tabla restaurante
	public Iterable<Restaurante> consultarTodos() {
		return this.restauranteRepository.findAll();
		//return null;
	}

	@Override
	@Transactional (readOnly = true)
	public Optional<Restaurante> consultarRestaurante(Long id) {
		return this.restauranteRepository.findById(id);
		//return Optional.empty();
	}
	
	@Override
	@Transactional (readOnly = true)
	public Iterable <Restaurante> consultarRestauranteRangoPrecio(int preciomin, int preciomax) {
		
		Iterable<Restaurante> lrr=null;
		
		lrr=this.restauranteRepository.findByPrecioMedioBetween(preciomin, preciomax);
		
		return lrr;
	}
	
	@Override
	@Transactional (readOnly = true)
	public Iterable <Restaurante>consultarRestauranteCriterio(String criterio){
		
		Iterable<Restaurante> lrc=null;
		
		lrc=this.restauranteRepository.buscarPorBarrioNombreEspecialidad(criterio);
		
		return lrc;
		
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
		Optional<Restaurante> opRest = Optional.empty();
				
		//1 LEER
					opRest = this.restauranteRepository.findById(id);
					if (opRest.isPresent())
					{
						//Al estar dentro de una transacción, restauranteLeido está asociado
						//a un registro de la tabla. Si modifico un campo, estoy modificando 
						//la columna asociada (Estado "Persistent" - JPA)
						Restaurante restauranteLeido =  opRest.get();
						//restauranteLeido.setNombre(restaurante.getNombre());
						BeanUtils.copyProperties(restaurante, restauranteLeido, "id", "creadoEn");
						opRest = Optional.of(restauranteLeido);//"relleno el Optional"
					}
		//2 ACTUALIZAR
			
	return opRest;		
		
	}

	@Transactional(readOnly = true)
	public Iterable<String> obtenerTodosLosBarrios() {
		return this.restauranteRepository.consultarTodosLosBarrios();
		
	}
	
	//El ServiceImplemen
	//@Override
	//@Transactional(readOnly = true)
	//public Iterable<String> getAllBarrios() {
	//	Iterable<String> listaPorBarrios = null;
	//	listaPorBarrios = this.restauranteRepository.findDistinctByBarrioIgnoreCase();
	//	return listaPorBarrios;
	//}
	

}
