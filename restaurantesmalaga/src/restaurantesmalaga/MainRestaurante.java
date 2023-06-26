package restaurantesmalaga;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import restaurantesmalaga.ComparadorDeRestaurantes;
import restaurantesmalaga.Restaurante;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainRestaurante {

	private static final String RUTA_FICHERO = "Restaurantes.txt";

	private static void quitarBlancos(String[] especialidades) {
		for (int z = 0; z < especialidades.length; z++) {
			especialidades[z] = especialidades[z].trim();// quita espacios por delante y por detras
		}
	}

	public static List<Restaurante> cargarRestaurantes(List<String> lineas) {

		List<Restaurante> lRestaurantes = null;
		int numlinea = 0;
		Restaurante restauranteAux = null; // El restaurante en curso
		restauranteAux = new Restaurante(); // Creo el restaurante vacio
		lRestaurantes = new ArrayList<>(); // lista de restaurantes

		for (String linea : lineas) {
			numlinea = numlinea + 1;
			switch (numlinea) {
			case 1:
				restauranteAux.setNombre(linea);
				break;
			case 2:
				restauranteAux.setDireccion(linea);
				break;
			case 3:
				restauranteAux.setWeb(linea);
				break;
			case 4:
				restauranteAux.setFichaGoogle(linea);
				break;
			case 5:
				restauranteAux.setLatitud(Float.parseFloat(linea));
				break;
			case 6:
				restauranteAux.setLongitud(Float.parseFloat(linea));
				break;
			case 7:
				restauranteAux.setBarrio(linea);
				break;
			case 8:
				restauranteAux.setPrecioMedio(Float.parseFloat(linea));
				break;
			case 9:
				String[] especialidades = linea.split(","); // troceo esp1 esp2 esp3
				quitarBlancos(especialidades);
				// paso de array a lista
				List<String> lespecialidades = Arrays.asList(especialidades);
				restauranteAux.setEspecialidades(lespecialidades);
				lRestaurantes.add(restauranteAux);
				numlinea = 0;
				restauranteAux = new Restaurante();
				break;
			}
		}

		return lRestaurantes;
	}

	public static void main(String[] args) throws IOException {
		// TODO Cargar la lista de restaurantes del fichero

		File file = new File(RUTA_FICHERO);
		if (file.exists()) {
			System.out.println("Fichero existe, a parsearlo");
			Path path = file.toPath(); // convierto a path para usar el nuevo api
			List<String> lineas = Files.readAllLines(path); // leo todo el fichero en una linea
			List<Restaurante> ListRest = cargarRestaurantes(lineas);
			System.out.println("La lista ORIGINAL tiene " + ListRest.size());
			mostrarRestaurantes(ListRest);
			System.out.println("La lista ORDENADA por precio " + ListRest.size());
			Collections.sort(ListRest);// orden natural
			mostrarRestaurantes(ListRest);

			System.out.println("La lista ORDENADA por nombre " + ListRest.size());
			ComparadorDeRestaurantes cr = new ComparadorDeRestaurantes();
			Collections.sort(ListRest, cr);// orden total
			mostrarRestaurantes(ListRest);

			Restaurante r5 = ListRest.get(4);
			boolean esta = buscarRestaurante(ListRest, r5);
			System.out.println("R5 esta en la lista " + esta);

			List<Restaurante> estaLaEspecialidad = buscarPorEspecialidad(ListRest, "fritura");
			System.out.println("Los restaurantes que tienen la especialidad que te gusta son " + estaLaEspecialidad);

			List<Restaurante> estaElNombre = buscarPorNombre(ListRest, "McDonadls2");
			System.out.println("Los restaurantes que tienen el nombre que buscas son " + estaElNombre);

			List<Restaurante> estaElBarrio = buscarPorBarrio(ListRest, "la palmilla");
			System.out.println("Los restaurantes que estan en el barrio que quieres son " + estaElBarrio);

			List<Restaurante> estaElPrecio = buscarPorPrecio(ListRest, (float) 19);
			System.out.println("Los restaurantes que tienen ese precio medio son " + estaElPrecio);
			mostrarRestaurantes(estaElPrecio);

		} else {
			System.out.println("No existe el fichero en esa ruta: (");
		}

	}

	public static void mostrarRestaurantes(List<Restaurante> ListRest) {
		// muestra nombre canonigo seguida de una ruta interna de la memoria
		System.out.println("Mostrando restaurantes...");
		for (Restaurante r : ListRest) {
			System.out.println(r.toString());
		}
	}

	public static boolean buscarRestaurante(List<Restaurante> ListRest, Restaurante restauranteBuscado) {
		boolean estaRestaurante = false;
		int pos_actual = 0;
		int longitud = ListRest.size();
		Restaurante restauranteAux = null;

		while (pos_actual < longitud && !estaRestaurante) {
			restauranteAux = ListRest.get(pos_actual);
			estaRestaurante = restauranteAux.equals(restauranteBuscado);
			pos_actual += 1;
		}

		return estaRestaurante;
	}

	public static List<Restaurante> buscarPorEspecialidad(List<Restaurante> ListRest, String especialidadBuscada) {
		List<Restaurante> ListaDeRestaurantes = new ArrayList<>();

		for (Restaurante restaurante : ListRest) {
			if (restaurante.getEspecialidades().contains(especialidadBuscada)) {
				ListaDeRestaurantes.add(restaurante);
			}

		}
		return ListaDeRestaurantes;
	}

	public static List<Restaurante> buscarPorNombre(List<Restaurante> ListRest, String nombreBuscado) {
		List<Restaurante> ListaDeRestaurantes = new ArrayList<>();

		for (Restaurante restaurante : ListRest) {
			if (restaurante.getNombre().contains(nombreBuscado)) {
				ListaDeRestaurantes.add(restaurante);
			}

		}
		return ListaDeRestaurantes;
	}

	/*
	 * List<Restaurante> listaRestNombres = null; listaRestNombres = new
	 * ArrayList<Restaurante>(); for (Restaurante r : listaRestNombres){
	 * if(r.getNombre().indexOf(nombre)!=-1){ listaRestNombres.add(r); }}
	 */

	/*
	 * Mostrar restaurantes lambda
	 * listRest.forEach(restaurante->System.out.println(restaurante));
	 */

	public static List<Restaurante> buscarPorPrecio(List<Restaurante> ListRest, Float precio) {
		List<Restaurante> ListaPorPrecio = new ArrayList<>();

		for (Restaurante restaurante : ListRest) {
			if (restaurante.getPrecioMedio() <= precio) {
				ListaPorPrecio.add(restaurante);
			}
		}
		return ListaPorPrecio;
	}

	/*
	 * busqueda por precio con funcion lambda
	 * 
	 * public static List<Restaurante> buscarPorPrecioMedio(List<Restaurante>
	 * listRest, float presupuesto){ List<Restaurante> lRestConPrecioMaximoBuscado =
	 * null;
	 * 
	 * 
	 * lRestConPrecioMaximoBuscado = listRest .stream() .filter(r -> {return
	 * (r.getPrecioMedio()<=presupuesto);}) .toList();
	 * 
	 * return lRestConPrecioMaximoBuscado;
	 * 
	 * }
	 */

	public static List<Restaurante> buscarPorBarrio(List<Restaurante> ListRest, String barrioBuscado) {
		List<Restaurante> ListaDeRestaurantes = new ArrayList<>();

		for (Restaurante restaurante : ListRest) {
			if (restaurante.getBarrio().contains(barrioBuscado)) {
				ListaDeRestaurantes.add(restaurante);
			}

		}
		return ListaDeRestaurantes;
	}

}
