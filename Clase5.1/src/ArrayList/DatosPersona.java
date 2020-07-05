package ArrayList;

import java.util.Scanner;

/*clase para almacenar la información de la persona*/

public class DatosPersona {
	Scanner teclado;
	String tipoIdentificacion;
	int numeroidentificacion;
	String nombreCompleto;
	int edad;

	public DatosPersona() {
		teclado = new Scanner(System.in);
		System.out.println("Digite su tipo de identifcación: ");
		this.tipoIdentificacion = teclado.next();
		System.out.println("Digite su numero de identifcación: ");
		this.numeroidentificacion = teclado.nextInt();
		System.out.println("Digite su nombre completo: ");
		this.nombreCompleto = teclado.next();
		System.out.println("Digite su edad: ");
		this.edad = teclado.nextInt();

	}

	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public int getNumeroidentificacion() {
		return numeroidentificacion;
	}

	public void setNumeroidentificacion(int numeroidentificacion) {
		this.numeroidentificacion = numeroidentificacion;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

}
