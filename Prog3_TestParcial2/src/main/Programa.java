package main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Programa {

	public static void main(String[] args) {
		
		Singleton<Integer> s = new Singleton<>();
		System.out.println(s.getInstance().getClass());
		
		List<Cliente> lista = new ArrayList<>();
		Random rnd = new Random();
		lista = rnd.ints(10,0,100).mapToObj(x -> new Cliente("N",""+x)).toList();
		lista.forEach(System.out::println);
		
		lista = lista.stream()
				.sorted(Comparator.comparing(Cliente::getApellido))
				.toList();
		
		System.out.println("--- Lista filtrada ---");;
		lista.forEach(System.out::println);

		Polinomio fcion = x -> x * x + x;
		System.out.println(fcion.calculate(1));

	}
	interface Polinomio {
	    int calculate(int x);
	}

	
	public static <T> T max(T x, T y) {
		 return x.equals(y) ? x : y;
		 } 

}
