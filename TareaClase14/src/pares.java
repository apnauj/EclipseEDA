public class pares {
	
	public static int contar(int[] a) {
		if(a.length == 0) return 0;
		return contar(a, 0, 0);
	}
	
	public static int contar(int[] a, int i, int c) {
		if(i == a.length) return c;
		if(a[i] % 2 == 0) return contar(a, ++i, ++c);
		return contar(a, ++i, c);
	}
	
	public static void main(String[] args) {
		int[] a = {1};
		System.out.println(contar(a));
	}
}
