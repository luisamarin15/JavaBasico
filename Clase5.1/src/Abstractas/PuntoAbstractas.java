package Abstractas;

public class PuntoAbstractas {

	public static void main(String[] args) {
		Comercial comercial = new Comercial(2000000, "Luisa","Marin", 28);
		comercial.extras(comercial.horas());
		System.out.println("Nombre del empleado: "+ comercial.nombre);
		System.out.println("Apellido del empleado: "+comercial.apellido);
		System.out.println("La edad del empleado: " + comercial.edad);		
		System.out.println("El salario del empleado: " + comercial.salario);		
		System.out.println("Total a pagar al  empleado: " + comercial.totalextras);
		
		

	}

}
