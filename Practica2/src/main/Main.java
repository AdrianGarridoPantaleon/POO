package main;

import clientes.*;
import clientes.ClienteEmpresa.tipoEmpresa;
import cuentas.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class Main {

	private static ArrayList<Cliente> nclientes = new ArrayList<>();
	private static ArrayList<Cuenta> ncuentas = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		// clientes
		ClienteParticular joven1 = new ClienteParticular(LocalDate.of(2001, Month.APRIL, 22));
		ClienteEmpresa granEmpresa = new ClienteEmpresa(tipoEmpresa.GRANEMPRESA, 3500);
		ClienteParticular adulto = new ClienteParticular(LocalDate.of(1971, Month.DECEMBER, 16));
		ClienteParticular joven2 = new ClienteParticular(LocalDate.of(1998, Month.MARCH, 8));
		ClienteEmpresa pyme = new ClienteEmpresa(tipoEmpresa.PYMES, 5000);
		ClienteParticular anciano = new ClienteParticular(LocalDate.of(1934, Month.JULY, 05));

		// arrays
		nclientes.add(joven1);
		nclientes.add(granEmpresa);
		nclientes.add(adulto);
		nclientes.add(joven2);
		nclientes.add(anciano);
		nclientes.add(pyme);

		llenarCuentas(nclientes, ncuentas);
		comprobarContraseña("1234", pyme, joven1);
		comprobarDNI("50354875D", granEmpresa, joven2);

	}

	private static void llenarCuentas(ArrayList<Cliente> nclientes, ArrayList<Cuenta> ncuentas) throws Exception {
		for (int i = 0; i < nclientes.size(); i++) {
			if (nclientes.get(i) instanceof ClienteParticular) {
				ClienteParticular part = (ClienteParticular) nclientes.get(i);
				if (part.saberEdad() >= 18 && part.saberEdad() <= 34) {
					CuentaJoven cue1 = new CuentaJoven(3000, nclientes.get(i));
					ncuentas.add(cue1);
				}
				if (part.saberEdad() >= 65) {
					CuentaTerceraEdad cue2 = new CuentaTerceraEdad(3500, nclientes.get(i));
					ncuentas.add(cue2);
				}
				if (part.saberEdad() > 34 && part.saberEdad() < 65) {
					CuentaParticular cue3 = new CuentaParticular(3500, nclientes.get(i));
					ncuentas.add(cue3);
				}
			}
			if (nclientes.get(i) instanceof ClienteEmpresa) {
				CuentaEmpresa cue4 = new CuentaEmpresa(3500, nclientes.get(i));
				ncuentas.add(cue4);
			}
		}

	}

	private static void comprobarContraseña(String contraseña, ClienteEmpresa clie, ClienteParticular clip) {
		try {
			clie.validarPassword(contraseña);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static void comprobarDNI(String dni, ClienteEmpresa clie, ClienteParticular clip) {
		try {
			

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static void comprobarCIF(String cif, ClienteEmpresa clie, ClienteParticular clip) {
		try {
			clie.validarPassword(cif);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static void comprobarOperaciones(String contraseña, ClienteEmpresa clie, ClienteParticular clip) {
		try {
			clie.validarPassword(contraseña);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
