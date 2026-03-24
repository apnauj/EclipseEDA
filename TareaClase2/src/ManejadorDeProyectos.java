import java.util.Arrays;

public class ManejadorDeProyectos {
	
	private double [][] proyectos;
	private final int CANTIDAD_PROYECTOS = 20;
	private final int MESES = 12;
	
	public ManejadorDeProyectos() {
		this.proyectos = new double[CANTIDAD_PROYECTOS][MESES];
	}
	
	public double[][] getProyectos() {
		return proyectos;
	}
	
	public void anadirHoras(int proyecto, int mes, double horas) {
		int p = proyecto -1;
		int m = mes -1;
		
		if(p < 0 || p >= CANTIDAD_PROYECTOS) {
			System.out.println("El proyecto número: "+ proyecto + " no existe, solo hay proyectos del 1 al 20");
		} else if(m < 0 || m >= MESES) {
			System.out.println("El mes número: "+ mes + " no existe, solo hay meses del 1 al 12");
		} else if (horas < 0) {
			System.out.println("No es posible trabajar un número negativo de horas");
		} else {
			proyectos[p][m] = horas;
		}
	}
	
	public double horasPorMes(int mes) {
		int m = mes -1;
		double ans = 0;
		if(m < 0 || m >= MESES) {
			System.out.println("El mes número: "+ mes + " no existe, solo hay meses del 1 al 12");
		} else {
			for(int i = 0; i < CANTIDAD_PROYECTOS; i++) {
				ans+=proyectos[i][m];
			}
		}
		return Math.round(ans*100.0)/100.0;
	}
	
	public double horasPorProyecto(int proyecto) {
		double ans = 0;
		int p = proyecto - 1;
		if(p < 0 || p >= CANTIDAD_PROYECTOS) {
			System.out.println("El proyecto número: "+ proyecto + " no existe, solo hay proyectos del 1 al 20");
		} else {
			for(int i = 0; i < MESES; i++) {
				ans+=proyectos[p][i];
			}
		}
		return Math.round(ans*100.0)/100.0;
	}
	
	public double horasTotales() {
		double ans = 0;
		for(int i = 1; i <= CANTIDAD_PROYECTOS;i++) {
			ans += horasPorProyecto(i);
		}
		return Math.round(ans*100.0)/100.0;
	}
	

	@Override
	public String toString() {
	    String resultado = "REPORTE DE PROYECTOS:\n";
	    
	    for (int i = 0; i < proyectos.length; i++) {
	        resultado += "Proyecto " + (i + 1) + ": " + Arrays.toString(proyectos[i]) + "\n";
	    }
	    
	    return resultado;
	}

	public static void main(String[] args) {
		ManejadorDeProyectos m = new ManejadorDeProyectos();
		for(int i = 0; i < m.getProyectos().length; i++) {
			for(int j = 0; j < m.getProyectos()[i].length; j++) {
				m.anadirHoras(i+1, j+1, Math.round(Math.random() * 1000.0) / 100.0);
			}
		}
		System.out.println(m);
		System.out.println("Horas totales del mes 1: " + m.horasPorMes(1));
		System.out.println("Horas del proyecto 1: " + m.horasPorProyecto(1));
		System.out.println("Horas totales: " + m.horasTotales());
	}
}
