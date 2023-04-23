package ventana;

import javax.swing.*;

/**
 * Esta clase soluciona cualquier tipo de error en las ventanas.
 * 
 * @author Adrian
 *
 */
public class ErrorPopUp extends Ventana {

	private static ErrorPopUp instancia = null;

	private ErrorPopUp(String mensajeError) {
		super();
		this.panelVentana.add(new JLabel(mensajeError));
		this.setSize(300, 100);
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(e -> {
			cerrarVentana();
		});
		this.panelVentana.add(btnVolver);
	}

	public static ErrorPopUp getInstancia(String error) {
		if (instancia == null)
			instancia = new ErrorPopUp(error);

		return instancia;
	}

	@Override
	public void cerrarVentana() {
		this.dispose();
	}
}
