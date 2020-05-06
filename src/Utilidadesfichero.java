import java.io.File;
import java.util.ArrayList;
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

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Utilidadesfichero {

	public static Almacen cargarAlmacenxml(String ruta) {

		return null;
	}

	public static void guardarAlmacenxml(Almacen almacen, String ruta) {
		try {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("almacen");
			doc.appendChild(rootElement);
			
			if(almacen.getProductos().isEmpty() == false) 
			{
				guardarProductos(rootElement, doc, almacen.getProductos());
			}

			if(almacen.getClientes().isEmpty() == false) 
			{
				guardarClientes(rootElement, doc, almacen.getClientes());
			}

			if(almacen.getPedidos().isEmpty() == false) 
			{
				guardarPedidos(rootElement, doc, almacen.getPedidos());
			}


			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			transformerFactory.setAttribute("indent-number", new Integer(2));
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			DOMSource source = new DOMSource(doc);

			StreamResult result = new StreamResult(new File(ruta));

			transformer.transform(source, result);

		} catch (ParserConfigurationException | TransformerConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

	private static void guardarProductos(Element rootElement, Document doc, ArrayList<Producto> productos) 
	{
		Element productosEl = doc.createElement("productos");
		rootElement.appendChild(productosEl);
		
		for(Producto p:productos) 
		{
			Element productoEl = doc.createElement("producto");
			productosEl.appendChild(productoEl);
			
			Element codigoEl = doc.createElement("codigo");
			codigoEl.appendChild(doc.createTextNode(p.getCodigo()));
			productoEl.appendChild(codigoEl);
			

			Element nombreEl = doc.createElement("nombre");
			nombreEl.appendChild(doc.createTextNode(p.getNombre()));
			productoEl.appendChild(nombreEl);
			
			Element descripcionEl = doc.createElement("descripcion");
			descripcionEl.appendChild(doc.createTextNode(p.getDescripcion()));
			productoEl.appendChild(descripcionEl);
			

			Element stockEl = doc.createElement("stock");
			stockEl.appendChild(doc.createTextNode(p.getStock()));
			productoEl.appendChild(stockEl);
			
			Element localizacionEl = doc.createElement("localizacion");
			productoEl.appendChild(localizacionEl);
			

			Element pasilloEl = doc.createElement("pasillo");
			pasilloEl.appendChild(doc.createTextNode(""+p.getLocalizacion().getPasillo()));
			localizacionEl.appendChild(pasilloEl);
			

			Element estanteriaEl = doc.createElement("estanteria");
			estanteriaEl.appendChild(doc.createTextNode(""+p.getLocalizacion().getEstanteria()));
			localizacionEl.appendChild(estanteriaEl);
			
			
			Element estanteEl = doc.createElement("estante");
			estanteEl.appendChild(doc.createTextNode(""+p.getLocalizacion().getEstante()));
			localizacionEl.appendChild(estanteEl);
			

			Element pendientesEl = doc.createElement("pendientes");
			pendientesEl.appendChild(doc.createTextNode(""+p.getPendientes()));
			productoEl.appendChild(pendientesEl);
		}
		
	}

	private static void guardarClientes(Element rootElement, Document doc, ArrayList<Cliente> clientes) 
	{
		Element clientesEl = doc.createElement("clientes");
		rootElement.appendChild(clientesEl);
		
		for(Cliente c:clientes) 
		{
			Element clienteEl = doc.createElement("cliente");
			clientesEl.appendChild(clienteEl);
			
			Element nombreEl = doc.createElement("nombre");
			nombreEl.appendChild(doc.createTextNode(c.getNombre()));
			clienteEl.appendChild(nombreEl);

			Element apellidosEl = doc.createElement("apellidos");
			apellidosEl.appendChild(doc.createTextNode(c.getApellidos()));
			clienteEl.appendChild(apellidosEl);
			
			Element emailEl = doc.createElement("email");
			emailEl.appendChild(doc.createTextNode(c.getEmail()));
			clienteEl.appendChild(emailEl);
			
			Element telefonocontactoEl = doc.createElement("telefono_contacto");
			telefonocontactoEl.appendChild(doc.createTextNode(c.getTelefonoContacto()));
			clienteEl.appendChild(telefonocontactoEl);
					
			Element direccionEl = doc.createElement("direccion");
			clienteEl.appendChild(direccionEl);
			
			Element calleEl = doc.createElement("calle");
			calleEl.appendChild(doc.createTextNode(""+c.getDireccion().getCalle()));
			direccionEl.appendChild(calleEl);
			
			Element numeroEl = doc.createElement("numero");
			numeroEl.appendChild(doc.createTextNode(""+c.getDireccion().getNumero()));
			direccionEl.appendChild(numeroEl);
			
			Element codigoPostalEl = doc.createElement("codigo_postal");
			codigoPostalEl.appendChild(doc.createTextNode(""+c.getDireccion().getCodigoPostal()));
			direccionEl.appendChild(codigoPostalEl);
			
			Element poblacionEl = doc.createElement("poblacion");
			poblacionEl.appendChild(doc.createTextNode(""+c.getDireccion().getPoblacion()));
			direccionEl.appendChild(poblacionEl);
			
			Element paisEl = doc.createElement("pais");
			paisEl.appendChild(doc.createTextNode(""+c.getDireccion().getPais()));
			direccionEl.appendChild(paisEl);
			
		}
		
	}

	private static void guardarPedidos(Element rootElement, Document doc, ArrayList<Pedido> pedidos) 
	{
		Element pedidosEl = doc.createElement("pedidos");
		rootElement.appendChild(pedidosEl);
		
		for(Pedido pe:pedidos) 
		{
			Element pedidoEl = doc.createElement("pedido");
			pedidosEl.appendChild(pedidoEl);
			
			for(Lineapedido lp:pe.getLineasPedido()) 
			{
				Element lineaspedidoEl = doc.createElement("linea_pedido");
				pedidoEl.appendChild(lineaspedidoEl);
				
				Element codigoEl = doc.createElement("codigo");
				codigoEl.appendChild(doc.createTextNode(lp.getCodigo()));
				lineaspedidoEl.appendChild(codigoEl);
				
				Element cantidadEl = doc.createElement("cantidad");
				cantidadEl.appendChild(doc.createTextNode(""+lp.getCantidad()));
				lineaspedidoEl.appendChild(cantidadEl);		
			}
			
			Element codigoEl = doc.createElement("codigo");
			codigoEl.appendChild(doc.createTextNode(pe.getCodigo()));
			pedidoEl.appendChild(codigoEl);
			
			Element direccionEl = doc.createElement("direccion");
			pedidoEl.appendChild(direccionEl);
			
			Element calleEl = doc.createElement("calle");
			calleEl.appendChild(doc.createTextNode(""+pe.getDireccionEntrega().getCalle()));
			direccionEl.appendChild(calleEl);
			
			Element numeroEl = doc.createElement("numero");
			numeroEl.appendChild(doc.createTextNode(""+pe.getDireccionEntrega().getNumero()));
			direccionEl.appendChild(numeroEl);
			
			Element codigoPostalEl = doc.createElement("codigo_postal");
			codigoPostalEl.appendChild(doc.createTextNode(""+pe.getDireccionEntrega().getCodigoPostal()));
			direccionEl.appendChild(codigoPostalEl);
			
			Element poblacionEl = doc.createElement("poblacion");
			poblacionEl.appendChild(doc.createTextNode(""+pe.getDireccionEntrega().getPoblacion()));
			direccionEl.appendChild(poblacionEl);
			
			Element paisEl = doc.createElement("pais");
			paisEl.appendChild(doc.createTextNode(""+pe.getDireccionEntrega().getPais()));
			direccionEl.appendChild(paisEl);
			
			Element destinatarioEl = doc.createElement("destinatario");
			destinatarioEl.appendChild(doc.createTextNode(pe.getDestinatario()));
			pedidoEl.appendChild(destinatarioEl);
			
			Element fechaEntregaEl = doc.createElement("fecha_entrega");
			fechaEntregaEl.appendChild(doc.createTextNode(pe.getFechaEntrega()));
			pedidoEl.appendChild(fechaEntregaEl);
			
		}
		
	}

}
