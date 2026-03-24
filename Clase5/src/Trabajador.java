
public class Trabajador {
	protected String nombre;
	protected float sb;
	protected float dt;
	
	public Trabajador(String nombre, float sb, float dt ) {
		this.nombre = nombre;
		this.sb = sb;
		this.dt = dt;
	}
	
	public float salario() {
		return sb*dt/24;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getSb() {
		return sb;
	}

	public void setSb(float sb) {
		this.sb = sb;
	}

	public float getDt() {
		return dt;
	}

	public void setDt(float dt) {
		this.dt = dt;
	}
	
	
	
}
