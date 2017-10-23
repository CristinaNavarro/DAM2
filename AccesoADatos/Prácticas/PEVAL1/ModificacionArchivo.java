import java.io.*;

/*
********Autor: Cristina Navarro
********Fecha: 23/10/2017
********Asignatura: Acceso a Datos
********Ejercicio:Buscar un archivo en todas las carpetas del ordenador,
********modifica información que este contiene, y crea archivos a partir
********del inicial de otros formatos.
*/

public class ModificacionArchivo {

    //Atributo
    private final String palabraModificar;
    private final String palabraNueva;

    //Constructor
    ModificacionArchivo(String palabraModificar, String palabraNueva){
        this.palabraModificar = palabraModificar;
        this.palabraNueva = palabraNueva;
    }

    //Métodos
    //Busca la palabra introducida en el main() y la sustituye por otra también introducida
    public void modificarArchivo(String path){
        File fOriginal = new File(path,"contabilidad.txt");
        File fCopia = new File(path,"contabilidad.temp.txt");
        String linea;
        String[] lineaProcesada;
        try {
            BufferedReader brOriginal = new BufferedReader(new FileReader(fOriginal));
            BufferedWriter brCopia = new BufferedWriter(new FileWriter(fCopia));
            while ((linea = brOriginal.readLine()) != null) {
                lineaProcesada = linea.split(" ");
                brCopia.write(lineaProcesada[0] + " ");

                if(lineaProcesada[1].equalsIgnoreCase(palabraModificar)){

                    brCopia.write(palabraNueva);
                }else{
                    brCopia.write(lineaProcesada[1]);
                }
                brCopia.write(" " + lineaProcesada[2]+ " ");
                brCopia.write(lineaProcesada[3]);
                brCopia.newLine();
            }
            brCopia.close();
            brOriginal.close();
            fOriginal.delete();
            fCopia.renameTo(new File(path,"contabilidad.txt"));
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
