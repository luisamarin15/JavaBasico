package proyectoFinal;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Aparcamento {
	static Scanner teclado = new Scanner(System.in);
	
	public static class VehiculoYaRegistrado extends Exception {
	}

	public static class VehiculoYaAparcado extends Exception {
	}

	public static class VehiculoNoAparcado extends Exception {
	}

	// Veh�culos que se encuentran en un momento dado en el
	// aparcamiento. Pueden ser tanto veh�culos de residentes,
	// como oficiales como de no residentes
	private LinkedList<Vehiculo> aparcados = new LinkedList<Vehiculo>();

	// Registro de veh�culos oficiales
	private LinkedList<VehiculoOficial> oficiales = new LinkedList<VehiculoOficial>();

	// Registro de veh�culos de residentes
	private LinkedList<VehiculoResidente> residentes = new LinkedList<VehiculoResidente>();

	/**
	 * Busca el coche con la matricula indicada en la lista de veh�culos oficiales
	 * 
	 * @param matricula matricula del veh�culo buscado
	 * @return el veh�culo o null en caso de que no lo encuentre
	 */
	private VehiculoOficial buscaOficial(String matricula) {
		for (VehiculoOficial vehi : oficiales) {
			if (vehi.getMatricula().equals(matricula))
				return vehi;
		}
		return null;
	}

	private VehiculoResidente buscaResidente(String matricula) {
		for (VehiculoResidente vehi : residentes) {
			if (vehi.getMatricula().equals(matricula))
				return vehi;
		}
		return null;
	}

	/**
	 * Busca el coche con la matricula indicada en la lista de veh�culos aparcados
	 * 
	 * @param matricula matricula del veh�culo buscado
	 * @return el veh�culo o null en caso de que no lo encuentre
	 */
	private Vehiculo buscaAparcado(String matricula) {
		for (Vehiculo vehi : aparcados) {
			if (vehi.getMatricula().equals(matricula))
				return vehi;
		}
		return null;
	}

	/**
	 * A�ade el coche con la matricula indicada a la lista de * veh�culos oficiales
	 * 
	 * @param matricula matricula del nuevo coche oficial
	 * @throws VehiculoYaRegistrado ya existe un coche con esa matricula en la lista
	 */
	public void registraOficial(String matricula) throws VehiculoYaRegistrado {
		VehiculoOficial vehi = buscaOficial(matricula);
		if (vehi!= null)
			throw new VehiculoYaRegistrado();
		vehi = new VehiculoOficial(matricula);
		oficiales.add(vehi);
	}

	/**
	 * A�ade el coche con la matricula indicada a la lista de veh�culos de
	 * residentes
	 * 
	 * @param matricula matricula del nuevo coche de residente
	 * @throws VehiculoYaRegistrado ya existe un coche con esa matricula en la lista
	 */
	public void registraResidente(String matricula) throws VehiculoYaRegistrado {
		VehiculoResidente v = buscaResidente(matricula);
		if (v != null)
			throw new VehiculoYaRegistrado();
		v = new VehiculoResidente(matricula);
		residentes.add(v);
	}

	/**
	 * Un veh�culo entra al aparcamiento
	 * 
	 * @param matricula matricula del coche que entra
	 * @throws VehiculoYaAparcado ya existe un coche con esa matricula dentro del
	 *                            aparcamiento
	 */
	public void entra(String matricula) throws VehiculoYaAparcado {
		Vehiculo vehi = buscaAparcado(matricula);
		if (vehi != null) {
// error: ya existe un coche dentro del aparcamiento
// con esa matricula
			throw new VehiculoYaAparcado();
		}
// vemos si es un veh�culo de residente
		vehi = buscaResidente(matricula);
		if (vehi== null) {
// no es un veh�culo de residente, vemos si es oficial
			vehi = buscaOficial(matricula);
			if (vehi == null) {
// tampoco es oficial, luego es de no residente.
				// Crea un veh�culo de no residente
				vehi = new VehiculoNoResidente(matricula);
			}
		}
		// sea del tipo que sea, llamamos al m�todo correspondiente
		// a comenzar la estancia y le a�adimos a la lista de
		// veh�culos aparcados
		vehi.comienzaEstancia();
		aparcados.add(vehi);
	}

	/**
	 * Un veh�culo sale del aparcamiento
	 * 
	 * @param matricula matricula del veh�culo que sale
	 * @return el veh�culo que sale para que, si es necesario, puedan consultarse
	 *         sus datos (pago, estancias, ..)
	 * @throws VehiculoNoAparcado si la matricula no corresponde a ning�n veh�culo
	 *                            aparcado
	 */
	public Vehiculo sale(String matricula) throws VehiculoNoAparcado {
		Vehiculo vehi = buscaAparcado(matricula);
		if (vehi == null) {
			// error: el veh�culo deber�a estar en el aparcamiento!!
			throw new VehiculoNoAparcado();
		}
		// finaliza la estancia y se elimina de la lista de aparcados
		vehi.finEstancia();
		aparcados.remove(vehi);
		return vehi;
	}

	/**
	 * Pone a 0 los registros de todos los veh�culos
	 */
	public void comienzaMes() {
		for (VehiculoResidente v : residentes)
			v.comienzaMes();
		for (VehiculoOficial v : oficiales)
			v.comienzaMes();
	}

	/**
	 * Genera un informe con los pagos que deben realizar los residentes
	 * 
	 * @param nomFich fichero en el que se escribe el informe
	 * @throws IOException error de E/S
	 */
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
		
		System.out.println("Bienvenido al menu principal");
		System.out.println("Seleccione la opcion: ");
		System.out.println("1. Registrar entrada: ");
		System.out.println("2. Registrar salida: ");
		System.out.println("3. Da de alta veh�culo de oficial: ");
		System.out.println("4. Da de alta veh�culo de residente: ");
		System.out.println("5. Comienza mes: ");
		System.out.println("6. Pagos de residentes: ");
		
		int opcion = teclado.nextInt();
		switch (opcion) {
		case 1:
		
			
			break;
		case 2:
			
			break;
			
		case 3:
		
			break;
			
		case 4:
			
			
			break;
			
		case 5:
			
			break;
			
			
			default:
				System.out.println("opci�n no valida");

		}
	}
	public static void main(String[] args) {
		Aparcamento a= new Aparcamento(); 		
	
		
	}

}
