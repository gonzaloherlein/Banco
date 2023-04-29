package banco.dominio;

public class CuentaCorriente extends Cuenta{
	private Double descubiertoInicial = 150.0;
	private Double descubiertoActual;
	private Double comision;
	
	public CuentaCorriente(String nombre,Double saldo) {
		super(nombre, saldo);
		this.comision = 0.05;
		this.descubiertoActual = 0.0;
	}
	
	@Override
	public boolean extraer(Double dinero) {
		Double disponible = this.saldo + descubiertoInicial;
		if(dinero <= disponible) {
			if(dinero <= saldo) {
				saldo -= dinero;
			}else {
				descubiertoActual = dinero - this.saldo;
				Double deuda = descubiertoActual * comision;
				this.saldo = 0.0;
				this.saldo -= descubiertoActual + deuda;
			}
			return true;
		}
		return false;
	}
	
	
}
