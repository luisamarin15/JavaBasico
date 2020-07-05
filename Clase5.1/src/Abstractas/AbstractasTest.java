package Abstractas;

public class AbstractasTest {

	public static void main(String[] args) {
		oveja oveja = new oveja("Dory", 4);
		System.out.println(oveja .saludar());
		System.out.println(oveja .nombre);
		System.out.println(oveja .patas);
		oveja.comer();
		oveja.sonido();

	}

}
