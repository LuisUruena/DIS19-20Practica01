import java.util.ArrayList;
import java.util.HashMap;

public class Almacen {
	
	private HashMap<String, Producto> productos;
	private HashMap<String, Cliente> clientes;
	private HashMap<String, Pedido> pedidos;
	
	public Almacen() 
	{
		this.productos = new HashMap();
		this.pedidos = new HashMap();
		this.clientes = new HashMap();
	}

	public Almacen(HashMap productos, HashMap clientes, HashMap pedidos) 
	{
		this.productos = productos;
		this.pedidos = pedidos;
		this.clientes = clientes;
	}
	
	public boolean añadirProducto(Producto producto) 
	{
		if(this.productos.containsKey(producto.getCodigo())) 
		{
			return false;
		}
		else 
		{
			this.productos.put(producto.getCodigo(),producto);
			return true;
		}
	}
	
	public Producto borrarProducto(String codigo) 
	{
		return productos.remove(codigo);
	}
	
	public Producto buscarProducto(String codigo) 
	{
		return productos.get(codigo);
	}
	
	public boolean añadirCliente(Cliente cliente) 
	{
		if(this.clientes.containsKey(cliente.getEmail())) 
		{
			return false;
		}
		else 
		{
			this.clientes.put(cliente.getEmail(),cliente);
			return true;
		}
	}
	
	public Cliente borrarCliente(String email) 
	{
		return clientes.remove(email);
	}
	
	public Cliente buscarCliente(String email) 
	{
		return clientes.get(email);
	}
	
	public boolean añadirPedido(Pedido pedido) 
	{
		if(this.pedidos.containsKey(pedido.getCodigo())) 
		{
			return false;
		}
		else 
		{
			this.pedidos.put(pedido.getCodigo(),pedido);
			return true;
		}
	}
	
	public Pedido borrarPedido(String codigo) 
	{
		return pedidos.remove(codigo);
	}
	
	public Pedido buscarPedido(String codigo) 
	{
		return pedidos.get(codigo);
	}

	public ArrayList<Producto> getProductos() {
		return new ArrayList(productos.values());
	}

	public ArrayList<Cliente> getClientes() {
		return new ArrayList(clientes.values());
	}

	public ArrayList<Pedido> getPedidos() {
		return new ArrayList(pedidos.values());
	}
	
	
}	
