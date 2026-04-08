
public class IsPalindrome {
	
	public static boolean isPalindrome(String s) {
		if (s == null || s.length() < 0) return false;
		if(s.length() == 0 || s.length() == 1) return true;
		s = s.toLowerCase().replace(" ", "");
		return isPalindrome(s,0,s.length() - 1);
	}
	
	public static boolean isPalindrome(String s, int i, int j) {
		if(i >= j) return true;
		if(s.charAt(i) == s.charAt(j)) return isPalindrome(s,++i,--j);
		return false;
	}

	public static void main(String[] args) {
		String palindromoString = "aa b aa";
		System.out.println(isPalindrome(palindromoString));
	}

}
