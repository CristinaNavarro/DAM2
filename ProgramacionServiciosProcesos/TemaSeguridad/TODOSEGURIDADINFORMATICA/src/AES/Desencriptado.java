package AES;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Desencriptado {
    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\\\Cristi\\pruebaEncriptacion\\prueba\\claveAES.txt");
            FileInputStream fis = new FileInputStream(file);
            byte[] clave = new byte[(int) file.length()];
            fis.read(clave);
            SecretKey keyspec = new SecretKeySpec(clave, "AES") {
            };
            Cipher desCipher = Cipher.getInstance("AES");
            desCipher.init(Cipher.DECRYPT_MODE, keyspec);
            File inf = new File("C:\\Users\\Cristi\\pruebaEncriptacion\\prueba\\fichero_codificado_AES.txt");
            FileInputStream is = new FileInputStream(inf);
            FileOutputStream os = new FileOutputStream("C:\\Users\\Cristi\\pruebaEncriptacion\\prueba\\fichero_descifrado_AES.txt");
            byte[] buffer = new byte[16];
            int bytes_leidos = is.read(buffer);
            while (bytes_leidos != -1) {
                os.write(desCipher.doFinal(buffer, 0, bytes_leidos));
                bytes_leidos = is.read(buffer);
            }
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
