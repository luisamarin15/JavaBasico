package Case;

import java.util.Scanner;

public class Switch {
	Scanner teclado;

	public void menuPrincipal() {
		teclado = new Scanner(System.in);
		System.out.println("Menu principal: ");
		System.out.println("1. Opcion 1: ");
		System.out.println("2. Opcion 2: ");
		System.out.println("3. Opcion 3: ");
		System.out.println("Digite la opci�n ");
		int opcion = teclado.nextInt();
		switch (opcion) {

		case 1:
			System.out.println("Entre a la opci�n 1: ");
			break;

		case 2:
			System.out.println("Entre a la opci�n 2: ");
			break;

		case 3:
			System.out.println("Entre a la opci�n 3: ");
			break;

		default:
			System.out.println("opci�n no valida");
			menuPrincipal();

		}

	}

	public static void main(String[] args) {
		Switch s = new Switch();
		s.menuPrincipal();

	}

}
