package clientes;

import java.util.*;

abstract public class Cliente {

	public Cliente() {

		num = numClientes;

		numClientes++;
	}

	private static int numClientes = 1;
	private int num;
	protected String id;
	private Date fechaDeAlta;
	protected String password;
	private String email;

//VALIDAR IDENTIFICACIÓN //

	abstract boolean validarId();

	public String getId() {
		return this.id;
	}

	public void setId(String ID) {
		if (validarId() == true) {
			this.id = ID;
		} else {
			System.out.println("Identificación no valida");
		}
	}

//VALIDAR CONTRASEÑA//
	boolean validarPassword(String password) {
		String letras = ("qwertyuiopasdfghjklñzxcvbnmQWERTYUIOPASDFGHJKLÑZXCVBNM");
		String numeros = ("0123456789");
		int contLetras = 0;
		int contNum = 0;

		int i;
		for (i = 0; i < password.length(); i++)
			;
		{

			if (password.charAt(i) == letras.charAt(i)) {
				contLetras++;
			}
			if ((password.charAt(i) == numeros.charAt(i))) {
				contNum++;
			}
			if ((password.charAt(i) == letras.charAt(i))) {
				contLetras++;
			}
			if ((contLetras < 1) && (contNum < 1)) {

				return false;

			}

			else {
				return true;

			}

		}

	}

	public void setPassword(String password) {
		if (validarPassword(password) == true) {
			this.password = password;
		} else {
			System.out.println("Contraseña no valida");
		}
	}

	public String getPassword() {

		return password;
	}

}
