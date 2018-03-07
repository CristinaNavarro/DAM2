package DES;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.FileOutputStream;

public class GeneradorDES {
    public static void main(String[] args) throws Exception{
        String clave = "C:\\Users\\Cristi\\pruebaEncriptacion\\prueba\\claveDES.txt";

        System.out.println("Creo el generador de claves DES");
        KeyGenerator keygen = KeyGenerator.getInstance("DES");
        System.out.println("Genero la clave");
        SecretKey key = keygen.generateKey();
        System.out.println("Obtengo objeto Cipher con cifrado DES");
        Cipher desCipher = Cipher.getInstance("DES");
        System.out.println("Configuro Cipher para encriptar");
        desCipher.init(Cipher.ENCRYPT_MODE, key);
        System.out.println("Obtengo la factoría de claves con cifrado DES");
        SecretKeyFactory keyfac = SecretKeyFactory.getInstance("DES");
        System.out.println("Genero keyspec");
        DESKeySpec keyspec = (DESKeySpec) keyfac.getKeySpec(key, DESKeySpec.class);
        System.out.println("Escribo la clave en el fichero clave.txt");
        FileOutputStream cos = new FileOutputStream(clave);
        cos.write(keyspec.getKey());
        cos.close();
    }
}
