package Abstractas;

public class oveja extends Animal {
	// Atributos
	int patas;

	// Getters & Setters
	public int getPatas() {
		return patas;
	}

	public void setPatas(int patas) {
		this.patas = patas;
	}

	// Constructor
	public oveja(String nombre, int patas) {
		super(nombre);
		this.patas = patas;
	}

	// Metodos implementados de la clase abstracta Animal
	@Override
	void sonido() {
		System.out.println("BEEEE!");
	}

	@Override
	void comer() {
		System.out.println("Ñam ñam!");
	}

	@Override
	String saludar() {
		return "Hola Soy: "+ this.nombre;
	}
}
