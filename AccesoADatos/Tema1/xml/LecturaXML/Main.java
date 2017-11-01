/*
********Autor: Cristina Navarro
********Fecha: 25/10/2017
********Asignatura: Acceso a Datos.
********Ejercicio: Visualización de archivo .xml
*/

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("C:\\Users\\Cristi\\Desktop\\A\\EmpleadosObjetos.xml"));
            doc.getDocumentElement().normalize();
            System.out.printf("Elemento raiz: %s %n", doc.getDocumentElement().getNodeName());
            NodeList empleados = doc.getElementsByTagName("empleado");
            System.out.printf("Nodos empleado a recorrer: %d %n", empleados.getLength());

            for (int i = 0; i < empleados.getLength(); i++) {
                Node emple = empleados.item(i);
                if (emple.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) emple;
                    System.out.printf("ID = %s %n", elemento.getElementsByTagName("codigo").item(0).getTextContent());
                    System.out.printf("* Apellido = %s %n", elemento.getElementsByTagName("apellido").item(0).getTextContent());
                    System.out.printf("* Salario = %s %n", elemento.getElementsByTagName("salario").item(0).getTextContent());
                }
            }
        } catch (ParserConfigurationException e) {
            System.out.println("Parser " +  e.getMessage());
        }catch (SAXException e){
            System.out.println("SAX " +  e.getMessage());
        }
    }
}
