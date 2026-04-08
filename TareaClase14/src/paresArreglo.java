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
	
	
	public static void main(String[] args) {
		int[] b = {1,1,2};
		
		for(int i : pares(b)) {
			System.out.println(i);
		}
	}
}
