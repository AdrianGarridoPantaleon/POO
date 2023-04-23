package ventana;

import javax.swing.*;

/**
 * Esta clase se ocupa de crear la ventana principal. La ventana principal se
 * ocupara de pedir al usuario los datos.
 * 
 * @author Adrian
 *
 */

public abstract class Ventana extends JFrame {

	protected JPanel panelVentana = new JPanel();

	public Ventana() {
		this.setSize(300, 260);
		this.setLocationRelativeTo(null);
		this.add(panelVentana);
		this.setResizable(false);
	}

	public void mostrarVentana() {
		this.setVisible(true);
	}

	public void ocutarVentana() {
		this.setVisible(false);
	}

	public void cerrarVentana() {
		System.exit(0);
	}

}
