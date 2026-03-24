
public class Estudiante {
	private String nombre;
	private final float nota1;
	private final float nota2;
	private final float nota3;
	
	public Estudiante(String nombre,float nota1, float nota2, float nota3) throws IllegalArgumentException {
		this.nombre = nombre;
		if(nota1 < 0.0 || nota2 < 0.0 || nota3 < 0.0 || nota1 > 5.0 || nota2 > 5.0 || nota3 > 5.0) {
			throw new IllegalArgumentException("La calificación debe estar entre 0.0 y 5.0");
		}
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public float getNota1() {
		return nota1;
	}
	
	public float getNota2() {
		return nota2;
	}
	
	public float getNota3() {
		return nota3;
	}
	
	public float promedio() {
		return (nota1+nota2+nota3)/3;
	}
	
	public char calificar() throws UndefinedCalificationException {
		int pt = (int)promedio();
		char ans = ' ';
		
		switch(pt) {
		case 4, 5:
			ans = 'B';
			break;
			
		case 3:
			ans = 'R';
			break;
			
		case 2:
			ans = 'M';
			break;
			
		default:
			throw new UndefinedCalificationException("La calificacion para la nota: "+ pt +" no se definio.");
		}
		
//		if(pt == 4 || pt == 5) {
//			ans = 'B';
//		} else if(pt == 3) {
//			ans = 'R';
//		} else if(pt == 2) {
//			ans = 'M';
//		} else {
//			throw new UndefinedCalificationException("La calificacion para la nota: "+ pt +" no se definio.");
//		}
		return ans;
	}

	public static void main(String[] args) throws IllegalArgumentException, UndefinedCalificationException{
		try {
			Estudiante e = new Estudiante("Sara",4F,4F,4F);
			System.out.println("La calificacion de " +e.getNombre() + " es: "+ e.calificar());
		} catch (IllegalArgumentException | UndefinedCalificationException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
