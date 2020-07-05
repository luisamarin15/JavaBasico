package General;

public class Calculadora implements ICalculadora{

	public static void main(String[] args) {
		Calculadora c= new Calculadora();
		c.sumar(4, 5);
		c.restar(4, 5);
		System.out.println("la multiplicacion  es "+c.multiplicar(4, 5));
		

	}


	public void sumar(int x, int y) {
		System.out.println("la suma de "+x+" + y + es:" + ( x+y) );
		
	}

	public void restar(int x, int y) {
		System.out.println("la resta de "+x+" + y + es:" + ( x-y) );
	}
	@Override
	public int multiplicar(int x, int y) {
		return (x+1)* (y+1);
	}
}
