package restaurantesmalaga;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;

import restaurantesmalaga.ComparadorDeRestaurantes;
import restaurantesmalaga.Restaurante;

public class MainMapas {

	private static final String RUTA_FICHERO = "restaurantes.txt";

	public static void main(String[] args) throws IOException {

		// TODO Cargar la lista de restaurantes del fichero
		File file = new File(RUTA_FICHERO);
		if (file.exists()) {
			System.out.println("FICHERO EXISTE!...se procede a tratarlo)");
			Path path = file.toPath();// convierto a PATH para usar el nuevo API y así ir más rápido
			List<String> lineas = Files.readAllLines(path);// leo todo el fichero en una línea
			List<Restaurante> listRest = MainRestaurante.cargarRestaurantes(lineas);

			//creo un mapa con clave nombre
			Map<String, Restaurante> mapaRestaurantes = new HashMap<>();
			for (Restaurante r : listRest) {
				mapaRestaurantes.put(r.getNombre(), r);
			}
			
			//busco el registro correspondiente a La Taberna del Puerto
			Restaurante rp = mapaRestaurantes.get("La Taberna del Puerto");
			//imprimo el registro de la taberna del puerto
			System.out.println(rp.toString());

			// Partiendo de la lista de restaurantes haced un mapa,
			// donde la clave sea el barrio y el valor la lista de restaurantes de ese
			// barrio

			Map<String, List<Restaurante>> mapaRestaurantesPorBarrios = null;
			
			//creo un mapa con clave = barrios
			mapaRestaurantesPorBarrios = crearMapBarrios(listRest);
			
			//imprimo restaurantes por barrio
			mostrarMapa(mapaRestaurantesPorBarrios);
			
			//creo una lista de restaurantes donde incluire los restaurantes mas caros de cada barrio
			List<Restaurante> lr = getRestMasCaros(mapaRestaurantesPorBarrios);
			
			System.out.println("Mostrando los mas caros");
			for (Restaurante r : lr) {
				System.out.println(r.toString());
			}
			
	
			System.out.println("Mostrando los mas caros");
			for (Restaurante r : lr) {
				System.out.println(r.toString());
			}
			
			//averiguo el precio medio de un barrio a partir de la lista de restaurantes y un barrio determinado
			
			float preciomediobarrio=0;
			String barrio="Malagueta";
			preciomediobarrio=getPrecioMedioBarrio(barrio,mapaRestaurantesPorBarrios);
			System.out.println("el precio medio de "+barrio+" es "+preciomediobarrio);
			
			
			

		} else {
			System.out.println("FICHERO NO EXISTE!");
		}
	}
	
	//calculo el precio medio de un barrio determinado
	private static float getPrecioMedioBarrio(String barrio, Map<String, List<Restaurante>> mapaRestaurantes) {
		
		float preciomedio=0;
		float total=0;
		
		List<Restaurante> lrb = mapaRestaurantes.get(barrio);
		int longitud=lrb.size();
		
		for(Restaurante r:lrb) {
			
			total=total+r.getPrecioMedio();
			
		}
		if (longitud>0) {
			preciomedio=total/longitud;
		}
				
		return preciomedio;
	}
	
	
	
	//2) Haced un método que reciba el mapa de restaurantes y me diga el restaurante
	//más barato de todos los barrios.
	
	private static Restaurante getRestauranteMasBarato(Map<String, List<Restaurante>> mapaRestaurantes) {
		
		Restaurante RestauranteMasBarato =null; 
		float preciomenor=5000000;
		
		Set<String> ConjuntoBarrios = mapaRestaurantes.keySet();
		
		for(String barrio:ConjuntoBarrios) {
			
			List<Restaurante> lra=mapaRestaurantes.get(barrio);
			
			for(Restaurante restaurante:lra) {
				
				if(restaurante.getPrecioMedio()<preciomenor)
				{
					preciomenor=restaurante.getPrecioMedio();
					RestauranteMasBarato=restaurante;
				}
			}
			
		}
		
		return RestauranteMasBarato;
		
	}
	
	
	
	//muestro mapa restaurantes por barrio
	private static void mostrarMapa(Map<String, List<Restaurante>> mapa) {

		//saco una lista con los barrios
		Set<String> clavesMapa = mapa.keySet();
		
		//recorro cada barrio e imprimo los restaurantes del barrio
		for (String barrio : clavesMapa) {
			List<Restaurante> lrb = mapa.get(barrio);
			System.out.println("Barrio = " + barrio);
			for (Restaurante rb : lrb) {
				System.out.println(rb.toString());
			}
		}
	}

	public static Map<String, List<Restaurante>> crearMapBarrios(List<Restaurante> lr) {
		
		Map<String, List<Restaurante>> mapa = new HashMap<>();

		// recorro la lista
		// si el barrio ya esta en el mapa añado restaurante a esa lista
		// si no creo lista nueva y añado ese restaurante

		for (Restaurante r : lr) {
			List<Restaurante> lrb = mapa.get(r.getBarrio());
			if (lrb != null) {
				//System.out.println("Ya existen restaurantes con ese barrio");
				lrb.add(r);
			} else {
				List<Restaurante> lnueva = new ArrayList<>();
				lnueva.add(r);
				mapa.put(r.getBarrio(), lnueva);
			}
		}
		
		//devuelvo un mapa con clave = barrio
		return mapa;
	}

	// partiendo del mapa de restaurantes por barrio,
	// hacer un metodo que me devuelva los restaurantes mas caros de cada barrio.

	public static List<Restaurante> getRestMasCaros(Map<String, List<Restaurante>> mapaRestMasCaros) {
		List<Restaurante> listaCaros = new ArrayList<>();

		// TODO recorrer el mapa por barrios y quedarme con el mas caro de cada barrio.

		//saco una lista con los barrios
		Set<String> barrios = mapaRestMasCaros.keySet();
		
		//para cada barrio obtengo el restaurante mas caro
		for (String barrio : barrios) {
			List<Restaurante> lrb = mapaRestMasCaros.get(barrio);
			Restaurante rmascaro = obtenerMasCaro(lrb);
			//voy construyendo la lista del mas caro
			listaCaros.add(rmascaro);
		}

		return listaCaros;
	}

	private static Restaurante obtenerMasCaro(List<Restaurante> lrb) {
		Restaurante restMasCaro = null;
		float precioMayor = 0;

		for (Restaurante r : lrb) {
			if (r.getPrecioMedio() > precioMayor) {
				restMasCaro = r;
				precioMayor = r.getPrecioMedio();
			}
		}

		return restMasCaro;
	}

	private static Restaurante obtenerMasCaro2(List<Restaurante> lrb) {
		Restaurante restMasCaro = null;

		Collections.sort(lrb);
		restMasCaro = lrb.get(lrb.size() - 1);

		return restMasCaro;
	}

}