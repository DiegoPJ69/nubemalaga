package edu.arelance.nube.repository.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table (name="restaurantes")

public class Restaurante {
	
	@Id //indico a springque este sera la clave primaria
	@GeneratedValue (strategy = GenerationType.IDENTITY)//Autoinc en Mysql
	
	private long id;
	@NotNull
	@NotEmpty
	private String nombre;//x
	@NotEmpty
	private String barrio;//x
	@NotEmpty
	private String direccion;//x
	
	private String web;
	private String fichaGoogle;
	private float latitud;
	private float longitud;
	@Min(2)
	@Max(500)
	private Integer precioMedio;//x
	private String especialidad1;
	private String especialidad2;
	private String especialidad3;
	
	@Column (name="creado_en")
	private LocalDateTime creadoEn;
	
	@PrePersist//este método, marcado asi, se ejecuta antes de insertar el restaurante
	private void generarFechaCreacion()
	{
		this.creadoEn=LocalDateTime.now(); //obtengo la fecha del sistema
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getBarrio() {
		return barrio;
	}
	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getFichaGoogle() {
		return fichaGoogle;
	}

	public void setFichaGoogle(String fichaGoogle) {
		this.fichaGoogle = fichaGoogle;
	}

	public float getLatitud() {
		return latitud;
	}

	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}

	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

	
	
	public Integer getPrecioMedio() {
		return precioMedio;
	}

	public void setPrecioMedio(Integer precioMedio) {
		this.precioMedio = precioMedio;
	}

	public String getEspecialidad1() {
		return especialidad1;
	}

	public void setEspecialidad1(String especialidad1) {
		this.especialidad1 = especialidad1;
	}

	public String getEspecialidad2() {
		return especialidad2;
	}

	public void setEspecialidad2(String especialidad2) {
		this.especialidad2 = especialidad2;
	}

	public String getEspecialidad3() {
		return especialidad3;
	}

	public void setEspecialidad3(String especialidad3) {
		this.especialidad3 = especialidad3;
	}

	public LocalDateTime getCreadoEn() {
		return creadoEn;
	}

	public void setCreadoEn(LocalDateTime creadoEn) {
		this.creadoEn = creadoEn;
	}

	public Restaurante(long id, String nombre, String barrio, String direccion, String web, String fichaGoogle,
			float f, float g, Integer precio_medio, String especialidad1, String especialidad2,
			String especialidad3, LocalDateTime creadoEn) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.barrio = barrio;
		this.direccion = direccion;
		this.web = web;
		this.fichaGoogle = fichaGoogle;
		this.latitud = f;
		this.longitud = g;
		this.precioMedio = precio_medio;
		this.especialidad1 = especialidad1;
		this.especialidad2 = especialidad2;
		this.especialidad3 = especialidad3;
		this.creadoEn = creadoEn;
		
		
	}

	@Override
	public String toString() {
		return "Restaurante [id=" + id + ", nombre=" + nombre + ", barrio=" + barrio + ", direccion=" + direccion
				+ ", web=" + web + ", fichaGoogle=" + fichaGoogle + ", latitud=" + latitud + ", longitud=" + longitud
				+ ", precioMedio=" + precioMedio + ", especialidad1=" + especialidad1 + ", especialidad2="
				+ especialidad2 + ", especialidad3=" + especialidad3 + ", creadoEn=" + creadoEn + "]";
	}

	public Restaurante() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
