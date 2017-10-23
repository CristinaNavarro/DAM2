import java.io.File;
import java.util.ArrayList;
import java.util.List;

/*
********Autor: Cristina Navarro
********Fecha: 23/10/2017
********Asignatura: Acceso a Datos
********Ejercicio:Buscar un archivo en todas las carpetas del ordenador,
********modifica información que este contiene, y crea archivos a partir
********del inicial de otros formatos.
*/

public class BusquedaArchivo {

    //Atributos
    private String archivoABuscar;
    private List<String> listaResultado = new ArrayList<>();

    //Constructor
    BusquedaArchivo() {
    }

    //Getter&Setter
    //Devuelve la lista de coincidencias
    public List<String> getListaResultado(){
        return listaResultado;
    }

    //Métodos
    //Busca desde la raíz
    public void buscarDirectorio(File directorio, String archivoABuscar) {
        this.archivoABuscar = archivoABuscar;
        if (directorio.isDirectory()) {
            buscar(directorio);
        }
    }

    //Busca el archivo indicado dentro de las distintas carpetas del sistema
    private void buscar(File file) {
        if (file.isDirectory()) {
            for (File temp : file.listFiles()) {
                if (temp.isDirectory()) {
                    try {
                        buscar(temp);
                    } catch (NullPointerException e) {
                    }
                } else {
                    if (this.archivoABuscar.equals(temp.getName().toLowerCase())) {
                        this.listaResultado.add(temp.getAbsoluteFile().toString());
                        break;
                    }
                }
            }
        }
    }
}
