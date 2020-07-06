package proyectoFinal;

import java.util.*;

/**
 * Veh�culo no residente. Debe pagar la estancia al salir.
 */
public class VehiculoNoResidente extends Vehiculo {
	private static final double precioMinuto = 50;
	private double pagoEstancia = 0.0;
	
	

	public VehiculoNoResidente(String matricula) {
		super(matricula);
		
		
	}

	@Override
	public void finEstancia() {
// calcula la cantidad a pagar


	}


	

	public double pagoEstancia() {
		return pagoEstancia;
	}
}