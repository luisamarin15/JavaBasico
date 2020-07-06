package proyectoFinal;

import java.util.Calendar;

/**
 * Vehículo de residente. Lleva la cuenta del tiempo de estancia acumulado en el
 * mes en curso
 */
public class VehiculoResidente extends Vehiculo {
	private static final double precioMinuto = 25;
// tiempo de estancia acumulado en el mes en curso
	private int tiempoAcumulado = 0;

	public VehiculoResidente(String matricula) {
		super(matricula);
	}

	public int getTiempoAcumulado() {
		return tiempoAcumulado;
	}

	@Override
	public void comienzaMes() {
// pone a 0 el tiempo acumulado
		tiempoAcumulado = 0;
	}

	@Override
	public void finEstancia() {

// incrementa el tiempo acumulado en la duración de
// la estancia que finaliza en este instante
	//	tiempoAcumulado = tiempoAcumulado + (difEnMinutos(getHoraEntrada(), Calendar.getInstance()));
	}

	public double pagoMes() {
		return tiempoAcumulado * precioMinuto;
	}
}
