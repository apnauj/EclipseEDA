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
	
	public static int contarSinAux(int[] a) {
		if(a.length == 0) return 0;
		return contarSinAux(a, 0);
	}
	
	public static int contarSinAux(int[] a, int i) {
		if(i == (a.length - 1)) return (a[i] % 2 == 0) ? 1 : 0;
		if(a[i] % 2 == 0) return 1 + contarSinAux(a, ++i);
		return contarSinAux(a, ++i);
	}
	
	public static void main(String[] args) {
		int[] a = {2,2,1};
		System.out.println(contarSinAux(a));
	}
}
