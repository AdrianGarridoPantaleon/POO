package nomina;

/**
 * Esta clase calcula la nomina.
 * 
 * @author Adrián Garrido Pantaleón
 *
 */
public class Nomina {
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	public int salario, retSS, retIRPF, salarioNeto;

	/**
	 * Este es el constructor de la clase nómina
	 * 
	 * @param nombre del usuario.
	 * @param primerApellido del usuario.
	 * @param segundoApellido del usuario.
	 * @param salario
	 */
	public Nomina(String nombre, String primerApellido, String segundoApellido, int salario) {
		this.salario = salario;
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.retIRPF = salario * 20 / 100;
		this.retSS = salario * 10 / 100;

	}

	// GETTERS AND SETTERS
	public String getNombre() {
		return nombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public int getSalario() {
		return salario;
	}

	public int getRetSS() {
		return retSS;
	}

	public int getRetIRPF() {
		return retIRPF;
	}

	public int getSalarioNeto() {
		salarioNeto = salario - retSS - retIRPF;
		return salarioNeto;
	}

}