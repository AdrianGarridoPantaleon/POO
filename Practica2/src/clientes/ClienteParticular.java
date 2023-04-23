package clientes;

import java.time.LocalDate;
import java.time.Period;

import cuentas.Cuenta;
import cuentas.CuentaParticular;

public class ClienteParticular extends Cliente {

	private Cuenta cuenta;
	protected String nombre;
	private String apellidos;
	private LocalDate nacimiento;
	private double rentaAnual;

	public ClienteParticular(LocalDate nacimiento) {
		super();
		this.nacimiento = nacimiento;

	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public double getRenta_anual() {
		return rentaAnual;
	}

	public void setRenta_anual(double renta_anual) {
		this.rentaAnual = renta_anual;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	// METODO VALIDAR PASSWORD

	boolean validarPassword(String password) {

		int length = 0;
		int numCount = 0;
		int capCount = 0;
		boolean z;
		for (int x = 0; x < password.length(); x++) {
			if ((password.charAt(x) >= 47 && password.charAt(x) <= 58)
					|| (password.charAt(x) >= 64 && password.charAt(x) <= 91)
					|| (password.charAt(x) >= 97 && password.charAt(x) <= 122)) {

			}

			if ((password.charAt(x) > 47 && password.charAt(x) < 58)) { 
				numCount++;
			}

			if ((password.charAt(x) > 64 && password.charAt(x) < 91)) { 
			}

			length = (x + 1); 

		if (numCount < 1) {
			z = false;
		}

		if (capCount < 1) { 
			z = false;
		}

		if (length > 4) { 
			z = false;
		}
		if (z = false) {
			return false;

		} else {
			return true;
		}
		}
		return false;

	}

	public boolean excepcionContraseña(boolean validarPassword) throws Exception {

		if (validarPassword == false) {
			throw new Exception(
					"Contraseña no valida, debe tener una longitud maxima de 4 caracteres y contener letras y números");
		} else {
			return true;

		}
	}

	// METODO VALIDAR ID

	public boolean validarDni() {

		String letraMayuscula = "";

		if (id.length() != 9 || Character.isLetter(this.id.charAt(8)) == false) {
			return false;
		}

		letraMayuscula = (this.id.substring(8)).toUpperCase();

		if (soloNumeros() == true && letraDNI().equals(letraMayuscula)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean soloNumeros() {

		int i, j = 0;
		String numero = ""; 
		String miDNI = ""; 
		String[] unoNueve = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };

		for (i = 0; i < this.id.length() - 1; i++) {
			numero = this.id.substring(i, i + 1);

			for (j = 0; j < unoNueve.length; j++) {
				if (numero.equals(unoNueve[j])) {
					miDNI += unoNueve[j];
				}
			}
		}

		if (miDNI.length() != 8) {
			return false;
		} else {
			return true;
		}
	}

	private String letraDNI() {
		
		int miDNI = Integer.parseInt(this.id.substring(0, 8));
		int resto = 0;
		String miLetra = "";
		String[] asignacionLetra = { "T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S",
				"Q", "V", "H", "L", "C", "K", "E" };

		resto = miDNI % 23;

		miLetra = asignacionLetra[resto];

		return miLetra;
	}

	@Override
	boolean validarId() {
		if (validarDni() == true) {
			return true;

		} else {
			return false;
		}
		// TODO Auto-generated method stub

	}

	public int saberEdad() {
		LocalDate hoy = LocalDate.now();
		return Period.between(nacimiento, hoy).getYears();
	}

}
