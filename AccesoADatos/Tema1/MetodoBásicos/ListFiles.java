package EjerciciosTema1;/*
⦁	Realiza un programa Java que utilice el método listFiles()
 para mostrar la lista de ficheros en un directorio cualquiera,
  o en el directorio actual.
 */


import java.io.File;
import java.util.Scanner;

public class ListFiles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el directorio");
        String dir=sc.nextLine();
        File f = new File(dir);
        File[] listaFiles =  f.listFiles();
        for(int i=0;i<listaFiles.length;i++){
            if(listaFiles[i].isDirectory()) {
                System.out.println(listaFiles[i].getName());
            }
        }
    }
}
