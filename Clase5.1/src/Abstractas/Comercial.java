package Abstractas;

import java.util.Scanner;

public class Comercial extends Empleado {
	Scanner teclado;
	double horas;
	double valorextras;
	double totalextras;

	public Comercial(double salario, String nombre, String apellido, int edad) {
		super(salario, nombre, apellido, edad);
		this.salario = salario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		
	}
	
	public double horas() {
		double calculo=0;
		teclado = new Scanner(System.in);
		System.out.println("Digite el valor de las horas extras: ");
		this.valorextras = teclado.nextDouble();		
		System.out.println("Digite la cantidad de horas extras: ");
		this.horas = teclado.nextDouble();
		calculo = horas * valorextras;
		return calculo;
		
		
	}
	
	@Override
	public boolean extras(double sueldoExtra) {
		totalextras =sueldoExtra + salario ;
		return true;

	}

}
