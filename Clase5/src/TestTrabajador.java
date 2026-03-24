public class TestTrabajador {
	public static void main(String[] Args) {
		Trabajador t = new Trabajador("Angel", 3000000, 20);
		Trabajador t1 = new Trabajador("Sara", 3000000, 20);
		Trabajador t2 = new Trabajador("Samuel", 3000000, 20);
		Trabajador e = new EmpLimpieza("Angela", 3000000, 20, 20, 15);
		
		Trabajador[] trabajadores = new Trabajador[4];
		trabajadores[0] = t;
		trabajadores[1] = e;
		trabajadores[2] = t1;
		trabajadores[3] = t2;
		
		((EmpLimpieza)trabajadores[1]).getNorma();
		
		for (int i = 0; i < trabajadores.length; i++) {
			if (trabajadores[i] instanceof EmpLimpieza) {
				System.out.println("Empleado de Servicio: \n" + ((EmpLimpieza)trabajadores[i]).getNorma());
			} else {
				System.out.println("Trabajador: \n" + trabajadores[i].getNombre()+"\t"+trabajadores[i].salario());
			}
		}
	}
}
