
public class SumaArreglo {
	
	public static boolean existe(int[] a, int obj, int i, int sum) {
		if(a.length == 0) return false;
		if(sum == obj) return true;
		if(i == a.length || sum > obj) return false;
		if(existe(a, obj, i + 1, sum + a[i])) return true;
		if(existe(a, obj, i + 1, sum)) return true;
		return false;
	}
	
	public static void main(String[] args) {
		int[] b = {2,5,6,7,8};
		System.out.println(existe(b, 13, 0, 0));
	}
}
