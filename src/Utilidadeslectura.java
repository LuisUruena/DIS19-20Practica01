import java.util.Scanner;

public class Utilidadeslectura 
{
	public static Producto leerProducto() 
	{
		Scanner lector = new Scanner (System.in);
		
		String codigo;
		System.out.println("Introduce el código del producto:");
		codigo = lector.nextLine();
		
		String nombre;
		System.out.println("Introduce el nombre del producto:");
		nombre = lector.nextLine();

		String descripcion;
		System.out.println("Introduce la descripción del producto:");
		descripcion = lector.nextLine();
		
		String stock;
		System.out.println("Introduce el stock existente del producto:");
		stock = lector.nextLine();
		
		Localizacion localizacion = leerLocalizacion();
		
		int pendientes;
		System.out.println("Introduce el número de entregas pendientes del producto:");
		pendientes = Integer.parseInt(lector.nextLine());
		
		
		Producto producto = new Producto(codigo,nombre,descripcion,stock,localizacion,pendientes);
		
		return producto;
		
	}
	
	
	public static Pedido leerPedido() 
	{
		Scanner lector = new Scanner (System.in);
		
		String codigo;
		System.out.println("Introduce codigo del pedido:");
		codigo = lector.nextLine();
		
		Direccion direccion = leerDireccion("Datos de la dirección del pedido:");
		
		String destinatario;
		System.out.println("Introduce destinatario del pedido:");
		destinatario = lector.nextLine();
		
		String fechaEntrega;
		System.out.println("Introduce fecha de entrega del pedido:");
		fechaEntrega = lector.nextLine();
		
		Pedido pedido = new Pedido(codigo, direccion, destinatario, fechaEntrega);
		
		char respuesta;
		
		do 
		{
			Lineapedido lineaPedido = leerLineapedido();
			pedido.añadirLineapedido(lineaPedido);
			
			System.out.println("¿Quieres introducir más líneas de pedido? (S/N):");
			respuesta = lector.nextLine().charAt(0);
			
		} while(respuesta == 'S' || respuesta == 's');
		
		return pedido;
		
	}
	
	public static Cliente leerCliente() 
	{
		Scanner lector = new Scanner (System.in);
		
		String nombre;
		System.out.println("Introduce el nombre del cliente:");
		nombre = lector.nextLine();
		
		String apellidos;
		System.out.println("Introduce los apellidos del cliente:");
		apellidos = lector.nextLine();
		
		String email;
		System.out.println("Introduce el email del cliente:");
		email = lector.nextLine();
		
		String telefonoContacto;
		System.out.println("Introduce el teléfono de contacto del cliente:");
		telefonoContacto = lector.nextLine();
		
		
		Direccion direccion = leerDireccion("Datos de la dirección del cliente:");
		
		Cliente cliente = new Cliente(nombre, apellidos, email, telefonoContacto, direccion);
		
		return cliente;
		
	}
	
	
	public static Lineapedido leerLineapedido() 
	{
		Scanner lector = new Scanner (System.in);
		
		String codigo;
		System.out.println("Introduce codigo del producto:");
		codigo = lector.nextLine();
		
		int cantidad;
		System.out.println("Introduce cantidad del producto:");
		cantidad = Integer.parseInt(lector.nextLine());
		
		Lineapedido lineaPedido = new Lineapedido(codigo,cantidad);
		
		return lineaPedido;
	}
	
	
	public static Localizacion leerLocalizacion() 
	{
		Scanner lector = new Scanner (System.in);
		
		int pasillo;
		System.out.println("Introduce el pasillo donde se encuentra el producto:");
		pasillo = Integer.parseInt(lector.nextLine());
		
		int estanteria;
		System.out.println("Introduce la estantería donde se encuentra el producto:");
		estanteria = Integer.parseInt(lector.nextLine());
		
		int estante;
		System.out.println("Introduce el estante donde se encuentra el producto:");
		estante = Integer.parseInt(lector.nextLine());
		
		Localizacion localizacion = new Localizacion(pasillo,estanteria,estante);
		
		return localizacion;
		
	}
	
	public static Direccion leerDireccion(String mensaje) 
	{
		Scanner lector = new Scanner (System.in);
		
		System.out.println(mensaje);
		
		String calle;
		System.out.println("Introduce la calle:");
		calle = lector.nextLine();
		
		String numero;
		System.out.println("Introduce el número:");
		numero = lector.nextLine();
		
		String codigoPostal;
		System.out.println("Introduce el código postal:");
		codigoPostal = lector.nextLine();
		
		String poblacion;
		System.out.println("Introduce la población:");
		poblacion = lector.nextLine();
		
		String pais;
		System.out.println("Introduce el país:");
		pais = lector.nextLine();
		
		Direccion direccion = new Direccion(calle, numero, codigoPostal, poblacion, pais);
		
		return direccion;
		
	}
	

}
