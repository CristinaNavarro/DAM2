import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Encriptado {
    public static void main(String[] args) {
        try {
            System.out.println("Obteniendo generador de claves con cifrado DES");
            KeyGenerator keygen = KeyGenerator.getInstance("DES");
            System.out.println("Generando clave");
            SecretKey key = keygen.generateKey();
            System.out.println("Obteniendo objeto Cipher con cifrado DES");
            Cipher desCipher = Cipher.getInstance("DES");
            System.out.println("Configurando Cipher para encriptar");
            desCipher.init(Cipher.ENCRYPT_MODE, key);
            System.out.println("Abriendo el fichero");
            File inf = new File("C:\\Users\\Cristi\\pruebaEncriptacion\\fichero_prueba.txt");
            FileInputStream is = new FileInputStream(inf);
            System.out.println("Abriendo el fichero cifrado");
            FileOutputStream os = new FileOutputStream("C:\\Users\\Cristi\\pruebaEncriptacion\\fichero_cifrado_DES2.txt");
            System.out.println("Cifrando el fichero...");
            byte[] buffer = new byte[8];
            int bytes_leidos = is.read(buffer);
            while (bytes_leidos != -1) {
                os.write(desCipher.doFinal(buffer, 0, bytes_leidos));
                bytes_leidos = is.read(buffer);
            }
            os.close();
            System.out.println("Obteniendo factor�a de claves con cifrado DES");
            SecretKeyFactory keyfac = SecretKeyFactory.getInstance("DES");
            System.out.println("Generando keyspec");
            DESKeySpec keyspec = (DESKeySpec) keyfac.getKeySpec(key, DESKeySpec.class);
            System.out.println("Salvando la clave en un fichero");
            FileOutputStream cos = new FileOutputStream("C:\\Users\\Cristi\\pruebaEncriptacion\\clave_DES2.txt");
            cos.write(keyspec.getKey());
            cos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
