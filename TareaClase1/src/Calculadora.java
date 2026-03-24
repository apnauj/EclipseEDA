import java.util.*;

public class Calculadora {
	
	public static int mcd(int a, int b) throws IllegalArgumentException {
//		if(a <= 0 || b <= 0) {
//			throw new IllegalArgumentException("Los numeros deben ser enteros positivos");
//		}else {
			while(a != b) {
				if(a > b) {
					a -= b;
				} else {
					b-=a;
				}
			}
			return a;
//		}
	}
	
	public static int factorial(int a) throws IllegalArgumentException {
		if(a < 0) {
			throw new IllegalArgumentException("El numero debe ser mayor o igual que 0");
		}
		int ans = 1;
		for(int i = a; i > 0; i--) {
			ans *= i;
		}
		return ans;
	}
	
	public static void menu() {
		System.out.println("Por favor elija que desea hacer a continuacion");
		System.out.println("1. Calcular el MCD de dos numeros");
		System.out.println("2. Calcular el factorial de un numero");
		System.out.println("3. Salir");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Bienvenido a tu calculadora de MCD y factorial");
		boolean flag = true;
		while(flag) {
			Calculadora.menu();
			
			switch (sc.next()) {
			case "1"-> {
				try {
				System.out.println("Ingrese su primer número");
				int a = Integer.parseInt(sc.next());
				System.out.println("Ingrese su segundo número");
				int b = Integer.parseInt(sc.next());
				System.out.println("El mcd es: " + Calculadora.mcd(a, b));
				} 
//				catch(NumberFormatException e) {
//					System.out.println("Error: la entrada no es un número entero");
//				} 
				catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
				
			}
			case "2"->{
				try {
				System.out.println("Ingrese su número");
				int a = Integer.parseInt(sc.next());
				System.out.println(a+"! es "  + Calculadora.factorial(a));
				} catch(NumberFormatException e) {
					System.out.println("Error: la entrada no es un número entero");
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
			}
			case "3"->{
				System.out.println("Saliendo...");
				flag = false;
			}
			default->{
				System.out.println("Opcion inválida intente de nuevo");
			}
			}
		}
	}
}
