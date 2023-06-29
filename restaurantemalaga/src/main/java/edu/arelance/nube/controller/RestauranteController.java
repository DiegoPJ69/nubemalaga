package edu.arelance.nube.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.arelance.nube.repository.entity.Restaurante;
import edu.arelance.nube.service.RestauranteService;
import io.swagger.v3.oas.annotations.Operation;

/**
 * API WEB
 * HTTP -> Deriva en la ejeciución de un método
 * @author dpjaraba
 *
 *GET -> Consultar TODOS
 *GET -> Consultar Uno (por ID)
 *POST -> insertar un restaurante nuevo
 *PUT -> Modificar un restaurante que ya existe
 *DELETE -> Borrar un restaurante (por ID)
 *
 *GET -> Búsqueda -> Por barrio, por especialidad, por nombre, etc
 *
 */


//@Controller//Devolvemos una vista html/JSP
@RestController//Devolvemos JSON http://localhost:8081/restaurante
@RequestMapping("/restaurante")
public class RestauranteController {
	
	@Autowired
	RestauranteService restauranteService;
	
	Logger logger=LoggerFactory.getLogger(RestauranteController.class);
	
	@GetMapping("/test")//GET http://localhost:8081/restaurante/test
	
	public Restaurante obtenerRestauranteTest()
	{
		Restaurante restaurante=null;
		
		System.out.println("llamando a obtenerRestauranteTest");
		
		logger.debug("estoy en obtenerRestaurante");
		
		restaurante = new Restaurante(1l, "Martinete", "Carlos Haya 33", "Carranque", "www.martinete.org", "http://gogle.xe", 33.65f, -2.3f, 10, "gazpachuelo", "paella", "sopa de marisco", LocalDateTime.now());
		
		return restaurante;
	}
//ResponseEntity es una clase java que incluye los datos HTP
//GET -> Consultar TODOS GET http://localhost:8081/restaurante

@GetMapping
public ResponseEntity<?> listartodos(){
	
	ResponseEntity<?> responseEntity=null;
	Iterable <Restaurante> lista_restaurantes = null;
	
	lista_restaurantes=this.restauranteService.consultarTodos();
	responseEntity=ResponseEntity.ok(lista_restaurantes);
	
	return responseEntity;
	
}

//GET por ID -> Consultar TODOS GET http://localhost:8081/restaurante/id
@Operation (description="Este servicio consulta restaurantes por un id")
@GetMapping ("/{id}") //entre llaves porque id es variable
public ResponseEntity<?> listarPorId (@PathVariable Long id){
	
	ResponseEntity<?> responseEntity=null;
	Optional<Restaurante> or=null;
	
	or=this.restauranteService.consultarRestaurante(id);
	if(or.isPresent())
	{//la consulta ha recuperadeo un registro
		Restaurante restauranteleido =or.get();
		responseEntity=ResponseEntity.ok(restauranteleido);
		
	} else {
	//la consulta NO ha recuperado un registro
	responseEntity=ResponseEntity.noContent().build();
	}
	

	return responseEntity;
}

//GET por reango de precio -> Consultar restaurantes en un rango de precios GET http://localhost:8081/restaurante/listarPorRangoPrecio?preciomin=1?preciomax=5
@Operation (description="Este servicio consulta restaurantes de acuerdo a un rango de precio")
@GetMapping ("listarPorRangoPrecio") //entre llaves porque los precios son variables
public ResponseEntity<?> listarPorRangoPrecio(@RequestParam (name="preciomin") int preciomin,@RequestParam (name="preciomax") int preciomax){
	
	ResponseEntity<?> responseEntity=null;
	Iterable <Restaurante> lrr=null;
	
	lrr=this.restauranteService.consultarRestauranteRangoPrecio (preciomin,preciomax);
	
	if(lrr != null) {
	responseEntity=ResponseEntity.ok(lrr);
	} else
	{
	//la consulta NO ha recuperado registros
	responseEntity=ResponseEntity.noContent().build();
	}
	
	
	return responseEntity;
}

//GET por nombre, barrio o especialidad  -> Consultar restaurantes por un criterio no definido a priori GET http://localhost:8081/restaurante/listarPorCriterio?criterio=Pescado
@Operation (description="Este servicio consulta restaurantes de acuerdo a un criterio")
@GetMapping ("/listarPorCriterio") //de esta manera ubicamos el metodo de manera inequívoca
public ResponseEntity<?> listarPorCriterio(@RequestParam (name="criterio") String criterio){
	
	ResponseEntity<?> responseEntity=null;
	Iterable <Restaurante> lrr=null;
	
	lrr=this.restauranteService.consultarRestauranteCriterio (criterio);
	responseEntity=ResponseEntity.ok(lrr);
	
	
	return responseEntity;
}



//POST -> insertar un restaurante nuevo http://localhost:8081/restaurante (body restaurante)
//public pq el post lo llama spring (callback)

@PostMapping
public ResponseEntity<?> insertarRestaurante (@RequestBody Restaurante restaurante)
{
	ResponseEntity<?> responseEntity = null;
	Restaurante restauranteNuevo = null;
	
		restauranteNuevo = this.restauranteService.altaRestaurante(restaurante);
		responseEntity = ResponseEntity.status(HttpStatus.CREATED).body(restauranteNuevo);
	
	return responseEntity;
}


//PUT -> Modificar un restaurante que ya existe http://localhost:8081/restaurante/id (body restaurante)
@PutMapping("/{id}")
public  ResponseEntity<?> modificarRestaurante(@RequestBody Restaurante restaurante,@PathVariable long id){
	
	ResponseEntity<?> responseEntity=null;
	Optional<Restaurante> opRest=null;
	
	opRest=this.restauranteService.modificarRestaurante(id, restaurante);
	
	if(opRest.isPresent())
	{
		Restaurante rm =opRest.get();
		responseEntity=ResponseEntity.ok(rm);
		
	} else {
	
	responseEntity=ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	return responseEntity;
	
}



//DELETE -> Borrar un restaurante (por ID) http://localhost:8081/restaurante/id

@DeleteMapping ("/{id}") //entre llaves porque id es variable
public ResponseEntity<?> borrarPorId (@PathVariable Long id)
{
	ResponseEntity<?> responseEntity=null;
	
	this.restauranteService.borrarRestaurante(id);
	responseEntity=ResponseEntity.ok().build();
	
	return responseEntity;	
}



}









