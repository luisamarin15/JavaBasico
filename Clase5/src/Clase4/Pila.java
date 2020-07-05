package Clase4;

public class Pila {
/*
	class Nodo {
		int edad;// dato de la lista
		String nombre;
		Nodo sig; //puntero de la lista
	}
*/
	private Nodo raiz; //instancia de tipo nodo

	public Pila() {
		raiz = null;
	}

	public void insertar(int x, String nombre) {
		Nodo nuevo;
		nuevo = new Nodo();
		nuevo.edad = x;
		nuevo.nombre = nombre;
		if (raiz == null) {
			nuevo.sig = null;
			raiz = nuevo;
		} else {
			nuevo.sig = raiz;
			raiz = nuevo;
		}
	}

	public int extraer() {
		if (raiz != null) {
			int informacion = raiz.edad;
			raiz = raiz.sig;
			return informacion;
		} else {
			return Integer.MAX_VALUE;
		}
	}

	public void imprimir() {
		Nodo reco = raiz;
		System.out.println("Listado de todos los elementos de la pila.");
		System.out.println("Raiz-");
		while (reco != null) {
			System.out.print("(");
			System.out.print(reco.edad + "-");
			System.out.print(reco.nombre + "-");
			System.out.print(")");
			reco = reco.sig;
		}
		System.out.println("Cola");
		System.out.println();
	}

	public static void main(String[] args) {
		Pila pila1 = new Pila();
		pila1.insertar(10, "juan");
		pila1.insertar(40, "luisa");
		pila1.insertar(3, "fernanda");
		pila1.imprimir();
		System.out.println("Extraemos de la pila:" + pila1.extraer());
		pila1.imprimir();

	}

}//39:20
