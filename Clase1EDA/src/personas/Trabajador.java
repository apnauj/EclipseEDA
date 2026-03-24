package personas;

public class Trabajador {
	private String nombre;
	private float salariobasico;
	private float dias;
	public final static float DIAS = 24;
	
	public Trabajador(String nombre, float salariobasico) {
		this.nombre = nombre;
		this.salariobasico = salariobasico;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public float getSalario() {
		return salariobasico;
	}
	
	public float getDias() {
		return dias;
	}
	
	public void setSalarioBasico(float salariobasico) {
		this.salariobasico = salariobasico;
	}
	
	public void setDias(float dias) {
		this.dias = dias;
	}
	
	public float salario() {
		float salario = salariobasico * dias / DIAS;
		return salario;
	}

	public static void main(String[] args) {
		Trabajador t = new Trabajador(	"Pedro",1500000);
		Trabajador t2 = new Trabajador("Ana",5000000);
		Trabajador t3 = new Trabajador("Juan Perez",4000000);
		
		t.setDias(24);
		t2.setDias(20);
		t3.setDias(30);
		
		System.out.println(t.getNombre()+ ": " + t.salario());
		System.out.println(t2.getNombre()+ ": " + t2.salario());
		System.out.println(t3.getNombre()+ ": " + t3.salario());
		System.out.println(Trabajador.DIAS);
		
	}

}
