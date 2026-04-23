import java.util.Arrays;

public class Merge {
	
	public static Comparable[] merge(Comparable[] a, Comparable[] b) {
		Comparable[] ans = new Comparable[a.length + b.length];
		int i = 0;
		int j = 0;
		while(i < a.length && j < b.length) {
			ans[i + j] = (a[i].compareTo(b[j]) <= 0) ? a[i++] : b[j++];
		}
		for (int k = i; k < a.length; k++) {
			ans[k + j] = a[k];
		}
		for (int k = j; k < b.length; k++) {
			ans[k + i] = b[k];
		}
		return ans;
	}
	
	public static Comparable[] mergeSort(Comparable[] a) {
		if(a.length == 0) return a;
		if(a.length == 1) return a;
		int mitad = (a.length)/2;
		return merge(mergeSort(Arrays.copyOfRange(a, 0, mitad)), mergeSort(Arrays.copyOfRange(a, mitad, a.length)));
	}
	
	public static Comparable[] mergeSortOptimo(Comparable[] a, int i, int j) {
		if(j <= i) return new Comparable[] {a[i]};
		int mitad = (i + j)/2;
		Comparable[] l = mergeSortOptimo(a, i, mitad);
		Comparable[] r = mergeSortOptimo(a, mitad + 1, j);
		return merge(l, r);
	}
	
	public static void main(String[] args) {
		Integer[] a1 = {2,1,1,3,4,5,6};
		Integer[] a2 = {7,8,9,10};
		
		for (Comparable num : mergeSortOptimo(a1, 0, a1.length - 1)) {
			System.out.print(num + " ");
		}
	}
}
