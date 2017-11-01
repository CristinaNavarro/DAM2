/*
********Autor: Cristina Navarro
********Fecha: 28/10/2017
********Asignatura:AccesoADatos
********Ejercicio:	Lectura y escritura de
********  objeto en archivo .xml
*/

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        //Preparación con respecto al objeto
        boolean existe = false;
        boolean salir = false;
        Departamento depart;
        FileInputStream fIn = new FileInputStream("C:\\Users\\Cristi\\Desktop\\A\\DepartamentosObjetos.dat");
        ObjectInputStream objectIn = new ObjectInputStream(fIn);

        //Preparación del XML
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        //Lectura y escritura
        try {

            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document doc = implementation.createDocument(null, "Departamentos", null);
            doc.setXmlVersion("1.0");
            int codigo;
            while (!salir) {
                depart = (Departamento) objectIn.readObject();
                codigo = depart.getCodigo();
                if (codigo > 0) {
                    Element raiz = doc.createElement("departamento");
                    doc.getDocumentElement().appendChild(raiz);
                    crearElemento("codigo", Integer.toString(depart.getCodigo()), raiz, doc);
                    crearElemento("nombre", depart.getNombre(), raiz, doc);
                    crearElemento("lugar", depart.getLugar(), raiz, doc);
                }
                if (codigo == 3) {
                    salir = true;
                }

            }
            Source source = new DOMSource(doc);
            Result result = new StreamResult(new File("C:\\Users\\Cristi\\Desktop\\A\\DepartamentosObjetos.xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
        } catch (EOFException error) {
            objectIn.close();
            fIn.close();
            if (!existe) System.out.println("Ese empleado no existe");
        } catch (ClassNotFoundException error) {
            System.out.println(error.getMessage());
        } catch (OptionalDataException error) {
            System.out.println(error.getMessage());
        } catch (ParserConfigurationException error) {
            error.printStackTrace();
        } catch (TransformerException error) {
            error.printStackTrace();
        }
    }

    private static void crearElemento(String datoEmple, String valor, Element raiz, Document document) {
        Element elem = document.createElement(datoEmple);
        Text text = document.createTextNode(valor); //damos el valor
        raiz.appendChild(elem); //pegamos el elemento hijo a la raiz
        elem.appendChild(text); //pegamos el valor
    }
}
