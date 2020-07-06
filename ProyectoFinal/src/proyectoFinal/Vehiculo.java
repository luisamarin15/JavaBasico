package proyectoFinal;

import java.util.*;

/**
 * Vehículo abstracto. Superclase de las clases de vehículos reales
 */
public abstract class Vehiculo {
	private String matricula;
	private Calendar horaEntrada;

	public Vehiculo(String matricula) {
		this.matricula = matricula;
	}

	public String getMatricula() {
		return matricula;
	}

	public Calendar getHoraEntrada() {
		return horaEntrada;
	}

	public void comienzaMes() {
	}

	public void finEstancia() {
	}

	public void comienzaEstancia() {
		this.horaEntrada = Calendar.getInstance();
	}
	
	public  double difEnMinutos(Calendar horaEntrada, Calendar horaSalida) {
		long milisegundos= horaEntrada.getTime().getTime() - horaSalida.getTime().getTime();
		double minutos = milisegundos/60000;		
		return minutos;
	}
}
