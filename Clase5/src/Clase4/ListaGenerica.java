package Clase4;

public class ListaGenerica {
	private Nodo raiz;

	public ListaGenerica() {
		raiz = null;
	}

	void insertar(int pos, int x, String nombre) {
		if (pos <= cantidad() + 1) {
			Nodo nuevo = new Nodo();
			nuevo.edad = x;
			nuevo.nombre = nombre;
			if (pos == 1) {
				nuevo.sig = raiz;
				raiz = nuevo;
			} else if (pos == cantidad() + 1) {
				Nodo reco = raiz;
				while (reco.sig != null) {
					reco = reco.sig;
				}
				reco.sig = nuevo;
				nuevo.sig = null;
			} else {
				Nodo reco = raiz;
				for (int f = 1; f <= pos - 2; f++)
					reco = reco.sig;
				Nodo siguiente = reco.sig;
				reco.sig = nuevo;
				nuevo.sig = siguiente;
			}
		}
	}

	public int extraer(int pos) {
		if (pos <= cantidad()) {
			int edadrmacion;
			if (pos == 1) {
				edadrmacion = raiz.edad;
				raiz = raiz.sig;
			} else {
				Nodo reco;
				reco = raiz;
				for (int f = 1; f <= pos - 2; f++)
					reco = reco.sig;
				Nodo prox = reco.sig;
				reco.sig = prox.sig;
				edadrmacion = prox.edad;
			}
			return edadrmacion;
		} else
			return Integer.MAX_VALUE;
	}

	public void borrar(int pos) {
		if (pos <= cantidad()) {
			if (pos == 1) {
				raiz = raiz.sig;
			} else {
				Nodo reco;
				reco = raiz;
				for (int f = 1; f <= pos - 2; f++)
					reco = reco.sig;
				Nodo prox = reco.sig;
				reco.sig = prox.sig;
			}
		}
	}

	public void intercambiar(int pos1, int pos2) {
		if (pos1 <= cantidad() && pos2 <= cantidad()) {
			Nodo reco1 = raiz;
			for (int f = 1; f < pos1; f++)
				reco1 = reco1.sig;
			Nodo reco2 = raiz;
			for (int f = 1; f < pos2; f++)
				reco2 = reco2.sig;
			int aux = reco1.edad;
			reco1.edad = reco2.edad;
			reco2.edad = aux;
		}
	}

	public int mayor() {
		if (!vacia()) {
			int may = raiz.edad;
			Nodo reco = raiz.sig;
			while (reco != null) {
				if (reco.edad > may)
					may = reco.edad;
				reco = reco.sig;
			}
			return may;
		} else
			return Integer.MAX_VALUE;
	}

	public int posMayor() {
		if (!vacia()) {
			int may = raiz.edad;
			int x = 1;
			int pos = x;
			Nodo reco = raiz.sig;
			while (reco != null) {
				if (reco.edad > may) {
					may = reco.edad;
					pos = x;
				}
				reco = reco.sig;
				x++;
			}
			return pos;
		} else
			return Integer.MAX_VALUE;
	}

	public int cantidad() {
		int cant = 0;
		Nodo reco = raiz;
		while (reco != null) {
			reco = reco.sig;
			cant++;
		}
		return cant;
	}

	public boolean ordenada() {
		if (cantidad() > 1) {
			Nodo reco1 = raiz;
			Nodo reco2 = raiz.sig;
			while (reco2 != null) {
				if (reco2.edad < reco1.edad) {
					return false;
				}
				reco2 = reco2.sig;
				reco1 = reco1.sig;
			}
		}
		return true;
	}

	public boolean existe(int x) {
		Nodo reco = raiz;
		while (reco != null) {
			if (reco.edad == x)
				return true;
			reco = reco.sig;
		}
		return false;
	}

	public boolean vacia() {
		if (raiz == null)
			return true;
		else
			return false;
	}

	public void imprimir() {
		Nodo reco = raiz;
		while (reco != null) {
			System.out.print(reco.edad + "-");
			reco = reco.sig;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ListaGenerica lg = new ListaGenerica();
		lg.insertar(1, 25, "luisa");
		lg.insertar(2, 10, "fernanda");
		lg.insertar(3, 40, "luis");
		lg.insertar(2, 24, "fernando");
		lg.imprimir();
		System.out.println("Luego de Intercambiar el primero con el tercero");
		lg.intercambiar(1, 3);
		lg.imprimir();
		if (lg.existe(20))
			System.out.println("Se encuentra el 20 en la lista");
		else
			System.out.println("No se encuentra el 20 en la lista");
		System.out.println("La posición del mayor es:" + lg.posMayor());
		if (lg.ordenada())
			System.out.println("La lista está ordenada de menor a mayor");
		else
			System.out.println("La lista no está ordenada de menor a mayor");
		System.out.println("Luego de Borrar el primero");
		lg.borrar(1);
		lg.imprimir();
		System.out.println("Luego de Extraer el segundo");
		lg.extraer(2);
		lg.imprimir();
	}

}
