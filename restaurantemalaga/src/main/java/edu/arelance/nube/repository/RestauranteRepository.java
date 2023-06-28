package edu.arelance.nube.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.arelance.nube.repository.entity.Restaurante;

//CrudRepository es una interfaz que tiene implemantado metodos de acceso a BD
@Repository
public interface RestauranteRepository extends CrudRepository<Restaurante, Long>{

}
