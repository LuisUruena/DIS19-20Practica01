import java.io.File;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;

public class Main {

	public static void main(String[] args) 
	{
		int opcion = 0;
		Scanner lector = new Scanner(System.in);
		do {
			System.out.println("Introduce una opción: ");
			System.out.println("1. Crear almacén.");
			System.out.println("2. Abrir almacén ya existente.");
			System.out.println("3. Salir.");

			opcion = Integer.parseInt(lector.nextLine());

			switch (opcion) 
			{
			
			case 1:
				crearAlmacen();
				break;

			case 2:
				abrirAlmacen();
				break;

			case 3:
				break;

			default:
				System.out.println("Error. Has elegido una opción no valida.");
				break;
			}

		} while (opcion != 3);
	}
	
	private static void guardarAlmacen(Almacen almacen) 
	{
		 String nombreArchivo; 
		 Scanner lector = new Scanner (System.in);
		 System.out.println("Introduce el nombre del archivo XML:"); 
		 nombreArchivo = lector.nextLine(); 
		 
		 Utilidadesfichero.guardarAlmacenxml(almacen, nombreArchivo);
		 
		 System.out.println("Fichero guardado correctamente."); 
	}
	
	private static void añadirProducto(Almacen almacen) 
	{
		Producto producto = Utilidadeslectura.leerProducto();
		if (almacen.añadirProducto(producto) == true) 
		{
			System.out.println("Producto añadido correctamente.");
		}
		else 
		{
			System.out.println("Error. Ya existe un producto con ese código.");
		}
		
	}
	
	private static void añadirCliente(Almacen almacen) 
	{
		Cliente cliente = Utilidadeslectura.leerCliente();
		if (almacen.añadirCliente(cliente) == true) 
		{
			System.out.println("Cliente añadido correctamente.");
		}
		else 
		{
			System.out.println("Error. Ya existe un cliente con ese código.");
		}
	}
	
	private static void añadirPedido(Almacen almacen) 
	{
		Pedido pedido = Utilidadeslectura.leerPedido();
		if (almacen.añadirPedido(pedido) == true) 
		{
			System.out.println("Pedido añadido correctamente.");
		}
		else 
		{
			System.out.println("Error. Ya existe un pedido con ese código.");
		}
	}
	
	private static void buscarProducto(Almacen almacen) 
	{
		String codigoProducto; 
		Producto productoBuscado;
		
		Scanner lector = new Scanner (System.in);
		System.out.println("Introduce el código del producto a buscar:"); 
		codigoProducto = lector.nextLine(); 
		
		productoBuscado = almacen.buscarProducto(codigoProducto);
		
		if(productoBuscado == null) 
		{
			System.out.println("Error. El código no se corresponde a ningún producto del almacén.");
		}
		else 
		{
			System.out.println("Producto encontrado.");
			System.out.println("Datos del producto:");
			System.out.println(""+productoBuscado.toString());
		}
		
	}
	
	private static void buscarCliente(Almacen almacen) 
	{
		String emailCliente; 
		Cliente clienteBuscado;
		
		Scanner lector = new Scanner (System.in);
		System.out.println("Introduce el email del cliente a buscar:"); 
		emailCliente = lector.nextLine(); 
		
		clienteBuscado = almacen.buscarCliente(emailCliente);
		
		if(clienteBuscado == null) 
		{
			System.out.println("Error. El email no se corresponde a ningún cliente.");
		}
		else 
		{
			System.out.println("Cliente encontrado.");
			System.out.println("Datos del cliente:");
			System.out.println(""+clienteBuscado.toString());
		}
	}
	
	private static void buscarPedido(Almacen almacen) 
	{
		String codigoPedido; 
		Pedido pedidoBuscado;
		
		Scanner lector = new Scanner (System.in);
		System.out.println("Introduce el código del pedido a buscar:"); 
		codigoPedido = lector.nextLine(); 
		
		pedidoBuscado= almacen.buscarPedido(codigoPedido);
		
		if(pedidoBuscado == null) 
		{
			System.out.println("Error. El código no se corresponde a ningún pedido.");
		}
		else 
		{
			System.out.println("Pedido encontrado.");
			System.out.println("Datos del pedido:");
			System.out.println(""+pedidoBuscado.toString());
		}
	}
	
	private static void borrarProducto(Almacen almacen) 
	{
		String codigoProducto; 
		Producto productoBorrado;
		
		Scanner lector = new Scanner (System.in);
		System.out.println("Introduce el código del producto a borrar:"); 
		codigoProducto = lector.nextLine(); 
		
		productoBorrado = almacen.borrarProducto(codigoProducto);
		
		if(productoBorrado == null) 
		{
			System.out.println("Error. El código no se corresponde a ningún producto del almacén.");
		}
		else 
		{
			System.out.println("Producto borrado correctamente.");
			System.out.println("Datos del producto borrado:");
			System.out.println(""+productoBorrado.toString());
		}
	}
	
	private static void borrarCliente(Almacen almacen) 
	{
		String emailCliente; 
		Cliente clienteBorrado;
		
		Scanner lector = new Scanner (System.in);
		System.out.println("Introduce el email del cliente a borrar:"); 
		emailCliente = lector.nextLine(); 
		
		clienteBorrado = almacen.borrarCliente(emailCliente);
		
		if(clienteBorrado == null) 
		{
			System.out.println("Error. El email no se corresponde a ningún cliente.");
		}
		else 
		{
			System.out.println("Cliente borrado correctamente.");
			System.out.println("Datos del cliente borrado:");
			System.out.println(""+clienteBorrado.toString());
		}
	}
	
	private static void borrarPedido(Almacen almacen) 
	{
		String codigoPedido; 
		Pedido pedidoBorrado;
		
		Scanner lector = new Scanner (System.in);
		System.out.println("Introduce el código del pedido a borrar:"); 
		codigoPedido = lector.nextLine(); 
		
		pedidoBorrado = almacen.borrarPedido(codigoPedido);
		
		if(pedidoBorrado == null) 
		{
			System.out.println("Error. El código no se corresponde a ningún pedido.");
		}
		else 
		{
			System.out.println("Pedido borrado correctamente.");
			System.out.println("Datos del pedido borrado:");
			System.out.println(""+pedidoBorrado.toString());
		}
		
	}
	
	private static void modificarPedido(Almacen almacen) 
	{
		String codigoPedido, confirmar, destinatarioModificar, fechaEntregaModificar; 
		Direccion direccionModificar;
		Pedido pedidoModificado;
		
		Scanner lector = new Scanner (System.in);
		System.out.println("Introduce el código del pedido a modificar:"); 
		codigoPedido = lector.nextLine(); 
		
		pedidoModificado = almacen.buscarPedido(codigoPedido);
		
		if(pedidoModificado == null) 
		{
			System.out.println("Error. El código no se corresponde a ningún pedido.");
		}
		else 
		{
			System.out.println("Dirección de entrega actual:\n" + pedidoModificado.getDireccionEntrega());
			System.out.println("¿Quieres modificar la dirección de entrega (S/N)?");
			confirmar = lector.nextLine();
			if(confirmar.equalsIgnoreCase("S"))
			{
				direccionModificar = Utilidadeslectura.leerDireccion("Introduce la nueva dirección de entrega: ");
				pedidoModificado.setDireccionEntrega(direccionModificar);
			}
			
			System.out.println("Destinatario actual: " + pedidoModificado.getDestinatario());
			System.out.println("¿Quieres modificar el destinatario (S/N)?");
			confirmar = lector.nextLine();
			if(confirmar.equalsIgnoreCase("S"))
			{
				System.out.println("Introduce el nuevo destinatario: ");
				destinatarioModificar = lector.nextLine();
				pedidoModificado.setDestinatario(destinatarioModificar);
			}
			
			System.out.println("Fecha de entrega actual: " + pedidoModificado.getFechaEntrega());
			System.out.println("¿Quieres modificar la fecha de entrega (S/N)?");
			confirmar = lector.nextLine();
			if(confirmar.equalsIgnoreCase("S"))
			{
				System.out.println("Introduce la nueva fecha de entrega: ");
				fechaEntregaModificar = lector.nextLine();
				pedidoModificado.setFechaEntrega(fechaEntregaModificar);
			}
			
			System.out.println(pedidoModificado.lineasPedidoToString());
			System.out.println("¿Quieres añadir líneas de pedido (S/N)?");
			confirmar = lector.nextLine();
			if(confirmar.equalsIgnoreCase("S"))
			{
				do 
				{
					Lineapedido lineaPedidoAñadido = Utilidadeslectura.leerLineapedido();
					pedidoModificado.añadirLineapedido(lineaPedidoAñadido);
					
					System.out.println("¿Quieres introducir más líneas de pedido? (S/N):");
					confirmar = lector.nextLine();
					
				} while(confirmar.equalsIgnoreCase("S"));
			}
			
			System.out.println("Pedido modificado correctamente.");
			System.out.println("Datos del pedido modificado:");
			System.out.println(""+pedidoModificado.toString());
		}
		
	}

	private static void modificarCliente(Almacen almacen) 
	{
		String emailCliente, emailModificar, confirmar; 
		Cliente clienteModificado;
		
		Scanner lector = new Scanner (System.in);
		System.out.println("Introduce el email del cliente a modificar:"); 
		emailCliente = lector.nextLine(); 
		
		clienteModificado = almacen.buscarCliente(emailCliente);
		
		if(clienteModificado == null) 
		{
			System.out.println("Error. El email no se corresponde a ningún cliente.");
		}
		else 
		{
			System.out.println("Email actual:\n" + clienteModificado.getEmail());
			System.out.println("¿Quieres modificarlo (S/N)?");
			confirmar = lector.nextLine();
			if(confirmar.equalsIgnoreCase("S"))
			{
				System.out.println("Introduce el nuevo email: ");
				emailModificar = lector.nextLine();
				clienteModificado.setEmail(emailModificar);
				// Al cambiar de email (clave que pedimos para identificar al cliente), 
				// borramos el cliente con el email anterior, y luego añadimos con el nuevo email.
				almacen.borrarCliente(emailCliente);
				almacen.añadirCliente(clienteModificado);
			}
		}
		
		
	}

	private static void modificarProducto(Almacen almacen) 
	{
		
		
	}

	private static void abrirAlmacen() 
	{
		
		
	}

	private static void crearAlmacen() 
	{
		Almacen almacenNuevo = new Almacen();
		
		int opcion = 0;
		Scanner lector = new Scanner(System.in);
		do {
			System.out.println("Introduce una opción: ");
			System.out.println("0. Salir.");
			System.out.println("1. Guardar almacén.");
			System.out.println("2. Añadir un producto.");
			System.out.println("3. Añadir un cliente.");
			System.out.println("4. Añadir un pedido.");
			System.out.println("5. Borrar un producto.");
			System.out.println("6. Borrar un cliente.");
			System.out.println("7. Borrar un pedido.");
			System.out.println("8. Buscar un producto.");
			System.out.println("9. Buscar un cliente.");
			System.out.println("10. Buscar un pedido.");
			System.out.println("11. Modificar un producto.");
			System.out.println("12. Modificar un cliente.");
			System.out.println("13. Modificar un pedido.");
			
			opcion = Integer.parseInt(lector.nextLine());

			switch (opcion) 
			{
			
			case 0:
				break;
				
			case 1:
				guardarAlmacen(almacenNuevo);
				break;

			case 2:
				añadirProducto(almacenNuevo);
				break;

			case 3:
				añadirCliente(almacenNuevo);
				break;
				
			case 4:
				añadirPedido(almacenNuevo);
				break;
				
			case 5:
				borrarProducto(almacenNuevo);
				break;
				
			case 6:
				borrarCliente(almacenNuevo);
				break;
				
			case 7:
				borrarPedido(almacenNuevo);
				break;
				
			case 8:
				buscarProducto(almacenNuevo);
				break;
				
			case 9:
				buscarCliente(almacenNuevo);
				break;
				
			case 10:
				buscarPedido(almacenNuevo);
				break;
				
			case 11:
				modificarProducto(almacenNuevo);
				break;
				
			case 12:
				modificarCliente(almacenNuevo);
				break;
				
			case 13:
				modificarPedido(almacenNuevo);
				break;

			default:
				System.out.println("Error. Has elegido una opción no valida.");
				break;
			}

		} while (opcion != 0);
	}
}
