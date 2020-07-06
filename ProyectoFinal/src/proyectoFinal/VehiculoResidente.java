package proyectoFinal;

import java.util.Calendar;

/**
 * Vehículo de residente. Lleva la cuenta del tiempo de estancia acumulado en el
 * mes en curso
 */
public class VehiculoResidente extends Vehiculo {
	private static final double precioMinuto = 25;

	private double tiempoAcumulado = 0;

	public VehiculoResidente(String matricula) {
		super(matricula);
	}

	public double getTiempoAcumulado() {
		return tiempoAcumulado;
	}

	@Override
	public void comienzaMes() {
// pone a 0 el tiempo acumulado
		tiempoAcumulado = 0;
	}

	@Override
	public void finEstancia() {


	}
	
	

	public double pagoMes() {
		return tiempoAcumulado * precioMinuto;
	}
}
