package edu.arelance.nube.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.arelance.nube.repository.entity.Restaurante;

//CrudRepository es una interfaz que tiene implemantado metodos de acceso a BD
@Repository
public interface RestauranteRepository extends CrudRepository<Restaurante, Long>{

	
	//Formas de trabajo con BD
	//KEY WORD QUERIES - Consultas por palabras clave
	
	//obtener restaurantes en un rango de precio
	Iterable <Restaurante> findByPrecioMedioBetween(int preciomin, int preciomax);
	//Iterable <Restaurante> findByespecialidad1orespecialidad2orespecialidad3IgnoreCase(String criterio);
	
	//2 JPQL - HQL - Pseduo SQL pero de JAVA
	//3 NATIVAS -SQL
	@Query(value = "SELECT * FROM bdrestaurantes.restaurantes WHERE barrio LIKE %?1% OR nombre LIKE %?1% OR especialidad1 LIKE %?1% OR especialidad2 LIKE %?1% OR especialidad3 LIKE %?1% ", nativeQuery = true)
	Iterable<Restaurante> buscarPorBarrioNombreEspecialidad(String criterio);
	
	@Query(value = "SELECT DISTINCT barrio from restaurantes", nativeQuery = true)
    Iterable<String> consultarTodosLosBarrios();
	
	//STORED PROCEDURES - Procedimientos Almacenados
	//5 CRITERIA API - SQL pero con métodos de java
	
	
	
	
	
}
