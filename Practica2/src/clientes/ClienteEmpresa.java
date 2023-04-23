package clientes;

import java.util.Date;

public class ClienteEmpresa extends Cliente {

	public enum tipoEmpresa {

		PYMES, GRANEMPRESA
	}

	private String razon_social;
	private String domicilio_social;
	private String nombre_empresa;
	private Date fecha_creacion;
	private tipoEmpresa tipo_empresa;
	private double facturacionAnual;

	public ClienteEmpresa(tipoEmpresa tipo_empresa, double facturacionAnual) {

		super();

		this.tipo_empresa = tipo_empresa;
		this.facturacionAnual = facturacionAnual;

	}

	@Override
	boolean validarId() {
		boolean ValidacionIdent = validarId();
		{
			
			if (this.id.length() != 9) {
				return false;
			}
			
			boolean respuesta = false;
			char tabla[] = { 'J', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I' };
			int sumap = 0; 
			int sumai = 0;
			int p;
			int R;
			int dc;
			id = id.toUpperCase();
			try {
				sumap = Integer.parseInt(id.substring(2, 3)) + Integer.parseInt(id.substring(4, 5))
						+ Integer.parseInt(id.substring(6, 7));
				for (int i = 1; i <= 8; i++) {
					p = 2 * Integer.parseInt(id.substring(i, i + 1));
					if (p > 9) {
						sumai += (p / 10) + (p % 10);
					} else {
						sumai += p;
					}
					i++;
				}
				R = sumap + sumai;
				dc = R % 10;
				dc = 10 - dc;
				if (dc == 10) {
					dc = 0;
				}
				if (Character.isLetter(id.charAt(8))) {
					if (tabla[dc] == id.charAt(8)) {
						respuesta = true;
					}
				} else {
					if (dc == Integer.parseInt(id.substring(8, 9))) {
						respuesta = true;
					}
				}
			} catch (ArithmeticException e) {
				System.out.println("Division por cero");
				respuesta = false;
			} catch (IllegalArgumentException e) {
				respuesta = false;
			}
			return respuesta;

		}

	}

	@Override
	public boolean validarPassword(String password) {
		// TODO Auto-generated method stub
		return super.validarPassword(password);
	}

	public String getRazon_social() {
		return razon_social;
	}

	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}

	public String getDomicilio_social() {
		return domicilio_social;
	}

	public void setDomicilio_social(String domicilio_social) {
		this.domicilio_social = domicilio_social;
	}

	public String getNombre_empresa() {
		return nombre_empresa;
	}

	public void setNombre_empresa(String nombre_empresa) {
		this.nombre_empresa = nombre_empresa;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public tipoEmpresa getTipo_empresa() {
		return tipo_empresa;
	}

	public void setTipo_empresa(tipoEmpresa tipo_empresa) {
		this.tipo_empresa = tipo_empresa;
	}

	public double getFacturacionAnual() {
		return facturacionAnual;
	}

	public void setFacturacionAnual(double facturacionAnual) {
		this.facturacionAnual = facturacionAnual;
	}

}