package cuentas;

import java.time.LocalDateTime;

import clientes.Cliente;
import clientes.ClienteParticular;

public class CuentaTerceraEdad extends Cuenta {
	private String INGRESO_MAXIMO = "No puedes ingresar mas de 1000€";
	private String DESCUBIERTO_MAXIMO = "No puedes quedarte en menos de -1000€";
	private String ERROR_EDAD = "Tienes que tener mas de 65 años";
	private String ERROR_CUENTA = "El cliente debe ser particular";
	private static final int dineroMaximo = 1000;
	private static final int descubiertoMaximo = -1000;

	public CuentaTerceraEdad(double saldo, Cliente cli) throws Exception {

		super();
		consultarCliente(cli);
		this.setCadenaCuenta("T");
		this.crearCadenaCuenta();
		setSaldo(saldo);
	}

	@Override
	public void ingresarDinero(double dineroIngreso) throws Exception {
		if (dineroIngreso > dineroMaximo) {
			throw new Exception(INGRESO_MAXIMO);
		} else {
			Movimiento mov = new Movimiento(LocalDateTime.now(), this.getSaldo(), 0, dineroIngreso,
					this.getSaldo() - dineroIngreso, "Ingreso dinero");
			this.getOperacionesRealizadas().add(mov);
			setSaldo(getSaldo() + dineroIngreso);

		}

	}

	public boolean retirarDinero(double dineroRetirar) throws Exception {

		if ((getSaldo() - dineroRetirar) < descubiertoMaximo) {
			throw new Exception(DESCUBIERTO_MAXIMO);
		} else {
			Movimiento mov = new Movimiento(LocalDateTime.now(), this.getSaldo(), 0, dineroRetirar,
					this.getSaldo() - dineroRetirar, "Retiro dinero");
			this.getOperacionesRealizadas().add(mov);
			setSaldo(getSaldo() - dineroRetirar);
			return true;
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
			ClienteParticular part = (ClienteParticular) cli;
			if (part.saberEdad() > 65) {
				return true;
			} else {
				throw new Exception(ERROR_EDAD);
			}

		} else {
			throw new Exception(ERROR_CUENTA);
		}

	}
}
