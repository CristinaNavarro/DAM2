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
        Empleados e;
        FileInputStream fIn = new FileInputStream("C:\\Users\\Cristi\\Desktop\\A\\EmpleadosObjetos.dat");
        ObjectInputStream objectIn = new ObjectInputStream(fIn);

        //Preparación del XML
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        //Lectura y escritura
        try {

            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document doc = implementation.createDocument(null, "Empleados", null);
            doc.setXmlVersion("1.0");
            int codigo;
            while (!salir) {
                e = (Empleados) objectIn.readObject();
                codigo = e.codigo;
                if (codigo > 0) {
                    Element raiz = doc.createElement("empleado");
                    doc.getDocumentElement().appendChild(raiz);
                    crearElemento("codigo", Integer.toString(e.codigo), raiz, doc);
                    crearElemento("apellido", e.apellido, raiz, doc);
                    crearElemento("salario", Integer.toString(e.sueldo), raiz, doc);
                }
                if(codigo == 3){
                    salir = true;
                }

            }
            Source source = new DOMSource(doc);
            Result result = new StreamResult(new File("C:\\Users\\Cristi\\Desktop\\A\\EmpleadosObjetos.xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
        }catch (EOFException error){
            objectIn.close();
            fIn.close();
            if(!existe) System.out.println("Ese empleado no existe");
        }catch (ClassNotFoundException error){
            System.out.println(error.getMessage());
        }catch (OptionalDataException error){
            System.out.println(error.getMessage());
        }catch (ParserConfigurationException error){
            error.printStackTrace();
        }catch (TransformerException error) {
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
