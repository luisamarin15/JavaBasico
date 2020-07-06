package proyectoFinal;

import java.util.Calendar;
import java.util.LinkedList;

/**
 * Vehículo oficial. Lleva la lista de las estancias en el aparcamiento
 * realizadas en el mes en curso
 */
public class VehiculoOficial extends Vehiculo {
// lista de las estancias en el mes en curso
	private LinkedList<Estancia> estancias = new LinkedList<Estancia>();

	public VehiculoOficial(String matricula) {
		super(matricula);
	}

	public LinkedList<Estancia> getEstancias() {
		return estancias;
	}

	@Override
	public void comienzaMes() {
		
	}

	@Override
	public void finEstancia() {
// añade la estancia a la lista
		estancias.add(new Estancia(getHoraEntrada(), Calendar.getInstance()));
	}
}