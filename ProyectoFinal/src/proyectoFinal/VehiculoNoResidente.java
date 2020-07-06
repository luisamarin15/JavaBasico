package proyectoFinal;

import java.util.*;

/**
 * VehÝculo no residente. Debe pagar la estancia al salir.
 */
public class VehiculoNoResidente extends Vehiculo {
	private static final double precioMinuto = 50;
	private double pagoEstancia = 0.0;

	public VehiculoNoResidente(String matrÝcula) {
		super(matrÝcula);
	}

	@Override
	public void finEstancia() {
// calcula la cantidad a pagar

		pagoEstancia = difEnMinutos(getHoraEntrada(), Calendar.getInstance()) * precioMinuto;
	}



	public double pagoEstancia() {
		return pagoEstancia;
	}
}