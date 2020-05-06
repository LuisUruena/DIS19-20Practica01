
public class Producto {

	private String codigo;
	private String nombre;
	private String descripcion;
	private String stock;
	private Localizacion localizacion;
	private int pendientes;
	
	public Producto(String codigo, String nombre, String descripcion, String stock, Localizacion localizacion, int pendientes) 
	{
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.stock = stock;
		this.localizacion = localizacion;
		this.pendientes = pendientes;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public Localizacion getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(Localizacion localizacion) {
		this.localizacion = localizacion;
	}

	public int getPendientes() {
		return pendientes;
	}

	public void setPendientes(int pendientes) {
		this.pendientes = pendientes;
	}
	
	@Override
	public String toString() 
	{
		return "Codigo: " + codigo + "\nNombre: " + nombre + "\nDescripcion: " + descripcion + "\nStock: " + stock + "\nLocalizacion: " + localizacion.toString() + "\nPendientes: " + pendientes;
	}

}
