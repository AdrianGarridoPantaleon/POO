package cuentas;

import java.time.LocalDateTime;

import clientes.Cliente;
import clientes.ClienteParticular;

public class CuentaParticular extends Cuenta {

	private String FALLO_RETIRO = "No puedes retirar mas dinero del que tienes en la cuenta";
	private String FALLO_INGRESO = "No puedes ingresar dinero";
	private String ERROR_CUENTA = "El cliente introducido debe ser particular";

	public CuentaParticular(double saldo, Cliente cli) throws Exception {
		super();
		consultarCliente(cli);
		this.setCadenaCuenta("P");
		this.crearCadenaCuenta();
		setSaldo(saldo);

	}

	@Override
	public void ingresarDinero(double dineroIngreso) throws Exception {
		if (dineroIngreso < 10) {
			throw new Exception(FALLO_INGRESO);
		} else {
			Movimiento mov = new Movimiento(LocalDateTime.now(), this.getSaldo(), dineroIngreso, 0,
					this.getSaldo() + dineroIngreso, "Ingreso dinero");
			this.getOperacionesRealizadas().add(mov);
			setSaldo(dineroIngreso);
		}
	}

	@Override
	public boolean retirarDinero(double dineroRetirar) throws Exception {
		double dineroConComision = (dineroRetirar * 1.05);
		if (super.retirarDinero(dineroRetirar) && this.getSaldo() >= dineroConComision) {
			Movimiento mov = new Movimiento(LocalDateTime.now(), this.getSaldo(), 0, dineroRetirar,
					this.getSaldo() - dineroConComision, "Ingreso dinero");
			this.getOperacionesRealizadas().add(mov);
			this.setSaldo(this.getSaldo() - (dineroConComision));
			return true;
		} else {
			throw new Exception(FALLO_RETIRO);
		}

	}

	@Override
	public void mostrarMovimientos() {
		for (Movimiento recibo : this.getOperacionesRealizadas()) {
			recibo.mostrarReciboMovimiento();
		}
	}

	protected boolean consultarCliente(Cliente cli) throws Exception {
		if (cli instanceof ClienteParticular) {
			return true;
		} else {
			throw new Exception(ERROR_CUENTA);
		}

	}
}
