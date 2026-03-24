import java.util.Arrays;
import java.util.Random;

public class Produccion {
	private int[][] prodDiariaProducto;
	private String[] productos;
	public static final String[] diasSemana = {"LUNES","MARTES","MIERCOLES","JUEVES","VIERNES"};
	
	public int[][] getProdDiariaProducto() {
		return prodDiariaProducto;
	}

	public void setProdDiariaProducto(int[][] prodDiariaProducto) {
		this.prodDiariaProducto = prodDiariaProducto;
	}

	public String[] getProductos() {
		return productos;
	}

	public void setProductos(String[] productos) {
		this.productos = productos;
	}

	//Método para calcular la prod total
	public Produccion(String[] productos) {
		this.productos = productos;
		prodDiariaProducto = new int[10][5];
	}
	
	public void llenarprodRandom() {
		Random r = new Random(5);
		for(int i = 0; i < prodDiariaProducto.length; i++) {
			for(int j = 0; j < prodDiariaProducto[i].length; j++) {
				prodDiariaProducto[i][j] = r.nextInt(1000);
			}
		}
	}
	
	public int prodTotal() {
		int a = 0;
//		for(int i = 0; i < prodDiariaProducto.length; i++) {
//			for(int j = 0; j < prodDiariaProducto[i].length; j++) {
//				a += prodDiariaProducto[i][j];
//			}
//		}
		
		for(int[] i : prodDiariaProducto) {
			for(int j : i) {
				a+=j;
			}
		}
		return a;
	}
	
	public int buscarIndexNombreProducto(String s) {
		int i = 0;
		while( i < productos.length && !(productos[i].equalsIgnoreCase(s))) i++;
		return (i < productos.length) ? i : -1;
	}
	
	public int buscarIndiceDiaSemana(String s) {
		s = s.toUpperCase();
;		switch(s) {
		case "LUNES": return 0;
		case "MARTES": return 1;
		case "MIERCOLES": return 2;
		case "JUEVES": return 3; 
		case "VIERNES": return 4;
		default: return -1;
		}
	}
	
	public int prodTotalDia(String s) {
		int i = buscarIndiceDiaSemana(s);
		if(i == -1) {
			System.out.println("El día de la semana ingresado no existe");
			return i;
		} else {
			int a = 0;
			for(int[] j : prodDiariaProducto) {
				a += j[i];
			}
			return a;
		}
	}
	
	//Encontrar producción por nombre de producto
	
	public int prodPorProducto(String s){
		int i = buscarIndexNombreProducto(s);
		if(i == -1) {
			System.out.println("El producto no existe");
			return i;
		} else {
			int a = 0;
			for(int j : prodDiariaProducto[i]) {
				a+=j;
			}
			return a;
		}
	}
	
	//Encontrar producción por dia de un producto
	
	public int prodDiaPorProducto(String s, int dia){
			int i = buscarIndexNombreProducto(s);
			if(i == -1) {
				System.out.println("El producto no existe");
				return i;
			}else if(dia >5 || dia < 0) {
				System.out.println("Día de la semana inválido");
				return i;
			} else {
				return prodDiariaProducto[i][dia-1];
			}
				
	}
	
	//Añadir produccion de un producto determinado
	
	public void addProduction(String s, int[] production) {
		int i = buscarIndexNombreProducto(s);
		if(i == -1){ 
			addProducto(s);
			prodDiariaProducto[prodDiariaProducto.length -1] = production; 
		} else {
			prodDiariaProducto[prodDiariaProducto.length -1] = production; 
		}
	}
	
	//Añadir producto
	
	public void addProducto(String s) {
		productos = Arrays.copyOf(productos, productos.length + 1);
		prodDiariaProducto = Arrays.copyOf(prodDiariaProducto, prodDiariaProducto.length + 1);
		productos[productos.length - 1] = s;
	}	
	
	
	
	@Override
	public String toString() {
		String resultado = "REPORTE DE PRODUCCION:\n";
	    
	    for (int i = 0; i < prodDiariaProducto.length; i++) {
	        resultado += "Produccion " + productos[i] +": " + Arrays.toString(prodDiariaProducto[i]) + "\n";
	    }
	    
	    return resultado;
	}
	
	public static void main(String[] Args) {
		String[] a = {"Mango","Papaya","Mora","Papa","Kiwi","Aguacate","Fresa","Piña","Melon","Sandia"};
		Produccion p = new Produccion(a);
		p.llenarprodRandom();
		System.out.println(p.toString());
		System.out.println("La produccion total fue de " + p.prodTotal() +" productos");
		System.out.println(p.buscarIndexNombreProducto("kiwi"));
		System.out.println(p.buscarIndiceDiaSemana("lunes"));
		System.out.println(p.prodTotalDia("lunes"));
		
		// Tarea 
		
		int[] manzanaProd = {12,12,12,12,12};
		p.addProducto("Manzana");
		p.addProduction("Manzana", manzanaProd);
		System.out.println(p.toString());
		System.out.println(p.prodPorProducto("Manzana"));
		System.out.println(p.prodDiaPorProducto("Manzana",1));
	}
}






