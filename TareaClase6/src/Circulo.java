class Circulo implements FiguraGeometrica{
	private double radio;
	
	public Circulo(double radio) throws ELongitudInvalida{
		if(radio <= 0) {
			throw new ELongitudInvalida();
		}
		
		this.radio = radio;
	}
	
	public double getRadio() {
		return radio;
	}
	
	@Override
	public double area() {
		return (Math.pow(radio, 2) * Math.PI);
	}
	
	@Override 
	public double perimetro() {
		return (Math.PI*2*radio);
	}
	
	//Aquí se está haciendo una anulación pues se sobreescribe completamente el método
	@Override 
	public String toString() {
		return "Circulo de radio: " + radio;
	}
	
	public static void main(String [] Args) {
		try {
			Circulo c = new Circulo(2);
			System.out.println(c.toString());
		} catch (ELongitudInvalida e) {
			System.out.println(e.getMessage());
		}
		
	}
}
