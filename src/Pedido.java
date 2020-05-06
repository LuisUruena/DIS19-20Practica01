import java.util.ArrayList;

public class Pedido {
	
	private ArrayList<Lineapedido> lineasPedido;
	private String codigo;
	private Direccion direccionEntrega;
	private String destinatario;
	private String fechaEntrega;
	
	public Pedido(String codigo, Direccion direccionEntrega, String destinatario, String fechaEntrega) 
	{
		this.lineasPedido = new ArrayList();
		this.codigo = codigo;
		this.direccionEntrega = direccionEntrega;
		this.destinatario = destinatario;
		this.fechaEntrega = fechaEntrega;
	}

	public Pedido(ArrayList lineasPedido, String codigo, Direccion direccionEntrega, String destinatario, String fechaEntrega) 
	{
		this.lineasPedido = lineasPedido;
		this.codigo = codigo;
		this.direccionEntrega = direccionEntrega;
		this.destinatario = destinatario;
		this.fechaEntrega = fechaEntrega;
	}
	
	public void añadirLineapedido(Lineapedido lineapedido) 
	{
		this.lineasPedido.add(lineapedido);
	}

	public ArrayList<Lineapedido> getLineasPedido() {
		return lineasPedido;
	}

	public void setLineasPedido(ArrayList<Lineapedido> lineasPedido) {
		this.lineasPedido = lineasPedido;
	}

	public String getCodigo() {
		return codigo;
	}

	public Direccion getDireccionEntrega() {
		return direccionEntrega;
	}

	public void setDireccionEntrega(Direccion direccionEntrega) {
		this.direccionEntrega = direccionEntrega;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	
	public String lineasPedidoToString() 
	{
		String salida = "";
		salida += "Lineas de Pedido: " ; 
		for (int iterador = 0; iterador < lineasPedido.size(); iterador++) 
		{
			salida += "\n\t" + lineasPedido.get(iterador); 
		}
		return salida;
	}
	
	@Override
	public String toString() 
	{
		String salida = "\nCódigo: " + codigo + "\nDirección: " + direccionEntrega.toString() + "\nDestinatario: " + destinatario + "\nFecha de entrega: " + fechaEntrega;
		salida += "\n" + lineasPedidoToString();
		return salida;
	}

}
