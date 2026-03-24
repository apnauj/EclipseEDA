
public class Estudiante {
	private String nombre;
	private static int contadorStatic; //Recordar: las variables de tipo numerico se inician en 0
	private int id;
	
	Estudiante(String nombre){
		this.nombre = nombre;
		contadorStatic++;
		id = contadorStatic;
	}
	
	
	
	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public static int getContadorStatic() {
		return contadorStatic;
	}



	public static void setContadorStatic(int contadorStatic) {
		Estudiante.contadorStatic = contadorStatic;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	@Override
	public String toString() {
		return "Estudiante (nombre="+nombre +", id:"+id +", contador: "+contadorStatic+")";
	}
	
	public static void main(String[] Args) {
		Estudiante e1 = new Estudiante("Pedro Perez");
		System.out.println(e1);
		Estudiante e2 = new Estudiante("Juana Lopez");
		System.out.println(e2);
		e2.setContadorStatic(5);
		System.out.println(e2);
		System.out.println(e1);
	}
}
