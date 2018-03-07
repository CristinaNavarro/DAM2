package DES; /**
 * Asignatura: Programación de Servicios y Procesos
 * Autor: Cristina Navarro
 * Práctica: Seguridad informática
 */

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CifradoDESConGenerador {
    public static void main(String[] args) {
        String ficheroOriginal = "C:\\Users\\Cristi\\pruebaEncriptacion\\prueba\\fichero_original.txt";
        String ficheroCodificado = "C:\\Users\\Cristi\\pruebaEncriptacion\\prueba\\fichero_codificado.txt";
        String clave = "C:\\Users\\Cristi\\pruebaEncriptacion\\prueba\\clave.txt";
        try {
            System.out.println("Creo el generador de claves DES");
            KeyGenerator keygen = KeyGenerator.getInstance("DES");
            System.out.println("Genero la clave");
            SecretKey key = keygen.generateKey();
            System.out.println("Obtengo objeto Cipher con cifrado DES");
            Cipher desCipher = Cipher.getInstance("DES");
            System.out.println("Configuro Cipher para encriptar");
            desCipher.init(Cipher.ENCRYPT_MODE, key);
            System.out.println("Abro fichero_original para extraer la información");
            File inf = new File(ficheroOriginal);
            FileInputStream is = new FileInputStream(inf);
            System.out.println("Abro el fichero_codificado.txt");
            FileOutputStream os = new FileOutputStream(ficheroCodificado);
            System.out.println("Guardo la información cifrada en fichero_codificado.txt");
            byte[] buffer = new byte[8];
            int bytes_leidos = is.read(buffer);
            while (bytes_leidos != -1) {
                os.write(desCipher.doFinal(buffer, 0, bytes_leidos));
                bytes_leidos = is.read(buffer);
            }
            os.close();
            System.out.println("Obtengo la factoría de claves con cifrado DES");
            SecretKeyFactory keyfac = SecretKeyFactory.getInstance("DES");
            System.out.println("Genero keyspec");
            DESKeySpec keyspec = (DESKeySpec) keyfac.getKeySpec(key, DESKeySpec.class);
            System.out.println("Escribo la clave en el fichero clave.txt");
            FileOutputStream cos = new FileOutputStream(clave);
            cos.write(keyspec.getKey());
            cos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
