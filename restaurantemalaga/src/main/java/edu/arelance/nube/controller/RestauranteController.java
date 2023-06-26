package edu.arelance.nube.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.arelance.nube.repository.entity.Restaurante;

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
	
	@GetMapping("/test")//GET http://localhost:8081/restaurante/test
	public Restaurante obtenerRestauranteTest()
	{
		Restaurante restaurante=null;
		
		System.out.println("llamando a obtenerRestauranteTest");
		
		return restaurante;
	}

}
