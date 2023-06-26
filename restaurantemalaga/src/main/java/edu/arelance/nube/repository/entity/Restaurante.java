package edu.arelance.nube.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="bdrestaurantes")

public class Restaurante {
	
	@Id //indico a springque este sera la clave primaria
	@GeneratedValue (strategy = GenerationType.IDENTITY)//Autoinc en Mysql
	
	private long id;
	private String nombre;
	private String barrio;
	private String direccion;
	private String web;
	private String fichaGoogle;
	private String latitud;
	private String longitud;
	private Integer preciomedio;
	private String especialidad1;
	private String especialidad2;
	private String especialidad3;


}
