package proyectoFinal;

import java.util.*;

/**
 * VehÝculo abstracto. Superclase de las clases de vehÝculos reales
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
}
