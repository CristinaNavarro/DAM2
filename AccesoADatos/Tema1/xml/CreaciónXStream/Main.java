/*
********Autor: Cristina Navarro
********Fecha: 01/11/2017
********Asignatura:AccesoADatos
********Ejercicio:	A partir de los datos del fichero
******** Departamentos.dat creado en ejercicios anteriores,
******** crear un fichero XML usando XStream.
*/
import java.io.*;

import com.thoughtworks.xstream.XStream;

public class Main {
    public static void main(String[] args) throws IOException {
        File f = new File("C:\\Users\\Cristi\\Desktop\\A\\DepartamentosObjetos.dat");
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);

        ListaDepartamentos listDepartamentos = new ListaDepartamentos();

        try {
            while (true) {
                Departamento departamento = (Departamento) ois.readObject();
                listDepartamentos.add(departamento);
            }
        } catch (EOFException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        ois.close();


        XStream xstream = new XStream();
        xstream.alias("ListaDepartamentos", ListaDepartamentos.class);
        xstream.alias("DatosDepartamentos", Departamento.class);
        xstream.addImplicitCollection(ListaDepartamentos.class, "listDepartamentos");
        xstream.toXML(listDepartamentos, new FileOutputStream("C:\\Users\\Cristi\\Desktop\\A\\DepartamentosObjetosXSTREAM.xml"));
        System.out.println("Creado fichero");

    }
}
