
public class SearchFrom {
	private static int search(int i, int obj, int[] v) {
		while(i < v.length && v[i] != obj) {
			i++; 
		}
		return (i == v.length) ? -1 : i;
	}
}
