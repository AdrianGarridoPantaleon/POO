package cuentas;

import clientes.Cliente;
import clientes.ClienteEmpresa;
import clientes.ClienteEmpresa.tipoEmpresa;

import java.time.LocalDateTime;

public class CuentaEmpresa extends Cuenta {
	private String FALLO_PYMES = "No puedes retirar mas del 10% de tu facturacion anual";
	private String ERROR_CUENTA = "El cliente introducido debe ser una empresa";

	public CuentaEmpresa(double saldo, Cliente cli) throws Exception {

		super();
		consultarCliente(cli);
		this.setCadenaCuenta("E");
		this.crearCadenaCuenta();
		setSaldo(saldo);
	}

	@Override
	public void ingresarDinero(double dineroIngreso) {

		Movimiento mov = new Movimiento(LocalDateTime.now(), this.getSaldo(), dineroIngreso, 0,
				this.getSaldo() + dineroIngreso, "Ingreso dinero");
		this.getOperacionesRealizadas().add(mov);
		setSaldo(dineroIngreso);

	}

	public void retirarDinero(double dineroRetirar, tipoEmpresa tipo_empresa, double facturacionAnual,
			ClienteEmpresa cli) throws Exception {
		double comision = 0;

		if (tipo_empresa == tipoEmpresa.PYMES) {
			if (dineroRetirar > (cli.getFacturacionAnual() * 0.10)) {
				throw new Exception(FALLO_PYMES);
			} else {
				if (this.getSaldo() < 5000) {
					comision = dineroRetirar * 0.1;
					Movimiento mov = new Movimiento(LocalDateTime.now(), this.getSaldo(), comision, dineroRetirar,
							this.getSaldo() - dineroRetirar - comision, "Retiro dinero");
					this.getOperacionesRealizadas().add(mov);
					setSaldo(getSaldo() - dineroRetirar - comision);
				} else {
					Movimiento mov = new Movimiento(LocalDateTime.now(), this.getSaldo(), 0, dineroRetirar,
							this.getSaldo() - dineroRetirar, "Retiro dinero");
					this.getOperacionesRealizadas().add(mov);
					setSaldo(getSaldo() - dineroRetirar);
				}
			}

		}
		if (tipo_empresa == tipoEmpresa.GRANEMPRESA) {
			if (this.getSaldo() < 5000) {
				comision = dineroRetirar * 0.1;
				Movimiento mov = new Movimiento(LocalDateTime.now(), this.getSaldo(), comision, dineroRetirar,
						this.getSaldo() - dineroRetirar - comision, "Retiro dinero");
				this.getOperacionesRealizadas().add(mov);
				setSaldo(getSaldo() - dineroRetirar - comision);
			} else {
				Movimiento mov = new Movimiento(LocalDateTime.now(), this.getSaldo(), 0, dineroRetirar,
						this.getSaldo() - dineroRetirar, "Retiro dinero");
				this.getOperacionesRealizadas().add(mov);
				setSaldo(getSaldo() - dineroRetirar);
			}
		}
	}

	@Override
	public void mostrarMovimientos() {
		for (Movimiento recibo : this.getOperacionesRealizadas()) {
			recibo.mostrarReciboMovimiento();
		}
	}

	protected boolean consultarCliente(Cliente cli) throws Exception {
		if (cli instanceof ClienteEmpresa) {
			return true;
		} else {
			throw new Exception(ERROR_CUENTA);
		}

	}
}
