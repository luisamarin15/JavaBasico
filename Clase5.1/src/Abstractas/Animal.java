package Abstractas;

public abstract class Animal {
	String nombre;

	// Constructor
	public Animal(String nombre) {
		// super();
		this.nombre = nombre;
	}

	// Getters & Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// Métodos abstractos
	abstract void sonido();

	abstract void comer();

	abstract String saludar();

	public abstract boolean extras(double sueldoExtra);

}
