import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private Cuenta[] cuentas;
	
	
	Main(){
		this.cuentas = new Cuenta[0];
	}
	
	public void addCuenta(float saldo, float numero) {
		Cuenta cuenta = new Cuenta(saldo, numero);
		cuentas = Arrays.copyOf(cuentas, cuentas.length + 1);
		cuentas[cuentas.length - 1] = cuenta;
		System.out.println("Se añadió la cuenta al arreglo de cuentas");
	}
	
	public void guardarCuentas() throws IOException{
		for(int i = 0; i < cuentas.length; i++) {
			Cuenta c = cuentas[i];
			c.escribirFicheroCuenta("/home/juanpa/Documents/University/S3.2026/Estructuras/EclipseWorkspace/TareaClase8/ficheros/cuenta"+(i+1)+".cuentaFile");
		}	
		
	}
	
	public void cargarCuentas() throws IOException, ClassNotFoundException{
		File dir = new File("ficheros/");
		File[] ficheros = dir.listFiles();
		
		for(File f: ficheros) {
			if(f.isFile() && f.getName().endsWith(".cuentaFile")) {
				Cuenta cuenta =  Cuenta.leerFicheroCuenta(f.getPath());
				cuentas = Arrays.copyOf(cuentas, cuentas.length + 1);
				cuentas[cuentas.length - 1] = cuenta; 
			}
		}
	}
	
	public static void main(String[] Args) {
		Main main = new Main();
		
		//Cargar las cuentas
		try {
			main.cargarCuentas();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		if(main.cuentas.length != 0) {
			System.out.println("Las cuentas actuales son:");
			for(int i=0; i < main.cuentas.length; i++) {
				System.out.println("La cuenta " + (i+1) + " tiene saldo: " + main.cuentas[i].getSaldo());
			}
		} else {
			System.out.println("En este momento no hay cuentas cargadas en el sistema");
		}
		
		
		//Añadir cuentas dinámicamente
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
			String option = sc.nextLine();
			switch (option) {
			case "add":
				float saldo = sc.nextFloat();
				float numero = sc.nextFloat();
				sc.nextLine();
				main.addCuenta(saldo, numero);
				System.out.println("Añadida la cuenta de saldo: " + saldo + " y numero: " +  numero);
				break;
			case "salir":
				System.out.println("Saliendo");
				flag = false;
				break;
			default:
				System.out.println("Opcion invalida re intente");
				break;
			}
		}
		
		//Guardar las cuentas
		System.out.println("Guardando información de cuentas....");
		try {
			main.guardarCuentas();
		} catch (IOException e){
			System.out.println(e.getMessage());
		}
		
		sc.close();
	}
}
