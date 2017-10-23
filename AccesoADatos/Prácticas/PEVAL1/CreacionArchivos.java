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


/*
********Autor: Cristina Navarro
********Fecha: 23/10/2017
********Asignatura: Acceso a Datos
********Ejercicio:Buscar un archivo en todas las carpetas del ordenador,
********modifica información que este contiene, y crea archivos a partir
********del inicial de otros formatos.
*/

public class CreacionArchivos {
    //Atributos
    private String nombre;
    private String path;
    private String origen;

    //Constructor
    CreacionArchivos(String nombre, String path, String origen) {
        this.nombre = nombre;
        this.path = path;
        this.origen = origen;
    }

    //Métodos
    //Crea un archivo binario cuyo contenido dependerá del nombre de archivo introducido
    public void crearArchivoBinario() {
        String linea;
        String distincion;
        if (this.nombre.equals("ingresos.dat")) {
            distincion = "I";
        } else {
            distincion = "G";
        }
        String[] lineaProcesada;
        File fOrigen = new File(this.path, this.origen);
        File fDestino = new File(this.path, this.nombre);
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(fOrigen));
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(fDestino));
            while ((linea = br.readLine()) != null) {
                lineaProcesada = linea.split(" ");
                if (lineaProcesada[3].equals(distincion)) {
                    dos.writeUTF(lineaProcesada[0]);
                    dos.writeUTF(lineaProcesada[1]);
                    dos.writeDouble(Double.parseDouble(lineaProcesada[2]));
                    dos.writeUTF(lineaProcesada[3]);
                }
            }
            br.close();
            dos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {
            System.out.println("FIN");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    //Creación de archivo XML con los mismos datos que el archivo introducido
    public void crearArchivoXML() {
        String linea;
        String[] lineaProcesada;
        File fOrigen = new File(this.path, this.origen);
        File fDestino = new File(this.path, this.nombre);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try (BufferedReader br = new BufferedReader(new FileReader(fOrigen))) {
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document doc = implementation.createDocument(null, "Empleados", null);
            doc.setXmlVersion("1.0");
            while ((linea = br.readLine()) != null) {
                lineaProcesada = linea.split(" ");
                Element raiz = doc.createElement("empleado");
                doc.getDocumentElement().appendChild(raiz);
                crearElemento("Fecha", lineaProcesada[0].trim(), raiz, doc);
                crearElemento("Concepto", lineaProcesada[1].trim(), raiz, doc);
                crearElemento("Cantidad", lineaProcesada[2].trim(), raiz, doc);
                crearElemento("Tipo", lineaProcesada[3].trim(), raiz, doc);
            }

            Source source = new DOMSource(doc);
            Result result = new StreamResult(fDestino);
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            br.close();
        } catch (ParserConfigurationException e) {
            System.out.println(e.getMessage());
        } catch (TransformerException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //
    private static void crearElemento(String datoEmple, String valor, Element raiz, Document doc) {
        Element elem = doc.createElement(datoEmple);
        Text text = doc.createTextNode(valor);
        raiz.appendChild(elem);
        elem.appendChild(text);
    }
}




