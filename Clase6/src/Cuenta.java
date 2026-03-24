import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.Serializable;

public class Cuenta implements Serializable {
	
	private static final long serialVersionUID = -1799753742985549207L;
	private float saldo;
	private float numero;
	
	public Cuenta(float saldo, float numero) {
		super();
		this.saldo = saldo;
		this.numero = numero;
	}

	public void depositar(float v) throws EValorNegativo{
		if(v>0) {
			saldo+=v;	
		}
		else {
			throw new EValorNegativo("El saldo a depositar debe ser mayor que 0");
		}
	}
	
	public void extraer(float v) throws EValorNegativo, EValorMayorSaldo {
		if(v>0) {
			if(v<=saldo) {
				saldo-=v;
			}
			else {
				throw new EValorMayorSaldo(saldo,v);
			}
		}else {
			throw new EValorNegativo("El saldo a extraer debe ser mayor que 0");
		}
	}
	
	public void copiarFicheroCuenta(String dir) throws IOException {
		FileOutputStream f = new FileOutputStream(dir);
		ObjectOutputStream b = new ObjectOutputStream(f);
		b.writeObject((Cuenta)this);
		b.close();
		f.close();
	}
	
	public static Cuenta leerFicheroCuenta(String dir) throws IOException, ClassNotFoundException {
	    try (FileInputStream f = new FileInputStream(dir);
	         ObjectInputStream b = new ObjectInputStream(f)) {
	        
	        return (Cuenta) b.readObject();
	    }
	}
	
	public static void main(String [] Args) throws EValorNegativo, EValorMayorSaldo {
		Cuenta[] cuentas = new Cuenta[4];
//		Cuenta cuenta = new Cuenta(1,100);
//		Cuenta cuenta2 = new Cuenta(2,100);
//		Cuenta cuenta3 = new Cuenta(3,100);
//		Cuenta cuenta4 = new Cuenta(4,100);
//		cuentas[0] = cuenta;
//		cuentas[1] = cuenta2;
//		cuentas[2] = cuenta3;
//		cuentas[3] = cuenta4;	
//		try {
//			int i = 1;
//			for(Cuenta c : cuentas) {
//				c.copiarFicheroCuenta("/home/juanpa/Documents/University/S3.2026/Estructuras/EclipseWorkspace/Clase6/ficheros/ficheroPruebaObjeto.cuenta"+i);
//				i++;
//			}
//			
//		} catch (IOException e) {
//			System.out.println("Problema con el fichero");
//		}
		
		try {
			for(int i = 0; i < 4; i++) {
				cuentas[i] = Cuenta.leerFicheroCuenta("/home/juanpa/Documents/University/S3.2026/Estructuras/EclipseWorkspace/Clase6/ficheros/ficheroPruebaObjeto.cuenta"+(i+1));
			}
			
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Problema con el fichero");
		}
		
		for(Cuenta c: cuentas) {
			System.out.println(c.saldo);
		}
		
		
	}
}
