package General;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ListaNumeros {
	
	

	public static void main(String[] args) {
		List<Integer> ListaNumeros = new ArrayList();
		ListaNumeros.add(4);
		ListaNumeros.add(6);
		ListaNumeros.add(4);
		ListaNumeros.add(5);
		
		Stream st = ListaNumeros.stream();
		System.out.println(st.filter(Predicate.isEqual(4)).count());
		
		
		

	}

}
