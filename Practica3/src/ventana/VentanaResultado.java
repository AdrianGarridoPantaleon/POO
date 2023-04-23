package ventana;

import nomina.Nomina;

import javax.swing.*;

/**
 * Esta clase crea la ventan resultado. Se encargara de imprimir los datos del
 * usuario.
 * 
 * @author Adrian
 *
 */
public class VentanaResultado extends Ventana {

	public VentanaResultado(VentanaInicio vntInicio, Nomina nomina) {
		super();
		this.setSize(300, 350);
		agregarComponentesResultados(nomina);
		agregarBotones(vntInicio);
	}

	private void agregarComponentesResultados(Nomina nomina) {
		this.panelVentana.add(new JLabel("Nombre"));
		JTextField nombre = new JTextField(nomina.getNombre(), 25);
		nombre.setEditable(false);
		this.panelVentana.add(nombre);
		this.panelVentana.add(new JLabel("Primer apellido"));
		JTextField primerApellido = new JTextField(nomina.getPrimerApellido(), 25);
		primerApellido.setEditable(false);
		this.panelVentana.add(primerApellido);
		this.panelVentana.add(new JLabel("Segundo Apellido"));
		JTextField segundoApellido = new JTextField(nomina.getSegundoApellido(), 25);
		segundoApellido.setEditable(false);
		this.panelVentana.add(segundoApellido);
		this.panelVentana.add(new JLabel("Retenciones: IRPF"));
		JTextField retIRPF = new JTextField(String.valueOf(nomina.getRetIRPF()), 25);
		retIRPF.setEditable(false);
		this.panelVentana.add(retIRPF);
		this.panelVentana.add(new JLabel("Retenciones SS:"));
		JTextField retSS = new JTextField(String.valueOf(nomina.getRetSS()), 25);
		retSS.setEditable(false);
		this.panelVentana.add(retSS);
		this.panelVentana.add(new JLabel("Sueldo neto"));
		JTextField salarioNeto = new JTextField(String.valueOf(nomina.getSalarioNeto()), 25);
		salarioNeto.setEditable(false);
		this.panelVentana.add(salarioNeto);
	}

	/**
	 * Ponemos los botones que ns harán falta
	 * 
	 * @param vntInicio
	 */
	private void agregarBotones(VentanaInicio vntInicio) {
		JButton btnVolver = new JButton("Volver");
		JButton btnSalir = new JButton("Salir");

		btnVolver.addActionListener(e -> {
			this.ocutarVentana();
			// vntInicio.limpiarComponentes();
			vntInicio.mostrarVentana();
		});

		btnSalir.addActionListener(e -> {
			this.cerrarVentana();
			vntInicio.mostrarVentana();
		});

		this.panelVentana.add(btnVolver);
		this.panelVentana.add(btnSalir);
	}

	@Override
	public void ocutarVentana() {
		this.dispose();
	}
}