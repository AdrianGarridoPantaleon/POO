package cuentas;

import java.time.LocalDateTime;

import clientes.Cliente;
import clientes.ClienteParticular;

public class CuentaJoven extends Cuenta {
	private String DINERO_MAXIMO = "No puedes tener mas de 15000€";
	private String INGRESO_MAXIMO = "No puedes ingresar mas de lo que tienes";
	private String RETIRADA_MAYOR_50 = "No puedes retirar mas del 50% de tu saldo";
	private String ERROR_EDAD = "Tienes que tener entre 18 y 34 años";
	private String ERROR_CUENTA = "El cliente debe ser particular";
	private static final int dineroMaximo = 15000;

	public CuentaJoven(double saldo, Cliente cli) throws Exception {

		super();
		consultarCliente(cli);
		this.setCadenaCuenta("J");
		this.crearCadenaCuenta();
		setSaldo(saldo);
	}

	@Override
	public void ingresarDinero(double dineroIngreso) throws Exception {
		if (dineroIngreso > getSaldo()) {
			throw new Exception(INGRESO_MAXIMO);
		} else {
			if ((getSaldo() + dineroIngreso) > dineroMaximo) {
				throw new Exception(DINERO_MAXIMO);
			} else {
				Movimiento mov = new Movimiento(LocalDateTime.now(), this.getSaldo(), 0, dineroIngreso,
						this.getSaldo() - dineroIngreso, "Ingreso dinero");
				this.getOperacionesRealizadas().add(mov);
				setSaldo(getSaldo() + dineroIngreso);
			}

		}

	}

	public boolean retirarDinero(double dineroRetirar) throws Exception {
		double comision = dineroRetirar * 0.02;
		if (dineroRetirar > (getSaldo() * 0.5)) {
			throw new Exception(RETIRADA_MAYOR_50);
		} else {
			Movimiento mov = new Movimiento(LocalDateTime.now(), this.getSaldo(), comision, dineroRetirar,
					this.getSaldo() - dineroRetirar - comision, "Retiro dinero");
			this.getOperacionesRealizadas().add(mov);
			setSaldo(getSaldo() - dineroRetirar - comision);
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
			if (18 <= part.saberEdad() && part.saberEdad() <= 34) {
				return true;
			} else {
				throw new Exception(ERROR_EDAD);
			}

		} else {
			throw new Exception(ERROR_CUENTA);
		}

	}
}
