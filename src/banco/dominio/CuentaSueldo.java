package banco.dominio;

public class CuentaSueldo extends Cuenta{
	
	public CuentaSueldo(String nombre, Double saldo) {
		super(nombre, saldo);
	}
	
	@Override
	public boolean extraer(Double dineroAExtraer) {
		if(this.saldo >= dineroAExtraer) {
			this.saldo -= dineroAExtraer;
			return true;
		}
		return false;
	}
}
