package basicos;

/**
 * 
 * 
 * @author Val
 *
 *El código de esta clase, es un poco misterioso. Algún programador Clase "C", no ha usado
 *nombres descriptivos y ahora, nos toca pegarnos y descubrir qué narices hace este código, 
 *para poder usarlo en nuestro proyecto.
 *
 *
 *Se pide:
 *
 *1) Adivinar la funcionalidad del método adivinaQueHace
 *2) Una vez descubierto, aplicar un nombre apropiado al método y a la clase
 *3) Idear un método equivalente, pero distinto. Es decir, crear un método 
 *que haga lo mismo que adivinaQueHace, pero de otra manera.
 *4) EXTRA: Sólo si resolviste los puntos anteriores, implementa una versión recursiva
 *
 */
public class EsCapicua {
	
//	private static boolean adivinaQueHace (String cad)
	//{
//		boolean bd = true;
		
//		int i = 0;
//		int j = cad.length()-1;
		
//		while ((i<=j)&&(bd))
//		{
//			bd = cad.charAt(i)==cad.charAt(j);
//			i++;
//			j--;
//		}
		
		
//		return bd;
//	}
	
	//public static void main(String[] args) {
	//	if (adivinaQueHace("peeep"))
	//	{
	//		System.out.println("VERDADERO");
	//	} else 
	//	{   System.out.println("FALSO");
	//	}
	//}
	
	//conocer si el primer caracter y el ultimo son iguales
		 
	
	
	
	
	
	public static boolean esCapicua(String cadena) {

		boolean capicua, primerultimo, cadenamedia = true;
		int aux, longitud = 0;
		longitud = cadena.length();

		if (cadena.charAt(0) == cadena.charAt(longitud - 1)) {
			primerultimo = true;
		} else {
			primerultimo = false;
		}

		for (aux = 1; aux == longitud - 3; aux++)
			;
		{
			if (cadena.charAt(aux) == cadena.charAt(aux + 1)) {
				cadenamedia = true;
			} else {
				cadenamedia = false;
			}

			capicua = primerultimo && cadenamedia;
			return capicua;
		}
	}

//	public static void main(String[] args) {
//		if (esCapicua("wuuuuuuuuw")) {
//			System.out.println("VERDADERO");
//		} else {
//			System.out.println("FALSO");
//		}
//	}
	
	public static boolean comparaCadenaRecursiva (int inicio, int fin, String cad)
	{
		if (inicio>=fin) 
			return true;
		else {
			return cad.charAt(inicio)==cad.charAt(fin) 
					&& comparaCadenaRecursiva(++inicio, --fin, cad);
		}
	}
	
	
}
