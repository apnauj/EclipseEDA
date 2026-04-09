
public class matriz {
	
	public static int sumar(int[][] a) {
		if(a.length == 0) return 0;
		return sumar(a, 0, 0, 0);
	}
	
	public static int sumar(int[][] a, int i, int j, int c) {
		if (i == (a.length - 1) && j == (a[i].length - 1)) return c + a[i][j];
		if(j == (a[i].length - 1)) {
			c+=a[i][j];
			return sumar(a, ++i, 0, c);
		} 
		c+=a[i][j];
		return sumar(a, i, ++j, c);
	}
	
	public static int sumarSinAux(int[][] a) {
		if(a.length == 0) return 0;
		return sumarSinAux(a, 0, 0);
	}
	
	public static int sumarSinAux(int[][] a, int i, int j) {
		if (i == (a.length - 1) && j == (a[i].length - 1)) return a[i][j];
		if(j == (a[i].length - 1)) return a[i][j] + sumarSinAux(a, ++i, 0);
		return a[i][j] + sumarSinAux(a, i, ++j);
	}
	
	
	
	public static void main(String[] args) {
		int[][] a = {
				{2,3,3},
				{1,2,3},
				{1,2,3}
		};
		System.out.println(sumarSinAux(a));
	}
}
