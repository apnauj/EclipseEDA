
public class sumaArray {
	
	public static int suma(int[] a) {
		if (a.length == 0) return 0;
		return suma(a, 0, a.length - 1);
	}
	
	public static int suma(int[] a, int i, int j) {
		if (i == j) return a[i];
		int aux = (j+i)/2;
		return suma(a, i, aux) + suma(a, aux+1, j);
	}
	
	public static void main(String[] args) {
		int[] b = {1,2,3,4,5};
		System.out.println(suma(b));
	}
}
