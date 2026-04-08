
public class ReverseString {
	
	public static String reverseString(String a) {
		if (a == null || a.length() <= 1) return a;
		StringBuilder ab  = new StringBuilder(a);
		return reverseString(ab,0,ab.length()-1);
	}
	
	public static String reverseString(StringBuilder ab, int i, int j) {
		if(i>=j) return ab.toString();
		char aux = ab.charAt(i);
		ab.setCharAt(i, ab.charAt(j));
	    ab.setCharAt(j, aux);
		return reverseString(ab,i+1,j-1);
	}

	public static void main(String[] args) {
		String a = "Aguacate maduro";
		System.out.println(a);
		System.out.println(reverseString(a));
	}
}
