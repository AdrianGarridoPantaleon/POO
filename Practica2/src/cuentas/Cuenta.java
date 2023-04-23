package cuentas;

import clientes.Cliente;

import java.util.ArrayList;

abstract public class Cuenta {

	private static int numCuentas = 1;
	private int numeroCuenta;
	private String cadenaCuenta;
	private double saldo;
	private ArrayList<Movimiento> operacionesRealizadas = new ArrayList<>();

	private Cliente cliente;
	private String CUENTA_VACIA = "El saldo de su cuenta no puede quedarse en descubierto";

	public Cuenta() {
		this.setNumeroCuenta(Cuenta.numCuentas);
		this.setSaldo(0);
		Cuenta.numCuentas++;
	}

	protected abstract boolean consultarCliente(Cliente cli) throws Exception;

	public abstract void mostrarMovimientos();

	public abstract void ingresarDinero(double dineroIngreso) throws Exception;

	public boolean retirarDinero(double dineroRetirar) throws Exception {
		if (saldo < 0) {
			throw new Exception(CUENTA_VACIA);
		} else {
			this.saldo -= dineroRetirar;
			return true;
		}

	}

	public int getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getCadenaCuenta() {
		return cadenaCuenta;
	}

	public void setCadenaCuenta(String cadenaCuenta) {
		this.cadenaCuenta = cadenaCuenta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	protected void crearCadenaCuenta() {
		int pos = (int) (Math.log10(this.numeroCuenta + 1));
		for (int i = pos; i <= (9 - pos); i++) {
			this.cadenaCuenta += "0";
		}
		this.cadenaCuenta += this.numeroCuenta;
	}

	public ArrayList<Movimiento> getOperacionesRealizadas() {
		return operacionesRealizadas;
	}
}