import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/*
********Autor: Cristina Navarro*********************
********Fecha: 11/10/2017***************************
********Asignatura:Acceso a Datos ******************
********Ejercicio:	 Visualización datos de fichero*
*********  con acceso aleatorio*********************
*/
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        File f = new File("C:\\Users\\Cristi\\Desktop\\A\\DepartamentoAleatorio.dat");
        RandomAccessFile raf = new RandomAccessFile(f,"r");
        System.out.println("Introduce el fichero a visualizar");
        int posFinal = sc.nextInt()*44;
        int posicion;
        System.out.println(posFinal);
        if(posFinal<44){
            posicion = 0;
        }else{
            posicion = (sc.nextInt()*44)-44;
        }
        raf.seek(posicion);
        System.out.println(posicion);
        System.out.println(raf.readInt());
        for(int i=posicion;i<(posicion+44);i++){
           raf.seek(i);
           System.out.print(raf.readChar());
        }
    }
}
