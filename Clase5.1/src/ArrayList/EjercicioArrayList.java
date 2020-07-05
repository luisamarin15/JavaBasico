package ArrayList;

import java.util.Scanner;
import java.util.ArrayList;

public class EjercicioArrayList {

	Scanner teclado;

	/*
	 * Método numeroAlumnos(): este método pide por teclado el número de alumnos de
	 * la clase y devuelve dicho número al programa principal.
	 */
	public static int numeroAlumnos() {
		int n;
		Scanner teclado;
		teclado = new Scanner(System.in);
		System.out.println("Digite el numero de alumnos de la clase: ");
		n = teclado.nextInt();
		return n;

	}

	/*
	 * Método leerAlturas(): pide por teclado las alturas de los N alumnos y las
	 * almacena en el ArrayList. Este método recibe como parámetros el ArrayList
	 * inicialmente vacío y el número de alumnos a leer.
	 */
	public static void leerAlturas(ArrayList<Double> altura, int n) {
		Scanner teclado;
		teclado = new Scanner(System.in);
		double alturaE;
		for (int i = 0; i < n; i++) {
			System.out.print("Ingrese la altura: ");
			alturaE = teclado.nextDouble();
			altura.add(alturaE);
		}

	}

	/*
	 * Método calcularMedias(): calcula y devuelve la media de los alumnos de la
	 * clase. Este método recibe como parámetro el ArrayList con las alturas de
	 * todos los alumnos.
	 */

	public static double calcularMedias(ArrayList<Double> altura) {
		double media = 0;
		for (Double cm : altura) {
			media = media + cm;
		}
		return media / altura.size();
	}

	/*
	 * Método mostrarResultados(): muestra por pantalla todas las alturas y calcula
	 * y muestra el número de alumnos con altura superior e inferior a la media.
	 * Recibe como parámetros el ArrayList con las alturas de todos los alumnos y la
	 * media calculada anteriormente.
	 */

	public static void mostrarResultados(ArrayList<Double> altura, double media) {
		int superior = 0, inferior = 0;
		System.out.println("alturas introducidas: ");
		System.out.println(altura);
		for (Double si : altura) {
			if (si > media)
				superior = superior + 1;
			else if (si < media)
				inferior = inferior + 1;
		}
		System.out.println("Media: " + media);
		System.out.println("Número de alumnos con altura superior: " + superior);
		System.out.println("Número de alumnos con altura inferior: " + inferior);
	}

	public static void main(String[] args) {
		ArrayList<Double> altura = new ArrayList<Double>();
		double media;
		int n = numeroAlumnos();
		leerAlturas(altura, n);
		media = calcularMedias(altura);
		mostrarResultados(altura, media);

	}

}
