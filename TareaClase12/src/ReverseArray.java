
public class ReverseArray {
	
	//Hecho por mi
	
	public static int[] reverseArreglo(int[] a) {
		if (a == null || a.length <= 1) return a;
		return reverseArreglo(a,0);
	}
	
	public static int[] reverseArreglo(int[] a, int i) {
		if(i == (a.length - 1)/2) return a;
		int aux = a[a.length - 1 - i];
		a[a.length - 1 - i] = a[i];
		a[i] = aux;
		return reverseArreglo(a,++i);
	}
	
	//Mejorado por IA
	
	public static int[] reverseArregloMejorado(int[] a) {
		if (a == null || a.length <= 1) return a;
		return reverseArregloMejorado(a,0,a.length-1);
	}
	
	public static int[] reverseArregloMejorado(int[] a, int i, int j) {
		if(i>=j) return a;
		int aux = a[i];
	    a[i] = a[j];
	    a[j] = aux;
		return reverseArregloMejorado(a,i+1,j-1);
	}

	public static void main(String[] args) {
		int[] arreglo = {1,2,3,4};
		reverseArregloMejorado(arreglo);
		for (int i : arreglo) {
			System.out.println(i);
		}
		
	}

}
