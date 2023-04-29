package banco.dominio;

public class CajaDeAhorros extends Cuenta{
	
	private Integer cantidadDeExtracciones = 0;
	
	public CajaDeAhorros(String nombre,Double saldo) {
		super(nombre, saldo);
	}
	
	@Override
	public boolean extraer(Double dinero) {
		boolean sePuedeExtraer = false;
		if(cantidadDeExtracciones < 5) {
			 this.saldo -= dinero;
			 sePuedeExtraer = true;
		}else{
			this.saldo -= (dinero + 6.0);
		}
		this.cantidadDeExtracciones++;
		return sePuedeExtraer;
	}

	public Integer getCantidadDeExtracciones() {
		return cantidadDeExtracciones;
	}

	public void setCantidadDeExtracciones(Integer cantidadDeExtracciones) {
		this.cantidadDeExtracciones = cantidadDeExtracciones;
	}
	
	
}
