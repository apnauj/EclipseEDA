
public class paresArreglo {
	//Cuantos números pares hay en un arreglo de enteros
	
	public static int pares(int[] a) {
		return pares(a, 0, a.length - 1);
	}
	
	public static int pares(int[] a, int i, int j) {
		if (i == j) return a[i] % 2 == 0 ? 1 : 0;
		int aux = (j+i)/2;
		return pares(a, i, aux) + pares(a, aux+1, j);
	}
	
		
	public static void main(String[] args) {
		int[] b = {2,2,2,3};
		System.out.println(pares(b));
	}
}
