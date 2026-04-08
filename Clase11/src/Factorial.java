import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.Arrays;

public class Factorial {
	
	public static long factorial(long n) {
		long f = 1;
		for (int i = 2; i <= n; i++) {
			f *= i;
		}
		return f;
	}
	
	public static long factorialRecursivo(long n) {
		if(n == 0 || n == 1) return 1;
		return n * factorialRecursivo(n - 1);
	}
	
	public static long fibonacci(long n) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		
		return fibonacci(n-1) + fibonacci(n-2);
	}
	
	public static long fibonacciFor(long n) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		long aux;
		long previo1 = 1;
		long previo2 = 1;
		
		for (int i = 0; i < (n-2); i++) {
			aux = previo1;
			previo1 += previo2;
			previo2 = aux;
			
		}
		return previo1;
	}
	
	public static long fibonacciRecursivo(int n) {
		if(n == 1) return 1;
		if(n == 2) return 1;
		return fibonacciRecursivo(1,1,n);
	}
	
	public static long fibonacciRecursivo(long n1, long n2, long n) {
		if(n <= 2) return n1;
		long aux = n1;
		return fibonacciRecursivo(n1+n2,aux,--n);
	}
	
	public static BigInteger fibonacciRecursivoPro(long n) {
		if(n == 1) return new BigInteger("1");
		if(n == 2) return new BigInteger("1");
		return fibonacciRecursivoPro(new BigInteger("1"),new BigInteger("1"),n);
	}
	
	public static BigInteger fibonacciRecursivoPro(BigInteger n1, BigInteger n2, long n) {
		if(n <= 2) return n1;
		BigInteger aux = n1;
		return fibonacciRecursivoPro(new BigInteger(n1.toString()).add(n2),aux,--n);
	}
	
	public static long sumaNaturales(long n) {
		if(n <= 0) return 0;
		if(n == 1) return n;
		return n + sumaNaturales(n-1);
	}
	
	public static long sumaNaturalesFor(long n) {
		long ans = 0;
		for (int i = 1; i <= n; i++) {
			ans+=i;
		}
		return ans;
	}
	
	public static int sumaElementosCortando(int[] a) {
		if(a.length == 0) return 0;
		if(a.length == 1) return a[0];
		
		return a[a.length - 1] + sumaElementosCortando(Arrays.copyOf(a, a.length - 1));
	}
	
	public static int sumaElementos(int[] a) throws IllegalArgumentException {
		if(a.length == 0 || a == null) throw new IllegalArgumentException();
		return sumaElementos(a, a.length - 1);

	}
	
	public static int sumaElementos(int[] a, int i) {
		if(i == 0) return a[0];
		return a[i] + sumaElementos(a, i-1);
	}
	
	public static int sumaElementosAA(int[] a) throws IllegalArgumentException {
		if(a.length == 0 || a == null) throw new IllegalArgumentException();
		return sumaElementos(a, 0);

	}
	
	public static int sumaElementosAA(int[] a, int i) {
		if(i == (a.length-1)) return a[a.length-1];
		return a[i] + sumaElementos(a, i+1);
	}
	
	public static int maximoEnArreglo(int[] a) {
		if(a.length == 0) return 0;
		if(a.length == 1) return a[0];
		return maximoEnArreglo(a, a.length - 1, a[a.length - 1]);
	}
	
	public static int maximoEnArreglo(int[] a, int i, int max) {
		if(i == 0) return Math.max(a[0], max);
		return maximoEnArreglo(a,i - 1,Math.max(max, a[i]));
	}
	
	
	
	public static void main(String args[]) {
		BigInteger fi1000 = fibonacciRecursivoPro(100);
		BigInteger fi999 = fibonacciRecursivoPro(99);
		BigDecimal b1 = new BigDecimal(fi1000);
		BigDecimal b2 = new BigDecimal(fi999);
		System.out.println(b1.divide(b2, MathContext.DECIMAL128));
	}
}
