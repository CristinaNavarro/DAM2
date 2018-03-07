package HASH;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.MessageDigest;

public class HacerHASHFichero {
    public static void main(String[] args) {
        try {
            //Instancia del algoritmo MD5
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            //Canales de información
            FileInputStream is = new FileInputStream("C:\\Users\\Cristi\\pruebaEncriptacion\\prueba\\fichero_original.txt");
            FileOutputStream os = new FileOutputStream("C:\\Users\\Cristi\\pruebaEncriptacion\\prueba\\fichero_hash.txt");
            //Buffers
            byte[] buffer = new byte[8];
            int bytes_leidos = is.read(buffer);
            while (bytes_leidos != -1) {
                messageDigest.update(buffer);
                byte[] resumen = messageDigest.digest();
                os.write(resumen);
                bytes_leidos = is.read(buffer);
            }
            is.close();
            os.close();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
