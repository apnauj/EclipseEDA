
public class Rectangulo {
	private double lado1;
	private double lado2;
	private double lado3;
	private double lado4;
	
	public Rectangulo(double lado1, double lado2) throws ELongitudInvalida{
		if(lado1 <= 0 || lado2 <= 0) {
			throw new ELongitudInvalida();
		}
		
		this.lado1 = lado1;
		this.lado2 = lado2;
		this.lado3 = lado1;
		this.lado4 = lado2;	
		
	}
	
	public static void main(String [] Args) {
		try {
			Rectangulo r = new Rectangulo(8,9);
		} catch (ELongitudInvalida e) {
			System.out.println(e.getMessage());
		}
	}
}
