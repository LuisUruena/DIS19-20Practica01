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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("almacen");
			doc.appendChild(rootElement);
			
			System.out.println("Productos:");
			leerProductos(rootElement, doc);
			
			System.out.println("Clientes:");
			
			System.out.println("Pedidos:");
			
			// DOMImplementation domImpl = doc.getImplementation();
			// DocumentType doctype = domImpl.createDocumentType("doctype", "almacen","almacen.dtd");
			
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			transformerFactory.setAttribute("indent-number", new Integer(2));
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2"); 
			DOMSource source = new DOMSource(doc);
			
			String nombreArchivo;
			Scanner lector = new Scanner (System.in);
			System.out.println("Introduce el nombre del archivo XML:");
			nombreArchivo = lector.nextLine();
			StreamResult result = new StreamResult(new File(nombreArchivo));

			transformer.transform(source, result);

			System.out.println("Fichero guardado correctamente.");
			
		} catch (ParserConfigurationException | TransformerConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		

	}

	private static void leerProductos(Element rootElement, Document doc) {
		// TODO Auto-generated method stub
		
		char respuesta;
		Scanner lector = new Scanner (System.in);
		Element productosEl = doc.createElement("productos");
		rootElement.appendChild(productosEl);
		
		do {
			
			Element productoEl = doc.createElement("producto");
			productosEl.appendChild(productoEl);
			
			String codigo;
			System.out.println("Introduce el código del producto:");
			codigo = lector.nextLine();
			Element codigoEl = doc.createElement("codigo");
			codigoEl.appendChild(doc.createTextNode(codigo));
			productoEl.appendChild(codigoEl);
			
			String nombre;
			System.out.println("Introduce el nombre del producto:");
			nombre = lector.nextLine();
			Element nombreEl = doc.createElement("nombre");
			nombreEl.appendChild(doc.createTextNode(nombre));
			productoEl.appendChild(nombreEl);
			
			String descripcion;
			System.out.println("Introduce la descripción del producto:");
			descripcion = lector.nextLine();
			Element descripcionEl = doc.createElement("descripcion");
			descripcionEl.appendChild(doc.createTextNode(descripcion));
			productoEl.appendChild(descripcionEl);
			
			String stock;
			System.out.println("Introduce el stock existente del producto:");
			stock = lector.nextLine();
			Element stockEl = doc.createElement("stock");
			stockEl.appendChild(doc.createTextNode(stock));
			productoEl.appendChild(stockEl);
			
			Element localizacionEl = doc.createElement("localizacion");
			productoEl.appendChild(localizacionEl);
			
			String pasillo;
			System.out.println("Introduce el pasillo donde se encuentra el producto:");
			pasillo = lector.nextLine();
			Element pasilloEl = doc.createElement("pasillo");
			pasilloEl.appendChild(doc.createTextNode(pasillo));
			localizacionEl.appendChild(pasilloEl);
			
			String estanteria;
			System.out.println("Introduce la estantería donde se encuentra el producto:");
			estanteria = lector.nextLine();
			Element estanteriaEl = doc.createElement("estanteria");
			estanteriaEl.appendChild(doc.createTextNode(estanteria));
			localizacionEl.appendChild(estanteriaEl);
			
			String estante;
			System.out.println("Introduce el estante donde se encuentra el producto:");
			estante = lector.nextLine();
			Element estanteEl = doc.createElement("estante");
			estanteEl.appendChild(doc.createTextNode(estante));
			localizacionEl.appendChild(estanteEl);
			
			
			String pendientes;
			System.out.println("Introduce el número de entregas pendientes del producto:");
			pendientes = lector.nextLine();
			Element pendientesEl = doc.createElement("pendientes");
			pendientesEl.appendChild(doc.createTextNode(pendientes));
			productoEl.appendChild(pendientesEl);
			
			
			System.out.println("¿Quieres introducir más productos? (S/N):");
			respuesta = lector.nextLine().charAt(0);
					
		} while(respuesta == 'S' || respuesta == 's');
		
	}

}
