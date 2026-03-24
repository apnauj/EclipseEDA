package Figuras;

public class Triangulo {
	private float lado1;
	private float lado2;
	private float lado3;
	
	public Triangulo(float lado1, float lado2, float lado3) throws TrianguloInvalidoException, IllegalArgumentException {
		if(lado1 <= 0 || lado2 <= 0 || lado3 <= 0) {
			throw new IllegalArgumentException("El triangulo no puede tener lados negativos ni iguales a 0");
		}
		if((lado1 + lado2) > lado3 && (lado1 + lado3) > lado2 && (lado2 +lado3)>lado1) {
			this.lado1 = lado1;
			this.lado2 = lado2;
			this.lado3 = lado3;
		} else {
			throw new TrianguloInvalidoException("El triangulo que intenta crear no es posible matemáticamente!");
		}
		
	}
	
	public char clasificar() {
		if(lado1 == lado2) {
			if(lado2 == lado3) {
				return 'q';
			} else {
				return 'i';
			}
		} else {
			if(lado1 == lado3) {
				return 'i';
			} else {
				return 'e';
			}
		} 
		//return (lado1==lado2 && lado2==lado3) ? 'q' : (lado1 == lado2 || lado1 == lado3 || lado3 == lado2) ? 'i' : 'e';
	}
	
	public float perimetro() {
		return lado1 + lado2 + lado3;
	}
	
	public float area() {
		float s = perimetro()/2;
		float a = (float) Math.sqrt(s*(s-lado1)*(s-lado2)*(s-lado3));
		return a;
	}
	
	public float getLado1() {
		return lado1;
	}
	
	public float getLado2() {
		return lado2;
	}
	
	public float getLado3() {
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
		return "El triangulo es " + tipo + " de area: "+this.area()+" y perimetro: "+this.perimetro();
	}
	
	
	public static void main(String[] args) throws TrianguloInvalidoException {
		try {
			Triangulo t = new Triangulo(0,3,5);
			System.out.println(t);
			System.out.println();
		} catch (TrianguloInvalidoException | IllegalArgumentException e ) {
			System.out.println(e.getMessage());
		}
		
	}
}
