package proyectoFinal;

import java.util.*;

public class Estancia {
	private Calendar horaEntrada;
	private Calendar horaSalida;

	public Estancia(Calendar horaEntrada, Calendar horaSalida) {
		super();
		this.horaEntrada = horaEntrada;
		this.horaSalida = horaSalida;
	}

	public Calendar getHoraEntrada() {
		return horaEntrada;
	}

	public Calendar getHoraSalida() {
		return horaSalida;
	}
}