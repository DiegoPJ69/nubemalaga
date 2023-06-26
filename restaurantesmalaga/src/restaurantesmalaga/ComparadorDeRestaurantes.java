package restaurantesmalaga;

import java.util.Comparator;

public class ComparadorDeRestaurantes implements Comparator<Restaurante> {

	@Override
	public int compare(Restaurante o1, Restaurante o2) {

		return o1.getNombre().compareTo(o2.getNombre());
	}

}
/*
import java.util.Collections;
import java.util.Comparator;

public class ComparadorBarrioEspecialidadPrecio implements Comparator<Restaurante> {

	@Override
	public int compare(Restaurante o1, Restaurante o2) {
		// ordenamos por barrio
		int resultadoBarrio = o1.getBarrio().compareTo(o2.getBarrio());

		// Si el barrio es coincidente, ordenar por especialidad
		if (resultadoBarrio == 0) {
			int resultadoEspecialidad = 0;
			Collections.sort(o1.getEspecialidades());
			Collections.sort(o2.getEspecialidades());
			//une cada posición de la colección con el caracter dado (""). Concatena todo los valores.
			String stro1 = String.join("", o1.getEspecialidades());
			String stro2 = String.join("", o2.getEspecialidades());
			//compara el resultado de la concatenación de String
			resultadoEspecialidad = stro1.compareTo(stro2);
			
			// Si la especialidad coincide, ordenamos por precio medio. Si no, solo nos devuelve la ordenación por barrio/especialidad.
			if (resultadoEspecialidad == 0) {
				int resultadoPrecio = 0;
				if (o1.getPrecioMedio() > o2.getPrecioMedio()) {
					resultadoPrecio = 1;
				} else if (o1.getPrecioMedio() < o2.getPrecioMedio()) {
					resultadoPrecio = -1;
				}
				return resultadoPrecio;

			} else {
				return resultadoEspecialidad;
			}

		} else {
			return resultadoBarrio;
		}
	}

}


*/