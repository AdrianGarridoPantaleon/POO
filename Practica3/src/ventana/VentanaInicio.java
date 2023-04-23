package ventana;

import nomina.*;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Esta clase es la ventana de inicio que hará de interfaz con el usuario.
 * 
 * @author Adrian
 *
 */
public class VentanaInicio extends Ventana {
	private String[] etiquetasInputText = { "Nombre: ", "Primer Apellido: ", "Segundo Apellido: ",
			"Salario bruto mensual: " };
	private ArrayList<JTextField> camposTexto = new ArrayList<>(4);
	private Nomina nomina;
	private VentanaResultado vntResultado;

	public VentanaInicio() {
		super();
		agregarComponentes();
		agregarBotones();
	}

	private void agregarBotones() {
		JButton btnSalir = new JButton("Salir");
		JButton btnCalcular = new JButton("Calcular");

		this.panelVentana.add(btnCalcular);
		this.panelVentana.add(btnSalir);

		btnSalir.addActionListener(e -> {
			cerrarVentana();
		});

		btnCalcular.addActionListener(e -> {
			if (validarInput()) {
				this.ocutarVentana();
				this.nomina = new Nomina(camposTexto.get(0).getText(), camposTexto.get(1).getText(),
						camposTexto.get(2).getText(), Integer.parseInt(camposTexto.get(3).getText()));
				vntResultado = new VentanaResultado(this, nomina);
				vntResultado.mostrarVentana();
			} else {
				ErrorPopUp.getInstancia("Error: Uno o alguno de los campos están vacíos.").mostrarVentana();
			}
		});
	}

	private boolean validarInput() {
		for (JTextField datoInput : camposTexto) {
			if (datoInput.getText().isEmpty()) {
				return false;
			}
		}
		return true;
	}

	// En caso de necesitar los campos de la ventana inicio al volver desde
	// Resultado
	protected void limpiarComponentes() {
		for (JTextField inputTexto : camposTexto) {
			inputTexto.setText("");
		}
	}

	private void agregarComponentes() {
		for (String etiqueta : etiquetasInputText) {
			JTextField aux = new JTextField(25);
			this.panelVentana.add(new JLabel(etiqueta));
			this.panelVentana.add(aux);
			this.camposTexto.add(aux);
		}
	}

}
