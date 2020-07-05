package ArrayList;

import java.util.ArrayList;


public class ArrayListtest {

	public static void main(String[] args) {
		/*
		ArrayList<String> al = new ArrayList<String>();
		al.add("Mauricio");
		al.add("Juan");
		al.add(1, "Lina");
		al.add("Pedro");

		System.out.println("Dato: " + al);

		for (String nombre : al) {
			System.out.println("Dato: " + nombre );

		}
		System.out.println("Valor en la posición 2: " + al.get(2));
		al.set(2, "Juan Luis");
		System.out.println("dato: " + al);
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(21);
		al.add(11);
		al.add(1);
		Collections.sort(al);
		for(Integer edades : al) {
			System.out.println("Edades: " + edades);
			}
		*/
		
		ArrayList<DatosPersona> ald = new ArrayList<DatosPersona>();
		for (int i =0;  i<2; i++) {
			DatosPersona dp =  new DatosPersona();
			ald.add(dp);
		}
		
		/*for (int i =0;  i<ald.size(); i++) {
			System.out.println("Tipo de identificación: " + ald.get(i).getTipoIdentificacion());
			System.out.println("Nuemro de identificación: " + ald.get(i).getNumeroidentificacion());
			System.out.println("Nombre Completo: " + ald.get(i).getNombreCompleto());
			System.out.println("Edad: " + ald.get(i).getEdad());
		}
		*/
		for(DatosPersona dPI: ald) {
			System.out.println("Tipo de identificación: " + dPI.getTipoIdentificacion());
			System.out.println("Nuemro de identificación: " + dPI.getNumeroidentificacion());
			System.out.println("Nombre Completo: " + dPI.getNombreCompleto());
			System.out.println("Edad: " + dPI.getEdad());
			
		}
		
		
		
		
	}

}
