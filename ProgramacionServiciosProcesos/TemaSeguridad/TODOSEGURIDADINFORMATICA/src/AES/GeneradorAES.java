package AES;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileOutputStream;

public class GeneradorAES {

    public static void main(String[] args) throws Exception{
        String clave = "C:\\Users\\Cristi\\pruebaEncriptacion\\prueba\\claveAES.txt";

        System.out.println("Creo el generador de claves AES");
        KeyGenerator keygen = KeyGenerator.getInstance("AES");
        System.out.println("Genero la clave");
        SecretKey key = keygen.generateKey();
        System.out.println("Obtengo objeto Cipher con cifrado AES");
        Cipher desCipher = Cipher.getInstance("AES");
        System.out.println("Configuro Cipher para encriptar");
        desCipher.init(Cipher.ENCRYPT_MODE, key);
        System.out.println("Obtengo la factoría de claves con cifrado AES");
        System.out.println("Genero keyspec");
        SecretKey keyspec = new SecretKeySpec(key.getEncoded(),"AES");
        System.out.println("Escribo la clave en el fichero clave.txt");
        FileOutputStream cos = new FileOutputStream(clave);
        cos.write(keyspec.getEncoded());
        cos.close();
    }
}
