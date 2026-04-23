public class SearchClosest {
	private static int search(int[] v, int objetivo) {
		int k = 1;
		int minDistance = Math.abs(v[k] - objetivo);
		int minIndex = 0;
		while(k < (v.length - 1) && v[k] != objetivo) {
			if(Math.abs(v[k] - objetivo) < minDistance) {
				minIndex = k;
				minDistance = Math.abs(v[k] - objetivo);
			} else if(Math.abs(v[k] - objetivo) == minDistance) {
				minIndex = (v[minIndex] < v[k]) ? minIndex : k;
			}
			k++;
		}
		return (k == (v.length - 1)) ? minIndex : k;
	}
	
	public static void main(String[] args) {
		int[] test = {1,2,3,5,7};
		System.out.println(search(test, 5));
	}
}
