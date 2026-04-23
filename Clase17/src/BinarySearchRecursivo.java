public class BinarySearchRecursivo {
	
	public static int search(Comparable[] a, Comparable objetivo, int i, int j) {
		int medio;
		if(i >= j) return a[i].compareTo(objetivo) == 0 ? i : -1;
		else {
			medio = (i+j)/2;
			if(a[medio].compareTo(objetivo) == 0) return medio;
			else {
				if (a[medio].compareTo(objetivo) > 0) return search(a, objetivo, i, medio - 1);
				else return search(a, objetivo, medio + 1, j);
			}
		}
	}
	
	public static void main(String[] args) {
		Integer[] a = {1};
		System.out.println(search(a, 5, 0, a.length - 1));
	}
}
