/*
********Autor: Cristina Navarro*********************
********Fecha: 18/10/2017***************************
********Asignatura:Acceso a Datos ******************
********Ejercicio:crear un documento XML usando DOM.

*/

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;



//////////////////////////////////////////////////////////////////////////////////////////////////Fichero aleatorio a XML
public class Main {
    public static void main(String[] args) throws IOException {
        File f = new File("C:\\Users\\Cristi\\Desktop\\A\\EmpleadosAleatorio.dat");
        RandomAccessFile raf = new RandomAccessFile(f, "r");
        int codigo;
        int posicion = 0;

        int sueldo;
        char[] apellidos = new char[10]; //aux?
        char aux;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document doc = implementation.createDocument(null, "Empleados", null);
            doc.setXmlVersion("1.0");
            raf.seek(0);
            for (int i = 0; i < f.length() / 32; i++) {
                codigo = raf.readInt();
                System.out.println(codigo);
                for (int j = 0; j < 10; j++) {
                    apellidos[j] = raf.readChar();
                    System.out.print(apellidos[j]);
                }
                String apellido = new String(apellidos);
                sueldo = raf.readInt();
                System.out.print(sueldo + " ");
                System.out.println(raf.readInt());
                System.out.println();


                if (codigo > 0) {
                    Element raiz = doc.createElement("empleado");
                    doc.getDocumentElement().appendChild(raiz);
                    crearElemento("codigo", Integer.toString(codigo), raiz, doc);
                    crearElemento("apellido", apellido.trim(), raiz, doc);
                    crearElemento("salario", Integer.toString(sueldo), raiz, doc);
                }
                posicion += 28;
                if (raf.getFilePointer() == raf.length()) {
                    break;
                }
            }

            Source source = new DOMSource(doc);
            Result result = new StreamResult(new File("C:\\Users\\Cristi\\Desktop\\A\\EmpleadosAleatorio.xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        raf.close();
    }

    private static void crearElemento(String datoEmple, String valor, Element raiz, Document document) {
        Element elem = document.createElement(datoEmple);
        Text text = document.createTextNode(valor); //damos el valor
        raiz.appendChild(elem); //pegamos el elemento hijo a la raiz
        elem.appendChild(text); //pegamos el valor
    }

}
