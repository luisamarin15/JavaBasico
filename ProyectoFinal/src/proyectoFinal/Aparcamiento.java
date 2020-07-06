package proyectoFinal;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;



public class Aparcamiento {
	static Scanner teclado = new Scanner(System.in);
	static String matricula;

	public static class VehiculoYaRegistrado extends Exception {
	}

	public static class VehiculoYaAparcado extends Exception {
	}

	public static class VehiculoNoAparcado extends Exception {
	}

	// Lista vehiculos
	LinkedList<Vehiculo> aparcados = new LinkedList<Vehiculo>();

	// Lista vehiculos oficiales
	LinkedList<VehiculoOficial> oficiales = new LinkedList<VehiculoOficial>();

	// Lista vehiculos residentes

	LinkedList<VehiculoResidente> residentes = new LinkedList<VehiculoResidente>();

	public Aparcamiento() {
		super();
	}

	// Registrar oficial
	public void registraOficial(String matricula) throws VehiculoYaRegistrado {
		VehiculoOficial vehi = buscaOficial(matricula);
		if (vehi != null)
			throw new VehiculoYaRegistrado();
		vehi = new VehiculoOficial(matricula);
		oficiales.add(vehi);
	}

	// busca el vehiculo oficial
	public VehiculoOficial buscaOficial(String matricula) {
		for (VehiculoOficial vehi : oficiales) {
			if (vehi.getMatricula().equals(matricula))
				return vehi;
		}
		return null;
	}

	public void registraResidente(String matricula) throws VehiculoYaRegistrado {
		VehiculoResidente Vehi = buscaResidente(matricula);
		if (Vehi != null)
			throw new VehiculoYaRegistrado();
		Vehi = new VehiculoResidente(matricula);
		residentes.add(Vehi);
	}

	// busca el vehiculo residente
	public  VehiculoResidente buscaResidente(String matricula) {
		for (VehiculoResidente vehi : residentes) {
			if (vehi.getMatricula().equals(matricula))
				return vehi;
		}
		return null;
	}

	// buscar vehiculo aparcados
	public  Vehiculo buscaAparcado(String matricula) {
		for (Vehiculo vehi : aparcados) {
			if (vehi.getMatricula().equals(matricula))
				return vehi;
		}
		return null ;
	}

	
	public  void entra(String matricula) throws VehiculoYaAparcado {
		Vehiculo vehi = buscaAparcado(matricula);
		if (vehi != null) {
			//vehiculo ya existe
			throw new VehiculoYaAparcado();
		}
		// Busqueda vehículo residente
		vehi = buscaResidente(matricula);
		if (vehi == null) {
			// Busqueda vehículo oficial
			vehi = buscaOficial(matricula);
			if (vehi == null) {
				//creación residente
				vehi = new VehiculoNoResidente(matricula);
			}
		}
		//añadir vehículo aparcado
		vehi.comienzaEstancia();
		aparcados.add(vehi);
	}

	public Vehiculo sale(String matricula) throws VehiculoNoAparcado {
		Vehiculo vehi = buscaAparcado(matricula);
		if (vehi == null) {
			//validación si el vehículo está aparcado
			throw new VehiculoNoAparcado();
		}
		// eliminación del vehículo
		vehi.finEstancia();
		aparcados.remove(vehi);
		return vehi;
	}

	//Comienza el mes para los vehículos los vehículos de residentes.
	public void comienzaMes() {
		for (VehiculoResidente vehi : residentes)
			vehi.comienzaMes();
		}
	
	

	public void generaInformePagosResidentes(String nomFich) throws IOException {
		PrintWriter sal = null;

		try {
			sal = new PrintWriter(new FileWriter(nomFich));
			sal.println("matricula Tiempo estacionado (min.)" + " Cantidad a pagar");
			for (VehiculoResidente v : residentes) {
				sal.printf("%-20s %7d %20.2f%n", v.getMatricula(), v.getTiempoAcumulado(), v.pagoMes());
			}
		} finally {
			if (sal != null)
				sal.close();
		}
	}

	public static void menuPrincipal() {
		boolean salir = false;
		Aparcamiento apar = new Aparcamiento();
		while (!salir) {
		System.out.println("Bienvenido al menu principal");
		System.out.println("Seleccione la opcion: ");
		System.out.println("1. Registrar entrada: ");
		System.out.println("2. Registrar salida: ");
		System.out.println("3. Da de alta vehículo de oficial: ");
		System.out.println("4. Da de alta vehículo de residente: ");
		System.out.println("5. Comienza mes: ");
		System.out.println("6. Pagos de residentes: ");
		System.out.println("7. Salir: ");
 try {
		int opcion = teclado.nextInt();
		switch (opcion) {
		case 1:
			System.out.println("Digite la placa: ");
			matricula = teclado.next();
			apar.entra(matricula);
			break;

		case 2:
			System.out.println("Digite la placa: ");
			matricula = teclado.next();
			apar.sale(matricula);

			break;

		case 3:
			System.out.println("Digite la placa: ");
			matricula = teclado.next();
			apar.registraOficial(matricula);

			break;

		case 4:
			System.out.println("Digite la placa: ");
			matricula = teclado.next();
			apar.registraResidente(matricula);
			break;

		case 5:
			System.out.println("Digite la placa: ");
			matricula = teclado.next();
			apar.comienzaMes();
			break;

		case 6:
			System.out.println("Digite la placa: ");
			matricula = teclado.next();
			apar.generaInformePagosResidentes(matricula);
			break;
			
		case 7:
			System.out.println("Hasta Luego");
			salir = true;			
			break;
			
			default:
			System.out.println("opción no valida");

		}
 }
 
 catch(Exception error){
	
	 System.out.println("error" + error.getMessage());
 }
		
	}
	}

	public static void main(String[] args) {
		Aparcamiento.menuPrincipal();

	}

}
