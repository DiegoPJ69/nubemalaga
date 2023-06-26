package basicos;
import java.util.Scanner;



/**
 * 
 * LISTA DE EJERCICIOS DE REPASO A LA PARTE DE INICIACIÓN EN JAVA:
 * 
 * 1) HACER UN MÉTODO QUE RECIBA UNA CADENA Y UN CARACTER Y DIGA SI ESE CARACTER
 * PERTENECE A LA CADENA O NO perteneceACadena 
 * 2) HACER UN MÉTODO QUE RECIBA UNA
 * CADENA Y UN CARACTER Y DIGA CÚANTAS VECES APARECE ESE CARACTER EN LA CADENA
 * 2.1) HACER UN MÉTODO QUE RECIBA UNA CADENA Y UN CARACTER Y DIGA la última
 * posición donde aparece ese caracter en esa cadena. Si no está, devuelve -1
 * 
 * "hola" a --> 3 "maja" a --> 3 "conejo" i --> -1
 * 
 * 
 * 3) HACER UN MÉTODO QUE DADO UN NÚMERO, DIGA SI ES PAR O NO esPar
 * 4) HACER UN MÉTODO QUE LE PIDA AL USUARIO SU EDAD Y LE DIGA SI ES MAYOR DE
 * EDAD O NO mayorDeEdad 
 * 5) HACER UN MÉTODO QUE RECIBA UNA NOTA DE 0 A 10 Y DIGA
 * SI EQUIVALE A UN APROBADO, BIEN, NOTABLE, O SOBRESALIENTE clasificarNota -
 * 6) HACER UN MÉTODO QUE RECIBA UNA CADENA Y LA DEVUELVA ALREVÉS invertirCadena 
 * 7) HACER UN PROGRAMA QUE MUESTRE LA SECUENCIA 3, 6, 9, 12, 15 ...99 deTresEnTres
 *
 *
 * // DEFINO UN MÉTODO // DARLE UN NOMBRE - camelCase // ID la entrada - // ID
 * la salida -
 *
 * //pensar el los pasos en esapñol en psuedocódigo
 */

public class EjercicosBasicos {
	
//	public static void main(String[] args) 
	
//	{
//ejercicio 1
//		if(estaCadena("en un lugar de la mancha",'x')) {
//		System.out.println("el caracter está");
//		}
//		else 
//		{
//			System.out.println("el caracter no esta");
//		}
	
//ejercicio 2		
//		System.out.println(CuantasVecesEsta("en un lugar de la mancha", 'a')+"");
//
		
//ejercicio 2.1
	//System.out.println("la ultima posicion del caracter es "+posicionCaracter("en un lugar de la mancha", 'n')+"");

		//ejercicio 3
		//System.out.println(esPAr(7)+"");		
				
	//ejercicio 4
		//ConsolaEdad();
		
	//ejercicio 5
		
	//	System.out.println("dame tu nota?");
		
		//	Scanner scanner = new Scanner (System.in);
		
		//	float nota=scanner.nextFloat();
		
		//System.out.println(queNota(nota));
		
	//ejercicio 6
		
//System.out.println("introduce una cadena ");
		
//Scanner scanner = new Scanner (System.in);
		
//String cadenaainvertir=scanner.next();

//StringBuilder Cadenainvertida= new StringBuilder(cadenaainvertir).reverse();

//System.out.println(invertirCadena(cadenaainvertir));
			
//ejercicio 7
	//	ImprimeSecuencia();
		
//ejercicio 8
		
//		AssessmentObesidad();
		
//	}
	
	//ejercicio 1
	
	/*1) HACER UN MÉTODO QUE RECIBA UNA CADENA Y UN CARACTER Y DIGA SI ESE CARACTER
 * PERTENECE A LA CADENA O NO perteneceACadena*/
	
	
public static boolean estaCadena (String cadena, char caracter) {
		
	    boolean esta = true;
	    
	    esta = cadena.contains(caracter+"");
			
	    return esta;
	    }

//ejercicio 2

/** 2) HACER UN MÉTODO QUE RECIBA UNA
 * CADENA Y UN CARACTER Y DIGA CÚANTAS VECES APARECE ESE CARACTER EN LA CADENA*/



public static int CuantasVecesEsta(String cadena,char caracter) {
	
    int esta = 0;
    int longitud = cadena.length();
    
    for(int i=0;i<longitud;i++)
    {
    	if (cadena.charAt(i) == caracter)
    	{
    		esta++;
    	}
    }
    
    return esta;
}
    
	
//	if (!=) 
//		{;
//		esta=false;
//		}
		
 //   return esta;
   // }

//ejercicio 2.1

/*2.1) HACER UN MÉTODO QUE RECIBA UNA CADENA Y UN CARACTER Y DIGA la última
* posición donde aparece ese caracter en esa cadena. Si no está, devuelve -1
* 
* usar lastindex
* */

public static int posicionCaracter (String cadena, char caracter) {
	
  int posicion = -1;    
	
  int longitud = cadena.length();
  
  int i=0;
  
  while (cadena.charAt(i) != caracter)
  	{
  		i++;
  	}
  
	if (posicion==-1)	
		
		return posicion;
  else
  	{
	  return posicion+1;
  	}
  }
  


//ejercicio 3
/* 3) HACER UN MÉTODO QUE DADO UN NÚMERO, DIGA SI ES PAR O NO esPar*/

public static String esPAr (int numero) {
	
    
    String paridad="";

	if(numero%2!=0) 
	{
		paridad= "es impar";
	}
	else 
		{
		paridad="es par";
		}
    return paridad;
    }


//ejercicio 4
/*HACER UN MÉTODO QUE LE PIDA AL USUARIO SU EDAD Y LE DIGA SI ES MAYOR DE
 * EDAD O NO mayorDeEdad */

public static void ConsolaEdad()
{

	System.out.println("dame tu edad?");
	
	//Scanner scanner = null;
	
	Scanner scanner = new Scanner (System.in);
	
	int edad=scanner.nextInt();
	
	
	
	if (esMayordeEdad(edad))
	{
		System.out.println("es mayor de edad");
	}
	else 
		{
		System.out.println("es menor de edad");
		}
   
	
}

//Nop haria falta u metodo. se puede tirar con un ir ternario ; (condición ? (if):(else));

public static boolean esMayordeEdad (int edad) {
	
  boolean mayorDeEdad = false;    
	
  if (edad>=18) 
	{
		mayorDeEdad=true;
	}
		
  return mayorDeEdad;
  }


//ejercicio 5

/*5) HACER UN MÉTODO QUE RECIBA UNA NOTA DE 0 A 10 Y DIGA
 * SI EQUIVALE A UN APROBADO, BIEN, NOTABLE, O SOBRESALIENTE clasificarNota -*/

public static String queNota (float nota) {
	
	String calificacion="";
	
	if (nota<5) {
	calificacion ="suspenso";
	}
	else{
		if ((5<=nota)&&(nota<6))
		calificacion ="aprobado";
		else 
		{ 
			if ((5<=nota)&&(nota<7))
			calificacion ="bien";
			else
				{
				if ((7<=nota) && (nota<9))
				calificacion ="notable";
				
				else
				calificacion ="sobresaliente";
				}
		}
	}
     return calificacion;
}

//ejercicio 6
/*
 * 6) HACER UN MÉTODO QUE RECIBA UNA CADENA Y LA DEVUELVA ALREVÉS invertirCadena
 */

public static StringBuilder invertirCadena (String cadena) {  
		
	  StringBuilder Cadenainvertida= new StringBuilder(cadena).reverse();
			
	  return Cadenainvertida;
	  }

//ejercicio 7
/*7) HACER UN PROGRAMA QUE MUESTRE LA SECUENCIA 3, 6, 9, 12, 15 ...99 deTresEnTres*/

public static void ImprimeSecuencia()
{

	for (int i=3;i<100;i=i+9)
	{
		
	String terna1 = i+"";
	String terna2 = i+3+"";
	String terna3 = i+6+"";
	System.out.println(terna1+" "+terna2+" "+terna3+" ");
	
	}

}

//ejercicio 8
/*
 * HACED UNA APLICACIÓN QUE PERMITA INTRODUCIR AL USUARIO
 * SU ESTATURA EN METROS Y SU PESO EN KG Y LE INFORME SU 
 * INFORME DE SU ÍNDICE DE MASA CORPORAL (IMC) SEGÚN LA SIGUIENTE FÓRMULA
 * 
 * LA FÓRMULA DEL IMC = PESO KG / ESTATURA AL CUADRADO METROS
 *  * SI IMC < 16 ->> su imc es DESNUTRIDO
 * SI IMC >= 16 Y < 18  ->> su imc es DELGADO
 * SI IMC >= 18 Y < 25  ->> su imc es IDEAL
 * SI IMC >= 25 Y < 31  ->> su imc es SOBREPESO
 * SI IMC >= 31 ->> su imc es OBESO
 ADEMÁS, DE DECIRLE SU IMC NUMÉRICO Y NOMINAL,
pista: PARA LEER DE TECLADO USAD LA CLASE SCANNER
  */

public static void AssessmentObesidad()
{
 //hacer el IMC
	

	
	System.out.println("Introduce tu peso en kg");
	
	Scanner scanner = new Scanner (System.in);
	
	float peso=scanner.nextFloat();
		
	System.out.println("Introduce tu altura en mtr");
	
	float altura=scanner.nextFloat();
	
	float IMC=peso/(altura*altura);
	
	System.out.println("tu IMC es "+IMC);
	
	String cad="";
	
	
		if(IMC<16.00){
		  cad="DESNUTRIDO";
		}else if(IMC>=16.00 & IMC<18){
		  cad="DELGADO";
		}else if(IMC>=18.00 & IMC<25){
		  cad="IDEAL";
		}else if(IMC>=25 & IMC<31){
		  cad="SOBREPESO";
		}else if(IMC<=31){
		  cad="OBESO";
		} else{
		  cad="no existe clasificacion";
		}
		
	System.out.println("tu estado es "+cad);
	
	
}	

//TODO hacer trabajo con listas


}





