package banco.test;

import static org.junit.Assert.*;

import org.junit.Test;

import banco.dominio.Banco;
import banco.dominio.CajaDeAhorros;
import banco.dominio.Cliente;
import banco.dominio.Cuenta;
import banco.dominio.CuentaCorriente;
import banco.dominio.CuentaSueldo;

public class BancoTest {

	@Test
	public void queSePuedaCrearUnBanco() {
		Banco banco = new Banco();
		assertNotNull(banco);
	}

	@Test
	public void queSePuedaCrearUnCliente() {
		Cliente cliente = new Cliente();
		assertNotNull(cliente);
	}
	
	@Test
	public void queSePuedaCrearUnaCuenta() {
		Cuenta cuenta = new Cuenta();
		assertNotNull(cuenta);
	}
	
	
	@Test
	public void queSePuedaExtraer() {
		Cuenta cuenta =  new Cuenta("Juani Quevedo", 500.0);
		cuenta.extraer(400.0);
		
		assertEquals(cuenta.getDinero(), (Double) 100.0);
	}
	
	@Test
	public void queSePuedaExtraerCuentaSueldo() {
		Cuenta cuenta =  new CuentaSueldo("Juani Quevedo", 500.0);
		
		
		assertTrue(cuenta.extraer(400.0));
	}
	
	@Test
	public void queSePuedaExtraerCajaDeAhorro() {
		CajaDeAhorros cuenta =  new CajaDeAhorros("Juani Quevedo", 500.0);
		
		cuenta.extraer(1.0);
		cuenta.extraer(1.0);
		cuenta.extraer(1.0);
		cuenta.extraer(1.0);
		cuenta.extraer(1.0);
		cuenta.extraer(1.0);
		
		
		assertEquals(cuenta.getDinero(), (Double) 488.0);
		
		assertEquals(cuenta.getCantidadDeExtracciones(), (Integer) 6);
	}
	
	@Test
	public void queSeCobreCincoPorcientoDeComisionAlDepositarDineroLuegoDeHaberRealizadoUnaExtraccionMayorAlSaldo() {
		CuentaCorriente cuenta = new CuentaCorriente("Sebastian Quevedo", 0.0);
		
		cuenta.depositar(100.0);
		cuenta.extraer(200.0);
		cuenta.depositar(200.0);
		
		
		assertEquals(cuenta.getDinero(), (Double)95.0);
	}
	
	@Test
	public void queSeCobreElCincoPorCientoDeComisionPorMasQueElProximoDepositoNoSeaSuficieteParaCubrirElDescubierto() {
		CuentaCorriente cuenta = new CuentaCorriente("Sebastian Quevedo", 0.0);
		
		cuenta.depositar(100.0);
		cuenta.extraer(200.0);
		cuenta.depositar(100.0);
		
		
		assertEquals(cuenta.getDinero(), (Double)(-5.0));
	}
	
	@Test
	public void queUnaExtraccionCuandoYaSeTieneDeudaIncrementeLaDeuda() {
		CuentaCorriente cuenta = new CuentaCorriente("Sebastian Quevedo", 0.0);
		
		cuenta.depositar(100.0);
		cuenta.extraer(200.0);
		cuenta.extraer(50.0);
		
		
		assertEquals(cuenta.getDinero(), (Double)(150.0));
	}
}
