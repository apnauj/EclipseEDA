import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

public class Triangulo implements FiguraGeometrica{
	private double lado1;
	private double lado2;
	private double lado3;
	
	public Triangulo(double lado1, double lado2, double lado3) throws ETrianguloInvalido, ELongitudInvalida {
		if(lado1 <= 0 || lado2 <= 0 || lado3 <= 0) {
			throw new ELongitudInvalida();
		}
		if(!((lado1 + lado2) > lado3 && (lado1 + lado3) > lado2 && (lado2 +lado3)>lado1)) {
			throw new ETrianguloInvalido();
			
		}
		
		this.lado1 = lado1;
		this.lado2 = lado2;
		this.lado3 = lado3;
		
	}
	
	public char clasificar() {
//		if(lado1 == lado2) {
//			if(lado2 == lado3) {
//				return 'q';
//			} else {
//				return 'i';
//			}
//		} else {
//			if(lado1 == lado3) {
//				return 'i';
//			} else {
//				return 'e';
//			}
//		} 
		return (lado1==lado2 && lado2==lado3) ? 'q' : (lado1 == lado2 || lado1 == lado3 || lado3 == lado2) ? 'i' : 'e';
	}
	
	@Override
	public double perimetro() {
		return lado1 + lado2 + lado3;
	}
	
	@Override
	public double area() {
		double s = perimetro()/2;
		double a = (float) Math.sqrt(s*(s-lado1)*(s-lado2)*(s-lado3));
		return a;
	}
	
	public double getLado1() {
		return lado1;
	}
	
	public double getLado2() {
		return lado2;
	}
	
	public double getLado3() {
		return lado3;
	}
	
	@Override
	public String toString() {
		String tipo = "";
		switch(this.clasificar()) {
		case 'i'-> tipo = "isoceles";
		case 'e'-> tipo = "escaleno";
		case 'q'-> tipo = "equilatero";
		}
		return String.format("%s de area: %.2f y perimetro: %.2f", tipo, area(), perimetro());


	}
	
	
	public static void main(String [] Args) {
		Triangulo[] triangulos = new Triangulo[0];
		int a;
		int b;
		int c;
		while (triangulos.length < 10) {
			a = (int)(Math.random() * 10) - 5;
			b = (int)(Math.random() * 10) - 5;
			c = (int)(Math.random() * 10) - 5;
			try {
				Triangulo t = new Triangulo(a, b, c);
				triangulos = Arrays.copyOf(triangulos,triangulos.length + 1);
				triangulos[triangulos.length - 1] = t;
			} catch (ETrianguloInvalido | ELongitudInvalida e) {
				System.err.println(e.getMessage());
			}
		}
		for (int i = 0; i < triangulos.length; i++ ) {
			System.out.println("El triangulo numero " + (i+1) + " es: " + triangulos[i]);
		}
	}
}
