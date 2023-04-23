package cuentas;

import java.time.LocalDateTime;

public class Movimiento {
	private LocalDateTime fechaMovimiento;
	private double importeInicial;
	private double abono;
	private double cargo;
	private double saldoFinal;
	private String concepto;

	public Movimiento(LocalDateTime fechaMovimiento, double importeInicial, double abono, double cargo,
			double saldoFinal, String concepto) {
		this.fechaMovimiento = fechaMovimiento;
		this.importeInicial = importeInicial;
		this.abono = abono;
		this.cargo = cargo;
		this.saldoFinal = saldoFinal;
		this.concepto = concepto;
	}

	public void mostrarReciboMovimiento() {
		StringBuilder recibo = new StringBuilder();
		recibo.append("Fecha: " + this.fechaMovimiento + "\n");
		recibo.append("Importe inicial: " + this.importeInicial + "\n");
		recibo.append("Abono: " + this.abono + "\n");
		recibo.append("Cargo: " + this.cargo + "\n");
		recibo.append("Saldo final: " + this.saldoFinal + "\n");
		recibo.append("Concepto: " + this.concepto + "\n");
		System.out.println(recibo.toString());
	}

}
