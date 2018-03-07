package AES;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Base64;

public class CifradoAESConGenerador {
    public static void main(String[] args) {
        String ficheroOriginal = "C:\\Users\\Cristi\\pruebaEncriptacion\\prueba\\fichero_original.txt";
        String ficheroCodificado = "C:\\Users\\Cristi\\pruebaEncriptacion\\prueba\\fichero_codificado_AES.txt";
        String clave = "C:\\Users\\Cristi\\pruebaEncriptacion\\prueba\\claveAES.txt";
        try {
            System.out.println("Creo el generador de claves AES");
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
            System.out.println("Genero la clave");
            SecretKey key = keygen.generateKey();
            System.out.println("Obtengo objeto Cipher con cifrado AES");
            Cipher desCipher = Cipher.getInstance("AES");
            System.out.println("Configuro Cipher para encriptar");
            desCipher.init(Cipher.ENCRYPT_MODE, key);
            System.out.println("Abro fichero_original para extraer la información");
            File inf = new File(ficheroOriginal);
            FileInputStream is = new FileInputStream(inf);
            System.out.println("Abro el fichero_codificado_AES.txt");
            FileOutputStream os = new FileOutputStream(ficheroCodificado);
            System.out.println("Guardo la información cifrada en fichero_codificado_AES.txt");
            byte[] buffer = new byte[8];
            int bytes_leidos = is.read(buffer);
            while (bytes_leidos != -1) {
                os.write(desCipher.doFinal(buffer, 0, bytes_leidos));
                bytes_leidos = is.read(buffer);
            }
            os.close();
            System.out.println("Obtengo la factoría de claves con cifrado AES");
            System.out.println("Genero keyspec");
            SecretKey keyspec = new SecretKeySpec(key.getEncoded(),"AES");
            System.out.println("Escribo la clave en el fichero clave.txt");
            FileOutputStream cos = new FileOutputStream(clave);
            cos.write(keyspec.getEncoded());
            cos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
