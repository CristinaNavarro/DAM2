import java.io.File;

/*
********Autor: Cristina Navarro
********Fecha: 23/10/2017
********Asignatura: Acceso a Datos
********Ejercicio:Buscar un archivo en todas las carpetas del ordenador,
********modifica información que este contiene, y crea archivos a partir
********del inicial de otros formatos.
*/

public class Main {
    public static void main(String[] args) {
        String nombreArchivo = "contabilidad.txt";
        String raiz = "C:\\";
        String pathDeseado = "";
        BusquedaArchivo buscar = new BusquedaArchivo();
        buscar.buscarDirectorio(new File(raiz),nombreArchivo);

        int cantidadCoincidencias = buscar.getListaResultado().size();
        if(cantidadCoincidencias == 0){
            System.out.println("\nNo se ha encontrado el archivo");
        }else{
            System.out.println("\nSe ha encontrado " + cantidadCoincidencias + " archivo/s que coincide con ese nombre\n");
            for (String coincidencia : buscar.getListaResultado()){
                System.out.println("Se ha encontrado: " + coincidencia);
                pathDeseado = coincidencia.substring(0,coincidencia.length() - nombreArchivo.length());
            }

            ModificacionArchivo modificacion = new ModificacionArchivo("almuerzo","Dieta");
            modificacion.modificarArchivo(pathDeseado);

            CreacionArchivos archivoIngresos = new CreacionArchivos("ingresos.dat",pathDeseado,nombreArchivo);
            archivoIngresos.crearArchivoBinario();
            CreacionArchivos archivoGastos = new CreacionArchivos("gastos.dat",pathDeseado,nombreArchivo);
            archivoGastos.crearArchivoBinario();

            CreacionArchivos archivoXML = new CreacionArchivos("contabilidad.xml",pathDeseado,nombreArchivo);
            archivoXML.crearArchivoXML();
        }
    }
}
