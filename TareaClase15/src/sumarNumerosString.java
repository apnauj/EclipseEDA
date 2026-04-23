
public class sumarNumerosString {
	
	public static int sumar(String[] a) {
		if (a.length == 0) return 0;
		return sumar(a,0);
	}
	
	public static int sumar(String[] a, int i) {
		if(i == a.length) return 0;
		try {
			int n = Integer.parseInt(a[i]);
			return sumar(a, ++i) + n;
		} catch (Exception e) {
			return sumar(a, ++i);
		}
	}
	
	
	public static void main(String[] args) {
		String[] a = {"casa", "123","2","dos"};
		System.out.println(sumar(a));
	}
}
