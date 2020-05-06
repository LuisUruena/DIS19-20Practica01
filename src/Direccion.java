
public class Direccion {
	
	private String calle;
	private String numero;
	private String codigoPostal;
	private String poblacion;
	private String pais;

	public Direccion(String calle, String numero, String codigoPostal, String poblacion, String pais) 
	{
		this.calle = calle;
		this.numero = numero;
		this.codigoPostal = codigoPostal;
		this.poblacion = poblacion;
		this.pais = pais;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
	@Override
	public String toString() 
	{
		return "Calle: " + calle + "\nNúmero: " + numero + "\nCódigo Postal: " + codigoPostal + "\nPoblación: " + poblacion + "\nPaís: " + pais;
	}
	
}
