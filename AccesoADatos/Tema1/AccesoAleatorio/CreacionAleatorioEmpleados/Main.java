import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {
    public static void main(String[] args) throws IOException {
        File f = new File("C:\\Users\\Cristi\\Desktop\\A\\EmpleadosAleatorio.dat");
        RandomAccessFile raf = new RandomAccessFile(f,"rw");
        String[] nombre = {"Navarro","Soto","RRHH"};
        int[] lugar = {2000, 1500,2500};
        StringBuffer sbApellido;


       //////////Creación del fichero//////////////////////////////
       /*for(int i=0;i<nombre.length;i++){
            raf.writeInt(i+1);
            sbApellido = new StringBuffer(nombre[i]);
            sbApellido.setLength(10);
            raf.writeChars(sbApellido.toString());
            raf.writeInt(lugar[i]);
            raf.writeInt(0);
            //raf.writeBytes(System.getProperty("line.separator"));
        ////////////////////////////////////////////////////////////
        }*/

        //lectura de fichero ///////////////////////////////
        try {
            raf.seek(0);
            for (int i = 0; i < f.length() / 32; i++) {
                char[] apellidos = new char[10];
                System.out.print(raf.readInt());
                for (int j = 0; j < 10; j++) {
                    apellidos[j] = raf.readChar();
                    System.out.print(apellidos[j]);
                }
                System.out.print(raf.readInt() + " ");
                System.out.println(raf.readInt());
                System.out.println();
            }
        }catch (EOFException e){
            System.out.println("Saliendo");
        }
        ///////////////////////////////////////////////////
        raf.close();
    }
}
