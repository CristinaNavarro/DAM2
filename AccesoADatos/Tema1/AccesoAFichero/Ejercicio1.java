import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio1 {
    public static void main(String[] args) throws IOException {
        //declarar fichero
        File fichero= new File("C:\\Users\\Cristi\\IdeaProjects\\prueba\\src\\hilosRunnable\\Hilo2.java");
        //crear el flujo de entrada hacia el fichero
        FileReader fic = new FileReader(fichero);
        int i;
        /* Con un tamaño determinado
        char b[]=new char[20];
		while((i=fic.read(b))!=-1) System.out.println(b);

         */
        /*de uno en uno
        while((i=fic.read())!=-1)
            System.out.println((char) i);//se va leyendo un carácter (se lee carácter a carácter)  último vale -1.
        fic.close(); // cierro el fichero
        */
        char b[]=new char[90];
        while((i=fic.read(b))!=-1) System.out.println(b);

    }

}
