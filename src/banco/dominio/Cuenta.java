package banco.dominio;

public class Cuenta {
	private String nombre;
	protected Double saldo;
 
	
	public Cuenta() {
		
	}
	
	public Cuenta(String nombre,Double saldo) {
		this.nombre = nombre;
		this.saldo = saldo;
	}
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getDinero() {
		return saldo;
	}

	public void setDinero(Double dinero) {
		this.saldo = saldo;
	}

	public boolean extraer(Double dinero) {
		this.saldo -= dinero;
		return true;
	}
	
	public Double depositar(Double dinero) {
		
		return this.saldo += dinero;
	}
	
}
