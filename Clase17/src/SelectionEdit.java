
public class SelectionEdit {
	public static void selection(Comparable[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int im = i;
			if(i % 2 == 0) {
				for (int j = i + 2; j < a.length; j+=2) {
					if(a[j].compareTo(a[im]) < 0) {
						im = j;
					}
				}
			} else {
				for (int j = i + 2; j < a.length; j+=2) {
					if(a[j].compareTo(a[im]) > 0) {
						im = j;
					}
				}
			}
			Comparable temp = a[i];
			a[i] = a[im];
			a[im] = temp;
		}
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
		printLista(a);
		selection(a);
		printLista(a);
	}
}
