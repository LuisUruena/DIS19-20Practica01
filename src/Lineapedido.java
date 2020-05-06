
public class Lineapedido {
	
	private String codigo;
	private int cantidad;

	public Lineapedido(String codigo,int cantidad) 
	{
		this.codigo = codigo;
		this.cantidad = cantidad;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	@Override
	public String toString() 
	{
		return "Código: " + codigo + ", Cantidad: " + cantidad;
	}

}
