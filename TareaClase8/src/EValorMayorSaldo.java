
public class EValorMayorSaldo extends Exception{
	public EValorMayorSaldo(float saldoActual, float monto) {
		super("El valor solicitado excede al saldo. Su saldo es: " + (saldoActual) + " y el monto de retiro solicitado es de: " + (monto));
	}
}
