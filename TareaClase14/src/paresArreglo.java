import java.util.Arrays;

public class paresArreglo {
	
	public static int[] pares(int[] a) {
		if(a.length == 0) return new int[0];
		if(a.length == 1) return (a[0] % 2 == 0) ? new int[]{a[0]} : new int[0];
		return pares(a, 0, new int[0]);
	}
	
	public static int[] pares(int[] a, int i, int[] b) {
		if(a[i] % 2 == 0) {
			b = Arrays.copyOf(b, b.length + 1);
			b[b.length - 1] = a[i];
		}
		if(i == a.length - 1) return b;
		return pares(a, ++i, b);
	}
	
	public static int[] dividePares(int[] a) {
		if(a.length == 0) return new int[0];
		if(a.length == 1) return (a[0] % 2 == 0) ? new int[]{a[0]} : new int[0];
		return dividePares(a, 0, a.length - 1);
	}
	
	public static int[] dividePares(int[] a, int i, int j) {
		if(i == j) {
			if (a[i] % 2 == 0) {
				return new int[] {a[i]};
			}
			return new int[0];
		};
		int aux = (j+i)/2;
		return combinar(dividePares(a, i, aux), dividePares(a, aux+1, j));
	}
	
	public static int[] combinar(int[] a, int[] b) {
		int n = a.length;
		a = Arrays.copyOf(a, n + b.length);
		int j = 0;
		for(int i : b) {
			a[n + j] = i;
			j++;
		}
		return a;
	}
	
	
	public static void main(String[] args) {
		int[] b = {1,1,2};
		int[] a = {2,3,4};
		
		for(int i : dividePares(a)) {
			System.out.println(i);
		}
		
		for(int i : dividePares(b)) {
			System.out.println(i);
		}
	}
}
