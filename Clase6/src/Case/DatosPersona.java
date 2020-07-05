package Case;

import java.util.Scanner;

public class DatosPersona {
	int numeroIdentificacion;
	String nombre;
	
	
	public DatosPersona() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("digite su numero de identificación: ");
		numeroIdentificacion= teclado.nextInt();
		System.out.println("digite su nombre: ");
		nombre= teclado.next();
		
	}
	
	

}
