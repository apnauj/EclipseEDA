
public class DivisibleBy3 {
	
	public static boolean divisible(int n) {
        n = Math.abs(n);
        if (n < 10) return (n == 0 || n == 3 || n == 6 || n == 9);
        

        return divisible(sumarDigitos(n));
    }

    private static int sumarDigitos(int n) {
        if (n == 0) return 0;
        return (n % 10) + sumarDigitos(n / 10);
    }
	
	public static void main(String[] args) {
		System.out.println(divisible(459));
	}
}
