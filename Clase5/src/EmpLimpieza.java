public class EmpLimpieza extends Trabajador{
	private float norma;
	private float cump;
	
	public EmpLimpieza(String nombre, float sb, float dt, float norma, float cump) {
	super(nombre, sb, dt);
	this.norma = norma;
	this.cump = cump;
	}
	
	@Override
	public float salario() {
		float salarioT = super.salario();
		return (float) (salarioT + salarioT*0.1*cump/norma);
	}

	public float getNorma() {
		return norma;
	}

	public void setNorma(float norma) {
		this.norma = norma;
	}

	public float getCump() {
		return cump;
	}

	public void setCump(float cump) {
		this.cump = cump;
	}	
	
	
}
