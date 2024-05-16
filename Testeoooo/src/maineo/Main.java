package maineo;

import java.util.Iterator;
import java.lang.Math;
import java.math.BigInteger;

public class Main {
	
		public static void main(String[] args) {
		BigInteger varA = new BigInteger("1");
		BigInteger varB = new BigInteger("1");
		BigInteger varC = new BigInteger("1");
		BigInteger varD = new BigInteger("1");
		BigInteger uno = new BigInteger("1");
		BigInteger tres = new BigInteger("3");
		BigInteger cuatro = new BigInteger("4");
		//double contador = Math.pow(2023,100);
		long contador = 100;
		//int contador = 100;
		BigInteger resultado = new BigInteger("0");
		for (int i = 0; i < contador;i++)
		{
			resultado = varD.multiply(tres).add(varC.multiply(uno)).add(varB.multiply(cuatro)).add(varA.multiply(uno));
			varA = varB;
			varB = varC;
			varC = varD;
			varD = resultado;
			System.out.println(varD.remainder(BigInteger.TEN.pow(10)));
			//System.out.println(varD);
		}
		//int resultadoPantalla =  varD % 10000000000; 
		
	}
}
