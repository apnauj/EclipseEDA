import java.util.Random;
public class QuickSortRandomPivot {

	public static void quick(Comparable[] a, int inicio, int fin) {
	    if (inicio >= fin) return;

	    Random rand = new Random();
	    int p = inicio + rand.nextInt(fin - inicio + 1);
	    Comparable pivote = a[p];

	    int i = inicio - 1;
	    int j = fin;
	    Comparable temp;

	    while (i < j) {
	        while (a[++i].compareTo(pivote) < 0);

	        while (a[--j].compareTo(pivote) > 0);

	        if (i < j) {
	            temp = a[i];
	            a[i] = a[j];
	            a[j] = temp;
	        }
	    }

	    if (inicio < j) quick(a, inicio, j);
	    if (j + 1 < fin) quick(a, j + 1, fin);
	    
	}
	
	public static void printLista(Comparable[] a) {
		if(a != null) {
			for (Comparable comparable : a) {
				System.out.print(comparable + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Integer[] a = {4,8,9,2,3,4,5,12};
		quick(a, 0, a.length - 1);
		printLista(a);
	}
}
