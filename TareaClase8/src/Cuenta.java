import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
	
	

	public float getSaldo() {
		return saldo;
	}



	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}



	public float getNumero() {
		return numero;
	}



	public void setNumero(float numero) {
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
	
	public void escribirFicheroCuenta(String dir) throws IOException {
		FileOutputStream f = new FileOutputStream(dir);
		ObjectOutputStream b = new ObjectOutputStream(f);
		b.writeObject((Cuenta)this);
		b.close();
		f.close();
	}
	
	public static Cuenta leerFicheroCuenta(String dir) throws IOException, ClassNotFoundException {
	    FileInputStream f = new FileInputStream(dir);
	    ObjectInputStream b = new ObjectInputStream(f);
	    Cuenta cuenta = (Cuenta) b.readObject();
	    f.close();
	    b.close();
	    return cuenta;
	}
	
}
