package Abstractas;

public abstract class Empleado {

	String nombre;
	String apellido;
	int edad;
	double salario;

	
	public Empleado(double salario, String nombre,String apellido, int edad ) {
		super();
		this.salario= salario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		
		
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public double getSalario() {
		return salario;
	}


	public void setSalario(double salario) {
		this.salario = salario;
	}


	public abstract boolean extras (double sueldoExtra);
}
